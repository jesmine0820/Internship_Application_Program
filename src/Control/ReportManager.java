package Control;

import ADT.*;
import Boundary.ReportUI;
import Dao.Database;
import Entity.*;
import Utility.Input;
import Utility.MatchingEngine;
import Utility.MessageUI;
import Utility.Searching;
import Utility.Tools;

/**
 *
 * @author All
 * Explanation
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
    
    private static final MatchingEngine match = new MatchingEngine();
    private static final Searching searching = new Searching();
    
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
        UserManager.profileHeadLine();
        ReportUI.reportHeader("Matching");
        generateMatchingReport();
        Tools.systemPause("Press Enter to Continue...");
    }
    
    private static <T> void generateMatchingReport() {

        if (Database.getEmployer() != null) {
            Employer employer = Database.getEmployer();
            ListInterface<Job> jobMatchList = new DoublyLinkedList<>();
            T object = getObject("Applicant");

            if (!employer.getJob().isEmpty()) {
                for (Job job : employer.getJob()) {
                    jobMatchList.add(job);
                    ListInterface<Applicant> applicantMatchList = new DoublyLinkedList<>();

                    // Collect applicants who applied for this job
                    for (JobApplication jobApplication : job.getJobApplication()) {
                        applicantMatchList.add(jobApplication.getApplicant());
                    }

                    // Sort the applicants 
                    ListInterface<Applicant> sortedList = match.heapSort(applicantMatchList, object);

                    // Print job title
                    System.out.println("Job: " + job.getJobTitle());

                    // Print matched applicants with scores
                    if (!sortedList.isEmpty()) {
                        for (int i = 0; i < sortedList.size(); i++) {
                            Applicant applicant = sortedList.get(i);
                            int score = match.getScore(applicant, employer);
                            System.out.println("  - " + applicant.getName() + " (Score: " + score + ")");
                        }
                    } else {
                        MessageUI.noMatchFound();
                    }
                    System.out.println("-------------------------------------------"); 
                }
            }
        } else {
            Applicant applicant = Database.getApplicant();
            ListInterface<JobApplication> applicationMatchList = new DoublyLinkedList<>();
            ListInterface<Job> jobMatchList = new DoublyLinkedList<>();
            T object = getObject("Job");

            if (!applicant.getJobApplication().isEmpty()) {
                for (JobApplication jobApplication : applicant.getJobApplication()) {
                    applicationMatchList.add(jobApplication);
                    jobMatchList.add(jobApplication.getJob());
                }

                ListInterface<Job> sortedList = match.heapSort(jobMatchList, object);

                if (!sortedList.isEmpty()) {
                    for (int i = 0; i < sortedList.size(); i++) {
                        Job job = sortedList.get(i);
                        int score = match.getScore(job, applicant);
                        System.out.println("  - " + job.getJobTitle() + " (Score: " + score + ")");
                        System.out.println("-------------------------------------------"); 
                    }
                } else {
                    MessageUI.noMatchFound();
                }
                System.out.println(); 
            }
        }
    }



    // 2. Top Matched Applicants Report
    // Highest Match Score per applicant
    
    private static void topMatchedReport(){
        ReportUI.reportHeader("Matching");
        generateTopMatchedReport();
        Tools.systemPause("Press Enter to Continue...");
    }
    
    private static <T> void generateTopMatchedReport(){
        if(UserManager.isEmployer()){
            MessageUI.restrictView();
        } else {
            Applicant applicant = Database.getApplicant();
            ListInterface<Job> jobList = Database.jobList;
            T object = getObject("Job");
            
            if (jobList.isEmpty()){
                MessageUI.emptyDatabase();
                return;
            }
            
            ListInterface<Job> sortedList = match.heapSort(jobList, object);
            
            System.out.println("Matching Result for: " + applicant.getName());
            if (!sortedList.isEmpty()) {
                    for (int i = 0; i < sortedList.size(); i++) {
                        Job job = sortedList.get(i);
                        int score = match.getScore(job, applicant);
                        System.out.println("  - " + job.getJobTitle() + " (Score: " + score + ")");
                    }
                } else {
                    MessageUI.noMatchFound();
                }
                System.out.println(); 
            
        }
    }
    
    // 3. Matching Engine Efficiency Report
    // Successful matches and time taken for matching
    private static void matchingEngineEfficiencyReport() {
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
                    ListInterface<Applicant> sortedList = match.heapSort(applicantMatchList, object);

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
                ListInterface<JobApplication> sortedList = match.heapSort(applicationMatchList, object);

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
    }

    // Searching Module Report
    private static void searchingReportManagement(){
        UserManager.profileHeadLine();
        ReportUI.reportHeader("Searching");
        searchPerformanceReport();
        Tools.systemPause("Press Enter to Continue...");
    }
    
    // 1. Search Module Performance Report
    // How often the top search results are relevant
    private static void searchPerformanceReport(){
        ListInterface<Job> jobList = Database.jobList;
        ListInterface<Job> results = new DoublyLinkedList<>();

        String input = Input.getStringInput("Search a job: ");
        int falseStep = 10;
        
        for (int i = 0; i < jobList.size(); i++) {
                Job job = jobList.get(i);
                if (searching.search(job.getJobTitle().toLowerCase(), input) || searching.fuzzyMatching(job.getJobTitle().toLowerCase(), input) <= falseStep) {
                    results.add(job);
                    results = match.heapSort(results, job);
                    
                }
            }
        
        int topRelevantResults = 0;
        String[] parts = input.replace(",","").split(" ");
        for (int i = 0; i < Math.min(5, results.size()); i++) {
            for (int j = 0; i < parts.length; j++){
                if (results.get(i).getJobTitle().contains(parts[j])) {
                    topRelevantResults++;
                }
            }
        }

        double relevanceScore = (double) topRelevantResults / Math.min(5, results.size()) * 100;
        System.out.println("Search Relevance Score: " + relevanceScore + "%");
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
}
