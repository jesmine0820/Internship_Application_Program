/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import static Utility.Tools.RED;
import static Utility.Tools.BLUE;
import static Utility.Tools.GREEN;
import static Utility.Tools.PURPLE;
import static Utility.Tools.RESET;

/**
 *
 * @author User
 */
public class MessageUI {
    
    public static void errorMessage(){
        System.out.println(RED + "Invalid Input!" + RESET);
        Tools.systemPause();
    }
    
    public static void inputIntegerMessage(){
        System.out.println(RED + "Input must in Integer." + RESET);
    }
    
    public static void doubleIntegerMessage(){
        System.out.println(RED + "Invalid input. Input must be in Double." + RESET);
    }
    
    public static void yesNoMessage(){
        System.out.println(RED + "Enter Y or N only." + RESET);
    }
    
    public static void emptyDatabase(){
        System.out.println(RED + "No data in database." + RESET);
    }
    
    public static void emptyEmployerMessage(){
        System.out.println(RED + "No employer available." + RESET);
    }
    
    public static void emptyApplicantMessage(){
        System.out.println(RED + "No applicant available." + RESET);
    }
    
    public static void logOutMessage(){
        System.out.println(BLUE + "Log out... " + RESET);
    }
    
    public static void invalidTitle(){
        System.out.println(RED + "Invalid Title" + RESET);
    }
    
    public static void noMatchFound(){
        System.out.println(PURPLE + "No match found." + RESET);
    }
    
    public static void restrictView(){
        System.out.println(RED + "You are blocked from view." + RESET);
    }
    
    public static void invalidName(){
        System.out.println(RED + "Invalid name. Please enter a valid name." + RESET);
    }
    
    public static void invalidDate(){
        System.out.println(RED + "Invalid date format. Please enter a valid date." + RESET);
    }
    
    public static void invalidTime(){
        System.out.println(RED + "Invalid time format. Please enter a valid time." + RESET);
    }
    
    public static void invalidIC(){
        System.out.println(RED + "IC must be in the format xxxxxx-xx-xxxx (12 digits with dashes)." + RESET);
    }
    
    public static void invalidDOB(){
        System.out.println(RED + "Invalid birthdate in IC number. Please ensure YYMMDD is a valid date." + RESET);
    }
    
    public static void invalidPhone(){
        System.out.println(RED + "Invalid phone number format." + RESET);
        System.out.println(RED + "Please enter a valid number in the format 01X-XXXXXXX or 01X-XXXXXXXX." + RESET);
    }
    
    public static void invalidEmail(){
        System.out.println(RED + "Invalid email format." + RESET);
        System.out.println(RED + "Please enter a valid email address." + RESET);
    }
    
    public static void invalidSocialMedia(){
        System.out.println(RED + "Invalid social media handle." + RESET);
        System.out.println(RED + "Please enter the handle in the format: @username." + RESET);
    }
    
    public static void invalidList(){
        System.out.println(RED + "Invalid choice! Please select a valid number from the list." + RESET);
    }
    
    public static void noScheduled(){
        System.out.println(PURPLE + "No scheduled interview yet!" + RESET);
    }
    
    public static void cancelSelection(){
        System.out.println(PURPLE + "No changes were made." + RESET);
    }
    
    public static void createSuccessful(){
        System.out.println(GREEN + "Successfully registered!" + RESET);
    }
    
    public static void updateSuccessful(){
        System.out.println(GREEN + "Your personal information has been updated successfully." + RESET);
    }
    
    public static void deleteSuccessful(){
        System.out.println(GREEN+"Applicant has been removed successfully."+RESET);
    }
    
    public static void removeFailed(){
        System.out.println(RED + "An error occurred while removing");
    }
    
}
