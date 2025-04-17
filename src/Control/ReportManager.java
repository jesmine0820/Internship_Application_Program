package Control;

import ADT.ListInterface;
import ADT.DoublyLinkedList;
import Boundary.ReportUI;
import Boundary.UserUI;
import Dao.Database;
import Entity.Applicant;
import Entity.Company;
import Entity.Employer;
import Entity.Job;
import Entity.JobApplication;
import Entity.Schedule;
import Utility.Input;
import Utility.MessageUI;
import Utility.Tools;
import static Utility.Tools.GREEN;
import static Utility.Tools.RED;
import static Utility.Tools.RESET;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author All
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
    
    // ==================================Employer Module Report===========================================
    
    public static void highestJobAppliedReport() {
        Tools.clearScreen();
        UserUI.headLine();

        Employer currentEmployer = Database.getEmployer();
        Company currentEmployerCompany = currentEmployer.getCompany();

        ListInterface<Job> companyJobs = new DoublyLinkedList<>();
        for (Job job : Database.jobList) {
            if (job.getEmployer().getCompany().equals(currentEmployerCompany)) {
                companyJobs.add(job);
            }
        }

        System.out.println("================================================================================");
        System.out.println("                    JOB APPLICATION MANAGEMENT SYSTEM");
        System.out.println("                       HIGHEST JOB APPLIED REPORT");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Generated at: " + java.time.LocalDateTime.now());
        System.out.println("********************************************************************************");
        System.out.println("Company: " + currentEmployer.getCompany().getCompanyName());
        System.out.println("Employer: " + currentEmployer.getName());
        System.out.println();

        ListInterface<Job> jobList = new DoublyLinkedList<>();
        ListInterface<Integer> applicationCounts = new DoublyLinkedList<>();

        int totalJobsOffered = 0;
        int totalApplications = 0;

        for (Job job : Database.jobList) {
            if (job.getEmployer().equals(currentEmployer)) {
                totalJobsOffered++;
                int apps = job.getJobApplication().size();
                totalApplications += apps;

                jobList.add(job);
                applicationCounts.add(apps);
            }
        }

        if (totalJobsOffered == 0) {
            System.out.println(Tools.RED + "No jobs found for the employer." + Tools.RESET);
            return;
        }

        Job mostAppliedJob = null;
        Job leastAppliedJob = null;
        int maxApplications = 0;
        int minApplications = Integer.MAX_VALUE;

        for (int i = 0; i < jobList.size(); i++) {
            Job job = jobList.get(i);
            int apps = applicationCounts.get(i);

            if (apps > maxApplications) {
                maxApplications = apps;
                mostAppliedJob = job;
            }
            if (apps < minApplications) {
                minApplications = apps;
                leastAppliedJob = job;
            }
        }

        System.out.println("Total Jobs Offered by Employer : " + totalJobsOffered);
        System.out.println("================================================================================");
        System.out.println("No. | Job ID  | Job Title                                 | Number of Applicant");
        System.out.println("================================================================================");

        for (int i = 0; i < jobList.size(); i++) {
            Job job = jobList.get(i);
            int apps = applicationCounts.get(i);
            System.out.printf("%-3d | %-7s | %-40s | %-20d%n", i + 1, job.getJobID(), job.getJobTitle(), apps);
            System.out.println("--------------------------------------------------------------------------------");
        }

        System.out.println("Total                                                    | " + totalApplications);
        System.out.println("================================================================================");

        System.out.println();
        System.out.println("Most Applied Job:");
        System.out.println("--------------------------------------------------------------------------------");
        if (mostAppliedJob != null) {
            System.out.println("Job ID          : " + mostAppliedJob.getJobID());
            System.out.println("Job Title       : " + mostAppliedJob.getJobTitle());
            System.out.println("Job Type        : " + mostAppliedJob.getJobType());
            System.out.println("Employment Type : " + mostAppliedJob.getEmploymentType());
            System.out.println("Work Mode       : " + mostAppliedJob.getWorkMode());
            System.out.println("Applications    : " + maxApplications);
        }

        System.out.println();
        System.out.println("Total Job Applications Received: " + totalApplications);
        System.out.println("********************************************************************************");

        System.out.println("Job Application Bar Chart:");
        System.out.println("(Each colored block = 1 application)");
        System.out.println("--------------------------------------------------------------------------------");

        ListInterface<String> jobIDs = new DoublyLinkedList<>();
        for (int i = 0; i < jobList.size(); i++) {
            jobIDs.add(jobList.get(i).getJobID());
        }
        verticalBarChart(jobIDs, applicationCounts, "Job Applications by Job ID");

        System.out.println("********************************************************************************");
        System.out.println("Programmes with the most applications (" + maxApplications + "):");
        System.out.println("* " + mostAppliedJob.getJobID() + " - " + mostAppliedJob.getJobTitle());

        System.out.println();
        System.out.println("Programmes with the least applications (" + minApplications + "):");
        System.out.println("* " + leastAppliedJob.getJobID() + " - " + leastAppliedJob.getJobTitle());

        System.out.println("********************************************************************************");
        System.out.println("                                 END OF THE REPORT");
        System.out.println("********************************************************************************");
    }

    public static void JobApplied() {
        Tools.clearScreen();
        UserUI.headLine();

        Employer currentEmployer = Database.getEmployer();
        Company currentEmployerCompany = currentEmployer.getCompany();

        ListInterface<Employer> employerList = new DoublyLinkedList<>();
        ListInterface<Integer> applicationCountList = new DoublyLinkedList<>();

        int totalJobsOffered = 0;
        int totalApplications = 0;

        for (Job job : Database.jobList) {
            if (job.getEmployer().getCompany().equals(currentEmployerCompany)) {
                totalJobsOffered++;
                int apps = job.getJobApplication().size();
                totalApplications += apps;

                Employer employer = job.getEmployer();
                boolean found = false;
                for (int i = 0; i < employerList.size(); i++) {
                    if (employerList.get(i).equals(employer)) {
                        applicationCountList.set(i, applicationCountList.get(i) + apps);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    employerList.add(employer);
                    applicationCountList.add(apps);
                }
            }
        }

        if (totalJobsOffered == 0) {
            System.out.println(Tools.RED + "No jobs found for the company." + Tools.RESET);
            return;
        }

        System.out.println("================================================================================");
        System.out.println("                    JOB APPLICATION MANAGEMENT SYSTEM");
        System.out.println("                  JOB APPLICATIONS OVERVIEW FOR EMPLOYERS IN " + currentEmployer.getCompany().getCompanyName());
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Generated at: " + java.time.LocalDateTime.now());
        System.out.println("********************************************************************************");
        System.out.println("Company: " + currentEmployer.getCompany().getCompanyName());
        System.out.println();

        System.out.println("Total Jobs Offered by All Employers in the Company: " + totalJobsOffered);
        System.out.println("=====================================================================================================");
        System.out.println("No. | Job ID  | Job Title                                | Employer             | Number of Applicants");
        System.out.println("=====================================================================================================");

        int index = 1;
        for (Job job : Database.jobList) {
            if (job.getEmployer().getCompany().equals(currentEmployerCompany)) {
                System.out.printf("%-3d | %-7s | %-40s | %-20s | %-20d%n", index++, job.getJobID(), job.getJobTitle(), job.getEmployer().getName(), job.getJobApplication().size());
                System.out.println("----------------------------------------------------------------------------------------------------");
            }
        }

        System.out.println("Total                                                    |                      | " + totalApplications);
        System.out.println("=====================================================================================================");

        System.out.println();
        System.out.println("Job Application Bar Chart:");
        System.out.println("(Each colored block = 1 application)");
        System.out.println("--------------------------------------------------------------------------------");

        ListInterface<String> employerNames = new DoublyLinkedList<>();
        for (int i = 0; i < employerList.size(); i++) {
            employerNames.add(employerList.get(i).getName());
        }

        verticalBarChart(employerNames, applicationCountList, "Total Applications per Employer");

        System.out.println("********************************************************************************");
        System.out.println("Total Job Applications Received: " + totalApplications);
        System.out.println("********************************************************************************");
        System.out.println("                                 END OF THE REPORT");
        System.out.println("********************************************************************************");
    }
    
    // ==================================Applicant Module Report===========================================
    
    // ==================================Matching Engine Module Report===========================================
    
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
    
    // Helper function to generate the applicang matching report
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
                ListInterface<Job> sortedList = MatchingEngine.heapSort(jobMatchList, object); 

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
    
    // Helper function to generate the top matched job report
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

            ListInterface<String> x_axis = new DoublyLinkedList<>();
            ListInterface<Integer> y_axis = new DoublyLinkedList<>();

            int highest = Integer.MIN_VALUE;
            int lowest = Integer.MAX_VALUE;

            ListInterface<Job> highestMatchedJobs = new DoublyLinkedList<>();
            ListInterface<Job> lowestMatchedJobs = new DoublyLinkedList<>();

            if (!sortedList.isEmpty()) {
                for (int i = 0; i < sortedList.size(); i++) {
                    Job job = sortedList.get(i);
                    int score = MatchingEngine.getScore(job, applicant);

                    System.out.println("  - " + job.getJobTitle() + " (Score: " + score + ")");

                    // Add to chart only if score > 0
                    if (score > 0) {
                        x_axis.add(job.getJobTitle().length() > 6 ? job.getJobTitle().substring(0, 6) : job.getJobTitle());
                        y_axis.add(score);
                    }

                    // Track highest match
                    if (score > highest) {
                        highest = score;
                        highestMatchedJobs.clear();
                        highestMatchedJobs.add(job);
                    } else if (score == highest) {
                        highestMatchedJobs.add(job);
                    }

                    // Track lowest match (excluding zero scores if needed)
                    if (score < lowest && score > 0) {
                        lowest = score;
                        lowestMatchedJobs.clear();
                        lowestMatchedJobs.add(job);
                    } else if (score == lowest && score > 0) {
                        lowestMatchedJobs.add(job);
                    }
                }

                // Show most and least matched jobs
                if (!highestMatchedJobs.isEmpty()) {
                    System.out.println("\nMost Matched Job(s):");
                    for (Job job : highestMatchedJobs) {
                        System.out.println("  - " + job.getJobTitle() + " (Score: " + highest + ")");
                    }
                }

                if (!lowestMatchedJobs.isEmpty() && lowest != highest) {
                    System.out.println("\nLeast Matched Job(s):");
                    for (Job job : lowestMatchedJobs) {
                        System.out.println("  - " + job.getJobTitle() + " (Score: " + lowest + ")");
                    }
                }

                // Show chart if there are valid scores
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
    
    // Helper function to calculate the time taken
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
            ListInterface<Job> applicationMatchList = new DoublyLinkedList<>();
            Object object = getObject("Job");

            if (!applicant.getJobApplication().isEmpty()) {
                for (JobApplication jobApplication : applicant.getJobApplication()) {
                    applicationMatchList.add(jobApplication.getJob());
                }

                // Sort jobs based on matching score
                ListInterface<Job> sortedList = MatchingEngine.heapSort(applicationMatchList, object);

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
    
    // ==================================Interview Module Report===========================================
    
    public static void interviewReportManagement() {
        int choice;
        do {
            displayLoggedInEmployer();

            System.out.println("\n===== EMPLOYER REPORT MODULE =====");
            System.out.println("1. View Schedules by Date");
            System.out.println("2. View Applicants by Status");
            System.out.println("3. View Applicants by Status");
            System.out.println("4. View Applicants by Score");
            System.out.println("5. View Passed Applicants (Score >= 80)");
            System.out.println("6. Generate Summary Report");
            System.out.println("7. View Top Scorer");
            System.out.println("8. View Upcoming Interviews");
            System.out.println("9. Exit");
            System.out.print("Enter choice > ");
            choice = Input.getIntegerInput();

            switch (choice) {
                case 1:
                    viewScheduleByDate();
                    break;
                case 2:
                    viewApplicantsByName();
                    break;
                case 3:
                    viewApplicantsByStatus();
                    break;
                case 4:
                    viewApplicantsByScore();
                    break;
                case 5:
                    viewPassedApplicants();
                    break;
                case 6:
                    generateSummaryReport();
                    break;
                case 7:
                    viewTopScorer();
                    break;
                case 8:
                    viewUpcomingInterviews();
                    break;
                case 9:
                    System.out.println("Exiting report module...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 9);
    }

    public static void displayLoggedInEmployer() {
        Employer employer = Database.getEmployer();
        if (employer != null) {
            System.out.println("\nLogged in Employer: " + employer.getName());
        } else {
            System.out.println("No employer is currently logged in.");
        }
    }

    public static void viewScheduleByDate() {
        System.out.print("Enter interview date (yyyy-mm-dd) > ");
        String interviewDateStr = Input.getStringInput();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date interviewDate;

        try {
            interviewDate = sdf.parse(interviewDateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format.");
            return;
        }

        boolean found = false;

        // Table Header
        System.out.println("\nSchedules on " + interviewDateStr + " for Employer: " + Database.getEmployer().getName());
        System.out.printf("%-20s %-15s %-15s %-12s %-10s%n", "Applicant Name", "Interview Date", "Follow-up Date", "Venue", "Status");
        System.out.println("--------------------------------------------------------------------------------");

        for (int i = 0; i < Database.schedules.size(); i++) {
            Schedule schedule = Database.schedules.get(i);
            if (schedule.getEmployer().equals(Database.getEmployer())
                    && sdf.format(schedule.getInterviewDate()).equals(sdf.format(interviewDate))) {

                String applicantName = schedule.getApplicant().getName();
                String interviewDateFormatted = sdf.format(schedule.getInterviewDate());
                String followUpDateFormatted = sdf.format(schedule.getFollowUpDate());
                String venue = schedule.getVenue();  // Assuming there's a getVenue method in Schedule class
                String status = schedule.getStatus();

                System.out.printf("%-20s %-15s %-15s %-12s %-10s%n",
                        applicantName, interviewDateFormatted, followUpDateFormatted, venue, status);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No schedules found on this date for employer: " + Database.getEmployer().getName());
        }
    }

    public static void viewApplicantsByName() {
        System.out.print("Enter applicant name to filter: ");
        String applicantName = Input.getStringInput().toLowerCase();

        System.out.println("\n=== INTERVIEW SCHEDULES FOR APPLICANT: " + applicantName + " ===");
        System.out.printf("%-20s %-12s %-8s %-3s %-9s\n", "Applicant", "Interview Date", "Venue", "Score", "Status");

        boolean found = false;
        for (Schedule schedule : Database.schedules) {
            if (schedule.getEmployer().equals(Database.getEmployer())
                    && schedule.getApplicant().getName().toLowerCase().contains(applicantName)) {
                System.out.printf("%-20s %-12s %-8s %-3d %-9s\n",
                        schedule.getApplicant().getName(), schedule.getInterviewDate(),
                        schedule.getVenue(), schedule.getScore(), schedule.getStatus());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No schedules found for applicant: " + applicantName);
        }
    }

    public static void viewApplicantsByStatus() {
        System.out.println("Enter status to filter:");
        System.out.println("1. Scheduled");
        System.out.println("2. Completed");
        System.out.println("3. Canceled");
        System.out.print("Enter choice (1-3) > ");

        int choice = Input.getIntegerInput();
        String statusToFilter;

        switch (choice) {
            case 1:
                statusToFilter = "Scheduled";
                break;
            case 2:
                statusToFilter = "Completed";
                break;
            case 3:
                statusToFilter = "Canceled";
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        boolean found = false;

        // Table Header
        System.out.println("\nApplicants with status: " + statusToFilter + " for Employer: " + Database.getEmployer().getName());
        System.out.printf("%-20s %-15s %-15s %-12s %-10s%n", "Applicant Name", "Interview Date", "Follow-up Date", "Venue", "Status");
        System.out.println("--------------------------------------------------------------------------------");

        for (int i = 0; i < Database.schedules.size(); i++) {
            Schedule schedule = Database.schedules.get(i);
            if (schedule.getEmployer().equals(Database.getEmployer())
                    && schedule.getStatus().equalsIgnoreCase(statusToFilter)) {

                String applicantName = schedule.getApplicant().getName();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String interviewDateFormatted = sdf.format(schedule.getInterviewDate());
                String followUpDateFormatted = sdf.format(schedule.getFollowUpDate());
                String venue = schedule.getVenue();  // Assuming there's a getVenue method in Schedule class
                String status = schedule.getStatus();

                // Print the schedule in tabular format
                System.out.printf("%-20s %-15s %-15s %-12s %-10s%n",
                        applicantName, interviewDateFormatted, followUpDateFormatted, venue, status);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No applicants with status: " + statusToFilter + " for employer: " + Database.getEmployer().getName());
        }
    }

    public static void viewApplicantsByScore() {
        ListInterface<Schedule> schedules = Database.schedules;
        int n = schedules.size();

        // Sort schedules by score in descending order
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Schedule si = schedules.get(i);
                Schedule sj = schedules.get(j);

                if (si.getEmployer().equals(Database.getEmployer()) && sj.getEmployer().equals(Database.getEmployer())) {
                    // Compare and swap if needed
                    if (si.getScore() < sj.getScore()) {
                        schedules.swap(i, j);
                    }
                }
            }
        }

        System.out.println("\n=== APPLICANTS BY SCORE ===");
        boolean found = false;
        for (int i = 0; i < n; i++) {
            Schedule s = schedules.get(i);
            if (s.getEmployer().equals(Database.getEmployer())) {
                System.out.printf("Applicant: %-20s | Score: %-3d\n", s.getApplicant().getName(), s.getScore());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No applicants with recorded scores.");
        }
    }

    public static void viewPassedApplicants() {
        System.out.println("\n=== PASSED APPLICANTS ===");

        // Find passed applicants
        boolean found = false;

        for (Schedule schedule : Database.schedules) {
            if (schedule.getEmployer().equals(Database.getEmployer()) && schedule.getScore() >= 80) {
                // Print applicant name and score
                System.out.printf("%-25s | %-10s%n", schedule.getApplicant().getName(), schedule.getScore());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No applicants scored 80 or above.");
        }
    }

    public static void generateSummaryReport() {
        int total = 0, completed = 0, scheduled = 0, canceled = 0;

        for (Schedule schedule : Database.schedules) {
            if (schedule.getEmployer().equals(Database.getEmployer())) {
                total++;
                switch (schedule.getStatus().toLowerCase()) {
                    case "completed" -> completed++;
                    case "scheduled" -> scheduled++;
                    case "canceled" -> canceled++;
                }
            }
        }

        // Print summary report
        System.out.println("\n=== SUMMARY REPORT ===");
        System.out.printf("Total Interviews: %-5d%n", total);
        System.out.printf("Completed: %-5d%n", completed);
        System.out.printf("Scheduled: %-5d%n", scheduled);
        System.out.printf("Canceled: %-5d%n", canceled);
    }

    public static void viewTopScorer() {
        ListInterface<Schedule> schedules = Database.schedules;
        Schedule top = null;

        for (int i = 0; i < schedules.size(); i++) {
            Schedule s = schedules.get(i);
            if (s.getEmployer().equals(Database.getEmployer()) && s.getScore() >= 0) {
                if (top == null || s.getScore() > top.getScore()) {
                    top = s;
                }
            }
        }

        System.out.println("\n=== TOP SCORING APPLICANT ===");
        if (top != null) {
            System.out.printf("%-20s | Score: %d\n", top.getApplicant().getName(), top.getScore());
        } else {
            System.out.println("No applicant with a valid score found.");
        }
    }

    public static void viewUpcomingInterviews() {
        Date today = new Date(); // current date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("\n=== UPCOMING INTERVIEWS ===");
        System.out.printf("%-20s %-15s %-15s %-10s\n", "Applicant", "Date", "Venue", "Status");

        boolean found = false;
        for (int i = 0; i < Database.schedules.size(); i++) {
            Schedule s = Database.schedules.get(i);
            if (s.getEmployer().equals(Database.getEmployer()) && s.getInterviewDate().after(today)) {
                System.out.printf("%-20s %-15s %-15s %-10s\n",
                        s.getApplicant().getName(),
                        sdf.format(s.getInterviewDate()),
                        s.getVenue(),
                        s.getStatus());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No upcoming interviews found.");
        }
    }

    // ==================================Searching Module Report===========================================
    
    private static void searchingReportManagement(){
        int input;
        do{
            UserManager.profileHeadLine();
            input = ReportUI.searchingReport();
           
            switch (input){
                case 1 -> searchPerformanceManagement();
                case 2 -> searchHistoryManagement();
                case 3 -> Tools.back();
                default -> MessageUI.errorMessage();
            }
        }while(input != 3);
    }
    
    // 1. Search Module Performance Report
    // How the accuracy for the searching result
    private static void searchPerformanceManagement(){
        UserManager.profileHeadLine();
        String description = """
                             This report is to show the total accuracy from the search input.
                                   """;
        ReportUI.reportHeader("Searching");
        ReportUI.descriptionLine(description);
        searchPerformanceReport();
        Tools.systemPause("Press Enter to Continue...");
    }
    
    // Helper function to generate the search performance report
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
    private static void searchHistoryManagement(){
        UserManager.profileHeadLine();
        String description = """
                             This report is th show the frequency of search terms or job titles from the search history.
                                   """;
        ReportUI.reportHeader("Search Trend");
        ReportUI.descriptionLine(description);
        searchHistoryReport();
        Tools.systemPause("Press Enter to Continue...");
    }
    
    // Helper function to generate the search history report
    private static void searchHistoryReport() {
        ListInterface<String> searchHistory = Database.searchHistory; 
        if (searchHistory.isEmpty()) {
            System.out.println("No search history available.");
            return;
        }

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

        // Print the table header
        System.out.println("\n============================== Search History ==============================");
        System.out.printf("| %-15s | %-10s | %-15s |\n", "Search Term", "Count", "Date/Time");
        System.out.println("===========================================================================");

        for (int i = 0; i < searchTerms.size(); i++) {
            String searchTerm = searchTerms.get(i);
            int count = searchCounts.get(i);
            String timestamp = "2025-04-16 12:00"; // Placeholder

            System.out.printf("| %-15s | %-10d | %-15s |\n", searchTerm, count, timestamp);
        }
        System.out.println("===========================================================================");

        // Find highest and lowest trends
        int highest = 0;
        int lowest = Integer.MAX_VALUE;
        ListInterface<String> highestTrends = new DoublyLinkedList<>();
        ListInterface<String> lowestTrends = new DoublyLinkedList<>();

        for (int i = 0; i < searchCounts.size(); i++) {
            int count = searchCounts.get(i);
            String term = searchTerms.get(i);

            if (count > highest) {
                highest = count;
                highestTrends.clear();
                highestTrends.add(term);
            } else if (count == highest) {
                highestTrends.add(term);
            }

            if (count < lowest) {
                lowest = count;
                lowestTrends.clear();
                lowestTrends.add(term);
            } else if (count == lowest) {
                lowestTrends.add(term);
            }
        }

        // Display highest and lowest trends
        System.out.println("\nMost Trending Search Term(s):");
        for (String term : highestTrends) {
            System.out.printf("- %s (%d times)\n", term, highest);
        }

        System.out.println("\nLeast Trending Search Term(s):");
        for (String term : lowestTrends) {
            System.out.printf("- %s (%d time%s)\n", term, lowest, lowest > 1 ? "s" : "");
        }

        // Extract and display the most common keyword fragment if applicable
        String commonKeyword = findCommonKeyword(searchTerms);
        if (!commonKeyword.isEmpty()) {
            System.out.println("\nCommon Relevant Keyword: \"" + commonKeyword + "\"");
        }

        System.out.println("\n");

        // Display chart
        searchHistoryDistributionGraph();
    }

    // Helper function to calculate the distribution
    private static void searchHistoryDistributionGraph() {
        ListInterface<String> searchHistory = Database.searchHistory; 

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
    
    // Helper function tot find the common keyword
    private static String findCommonKeyword(ListInterface<String> searchTerms) {
        if (searchTerms.isEmpty()) return "";

        String[] words = searchTerms.get(0).split(" ");
        for (String word : words) {
            System.out.println(word);
            boolean isCommon = true;
            for (int i = 1; i < searchTerms.size(); i++) {
                if (!searchTerms.get(i).toLowerCase().contains(word.toLowerCase())) {
                    isCommon = false;
                    break;
                }
            }
            if (isCommon) {
                return word;
            }
        }
        return "";
    }

    // ==================================Helper Report===========================================
    
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
    
    // ==================================Generating Graph===========================================
    
    private static void verticalBarChart(ListInterface<String> x_axis, ListInterface<Integer> y_axis, String title) {
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
            // row
            System.out.print("            ");
            for (int j = 0; j < y_axis.size(); j++) {
                // column
                if (y_axis.get(j) >= i) {
                    String color = colors[j % colors.length]; 
                    System.out.print("   " + color + "   " + RESET);
                } else {
                    System.out.print("      ");
                }
            }
            System.out.println();
        }

        // Draw x-axis
        System.out.print("              ");
        for (int i = 0; i < y_axis.size(); i++) {
            System.out.print("-------");
        }
        System.out.println();

        // Print x-axis labels
        System.out.print("              ");
        for (int i = 0; i < x_axis.size(); i++) {
            String label = x_axis.get(i);
            System.out.printf(" %-5s", label.length() > 5 ? label.substring(0, 5) : label);
        }
        System.out.println("\n");
    }
}
