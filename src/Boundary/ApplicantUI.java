package Boundary;

import Utility.Tools;

/**
 *
 * @author Gan Khai Li
 * 
 */
public class ApplicantUI {

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
