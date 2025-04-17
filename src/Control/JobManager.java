package Control;

import Entity.*;
import Boundary.*;
import ADT.*;
import Dao.*;
import Utility.*;
import java.util.Date;
import static Utility.Tools.*;

/**
 *
 * @author Kit Chin Jie Ying
 * 
 */
public class JobManager {

    private static final ListInterface<Job> newJobList = new DoublyLinkedList<>();
    
    public static void createJob() {
        
        boolean error;
        String jobTitle = null;
        
        JobUI.createJobHeader();

        String jobID = String.format("J%03d", Database.jobList.size() + 1);
        System.out.println("Generated Job ID: " + jobID);

        // Get required job details
        do{
            error = false;
            jobTitle = Input.getStringInput("Enter Job Title: ");
            if (isJobTitleExists(jobTitle)) {
                System.out.println("Please enter a different job title.");
                error = true;
            }
        }while(error);

        String jobType = Input.getChoiceInput("Choose Job Type:", ChooseSetting.JOB_TYPES);
        String jobDescription = Input.getStringInput("Enter Job Description: ");
        String interviewProcess = Input.getStringInput("Enter Interview Process: ");
        String employmentType = Input.getChoiceInput("Enter Employment Type: ", ChooseSetting.EMPLOYMENT_TYPES);
        String workMode = Input.getChoiceInput("Enter Employment Type: ", ChooseSetting.WORK_MODES);
        String probationPeriod = Input.getStringInput("Enter Probation Period: ");
        boolean relocationAssistance = Input.getBooleanInput("Does this job offer relocation assistance? (true/false): ");

        // Collect required skills and store them in a list
        ListInterface<String> selectedSkills = Input.getPaginatedMultiSelectInput("Enter Required Skills (comma-separated): ", ChooseSetting.SKILL_OPTIONS);
        ListInterface<String> requiredSkills = new DoublyLinkedList<>();
        if(selectedSkills != null){
            requiredSkills.add(selectedSkills);
        }
        int requiredExperience = Input.getIntegerInput("Enter Required Experience (in years): ");
        int teamSize = Input.getIntegerInput("Enter Team Size: ");
        double salary = Input.getDoubleInput("Enter Salary: ");
        // Collect job benefits and store them in a list
        ListInterface<String> selectedBenefit = Input.getPaginatedMultiSelectInput("Enter Benefits (comma-separated): ", ChooseSetting.BENEFITS_OPTIONS);
        ListInterface<String> benefits = new DoublyLinkedList<>();
        if(selectedBenefit != null){
            benefits.add(selectedBenefit);
        }
        Date applicationDeadline = Validation.checkDate("Enter Application Deadline (YYYY-MM-DD): ");
        int workHours = Input.getIntegerInput("Enter Work Hours per week: ");
        String careerDevelopment = Input.getStringInput("Enter Career Development Opportunities: ");

        // Retrieve logged-in staff's company
        if (Database.getEmployer() == null) {
            System.out.println("Error: No logged-in staff found. Unable to create job.");
            return;
        }

        Employer employer = Database.getEmployer();

        Job newJob = new Job(jobID, jobTitle, jobType, jobDescription, interviewProcess,
                employmentType, workMode, probationPeriod, relocationAssistance, requiredSkills,
                requiredExperience, teamSize, salary, benefits, applicationDeadline,
                workHours, careerDevelopment, null, null, employer);

        boolean editing = true;
        while (editing) {
            Tools.clearScreen();
            System.out.println("        ====================");
            System.out.println("        |   Job Summary    |");
            System.out.println("        ====================");

            // Temporary job to preview details before confirmation
            Job tempJob = new Job(jobID, jobTitle, jobType, jobDescription, interviewProcess,
                    employmentType, workMode, probationPeriod, relocationAssistance, requiredSkills,
                    requiredExperience, teamSize, salary, benefits, applicationDeadline,
                    workHours, careerDevelopment, null, null, Database.getEmployer());

            displayJobDetails(tempJob);

            String confirm = Input.getYesNoInput("Do you confirm the job details? (yes/no): ");
            if (confirm.equalsIgnoreCase("yes")) {
                editing = false;
                break;
            }

            // Attribute editing menu
            System.out.println("\nWhich attribute do you want to change?");
            System.out.println("1. Job Title");
            System.out.println("2. Job Type");
            System.out.println("3. Job Description");
            System.out.println("4. Interview Process");
            System.out.println("5. Employment Type");
            System.out.println("6. Work Mode");
            System.out.println("7. Probation Period");
            System.out.println("8. Relocation Assistance");
            System.out.println("9. Required Skills");
            System.out.println("10. Required Experience");
            System.out.println("11. Team Size");
            System.out.println("12. Salary");
            System.out.println("13. Benefits");
            System.out.println("14. Application Deadline");
            System.out.println("15. Work Hours");
            System.out.println("16. Career Development");
            System.out.println("17. Done Editing");

            int choice = Input.getIntegerInput("Enter your choice: ");

            switch (choice) {
                case 1 -> jobTitle = Input.getStringInput("Enter Job Title: ");
                case 2 -> jobType = Input.getChoiceInput("Choose Job Type:", ChooseSetting.JOB_TYPES);
                case 3 -> jobDescription = Input.getStringInput("Enter Job Description: ");
                case 4 -> interviewProcess = Input.getStringInput("Enter Interview Process: ");
                case 5 -> employmentType = Input.getChoiceInput("Enter Employment Type: ", ChooseSetting.EMPLOYMENT_TYPES);
                case 6 -> workMode = Input.getChoiceInput("Enter Work Mode: ", ChooseSetting.WORK_MODES);
                case 7 -> probationPeriod = Input.getStringInput("Enter Probation Period: ");
                case 8 -> relocationAssistance = Input.getBooleanInput("Does this job offer relocation assistance? (true/false): ");
                case 9 -> requiredSkills = Input.getPaginatedMultiSelectInput("Enter Required Skills (comma-separated): ", ChooseSetting.SKILL_OPTIONS);
                case 10 -> requiredExperience = Input.getIntegerInput("Enter Required Experience (in years): ");
                case 11 -> teamSize = Input.getIntegerInput("Enter Team Size: ");
                case 12 -> salary = Input.getDoubleInput("Enter Salary: ");
                case 13 -> benefits = Input.getPaginatedMultiSelectInput("Enter Benefits (comma-separated): ", ChooseSetting.BENEFITS_OPTIONS);
                case 14 -> applicationDeadline = Validation.checkDate("Enter Application Deadline (YYYY-MM-DD): ");
                case 15 -> workHours = Input.getIntegerInput("Enter Work Hours per week: ");
                case 16 -> careerDevelopment = Input.getStringInput("Enter Career Development Opportunities: ");
                case 17 -> editing = false;
                default -> MessageUI.errorMessage();
            }
        }

        String confirmCreate = Input.getYesNoInput("Do you confirm creating this job? (Yes/No): ");

        if (confirmCreate.equals("yes")) {
            // Add the job to the database
            newJobList.add(newJob);
            Database.jobList.add(newJob);

            // Display success message
            System.out.println(GREEN + "\nJob successfully created!" + RESET);
        } else {
            // If canceled, notify the user
            System.out.println(RED + "\nJob creation canceled!" + RESET);
            JobUI.employerMenu();
        }

        String anotherCreate = Input.getYesNoInput("Do you have another job to create? (Yes or No): ");
        switch (anotherCreate) {
            case "yes":
                createJob();
                break;
            case "no":
                System.out.println("Return to Main Menu");
            default:
                System.out.println("Invalid input!");
                break;
        }

    }

    public static void updateJob() {
        Tools.clearScreen();
        UserUI.headLine();

        System.out.println("======================");
        System.out.println("|     Update Job     |");
        System.out.println("======================");
        boolean updatingJob = true;

        while (updatingJob) {

            String jobTitle = Input.getStringInput("\nEnter Job Title to update: ");

            // Search for job in DLL (Ensure jobList is defined properly)
            Job jobToUpdate = null;
            for (Job job : Database.jobList) {
                if (job.getJobTitle().equalsIgnoreCase(jobTitle)) {
                    jobToUpdate = job;
                    break;
                }
            }

            if (jobToUpdate == null) {
                System.out.println("\nJob not found! Please try again.");
                continue;
            }

            // Store original values for comparison
            String originalTitle = jobToUpdate.getJobTitle();
            String originalType = jobToUpdate.getJobType();
            String originalDescription = jobToUpdate.getJobDescription();
            String originalInterviewProcess = jobToUpdate.getInterviewProcess();
            String originalEmploymentType = jobToUpdate.getEmploymentType();
            String originalWorkMode = jobToUpdate.getWorkMode();
            String originalProbation = jobToUpdate.getProbationPeriod();
            boolean originalRelocation = jobToUpdate.isRelocationAssistance();
            ListInterface<String> originalSkills = new DoublyLinkedList<>();
            for (int i = 0; i < jobToUpdate.getRequiredSkills().size(); i++) {
                originalSkills.add(jobToUpdate.getRequiredSkills().get(i));
            }
            int originalExperience = jobToUpdate.getRequiredExperience();
            int originalTeamSize = jobToUpdate.getTeamSize();
            double originalSalary = jobToUpdate.getSalary();
            ListInterface<String> originalBenefits = new DoublyLinkedList<>();
            for (int i = 0; i < jobToUpdate.getBenefits().size(); i++) {
                originalBenefits.add(jobToUpdate.getBenefits().get(i));
            }
            int originalWorkHours = jobToUpdate.getWorkHours();
            String originalCareer = jobToUpdate.getCareerDevelopment();
            Date originalDeadline = jobToUpdate.getApplicationDeadline();

            boolean updatingAttributes = true;
            while (updatingAttributes) {
                System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("| %-3s | %-25s | %-80s |\n", "No.", "Field", "Details");
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("| %-3d | %-25s | %-80s |\n", 1, "Job ID", jobToUpdate.getJobID());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 2, "Title", jobToUpdate.getJobTitle());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 3, "Type", jobToUpdate.getJobType());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 4, "Description", jobToUpdate.getJobDescription());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 5, "Interview Process", jobToUpdate.getInterviewProcess());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 6, "Employment Type", jobToUpdate.getEmploymentType());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 7, "Work Mode", jobToUpdate.getWorkMode());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 8, "Probation Period", jobToUpdate.getProbationPeriod());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 9, "Relocation Assistance", jobToUpdate.isRelocationAssistance() ? "Yes" : "No");
                printMultiLine("| %-3s | %-25s | %-80s |\n", 10, "Required Skills", jobToUpdate.getRequiredSkills());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 11, "Required Experience", jobToUpdate.getRequiredExperience() + " years");
                System.out.printf("| %-3d | %-25s | %-80s |\n", 12, "Team Size", jobToUpdate.getTeamSize());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 13, "Salary", "$" + jobToUpdate.getSalary());
                printMultiLine("| %-3s | %-25s | %-80s |\n", 14, "Benefits", jobToUpdate.getBenefits());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 15, "Work Hours", jobToUpdate.getWorkHours() + " per week");
                System.out.printf("| %-3d | %-25s | %-80s |\n", 16, "Career Development", jobToUpdate.getCareerDevelopment());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 17, "Application Deadline", jobToUpdate.getApplicationDeadline());
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------\n");

                int choice = Input.getIntegerInput("Choose an attribute to update (2-17): ");
                switch (choice) {
                    case 2 -> jobToUpdate.setJobTitle(Input.getStringInput("Enter new Job Title: "));
                    case 3 -> jobToUpdate.setJobType(Input.getChoiceInput("Enter new Job Type: ", ChooseSetting.JOB_TYPES));
                    case 4 -> jobToUpdate.setJobDescription(Input.getStringInput("Enter new Job Description: "));
                    case 5 -> jobToUpdate.setInterviewProcess(Input.getStringInput("Enter new Interview Process: "));
                    case 6 -> jobToUpdate.setEmploymentType(Input.getChoiceInput("Enter new Employment Type: ", ChooseSetting.EMPLOYMENT_TYPES));
                    case 7 -> jobToUpdate.setWorkMode(Input.getChoiceInput("Enter new Work Mode: ", ChooseSetting.WORK_MODES));
                    case 8 -> jobToUpdate.setProbationPeriod(Input.getStringInput("Enter new Probation Period: "));
                    case 9 -> {
                        String relocation = Input.getStringInput("Does this job offer relocation assistance? (yes/no): ");
                        jobToUpdate.setRelocationAssistance(relocation.equalsIgnoreCase("yes"));
                    }
                    case 10 -> jobToUpdate.setRequiredSkills(Input.getPaginatedMultiSelectInput("Enter new Required Skills (comma-separated): ", ChooseSetting.SKILL_OPTIONS));
                    case 11 -> jobToUpdate.setRequiredExperience(Input.getIntegerInput("Enter new Required Experience (years): "));
                    case 12 -> jobToUpdate.setTeamSize(Input.getIntegerInput("Enter new Team Size: "));
                    case 13 -> jobToUpdate.setSalary(Input.getDoubleInput("Enter new Salary: "));
                    case 14 -> jobToUpdate.setBenefits(Input.getPaginatedMultiSelectInput("Enter new Benefits (comma-separated): ", ChooseSetting.BENEFITS_OPTIONS));
                    case 15 -> jobToUpdate.setWorkHours(Input.getIntegerInput("Enter new Work Hours per week: "));
                    case 16 -> jobToUpdate.setCareerDevelopment(Input.getStringInput("Enter new Career Development details: "));
                    case 17 -> jobToUpdate.setApplicationDeadline(Validation.checkDate("Enter new Application Deadline (YYYY-MM-DD): "));
                    case 18 -> {
                        System.out.println("\nExiting update process for this job.");
                        updatingAttributes = false;
                    }
                    default -> System.out.println("\nInvalid choice! Please select a valid option.");
                }

                // Ask to update another attribute
                if (updatingAttributes) {
                    int anotherUpdate = Input.getIntegerInput("Would you like to update another attribute? (1 = Yes, 2 = No): ");
                    if (anotherUpdate == 2) {
                        updatingAttributes = false;
                    }
                }

                System.out.println("\nJob updated successfully!");
                System.out.println("\n The attributes were updated:");
                System.out.println("-----------------------------------------------------------");

                if (!jobToUpdate.getJobTitle().equals(originalTitle)) {
                    System.out.printf("%-25s: %s -> %s\n", "Job Title", originalTitle, jobToUpdate.getJobTitle());
                }

                if (!jobToUpdate.getJobType().equals(originalType)) {
                    System.out.printf("%-25s: %s -> %s\n", "Job Type", originalType, jobToUpdate.getJobType());
                }

                if (!jobToUpdate.getJobDescription().equals(originalDescription)) {
                    System.out.printf("%-25s: %s -> %s\n", "Job Description", originalDescription, jobToUpdate.getJobDescription());
                }

                if (!jobToUpdate.getInterviewProcess().equals(originalInterviewProcess)) {
                    System.out.printf("%-25s: %s -> %s\n", "Interview Process", originalInterviewProcess, jobToUpdate.getInterviewProcess());
                }

                if (!jobToUpdate.getEmploymentType().equals(originalEmploymentType)) {
                    System.out.printf("%-25s: %s -> %s\n", "Employment Type", originalEmploymentType, jobToUpdate.getEmploymentType());
                }

                if (!jobToUpdate.getWorkMode().equals(originalWorkMode)) {
                    System.out.printf("%-25s: %s -> %s\n", "Work Mode", originalWorkMode, jobToUpdate.getWorkMode());
                }

                if (!jobToUpdate.getProbationPeriod().equals(originalProbation)) {
                    System.out.printf("%-25s: %s -> %s\n", "Probation Period", originalProbation, jobToUpdate.getProbationPeriod());
                }

                if (jobToUpdate.isRelocationAssistance() != originalRelocation) {
                    System.out.printf("%-25s: %s -> %s\n", "Relocation Assistance", originalRelocation ? "Yes" : "No", jobToUpdate.isRelocationAssistance() ? "Yes" : "No");
                }

                if (!jobToUpdate.getRequiredSkills().equals(originalSkills)) {
                    printMultiLine("%-25s: %s -> %s\n", "Skills", originalSkills, jobToUpdate.getRequiredSkills());
                }

                if (jobToUpdate.getRequiredExperience() != originalExperience) {
                    System.out.printf("%-25s: %d -> %d\n", "Required Experience", originalExperience, jobToUpdate.getRequiredExperience());
                }

                if (jobToUpdate.getTeamSize() != originalTeamSize) {
                    System.out.printf("%-25s: %d -> %d\n", "Team Size", originalTeamSize, jobToUpdate.getTeamSize());
                }

                if (Double.compare(jobToUpdate.getSalary(), originalSalary) != 0) {
                    System.out.printf("%-25s: %.2f -> %.2f\n", "Salary", originalSalary, jobToUpdate.getSalary());
                }

                if (jobToUpdate.getWorkHours() != originalWorkHours) {
                    System.out.printf("%-25s: %d -> %d\n", "Work Hours", originalWorkHours, jobToUpdate.getWorkHours());
                }

                if (!jobToUpdate.getCareerDevelopment().equals(originalCareer)) {
                    System.out.printf("%-25s: %s -> %s\n", "Career Development", originalCareer, jobToUpdate.getCareerDevelopment());
                }

                if (!jobToUpdate.getApplicationDeadline().equals(originalDeadline)) {
                    System.out.printf("%-25s: %s -> %s\n", "Application Deadline", originalDeadline, jobToUpdate.getApplicationDeadline());
                }

                if (!jobToUpdate.getBenefits().equals(originalBenefits)) {
                    printMultiLine("%-25s: %s -> %s\n", "Benefits", originalBenefits, jobToUpdate.getBenefits());
                }

                System.out.println("-----------------------------------------------------------");

                // Optionally: Wait for user input before clearing the screen
                Tools.systemPause();

                //Display the updated job details
                Tools.clearScreen();
                UserUI.headLine();
                System.out.println("\n Updated Job Details:");
                displayJobDetails(jobToUpdate);

                // Ask the user if they want to update another job
                int anotherJob = Input.getIntegerInput("Would you like to update another job? (1 = Yes, 2 = No): ");
                if (anotherJob == 2) {
                    updatingJob = false;

                    // Redirect to Employer UI after exiting the update process
                    System.out.println("\nReturning to Employer UI");
                }
            }

        }

    }

    public static void deleteJob() {
        Tools.clearScreen();
        UserUI.headLine();
        boolean continueDeleting = true;

        System.out.println("====================");
        System.out.println("|   Delete Job     |");
        System.out.println("====================");
        while (continueDeleting) {

            String jobTitle = Input.getStringInput("Enter Job Title to delete: ");

            Job jobToDelete = compareJobTitle(jobTitle); // Function to search job in jobList by ID

            // Check if the job exists
            if (jobToDelete == null) {
                System.out.println("Job " + jobTitle + " not found.");
            } else {
                // Confirm deletion
                System.out.println("\n----------------------------------------------------------------------------------------------------------------------");
                System.out.printf("| %-3s | %-25s | %-80s |\n", "No.", "Field", "Details");
                System.out.println("----------------------------------------------------------------------------------------------------------------------");
                System.out.printf("| %-3d | %-25s | %-80s |\n", 1, "Job ID", jobToDelete.getJobID());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 2, "Title", jobToDelete.getJobTitle());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 3, "Type", jobToDelete.getJobType());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 4, "Description", jobToDelete.getJobDescription());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 5, "Interview Process", jobToDelete.getInterviewProcess());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 6, "Employment Type", jobToDelete.getEmploymentType());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 7, "Work Mode", jobToDelete.getWorkMode());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 8, "Probation Period", jobToDelete.getProbationPeriod());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 9, "Relocation Assistance", jobToDelete.isRelocationAssistance() ? "Yes" : "No");
                printMultiLine("| %-3s | %-25s | %-80s |\n", 10, "Required Skills", jobToDelete.getRequiredSkills());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 11, "Required Experience", jobToDelete.getRequiredExperience() + " years");
                System.out.printf("| %-3d | %-25s | %-80s |\n", 12, "Team Size", jobToDelete.getTeamSize());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 13, "Salary", "$" + jobToDelete.getSalary());
                printMultiLine("| %-3s | %-25s | %-80s |\n", 14, "Benefits", jobToDelete.getBenefits());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 15, "Work Hours", jobToDelete.getWorkHours() + " per week");
                System.out.printf("| %-3d | %-25s | %-80s |\n", 16, "Career Development", jobToDelete.getCareerDevelopment());
                System.out.printf("| %-3d | %-25s | %-80s |\n", 17, "Application Deadline", jobToDelete.getApplicationDeadline());
                System.out.println("----------------------------------------------------------------------------------------------------------------------\n");

                String confirm = Input.getYesNoInput("Are you sure you want to delete this job? (Yes/No): ");

                if (confirm.equals("yes")) {
                    boolean removed = Database.jobList.remove(jobToDelete);
                    if (removed) {
                        System.out.println(GREEN + "\nJob deleted successfully!" + RESET);
                    } else {
                        System.out.println(RED + "\nFailed to delete job!" + RESET);
                    }
                } else {
                    System.out.println(BLUE + "\nJob deletion canceled!" + RESET);
                }

                // Display remaining jobs
                System.out.println("\n--------- Remaining Jobs -------------");
                System.out.printf("|%-10s | %-20s%n", "JOB ID", "JOB TITLE         |");
                System.out.println("--------------------------------------");

                for (Job job : Database.jobList) {
                    System.out.printf("%-10s | %-20s%n", job.getJobID(), job.getJobTitle());
                }
            }

            // Ask if user wants to delete another job
            int anotherDelete = Input.getIntegerInput("Would you like to delete another job? (1 = Yes, 2 = No): ");
            if (anotherDelete == 2) {
                continueDeleting = false;
                System.out.println("\nReturning to main menu");
            }
        }

    }

    public static void filterJob() {
        boolean continueFilter = true;

        do {
            Tools.clearScreen();
            UserUI.headLine();

            System.out.println("\n====================");
            System.out.println("|   Filter Jobs    |");
            System.out.println("====================");

            System.out.println("Select the criteria to filter by (e.g., 1,3,5):");
            System.out.println("1. Job Type");
            System.out.println("2. Salary Range");
            System.out.println("3. Skills");
            System.out.println("4. Work Mode");
            System.out.println("5. Employment Type");

            String input = Input.getStringInput("Enter your choices: ");
            String[] selections = input.split(",");

            boolean filterJobType = false;
            boolean filterSalary = false;
            boolean filterSkills = false;
            boolean filterWorkMode = false;
            boolean filterEmployment = false;

            for (String s : selections) {
                switch (s.trim()) {
                    case "1" ->
                        filterJobType = true;
                    case "2" ->
                        filterSalary = true;
                    case "3" ->
                        filterSkills = true;
                    case "4" ->
                        filterWorkMode = true;
                    case "5" ->
                        filterEmployment = true;
                }
            }

            // Filter values
            String jobType = null;
            double minSalary = 0, maxSalary = Double.MAX_VALUE;
            ListInterface<String> requiredSkills = null;
            String workMode = null;
            String employmentType = null;

            // Get filter input
            if (filterJobType) {
                jobType = Input.getChoiceInput("Enter Job Type: ", ChooseSetting.JOB_TYPES);
            }
            if (filterSalary) {
                String salaryRange = Input.getChoiceInput("Enter Salary Range: ", ChooseSetting.SALARY_RANGES);
                switch (salaryRange) {
                    case "RM2,500 - RM3,500" -> {
                        minSalary = 2500;
                        maxSalary = 3500;
                    }
                    case "RM3,500 - RM4,500" -> {
                        minSalary = 3500;
                        maxSalary = 4500;
                    }
                    case "RM4,500 - RM6,000" -> {
                        minSalary = 4500;
                        maxSalary = 6000;
                    }
                    case "RM6,000 - RM7,500" -> {
                        minSalary = 6000;
                        maxSalary = 7500;
                    }
                    case "RM7,500 and above" -> {
                        minSalary = 7500;
                        maxSalary = Double.MAX_VALUE;
                    }
                }
            }
            if (filterSkills) {
                requiredSkills = Input.getMultipleChoiceInput("Enter required Skills: ", ChooseSetting.SKILL_OPTIONS);
            }
            if (filterWorkMode) {
                workMode = Input.getChoiceInput("Enter Work Mode: ", ChooseSetting.WORK_MODES);
            }
            if (filterEmployment) {
                employmentType = Input.getChoiceInput("Enter Employment Type: ", ChooseSetting.EMPLOYMENT_TYPES);
            }

            // Matching Jobs
            System.out.println("\nMatched Jobs:\n");
            boolean found = false;
            int jobNumber = 1;

            for (Job job : Database.jobList) {
                boolean match = true;

                if (filterJobType && !job.getJobType().equalsIgnoreCase(jobType)) {
                    match = false;
                }
                if (filterSalary && !(job.getSalary() >= minSalary && job.getSalary() <= maxSalary)) {
                    match = false;
                }
                if (filterWorkMode && !job.getWorkMode().equalsIgnoreCase(workMode)) {
                    match = false;
                }
                if (filterEmployment && !job.getEmploymentType().equalsIgnoreCase(employmentType)) {
                    match = false;
                }

                if (filterSkills && requiredSkills != null) {
                    for (int j = 0; j < requiredSkills.size(); j++) {
                        if (!job.getRequiredSkills().contains(requiredSkills.get(j))) {
                            match = false;
                            break;
                        }
                    }
                }

                if (match) {
                    ListInterface<String> matchedFilters = new DoublyLinkedList<>();

                    if (filterJobType && job.getJobType().equalsIgnoreCase(jobType)) {
                        matchedFilters.add("Job Type");
                    }
                    if (filterSalary && (job.getSalary() >= minSalary && job.getSalary() <= maxSalary)) {
                        matchedFilters.add("Salary");
                    }
                    if (filterSkills && requiredSkills != null) {
                        boolean skillsMatch = true;
                        for (int j = 0; j < requiredSkills.size(); j++) {
                            if (!job.getRequiredSkills().contains(requiredSkills.get(j))) {
                                skillsMatch = false;
                                break;
                            }
                        }
                        if (skillsMatch) {
                            matchedFilters.add("Skills");
                        }
                    }
                    if (filterWorkMode && job.getWorkMode().equalsIgnoreCase(workMode)) {
                        matchedFilters.add("Work Mode");
                    }
                    if (filterEmployment && job.getEmploymentType().equalsIgnoreCase(employmentType)) {
                        matchedFilters.add("Employment Type");
                    }
                    String companyName = (job.getEmployer() != null && job.getEmployer().getCompany() != null)
                            ? job.getEmployer().getCompany().getCompanyName()
                            : "N/A";

                    System.out.println(jobNumber + ". Job Title : " + job.getJobTitle());
                    System.out.println("   Company   : " + companyName);

                    System.out.print(CYAN + "   Matched by: " + RESET);
                    if (filterJobType && job.getJobType().equalsIgnoreCase(jobType)) {
                        System.out.print("[Job Type] ");
                    }
                    if (filterSalary && (job.getSalary() >= minSalary && job.getSalary() <= maxSalary)) {
                        System.out.print("[Salary] ");
                    }
                    if (filterSkills && requiredSkills != null) {
                        boolean skillsMatch = true;
                        for (int j = 0; j < requiredSkills.size(); j++) {
                            if (!job.getRequiredSkills().contains(requiredSkills.get(j))) {
                                skillsMatch = false;
                                break;
                            }
                        }
                        if (skillsMatch) {
                            System.out.print("[Skills] ");
                        }
                    }
                    if (filterWorkMode && job.getWorkMode().equalsIgnoreCase(workMode)) {
                        System.out.print("[Work Mode] ");
                    }
                    if (filterEmployment && job.getEmploymentType().equalsIgnoreCase(employmentType)) {
                        System.out.print("[Employment Type] ");
                    }

                    System.out.println("\n");
                    jobNumber++;
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No jobs matched your criteria.");
            } else {
                String detailsFilter = Input.getYesNoInput("Do you need more details? (Y/N): ");
                if (detailsFilter.equalsIgnoreCase("yes")) {
                    String selectedJob = Input.getStringInput("Enter the Job Title: ");
                    boolean jobFound = false;

                    for (Job job : Database.jobList) {
                        if (job.getJobTitle().equalsIgnoreCase(selectedJob)) {
                            displayJobDetails(job);
                            jobFound = true;
                            break;
                        }
                    }

                    if (!jobFound) {
                        System.out.println("No job found with the title: " + selectedJob);
                    }
                } 
            }

            String continueChoice = Input.getYesNoInput("Do you want to continue filtering? (Y/N): ");
            if (continueChoice.equalsIgnoreCase("yes")) {
                continueFilter = true;
            } else {
                //ApplicantUI.applicantMenu(); // You will need to implement this method
                continueFilter = false;
            }

        } while (continueFilter);
    }

    public static void displayJobDetails(Job job) {
        Tools.clearScreen();
        UserUI.headLine();

        System.out.println("\n----------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-25s | %-80s |\n", "Field", "Details");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-25s | %-80s |\n", "Job ID", job.getJobID());
        System.out.printf("| %-25s | %-80s |\n", "Title", job.getJobTitle());
        System.out.printf("| %-25s | %-80s |\n", "Type", job.getJobType());
        System.out.printf("| %-25s | %-80s |\n", "Description", job.getJobDescription());
        System.out.printf("| %-25s | %-80s |\n", "Interview Process", job.getInterviewProcess());
        System.out.printf("| %-25s | %-80s |\n", "Employment Type", job.getEmploymentType());
        System.out.printf("| %-25s | %-80s |\n", "Work Mode", job.getWorkMode());
        System.out.printf("| %-25s | %-80s |\n", "Probation Period", job.getProbationPeriod());
        System.out.printf("| %-25s | %-80s |\n", "Relocation Assistance", job.isRelocationAssistance() ? "Yes" : "No");
        printMultiLine("| %-25s | %-80s |\n", "Required Skills", job.getRequiredSkills());
        System.out.printf("| %-25s | %-80s |\n", "Required Experience", job.getRequiredExperience() + " years");
        System.out.printf("| %-25s | %-80s |\n", "Team Size", job.getTeamSize());
        System.out.printf("| %-25s | %-80s |\n", "Salary", "$" + job.getSalary());
        printMultiLine("| %-25s | %-80s |\n", "Benefits", job.getBenefits());
        System.out.printf("| %-25s | %-80s |\n", "Work Hours", job.getWorkHours() + " per week");
        System.out.printf("| %-25s | %-80s |\n", "Career Development", job.getCareerDevelopment());
        System.out.printf("| %-25s | %-80s |\n", "Application Deadline", job.getApplicationDeadline());
        System.out.println("----------------------------------------------------------------------------------------------------------------\n");

        Tools.systemPause();
    }
    
    public static void displayMyJob(Employer employer) {
        if (Database.jobList == null || Database.jobList.isEmpty()) {
            System.out.println("No jobs available to display.");
            return;
        }

        Tools.clearScreen();
        UserManager.profileHeadLine();

        for(Job job : Database.jobList){
            if(job.getEmployer().equals(employer)){
                System.out.println("\n----------------------------------------------------------------------------------------------------------------");
                System.out.printf("| %-25s | %-80s |\n", "Field", "Details");
                System.out.println("----------------------------------------------------------------------------------------------------------------");
                System.out.printf("| %-25s | %-80s |\n", "Job ID", job.getJobID());
                System.out.printf("| %-25s | %-80s |\n", "Title", job.getJobTitle());
                System.out.printf("| %-25s | %-80s |\n", "Type", job.getJobType());
                System.out.printf("| %-25s | %-80s |\n", "Description", job.getJobDescription());
                System.out.printf("| %-25s | %-80s |\n", "Interview Process", job.getInterviewProcess());
                System.out.printf("| %-25s | %-80s |\n", "Employment Type", job.getEmploymentType());
                System.out.printf("| %-25s | %-80s |\n", "Work Mode", job.getWorkMode());
                System.out.printf("| %-25s | %-80s |\n", "Probation Period", job.getProbationPeriod());
                System.out.printf("| %-25s | %-80s |\n", "Relocation Assistance", job.isRelocationAssistance() ? "Yes" : "No");
                printMultiLine("| %-25s | %-80s |\n", "Required Skills", job.getRequiredSkills());
                System.out.printf("| %-25s | %-80s |\n", "Required Experience", job.getRequiredExperience() + " years");
                System.out.printf("| %-25s | %-80s |\n", "Team Size", job.getTeamSize());
                System.out.printf("| %-25s | %-80s |\n", "Salary", "$" + job.getSalary());
                printMultiLine("| %-25s | %-80s |\n", "Benefits", job.getBenefits());
                System.out.printf("| %-25s | %-80s |\n", "Work Hours", job.getWorkHours() + " per week");
                System.out.printf("| %-25s | %-80s |\n", "Career Development", job.getCareerDevelopment());
                System.out.printf("| %-25s | %-80s |\n", "Application Deadline", job.getApplicationDeadline());
                System.out.println("----------------------------------------------------------------------------------------------------------------\n");
            }
        }

        Tools.systemPause();
    }

    public static <T> void displayJobDetails() {
        
        if (Database.jobList == null || Database.jobList.isEmpty()) {
            System.out.println("No jobs available to display.");
            return;
        }

        Tools.clearScreen();
        UserManager.profileHeadLine();

        System.out.println("Total jobs in the list: " + Database.jobList.size());
        System.out.println("\n-----------------------------");
        for (Job job : Database.jobList) {
            System.out.printf("| %-25s |\n", job.getJobTitle()); 
        }
        System.out.println("-----------------------------");

        for (Job job : Database.jobList) {
            System.out.println("\n----------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-25s | %-80s |\n", "Field", "Details");
            System.out.println("----------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-25s | %-80s |\n", "Job ID", job.getJobID());
            System.out.printf("| %-25s | %-80s |\n", "Title", job.getJobTitle());
            System.out.printf("| %-25s | %-80s |\n", "Type", job.getJobType());
            System.out.printf("| %-25s | %-80s |\n", "Description", job.getJobDescription());
            System.out.printf("| %-25s | %-80s |\n", "Interview Process", job.getInterviewProcess());
            System.out.printf("| %-25s | %-80s |\n", "Employment Type", job.getEmploymentType());
            System.out.printf("| %-25s | %-80s |\n", "Work Mode", job.getWorkMode());
            System.out.printf("| %-25s | %-80s |\n", "Probation Period", job.getProbationPeriod());
            System.out.printf("| %-25s | %-80s |\n", "Relocation Assistance", job.isRelocationAssistance() ? "Yes" : "No");
            printMultiLine("| %-25s | %-80s |\n", "Required Skills", job.getRequiredSkills());
            System.out.printf("| %-25s | %-80s |\n", "Required Experience", job.getRequiredExperience() + " years");
            System.out.printf("| %-25s | %-80s |\n", "Team Size", job.getTeamSize());
            System.out.printf("| %-25s | %-80s |\n", "Salary", "$" + job.getSalary());
            printMultiLine("| %-25s | %-80s |\n", "Benefits", job.getBenefits());
            System.out.printf("| %-25s | %-80s |\n", "Work Hours", job.getWorkHours() + " per week");
            System.out.printf("| %-25s | %-80s |\n", "Career Development", job.getCareerDevelopment());
            System.out.printf("| %-25s | %-80s |\n", "Application Deadline", job.getApplicationDeadline());
            System.out.println("----------------------------------------------------------------------------------------------------------------\n");
        }

        Tools.systemPause();
    }

    public static boolean isJobTitleExists(String jobTitle) {
        if (jobTitle == null || Database.jobList.isEmpty()) {
            return false;
        }

        for (Job job : Database.jobList) {
            if (job.getJobID() != null && job.getJobTitle().equalsIgnoreCase(jobTitle)  && job.getEmployer().equals(Database.getEmployer())) {
                System.out.println("Job Name already exists.");
                return true;
            }
        }
        return false;
    }

    public static Job compareJobTitle(String jobTitle) {
        for (Job currentJob : Database.jobList) {  // Enhanced for loop
            if (currentJob.getJobTitle().equalsIgnoreCase(jobTitle)) {
                return currentJob;  // Found matching job
            }
        }
        return null;  // No job found with the given jobTitle
    }

    private static void printMultiLine(String format, String label, ListInterface<String> jobList) {
        boolean first = true;

        // Check if the jobList is not empty
        if (jobList == null || jobList.isEmpty()) {
            System.out.printf(format, label, "N/A");
            return;
        }

        // Go through each item in the jobList
        for (String data : jobList) {
            if (first) {
                // For the first item, print the label and the data
                System.out.printf(format, label, data);
                first = false;
            } else {
                // For subsequent items, print only the data without the label
                System.out.printf(format, "", data);
            }
        }
    }

    private static void printMultiLine(String format, int number, String label, ListInterface<String> jobList) {
        boolean first = true;
        for (String data : jobList) {
            if (first) {
                // Print the number with label and first data
                System.out.printf(format, String.format("%-3d", number), label, data);
                first = false;
            } else {
                // Empty label for subsequent lines
                System.out.printf(format, "", "", data);
            }
            number++;  // Increment number for each subsequent line
        }

        // Handle empty list (if there are no skills)
        if (first) {
            System.out.printf(format, String.format("%-3d", number), label, "N/A");
        }
    }

    private static void printMultiLine(String format, String label, ListInterface<String> beforeList, ListInterface<String> afterList) {
        int maxSize = Math.max(beforeList.size(), afterList.size());

        for (int i = 0; i < maxSize; i++) {
            String before = i < beforeList.size() ? beforeList.get(i) : "N/A";
            String after = i < afterList.size() ? afterList.get(i) : "N/A";

            if (i == 0) {
                // First line prints with the label
                System.out.printf(format, label, before, after);
            } else {
                // Other lines don't print the label
                System.out.printf(format, "", before, after);
            }
        }
    }

    public static void searchJobsByEmployerOrCompany() {
        Tools.clearScreen();
        UserUI.headLine();

        boolean found;
        int count;

        while (true) {
            // Ask the user for the Employer / Company Name
            String keyword = Input.getStringInput("Enter Employer / Company Name to Search: ").toLowerCase();

            found = false;
            count = 0;

            // Loop through all the jobs in the list
            for (int i = 0; i < Database.jobList.size(); i++) {
                Job job = Database.jobList.get(i);
                Employer employer = job.getEmployer();
                Company company = (employer != null) ? employer.getCompany() : null;

                //Perform string matching with contains() method
                boolean matchEmployer = employer != null && employer.getName().toLowerCase().contains(keyword);
                boolean matchCompany = company != null && company.getCompanyName().toLowerCase().contains(keyword);

                if (matchEmployer || matchCompany) {
                    System.out.println("----------------------------");
                    System.out.println("Job Title : " + job.getJobTitle());
                    System.out.println("Employer  : " + (employer != null ? employer.getName() : "N/A"));
                    System.out.println("Company   : " + (company != null ? company.getCompanyName() : "N/A"));
                    System.out.println("----------------------------");
                    found = true;
                    count++;
                }
            }

            // Output message if no jobs are found
            if (!found) {
                System.out.println("No jobs found for keyword: " + keyword);
            } else {
                System.out.println("Total jobs found: " + count);
            }

            // Ask the user if they want to search again or quit
            String choice = Input.getStringInput("Press [Enter] to search again, or type 'q' to quit: ").trim().toLowerCase();
            if (choice.equals("q")) {
                JobUI.employerMenu();  // Redirect to the employer menu
                break;
            }
        }
    }

    public static boolean searchString(String source, String keyword) {
        return source != null && source.toLowerCase().contains(keyword.toLowerCase());
    }

    public static void displayBrowseJobDetail(Job job, int i){
        Employer employer = job.getEmployer();
        Company company = employer.getCompany();
        String companyName = company.getCompanyName();
        String jobTitle = job.getJobTitle();
        String jobType = job.getJobType();
        String jobDescription = job.getJobDescription();
        Double salary = job.getSalary();
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.printf ("    %-3s %-70s \n", (i + 1) + ".", companyName);
        System.out.printf ("        Position:     %-60s \n", jobTitle);
        System.out.printf ("        Type:         %-60s \n", jobType);
        System.out.printf ("        Salary:       RM%-57.2f \n", salary);
        System.out.printf ("        Description:  %-60s \n", jobDescription);
        System.out.println("--------------------------------------------------------------------------------------");
    }
    
    public static void displayJobUnderCompany(Company company){
        int i = 0;
        for(Job job : Database.jobList){
            if(job.getEmployer().getCompany().equals(company)){
                System.out.println("--------------------------------------------------------------------------------------");
                System.out.printf ("    %-3s %-70s \n", (i + 1) + ".", company.getCompanyName());
                System.out.printf ("        Position:     %-60s \n", job.getJobTitle());
                System.out.printf ("        Type:         %-60s \n", job.getJobType());
                System.out.printf ("        Salary:       RM%-57.2f \n", job.getSalary());
                System.out.printf ("        Description:  %-60s \n", job.getJobDescription());
                System.out.println("--------------------------------------------------------------------------------------");
                i++;
            }
        }
    }
}
