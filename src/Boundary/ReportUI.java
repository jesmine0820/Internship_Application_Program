package Boundary;

import Control.UserManager;
import Utility.Input;
import Utility.Tools;

/**
 *
 * @author All
 * 
 */
public class ReportUI {
    
    //---------------------------Display Report Menu---------------------------
    public static int reportUI(){
        Tools.clearScreen();

        int input;
        
        UserUI.headLine();
        System.out.println("                ===============================");
        System.out.println("                =       Report Management     =");
        System.out.println("                ===============================");
        System.out.println("                =     1. Job Report           =");
        System.out.println("                =     2. Application Report   =");
        System.out.println("                =     3. Matching Report      =");
        System.out.println("                =     4. Interview Report     =");
        System.out.println("                =     5. Searching Report     =");
        System.out.println("                =     6. Exit                 =");
        System.out.println("                ===============================");
        
        input = Input.getIntegerInput("Enter your choice > ");
        
        return input;
    }

    //---------------------------Display Report Header---------------------------
    public static void reportHeader(String title){
        Tools.clearScreen();
        UserUI.headLine();
        
        System.out.println("==================================================================================================");
        System.out.printf("\t\t\t%35s\n", title);
        System.out.println("==================================================================================================");
    }
    
    //---------------------------Display Description---------------------------
    public static void descriptionLine(String text){
        System.out.println("Description: " + text);
    }
    
    //---------------------------Display Matching Engine Report Menu---------------------------
    public static int matchingReport(){
        Tools.clearScreen();

        int input;
        
        UserManager.profileHeadLine();
        System.out.println("                =================================================");
        System.out.println("                =                  Matching Report              =");
        System.out.println("                =================================================");
        System.out.println("                =       1. Job Application Matching Report      =");
        System.out.println("                =       2. Top Matched Job Report               =");
        System.out.println("                =       3. Matching Engine Efficiency Report    =");
        System.out.println("                =       4. Exit                                 =");
        System.out.println("                =================================================");
        
        input = Input.getIntegerInput("Enter your choice > ");
        
        return input;
    }
    
    //---------------------------Display Searching Module Report Menu---------------------------
    public static int searchingReport(){
        Tools.clearScreen();
        
        int input;
        
        UserManager.profileHeadLine();
        System.out.println("                =================================================");
        System.out.println("                =                 Searching Report              =");
        System.out.println("                =================================================");
        System.out.println("                =          1. Search Performance Report         =");
        System.out.println("                =          2. Search Trend Report               =");
        System.out.println("                =          3. Exit                              =");
        System.out.println("                =================================================");
        
        input = Input.getIntegerInput("Enter your choice > ");
        
        return input;
    }
    
    ////---------------------------Print Report UI---------------------------
    public static String printingReport(){
        String input;
        
        System.out.println("----------------------------------------------------------------------------");
        do{
            input = Input.getStringInput("Do you want to print out this report? (Y/N) > ");
        }while(!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("n") && !input.equalsIgnoreCase("no"));
    
        return input;
    }
    
    //---------------------------Display Graph Title---------------------------
    public static void graphTitle(String title){
        System.out.println("\n                  " + title + "\n");
    }
    
}
