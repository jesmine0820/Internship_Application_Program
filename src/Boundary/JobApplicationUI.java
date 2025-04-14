package Boundary;

import Control.JobApplicationManager;
import Entity.Applicant;
import Utility.Input;
import Utility.MessageUI;

/**
 *
 * @author Asus
 */
public class JobApplicationUI {

    public static void applicantionMenu(Applicant applicant) {
        int choice;

        do {
            UserUI.headLine();
            System.out.println("\nApplication Menu");
            System.out.println("1. Browse Jobs");
            System.out.println("2. View and remove");
            System.out.println("3. Search My Applications");
            System.out.println("4. Exit");

            choice = Input.getIntegerInput("Enter your choice > ");

            switch (choice) {
                case 1 ->
                    JobApplicationManager.browseJobs();

                case 2 ->
                    JobApplicationManager.CancelApplication();

                case 3 -> {
                    String searchTerm = Input.getStringInput("Enter keyword to search applications: ");
                    JobApplicationManager.searchMyApplications(searchTerm);
                }

                case 4 -> {
                    System.out.println("Thank you for using the Job Application System! Goodbye.");
                    return;
                }
                default ->
                    MessageUI.errorMessage();
            }

        } while (true);
    }
}
