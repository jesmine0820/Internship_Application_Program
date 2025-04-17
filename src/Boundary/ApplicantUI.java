package Boundary;

import Control.ApplicantManager;
import Utility.Input;
import Utility.Tools;
import Utility.MessageUI;

/**
 *
 * @author Gan Khai Li
 * 
 */
public class ApplicantUI {
    public static String applicantMenu() {
        Tools.clearScreen();
        UserUI.headLine();

        System.out.println("\nApplicant Menu");
        System.out.println("1. Create Applicant");
        System.out.println("2. Update Applicant");
        System.out.println("3. Delete Account");
        System.out.println("4. View Personal Details");
        // For company
        System.out.println("5. Filter Applicant");
        System.out.println("6. Search Applicant's resume");
        System.out.println("7. Exit");

        while (true) {
            int choice = Input.getIntegerInput("Enter your choice > ");
            switch (choice) {
                case 1 -> {
                    ApplicantManager.registerApplicant();
                }
                case 2 -> {
                    ApplicantManager.editProfile();
                }
                case 3 -> {
                    ApplicantManager.deleteAccount();
                }
                case 4 -> {
                    ApplicantManager.viewDetails();
                }
                case 5 -> {
                    ApplicantManager.filterApplicant();
                }
                case 6 -> {
                    String searchTerm = Input.getStringInput("Enter keyword to search resume details: ");
                    ApplicantManager.searchResume(searchTerm); 
                }
                case 7 -> {
                    System.out.println("Thank you for using the Job Application System! Goodbye.");
                    return null;
                }
                default ->
                    MessageUI.errorMessage();
            }
        }
    }
    
    public static void createApplicantHeader(String applicantID){
        System.out.println("\n========== Create New Applicant ==========");
        System.out.println("Applicant ID: " + applicantID);
    }
    
    public static void editProfileHeader(){
        Tools.clearScreen();
        UserUI.headLine();
        System.out.println("\n========== Update Applicant Profile ==========");

    }
    
    public static void deleteAccountHeader(){
        Tools.clearScreen();
        UserUI.headLine();
        System.out.println("\n========== Delete Account ==========");
    }
    
    public static void viewApplicantDetailsHeader(){
        Tools.clearScreen();
        UserUI.headLine();
        System.out.println("\n========== View Applicant Details ==========\n");
    }
    
    public static void filterApplicant(){
        Tools.clearScreen();
        UserUI.headLine();
        System.out.println("\n========== Filter Applicant ==========");
    }
}
