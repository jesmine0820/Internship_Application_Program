package Control;

import ADT.DoublyLinkedList;
import ADT.ListInterface;
import Boundary.ScheduleUI;
import Dao.Database;
import Entity.Applicant;
import Entity.Employer;
import Entity.Schedule;
import Utility.Input;
import Utility.MessageUI;
import Utility.Tools;
import Utility.Validation;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author User
 */
public class ScheduleManager {

    private static final ListInterface<Schedule> scheduleList = new DoublyLinkedList<>();

    public static void employerScheduleMenu() {
        int choice;
        do {
            choice = ScheduleUI.employerScheduleMenu();
            switch (choice) {
                case 1 ->
                    addSchedule();
                case 2 ->
                    updateSchedule();
                case 3 ->
                    cancelInterview();
                case 4 ->
                    Tools.back();
                default ->
                    MessageUI.errorMessage();
            }
        } while (choice != 4);
    }

    public static void addSchedule() {
        boolean error;
        String name;
        String dateString;
        Date interviewDate = null;
        String timeString;
        Date interviewTime = null;
        String interviewMode = null;
        String venue = null;
        Date followUpDate;
        Date followUpTime;
        String status = "Scheduled";
        Employer employer;
        Applicant applicant = null;

        employer = Database.getEmployer();

        // Get applicant name
        do {
            error = false;
            name = ScheduleUI.getApplicantName();
            if (!Validation.checkString(name) || !Validation.checkApplicant(name)) {
                if (!Validation.checkString(name)) {
                    System.out.println("Check string");
                }
                if (!Validation.checkApplicant(name)) {
                    System.out.println("No applicant");
                }
                error = true;
            }
            if (!error) {
                applicant = getApplicant(name);
            }
        } while (error);

        // Get interview date
        do {
            error = false;
            dateString = ScheduleUI.getDate();
            interviewDate = Validation.checkDate(dateString);
            if (interviewDate == null) {
                error = true;
            }
        } while (error);

        // Get interview time
        do {
            error = false;
            timeString = ScheduleUI.getTime();
            interviewTime = Validation.checkTime(timeString);
            if (interviewTime == null) {
                error = true;
            }
        } while (error);

        // Get interview mode and venue
        do {
            error = false;
            int choice = ScheduleUI.getInterviewMode();
            switch (choice) {
                case 1 -> {
                    interviewMode = "Online";
                    venue = "Zoom";
                }
                case 2 -> {
                    interviewMode = "Offline";
                    venue = ScheduleUI.getVenue();
                }
                default -> {
                    error = true;
                    MessageUI.errorMessage();
                }
            }
        } while (error);

        // Get follow up date
        do {
            error = false;
            String followUpDateStr = ScheduleUI.updateFollowUpDate();
            followUpDate = Validation.checkDate(followUpDateStr);
            if (followUpDate == null) {
                error = true;
            }
        } while (error);

        // Get follow up time
        do {
            error = false;
            String followUpTimeStr = ScheduleUI.updateFollowUpTime();
            followUpTime = Validation.checkTime(followUpTimeStr);
            if (followUpTime == null) {
                error = true;
            }
        } while (error);

        // Ask user for confirmation, print successful msg
        System.out.println("\nDo you want to confirm and save the schedule?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int confirm = Input.getIntegerInput("Enter your choice > ");

        if (confirm == 1) {
            Schedule schedule = new Schedule(
                    interviewDate,
                    interviewTime,
                    interviewMode,
                    venue,
                    followUpDate,
                    followUpTime,
                    status,
                    employer,
                    applicant
            );

            // Add to local and global list
            scheduleList.add(schedule);
            Database.schedules.add(schedule);

            System.out.println("Schedule added successfully!");
        } else {
            System.out.println("Schedule was not added.");
        }

        Tools.systemPause();
    }

    public static void updateSchedule() {
        boolean error;
        String name;
        Date interviewDate = null;
        String status = null;
        Schedule schedule = null;

        // 1. Identify the schedule using applicant name + interview date
        do {
            error = false;
            name = ScheduleUI.getApplicantName();
            if (!Validation.checkString(name) || !Validation.checkApplicant(name)) {
                System.out.println("Invalid name or applicant not found.");
                error = true;
                continue;
            }

            // Prompt for interview date to narrow it down
            String interviewDateStr = ScheduleUI.getInterviewDate();  // Assumes this method exists
            interviewDate = Validation.checkDate(interviewDateStr);
            if (interviewDate == null) {
                System.out.println("Invalid date format. Please try again.");
                error = true;
                continue;
            }

            // Try to find the schedule
            schedule = null;
            for (Schedule s : Database.schedules) {
                if (s.getApplicant() != null
                        && s.getApplicant().getName().equalsIgnoreCase(name)
                        && s.getInterviewDate().equals(interviewDate)) {
                    schedule = s;
                    break;
                }
            }

            if (schedule == null) {
                System.out.println("No schedule found for applicant '" + name + "' on that date.");
                error = true;
            }
        } while (error);

        // 2. Update interview date and time if needed
        System.out.print("Would you like to update the interview date or time? (1 = Yes, 2 = No) > ");
        if (Input.getIntegerInput() == 1) {
            Date newInterviewDate = null;
            Date newInterviewTime = null;

            // Get new interview date
            do {
                error = false;
                String newDateStr = ScheduleUI.getDate(); // prompt for new interview date
                newInterviewDate = Validation.checkDate(newDateStr);
                if (newInterviewDate == null) {
                    System.out.println("Invalid date format.");
                    error = true;
                }
            } while (error);

            // Get new interview time
            do {
                error = false;
                String newTimeStr = ScheduleUI.getTime(); // prompt for new interview time
                newInterviewTime = Validation.checkTime(newTimeStr);
                if (newInterviewTime == null) {
                    System.out.println("Invalid time format.");
                    error = true;
                }
            } while (error);

            // Update the schedule with new date and time
            schedule.setInterviewDate(newInterviewDate);
            schedule.setInterviewTime(newInterviewTime);

            System.out.println("Interview date and time updated successfully.");
        }

        // 3. Get new status
        do {
            error = false;
            int choice = ScheduleUI.updateStatus();
            switch (choice) {
                case 1 ->
                    status = "Scheduled";
                case 2 ->
                    status = "Completed";
                case 3 ->
                    status = "Canceled";
                default -> {
                    error = true;
                    MessageUI.errorMessage();
                }
            }
        } while (error);

        // 4. Get score if status is "Completed"
        int score = -1;
        if ("Completed".equals(status)) {
            do {
                error = false;
                System.out.print("Enter interview score (0-100) > ");
                score = Input.getIntegerInput();
                if (score < 0 || score > 100) {
                    System.out.println("Invalid score. Please enter a value between 0 and 100.");
                    error = true;
                }
            } while (error);
        }

        // 5. Confirm and apply update
        System.out.print("Are you sure you want to update this schedule? (1 = Yes, 2 = No) > ");
        if (Input.getIntegerInput() == 1) {
            schedule.setStatus(status);
            if (score != -1) {
                schedule.setScore(score);
            }

            // Date Formatting for display
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

            String formattedInterviewDate = dateFormat.format(schedule.getInterviewDate());
            String formattedInterviewTime = timeFormat.format(schedule.getInterviewTime());

            System.out.println("\n=== UPDATED SCHEDULE ===");
            System.out.println("Applicant: " + name);
            System.out.println("Updated Interview Date: " + formattedInterviewDate);
            System.out.println("Updated Interview Time: " + formattedInterviewTime);
            System.out.println("New Status: " + status);
            System.out.println("New Score: " + (score != -1 ? score : 0));

            System.out.println("Update successful!");
        } else {
            System.out.println("Update cancelled.");
        }

        Tools.systemPause();
    }

    public static void updateInterviewDateTime() {
        boolean error;
        String name;
        String interviewDateString;
        Date oldInterviewDate = null;
        Schedule schedule = null;

        // 1. Identify schedule using name + current interview date
        do {
            error = false;
            name = ScheduleUI.getApplicantName();
            interviewDateString = ScheduleUI.getInterviewDate();
            oldInterviewDate = Validation.checkDate(interviewDateString);

            if (!Validation.checkString(name) || !Validation.checkApplicant(name) || oldInterviewDate == null) {
                System.out.println("Invalid name or date, or applicant not found.");
                error = true;
            } else {
                schedule = getSchedule(name, oldInterviewDate);
                if (schedule == null) {
                    System.out.println("No schedule found for " + name + " on " + interviewDateString);
                    error = true;
                }
            }
        } while (error);

        // 2. Get new date
        Date newDate = null;
        do {
            error = false;
            String newDateStr = ScheduleUI.getDate();
            newDate = Validation.checkDate(newDateStr);
            if (newDate == null) {
                System.out.println("Invalid date format.");
                error = true;
            }
        } while (error);

        // 3. Get new time
        Date newTime = null;
        do {
            error = false;
            String newTimeStr = ScheduleUI.getTime(); // prompt: "Enter new interview time"
            newTime = Validation.checkTime(newTimeStr);
            if (newTime == null) {
                System.out.println("Invalid time format.");
                error = true;
            }
        } while (error);

        // 4. Confirm update
        System.out.print("Are you sure you want to update the interview date and time? (1 = Yes, 2 = No) > ");
        if (Input.getIntegerInput() == 1) {
            schedule.setInterviewDate(newDate);
            schedule.setInterviewTime(newTime);
            System.out.println("Interview date and time updated successfully.");
        } else {
            System.out.println("Update canceled.");
        }

        Tools.systemPause();
    }

    public static void displaySchedule() {
        ListInterface<Schedule> schedules = Database.schedules;
        ListInterface<Schedule> results = new DoublyLinkedList<>();
        Employer currentEmployer = null;
        Applicant currentApplicant = null;

        // Get current user
        if (UserManager.isEmployer()) {
            currentEmployer = Database.getEmployer();
        } else if (UserManager.isApplicant()) {
            currentApplicant = Database.getApplicant();
        }

        // Filter schedules based on user type
        if (currentEmployer != null) {
            for (Schedule sc : schedules) {
                Employer scheduleEmployer = sc.getEmployer();
                if (scheduleEmployer != null && scheduleEmployer.getId().equals(currentEmployer.getId())) {
                    results.add(sc);
                }
            }
        } else if (currentApplicant != null) {
            for (Schedule sc : schedules) {
                Applicant scheduleApplicant = sc.getApplicant();
                if (scheduleApplicant != null && scheduleApplicant.getId().equals(currentApplicant.getId())) {
                    results.add(sc);
                }
            }
        }

        // Display results
        System.out.println("\n=== FILTER RESULTS ===");
        System.out.println("Found " + results.size() + " matching schedules");

        if (!results.isEmpty()) {
            ScheduleUI.displaySchedule(results);
        } else {
            MessageUI.noScheduled();
        }
        Tools.systemPause();
    }

    public static void cancelInterview() {
        boolean error;
        String name;
        Applicant applicant = null;
        Schedule schedule = null;
        String dateString;
        Date interviewDate = null;

        do {
            error = false;
            name = ScheduleUI.getApplicantName();
            if (!Validation.checkString(name) || !Validation.checkApplicant(name)) {
                System.out.println("Invalid name or applicant not found.");
                error = true;
            } else {
                applicant = getApplicant(name);
            }
        } while (error);

        do {
            error = false;
            dateString = ScheduleUI.getDate();
            if (Validation.checkDate(dateString) == null) {
                System.out.println("Invalid date format. Please try again.");
                error = true;
            } else {
                interviewDate = Validation.checkDate(dateString);
            }
        } while (error);

        Schedule targetSchedule = null;
        for (Schedule s : Database.schedules) {
            if (s.getApplicant().equals(applicant) && s.getInterviewDate().equals(interviewDate)) {
                targetSchedule = s;
                break;
            }
        }

        if (targetSchedule != null) {
            System.out.print("Are you sure you want to cancel this interview? (1 = Yes, 2 = No) > ");
            int confirm = Input.getIntegerInput("");
            if (confirm == 1) {
                targetSchedule.setStatus("Canceled");
                System.out.println("Interview for " + name + " on " + dateString + " has been successfully canceled.\n");
            } else {
                System.out.println("Cancellation aborted.\n");
            }
        } else {
            System.out.println("No matching interview found for the given applicant and date.\n");
        }
        Tools.systemPause();
    }

    // Get the specific applicant
    private static Applicant getApplicant(String name) {
        Applicant applicant = null;
        ListInterface<Applicant> applicantList = Database.applicants;
        for (int i = 0; i < applicantList.size(); i++) {
            if (applicantList.get(i).getName().equals(name)) {
                applicant = applicantList.get(i);
            }
        }
        return applicant;
    }

    public static Schedule getSchedule(String name, Date interviewDate) {
        for (Schedule schedule : Database.schedules) {
            if (schedule.getApplicant() != null
                    && schedule.getApplicant().getName().equalsIgnoreCase(name)
                    && schedule.getInterviewDate().equals(interviewDate)) {
                return schedule;
            }
        }
        return null;
    }

}
