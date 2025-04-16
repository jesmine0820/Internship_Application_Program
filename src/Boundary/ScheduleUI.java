package Boundary;

import Utility.Input;
import Utility.MessageUI;
import Utility.Tools;
import static Utility.Tools.BLUE;
import static Utility.Tools.RED;
import static Utility.Tools.RESET;


/**
 *
 * @author User
 */
public class ScheduleUI {
    
    public static int employerScheduleMenu(){
        int choice;
        
        // menu
        Tools.clearScreen();
        System.out.println("   Schedule Menu  ");
        System.out.println("1. Assign interview");
        System.out.println("2. Update interview");
        System.out.println("3. Edit interview");
        System.out.println("3. Cancel interview");
        System.out.println("4. Exit");
        choice = Input.getIntegerInput("Enter your choice > ");
        return choice;
    }
    
    public static int editScheduleMenu(){
        int choice;
        System.out.println("Edit Menu");
        System.out.println("1. Edit interview time");
        System.out.println("2. Edit follow up time");
        System.out.println("3. Edit venue");
        System.out.println("4. Edit interview mode");
        System.out.println("5. Exit");
        choice = Input.getIntegerInput("Enter your choice");
        return choice;
    }

    public static void displayInterviewHeader(){
        System.out.println("=====================================================================");
        System.out.println("=                           Interview                               =");
        System.out.println("=====================================================================");
    }
    
    public static void displayCalendarHeader(String monthName, int year){
        System.out.println("------------------------------------------");
        System.out.println("               " + monthName + " " + year);
        System.out.println("------------------------------------------");
        System.out.println("|  M  |  T  |  W  |  T  |  F  |  " + BLUE + "S" + RESET + "  |  " + BLUE + "S" + RESET+ "  |");
        System.out.println("------------------------------------------");
    }
    
    public static void displayCalendarFooter(){
        System.out.println("");
        System.out.println(RED + "[Date] => Not Available" + RESET + " " + BLUE + "[Date] => Available" + RESET);
    }
    
    public static void successfulMessage(){
        MessageUI.createSuccessful();
        Tools.systemPause();
    }
}
