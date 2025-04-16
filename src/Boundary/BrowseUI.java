package Boundary;

import Control.UserManager;
import Utility.Tools;
import Utility.Input;

/**
 *
 * @author Jesmine Tey Khai Jing
 * 
 */
public class BrowseUI {
    public static int employerBrowseMenu() {
        int input;
        
        Tools.clearScreen();
        UserManager.profileHeadLine();
        System.out.println("        =======================================");
        System.out.println("        =          Employer Browse Menu       =");
        System.out.println("        =======================================");
        System.out.println("        =         1. Browse Job               =");
        System.out.println("        =         2. Browse Applicant         =");
        System.out.println("        =         3. Exit                     =");
        System.out.println("        =======================================");

        input = Input.getIntegerInput("Enter your choice > ");
        
        return input;
    }
    
    public static void displaySearchBar(){
        System.out.println("        --------------------------------------------------");
        System.out.println("        | S - Search: _______________________________| Q |");
        System.out.println("        --------------------------------------------------");
    }
    
    public static void displayBrowserHeader(String title) {
        Tools.clearScreen();
        UserManager.profileHeadLine();
        System.out.println("        ----------------------------------------------");
        System.out.println(String.format("          Browser: %15s", title));
        System.out.println("        ----------------------------------------------");
    }
    
    public static void displaySearchHeader() {
        UserManager.profileHeadLine();
        System.out.println("                -----------------------------------------------------");
        System.out.println("                              [Enter] Search    [X] quit             ");
        System.out.println("                -----------------------------------------------------");
    }
    
    public static void displayInformation(String title){
        Tools.clearScreen();
        UserManager.profileHeadLine();
        System.out.println("            ----------------------------------------------");
        System.out.println(String.format("              Information of: %20s", title));
        System.out.println("            ---------------------------------------------");
    }
}
