package Boundary;

import Utility.Input;
import Utility.Tools;

/**
 *
 * @author USER
 */
public class EmployerUI {

    public static int employerMenu() {
        Tools.clearScreen();
        UserUI.headLine();

        System.out.println("\nEmployer Menu\n");
        System.out.println("1. Create Job");
        System.out.println("2. Update Job");
        System.out.println("3. Delete Job");
        System.out.println("4. Display Jobs");
        System.out.println("5. Filter Jobs");
        System.out.println("6. Searching");
        System.out.println("7. Exit");

        int choice = Input.getIntegerInput("Enter your choice > ");
        return choice;
    }
}
