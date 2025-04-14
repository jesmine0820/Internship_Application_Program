package Control;

import ADT.*;
import Boundary.ApplicantUI;
import Boundary.UserUI;
import Dao.Database;
import Entity.*;
import Utility.*;
import static Utility.MessageUI.*;
import static Utility.Tools.*;
import java.util.Date;

/**
 *
 * @author Gan Khai Li
 * 
 */
public class ApplicantManager {

    // Create a local doubly linked list to store applicant information
    private static final ListInterface<Applicant> applicantList = new DoublyLinkedList<>();

    // ========== CREATE ==========
    public static void registerApplicant() {

        // Declare variables        
        String applicantID;
        String applicantName;
        Date dateOfBirth;
        String gender;
        String address;
        String ic;
        String phoneNo;
        String email;
        String socialMedia;
        String maritalStatus;
        String confirmation;
        
        // Collecting applicant-specific information
        Applicant newApplicantDetails = getApplicantDetails();

        // Collecting resume information
        Resume resume = getResumeDetails();
        
        // Applicant ID
        applicantID = String.format("A%03d", Database.applicants.size() + 1);
        
        // Applicant name
        applicantName = Validation.checkString("Enter your name: ");
        // Date of Birth
        dateOfBirth = Validation.checkDate("\"Enter your date of Birth(YYYY-MM-DD): \"");
        // Gender
        gender = Validation.checkGender("Enter your gender(Male/Female): ");
        // Address
        address = Input.getStringInput("Enter your Address: ");
        // IC
        ic = Validation.checkIcInput("Enter your IC(xxxxxx-xx-xxxx): ");
        // Phone Number
        phoneNo = Validation.checkPhoneNumber("Enter your IC(xxxxxx-xx-xxxx): ");
        // Email
        email = Validation.checkEmailFormat("Enter your email(e.g., john@gmail.com): ");
        // Social Media
        socialMedia = Validation.checkSocialMedia("Enter your Social Media(e.g.,@user_abc): ");
        // Marital Status
        maritalStatus = Input.getChoiceInput("Choose your marital status", ChooseSetting.MARITAL_STATUSES);
        
        // Save the applicant information into one object
        Applicant newApplicant = new Applicant(
                newApplicantDetails.getLocation(), newApplicantDetails.getPortfolioLink(),
                newApplicantDetails.getPreferredWorkMode(), newApplicantDetails.getDesiredJobType(),
                newApplicantDetails.getYearOfExperience(), newApplicantDetails.getDesiredSalaryRange(),
                newApplicantDetails.isWillingToRelocate(), newApplicantDetails.getAvailability(),
                resume, applicantID, applicantName, dateOfBirth, gender, address, ic, phoneNo, email, socialMedia, maritalStatus
        );

        // Get Confirmation
        confirmation = Input.getYesNoInput("\nDo you want to create this applicant? (Yes/No): ");
        
        if (confirmation.equalsIgnoreCase("yes") || confirmation.equalsIgnoreCase("y")) {
            applicantList.add(newApplicant); // local
            Database.applicants.add(newApplicant); // global
            MessageUI.createSuccessful();
        } else {
            MessageUI.cancelSelection();
        }
    }

    // ========== UPDATE ==========
    public static void editProfile() {
        
        // Declare variables
        boolean continueEditing = true;
        
        // Get the applicant from the Database
        Applicant applicantToUpdate = Database.getApplicant();

        // If no applicant is found, show an error message and return
        if (applicantToUpdate == null) {
            emptyApplicantMessage();
            return;
        }
        
        UserManager.profileHeadLine();
        
        // Main menu for selecting what to update
        while (continueEditing) {
            String[] editOptions = {
                "Update Personal Information",
                "Update Applicant Information",
                "Update Resume",
                "Cancel"
            };

            String editChoice = Input.getChoiceInput("\nWhat would you like to update?", editOptions);

            switch (editChoice) {
                case "Update Personal Information" -> {
                    displayPersonalInfo(applicantToUpdate);
                    updatePersonalInfo(applicantToUpdate);  // Modify personal details
                }
                case "Update Applicant Information" -> {
                    System.out.println("\nName: " + applicantToUpdate.getName());
                    displayApplicantDetails(applicantToUpdate);
                    updateApplicantInfo(applicantToUpdate); // Modify applicant info
                }
                case "Update Resume" -> {
                    System.out.println("\nName: " + applicantToUpdate.getName());
                    displayResumeDetails(applicantToUpdate.getResume());
                    updateResume(applicantToUpdate);  // Modify resume details
                }
                case "Cancel" -> {
                    MessageUI.cancelSelection();
                    continueEditing = false;
                }
                default ->
                    MessageUI.errorMessage();
            }

            if (continueEditing) {
                // Ask if they want to continue editing
                if (!Input.getYesNoInput("Would you like to update something else? (yes/no): ").equalsIgnoreCase("yes")) {
                    continueEditing = false;
                }
            }
        }
    }

    private static void updatePersonalInfo(Applicant applicantToUpdate) {
        
        boolean continueUpdatingPersonalInfo = true;
        boolean isCancelled = false;
        
        // Create a temporary copy of the applicant to make updates without affecting the original
        Applicant tempApplicant = new Applicant(applicantToUpdate.getId(),
                applicantToUpdate.getName(),
                applicantToUpdate.getDateOfBirth(),
                applicantToUpdate.getGender(),
                applicantToUpdate.getAddress(),
                applicantToUpdate.getIc(),
                applicantToUpdate.getPhoneNumber(),
                applicantToUpdate.getEmail(),
                applicantToUpdate.getSocialMedia(),
                applicantToUpdate.getMaritalStatus());

        // Loop to allow the user to update different personal info sections
        while (continueUpdatingPersonalInfo) {
            String[] personalInfoOptions = {
                "Address", "Phone Number", "Email", "Social Media", "Marital Status", "Update All", "Cancel Update"
            };

            // Ask the user which section to update
            String updateChoice = Input.getChoiceInput("\nWhich personal information would you like to update?", personalInfoOptions);

            switch (updateChoice) {
                case "Address" ->
                    tempApplicant.setAddress(Input.getStringInput("\nEnter updated address: "));
                case "Phone Number" ->
                    tempApplicant.setPhoneNumber(Validation.checkPhoneNumber("\nEnter updated phone number (01X-XXXXXXX or 01X-XXXXXXXX): "));
                case "Email" ->
                    tempApplicant.setEmail(Validation.checkEmailFormat("\nEnter updated email (e.g., john@gmail.com): "));
                case "Social Media" ->
                    tempApplicant.setSocialMedia(Validation.checkSocialMedia("\nEnter updated Social Media (e.g., @user_abc): "));
                case "Marital Status" ->
                    tempApplicant.setMaritalStatus(Input.getChoiceInput("\nSelect updated marital status: ", ChooseSetting.MARITAL_STATUSES));
                case "Update All" -> {
                    // Update all sections in one go
                    tempApplicant.setAddress(Input.getStringInput("\nEnter updated address: "));
                    tempApplicant.setPhoneNumber(Validation.checkPhoneNumber("\nEnter updated phone number (01X-XXXXXXX or 01X-XXXXXXXX): "));
                    tempApplicant.setEmail(Validation.checkEmailFormat("\nEnter updated email (e.g., john@gmail.com): "));
                    tempApplicant.setSocialMedia(Validation.checkSocialMedia("\nEnter updated Social Media (e.g., @user_abc): "));
                    tempApplicant.setMaritalStatus(Input.getChoiceInput("\nSelect updated marital status: ", ChooseSetting.MARITAL_STATUSES));
                }
                case "Cancel Update" -> {
                    // If the user chooses to cancel, confirm the action
                    String confirmation = Input.getYesNoInput("Are you sure you want to cancel update & discard all changes? (yes/no): ");
                    if (confirmation.equalsIgnoreCase("yes") || confirmation.equalsIgnoreCase("y")) {
                        MessageUI.cancelSelection();
                        isCancelled = true;  // Set cancelled flag to true
                    }
                }
                default ->
                    MessageUI.errorMessage();
            }

            // If cancelled, exit the loop
            if (isCancelled) {
                continueUpdatingPersonalInfo = false;
            } else if (!Input.getYesNoInput("Would you like to update another section? (yes/no): ").equalsIgnoreCase("yes")) {
                continueUpdatingPersonalInfo = false;
            }
        }

        // If the update was not cancelled, show the updated details
        if (!isCancelled) {
            System.out.println("\n=== Updated Personal Information Summary ===");
            displayPersonalInfo(tempApplicant);

            // Ask the user if they want to apply the changes
            if (Input.getYesNoInput("Apply these changes to your personal info? (yes/no): ").equalsIgnoreCase("yes")) {
                applicantToUpdate.setAddress(tempApplicant.getAddress());
                applicantToUpdate.setPhoneNumber(tempApplicant.getPhoneNumber());
                applicantToUpdate.setEmail(tempApplicant.getEmail());
                applicantToUpdate.setSocialMedia(tempApplicant.getSocialMedia());
                applicantToUpdate.setMaritalStatus(tempApplicant.getMaritalStatus());
                MessageUI.updateSuccessful();
            } else {
                MessageUI.cancelSelection();
            }
        }
    }

    private static void updateApplicantInfo(Applicant applicantToUpdate) {
        
        boolean continueUpdatingApplicantInfo = true;
        boolean isCancelled = false;
        
        // Create a temporary copy of the applicant to make updates without affecting the original
        Applicant tempApplicant = new Applicant(
                applicantToUpdate.getLocation(),
                applicantToUpdate.getPortfolioLink(),
                applicantToUpdate.getPreferredWorkMode(),
                applicantToUpdate.getDesiredJobType(),
                applicantToUpdate.getYearOfExperience(),
                applicantToUpdate.getDesiredSalaryRange(),
                applicantToUpdate.isWillingToRelocate(),
                applicantToUpdate.getAvailability());

        // Loop to allow the user to update different applicant info sections
        while (continueUpdatingApplicantInfo) {
            String[] personalInfoOptions = {
                "Location", "Portfolio Link", "Preferred Work Mode", "Desired Job Type", "Years of Experience",
                "Desired Salary Range", "Willing to Relocate", "Availability", "Update All", "Cancel Update"
            };

            // Ask the user which section to update
            String updateChoice = Input.getChoiceInput("\nWhich applicant information would you like to update?", personalInfoOptions);

            switch (updateChoice) {
                case "Location" ->
                    tempApplicant.setLocation(Input.getChoiceInput("\nSelect updated location: ", ChooseSetting.LOCATION_OPTIONS));
                case "Portfolio Link" ->
                    tempApplicant.setPortfolioLink(getPortfolioLinkInput("\nEnter updated Portfolio Link (e.g., www.example.com): "));
                case "Preferred Work Mode" ->
                    tempApplicant.setPreferredWorkMode(Input.getChoiceInput("\nSelect updated Preferred Work Mode: ", ChooseSetting.WORK_MODES));
                case "Desired Job Type" ->
                    tempApplicant.setDesiredJobType(Input.getChoiceInput("\nSelect updated Desired Job Type: ", ChooseSetting.JOB_TYPES));
                case "Years of Experience" ->
                    tempApplicant.setYearOfExperience(Input.getIntegerInput("\nEnter updated years of experience: "));
                case "Desired Salary Range" ->
                    tempApplicant.setDesiredSalaryRange(Input.getChoiceInput("\nSelect updated Desired Salary Range (Monthly): ", ChooseSetting.SALARY_RANGES));
                case "Willing to Relocate" ->
                    tempApplicant.setWillingToRelocate(Input.getBooleanInput("\nEnter updated willingness to relocate (true/false): "));
                case "Availability" ->
                    tempApplicant.setAvailability(Input.getChoiceInput("\nSelect updated Availability: ", ChooseSetting.AVAILABILITY_OPTIONS));
                case "Update All" -> {
                    // Update all sections in one go
                    Applicant updatedDetails = getApplicantDetails();
                    tempApplicant.setLocation(updatedDetails.getLocation());
                    tempApplicant.setPortfolioLink(updatedDetails.getPortfolioLink());
                    tempApplicant.setPreferredWorkMode(updatedDetails.getPreferredWorkMode());
                    tempApplicant.setDesiredJobType(updatedDetails.getDesiredJobType());
                    tempApplicant.setYearOfExperience(updatedDetails.getYearOfExperience());
                    tempApplicant.setDesiredSalaryRange(updatedDetails.getDesiredSalaryRange());
                    tempApplicant.setWillingToRelocate(updatedDetails.isWillingToRelocate());
                    tempApplicant.setAvailability(updatedDetails.getAvailability());
                }
                case "Cancel Update" -> {
                    // If the user chooses to cancel, confirm the action
                    if (Input.getYesNoInput("Are you sure you want to cancel update & discard all changes? (yes/no): ").equalsIgnoreCase("yes")) {
                        MessageUI.cancelSelection();
                        isCancelled = true;  // Set cancelled flag to true
                    }
                }
                default ->
                    MessageUI.errorMessage();
            }

            // If cancelled, exit the loop
            if (isCancelled) {
                continueUpdatingApplicantInfo = false;
            } else if (!Input.getYesNoInput("Would you like to update another section? (yes/no): ").equalsIgnoreCase("yes")) {
                continueUpdatingApplicantInfo = false;
            }
        }

        // If the update was not cancelled, show the updated details
        if (!isCancelled) {
            System.out.println("\n=== Updated Applicant Information Summary ===");
            System.out.println("Name: " + applicantToUpdate.getName());
            displayApplicantDetails(tempApplicant);

            // Ask the user if they want to apply the changes
            if (Input.getYesNoInput("Apply these changes to your applicant info? (yes/no):").equalsIgnoreCase("yes")) {
                applicantToUpdate.setLocation(tempApplicant.getLocation());
                applicantToUpdate.setPortfolioLink(tempApplicant.getPortfolioLink());
                applicantToUpdate.setPreferredWorkMode(tempApplicant.getPreferredWorkMode());
                applicantToUpdate.setDesiredJobType(tempApplicant.getDesiredJobType());
                applicantToUpdate.setYearOfExperience(tempApplicant.getYearOfExperience());
                applicantToUpdate.setDesiredSalaryRange(tempApplicant.getDesiredSalaryRange());
                applicantToUpdate.setWillingToRelocate(tempApplicant.isWillingToRelocate());
                applicantToUpdate.setAvailability(tempApplicant.getAvailability());
                MessageUI.updateSuccessful();
            } else {
                MessageUI.cancelSelection();
            }
        }
    }

    private static void updateResume(Applicant applicantToUpdate) {
        boolean continueUpdatingResume = true;
        boolean isCancelled = false;        

        // Create a temporary copy of the resume to make updates without affecting the original
        Resume currentResume = applicantToUpdate.getResume();
        Resume updatedResume = new Resume(
                currentResume.getEducationLevel(),
                currentResume.getSkills(),
                currentResume.getExperience(),
                currentResume.getCertifications(),
                currentResume.getProjects(),
                currentResume.getLanguagesSpoken(),
                currentResume.getAwards()
        );

        // Loop to allow the user to update different resume sections
        while (continueUpdatingResume) {
            String[] resumeUpdateOptions = {
                "Education Level",
                "Skills",
                "Work Experience",
                "Certifications",
                "Projects",
                "Languages Spoken",
                "Awards",
                "Update All",
                "Cancel Update" // New option to cancel the update
            };

            // Ask the user which section to update
            String updateChoice = Input.getChoiceInput("\nWhich resume section would you like to update?", resumeUpdateOptions);

            switch (updateChoice) {
                case "Education Level" ->
                    updatedResume.setEducationLevel(Input.getChoiceInput("\nSelect updated Education Level: ", ChooseSetting.EDUCATION_LEVELS));
                // ==========================================================================================================================================================================
                case "Skills" ->
                    updatedResume.setSkills(Input.getMultipleChoiceInput("Select Skills: ", ChooseSetting.SKILL_OPTIONS));
                case "Work Experience" ->
                    updatedResume.setExperience(Input.getStringListInput("Enter updated Work Experience (comma-separated): "));
                case "Certifications" ->
                    updatedResume.setCertifications(Input.getStringListInput("Enter updated Certifications (comma-separated): "));
                case "Projects" ->
                    updatedResume.setProjects(Input.getStringListInput("Enter updated Projects (comma-separated): "));
                case "Languages Spoken" ->
                    updatedResume.setLanguagesSpoken(Input.getMultipleChoiceInput("Select updated Languages Spoken: ", ChooseSetting.LANGUAGE_OPTIONS));
                case "Awards" ->
                    updatedResume.setAwards(Input.getStringListInput("Enter updated Awards (comma-separated): "));
                case "Update All" -> {
                    // Update all sections in one go by gathering all new details
                    updatedResume = getResumeDetails();
                }
                case "Cancel Update" -> {
                    // If the user chooses to cancel, confirm the action
                    if (Input.getYesNoInput("Are you sure you want to cancel update & discard all changes? (yes/no): ").equalsIgnoreCase("yes")) {
                        MessageUI.cancelSelection();
                        isCancelled = true;  // Set cancelled flag to true
                    }
                }
                default ->
                    MessageUI.errorMessage();
            }

            // If cancelled, exit the loop
            if (isCancelled) {
                continueUpdatingResume = false;
            } else if (!Input.getYesNoInput("Would you like to update another section? (yes/no): ").equalsIgnoreCase("yes")) {
                continueUpdatingResume = false;
            }
        }

        // If the update was not cancelled, show the updated resume summary
        if (!isCancelled) {
            System.out.println("\n=== Updated Resume Summary ===");
            System.out.println("Name: " + applicantToUpdate.getName());
            displayResumeDetails(updatedResume);

            // Ask the user if they want to apply the changes
            if (Input.getYesNoInput("Apply these changes to your resume? (yes/no):").equalsIgnoreCase("yes")) {
                applicantToUpdate.setResume(updatedResume);
                MessageUI.updateSuccessful();
            } else {
                MessageUI.cancelSelection();
            }
        }
    }

    // ========== DELETE ==========
    public static void deleteAccount() {

        Applicant applicantToRemove = Database.getApplicant();

        if (applicantToRemove == null) {
            emptyApplicantMessage();
            return;
        }

        System.out.println("\nApplicant details:");
        System.out.println("Name: " + applicantToRemove.getName());
        System.out.println("ApplicantID: " + applicantToRemove.getId());
        String confirmRemove = Input.getYesNoInput("Are you sure you want to delete this account? (yes/no): ");

        if (confirmRemove.equalsIgnoreCase("yes")) {
            try {
                Database.applicants.remove(applicantToRemove); //global
                applicantList.remove(applicantToRemove);//local
                MessageUI.deleteSuccessful();
            } catch (Exception e) {
                MessageUI.removeFailed();
            }
        } else {
            MessageUI.cancelSelection();
        }
    }

    // ========== READ ==========
    public static void viewDetails() {

        Applicant applicantToView = Database.getApplicant();

        if (applicantToView == null) {
            emptyApplicantMessage();
            return;
        }
        
        ApplicantUI.viewApplicantDetailsHeader();

        Resume currentResume = applicantToView.getResume();
        displayPersonalInfo(applicantToView);
        
        System.out.println();
        displayApplicantDetails(applicantToView);
        System.out.println();
        displayResumeDetails(currentResume);
        System.out.println();
    }

    // ========== FILTER ==========
    public static void filterApplicant() {

        boolean continueFilter;

        do {
            String[] filterOptions = {
                "Years of Experience",
                "Desired Job Type",
                "Preferred Work Mode",
                "Availability",
                "All of the Above",
                "Any of the Above",
                "Cancel"
            };

            String choiceStr = Input.getChoiceInput("Select the criteria to filter by:", filterOptions);

            if (choiceStr.equalsIgnoreCase("Cancel")) {
                System.out.println("Filtering process cancelled.");
                break;
            }

            // Initialize filters
            int minYears = 0;
            String desiredJobType = null;
            String preferredWorkMode = null;
            String availability = null;

            // Get filtering criteria
            switch (choiceStr) {
                case "Years of Experience" ->
                    minYears = Input.getIntegerInput("Enter minimum years of experience: ");
                case "Desired Job Type" ->
                    desiredJobType = Input.getChoiceInput("Select applicant's desired job type:", ChooseSetting.JOB_TYPES);
                case "Preferred Work Mode" ->
                    preferredWorkMode = Input.getChoiceInput("Select applicant's preferred work mode:", ChooseSetting.WORK_MODES);
                case "Availability" ->
                    availability = Input.getChoiceInput("Select applicant's availability:", ChooseSetting.AVAILABILITY_OPTIONS);
                case "All of the Above", "Any of the Above" -> {
                    minYears = Input.getIntegerInput("Enter minimum years of experience: ");
                    desiredJobType = Input.getChoiceInput("Select applicant's desired job type:", ChooseSetting.JOB_TYPES);
                    preferredWorkMode = Input.getChoiceInput("Select applicant's preferred work mode:", ChooseSetting.WORK_MODES);
                    availability = Input.getChoiceInput("Select applicant's availability:", ChooseSetting.AVAILABILITY_OPTIONS);
                }
                default -> {
                    System.out.println("Invalid selection.");
                    return;
                }
            }

            System.out.println("=====================================");
            System.out.println("        Matched Applicants Overview");
            System.out.println("=====================================");

            DoublyLinkedList<Applicant> matchedApplicants = getMatchedApplicants(choiceStr, minYears, desiredJobType, preferredWorkMode, availability);

            if (matchedApplicants.isEmpty()) {
                System.out.println("No applicants matched your criteria.");
            } else {
                int selectedNo = Input.getIntegerInput("\nEnter Applicant No. to view details (0 to cancel): ");
                if (selectedNo > 0 && selectedNo <= matchedApplicants.size()) {
                    Tools.clearScreen();
                    displayEssentialInfo(matchedApplicants.get(selectedNo - 1)); // Assuming 0-indexed get
                } else if (selectedNo == 0) {
                    System.out.println("Cancelled.");
                } else {
                    System.out.println("Invalid number.");
                }
            }

            String continueChoice = Input.getYesNoInput("Do you want to continue filtering? (Y/N): ");
            continueFilter = continueChoice.equalsIgnoreCase("yes");

        } while (continueFilter);
    }

    private static DoublyLinkedList<Applicant> getMatchedApplicants(String choiceStr, int minYears, String jobType, String workMode, String availability) {
        DoublyLinkedList<Applicant> matched = new DoublyLinkedList<>();
        int count = 0;

        for (Applicant applicant : Database.applicants) {
            boolean matchExperience = applicant.getYearOfExperience() >= minYears;
            boolean matchJobType = jobType == null || applicant.getDesiredJobType().equalsIgnoreCase(jobType);
            boolean matchWorkMode = workMode == null || applicant.getPreferredWorkMode().equalsIgnoreCase(workMode);
            boolean matchAvailability = availability == null || applicant.getAvailability().equalsIgnoreCase(availability);

            boolean showApplicant = switch (choiceStr) {
                case "Years of Experience" ->
                    matchExperience;
                case "Desired Job Type" ->
                    matchJobType;
                case "Preferred Work Mode" ->
                    matchWorkMode;
                case "Availability" ->
                    matchAvailability;
                case "All of the Above" ->
                    matchExperience && matchJobType && matchWorkMode && matchAvailability;
                case "Any of the Above" ->
                    matchExperience || matchJobType || matchWorkMode || matchAvailability;
                default ->
                    false;
            };

            if (showApplicant) {
                count++;
                printApplicantSummary(count, applicant, choiceStr, minYears, jobType, workMode, availability);
                matched.add(applicant);
            }
        }

        return matched;
    }

    private static void printApplicantSummary(int no, Applicant applicant, String choice, int minYears, String jobType, String workMode, String availability) {
        System.out.println("\nNo." + no + "  Name: " + applicant.getName());
        System.out.println("      Job Type: " + applicant.getDesiredJobType());
        System.out.println("      Work Mode: " + applicant.getPreferredWorkMode());
        System.out.println("      Experience: " + applicant.getYearOfExperience() + " years");
        System.out.println("      Availability: " + applicant.getAvailability());

        System.out.print(PURPLE+"      Filter by: "+RESET);
        if (choice.equals("All of the Above") || choice.equals("Any of the Above")) {
            if (minYears > 0) {
                System.out.print("[Experience: " + minYears + " years] ");
            }
            if (jobType != null) {
                System.out.print("[Job Type: " + jobType + "] ");
            }
            if (workMode != null) {
                System.out.print("[Work Mode: " + workMode + "] ");
            }
            if (availability != null) {
                System.out.print("[Availability: " + availability + "] ");
            }
        } else {
            switch (choice) {
                case "Years of Experience" ->
                    System.out.print("[Experience: " + minYears + " years]");
                case "Desired Job Type" ->
                    System.out.print("[Job Type: " + jobType + "]");
                case "Preferred Work Mode" ->
                    System.out.print("[Work Mode: " + workMode + "]");
                case "Availability" ->
                    System.out.print("[Availability: " + availability + "]");
            }
        }
        System.out.println();
    }

    // ========== SEARCH ==========
    public static void searchResume(String searchTerm) {
        ListInterface<Applicant> matchedApplicants = new DoublyLinkedList<>();
        searchTerm = searchTerm.toLowerCase();

        for (int i = 0; i < Database.applicants.size(); i++) {
            Applicant applicant = Database.applicants.get(i);
            Resume resume = applicant.getResume();
            boolean applicantMatched = false;

            applicantMatched |= containsMatch(resume.getEducationLevel(), searchTerm);
            applicantMatched |= containsMatchInList(resume.getExperience(), searchTerm);
            applicantMatched |= containsMatchInList(resume.getSkills(), searchTerm);
            applicantMatched |= containsMatchInList(resume.getCertifications(), searchTerm);
            applicantMatched |= containsMatchInList(resume.getProjects(), searchTerm);
            applicantMatched |= containsMatchInList(resume.getLanguagesSpoken(), searchTerm);
            applicantMatched |= containsMatchInList(resume.getAwards(), searchTerm);

            if (applicantMatched) {
                matchedApplicants.add(applicant);
            }
        }

        if (matchedApplicants.isEmpty()) {
            System.out.println("No matches found for: " + searchTerm);
            return;
        }

        System.out.println(PURPLE+"\nTotal matches found: " + matchedApplicants.size()+RESET);
        System.out.println("---------------------------------------------------");

        int index = 1;
        for (int i = 0; i < matchedApplicants.size(); i++) {
            Applicant applicant = matchedApplicants.get(i);
            Resume resume = applicant.getResume();
            System.out.println(index + ". " + applicant.getName() + " (" + applicant.getEmail() + ")");
            boolean foundMatch = false;

            // Print matching fields
            foundMatch |= printMatchedField(resume, searchTerm, "Education Level");
            foundMatch |= printMatchedField(resume, searchTerm, "Work Experience");
            foundMatch |= printMatchedField(resume, searchTerm, "Skills");
            foundMatch |= printMatchedField(resume, searchTerm, "Certifications");
            foundMatch |= printMatchedField(resume, searchTerm, "Projects");
            foundMatch |= printMatchedField(resume, searchTerm, "Languages Spoken");
            foundMatch |= printMatchedField(resume, searchTerm, "Awards");

            if (!foundMatch) {
                System.out.println("   No matches found.");
            }

            index++;
        }

        int choice = Input.getIntegerInput("\nEnter the number of the applicant you want full details for (or 0 to cancel): ");
        if (choice > 0 && choice <= matchedApplicants.size()) {
            Applicant selectedApplicant = matchedApplicants.get(choice - 1);
            displayEssentialInfo(selectedApplicant); // Show full resume
        } else {
            System.out.println("No details displayed.");
        }
    }

    //for String
    private static boolean containsMatch(String value, String searchTerm) {
        return value != null && value.toLowerCase().contains(searchTerm);
    }

    //for ListInterface
    private static boolean containsMatchInList(ListInterface<String> list, String searchTerm) {
        for (String item : list) {
            if (item.toLowerCase().contains(searchTerm)) {
                return true;
            }
        }
        return false;
    }

    // Print matched fields
    private static boolean printMatchedField(Resume resume, String searchTerm, String fieldName) {
        boolean matchFound = false;

        switch (fieldName) {
            case "Education Level" -> {
                String education = resume.getEducationLevel();
                if (education != null && education.toLowerCase().contains(searchTerm)) {
                    System.out.println(PURPLE + "   Found in Education Level: " + RESET + education);
                    matchFound = true;
                }
            }
            case "Work Experience" -> {
                for (String exp : resume.getExperience()) {
                    if (exp.toLowerCase().contains(searchTerm)) {
                        System.out.println(PURPLE + "   Found in Work Experience: " + RESET + exp);
                        matchFound = true;
                    }
                }
            }
            case "Skills" -> {
                for (String skill : resume.getSkills()) {
                    if (skill.toLowerCase().contains(searchTerm)) {
                        System.out.println(PURPLE + "   Found in Skills: " + RESET + skill);
                        matchFound = true;
                    }
                }
            }
            case "Certifications" -> {
                for (String cert : resume.getCertifications()) {
                    if (cert.toLowerCase().contains(searchTerm)) {
                        System.out.println(PURPLE + "   Found in Certifications: " + RESET + cert);
                        matchFound = true;
                    }
                }
            }
            case "Projects" -> {
                for (String project : resume.getProjects()) {
                    if (project.toLowerCase().contains(searchTerm)) {
                        System.out.println(PURPLE + "   Found in Projects: " + RESET + project);
                        matchFound = true;
                    }
                }
            }
            case "Languages Spoken" -> {
                for (String lang : resume.getLanguagesSpoken()) {
                    if (lang.toLowerCase().contains(searchTerm)) {
                        System.out.println(PURPLE + "   Found in Languages Spoken: " + RESET + lang);
                        matchFound = true;
                    }
                }
            }
            case "Awards" -> {
                for (String award : resume.getAwards()) {
                    if (award.toLowerCase().contains(searchTerm)) {
                        System.out.println(PURPLE + "   Found in Awards: " + RESET + award);
                        matchFound = true;
                    }
                }
            }
        }

        return matchFound;
    }

    // ========== INPUT HELPERs ==========
    /*1. Applicant-specific Details*/
    private static Applicant getApplicantDetails() {
        String location = Input.getChoiceInput("\nSelect your location: ", ChooseSetting.LOCATION_OPTIONS);
        String portfolioLink = getPortfolioLinkInput("\nEnter your Portfolio Link(e.g., www.example.com): ");
        String preferredWorkMode = Input.getChoiceInput("\nSelect your Preferred Work Mode: ", ChooseSetting.WORK_MODES);
        String desiredJobType = Input.getChoiceInput("\nSelect your preferred job type:", ChooseSetting.JOB_TYPES);
        int yearOfExperience = Input.getIntegerInput("\nEnter your years of experience: ");
        String desiredSalaryRange = Input.getChoiceInput("\nSelect your Desired Salary Range(Monthly): ", ChooseSetting.SALARY_RANGES);
        boolean willingToRelocate = Input.getBooleanInput("\nEnter willing to recollate(true/false): ");
        String availability = Input.getChoiceInput("\nSelect Availability: ", ChooseSetting.AVAILABILITY_OPTIONS);

        Applicant applicant = new Applicant(location, portfolioLink, preferredWorkMode, desiredJobType, yearOfExperience,
                desiredSalaryRange, willingToRelocate, availability);

        return applicant;
    }

    /*2. Resume Details*/
    private static Resume getResumeDetails() {
        String educationLevel = Input.getChoiceInput("\nSelect Education Level: ", ChooseSetting.EDUCATION_LEVELS);
        ListInterface<String> skills = Input.getPaginatedMultiSelectInput("Select Skills: ", ChooseSetting.SKILL_OPTIONS);
        ListInterface<String> experience = Input.getStringListInput("\nEnter Work Experience (comma-separated): ");
        ListInterface<String> certifications = Input.getStringListInput("\nEnter Certifications (comma-separated): ");
        ListInterface<String> projects = Input.getStringListInput("\nEnter Projects (comma-separated): ");
        ListInterface<String> languagesSpoken = Input.getMultipleChoiceInput("\nSelect Languages Spoken: ", ChooseSetting.LANGUAGE_OPTIONS);
        ListInterface<String> awards = Input.getStringListInput("\nEnter Awards (comma-separated): ");

        Resume resume = new Resume(educationLevel, skills, experience, certifications, projects, languagesSpoken, awards);
        return resume;
    }

    // ========== DISPLAY HELPERS ==========
    /*1. Personal Information*/
    private static void displayPersonalInfo(Applicant applicant) {
        System.out.println(BLUE + "----- Personal Information -----" + RESET);
        System.out.println("ApplicantID     : " + applicant.getId());
        System.out.println("Name            : " + applicant.getName());
        System.out.println("Date of Birth   : " + applicant.getDateOfBirth());
        System.out.println("Gender          : " + applicant.getGender());
        System.out.println("Address         : " + applicant.getAddress());
        System.out.println("IC              : " + applicant.getIc());
        System.out.println("Phone Number    : " + applicant.getPhoneNumber());
        System.out.println("Email           : " + applicant.getEmail());
        System.out.println("Social Media    : " + applicant.getSocialMedia());
        System.out.println("Marital Status  : " + applicant.getMaritalStatus());
        System.out.println();
    }

    /*2. Applicant-specific Details*/
    private static void displayApplicantDetails(Applicant applicant) {
        System.out.println(BLUE + "----- Applicant-specific Details -----" + RESET);
        System.out.println("Location             : " + applicant.getLocation());
        System.out.println("Portfolio Link       : " + applicant.getPortfolioLink());
        System.out.println("Preferred Work Mode  : " + applicant.getPreferredWorkMode());
        System.out.println("Desired Job Type     : " + applicant.getDesiredJobType());
        System.out.println("Years of Experience  : " + applicant.getYearOfExperience());
        System.out.println("Desired Salary Range : " + applicant.getDesiredSalaryRange());
        System.out.println("Willing to Relocate  : " + (applicant.isWillingToRelocate() ? "Yes" : "No"));
        System.out.println("Availability         : " + applicant.getAvailability());
    }

    /*3. Resume Details*/
    private static void displayResumeDetails(Resume resume) {
        System.out.println(BLUE + "----- Resume Details -----" + RESET);
        System.out.println("Education Level: " + resume.getEducationLevel());
        printMultiLine("\nSkills", resume.getSkills());
        printMultiLine("\nWork Experience", resume.getExperience());
        printMultiLine("\nCertifications", resume.getCertifications());
        printMultiLine("\nProjects", resume.getProjects());
        printMultiLine("\nLanguages Spoken", resume.getLanguagesSpoken());
        printMultiLine("\nAwards", resume.getAwards());
    }

    /*4. Filter Details*/
    private static void displayEssentialInfo(Applicant applicant) {
        System.out.println("=====================================");
        System.out.println("         Applicant Resume Overview");
        System.out.println("=====================================");
        System.out.println("Name        : " + applicant.getName());
        System.out.println("-------------------------------------");

        System.out.println(BLUE + "\n***** Resume Details *****" + RESET);
        Resume resume = applicant.getResume();
        System.out.println("Education Level    : " + resume.getEducationLevel());
        printMultiLine("\nSkills", resume.getSkills());
        printMultiLine("\nWork Experience", resume.getExperience());
        printMultiLine("\nProjects", resume.getProjects());

        System.out.println(BLUE + "\n***** Contact Information *****" + RESET);
        System.out.println("Phone       : " + applicant.getPhoneNumber());
        System.out.println("Email       : " + applicant.getEmail());
        System.out.println("Location    : " + applicant.getLocation());
        System.out.println("Portfolio   : " + applicant.getPortfolioLink());
        System.out.println();
    }

    /*5. MultiLine*/
    private static void printMultiLine(String label, ListInterface<String> dataList) {
        System.out.println(label + " :" + RESET);
        for (String data : dataList) {
            System.out.println("  - " + data);
        }
    }

    // ========== VALIDATION HELPERS ==========
    /*name exists*/
    private static boolean isNameExists(String applicantName) {
        for (int i = 0; i < applicantList.size(); i++) { //local
            if (applicantList.get(i).getName().equalsIgnoreCase(applicantName)) {
                return true;
            }
        }

        for (int i = 0; i < Database.applicants.size(); i++) {//global
            if (Database.applicants.get(i).getName().equalsIgnoreCase(applicantName)) {
                return true;
            }
        }

        return false;
    }

    /*portfolioLink*/
    private static String getPortfolioLinkInput(String question) {
        String portfolioLink = Input.getStringInput(question);

        while (!portfolioLink.startsWith("www.") || !portfolioLink.endsWith(".com") || portfolioLink.substring(4, portfolioLink.length() - 4).isEmpty()) {
            System.out.println(RED + "Invalid link! Please ensure the link starts with 'www.', ends with '.com', and has characters in between." + RESET);
            portfolioLink = Input.getStringInput(question);
        }

        return portfolioLink;
    }
    
    public static void displayAllApplicants() {
        Tools.clearScreen();
        UserUI.headLine();
        System.out.println("\n=== Display All Applicants ===");

        // Check if there are any applicants in DataStore
        if (Database.applicants.isEmpty()) {
            System.out.println("No applicants found in the system.");
            return; // Exit the method if no applicants exist
        }

        // Iterate over each applicant in DataStore and display their details
        for (Applicant applicant : Database.applicants) {
            System.out.println("\n" + applicant.getName() + " -->");
            System.out.println("Phone: " + applicant.getPhoneNumber());
            System.out.println("Email: " + applicant.getEmail());
            System.out.println("=========================================");
        }
    }
}
