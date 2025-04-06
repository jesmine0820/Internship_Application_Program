package Boundary;

import Utility.Input;
import Utility.Tools;

/**
 *
 * @author User
 * 
 */
public class ReportUI {
    
    public static int reportUI(){
        Tools.clearScreen();

        int input;
        
        UserUI.headLine();
        System.out.println("===============================");
        System.out.println("=       Report Management     =");
        System.out.println("===============================");
        System.out.println("=     1. Job Report           =");
        System.out.println("=     2. Application Report   =");
        System.out.println("=     3. Matching Report      =");
        System.out.println("=     4. Interview Report     =");
        System.out.println("=     5. Searching Report     =");
        System.out.println("=     6. Exit                 =");
        System.out.println("===============================");
        
        input = Input.getIntegerInput("Enter your choice > ");
        
        return input;
    }

    public static void reportHeader(String title){
        Tools.clearScreen();
        UserUI.headLine();
        
        System.out.println("========================================");
        System.out.println("            " + title + " Report      ");
        System.out.println("========================================");
    }
    
    public static int matchingReport(){
        Tools.clearScreen();

        int input;
        
        UserUI.headLine();
        System.out.println("=================================================");
        System.out.println("=                  Matching Report              =");
        System.out.println("=================================================");
        System.out.println("=       1. Applicant Matching Report            =");
        System.out.println("=       2. Top Matched Application Report       =");
        System.out.println("=       3. Matching Engine Efficiency Report    =");
        System.out.println("=       4. Exit                                 =");
        System.out.println("=================================================");
        
        input = Input.getIntegerInput("Enter your choice > ");
        
        return input;
    }
    
}
