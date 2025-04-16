package Control;

import ADT.*;
import Boundary.ReportUI;
import Dao.Database;
import Entity.*;
import Utility.Input;
import Utility.MessageUI;
import Utility.Tools;
import static Utility.Tools.GREEN;
import static Utility.Tools.RED;
import static Utility.Tools.RESET;

/**
 *
 * @author All
 * Explanations
 * 1. Employer Module
 * 2. Application Module
 * 3. Matching Engine Module
 *      - Applicant Matching Report
 *      - Top Matched Applicants Report
 *      - Matching Engine Efficiency Report
 * 4. Interview with Schedule Module
 * 5. Searching Module
 *      - Applicant Search Trends
 *      - Search Module Performance Report
 * 
 */
public class ReportManager {
    
    private static final ListInterface<String> searching = new DoublyLinkedList<>();
    
    // Call Report Management function
    public static void reportMenu(){
        int input;
        do{
            UserManager.profileHeadLine();
            input = ReportUI.reportUI();
            
            switch (input){
                case 1 -> System.out.println("Job Report");
                case 2 -> System.out.println("Application Report");
                case 3 -> matchingReportManagement();
                case 4 -> System.out.println("Interview Report");
                case 5 -> searchingReportManagement();
                case 6 -> Tools.back();
                default -> MessageUI.errorMessage();
            }
            
        }while(input != 6);
    }
    
    // Matching Engine Module Report
    private static void matchingReportManagement(){
        int input;
        do{
            UserManager.profileHeadLine();
            input = ReportUI.matchingReport();
           
            switch (input){
                case 1 -> applicationMatchingReport();
                case 2 -> topMatchedReport();
                case 3 -> matchingEngineEfficiencyReport();
                case 4 -> Tools.back();
                default -> MessageUI.errorMessage();
            }
        }while(input != 4);
    }
    
    // 1. Applicant Matching Report
    // Total applicants matched, match distribution, match accuracy and unmatched applicants
    private static void applicationMatchingReport(){
        
        String description = """
                             This report provides an overview of applicant-job matching results, highlighting the top-matched applicant 
                             for each job. It includes total matched applicants, match distribution, match accuracy, and a list of 
                             unmatched applicants.""";
        
        UserManager.profileHeadLine();
        ReportUI.reportHeader("Application Matching Report");
        ReportUI.descriptionLine(description);
        generateMatchingReport();
        Tools.systemPause("Press Enter to Continue...");
    }
    
    private static <T> void generateMatchingReport() {
        if (Database.getEmployer() != null) {
            // EMPLOYER VIEW
            Employer employer = Database.getEmployer();
            T object = getObject("Applicant");
            int totalMatchedApplicants = 0;
            ListInterface<String> x_axis = new DoublyLinkedList<>();
            ListInterface<Integer> y_axis = new DoublyLinkedList<>();

            if (!employer.getJob().isEmpty()) {
                for (Job job : employer.getJob()) {

                    ListInterface<Applicant> applicantMatchList = new DoublyLinkedList<>();
                    int matchCount = 0;

                    // Collect applicants who applied for this job
                    for (JobApplication jobApplication : job.getJobApplication()) {
                        Applicant applicant = jobApplication.getApplicant();
                        System.out.println(job);
                        int score = MatchingEngine.getScore(applicant, job);
                        if(score > 0){
                            applicantMatchList.add(applicant);
                            matchCount++;
                        }
                    }
                    
                    if(matchCount > 0){
                        x_axis.add(job.getJobTitle());
                        y_axis.add(matchCount);
                    }

                    if (!applicantMatchList.isEmpty()) {
                        ListInterface<Applicant> sortedList = MatchingEngine.heapSort(applicantMatchList, object);

                        // Print report header
                        System.out.println("\n=====================================================================================================================");
                        System.out.printf("| %-14s | %-24s | %-30s | %-13s | %-19s |\n",
                                "JobID", "Job Title", "Applicant Name", "Match Score", "Interview Status");
                        System.out.println("=====================================================================================================================");
                        
                        // Print top 5 applicants
                        for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
                            Applicant applicant = sortedList.get(i);
                            String jobID = job.getJobID();
                            String jobTitle = job.getJobTitle();
                            String applicantName = applicant.getName();
                            int score = MatchingEngine.getScore(applicant, job);
                            String interviewStatus = getInterviewStatus(employer, applicant, job);
                            
                            totalMatchedApplicants++;

                            System.out.printf("| %-14s | %-24s | %-30s | %-13d | %-19s |\n",
                                    jobID, jobTitle, applicantName, score, interviewStatus);
                            System.out.println("---------------------------------------------------------------------------------------------------------------------");
                        }
                    } else {
                        MessageUI.noApplicant(job.getJobID(), job.getJobTitle());
                    }
                }

                // Summary
                System.out.println("\n======================================================================");
                System.out.println("                            Summary:                                    ");
                System.out.println("======================================================================");
                System.out.println("                   Total Jobs Posted         : " + employer.getJob().size());
                System.out.println("                   Total Matched Applicants  : " + totalMatchedApplicants);
                System.out.println("======================================================================");
                
                if(!x_axis.isEmpty() && !y_axis.isEmpty()){
                    verticalBarChart(x_axis, y_axis, "Total Matched Applicants for Each Job");
                }
                
            } else {
                MessageUI.noMatchFound();
            }

        } else {
            // APPLICANT VIEW
            Applicant applicant = Database.getApplicant();
            T object = getObject("Job");

            if (!applicant.getJobApplication().isEmpty()) {
                ListInterface<Job> jobMatchList = new DoublyLinkedList<>();
                ListInterface<Integer> scoreList = new DoublyLinkedList<>(); // NEW: to store scores
                ListInterface<String> x_axis = new DoublyLinkedList<>();
                ListInterface<Integer> y_axis = new DoublyLinkedList<>();

                for (JobApplication jobApplication : applicant.getJobApplication()) {
                    jobMatchList.add(jobApplication.getJob());
                }

                // Step 1: compute and store scores
                for (int i = 0; i < jobMatchList.size(); i++) {
                    Job job = jobMatchList.get(i);
                    int score = MatchingEngine.getScore(job, applicant);
                    scoreList.add(score); // parallel to jobMatchList
                }

                // Step 2: Sort jobs based on scores
                ListInterface<Job> sortedList = MatchingEngine.heapSort(jobMatchList, object); // assuming this uses compare() or compareTo()

                // Step 3: Create sortedScoreList based on sorted job order
                ListInterface<Integer> sortedScoreList = new DoublyLinkedList<>();
                for (int i = 0; i < sortedList.size(); i++) {
                    Job sortedJob = sortedList.get(i);

                    // Find original index in jobMatchList
                    for (int j = 0; j < jobMatchList.size(); j++) {
                        if (sortedJob == jobMatchList.get(j)) { // compare by object reference
                            sortedScoreList.add(scoreList.get(j));
                            break;
                        }
                    }
                }

                // Print report header
                System.out.println("\n==========================================================================================================================");
                System.out.printf("| %-14s | %-20s | %-20s | %-15s | %-16s | %-15s |\n",
                        "JobID", "Job Title", "Company Name", "Job Type", "Location", "Match Score");
                System.out.println("==========================================================================================================================");

                if (!sortedList.isEmpty()) {
                    for (int i = 0; i < sortedList.size(); i++) {
                        Job job = sortedList.get(i);
                        int score = sortedScoreList.get(i); // ✅ use stored score

                        String jobID = job.getJobID();
                        String jobTitle = job.getJobTitle();
                        String companyName = job.getEmployer().getCompany().getCompanyName();
                        String jobType = job.getJobType();
                        String location = job.getEmployer().getCompany().getLocation();

                        System.out.printf("| %-14s | %-20s | %-20s | %-15s | %-16s | %-15d |\n",
                                jobID, jobTitle, companyName, jobType, location, score);

                        // Add to chart if score > 0
                        if (score > 0) {
                            x_axis.add(jobTitle.length() > 6 ? jobTitle.substring(0, 6) : jobTitle);
                            y_axis.add(score);
                        }
                    }

                    System.out.println("==========================================================================================================================\n\n");

                    // Display bar chart
                    if (!x_axis.isEmpty()) {
                        verticalBarChart(x_axis, y_axis, "Match Scores by Job");
                    }

                } else {
                    MessageUI.noMatchFound();
                }

                // Summary
                System.out.println("\n--------------------------------------------------");
                System.out.println("Summary:");
                System.out.println("Total Applications Submitted : " + applicant.getJobApplication().size());
                System.out.println("Jobs Matched                 : " + sortedList.size());
                System.out.println("--------------------------------------------------\n");

            } else {
                MessageUI.noMatchFound();
            }
        }
        printReport();
    }

    // 2. Top Matched Applicants Report
    // Highest Match Score per applicant
    
    private static void topMatchedReport(){
        String description = """
                             This report provides an overview of the top matched job to each of the applicant. It includes the total matched
                             jobs and match accuracy.
                             """;
        ReportUI.reportHeader("Matching");
        ReportUI.descriptionLine(description);
        generateTopMatchedReport();
        Tools.systemPause("Press Enter to Continue...");
    }
    
    private static <T> void generateTopMatchedReport() {
        if (UserManager.isEmployer()) {
            MessageUI.restrictView();
        } else {
            Applicant applicant = Database.getApplicant();
            ListInterface<Job> jobList = Database.jobList;
            T object = getObject("Job");

            if (jobList.isEmpty()) {
                MessageUI.emptyDatabase();
                return;
            }

            ListInterface<Job> sortedList = MatchingEngine.heapSort(jobList, object);

            System.out.println("Matching Result for: " + applicant.getName());

            // Lists to hold job titles and match scores for graphing
            ListInterface<String> x_axis = new DoublyLinkedList<>();
            ListInterface<Integer> y_axis = new DoublyLinkedList<>();

            if (!sortedList.isEmpty()) {
                for (int i = 0; i < sortedList.size(); i++) {
                    Job job = sortedList.get(i);
                    int score = MatchingEngine.getScore(job, applicant);

                    // Display match information
                    System.out.println("  - " + job.getJobTitle() + " (Score: " + score + ")");

                    // Add to graph data if score > 0
                    if (score > 0) {
                        x_axis.add(job.getJobTitle().length() > 6 ? job.getJobTitle().substring(0, 6) : job.getJobTitle()); // Truncate job title for chart
                        y_axis.add(score);
                    }
                }

                // Display the bar chart if there are any valid jobs with a score > 0
                if (!x_axis.isEmpty()) {
                    verticalBarChart(x_axis, y_axis, "Top Matched Jobs for " + applicant.getName());
                }
            } else {
                MessageUI.noMatchFound();
            }

            System.out.println(); // End of report
        }
    }

    // 3. Matching Engine Efficiency Report
    // Successful matches and time taken for matching
    private static void matchingEngineEfficiencyReport() {
        String description = """
                             This report provides an overview of the successful matches and time taken for matching. This allows user to
                             examine the time taken of the matching algorithm and determine whether the system is efficiency.
                             """;
        ReportUI.reportHeader("Matching Engine Efficiency Report");
        ReportUI.descriptionLine(description);
        generateMatchingEngineEfficiencyReport();
        Tools.systemPause();
    }
    
    private static void generateMatchingEngineEfficiencyReport(){
        long startTime = System.nanoTime(); // Start time

        int successfulMatches = 0;

        if (Database.getEmployer() != null) {
            Employer employer = Database.getEmployer();
            ListInterface<Job> jobMatchList = new DoublyLinkedList<>();
            Object object = getObject("Applicant");

            if (!employer.getJob().isEmpty()) {
                for (Job job : employer.getJob()) {
                    jobMatchList.add(job);
                    ListInterface<Applicant> applicantMatchList = new DoublyLinkedList<>();

                    // Collect applicants who applied for this job
                    for (JobApplication jobApplication : job.getJobApplication()) {
                        applicantMatchList.add(jobApplication.getApplicant());
                    }

                    // Sort applicants based on matching score
                    ListInterface<Applicant> sortedList = MatchingEngine.heapSort(applicantMatchList, object);

                    if (!sortedList.isEmpty()) {
                        successfulMatches += sortedList.size(); 
                    }
                }
            }
        } else {
            Applicant applicant = Database.getApplicant();
            ListInterface<JobApplication> applicationMatchList = new DoublyLinkedList<>();
            Object object = getObject("Job");

            if (!applicant.getJobApplication().isEmpty()) {
                for (JobApplication jobApplication : applicant.getJobApplication()) {
                    applicationMatchList.add(jobApplication);
                }

                // Sort jobs based on matching score
                ListInterface<JobApplication> sortedList = MatchingEngine.heapSort(applicationMatchList, object);

                if (!sortedList.isEmpty()) {
                    successfulMatches += sortedList.size(); // Count matched jobs
                }
            }
        }

        long endTime = System.nanoTime(); // End time
        double timeTakenMs = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds

        // Display the report
        System.out.println("========== Matching Engine Efficiency Report ==========");
        System.out.println("Total Successful Matches: " + successfulMatches);
        System.out.println("Time Taken for Matching: " + timeTakenMs + " ms");
        System.out.println("======================================================");
        
        printReport();
    }

    // ==================================Searching Module Report===========================================
    private static void searchingReportManagement(){
        int input;
        do{
            UserManager.profileHeadLine();
            input = ReportUI.searchingReport();
           
            switch (input){
                case 1 -> searchPerformanceManagement();
                case 2 -> searchHistoryReport();
                case 3 -> Tools.back();
                default -> MessageUI.errorMessage();
            }
        }while(input != 3);
    }
    
    // 1. Search Module Performance Report
    // How often the top search results are relevant
    private static void searchPerformanceManagement(){
        UserManager.profileHeadLine();
        String description = """
                             This report is 
                                   """;
        ReportUI.reportHeader("Searching");
        ReportUI.descriptionLine(description);
        searchPerformanceReport();
        Tools.systemPause("Press Enter to Continue...");
    }
    
    private static void searchPerformanceReport() {
        ListInterface<Job> jobList = Database.jobList;
        ListInterface<Job> results = new DoublyLinkedList<>();

        String input = Input.getStringInput("Search a job: ");
        int falseStep = 10;

        for (int i = 0; i < jobList.size(); i++) {
            Job job = jobList.get(i);
            if (searching.search(job.getJobTitle().toLowerCase(), input) || searching.fuzzyMatching(job.getJobTitle().toLowerCase(), input) <= falseStep) {
                results.add(job);
                results = MatchingEngine.heapSort(results, job);
            }
        }

        // List for graphing purposes
        ListInterface<String> x_axis = new DoublyLinkedList<>();
        ListInterface<Integer> y_axis = new DoublyLinkedList<>();

        int topRelevantResults = 0;
        String[] parts = input.replace(",", "").split(" ");

        // Calculate relevance and prepare graph data
        for (int i = 0; i < Math.min(5, results.size()); i++) {
            Job job = results.get(i);
            int matchCount = 0;

            for (String part : parts) {
                if (job.getJobTitle().contains(part)) {
                    matchCount++;
                }
            }

            // Only consider jobs with some relevance
            if (matchCount > 0) {
                x_axis.add(job.getJobTitle().length() > 6 ? job.getJobTitle().substring(0, 6) : job.getJobTitle());
                y_axis.add(matchCount);
                topRelevantResults++;
            }
        }

        // Calculate the relevance score
        double relevanceScore = (double) topRelevantResults / Math.min(5, results.size()) * 100;
        System.out.println("Search Relevance Score: " + relevanceScore + "%");

        // Display the bar chart if there are relevant results
        if (!x_axis.isEmpty()) {
            verticalBarChart(x_axis, y_axis, "Search Results Relevance for: " + input);
        } else {
            System.out.println("No relevant jobs found.");
        }
    }
    
    // 2. Search Trend Report
    // Show the frequency of search terms or job titles from the search history
    
    private static void searchHistoryReport() {
        ListInterface<String> searchHistory = Database.searchHistory; 

        if (searchHistory.isEmpty()) {
            System.out.println("No search history available.");
            return;
        }

        // Create a simple map to count occurrences of each search term
        ListInterface<String> searchTerms = new DoublyLinkedList<>();
        ListInterface<Integer> searchCounts = new DoublyLinkedList<>();

        // Iterate over the search history and count occurrences of each search term
        for (String searchTerm : searchHistory) {
            if (searchTerms.contains(searchTerm)) {
                int index = searchTerms.indexOf(searchTerm);
                searchCounts.set(index, searchCounts.get(index) + 1);
            } else {
                searchTerms.add(searchTerm);
                searchCounts.add(1);
            }
        }

        // Print the table header
        System.out.println("\n============================== Search History ==============================");
        System.out.printf("| %-15s | %-10s | %-15s |\n", "Search Term", "Count", "Date/Time");
        System.out.println("===========================================================================");

        // Assuming you want to print the date/time in a placeholder form for now
        for (int i = 0; i < searchTerms.size(); i++) {
            String searchTerm = searchTerms.get(i);
            int count = searchCounts.get(i);
            String timestamp = "2025-04-16 12:00"; // Replace this with actual timestamp if needed

            System.out.printf("| %-15s | %-10d | %-15s |\n", searchTerm, count, timestamp);
        }

        System.out.println("===========================================================================");
        
        System.out.println("\n");
        searchHistoryDistributionGraph();
    }

    private static void searchHistoryDistributionGraph() {
        ListInterface<String> searchHistory = Database.searchHistory; // Assuming this is your search history list

        if (searchHistory.isEmpty()) {
            System.out.println("No search history available.");
            return;
        }

        // Create a simple map to count occurrences of each search term
        ListInterface<String> searchTerms = new DoublyLinkedList<>();
        ListInterface<Integer> searchCounts = new DoublyLinkedList<>();

        for (String searchTerm : searchHistory) {
            if (searchTerms.contains(searchTerm)) {
                int index = searchTerms.indexOf(searchTerm);
                searchCounts.set(index, searchCounts.get(index) + 1);
            } else {
                searchTerms.add(searchTerm);
                searchCounts.add(1);
            }
        }

        // Prepare the data for the bar chart
        verticalBarChart(searchTerms, searchCounts, "Search History Distribution");
    }


    // Helper function
    private static <T> T getObject(String title) {
        switch (title) {
            case "Job" -> {
                return (T) new Job();  
            }
            case "Employer" -> {
                return (T) new Employer();
            }
            case "Applicant" -> {
                return (T) new Applicant(); 
            }
            default -> {
                MessageUI.invalidTitle();
                return null;
            }
        }
    }
    
    private static String getInterviewStatus(Employer employer, Applicant applicant, Job job) {
        for (Schedule schedule : employer.getSchedule()) {
            if (schedule.getApplicant().equals(applicant) && schedule.getEmployer().getJob().equals(job)) {
                return schedule.getStatus();
            }
        }
        return "Not Scheduled";
    }
    
    private static void printReport() {
        String yesNo = ReportUI.printingReport();
        if (yesNo.equalsIgnoreCase("y") || yesNo.equalsIgnoreCase("yes")) {
            try {
                System.out.println("Prepare to print...");
                for (int i = 0; i <= 100; i += 20) {
                    StringBuilder line = new StringBuilder("Printing > ");

                    int totalLength = 30; // total length of dashes + percent
                    int percentPosition;

                    percentPosition = switch (i) {
                        case 0 -> 0;
                        case 100 -> totalLength - 5;
                        default -> (totalLength * i) / 100 - 2;
                    };

                    for (int j = 0; j < totalLength; j++) {
                        if (j == percentPosition) {
                            line.append(String.format("%3d%%", i));
                            j += 3;
                        } else {
                            line.append("-");
                        }
                    }

                    if (i < 100) {
                        System.out.println(RED + line.toString() + RESET);
                    } else {
                        System.out.println(GREEN + line.toString() + RESET);
                    }

                    Thread.sleep(1000);
                }
                System.out.println("Print out.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public static void verticalBarChart(ListInterface<String> x_axis, ListInterface<Integer> y_axis, String title) {
        int max = 0;
        for (int i = 0; i < y_axis.size(); i++) {
            max = Math.max(max, y_axis.get(i));
        }

        String[] colors = {
            Tools.REDBG,
            Tools.GREENBG,
            Tools.YELLOWBG,
            Tools.BLUEBG,
            Tools.PURPLEBG,
            Tools.CYANBG
        };

        System.out.println("\n              " + title);
        System.out.println();

        for (int i = max; i > 0; i--) {
            System.out.print("            ");
            for (int j = 0; j < y_axis.size(); j++) {
                if (y_axis.get(j) >= i) {
                    String color = colors[j % colors.length]; 
                    System.out.print("  " + color + "   " + RESET);
                } else {
                    System.out.print("       ");
                }
            }
            System.out.println();
        }

        // Draw x-axis
        System.out.print("            ");
        for (int i = 0; i < y_axis.size(); i++) {
            System.out.print("-------");
        }
        System.out.println();

        // Print x-axis labels
        System.out.print("            ");
        for (int i = 0; i < x_axis.size(); i++) {
            String label = x_axis.get(i);
            System.out.printf(" %-5s", label.length() > 5 ? label.substring(0, 5) : label);
        }
        System.out.println("\n");
    }


}
