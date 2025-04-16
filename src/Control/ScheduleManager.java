package Control;

import ADT.DoublyLinkedList;
import ADT.ListInterface;
import Boundary.ScheduleUI;
import Dao.Database;
import Entity.Applicant;
import Entity.Employer;
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
import java.util.Date;

/**
 *
 * @author 
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
                    editScheduleItem();
                case 4 ->
                    cancelInterview();
                case 5 ->
                    Tools.back();
                default ->
                    MessageUI.errorMessage();
            }
        } while (choice != 4);
    }

    public static void addSchedule() {
        boolean error;
        String name;
        Date interviewDate;
        Date interviewTime;
        String interviewMode;
        String venue;
        Date followUpDate = null;
        Date followUpTime = null;
        String status = "Scheduled";
        Employer employer;
        Applicant applicant = null;

        employer = Database.getEmployer();
        
        displayCalendar(employer);
        
        do{
            error = false;
            name = Validation.checkString("Enter applicant name: ");
            if(!Validation.checkApplicant(name)){
                error = true;
            } else {
                applicant = getApplicant(name);
            }
        } while(error);
        
        interviewDate = Validation.checkDate("Enter interview date: ");
        interviewTime = Validation.checkTime("Enter interview time: ");
        interviewMode = Input.getChoiceInput("Enter your interview mode > ", ChooseSetting.INTERVIEW_MODE_OPTIONS);
        venue = Input.getStringInput("Enter interview venue > ");
        
        Schedule schedule = new Schedule(interviewDate, interviewTime, interviewMode, venue, followUpDate, followUpTime, status, employer, applicant);
        scheduleList.add(schedule);
        Database.schedules.add(schedule);
        ScheduleUI.successfulMessage();
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
        
        do{
            error = false;
            name = Validation.checkString("Enter applicant name: ");
            if(!Validation.checkApplicant(name)){
                error = true;
            } else {
                applicant = getApplicant(name);
            }
        } while(error);
        
        for(Schedule list : Database.schedules){
            if(list.getApplicant().equals(applicant)){
                schedule = list;
            }
        }
        
        status = Input.getChoiceInput("Choose status to update > ", statusOptions);
        if(!status.equals("Canceled")){
            followUpDate = Validation.checkDate("Enter follow up date > ");
            followUpTime = Validation.checkTime("Enter follow up time > ");
        }
        
        // Update 
        schedule.setFollowUpDate(followUpDate);
        schedule.setFollowUpTime(followUpTime);
        schedule.setStatus(status);
        
        ScheduleUI.successfulMessage();
    }

    public static void editScheduleItem(){
        
        boolean error;
        int choice;
        String name;
        Schedule schedule = null;
        Applicant applicant = null;
        Employer employer = Database.getEmployer();
        
        Tools.clearScreen();
        displayCalendar(employer);
        
        do{
            error = false;
            name = Validation.checkString("Enter applicant name: ");
            if(!Validation.checkApplicant(name)){
                error = true;
            } else {
                applicant = getApplicant(name);
            }
        } while(error);
        
        for(Schedule list : Database.schedules){
            if(list.getApplicant().equals(applicant)){
                schedule = list;
            }
        }
        
        do{
            choice = ScheduleUI.editScheduleMenu();
            switch(choice){
                case 1 -> editInterviewDate(schedule);
                case 2 -> editFollowUpDate(schedule);
                case 3 -> editVenue(schedule);
                case 4 -> editInterviewMode(schedule);
                case 5 -> Tools.back();
                default -> MessageUI.errorMessage();
            }
        }while(choice != 4);
        
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
            displayScheduleList(results);
        } else {
            MessageUI.noScheduled();
        }
        Tools.systemPause();
    }
    
    public static void displayScheduleList(ListInterface<Schedule> scheduleList) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    boolean isEmployer = UserManager.isEmployer();

    if (isEmployer) {
        System.out.printf("%-4s | %-15s | %-10s | %-6s | %-15s | %-16s | %-15s | %-10s | %-6s%n",
                "No", "Name", "Date", "Time", "Venue", "Follow Up Date", "Follow Up Time", "Status", "Score");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
    } else {
        System.out.printf("%-4s | %-15s | %-10s | %-6s | %-15s%n",
                "No", "Name", "Date", "Time", "Venue");
        System.out.println("---------------------------------------------------------------");
    }

    int no = 1;
    for (Schedule item : scheduleList) {
            Applicant applicant = item.getApplicant();
            String name = (applicant != null) ? applicant.getName() : "N/A";

            String formattedInterviewDate = (item.getInterviewDate() != null) ? dateFormat.format(item.getInterviewDate()) : "N/A";
            String formattedInterviewTime = (item.getInterviewTime() != null) ? timeFormat.format(item.getInterviewTime()) : "N/A";

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
    }
    
    public static void cancelInterview() {
        boolean error;
        String cancel;
        String name;
        Schedule schedule;
        Applicant applicant = null;
        Employer employer = Database.getEmployer();

        do{
            error = false;
            name = Validation.checkString("Enter applicant name: ");
            if(!Validation.checkApplicant(name)){
                error = true;
            } else {
                applicant = getApplicant(name);
            }
        } while(error);
        
        schedule = getSchedule(employer, applicant);
        if(schedule != null){
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
            if(cancel.equalsIgnoreCase("y")){
                scheduleList.remove(schedule);
                Database.schedules.remove(schedule);
                MessageUI.deleteSuccessful();
            } else {
                MessageUI.nothing();
            }
        } else {
            System.out.println("No interview found!");
        }
        
        Tools.systemPause();
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
                displayCalendarForm();
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
                displayCalendarForm();
            } else {
                MessageUI.emptyDatabase();
            }
        }
        
    }
    
    private static void editInterviewDate(Schedule schedule){
        Date interviewDate = Validation.checkDate("Enter new interview date > ");
        Date interviewTime = Validation.checkDate("Enter new interview time > ");
        schedule.setInterviewDate(interviewDate);
        schedule.setInterviewTime(interviewTime);
        ScheduleUI.successfulMessage();
    }
    
    private static void editFollowUpDate(Schedule schedule){
        if(schedule.getFollowUpTime() == null){
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
    
    private static void editVenue(Schedule schedule){
        String venue = Input.getStringInput("Enter new venue > ");
        schedule.setVenue(venue);
        ScheduleUI.successfulMessage();
    }
    
    private static void editInterviewMode(Schedule schedule){
        String interviewMode = schedule.getInterviewMode();
        String yesNo;
        String venue;
        
        if(interviewMode.equals("Online")){
            yesNo = Input.getYesNoInput("Confirm to switch to offline? (y/n) > ");
            if(yesNo.equalsIgnoreCase("y")){
                venue = Input.getStringInput("Enter venue > ");
                schedule.setInterviewMode("Offline");
                schedule.setVenue(venue);
            } else {
                schedule.setInterviewMode("Online");
                schedule.setVenue("N/A");
            }
        }
    }
 
    // ------------------------------------------ by Jesmine Tey Khai Jing ----------------------------------------------------
    private static void displayCalendarForm(){
        
        int[][] calendar = new int[5][7];
        
        SimpleDateFormat intMonthFormat = new SimpleDateFormat("MM");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM"); 
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        SimpleDateFormat dayOfWeekFormat = new SimpleDateFormat("EEE");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        Date date = Database.getCurrentDate();
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
        
    }
    
    //  Get the scheduled date
    private static boolean scheduleDateList(int year, int month, int date){

        Date scheduledDate;
        Employer employer = Database.getEmployer();
        String currentYearString;
        String currentMonthString;
        String currentDateString;
        int currentYear;
        int currentMonth;
        int currentDate;
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        
        for(Schedule schedule : Database.schedules){
            Employer currentEmployer = schedule.getEmployer();
            if(currentEmployer.equals(employer)){
                scheduledDate = schedule.getInterviewDate();
                currentYearString = yearFormat.format(scheduledDate);
                currentMonthString = monthFormat.format(scheduledDate);
                currentDateString = dateFormat.format(scheduledDate);
                currentYear = Integer.parseInt(currentYearString);
                currentMonth = Integer.parseInt(currentMonthString);
                currentDate = Integer.parseInt(currentDateString);

                if((year == currentYear) && (month == currentMonth) && (date == currentDate)){
                    return true;
                }
            }
        }
        return false;
    }
    
    // Get current date
    private static boolean checkToday(int year, int month, int date){
        Date today = Database.getCurrentDate();
        
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        SimpleDateFormat intMonthFormat = new SimpleDateFormat("MM");
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        
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
    
    // Compare a list of string
    private static boolean compareStringList(String[] stringList, String month){
        for (String list : stringList) {
            if(month.equals(list)){
                return true;
            }
        }
        return false;
    }

}
