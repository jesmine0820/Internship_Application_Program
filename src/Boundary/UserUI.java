/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Boundary;

import Dao.Database;
import Utility.Input;
import Utility.Tools;

/**
 *
 * @author User
 */
public class UserUI {
    
    public static void headLine() {
        System.out.println("      ---------------------------------------- ");
        System.out.println("     |      TARUMT INTERNSHIP PROGRAM         |");
        System.out.println("      ---------------------------------------- ");
    }
    
    public static int loginUI(){
        
        int input;
        
        Tools.clearScreen();
        headLine();
        System.out.println("==================================");
        System.out.println("=           Log in as...         =");
        System.out.println("==================================");
        System.out.println("=          1. Employer           =");
        System.out.println("=          2. Applicant          =");
        System.out.println("=          3. Register           =");
        System.out.println("=          4. Exit               =");
        System.out.println("==================================");
        
        input = Input.getIntegerInput("Enter you choice > ");
        
        return input;
        
    }
    
    public static String employerMenu(){
        String input;
        
        Tools.clearScreen();
        System.out.println("==================================================");
        System.out.println("      Welcome " + Database.getEmployer().getName());
        System.out.println("==================================================");
        System.out.println("                                                  ");
        BrowseUI.displaySearchBar();
        System.out.println("                                                  ");
        System.out.println("==================================================");
        System.out.println("=             1. Job Posting                     =");
        System.out.println("=             2. Job Application                 =");
        System.out.println("=             3. Interview                       =");
        System.out.println("=             4. View Schedule                   =");
        System.out.println("=             5. Browse Manager                  =");
        System.out.println("=             6. Edit Profile                    =");
        System.out.println("=             7. Report Management               =");
        System.out.println("=             8. Logout                          =");
        System.out.println("==================================================");
        
        input = Input.getStringInput("Enter you choice > ");
        
        return input;
    }
    
    public static String applicantMenu(){
        String input;
        
        Tools.clearScreen();     
        System.out.println("==================================================");
        System.out.println("      Welcome " + Database.getApplicant().getName());
        System.out.println("==================================================");
        System.out.println("                                                  ");
        BrowseUI.displaySearchBar();
        System.out.println("                                                  ");
        System.out.println("==================================================");
        System.out.println("=             1. Browse Jobs                     =");
        System.out.println("=             2. View My Applications            =");
        System.out.println("=             3. Edit Profile                    =");
        System.out.println("=             4. Report Management               =");
        System.out.println("=             5. Logout                          =");
        System.out.println("==================================================");
        
        input = Input.getStringInput("Enter your choice > ");
        
        return input;
    }
    
    public static int registerMenu(){
        int input;
        
        Tools.clearScreen();
        System.out.println("=======================================");
        System.out.println("=             Register as...          =");
        System.out.println("=======================================");
        System.out.println("=             1. Company              =");
        System.out.println("=             2. Employer             =");
        System.out.println("=             3. Applicant            =");
        System.out.println("=             4. Exit                 =");
        System.out.println("=======================================");
        
        input = Input.getIntegerInput("Enter your choice > ");
        
        return input;
    }
    
    public static String chooseEntity(){
        String input;
        
        System.out.println("\nOptions: [P] Previous Page  [N] Next Page  [X] Cancel Selection");
        
        input = Input.getStringInput("Enter choice > ").trim();
        
        return input;
    }
    
    public static void profile(String name, String user){
        System.out.println("--------------------------------");
        System.out.println("Current Log in: " + name + "( " + user + " )");
    }
    
}
