package Boundary;

import Control.UserManager;
import Utility.Input;
import Utility.Tools;

/**
 *
 * @author Kit Chin Jie Ying
 * 
 */
public class JobUI {

    public static int employerMenu() {
        Tools.clearScreen();
        UserManager.profileHeadLine();

        System.out.println("                  ============================================");
        System.out.println("                  =              Job Posting Menu            =");
        System.out.println("                  ============================================");
        System.out.println("                  =              1. Create Job               =");
        System.out.println("                  =              2. Update Job               =");
        System.out.println("                  =              3. Delete Job               =");
        System.out.println("                  =              4. Display Jobs             =");
        System.out.println("                  =              5. View My Jobs             =");
        System.out.println("                  =              6. Filter Jobs              =");
        System.out.println("                  =              7. Searching                =");
        System.out.println("                  =              8. Exit                     =");
        System.out.println("                  ============================================");

        int choice = Input.getIntegerInput("Enter your choice > ");
        return choice;
    }
    
    public static void createJobHeader(){
        Tools.clearScreen();
        UserManager.profileHeadLine();
        System.out.println("                    ======================");
        System.out.println("                    =   Create New Job   =");
        System.out.println("                    ======================");
    }
}
