package Boundary;

import ADT.DoublyLinkedList;
import Control.JobManager;
import Utility.Input;
import Utility.Tools;
import Entity.*;
import Utility.MessageUI;

/**
 *
 * @author USER
 */
public class EmployerUI {

    public static final DoublyLinkedList<Job> jobList = new DoublyLinkedList<>();

    public static String employerMenu() {
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

        while (true) {
            int choice = Input.getIntegerInput("Enter your choice > ");
            switch (choice) {
                case 1 ->
                    JobManager.createJob();
                case 2 ->
                    JobManager.updateJob();
                case 3 ->
                    JobManager.deleteJob();
                case 4 ->
                    JobManager.displayJobDetails();
                case 5 ->
                    JobManager.filterJob();
                case 6 -> 
                    JobManager.searchJobsByEmployerOrCompany();
                case 7 ->
                    Tools.back();
                default ->
                    MessageUI.errorMessage();
            }
        }

    }
}
