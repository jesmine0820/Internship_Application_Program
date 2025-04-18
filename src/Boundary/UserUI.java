package Boundary;

import Dao.Database;
import Utility.Input;
import Utility.Tools;
import Utility.Validation;
import java.util.Date;
import static Utility.Tools.*;

/**
 *
 * @author Jesmine Tey Khai Jing
 * 
 */

public class UserUI {
    
    //---------------------------Display Header at Log In---------------------------
    public static void headLine() {
        Tools.clearScreen();
        System.out.printf(RED + "\t\t%s\n\t\t", "                         _" + RESET);
        System.out.printf(BLUE + "%s\n\t\t", "         _   _ _ __ ___ | |_" + RESET);
        System.out.printf(RED + "%s\n\t\t", "        | | | | '_ ` _ \\| __|" + RESET);
        System.out.printf(BLUE + "%s\n\t\t", "        | |_| | | | | | | |_" + RESET);
        System.out.printf(RED + "%s\n\n", "         \\__,_|_| |_| |_|\\__|" + RESET);
        System.out.println("             ---------------------------------------- ");
        System.out.println("             |      TARUMT INTERNSHIP PROGRAM       |");
        System.out.println("             ---------------------------------------- ");
    }
    
    //---------------------------Display Login Menu---------------------------
    public static int loginUI(){
        
        int input;
        
        Tools.clearScreen();
        headLine();
        System.out.println("                ==================================");
        System.out.println("                =           Log in as...         =");
        System.out.println("                ==================================");
        System.out.println("                =          1. Employer           =");
        System.out.println("                =          2. Applicant          =");
        System.out.println("                =          3. Register           =");
        System.out.println("                =          4. Exit               =");
        System.out.println("                ==================================");
        
        input = Input.getIntegerInput("Enter you choice > ");
        
        return input;
        
    }
    
    //---------------------------Display Employer Menu---------------------------
    public static String employerMenu(){
        String input;
        
        Tools.clearScreen();
        System.out.println("        ==================================================");
        System.out.println("                        Welcome " + Database.getEmployer().getName());
        System.out.println("        ==================================================");
        System.out.println("                                                  ");
        BrowseUI.displaySearchBar();
        System.out.println("                                                    ");
        System.out.println("        ==================================================");
        System.out.println("        =             1. Job Posting                     =");
        System.out.println("        =             2. Job Application                 =");
        System.out.println("        =             3. Interview                       =");
        System.out.println("        =             4. View Schedule                   =");
        System.out.println("        =             5. Browse Manager                  =");
        System.out.println("        =             6. Edit Profile                    =");
        System.out.println("        =             7. Report Management               =");
        System.out.println("        =             8. Logout                          =");
        System.out.println("        ==================================================");
        
        input = Input.getStringInput("Enter you choice > ");
        
        return input;
    }
    
    //---------------------------Display Applicant Menu---------------------------
    public static String applicantMenu(int count){
        String input;
        
        Tools.clearScreen();     
        System.out.println("        ==================================================");
        System.out.println("                Welcome " + Database.getApplicant().getName());
        System.out.println("        ==================================================");
        Tools.notificationIcon(count);
        System.out.println("                                                  ");
        BrowseUI.displaySearchBar();
        System.out.println("                                                  ");
        System.out.println("        ==================================================");
        System.out.println("        =             1. Browse Jobs                     =");
        System.out.println("        =             2. View My Applications            =");
        System.out.println("        =             3. View Schedule                   =");
        System.out.println("        =             4. View Saved Job List             =");
        System.out.println("        =             5. Edit Profile                    =");
        System.out.println("        =             6. Report Management               =");
        System.out.println("        =             7. Delete Account                  =");
        System.out.println("        =             7. Logout                          =");
        System.out.println("        ==================================================");
        
        input = Input.getStringInput("Enter your choice > ");
        
        return input;
    }
    
    //---------------------------Display Register Menu---------------------------
    public static int registerMenu(){
        int input;
        
        Tools.clearScreen();
        headLine();
        System.out.println("            =======================================");
        System.out.println("            =             Register as...          =");
        System.out.println("            =======================================");
        System.out.println("            =             1. Company              =");
        System.out.println("            =             2. Employer             =");
        System.out.println("            =             3. Applicant            =");
        System.out.println("            =             4. Exit                 =");
        System.out.println("            =======================================");
        
        input = Input.getIntegerInput("Enter your choice > ");
        
        return input;
    }
    
    //---------------------------Display Choose Entity Footer---------------------------
    public static String chooseEntity(){
        String input;
        
        System.out.println("\n  Options: [P] Previous Page  [N] Next Page  [X] Cancel Selection");
        
        input = Input.getStringInput("Enter choice > ").trim();
        
        return input;
    }
    
    //---------------------------Display Choose Entity Footer---------------------------
    public static String chooseFirstPageEntity(){
        String input;
        
        System.out.println("\n            Options: [N] Next Page  [X] Cancel Selection");
        
        input = Input.getStringInput("Enter choice > ").trim();
        
        return input;
    }
    
    //---------------------------Display Choose Entity Footer---------------------------
    public static String chooseLastPageEntity(){
        String input;
        
        System.out.println("\n            Options: [P] Previous Page  [X] Cancel Selection");
        
        input = Input.getStringInput("Enter choice > ").trim();
        
        return input;
    }
    
    //---------------------------Display Profile Header---------------------------
    public static void profile(String name, String user, String date, String time){
        System.out.printf(RED + "\t\t\t%s\n\t\t\t", "                       _" + RESET);
        System.out.printf(BLUE + "%s\n\t\t\t", "       _   _ _ __ ___ | |_" + RESET);
        System.out.printf(RED + "%s\n\t\t\t", "      | | | | '_ ` _ \\| __|" + RESET);
        System.out.printf(BLUE + "%s\n\t\t\t", "      | |_| | | | | | | |_" + RESET);
        System.out.printf(RED + "%s\n\n", "       \\__,_|_| |_| |_|\\__|" + RESET);
        System.out.println("    -----------------------------------------------------------------------------------------");
        System.out.println("        Current Log in: " + name + "( " + user + " )" + "         Date: " + date + " | Time: " + time);
        System.out.println("    -----------------------------------------------------------------------------------------");
    }
    
    public static Date userCurrentDate(){
        return(Validation.checkDate("Enter current date (yyyy-MM-dd) > "));
    }
    
    public static Date userCurrentTime(){
        return(Validation.checkTime("Enter current time (HH:mm) > "));
    }
    
}
