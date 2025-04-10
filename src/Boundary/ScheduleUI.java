package Boundary;

import ADT.ListInterface;
import Entity.Applicant;
import Entity.Schedule;
import Utility.Input;
import Utility.Tools;
import java.util.Date;

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
        System.out.println("2. Update interview status");
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
        date = Input.getStringInput("Enter Interview Date (yyyy-MM-dd) > ");
        return date;
    }
    
    public static String getTime(){
        String time;
        time = Input.getStringInput("Enter Interview Time (HH:mm) > ");
        return time;
    }
    
    public static int getInterviewMode(){
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
    
    // Display Schedule
    public static void displaySchedule(ListInterface<Schedule> scheduleList){
        System.out.printf("%-4s | %-10s | %-10s | %-6s | %-10s | %-16s | %-15s | %-10s%n",
                "No", "Name", "Date", "Time", "Venue", "Follow Up Date", "Follow Up Time", "Status");
        System.out.println("---------------------------------------------------------------------------------------------");

        // Print schedule entries
        int no = 1;
        for (Schedule item : scheduleList) {
            Applicant applicant = item.getApplicant();
            String name = applicant.getName();
            Date interviewDate = item.getInterviewDate();
            Date interviewTime = item.getInterviewTime();
            String venue = item.getVenue();
            Date followUpDate = item.getFollowUpDate();
            Date followUpTime = item.getFollowUpTime();
            String status = item.getStatus();

            System.out.printf("%-4d | %-10s | %-10s | %-6s | %-10s | %-16s | %-15s | %-10s%n",
                    no++,
                    name,
                    interviewDate,
                    interviewTime,
                    venue,
                    followUpDate,
                    followUpTime,
                    status);
        }
    }
}
