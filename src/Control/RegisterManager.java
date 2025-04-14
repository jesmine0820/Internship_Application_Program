package Control;

import Entity.*;
import Utility.*;
import Dao.*;
import java.util.Date;
import ADT.*;
import Boundary.EmployerUI;
import Boundary.UserUI;
import static Utility.Tools.*;

/**
 *
 * @author USER
 */
public class RegisterManager {

    private static final ListInterface<Employer> employerList = new DoublyLinkedList<>();
    private static final ListInterface<Company> companyList = new DoublyLinkedList<>();

    public static Employer compareEmployerEmail(String email) {
        for (Employer currentEmployer : Database.employers) {  // Enhanced for loop
            if (currentEmployer.getEmail().equalsIgnoreCase(email)) {
                System.out.println(RED + "Email already registered." + RESET);
                return currentEmployer;  // Found matching job
            }
        }
        return null;  // No job found with the given jobTitle
    }

    public static void registerEmployer() {
        
        Tools.clearScreen();
        UserUI.headLine();

        System.out.println("==========================");
        System.out.println("=    Employer Register   =");
        System.out.println("==========================");

        boolean continueRegistering = true;

        while (continueRegistering) {
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
            String nationality = Input.getStringInput("Enter Nationality: ");
            String department = Input.getStringInput("Enter Department: ");
            String position = Input.getStringInput("Enter Position: ");
            Date joinedDate = Validation.checkDate("Enter Joined Date (YYYY-MM-dd): ");
            int yearOfExperience = Input.getIntegerInput("Enter Years of Experience: ");

            // Display list of existing companies
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

            if (id == null || name == null || dateOfBirth == null || gender == null
                    || address == null || ic == null || phoneNumber == null || email == null
                    || socialMedia == null || maritalStatus == null || nationality == null
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
                System.out.println("Nationality: " + nationality);
                System.out.println("Department: " + department);
                System.out.println("Position: " + position);
                System.out.println("Joined Date: " + joinedDate);
                System.out.println("Years of Experience: " + yearOfExperience);
                System.out.println("Company: " + selectedCompany);
                System.out.println("==============================================");

                String confirmInfo = Input.getYesNoInput(BLUE + "\nDo you confirm the employer information? (yes/no): " + RESET);
                if (confirmInfo.equalsIgnoreCase("yes")) {
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
                System.out.println("10. Nationality");
                System.out.println("11. Department");
                System.out.println("12. Position");
                System.out.println("13. Joined Date");
                System.out.println("14. Years of Experience");
                System.out.println("15. Company");
                System.out.println("16. Done Editing");

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
                        socialMedia = Validation.getStringInput("Enter new Social Media: ");
                    case 9 ->
                        maritalStatus = Input.getChoiceInput("Enter new Marital Status: ", ChooseSetting.MARITAL_STATUSES);
                    case 10 ->
                        nationality = Validation.getStringInput("Enter new Nationality: ");
                    case 11 ->
                        department = Validation.getStringInput("Enter new Department: ");
                    case 12 ->
                        position = Validation.getStringInput("Enter new Position: ");
                    case 13 ->
                        joinedDate = Input.getDateInput("Enter new Joined Date (YYYY-MM-dd): ");
                    case 14 ->
                        yearOfExperience = Validation.getIntegerInput("Enter new Years of Experience: ");
                    case 15 -> {
                        // Display existing companies
                        for (int i = 0; i < Database.companies.size(); i++) {
                            System.out.println((i + 1) + ". " + Database.companies.get(i).getCompanyName());
                        }

                        companyChoice = Validation.getIntegerInput("Select a company by number (enter 0 to create a new company): ");

                        if (companyChoice == 0) {
                            selectedCompany = registerCompany(); // Ensure this method returns a Company object
                        } else if (companyChoice > 0 && companyChoice <= Database.companies.size()) {
                            selectedCompany = Database.companies.get(companyChoice - 1);
                        } else {
                            System.out.println(RED + "Invalid company selection." + RESET);
                            break;
                        }
                    }
                    case 16 ->
                        editing = false;
                    default ->
                        System.out.println(RED + "Invalid choice. Please try again." + RESET);
                }
            }

            String confirmRegister = Input.getYesNoInput("\nDo you confirm to register this employer? (yes/no): ");
            if (!confirmRegister.equalsIgnoreCase("yes")) {
                System.out.println(RED + "Employer registration cancelled." + RESET);
                EmployerUI.employerMenu();
                continue;
            }

            Employer newEmployer = new Employer(id, name, dateOfBirth, gender, address, ic, phoneNumber, email, socialMedia, maritalStatus, nationality, department, position, joinedDate, yearOfExperience, null, selectedCompany);
            employerList.add(newEmployer);
            Database.employers.add(newEmployer);
            System.out.println(GREEN + "Employer registered successfully." + RESET);

            String another = Input.getYesNoInput("\n\nDo you want to register another employer? (yes/no): ");
            if (!another.equalsIgnoreCase("yes")) {
                continueRegistering = false;
                // need change
                EmployerUI.employerMenu();
            } else {
                //back to the login
            }

        }
    }

    // this display not sure need use or not
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

    public static Company registerCompany() {
        
        Tools.clearScreen();
        UserUI.headLine();

        System.out.println("==========================");
        System.out.println("=    Company Register    =");
        System.out.println("==========================");

        while (true) {
            try {
                String companyName = Validation.getStringInput("Enter Company Name: ");
                String industryType = Validation.getStringInput("Enter Industry Type: ");
                int employeeCount = Validation.getIntegerInput("Enter Number of Employees: ");
                int foundedYear = Validation.getIntegerInput("Enter Founded Year: ");
                String location = Input.getChoiceInput("Enter Location: ", ChooseSetting.LOCATION_OPTIONS);
                String address = Validation.getStringInput("Enter Address: ");
                String coreServices = Validation.getStringInput("Enter Core Services: ");
                String companyCulture = Validation.getStringInput("Enter Company Culture: ");
                String website = Validation.getStringInput("Enter Website: ");
                String verifications = Validation.getStringInput("Enter Verifications (if any): ");

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
                    if (confirmInfo.equalsIgnoreCase("yes")) {
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

                    int choice = Validation.getIntegerInput("Enter your choice: ");
                    switch (choice) {
                        case 1:
                            companyName = Validation.getStringInput("Enter Company Name: ");
                        case 2:
                            industryType = Validation.getStringInput("Enter Industry Type: ");
                        case 3:
                            employeeCount = Validation.getIntegerInput("Enter Number of Employees: ");
                        case 4:
                            foundedYear = Validation.getIntegerInput("Enter Founded Year: ");
                        case 5:
                            location = Input.getChoiceInput("Enter Location: ", ChooseSetting.LOCATION_OPTIONS);
                        case 6:
                            address = Validation.getStringInput("Enter Address: ");
                        case 7:
                            coreServices = Validation.getStringInput("Enter Core Services: ");
                        case 8:
                            companyCulture = Validation.getStringInput("Enter Company Culture: ");
                        case 9:
                            website = Validation.getStringInput("Enter Website: ");
                        case 10:
                            verifications = Validation.getStringInput("Enter Verifications (if any): ");
                        case 11:
                            editing = false;
                        default:
                            System.out.println(RED + "Invalid choice. Please try again." + RESET);
                    }
                }

                String confirmRegister = Input.getYesNoInput("Do you confirm to register this company? (yes/no): ");
                if (!confirmRegister.equalsIgnoreCase("yes")) {
                    System.out.println(RED + "Company registration cancelled." + RESET);
                    //BAck to menu
                    EmployerUI.employerMenu();
                    continue;
                }

                Company newCompany = new Company(
                        companyName, industryType, employeeCount, foundedYear, location,
                        address, coreServices, companyCulture, website, verifications, new DoublyLinkedList<>()
                );

                companyList.add(newCompany);
                Database.companies.add(newCompany);
                System.out.println(GREEN + "Company registered successfully." + RESET);
                return newCompany;

            } catch (Exception e) {
                System.out.println("Error during company registration: " + e.getMessage());
            }
        }
    }
}
