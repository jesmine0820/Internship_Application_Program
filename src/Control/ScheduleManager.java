package Control;

import ADT.DoublyLinkedList;
import ADT.ListInterface;
import Boundary.ScheduleUI;
import Boundary.UserUI;
import Dao.Database;
import Entity.Applicant;
import Entity.Employer;
import Entity.Job;
import Entity.JobApplication;
import Entity.Schedule;
import Utility.ChooseSetting;
import Utility.Input;
import Utility.MessageUI;
import Utility.Tools;
import static Utility.Tools.BLUE;
import static Utility.Tools.GREEN;
import static Utility.Tools.RED;
import static Utility.Tools.RESET;
import Utility.Validation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Chan Jing Hui
 * 
 */
public class ScheduleManager {

    private static final ListInterface<Schedule> scheduleList = new DoublyLinkedList<>();
    private static final ListInterface<JobApplication> pendingApplication = new DoublyLinkedList<>();
    
    private static final SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
    private static final SimpleDateFormat intMonthFormat = new SimpleDateFormat("MM");
    private static final SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM"); 
    private static final SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    private static final SimpleDateFormat dayOfWeekFormat = new SimpleDateFormat("EEE");
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

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
                    editScheduleItem();
                case 4 ->
                    cancelInterview();
                case 5 ->
                    Tools.back();
                default ->
                    MessageUI.errorMessage();
            }
        } while (choice != 5);
    }

    public static void addSchedule() {
        Tools.clearScreen();
        UserUI.headLine();

        boolean error;
        String name;
        Date interviewDate;
        String interviewDuration;
        Date interviewTime;
        String interviewMode;
        String venue;
        Date followUpDate = null;
        Date followUpTime = null;
        String status = "Scheduled";
        Employer employer;
        Applicant applicant = null;

        employer = Database.getEmployer();

        if (employer == null) {
            MessageUI.emptyEmployerMessage();
            return;
        }

        boolean responses = true;
        while (responses) {
            displayCalendar(employer);

            displayPendingApplicant(employer);
            
            boolean hasApplicants = displayPendingApplicant(employer);
                if (!hasApplicants) {
                    Tools.systemPause();
                    return;
                }

            // Get the applicant name and ensure it's valid
            do {
                name = Validation.checkString("Enter applicant name: ");
                applicant = getApplicant(name);

                if (applicant == null) {
                    MessageUI.emptyApplicantMessage();
                }
            } while (applicant == null);

            venue = Input.getChoiceInput("Enter interview venue > ", ChooseSetting.VENUE_OPTIONS);
            displayVenueTimetable(venue, employer);

            interviewDate = Validation.checkDate("Enter interview date: ");
            interviewDuration = Input.getChoiceInput("Enter Duration: ", ChooseSetting.DURATIONS);

            displayVenueSlotTimetable(venue, employer, interviewDate, interviewDuration);

            Date suggestedTime = getNextAvailableTime(venue, employer, interviewDate, interviewDuration);
            if (suggestedTime != null) {
                System.out.println("Suggested Available Time: " + new SimpleDateFormat("HH:mm").format(suggestedTime));
            } else {
                System.out.println("No available slots at this venue on this day.");
            }

            do {
                interviewTime = Validation.checkTime("Enter interview time: ");
                
                if (isScheduleClash(interviewDate, interviewTime, venue, interviewDuration)) {
                    System.out.println("Schedule clash detected at the same time and venue! Please choose a different slot.\n");
                    displayVenueTimetable(venue, employer);
                    System.out.println("Try selecting a different time.");
                } else {
                    break;
                }
            } while (true);

            interviewMode = Input.getChoiceInput("Enter your interview mode > ", ChooseSetting.INTERVIEW_MODE_OPTIONS);

            Job job = getJobFromList(employer, applicant);
            
            Schedule schedule = new Schedule(interviewDate, interviewDuration, interviewTime, interviewMode, venue, followUpDate, followUpTime, status, employer, applicant, job, null);            scheduleList.add(schedule);
            scheduleList.add(schedule);
            Database.schedules.add(schedule);
            for (int i = 0; i < applicant.getJobApplication().size(); i++) {
                JobApplication application = applicant.getJobApplication().get(i);

                // Check against all employer jobs
                for (int j = 0; j < employer.getJob().size(); j++) {
                    Job employerJob = employer.getJob().get(j);

                    if (application.getJob().getJobTitle().equalsIgnoreCase(employerJob.getJobTitle())) {
                        application.setStatus("Scheduled");
                        break;
                    }
                }
            }

            System.out.println("\n--- Updated Job Applications for " + applicant.getName() + " ---");
            for (int i = 0; i < applicant.getJobApplication().size(); i++) {
                JobApplication application = applicant.getJobApplication().get(i);
                System.out.println("Job Title: " + application.getJob().getJobTitle());
                System.out.println("Status   : " + application.getStatus());
                System.out.println("------------------------------------------");
            }

            ScheduleUI.successfulMessage();

            System.out.println("\nUpdated Timetable for " + venue + " on " + new SimpleDateFormat("yyyy-MM-dd").format(interviewDate) + ":");
            displayVenueTimetable(venue, employer);

            String anotherSchedule = Input.getYesNoInput("Do you want to arrange another schedule? (yes/no): ");
            if (!anotherSchedule.equalsIgnoreCase("yes")) {
                return;
            }
        }
    }
 
    public static void updateSchedule() {
        boolean error;
        String name;
        Date followUpDate = null;
        Date followUpTime = null;
        String status;
        Schedule schedule = null;
        Applicant applicant = null;
        Employer employer = Database.getEmployer();

        String[] statusOptions = {"Canceled", "Completed"};

        displayCalendar(employer);

        do {
            error = false;
            name = Validation.checkString("Enter applicant name: ");
            if (!Validation.checkApplicant(name)) {
                error = true;
            } else {
                applicant = getApplicant(name);
            }
        } while (error);

        for (Schedule list : Database.schedules) {
            if (list.getApplicant().equals(applicant)) {
                schedule = list;
            }
        }
        
        int score = Input.getIntegerInput("Enter interview score > ");

        status = Input.getChoiceInput("Choose status to update > ", statusOptions);
        if (!status.equals("Canceled")) {
            followUpDate = Validation.checkDate("Enter follow up date > ");
            followUpTime = Validation.checkTime("Enter follow up time > ");
        }

        // Update 
        schedule.setScore(score);
        schedule.setFollowUpDate(followUpDate);
        schedule.setFollowUpTime(followUpTime);
        schedule.setStatus(status);

        ScheduleUI.successfulMessage();
    }

    public static void editScheduleItem() {

        boolean error;
        int choice;
        String name;
        Schedule schedule = null;
        Applicant applicant = null;
        Employer employer = Database.getEmployer();

        Tools.clearScreen();
        displayCalendar(employer);
        boolean hasApplicants = displayScheduledComplete(employer);
        if (!hasApplicants) {
            Tools.systemPause();
            return;
        }

        do {
            error = false;
            name = Validation.checkString("Enter applicant name: ");
            if (!Validation.checkApplicant(name)) {
                error = true;
            } else {
                applicant = getApplicant(name);
            }
        } while (error);

        for (Schedule list : Database.schedules) {
            if (list.getApplicant().equals(applicant)) {
                schedule = list;
            }
        }

        do {
            choice = ScheduleUI.editScheduleMenu();
            switch (choice) {
                case 1 ->
                    editInterviewDate(schedule);
                case 2 ->
                    editFollowUpDate(schedule);
                case 3 ->
                    editVenue(schedule);
                case 4 ->
                    editInterviewMode(schedule);
                case 5 ->
                    Tools.back();
                default ->
                    MessageUI.errorMessage();
            }
        } while (choice != 4);

    }
    
    private static void editInterviewDate(Schedule schedule) {
        Employer employer = schedule.getEmployer();
        String venue = schedule.getVenue();
        String interviewDuration = schedule.getInterviewDuration();

        displayVenueTimetable(venue, employer);

        Date interviewDate = Validation.checkDate("Enter new interview date > ");
        displayVenueSlotTimetable(venue, employer, interviewDate, interviewDuration);

        Date suggestedTime = getNextAvailableTime(venue, employer, interviewDate, interviewDuration);
        if (suggestedTime != null) {
            System.out.println("Suggested Available Time: " + new SimpleDateFormat("HH:mm").format(suggestedTime));
        } else {
            System.out.println(" No available slots at this venue on this date.");
        }

        Date interviewTime;
        while (true) {
            interviewTime = Validation.checkTime("Enter new interview time > ");

            if (ScheduleManager.isScheduleClash(interviewDate, interviewTime, venue, interviewDuration)) {
                System.out.println("Time slot is already booked. Please choose another time.\n");
                ScheduleManager.displayVenueSlotTimetable(venue, employer, interviewDate, interviewDuration);
            } else {
                break;
            }
        }

        // Update schedule
        schedule.setInterviewDate(interviewDate);
        schedule.setInterviewTime(interviewTime);
        ScheduleUI.successfulMessage();
    }

    private static void editFollowUpDate(Schedule schedule) {
        if (schedule.getFollowUpTime() == null) {
            System.out.println(RED + "Haven't assign follow up date" + RESET);
            Tools.systemPause();
        } else {
            Date followUpDate = Validation.checkDate("Enter new follow up date > ");
            Date followUpTime = Validation.checkTime("Enter new follow up time > ");
            schedule.setFollowUpDate(followUpDate);
            schedule.setFollowUpTime(followUpTime);
            ScheduleUI.successfulMessage();
        }
    }

    private static void editVenue(Schedule schedule) {
        Employer employer = schedule.getEmployer();
        Date interviewDate = schedule.getInterviewDate();
        Date interviewTime = schedule.getInterviewTime();
        String interviewDuration = schedule.getInterviewDuration();

        String venue = Input.getChoiceInput("Enter new venue > ", ChooseSetting.VENUE_OPTIONS);

        System.out.println("\nTimetable for new venue: " + venue);
        displayVenueTimetable(venue, employer);

        displayVenueSlotTimetable(venue, employer, interviewDate, interviewDuration);

        boolean hasClash = ScheduleManager.isScheduleClash(interviewDate, interviewTime, venue, interviewDuration);
        if (hasClash) {
            System.out.println("Warning: The current interview time ("
                    + new SimpleDateFormat("HH:mm").format(interviewTime)
                    + ") clashes with an existing schedule at this venue.");

            String proceed = Input.getYesNoInput("Do you still want to change to this venue? (yes/no) > ");
            if (!proceed.equalsIgnoreCase("yes")) {
                System.out.println("Venue update cancelled.");
                return;
            }
        }

        schedule.setVenue(venue);
        System.out.println("\nUpdated Timetable for " + venue + " on " + new SimpleDateFormat("yyyy-MM-dd").format(interviewDate) + ":");
        displayVenueTimetable(venue, employer);
        ScheduleUI.successfulMessage();

    }

    private static void editInterviewMode(Schedule schedule) {
        String interviewMode = schedule.getInterviewMode();
        String yesNo;
        String venue;

        if (interviewMode.equals("Online")) {
            yesNo = Input.getYesNoInput("Confirm to switch to offline? (y/n) > ");
            if (yesNo.equalsIgnoreCase("y")) {
                venue = Input.getStringInput("Enter venue > ");
                schedule.setInterviewMode("Offline");
                schedule.setVenue(venue);
            } else {
                schedule.setInterviewMode("Online");
                schedule.setVenue("N/A");
            }
        }
    }
    
    public static void cancelInterview() {
        boolean error;
        String cancel;
        String name;
        Schedule schedule;
        Applicant applicant = null;
        Employer employer = Database.getEmployer();
        boolean hasApplicants = displayScheduledComplete(employer);
        if (!hasApplicants) {
            Tools.systemPause();
            return;
        }

        do {
            error = false;
            name = Validation.checkString("Enter applicant name: ");
            if (!Validation.checkApplicant(name)) {
                error = true;
            } else {
                applicant = getApplicant(name);
            }
        } while (error);

        schedule = getSchedule(employer, applicant);
        if (schedule != null) {
            Date interviewDate = schedule.getInterviewDate();
            Date interviewTime = schedule.getInterviewTime();
            Date followUpDate = schedule.getFollowUpDate();
            Date followUpTime = schedule.getFollowUpTime();
            String venue = schedule.getVenue();

            System.out.println("---------------------------------------------------");
            System.out.println("Interview Date > " + interviewDate);
            System.out.println("Interview Time > " + interviewTime);
            System.out.println("Follow Up Date > " + followUpDate);
            System.out.println("Follow Up Time > " + followUpTime);
            System.out.println("Venue > " + venue);
            System.out.println("---------------------------------------------------");

            cancel = Input.getYesNoInput("Confirm to cancel this interview? (y/n) > ");
            if (cancel.equalsIgnoreCase("y")) {
                scheduleList.remove(schedule);
                Database.schedules.remove(schedule);
                for (int i = 0; i < applicant.getJobApplication().size(); i++) {
                    JobApplication application = applicant.getJobApplication().get(i);

                    for (int j = 0; j < schedule.getEmployer().getJob().size(); j++) {
                        Job employerJob = schedule.getEmployer().getJob().get(j);

                        if (application.getJob().getJobTitle().equals(employerJob.getJobTitle())
                                && application.getJob().getEmployer().equals(employerJob.getEmployer())) {

                            application.setStatus("Cancelled");
                            break;
                        }
                    }
                }
                MessageUI.deleteSuccessful();
            } else {
                MessageUI.nothing();
            }
        } else {
            System.out.println("No interview found!");
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

        if (!results.isEmpty()) {
            displayScheduleList(results);
        } else {
            MessageUI.noScheduled();
        }
        Tools.systemPause();
    }
    
    public static void displayScheduleList(ListInterface<Schedule> scheduleList) {
        
        boolean isEmployer = UserManager.isEmployer();
        
        ScheduleUI.displayScheduleHeader();

        if (isEmployer) {
            Employer employer = Database.getEmployer();
            displayCalendar(employer);
            System.out.println("\n\n                        -------------------------------------------------------------");
            System.out.println("                            |                     Overview Time Table                    |");
            System.out.println("                            -------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-4s | %-15s | %-10s | %-6s | %-15s | %-16s | %-15s | %-10s | %-6s%n",
                    "No", "Name", "Date", "Time", "Venue", "Follow Up Date", "Follow Up Time", "Status", "Score");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        } else {
            Applicant applicant = Database.getApplicant();
            displayCalendar(applicant);
            System.out.println("\n\n            --------------------------------------------");
            System.out.println("            |           Overview Time Table            |");
            System.out.println("            --------------------------------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.printf("%-4s | %-15s | %-10s | %-6s | %-15s%n",
                    "No", "Name", "Date", "Time", "Venue");
            System.out.println("----------------------------------------------------------------------");
        }
        int no = 1;
        for (Schedule item : scheduleList) {
            Applicant applicant = item.getApplicant();
            String name = applicant.getName();

            String formattedInterviewDate = dateFormat.format(item.getInterviewDate());
            String formattedInterviewTime = timeFormat.format(item.getInterviewTime());

            if (isEmployer) {
                String formattedFollowUpDate = (item.getFollowUpDate() != null) ? dateFormat.format(item.getFollowUpDate()) : "N/A";
                String formattedFollowUpTime = (item.getFollowUpTime() != null) ? timeFormat.format(item.getFollowUpTime()) : "N/A";

                System.out.printf("%-4d | %-15s | %-10s | %-6s | %-15s | %-16s | %-15s",
                        no++, name, formattedInterviewDate, formattedInterviewTime,
                        item.getVenue(), formattedFollowUpDate, formattedFollowUpTime);
            } else {
                System.out.printf("%-4d | %-15s | %-10s | %-6s | %-15s%n",
                        no++, name, formattedInterviewDate, formattedInterviewTime,
                        item.getVenue());
            }
        }
        
        if(isEmployer){
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        } else {
            System.out.println("----------------------------------------------------------------------");
        }
        
        String yesNo;
        boolean error = false;
        Date today = Database.getCurrentDate();
        
        if(isEmployer){
            Employer employer = Database.getEmployer();
            do{
                yesNo = Input.getYesNoInput("Do you want to view calendar? (Y/N) > ");
                if(yesNo.equalsIgnoreCase("Yes") || yesNo.equalsIgnoreCase("y")){
                    int year = 0;
                    int month = 0;
                    while(error){
                        error = false;
                        year = Input.getIntegerInput("Choose a year > ");
                        if(year < 2024){
                            System.out.println(RED + "Cannot choose a previous year! " + RESET);
                            error = true;
                        }
                        month = Input.getIntegerInput("Choose a month > ");
                        int currentMonth = Integer.parseInt(intMonthFormat.format(today));
                        if(month > currentMonth){
                            System.out.println(RED + "Cannot choose a previous month! " + RESET);
                            error = true;
                        }
                        if(month < 1 || month > 12){
                            System.out.println(RED + "Invalid month! " + RED);
                            error = true;
                        }
                    }
                    Tools.clearScreen();
                    UserManager.profileHeadLine();
                    displayCalendar(employer, year, month);
                }
            } while(yesNo.equalsIgnoreCase("Yes") || yesNo.equalsIgnoreCase("y"));
        } else {
            Applicant applicant = Database.getApplicant();
            do {
                yesNo = Input.getYesNoInput("Do you want to view calendar? (Y/N) > ");

                if (yesNo.equalsIgnoreCase("Yes") || yesNo.equalsIgnoreCase("y")) {
                    int year = 0;
                    int month = 0;

                    error = true;

                    while (error) {
                        error = false;

                        year = Input.getIntegerInput("Choose a year > ");
                        if (year < 2024) {
                            System.out.println(RED + "Cannot choose a previous year! " + RESET);
                            error = true;
                            continue;
                        }

                        month = Input.getIntegerInput("Choose a month > ");

                        if (month < 1 || month > 12) {
                            System.out.println(RED + "Invalid month! " + RESET);
                            error = true;
                        }
                    }
                    Tools.clearScreen();
                    UserManager.profileHeadLine();
                    displayCalendar(applicant, year, month);
                }
            } while (yesNo.equalsIgnoreCase("Yes") || yesNo.equalsIgnoreCase("y"));
        }
    }

    private static Schedule getSchedule(Employer employer, Applicant applicant) {
        
        Schedule result = null;
        
        for (Schedule schedule : Database.schedules) {
            if (schedule.getEmployer().equals(employer) && schedule.getApplicant().equals(applicant)) {
                result = schedule;
            }
        }
        return result;
    } 
    
    // Compare a list of string
    private static boolean compareStringList(String[] stringList, String month){
        for (String list : stringList) {
            if(month.equals(list)){
                return true;
            }
        }
        return false;
    }
    
    // ------------------------------------------ by Jesmine Tey Khai Jing ----------------------------------------------------
    
    // Display calendar for current month
    public static <T> void displayCalendar(T object){
        
        ListInterface<Schedule> list = new DoublyLinkedList<>();
        Employer employer = null;
        Applicant applicant = null;
        
        if(object == null){
            MessageUI.nothing();
        }
        
        if(!(object instanceof Employer)){
            applicant = (Applicant)object;
        } else {
            employer = (Employer)object;
        }
        
        if(employer != null){
            for(Schedule schedule : Database.schedules){
                if(schedule.getEmployer().equals(employer)){
                    list.add(schedule);
                }
            }
            if(!list.isEmpty()){
                displayCalendarForm(Database.getCurrentDate(), list, employer);
            } else {
                MessageUI.emptyDatabase();
            }
        } else {
            for(Schedule schedule : Database.schedules){
                if(schedule.getApplicant().equals(applicant)){
                    list.add(schedule);
                }
            }
            if(!list.isEmpty()){
                displayCalendarForm(Database.getCurrentDate(), list, applicant);
            } else {
                MessageUI.emptyDatabase();
            }
        }
        
    }
    
    // Display specific year and month calendar
    public static <T> void displayCalendar(T object, int year, int month){
        
        ListInterface<Schedule> list = new DoublyLinkedList<>();
        Employer employer = null;
        Applicant applicant = null;
        Date date;
        String dateString = year + "-" + month + "-01";
        try{
            date = dateFormat.parse(dateString);
        } catch (ParseException e){
            MessageUI.errorMessage();
            date = Database.getCurrentDate();
        }
        
        if(object == null){
            MessageUI.nothing();
        }
        
        if(!(object instanceof Employer)){
            applicant = (Applicant)object;
        } else {
            employer = (Employer)object;
        }
        
        if(employer != null){
            for(Schedule schedule : Database.schedules){
                if(schedule.getEmployer().equals(employer)){
                    list.add(schedule);
                }
            }
            if(!list.isEmpty()){
                displayCalendarForm(date, list, employer);
            } else {
                MessageUI.emptyDatabase();
            }
        } else {
            for(Schedule schedule : Database.schedules){
                if(schedule.getApplicant().equals(applicant)){
                    list.add(schedule);
                }
            }
            if(!list.isEmpty()){
                displayCalendarForm(date, list, applicant);
            } else {
                MessageUI.emptyDatabase();
            }
        }
        
    }

    // Display calendar body
    private static void displayCalendarForm(Date date, ListInterface<Schedule> list, Object object){
        
        int[][] calendar = new int[5][7];
               
        String monthName = monthFormat.format(date);
        String monthInt = intMonthFormat.format(date);
        String yearString = yearFormat.format(date);
        
        int count = 1;
        int totalDays;
        int startPosition = 0;
        int year = Integer.parseInt(yearString);
        int month = Integer.parseInt(monthInt);
        
        String firstDayString = String.format("%04d-%02d-01", year, month);
        Date firstDayDate = null;
        try{
            firstDayDate = dateFormat.parse(firstDayString);
        } catch (ParseException e){
            MessageUI.errorMessage();
        }
        String firstDayOfWeek = dayOfWeekFormat.format(firstDayDate);
        
        String[] month_31 = {
            "January", "March", "May", "July", "August", "October", "December"
        };
        String[] month_30 = {
            "April", "June", "September", "November"
        };
        
        if(compareStringList(month_31, monthName)){
            totalDays = 31;
        } else if(compareStringList(month_30, monthName)){
            totalDays = 30;
        } else if(year % 4 == 0){
            totalDays = 29;
        } else {
            totalDays = 28;
        }
        
        switch(firstDayOfWeek){
            case "Mon" -> startPosition = 1;
            case "Tue" -> startPosition = 2;
            case "Wed" -> startPosition = 3;
            case "Thu" -> startPosition = 4;
            case "Fri" -> startPosition = 5;
            case "Sat" -> startPosition = 6;
            case "Sun" -> startPosition = 7;
        }
        
        ScheduleUI.displayCalendarHeader(monthName, year);
        
        for (int row = 0; row < 5; row++) {
            System.out.println("------------------------------------------");
            for (int column = 0; column < 7; column++) {
                if (count >= totalDays + 1) {
                    System.out.print("|    |");
                } else if ((row == 0) && (column < startPosition)) {
                    System.out.print("|    |");
                } else {
                    if (scheduleDateList(year, month, count)) {
                        calendar[row][column] = count;
                        System.out.printf(RED + "| %02d |" + RESET, calendar[row][column]);
                    } else if (column == 5 || column == 6) {
                        calendar[row][column] = count;
                        System.out.printf(BLUE + "| %02d |" + RESET, calendar[row][column]);
                    } else if (checkToday(year, month, count)){
                        calendar[row][column] = count;
                        System.out.printf(GREEN + "| %02d |" + RESET, calendar[row][column]);
                    } else {
                        calendar[row][column] = count;
                        System.out.printf("| %02d |", calendar[row][column]);
                    }
                    count++;
                }
            }
            System.out.println("\n------------------------------------------");
        }
        
        ScheduleUI.displayCalendarFooter();
        
        boolean isEmployer = object instanceof Employer;
        int index = 1;
        boolean hasInterviews = false;

        String header = isEmployer
            ? String.format(" %-3s | %-15s | %-6s | %-12s | %-5s | %-15s", 
                "No", "Applicant Name", "Job ID", "Date", "Time", "Venue")
            : String.format(" %-3s | %-6s | %-12s | %-5s | %-15s", 
                "No", "Job ID", "Date", "Time", "Venue");

        String divider = isEmployer
            ? "-------------------------------------------------------------"
            : "-----------------------------------------------------";

        StringBuilder interviewList = new StringBuilder();

        for (Schedule schedule : list) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(schedule.getInterviewDate());

            int schedYear = cal.get(Calendar.YEAR);
            int schedMonth = cal.get(Calendar.MONTH) + 1;

            if (schedYear == year && schedMonth == month) {
                hasInterviews = true;

                String dateStr = dateFormat.format(schedule.getInterviewDate());
                String timeStr = timeFormat.format(schedule.getInterviewTime());
                String venue = schedule.getVenue();
                String jobId = schedule.getJob().getJobID();

                if (isEmployer) {
                    String applicantName = schedule.getApplicant().getName(); 
                    interviewList.append(String.format(" %-3d | %-15s | %-6s | %-12s | %-5s | %-15s\n",
                        index++, applicantName, jobId, dateStr, timeStr, venue));
                } else {
                    interviewList.append(String.format(" %-3d | %-6s | %-12s | %-5s | %-15s\n",
                        index++, jobId, dateStr, timeStr, venue));
                }
            }
        }

        if (hasInterviews) {
            System.out.println("\nScheduled Interviews:");
            System.out.println(divider);
            System.out.println(header);
            System.out.println(divider);
            System.out.print(interviewList);
            System.out.println(divider);
        }
    }
    
    //  Get the scheduled date
    private static boolean scheduleDateList(int year, int month, int date){

        Date scheduledDate;
        String currentYearString;
        String currentMonthString;
        String currentDateString;
        int currentYear;
        int currentMonth;
        int currentDate;
        
        for(Schedule schedule : Database.schedules){
            if(UserManager.isEmployer()){
                Employer employer = Database.getEmployer();
                Employer currentEmployer = schedule.getEmployer();
                if(currentEmployer.equals(employer)){
                    scheduledDate = schedule.getInterviewDate();
                    currentYearString = yearFormat.format(scheduledDate);
                    currentMonthString = intMonthFormat.format(scheduledDate);
                    currentDateString = dateFormat.format(scheduledDate);
                    currentYear = Integer.parseInt(currentYearString);
                    currentMonth = Integer.parseInt(currentMonthString);
                    currentDate = Integer.parseInt(currentDateString);

                    if((year == currentYear) && (month == currentMonth) && (date == currentDate)){
                        return true;
                    }
                }
            } else {
                Applicant applicant = Database.getApplicant();
                Applicant currentApplicant = schedule.getApplicant();
                if(currentApplicant.equals(applicant)){
                    scheduledDate = schedule.getInterviewDate();
                    currentYearString = yearFormat.format(scheduledDate);
                    currentMonthString = intMonthFormat.format(scheduledDate);
                    currentDateString = dayFormat.format(scheduledDate);
                    currentYear = Integer.parseInt(currentYearString);
                    currentMonth = Integer.parseInt(currentMonthString);
                    currentDate = Integer.parseInt(currentDateString);

                    if((year == currentYear) && (month == currentMonth) && (date == currentDate)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    // Get current date
    private static boolean checkToday(int year, int month, int date){
        Date today = Database.getCurrentDate();

        int currentDate = Integer.parseInt(dayFormat.format(today));
        int currentMonth = Integer.parseInt(intMonthFormat.format(today));
        int currentYear = Integer.parseInt(yearFormat.format(today));
        
        return((currentDate == date) && (currentMonth == month) && (currentYear == year));
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
    
    //---------------------------------------Done by Kit Chin Jie Ying---------------------------------------------------------
    
    private static boolean displayPendingApplicant(Employer employer) {

        pendingApplication.clear();

        for (JobApplication app : Database.jobApplicationList) {
            if (app.getStatus().equalsIgnoreCase("Pending")
                    && app.getJob().getEmployer().equals(employer)) {

                Applicant appApplicant = app.getApplicant();

                boolean alreadyAdded = false;
                for (int i = 0; i < pendingApplication.size(); i++) {
                    if (pendingApplication.get(i).getApplicant().equals(appApplicant)) {
                        alreadyAdded = true;
                        break;
                    }
                }

                if (!alreadyAdded) {
                    pendingApplication.add(app);
                }
            }

        }
        if (pendingApplication.isEmpty()) {
            System.out.println(RED + "No applicants with pending applications under your posted jobs." + RESET);
            return false;
        }

        System.out.println("\nApplicants with Pending Applications:");
        for (int i = 0; i < pendingApplication.size(); i++) {
            JobApplication pendingApp = pendingApplication.get(i);
            System.out.printf("%d. %s (Job: %s) %s\n", i + 1,
                    pendingApp.getApplicant().getName(),
                    pendingApp.getJob().getJobTitle(),
                    pendingApp.getStatus());
        }
        return true;

    }
    
    private static boolean displayScheduledComplete(Employer employer) {

        pendingApplication.clear();

        for (JobApplication app : Database.jobApplicationList) {
            if ((app.getStatus().equalsIgnoreCase("Scheduled")
                    || app.getStatus().equalsIgnoreCase("Completed"))
                    && app.getJob().getEmployer().equals(employer)) {

                Applicant appApplicant = app.getApplicant();

                boolean alreadyAdded = false;
                for (int i = 0; i < pendingApplication.size(); i++) {
                    if (pendingApplication.get(i).getApplicant().equals(appApplicant)) {
                        alreadyAdded = true;
                        break;
                    }
                }

                if (!alreadyAdded) {
                    pendingApplication.add(app);
                }
            }
        }

        // Moved OUTSIDE the for-loop
        if (pendingApplication.isEmpty()) {
            System.out.println(RED + "No applicants with scheduled or completed applications under your posted jobs." + RESET);
            return false;
        }

        System.out.println("\nApplicants with Scheduled or Completed Applications:");
        for (int i = 0; i < pendingApplication.size(); i++) {
            JobApplication pendingApp = pendingApplication.get(i);
            System.out.printf("%d. %s (Job: %s) %s\n", i + 1,
                    pendingApp.getApplicant().getName(),
                    pendingApp.getJob().getJobTitle(),
                    pendingApp.getStatus());
        }
        return true;
    }

    private static void displayVenueTimetable(String venue, Employer employer) {
        System.out.println("\nTimetable for Venue: " + venue);
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-12s %-10s %-20s\n", "Applicant", "Date", "Time", "Mode");
        System.out.println("-------------------------------------------------------------------------------------------");

        boolean hasSchedules = false;

        for (Schedule s : Database.schedules) {
            if (s.getEmployer().equals(employer) && s.getVenue().equalsIgnoreCase(venue)) {
                String applicantName = s.getApplicant().getName();
                String interviewDate = new SimpleDateFormat("yyyy-MM-dd").format(s.getInterviewDate());
                String interviewTime = new SimpleDateFormat("HH:mm").format(s.getInterviewTime());
                String mode = s.getInterviewMode();

                System.out.printf("%-15s %-12s %-10s %-20s\n",
                        applicantName, interviewDate, interviewTime, mode);

                hasSchedules = true;
            }
        }

        if (!hasSchedules) {
            System.out.println("No schedules at this venue yet.");
        }

        System.out.println("-------------------------------------------------------------------------------------------\n");
    }

    public static void displayVenueSlotTimetable(String venue, Employer employer, Date interviewDate, String interviewDuration) {
        int durationMinutes = Integer.parseInt(interviewDuration.replaceAll("\\D", ""));

        final int WORK_START_HOUR = 9;
        final int WORK_END_HOUR = 17;

        Calendar cal = Calendar.getInstance();
        cal.setTime(interviewDate);
        cal.set(Calendar.HOUR_OF_DAY, WORK_START_HOUR);
        cal.set(Calendar.MINUTE, 0);

        System.out.println("\nAvailable Slots for " + venue + " on " + new SimpleDateFormat("yyyy-MM-dd").format(interviewDate));
        System.out.println("------------------------------------------------");

        while (cal.get(Calendar.HOUR_OF_DAY) < WORK_END_HOUR) {
            Date start = cal.getTime();
            Calendar endCal = (Calendar) cal.clone();
            endCal.add(Calendar.MINUTE, durationMinutes);
            Date end = endCal.getTime();

            boolean isBooked = !isSlotAvailable(start, end, venue, interviewDate);
            String status = isBooked ? "Booked" : "Available";

            System.out.println(timeFormat.format(start) + " - " + timeFormat.format(end) + " " + status);

            cal.add(Calendar.MINUTE, 30);
        }

        System.out.println("------------------------------------------------");
    }

    public static Date getNextAvailableTime(String venue, Employer employer, Date interviewDate, String interviewDuration) {
        int durationMinutes = Integer.parseInt(interviewDuration.replaceAll("\\D", ""));

        Calendar cal = Calendar.getInstance();
        cal.setTime(interviewDate);
        cal.set(Calendar.HOUR_OF_DAY, 9);
        cal.set(Calendar.MINUTE, 0);

        while (cal.get(Calendar.HOUR_OF_DAY) < 17) {
            Date start = cal.getTime();
            Calendar endCal = (Calendar) cal.clone();
            endCal.add(Calendar.MINUTE, durationMinutes);
            Date end = endCal.getTime();

            if (isSlotAvailable(start, end, venue, interviewDate)) {
                return start;
            }

            cal.add(Calendar.MINUTE, durationMinutes); // Next slot
        }

        return null;
    }

    private static boolean isScheduleClash(Date interviewDate, Date interviewTime, String venue, String interviewDuration) {
        int durationMinutes = Integer.parseInt(interviewDuration.replaceAll("\\D", ""));

        Calendar newStart = Calendar.getInstance();
        newStart.setTime(interviewTime);
        Calendar newEnd = (Calendar) newStart.clone();
        newEnd.add(Calendar.MINUTE, durationMinutes);

        for (Schedule s : Database.schedules) {
            if (!s.getVenue().equalsIgnoreCase(venue) || !s.getInterviewDate().equals(interviewDate)) {
                continue;
            }

            Calendar existingStart = Calendar.getInstance();
            existingStart.setTime(s.getInterviewTime());
            Calendar existingEnd = (Calendar) existingStart.clone();
            existingEnd.add(Calendar.MINUTE, Integer.parseInt(s.getInterviewDuration()));

            if (newStart.before(existingEnd) && newEnd.after(existingStart)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isSlotAvailable(Date startTime, Date endTime, String venue, Date interviewDate) {
        for (Schedule s : Database.schedules) {
            if (!s.getVenue().equalsIgnoreCase(venue) || !s.getInterviewDate().equals(interviewDate)) {
                continue;
            }

            Calendar bookedStart = Calendar.getInstance();
            bookedStart.setTime(s.getInterviewTime());
            Calendar bookedEnd = (Calendar) bookedStart.clone();
            bookedEnd.add(Calendar.MINUTE, Integer.parseInt(s.getInterviewDuration()));

            if (startTime.before(bookedEnd.getTime()) && endTime.after(bookedStart.getTime())) {
                return false;
            }
        }
        return true;
    }
    
    private static Job getJobFromList(Employer employer, Applicant applicant){
        for(JobApplication app : pendingApplication){
            if(app.getApplicant().equals(applicant) && app.getJob().getEmployer().equals(employer)){
                return app.getJob();
            }
        }
        return null;
    }

}
