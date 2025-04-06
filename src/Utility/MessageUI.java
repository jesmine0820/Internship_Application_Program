/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import static Utility.Tools.RED;
import static Utility.Tools.BLUE;
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
    
}
