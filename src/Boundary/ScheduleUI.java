package Boundary;

import ADT.ListInterface;
import Control.UserManager;
import Entity.Applicant;
import Entity.Schedule;
import Utility.Input;
import Utility.Tools;
import java.text.SimpleDateFormat;

/**
 *
 * @author User
 */
public class ScheduleUI {
    
    public static int employerScheduleMenu(){
        int choice;
        
        Tools.clearScreen();
        System.out.println("   Schedule Menu  ");
        System.out.println("1. Assign interview");
        System.out.println("2. Update interview");
        System.out.println("3. Cancel interview");
        System.out.println("4. Exit");
        choice = Input.getIntegerInput("Enter your choice > ");
        return choice;
    }
    
    // Add Schedule
    public static String getApplicantName(){
        String name;
        name = Input.getStringInput("Enter Applicant Name > ");
        return name;
    }
    
    public static String getDate(){
        String date;
        date = Input.getStringInput("Enter interview date (yyyy-MM-dd) > ");
        return date;
    }
    
    public static String getTime(){
        String time;
        time = Input.getStringInput("Enter interview time (HH:mm) > ");
        return time;
    }

    public static String getInterviewDate() {
        String date;
        date = Input.getStringInput("Enter interview date (dd-MM-yyyy) > ");
        return date;
    }

    public static int getInterviewMode() {
        int choice;
        System.out.println("Select Interview Mode");
        System.out.println("    1. Online");
        System.out.println("    2. Offline");
        choice = Input.getIntegerInput("Enter your choice > ");
        return choice;
    }
    
    public static String getVenue(){
        String venue;
        venue = Input.getStringInput("Enter venue > ");
        return venue;
    }
    
    // Update Schedule
    public static String updateFollowUpDate(){
        String date;
        date = Input.getStringInput("Update follow up date (yyyy-MM-dd) > ");
        return date;
    }
    
    public static String updateFollowUpTime(){
        String time;
        time = Input.getStringInput("Update follow up time (HH:mm) > ");
        return time;
    }
    
    public static int updateStatus(){
        int choice;
        System.out.println("Select Status");
        System.out.println("1. Scheduled");
        System.out.println("2. Completed");
        System.out.println("3. Canceled");
        choice = Input.getIntegerInput("Enter your choice > ");
        return choice;
    }
    
    public static void displayInterviewHeader(){
        System.out.println("=====================================================================");
        System.out.println("=                           Interview                               =");
        System.out.println("=====================================================================");
    }
}
