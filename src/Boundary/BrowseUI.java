/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Boundary;

import Utility.Tools;
import Utility.Input;

/**
 *
 * @author User
 */
public class BrowseUI {
    public static int employerBrowseMenu() {
        int input;
        
        Tools.clearScreen();
        System.out.println("=======================================");
        System.out.println("=          Employer Browse Menu       =");
        System.out.println("=======================================");
        System.out.println("=         1. Browse Job               =");
        System.out.println("=         2. Browse Applicant         =");
        System.out.println("=         3. Search                   =");
        System.out.println("=         4. Exit                     =");
        System.out.println("=======================================");

        input = Input.getIntegerInput("Enter your choice > ");
        
        return input;
    }
    
    public static int applicantBrowseMenu() {
        int input;
        
        Tools.clearScreen();
        System.out.println("=======================================");
        System.out.println("=      Applicant Browse Menu          =");
        System.out.println("=======================================");
        System.out.println("=         1. Browse Job               =");
        System.out.println("=         2. Search                   =");
        System.out.println("=         3. Exit                     =");
        System.out.println("=======================================");

        input = Input.getIntegerInput("Enter your choice > ");
        
        return input;
    }
    
    public static void displaySearchBar(String title) {
        System.out.println("--------------------------------------");
        System.out.println("       Browser: " + title     );
        System.out.println("--------------------------------------");
    }
    
    public static void displayInformation(String title){
        System.out.println("--------------------------------------");
        System.out.println("     Information of " + title);
        System.out.println("--------------------------------------");
    }
    
    public static String chooseEntity(){
        String input;
        
        System.out.println("\nOptions: [P] Previous Page  [N] Next Page  [X] Cancel Selection");
        
        input = Input.getStringInput("Enter choice > ").trim();
        
        return input;
    }
    
    public static void lastPage(){
        System.out.println("*********No More Page Available*********");
    }
}
