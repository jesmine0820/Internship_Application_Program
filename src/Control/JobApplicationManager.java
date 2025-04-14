package Control;

import ADT.*;
import Dao.Database;
import Entity.*;
import Utility.*;
import static Utility.Tools.*;
import java.util.Date;

/**
 *
 * @author Asus
 */
public class JobApplicationManager {

    private static final ListInterface<JobApplication> jobApplicationList = new DoublyLinkedList<>();
    private static final ListInterface<Job> jobList = Database.jobList;
    public static final ListInterface<Company> companies = Database.companies;

    //========== BROWSE JOBS ========== 
    public static void browseJobs() {
        if (jobList.isEmpty()) {
            System.out.println("No available jobs at the moment.");
            return;
        }

        // Display job summaries
        for (int i = 0; i < jobList.size(); i++) {
            Job job = jobList.get(i);
            String jobTitle = job.getJobTitle();
            String companyName = "Unknown";

            if (job.getEmployer() != null && job.getEmployer().getCompany() != null) {
                companyName = job.getEmployer().getCompany().getCompanyName();
            }

            System.out.println((i + 1) + ". " + jobTitle + " - " + companyName
                    + "\n   -> " + job.getJobDescription());
        }

        // Let user pick one to view
        int choice;
        while (true) {
            choice = Input.getIntegerInput("\nEnter the number of the job to view details (or 0 to cancel): ");
            if (choice == 0) {
                System.out.println("Cancelled.");
                return;
            } else if (choice > 0 && choice <= jobList.size()) {
                break;
            } else {
                System.out.println("Invalid selection. Please try again.");
            }
        }

        // Show selected job details
        Job selectedJob = jobList.get(choice - 1);
        Employer selectedEmployer = selectedJob.getEmployer();
        Company company = (selectedEmployer != null) ? selectedEmployer.getCompany() : null;

        System.out.println(BLUE + "\n========== Job Details ==========" + RESET);
        System.out.println("Title: " + selectedJob.getJobTitle());
        System.out.println("Company: " + (company != null ? company.getCompanyName() : "Unknown"));
        System.out.println("Location: " + (company != null ? company.getLocation() : "Unknown"));
        System.out.println("Salary: RM" + selectedJob.getSalary());
        System.out.println("Employment Type: " + selectedJob.getEmploymentType());
        System.out.println("Experience Required: " + selectedJob.getRequiredExperience() + " years");
        System.out.println("Application Deadline: " + selectedJob.getApplicationDeadline());
        System.out.println("Relocation Assistance: " + (selectedJob.isRelocationAssistance() ? "Yes" : "No"));

        System.out.println(BLUE + "\n--- Description ---" + RESET);
        System.out.println(selectedJob.getJobDescription());

        printMultiLine("Skills", selectedJob.getRequiredSkills());
        printMultiLine("Benefits", selectedJob.getBenefits());
        // Now offer to apply
        applyToJob(selectedJob);
    }

    // ========== APPLY JOBS ========== [after browse]
    public static void applyToJob(Job selectedJob) {
        if (selectedJob == null) {
            System.out.println("No job selected to apply for.");
            return;
        }

        String userChoice = Input.getYesNoInput("\nWould you like to apply for this job? (Yes/No): ");
        if (!userChoice.equalsIgnoreCase("yes")) {
            System.out.println("Application canceled.");
            return;
        }

        Applicant loggedInApplicant = Database.getApplicant();
        if (loggedInApplicant == null) {
            System.out.println("No logged-in applicant found. Please log in first.");
            return;
        }

        Resume resume = loggedInApplicant.getResume();

        // Check if all details are filled in
        boolean hasAllDetails = resume != null
                && resume.getEducationLevel() != null && !resume.getEducationLevel().isEmpty()
                && resume.getSkills() != null && !resume.getSkills().isEmpty()
                && resume.getExperience() != null && !resume.getExperience().isEmpty()
                && resume.getCertifications() != null && !resume.getCertifications().isEmpty()
                && resume.getProjects() != null && !resume.getProjects().isEmpty()
                && resume.getLanguagesSpoken() != null && !resume.getLanguagesSpoken().isEmpty()
                && resume.getAwards() != null && !resume.getAwards().isEmpty();

        if (!hasAllDetails) {
            System.out.println("\nYour resume is missing essential details.");
            String completeNow = Input.getYesNoInput("Would you like to complete the missing parts of your resume now? (Yes/No): ");
            if (!completeNow.equalsIgnoreCase("yes")) {
                System.out.println("Application canceled due to incomplete resume.");
                return;
            }

            // Ensure the resume has all required details
            ensureResumeHasAllDetails(loggedInApplicant);
        }

        // Generate application ID like APP001
        String applicationID = String.format("APP%03d", Database.jobApplicationList.size() + 1);

        JobApplication newApplication = new JobApplication();
        newApplication.setApplicationID(applicationID);
        newApplication.setApplicationDate(new Date());
        newApplication.setStatus("Pending");
        newApplication.setResumeSubmitted(true); // Since resume is now complete
        newApplication.setApplicant(loggedInApplicant);
        newApplication.setJob(selectedJob);
        newApplication.setInterviewScheduled(false);

        // Add the application to the applicant's job application list and to the database
        loggedInApplicant.getJobApplication().add(newApplication);
        jobApplicationList.add(newApplication); //local
        Database.jobApplicationList.add(newApplication);//global

        System.out.println(GREEN+"\nApplication submitted successfully!"+RESET);
        System.out.println("Applicant Name: " + loggedInApplicant.getName());
        System.out.println("Application ID: " + applicationID);
        System.out.println("Job Title: " + selectedJob.getJobTitle());
        System.out.println("Date Applied: " + newApplication.getApplicationDate().toString());
        System.out.println("Current Status: " + newApplication.getStatus());

    }

    // ========== Search ==========
    public static void searchMyApplications(String searchTerm) {
        Applicant loggedInApplicant = Database.getApplicant();
        if (loggedInApplicant == null) {
            System.out.println("No logged-in applicant found. Please log in first.");
            return;
        }

        ListInterface<JobApplication> jobApplications = loggedInApplicant.getJobApplication();
        if (jobApplications.isEmpty()) {
            System.out.println("You haven't applied for any jobs yet.");
            return;
        }

        boolean foundAny = false;
        int matchCount = 0;

        System.out.println("\n====================================");
        System.out.println("        Search My Applications       ");
        System.out.println("====================================\n");

        for (int i = 0; i < jobApplications.size(); i++) {
            JobApplication jobApp = jobApplications.get(i);
            if (matchesSearch(jobApp, searchTerm)) {
                System.out.printf(BLUE+"     ********** Match %d **********\n" +RESET,++matchCount);
                displayJobApplicationDetails(jobApp);
                foundAny = true;
            }
        }

        if (!foundAny) {
            System.out.println("No applications matched your search term.");
        } else {
            System.out.println(PURPLE + "\nTotal Matches Found: " + matchCount + RESET);
        }
    }

    private static boolean matchesSearch(JobApplication app, String term) {
        if (term == null || term.isEmpty()) {
            return false;
        }

        term = term.toLowerCase();
        Job job = app.getJob();
        Employer employer = job.getEmployer();
        Company company = (employer != null) ? employer.getCompany() : null;

        return (job.getJobTitle() != null && job.getJobTitle().toLowerCase().contains(term))
                || (job.getJobDescription() != null && job.getJobDescription().toLowerCase().contains(term))
                || (company != null && company.getCompanyName().toLowerCase().contains(term));
    }

    // ========== Cancel ========== [View Application --> Cancel]
    public static void CancelApplication() {

        Applicant loggedInApplicant = Database.getApplicant();
        if (loggedInApplicant == null) {
            System.out.println("No logged-in applicant found. Please log in first.");
            return;
        }

        ListInterface<JobApplication> jobApplications = loggedInApplicant.getJobApplication();
        if (jobApplications.isEmpty()) {
            System.out.println("You haven't applied for any jobs yet.");
            return;
        }

        System.out.println("\n====================================");
        System.out.println("          View My Application          ");
        System.out.println("====================================\n");

        System.out.println(PURPLE + "Total Applications: " + jobApplications.size() + RESET);

        int applicationNumber = 1;
        for (JobApplication jobApplication : jobApplications) {
            System.out.printf(BLUE + "     **********    Job Application %d    **********\n" + RESET, applicationNumber);
            displayJobApplicationDetails(jobApplication);
            applicationNumber++;
        }

        String wantToCancel = Input.getYesNoInput("Do you want to cancel an application? (yes/no): ");
        if (!wantToCancel.equalsIgnoreCase("yes")) {
            System.out.println("No applications were canceled.");
            return;
        }

        int applicationToCancel = Input.getIntegerInput("Enter the application number you want to cancel: ");
        if (applicationToCancel < 1 || applicationToCancel > jobApplications.size()) {
            System.out.println("Invalid application number. Please try again.");
            return;
        }

        String confirmCancel = Input.getYesNoInput("Are you sure you want to cancel this application? (yes/no): ");
        if (confirmCancel.equalsIgnoreCase("yes")) {
            JobApplication toRemove = jobApplications.get(applicationToCancel - 1);

            jobApplications.remove(applicationToCancel - 1);

            Database.jobApplicationList.remove(toRemove);

            Job relatedJob = toRemove.getJob();
            if (relatedJob != null) {
                relatedJob.getJobApplication().remove(toRemove);
            }

            System.out.println(GREEN+"Application " + applicationToCancel + " has been successfully canceled."+RESET);
        } else {
            System.out.println("Application deletion canceled.");
        }
    }
    
    public static void arrangeApplication(){
        MatchingEngine match = new MatchingEngine();
        Applicant applicants = new Applicant();
        Employer employer = Database.getEmployer();
        ListInterface<Job> jobMatchList = new DoublyLinkedList<>();
        
        if (!employer.getJob().isEmpty()) {
                for (Job job : employer.getJob()) {
                    jobMatchList.add(job);
                    ListInterface<Applicant> applicantMatchList = new DoublyLinkedList<>();

                    // Collect applicants who applied for this job
                    for (JobApplication jobApplication : job.getJobApplication()) {
                        applicantMatchList.add(jobApplication.getApplicant());
                    }

                    // Sort the applicants 
                    ListInterface<Applicant> sortedList = match.heapSort(applicantMatchList, applicants);

                    // Print job title
                    System.out.println("Job: " + job.getJobTitle());

                    // Print matched applicants with scores
                    if (!sortedList.isEmpty()) {
                        for (int i = 0; i < sortedList.size(); i++) {
                            Applicant applicant = sortedList.get(i);
                            System.out.println(i + ") " + applicant.getName());
                        }
                    } else {
                        MessageUI.noMatchFound();
                    }
                    System.out.println("-------------------------------------------"); 
                }
            }
        
    }

    // ========== INPUT HELPERs ========== 
    /*Resume Details [use when the resume incomplete]*/
    private static void ensureResumeHasAllDetails(Applicant applicant) {
        Resume resume = applicant.getResume();
        if (resume == null) {
            resume = new Resume();
        }

        if (resume.getEducationLevel() == null || resume.getEducationLevel().isEmpty()) {
            resume.setEducationLevel(Input.getChoiceInput("\nSelect Education Level: ", ChooseSetting.EDUCATION_LEVELS));
        }

        if (resume.getSkills() == null || resume.getSkills().isEmpty()) {
            resume.setSkills(Input.getPaginatedMultiSelectInput("Select Skills: ", ChooseSetting.SKILL_OPTIONS));
        }

        if (resume.getExperience() == null || resume.getExperience().isEmpty()) {
            resume.setExperience(Input.getStringListInput("\nEnter Work Experience (comma-separated): "));
        }

        if (resume.getCertifications() == null || resume.getCertifications().isEmpty()) {
            resume.setCertifications(Input.getStringListInput("\nEnter Certifications (comma-separated): "));
        }

        if (resume.getProjects() == null || resume.getProjects().isEmpty()) {
            resume.setProjects(Input.getStringListInput("\nEnter Projects (comma-separated): "));
        }

        if (resume.getLanguagesSpoken() == null || resume.getLanguagesSpoken().isEmpty()) {
            resume.setLanguagesSpoken(Input.getMultipleChoiceInput("\nSelect Languages Spoken: ", ChooseSetting.LANGUAGE_OPTIONS));
        }

        if (resume.getAwards() == null || resume.getAwards().isEmpty()) {
            resume.setAwards(Input.getStringListInput("\nEnter Awards (comma-separated): "));
        }

        applicant.setResume(resume);
    }

    //========== DISPLAY HELPERs ==========
    public static void displayJobApplicationDetails(JobApplication jobApplication) {
        Job job = jobApplication.getJob();
        Employer employer = job.getEmployer();
        Company company = employer != null ? employer.getCompany() : null;
        // Display individual job application details
        System.out.printf("%-20s: %s\n", "Job Title", job.getJobTitle());
        System.out.printf("%-20s: %s\n", "Job Description", job.getJobDescription());
        System.out.printf("%-20s: %s\n", "Company", (company != null ? company.getCompanyName() : "N/A"));
        System.out.printf("%-20s: %s\n", "Location", (company != null ? company.getLocation() : "N/A"));
        System.out.printf("%-20s: %s\n", "Employment Type", job.getEmploymentType());
        System.out.printf("%-20s: RM%,.2f\n", "Salary", job.getSalary());
        System.out.printf("%-20s: %s\n", "Application Status", jobApplication.getStatus());
        System.out.printf("%-20s: %s\n", "Interview Scheduled", (jobApplication.isInterviewScheduled() ? "Yes" : "No"));
        System.out.printf("%-20s: %s\n", "Application Date", jobApplication.getApplicationDate().toString());
        System.out.println(BLUE+"******************************************************************\n"+RESET);

    }
    
    public static void displayMyJobApplication() {
        ListInterface<JobApplication> applicationList = new DoublyLinkedList<>();
        for(int i = 0; i < Database.jobApplicationList.size(); i++){
            JobApplication currentApplication = Database.jobApplicationList.get(i);
            if(currentApplication.getApplicant() == Database.getApplicant()){
                applicationList.add(currentApplication);
            }
        }
        
        if(!applicationList.isEmpty()){
            // Display individual job application details
            for(JobApplication list : applicationList){
                System.out.println(BLUE+"******************************************************************\n"+RESET);
            System.out.printf("%-20s: %s\n", "Job Title", list.getJob().getJobTitle());
            System.out.printf("%-20s: %s\n", "Job Description", list.getJob().getJobDescription());
            System.out.printf("%-20s: %s\n", "Company", (list.getJob().getEmployer().getCompany() != null ? list.getJob().getEmployer().getCompany().getCompanyName() : "N/A"));
            System.out.printf("%-20s: %s\n", "Location", (list.getJob().getEmployer().getCompany() != null ? list.getJob().getEmployer().getCompany().getLocation() : "N/A"));
            System.out.printf("%-20s: %s\n", "Employment Type", list.getJob().getEmploymentType());
            System.out.printf("%-20s: RM%,.2f\n", "Salary", list.getJob().getSalary());
            System.out.printf("%-20s: %s\n", "Application Status", list.getStatus());
            System.out.printf("%-20s: %s\n", "Interview Scheduled", (list.isInterviewScheduled() ? "Yes" : "No"));
            System.out.printf("%-20s: %s\n", "Application Date", list.getApplicationDate().toString());
            System.out.println(BLUE+"******************************************************************\n"+RESET);
            }
        } else {
            MessageUI.emptyDatabase();
        }
    }

    /* for display skill & benefit [when browse] */
    private static void printMultiLine(String label, ListInterface<String> dataList) {
        System.out.println(label + ":");
        for (String data : dataList) {
            System.out.println("   - " + data);
        }
    }
}
