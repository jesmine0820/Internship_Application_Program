package Control;

import Entity.*;
import Utility.*;
import Dao.*;
import java.util.Date;
import ADT.*;
import Boundary.JobUI;
import Boundary.UserUI;
import static Utility.Tools.*;

/**
 *
 * @author Kit Chin Jie Ying
 *
 */
public class EmployerManager {

    private static final ListInterface<Employer> employerList = new DoublyLinkedList<>();
    private static final ListInterface<Company> companyList = new DoublyLinkedList<>();

    public static void jobPosting() {
        int choice;
        do {
            choice = JobUI.employerMenu();
            switch (choice) {
                case 1 ->
                    JobManager.createJob();
                case 2 ->
                    JobManager.updateJob();
                case 3 ->
                    JobManager.deleteJob();
                case 4 ->
                    JobManager.displayJobDetails();
                case 5 ->
                    JobManager.displayMyJob(Database.getEmployer());
                case 6 ->
                    JobManager.filterJob();
                case 7 ->
                    JobManager.searchJobsByEmployerOrCompany();
                case 8 ->
                    Tools.back();
                default ->
                    MessageUI.errorMessage();
            }
        } while (choice != 7);
    }

    public static Employer compareEmployerEmail(String email) {
        for (Employer currentEmployer : Database.employers) {  // Enhanced for loop
            if (currentEmployer.getEmail().equalsIgnoreCase(email)) {
                System.out.println(RED + "Email already registered." + RESET);
                return currentEmployer;
            }
        }
        return null;
    }

    public static void registerEmployer() {

        Tools.clearScreen();
        UserUI.headLine();

        System.out.println("==========================");
        System.out.println("=    Employer Register   =");
        System.out.println("==========================");

        boolean continueRegistering = true;

        while (continueRegistering) {

            System.out.println("Available Companies:");
            for (int i = 0; i < Database.companies.size(); i++) {
                System.out.println((i + 1) + ". " + Database.companies.get(i).getCompanyName());
            }

            int companyChoice = Input.getIntegerInput("Select a company by number (enter 0 to create a new company): ");
            Company selectedCompany;

            if (companyChoice == 0) {
                selectedCompany = registerCompany();
            } else {
                selectedCompany = Database.companies.get(companyChoice - 1);
            }

            Tools.clearScreen();
            UserUI.headLine();
            System.out.println(" =======================================");
            System.out.println("= Employer Register as " + selectedCompany.getCompanyName() + " =");
            System.out.println(" =======================================");

            String id = String.format("E%03d", Database.employers.size() + 1);
            System.out.println("Generated Employer ID: " + id);

            String name = Input.getStringInput("Enter Name: ");
            Date dateOfBirth = Validation.checkDate("Enter Date of Birth (YYYY-MM-dd): ");
            String gender = Input.getStringInput("Enter Gender: ");
            String address = Input.getStringInput("Enter Address: ");
            String ic = Validation.checkIcInput("Enter IC: ");
            String phoneNumber = Validation.checkPhoneNumber("Enter Phone Number: ");
            String email = Validation.checkEmailFormat("Enter Email: ");
            if (compareEmployerEmail(email) != null) {
                System.out.println("Duplicate employer email detected.");
                return;
            }

            String socialMedia = Input.getStringInput("Enter Social Media: ");
            String maritalStatus = Input.getChoiceInput("Enter Marital Status: ", ChooseSetting.MARITAL_STATUSES);
            String department = Input.getStringInput("Enter Department: ");
            String position = Input.getStringInput("Enter Position: ");
            Date joinedDate = Validation.checkDate("Enter Joined Date (YYYY-MM-dd): ");
            int yearOfExperience = Input.getIntegerInput("Enter Years of Experience: ");

            // Display list of existing companies
            System.out.println("Available Companies:");
            for (int i = 0; i < Database.companies.size(); i++) {
                System.out.println((i + 1) + ". " + Database.companies.get(i).getCompanyName());
            }

            if (id == null || name == null || dateOfBirth == null || gender == null
                    || address == null || ic == null || phoneNumber == null || email == null
                    || socialMedia == null || maritalStatus == null
                    || department == null || position == null || joinedDate == null || selectedCompany == null) {
                System.out.println("Some required fields are empty.");
                return;
            }

            boolean editing = true;
            while (editing) {
                System.out.println("\nPlease review the employer information:");
                System.out.println("==============================================");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Date of Birth: " + dateOfBirth);
                System.out.println("Gender: " + gender);
                System.out.println("Address: " + address);
                System.out.println("IC: " + ic);
                System.out.println("Phone Number: " + phoneNumber);
                System.out.println("Email: " + email);
                System.out.println("Social Media: " + socialMedia);
                System.out.println("Marital Status: " + maritalStatus);
                System.out.println("Department: " + department);
                System.out.println("Position: " + position);
                System.out.println("Joined Date: " + joinedDate);
                System.out.println("Years of Experience: " + yearOfExperience);
                System.out.println("Company: ");
                displayCompany(selectedCompany);
                System.out.println("==============================================");

                String confirmInfo = Input.getYesNoInput(BLUE + "\nDo you confirm the employer information? (yes/no): " + RESET);
                if (confirmInfo.equalsIgnoreCase("yes") || confirmInfo.equalsIgnoreCase("y")) {
                    editing = false;
                    break;
                }

                System.out.println("\nWhich attribute do you want to change?");
                System.out.println("1. Name");
                System.out.println("2. Date of Birth");
                System.out.println("3. Gender");
                System.out.println("4. Address");
                System.out.println("5. IC");
                System.out.println("6. Phone Number");
                System.out.println("7. Email");
                System.out.println("8. Social Media");
                System.out.println("9. Marital Status");
                System.out.println("10. Department");
                System.out.println("11. Position");
                System.out.println("12. Joined Date");
                System.out.println("13. Years of Experience");
                System.out.println("14. Company");
                System.out.println("15. Done Editing");

                int choice = Input.getIntegerInput("Enter your choice: ");
                switch (choice) {
                    case 1 ->
                        name = Input.getStringInput("Enter new Name: ");
                    case 2 ->
                        dateOfBirth = Validation.checkDate("Enter new Date of Birth (YYYY-MM-dd): ");
                    case 3 ->
                        gender = Input.getStringInput("Enter new Gender: ");
                    case 4 ->
                        address = Input.getStringInput("Enter new Address: ");
                    case 5 ->
                        ic = Validation.checkIcInput("Enter new IC: ");
                    case 6 ->
                        phoneNumber = Validation.checkPhoneNumber("Enter new Phone Number: ");
                    case 7 ->
                        email = Validation.checkEmailFormat("Enter new Email: ");
                    case 8 ->
                        socialMedia = Input.getStringInput("Enter new Social Media: ");
                    case 9 ->
                        maritalStatus = Input.getChoiceInput("Enter new Marital Status: ", ChooseSetting.MARITAL_STATUSES);
                    case 10 ->
                        department = Input.getStringInput("Enter new Department: ");
                    case 11 ->
                        position = Input.getStringInput("Enter new Position: ");
                    case 12 ->
                        joinedDate = Validation.checkDate("Enter new Joined Date (YYYY-MM-dd): ");
                    case 13 ->
                        yearOfExperience = Input.getIntegerInput("Enter new Years of Experience: ");
                    case 14 -> {
                        // Display existing companies
                        for (int i = 0; i < Database.companies.size(); i++) {
                            System.out.println((i + 1) + ". " + Database.companies.get(i).getCompanyName());
                        }

                        companyChoice = Input.getIntegerInput("Select a company by number (enter 0 to create a new company): ");

                        if (companyChoice == 0) {
                            selectedCompany = registerCompany();
                        } else if (companyChoice > 0 && companyChoice <= Database.companies.size()) {
                            selectedCompany = Database.companies.get(companyChoice - 1);
                        } else {
                            System.out.println(RED + "Invalid company selection." + RESET);
                            break;
                        }
                    }
                    case 15 ->
                        editing = false;
                    default ->
                        System.out.println(RED + "Invalid choice. Please try again." + RESET);
                }
            }

            String confirmRegister = Input.getYesNoInput("\nDo you confirm to register this employer? (yes/no): ");
            if (!(confirmRegister.equalsIgnoreCase("yes") || confirmRegister.equalsIgnoreCase("y"))) {
                System.out.println(RED + "Employer registration cancelled." + RESET);
                continue;
            }

            Employer newEmployer = new Employer(id, name, dateOfBirth, gender, address, ic, phoneNumber, email, socialMedia, maritalStatus, department, position, joinedDate, yearOfExperience, null, null, selectedCompany);
            employerList.add(newEmployer);
            Database.employers.add(newEmployer);
            MessageUI.createSuccessful();
            displayEmployer(newEmployer);
            selectedCompany.incrementEmployeeCount();

            String another = Input.getYesNoInput("\n\nDo you want to register another employer? (yes/no): ");
            if (!(another.equalsIgnoreCase("yes") || another.equalsIgnoreCase("y"))) {
                continueRegistering = false;
                UserUI.loginUI();
            }
        }
    }

    public static void editEmployerProfile() {
        Tools.clearScreen();
        UserUI.headLine();

        System.out.println("==============================");
        System.out.println("|   Update Employer Profile  |");
        System.out.println("==============================");

        Employer editEmployer = Database.getEmployer();

        // Store original values
        String originalName = editEmployer.getName();
        Date originalDob = editEmployer.getDateOfBirth();
        String originalGender = editEmployer.getGender();
        String originalAddress = editEmployer.getAddress();
        String originalIc = editEmployer.getIc();
        String originalPhone = editEmployer.getPhoneNumber();
        String originalEmail = editEmployer.getEmail();
        String originalSocial = editEmployer.getSocialMedia();
        String originalMarital = editEmployer.getMaritalStatus();
        String originalDepartment = editEmployer.getDepartment();
        String originalPosition = editEmployer.getPosition();
        Date originalJoined = editEmployer.getJoinedDate();
        int originalExperience = editEmployer.getYearOfExperience();

        boolean updating = true;
        while (updating) {
            System.out.println("\n------------------------------------------------------------------------------");
            System.out.printf("| %-3s | %-25s | %-40s |\n", "No.", "Field", "Current Value");
            System.out.println("------------------------------------------------------------------------------");
            System.out.printf("| %-3d | %-25s | %-40s |\n", 1, "ID", editEmployer.getId());
            System.out.printf("| %-3d | %-25s | %-40s |\n", 2, "Name", editEmployer.getName());
            System.out.printf("| %-3d | %-25s | %-40s |\n", 3, "Date of Birth", editEmployer.getDateOfBirth());
            System.out.printf("| %-3d | %-25s | %-40s |\n", 4, "Gender", editEmployer.getGender());
            System.out.printf("| %-3d | %-25s | %-40s |\n", 5, "Address", editEmployer.getAddress());
            System.out.printf("| %-3d | %-25s | %-40s |\n", 6, "IC", editEmployer.getIc());
            System.out.printf("| %-3d | %-25s | %-40s |\n", 7, "Phone Number", editEmployer.getPhoneNumber());
            System.out.printf("| %-3d | %-25s | %-40s |\n", 8, "Email", editEmployer.getEmail());
            System.out.printf("| %-3d | %-25s | %-40s |\n", 9, "Social Media", editEmployer.getSocialMedia());
            System.out.printf("| %-3d | %-25s | %-40s |\n", 10, "Marital Status", editEmployer.getMaritalStatus());
            System.out.printf("| %-3d | %-25s | %-40s |\n", 11, "Department", editEmployer.getDepartment());
            System.out.printf("| %-3d | %-25s | %-40s |\n", 12, "Position", editEmployer.getPosition());
            System.out.printf("| %-3d | %-25s | %-40s |\n", 13, "Joined Date", editEmployer.getJoinedDate());
            System.out.printf("| %-3d | %-25s | %-40s |\n", 14, "Years of Experience", editEmployer.getYearOfExperience());
            System.out.printf("| %-3d | %-25s | %-40s |\n", 15, "Company", editEmployer.getCompany().getCompanyName());
            System.out.println("------------------------------------------------------------------------------");

            int choice = Input.getIntegerInput("Choose an attribute to update (2-14): ");

            switch (choice) {
                case 2 ->
                    editEmployer.setName(Input.getStringInput("Enter new Name: "));
                case 3 ->
                    editEmployer.setDateOfBirth(Validation.checkDate("Enter new Date of Birth (YYYY-MM-dd): "));
                case 4 ->
                    editEmployer.setGender(Input.getStringInput("Enter new Gender: "));
                case 5 ->
                    editEmployer.setAddress(Input.getStringInput("Enter new Address: "));
                case 6 ->
                    editEmployer.setIc(Validation.checkIcInput("Enter new IC: "));
                case 7 ->
                    editEmployer.setPhoneNumber(Validation.checkPhoneNumber("Enter new Phone Number: "));
                case 8 ->
                    editEmployer.setEmail(Validation.checkEmailFormat("Enter new Email: "));
                case 9 ->
                    editEmployer.setSocialMedia(Input.getStringInput("Enter new Social Media: "));
                case 10 ->
                    editEmployer.setMaritalStatus(Input.getChoiceInput("Enter new Marital Status: ", ChooseSetting.MARITAL_STATUSES));
                case 11 ->
                    editEmployer.setDepartment(Input.getStringInput("Enter new Department: "));
                case 12 ->
                    editEmployer.setPosition(Input.getStringInput("Enter new Position: "));
                case 13 ->
                    editEmployer.setJoinedDate(Validation.checkDate("Enter new Joined Date (YYYY-MM-dd): "));
                case 14 ->
                    editEmployer.setYearOfExperience(Input.getIntegerInput("Enter new Years of Experience: "));
                default ->
                    System.out.println("\nInvalid choice! Please select a valid option.");
            }

            int anotherUpdate = Input.getIntegerInput("Would you like to update another field? (1 = Yes, 2 = No): ");
            if (anotherUpdate == 2) {
                updating = false;
            }

            System.out.println();
            System.out.println("-----------------------------------------------------------");
            if (!editEmployer.getName().equals(originalName)) {
                System.out.printf("%-25s: %s -> %s\n", "Name", originalName, editEmployer.getName());
            }
            if (!editEmployer.getDateOfBirth().equals(originalDob)) {
                System.out.printf("%-25s: %s -> %s\n", "Date of Birth", originalDob, editEmployer.getDateOfBirth());
            }
            if (!editEmployer.getGender().equals(originalGender)) {
                System.out.printf("%-25s: %s -> %s\n", "Gender", originalGender, editEmployer.getGender());
            }
            if (!editEmployer.getAddress().equals(originalAddress)) {
                System.out.printf("%-25s: %s -> %s\n", "Address", originalAddress, editEmployer.getAddress());
            }
            if (!editEmployer.getIc().equals(originalIc)) {
                System.out.printf("%-25s: %s -> %s\n", "IC", originalIc, editEmployer.getIc());
            }
            if (!editEmployer.getPhoneNumber().equals(originalPhone)) {
                System.out.printf("%-25s: %s -> %s\n", "Phone Number", originalPhone, editEmployer.getPhoneNumber());
            }
            if (!editEmployer.getEmail().equals(originalEmail)) {
                System.out.printf("%-25s: %s -> %s\n", "Email", originalEmail, editEmployer.getEmail());
            }
            if (!editEmployer.getSocialMedia().equals(originalSocial)) {
                System.out.printf("%-25s: %s -> %s\n", "Social Media", originalSocial, editEmployer.getSocialMedia());
            }
            if (!editEmployer.getMaritalStatus().equals(originalMarital)) {
                System.out.printf("%-25s: %s -> %s\n", "Marital Status", originalMarital, editEmployer.getMaritalStatus());
            }
            if (!editEmployer.getDepartment().equals(originalDepartment)) {
                System.out.printf("%-25s: %s -> %s\n", "Department", originalDepartment, editEmployer.getDepartment());
            }
            if (!editEmployer.getPosition().equals(originalPosition)) {
                System.out.printf("%-25s: %s -> %s\n", "Position", originalPosition, editEmployer.getPosition());
            }
            if (!editEmployer.getJoinedDate().equals(originalJoined)) {
                System.out.printf("%-25s: %s -> %s\n", "Joined Date", originalJoined, editEmployer.getJoinedDate());
            }
            if (editEmployer.getYearOfExperience() != originalExperience) {
                System.out.printf("%-25s: %d -> %d\n", "Years of Experience", originalExperience, editEmployer.getYearOfExperience());
            }

            System.out.println("-----------------------------------------------------------");
        }

        System.out.println();
        System.out.println("=================================");
        System.out.println("   Updated Employer Profile");
        System.out.println("=================================");
        displayUpdated(editEmployer);

        Tools.systemPause();

    }

    private static void displayUpdated(Employer employer) {

        System.out.println();
        System.out.println("========================================================================");
        System.out.printf("| %-20s: %-45s |\n", "ID", employer.getId());
        System.out.printf("| %-20s: %-45s |\n", "Name", employer.getName());
        System.out.printf("| %-20s: %-45s |\n", "Date of Birth", employer.getDateOfBirth());
        System.out.printf("| %-20s: %-45s |\n", "Gender", employer.getGender());
        System.out.printf("| %-20s: %-45s |\n", "Address", employer.getAddress());
        System.out.printf("| %-20s: %-45s |\n", "IC", employer.getIc());
        System.out.printf("| %-20s: %-45s |\n", "Phone Number", employer.getPhoneNumber());
        System.out.printf("| %-20s: %-45s |\n", "Email", employer.getEmail());
        System.out.printf("| %-20s: %-45s |\n", "Social Media", employer.getSocialMedia());
        System.out.printf("| %-20s: %-45s |\n", "Marital Status", employer.getMaritalStatus());
        System.out.printf("| %-20s: %-45s |\n", "Department", employer.getDepartment());
        System.out.printf("| %-20s: %-45s |\n", "Position", employer.getPosition());
        System.out.printf("| %-20s: %-45s |\n", "Joined Date", employer.getJoinedDate());
        System.out.printf("| %-20s: %-45d |\n", "Year of Experience", employer.getYearOfExperience());
        System.out.println("==========================================================================");
        System.out.println();

    }

    private static void displayEmployer(Employer employer) {
        Tools.clearScreen();
        UserUI.headLine();

        System.out.println("ID: " + employer.getId());
        System.out.println("Name: " + employer.getName());
        Company company = employer.getCompany();
        if (company != null) {
            System.out.println("Company: " + company.getCompanyName());
        } else {
            System.out.println(RED + "Company: Not assigned" + RESET);
        }
    }

    public static boolean isDuplicateCompany(String name) {
        for (int i = 0; i < companyList.size(); i++) {
            if (companyList.get(i).getCompanyName().equalsIgnoreCase(name)) {
                System.out.println(CYAN + "Company with the same name already exists." + RESET);
                return true;
            }
        }
        return false;
    }

    public static void registerCompanyUI() {

        Tools.clearScreen();
        UserUI.headLine();

        System.out.println("==========================");
        System.out.println("=    Company Register    =");
        System.out.println("==========================");

        while (true) {
            try {
                String companyName = Input.getStringInput("Enter Company Name: ");
                String industryType = Input.getStringInput("Enter Industry Type: ");
                int employeeCount = Input.getIntegerInput("Enter Number of Employees: ");
                int foundedYear = Input.getIntegerInput("Enter Founded Year: ");
                String location = Input.getChoiceInput("Enter Location: ", ChooseSetting.LOCATION_OPTIONS);
                String address = Input.getStringInput("Enter Address: ");
                String coreServices = Input.getStringInput("Enter Core Services: ");
                String companyCulture = Input.getStringInput("Enter Company Culture: ");
                String website = Input.getStringInput("Enter Website: ");
                String verifications = Input.getStringInput("Enter Verifications (if any): ");

                if (isDuplicateCompany(companyName)) {
                    System.out.println("Duplicate company name detected.");
                    return;
                }

                boolean editing = true;
                while (editing) {
                    System.out.println("\nPlease review the company information:");
                    System.out.println("===============================================");
                    System.out.println("Company Name: " + companyName);
                    System.out.println("Industry Type: " + industryType);
                    System.out.println("Number of Employees: " + employeeCount);
                    System.out.println("Founded Year: " + foundedYear);
                    System.out.println("Location: " + location);
                    System.out.println("Address: " + address);
                    System.out.println("Core Services: " + coreServices);
                    System.out.println("Company Culture: " + companyCulture);
                    System.out.println("Website: " + website);
                    System.out.println("Verifications: " + verifications);
                    System.out.println("===============================================");

                    String confirmInfo = Input.getYesNoInput("\nDo you confirm the company information? (yes/no): ");
                    if ((confirmInfo.equalsIgnoreCase("yes") || confirmInfo.equalsIgnoreCase("y"))) {
                        editing = false;
                        break;
                    }

                    System.out.println("\nWhich attribute do you want to change?");
                    System.out.println("1. Company Name");
                    System.out.println("2. Industry Type");
                    System.out.println("3. Number of Employees");
                    System.out.println("4. Founded Year");
                    System.out.println("5. Location");
                    System.out.println("6. Address");
                    System.out.println("7. Core Services");
                    System.out.println("8. Company Culture");
                    System.out.println("9. Website");
                    System.out.println("10. Verifications");
                    System.out.println("11. Done Editing");

                    int choice = Input.getIntegerInput("Enter your choice: ");
                    switch (choice) {
                        case 1:
                            companyName = Input.getStringInput("Enter Company Name: ");
                            break;
                        case 2:
                            industryType = Input.getStringInput("Enter Industry Type: ");
                            break;
                        case 3:
                            employeeCount = Input.getIntegerInput("Enter Number of Employees: ");
                            break;
                        case 4:
                            foundedYear = Input.getIntegerInput("Enter Founded Year: ");
                            break;
                        case 5:
                            location = Input.getChoiceInput("Enter Location: ", ChooseSetting.LOCATION_OPTIONS);
                            break;
                        case 6:
                            address = Input.getStringInput("Enter Address: ");
                            break;
                        case 7:
                            coreServices = Input.getStringInput("Enter Core Services: ");
                            break;
                        case 8:
                            companyCulture = Input.getStringInput("Enter Company Culture: ");
                            break;
                        case 9:
                            website = Input.getStringInput("Enter Website: ");
                            break;
                        case 10:
                            verifications = Input.getStringInput("Enter Verifications (if any): ");
                            break;
                        case 11:
                            editing = false;
                            break;
                        default:
                            MessageUI.errorMessage();
                            break;
                    }
                }

                String confirmRegister = Input.getYesNoInput("Do you confirm to register this company? (yes/no): ");
                if (confirmRegister.equalsIgnoreCase("yes") || confirmRegister.equalsIgnoreCase("y")) {
                    Company newCompany = new Company(
                            companyName, industryType, employeeCount, foundedYear, location,
                            address, coreServices, companyCulture, website, verifications, new DoublyLinkedList<>()
                    );

                    companyList.add(newCompany);
                    Database.companies.add(newCompany);
                    System.out.println(GREEN + "Company registered successfully." + RESET);
                    
                    Tools.systemPause();
                    break;
                    
                } else {
                    System.out.println(RED + "Company registration cancelled." + RESET);
                    UserUI.loginUI();
                }

            } catch (Exception e) {
                System.out.println("Error during company registration: " + e.getMessage());
            }
            
        }
    }

    public static Company registerCompany() {

        Tools.clearScreen();
        UserUI.headLine();

        System.out.println("==========================");
        System.out.println("=    Company Register    =");
        System.out.println("==========================");

        while (true) {
            try {
                String companyName = Input.getStringInput("Enter Company Name: ");
                String industryType = Input.getStringInput("Enter Industry Type: ");
                int employeeCount = Input.getIntegerInput("Enter Number of Employees: ");
                int foundedYear = Input.getIntegerInput("Enter Founded Year: ");
                String location = Input.getChoiceInput("Enter Location: ", ChooseSetting.LOCATION_OPTIONS);
                String address = Input.getStringInput("Enter Address: ");
                String coreServices = Input.getStringInput("Enter Core Services: ");
                String companyCulture = Input.getStringInput("Enter Company Culture: ");
                String website = Input.getStringInput("Enter Website: ");
                String verifications = Input.getStringInput("Enter Verifications (if any): ");

                if (isDuplicateCompany(companyName)) {
                    System.out.println("Duplicate company name detected.");
                    return null;
                }

                boolean editing = true;
                while (editing) {
                    System.out.println("\nPlease review the company information:");
                    System.out.println("===============================================");
                    System.out.println("Company Name: " + companyName);
                    System.out.println("Industry Type: " + industryType);
                    System.out.println("Number of Employees: " + employeeCount);
                    System.out.println("Founded Year: " + foundedYear);
                    System.out.println("Location: " + location);
                    System.out.println("Address: " + address);
                    System.out.println("Core Services: " + coreServices);
                    System.out.println("Company Culture: " + companyCulture);
                    System.out.println("Website: " + website);
                    System.out.println("Verifications: " + verifications);
                    System.out.println("===============================================");

                    String confirmInfo = Input.getYesNoInput("\nDo you confirm the company information? (yes/no): ");
                    if ((confirmInfo.equalsIgnoreCase("yes") || confirmInfo.equalsIgnoreCase("y"))) {
                        editing = false;
                        break;
                    }

                    System.out.println("\nWhich attribute do you want to change?");
                    System.out.println("1. Company Name");
                    System.out.println("2. Industry Type");
                    System.out.println("3. Number of Employees");
                    System.out.println("4. Founded Year");
                    System.out.println("5. Location");
                    System.out.println("6. Address");
                    System.out.println("7. Core Services");
                    System.out.println("8. Company Culture");
                    System.out.println("9. Website");
                    System.out.println("10. Verifications");
                    System.out.println("11. Done Editing");

                    int choice = Input.getIntegerInput("Enter your choice: ");
                    switch (choice) {
                        case 1:
                            companyName = Input.getStringInput("Enter Company Name: ");
                            break;
                        case 2:
                            industryType = Input.getStringInput("Enter Industry Type: ");
                            break;
                        case 3:
                            employeeCount = Input.getIntegerInput("Enter Number of Employees: ");
                            break;
                        case 4:
                            foundedYear = Input.getIntegerInput("Enter Founded Year: ");
                            break;
                        case 5:
                            location = Input.getChoiceInput("Enter Location: ", ChooseSetting.LOCATION_OPTIONS);
                            break;
                        case 6:
                            address = Input.getStringInput("Enter Address: ");
                            break;
                        case 7:
                            coreServices = Input.getStringInput("Enter Core Services: ");
                            break;
                        case 8:
                            companyCulture = Input.getStringInput("Enter Company Culture: ");
                            break;
                        case 9:
                            website = Input.getStringInput("Enter Website: ");
                            break;
                        case 10:
                            verifications = Input.getStringInput("Enter Verifications (if any): ");
                            break;
                        case 11:
                            editing = false;
                            break;
                        default:
                            MessageUI.errorMessage();
                            break;
                    }
                }

                String confirmRegister = Input.getYesNoInput("Do you confirm to register this company? (yes/no): ");
                if (confirmRegister.equalsIgnoreCase("yes") || confirmRegister.equalsIgnoreCase("y")) {
                    Company newCompany = new Company(
                            companyName, industryType, employeeCount, foundedYear, location,
                            address, coreServices, companyCulture, website, verifications, new DoublyLinkedList<>()
                    );

                    companyList.add(newCompany);
                    Database.companies.add(newCompany);
                    System.out.println(GREEN + "Company registered successfully." + RESET);
                    return newCompany;
                } else {
                    System.out.println(RED + "Company registration cancelled." + RESET);
                    UserUI.loginUI(); // Back to register menu only if cancel
                }

            } catch (Exception e) {
                System.out.println("Error during company registration: " + e.getMessage());
            }
        }
    }

    public static void displayCompany(Company company) {

        System.out.println();
        System.out.println("=======================================================================");
        System.out.printf("| %-20s: %-45s |\n", "Company Name", company.getCompanyName());
        System.out.printf("| %-20s: %-45s |\n", "Industry Type", company.getIndustryType());
        System.out.printf("| %-20s: %-45d |\n", "Employee Count", company.getEmployeeCount());
        System.out.printf("| %-20s: %-45d |\n", "Founded Year", company.getFoundedYear());
        System.out.printf("| %-20s: %-45s |\n", "Location", company.getLocation());
        System.out.printf("| %-20s: %-45s |\n", "Company Address", company.getAddress());
        System.out.printf("| %-20s: %-45s |\n", "Core Services", company.getCoreServices());
        System.out.printf("| %-20s: %-45s |\n", "Company Culture", company.getCompanyCulture());
        System.out.printf("| %-20s: %-45s |\n", "Website", company.getWebsite());
        System.out.printf("| %-20s: %-45s |\n", "Verifications", company.getVerifications());
        System.out.println("=======================================================================");
        System.out.println();

    }

    public static void displayCompany() {
        if (Database.companies == null || Database.companies.isEmpty()) {
            System.out.println("No companies available to display.");
            return;
        }

        System.out.println("Total companies in the list: " + Database.companies.size());
        System.out.println("\n-----------------------------");
        for (Company company : Database.companies) {
            System.out.printf("| %-25s |\n", company.getCompanyName());
        }
        System.out.println("-----------------------------");

        for (Company company : Database.companies) {

            //ui
            System.out.println();
            System.out.println("======================================================================================");
            System.out.printf("| %-20s: %-45s |\n", "Company Name", company.getCompanyName());
            System.out.printf("| %-20s: %-45s |\n", "Industry Type", company.getIndustryType());
            System.out.printf("| %-20s: %-45d |\n", "Employee Count", company.getEmployeeCount());
            System.out.printf("| %-20s: %-45d |\n", "Founded Year", company.getFoundedYear());
            System.out.printf("| %-20s: %-45s |\n", "Location", company.getLocation());
            System.out.printf("| %-20s: %-45s |\n", "Company Address", company.getAddress());
            System.out.printf("| %-20s: %-45s |\n", "Core Services", company.getCoreServices());
            System.out.printf("| %-20s: %-45s |\n", "Company Culture", company.getCompanyCulture());
            System.out.printf("| %-20s: %-45s |\n", "Website", company.getWebsite());
            System.out.printf("| %-20s: %-45s |\n", "Verifications", company.getVerifications());
            System.out.println("======================================================================================");
            System.out.println();
            //ui

        }

        Tools.systemPause();

    }

}
