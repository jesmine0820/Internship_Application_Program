package Control;

import ADT.DoublyLinkedList;
import ADT.ListInterface;
import Boundary.UserUI;
import Dao.Database;
import Entity.*;
import Utility.Input;
import Utility.MessageUI;
import Utility.Tools;
import static Utility.Tools.RED;
import static Utility.Tools.RESET;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jesmine
 * 
 */
public class UserManager {
    
    private static final ListInterface<Schedule> scheduledList = new DoublyLinkedList<>();
    private static final ListInterface<Schedule> requestedList = new DoublyLinkedList<>();

    private static final SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
    
    public void login(){

        int loginChoice;
        
        do{
            loginChoice = UserUI.loginUI();    
        
            switch(loginChoice){
                case 1 -> Database.setEmployer(authenticateEmployer());
                case 2 -> Database.setApplicant(authenticateApplicant());
                case 3 -> registerHandler();
                case 4 -> Tools.exit();
                default -> MessageUI.errorMessage();
            }
            
            if(loginChoice != 4 && Database.getEmployer() == null && Database.getApplicant() == null){
                MessageUI.emptyDatabase();
            }
            
            if(Database.getEmployer() != null){
                userMenu("Employer");
            } else if(Database.getApplicant() != null){
                userMenu("Applicant");
            }
            
        }while (loginChoice != 4);
        
    }
    
    public static void profileHeadLine(){
        String name, user;
        String date, time;
        
        date = dateFormat.format(Database.getCurrentDate());
        time = timeFormat.format(Database.getCurrentTime());
        
        if(isEmployer()){
            name = Database.getEmployer().getName();
            user = "Employer";
        } else {
            name = Database.getApplicant().getName();
            user = "Applicant";
        }
        UserUI.profile(name, user, date, time);
    }
    
    public static void setCurrentDateTime(){
        boolean error;
        Date date;
        Date time;
        do{
            error = false;
            date = UserUI.userCurrentDate();
            if(Integer.parseInt(yearFormat.format(date)) < 2024){
                error = true;
                System.out.println(RED + "Our system is lauched since 2024. Please enter a year after 2024." +  RESET);
            } else if (Integer.parseInt(yearFormat.format(date)) >= 3000){
                error = true;
                System.out.println(RED + "Invalid year. Please enter again!" + RESET);
            }
        }while(error);
        time = UserUI.userCurrentTime();
        Database.setCurrentDate(date);
        Database.setCurrentTime(time);
    }  
    
    public static boolean isEmployer(){
        return Database.getEmployer() != null;
    }
    
    public static boolean isApplicant(){
        return Database.getApplicant() != null;
    }
    
    private Employer authenticateEmployer(){
        Employer employer;
        
        if(Database.employers.isEmpty()){
            MessageUI.emptyEmployerMessage();
            employer = null;
        } else {
            employer = Input.selectUser(Database.employers, "Employer");
        }
        return employer;
    }
    
    private Applicant authenticateApplicant(){
        Applicant applicant;
        
        if(Database.applicants.isEmpty()){
            MessageUI.emptyApplicantMessage();
            applicant = null;
        } else {
            applicant = Input.selectUser(Database.applicants, "Applicant");
        }
        return applicant;
    }
    
    private static void registerHandler(){
        int choice;
        do{
            choice = UserUI.registerMenu();
            switch(choice){
                case 1 -> EmployerManager.registerCompany();
                case 2 -> EmployerManager.registerEmployer();
                case 3 -> ApplicantManager.registerApplicant();
                case 4 -> Tools.back();
                default -> MessageUI.errorMessage();
            }
        }while(choice != 4);
    }  
    
    private static void userMenu(String user){
        String moduleChoose;
        
        if(user.equals("Employer")){
            do{
                requestedList.clear();
                checkNotification();
                moduleChoose = UserUI.employerMenu();
                switch(moduleChoose.toLowerCase()){
                    case "1" -> EmployerManager.jobPosting();
                    case "2" -> JobApplicationManager.arrangeApplication();
                    case "3" -> ScheduleManager.employerScheduleMenu();
                    case "4" -> ScheduleManager.displaySchedule();
                    case "5" -> BrowseManager.browseMenu();
                    case "6" -> EmployerManager.editEmployerProfile();
                    case "7" -> ReportManager.reportMenu();
                    case "8" -> {
                        MessageUI.logOutMessage();
                        Tools.exit();
                    }
                    case "n" -> {
                        if(!scheduledList.isEmpty()){
                            goNotification();
                        } else {
                            moduleChoose = "7";
                        }
                    }
                    case "s" -> {
                        Tools.clearScreen();
                        BrowseManager.searchEngine();
                    }
                    default -> MessageUI.errorMessage();
                }  
            } while (!moduleChoose.equals("8"));
        } else {
            do{
                scheduledList.clear();
                checkNotification();
                moduleChoose = UserUI.applicantMenu(scheduledList.size());
                switch(moduleChoose.toLowerCase()){
                    case "1" -> BrowseManager.browseMenu();
                    case "2" -> JobApplicationManager.CancelApplication();
                    case "3" -> ScheduleManager.displaySchedule();
                    case "4" -> JobApplicationManager.displaySaveList();
                    case "5" -> ApplicantManager.editProfile();
                    case "6" -> ReportManager.reportMenu();
                    case "7" -> ApplicantManager.deleteAccount();
                    case "8" -> Tools.back();
                    case "n" -> {
                        if(!scheduledList.isEmpty()){
                            goNotification();
                        } else {
                            moduleChoose = "7";
                        }
                    }
                    case "s" -> {
                        Tools.clearScreen();
                        BrowseManager.searchEngine();
                    }
                    default -> MessageUI.errorMessage();
                    }  
            } while (!moduleChoose.equals("8"));
        }
    }
    
    private static void checkNotification() {
        if(isEmployer()){
            Employer employer = Database.getEmployer();
            
            for(Schedule schedule : Database.schedules){
                for(JobApplication app : Database.jobApplicationList){
                    for(Job job : employer.getJob()){
                        if(job.equals(app.getJob())
                            && schedule.getEmployer().equals(employer)
                            && app.getStatus().equalsIgnoreCase("Requested")){
                            if(!requestedList.contains(schedule)){
                                requestedList.add(schedule);
                            }
                        }
                    }
                }
            }
        } else {
            Applicant applicant = Database.getApplicant();

            for (Schedule schedule : Database.schedules) {
                for (JobApplication app : Database.jobApplicationList) {
                    if (app.getApplicant().equals(applicant)
                            && app.getJob().equals(schedule.getJob())
                            && app.getStatus().equalsIgnoreCase("Pending")
                            && schedule.getStatus().equalsIgnoreCase("Scheduled")) {
                        if (!scheduledList.contains(schedule)) {
                            scheduledList.add(schedule);
                        }
                    }
                }
            }
        }
    }

    private static void goNotification() {
        if (isEmployer()) {
            if (requestedList.isEmpty()) {
                System.out.println("No scheduled interview yet.");
                Tools.systemPause();
            } else {
                System.out.println("---------------------------------------------------------------------------------------------------------");
                System.out.println(" No | Applicant Name | JobID | Interview Date | Time | Venue | Remark");
                System.out.println("---------------------------------------------------------------------------------------------------------");

                int index = 1;
                for (Schedule schedule : requestedList) {
                    String applicantName = schedule.getApplicant().getName();
                    String jobID = schedule.getJob().getJobID();
                    Date date = schedule.getInterviewDate();
                    Date time = schedule.getInterviewTime();
                    String venue = schedule.getVenue();
                    String remark = schedule.getRemark();

                    System.out.printf(" %2d | %-15s | %-5s | %-15s | %-5s | %-10s | %-40s\n",
                            index, applicantName, jobID, date, time, venue, remark);
                    index++;
                }

                int choice = Input.getIntegerInput("Enter the number of the schedule to edit (or 0 to cancel):");

                if (choice > 0 && choice <= requestedList.size()) {
                    Schedule selected = requestedList.get(choice - 1);
                    ScheduleManager.editScheduleItem();

                    requestedList.remove(selected); 
                    scheduledList.add(selected);    

                    System.out.println("Interview schedule updated.");
                } else if (choice == 0) {
                    System.out.println("Action cancelled.");
                } else {
                    System.out.println("Invalid selection.");
                }
            }
        } else {
            if (scheduledList.isEmpty()) {
            System.out.println("No scheduled interview yet.");
            Tools.systemPause();
            } else {
                System.out.println("---------------------------------------------------------------");
                System.out.println(" No | JobID | Job Title | Interview Date | Time | Venue ");
                System.out.println("---------------------------------------------------------------");

                int index = 1;
                for (Schedule schedule : scheduledList) {
                    Job job = schedule.getJob();

                    String jobId = job.getJobID();
                    String jobTitle = job.getJobTitle();
                    Date date = schedule.getInterviewDate();
                    Date time = schedule.getInterviewTime();
                    String venue = schedule.getVenue();

                    System.out.println(" " + index + "  |  " + jobId + "  | " + jobTitle + " | " + date + " | " + time + " | " + venue);
                    index++;
                }

                int choice = Input.getIntegerInput("Enter the number of the interview to respond (or 0 to cancel):");

                if (choice > 0 && choice <= scheduledList.size()) {
                    Schedule selected = scheduledList.get(choice - 1);
                    System.out.println("You selected interview for job: " + selected.getJob().getJobTitle());
                    System.out.println("1. Confirm Interview");
                    System.out.println("2. Request Change (Date/Time)");
                    System.out.println("3. Reject Interview");
                    int action = Input.getIntegerInput("Enter you choice > ");

                    switch (action) {
                        case 1 -> {
                            System.out.println("Interview confirmed.");
                            setConfirm(selected.getApplicant(), selected.getJob(), selected);
                        }
                        case 2 -> {
                            System.out.println("-------------------------------------------------------");
                            System.out.println("Remark will be sent to employer in charge to process...");
                            System.out.println("-------------------------------------------------------");
                            String remark = Input.getStringInput("Enter remark > ");
                            setRemark(selected, remark);
                        }
                        case 3 -> {
                            System.out.println("Interview rejected.");
                            setDeactive(selected.getApplicant(), selected.getJob(), selected);
                        }
                        default -> System.out.println("Invalid option.");
                    }
                } else if (choice == 0) {
                    System.out.println("Action cancelled.");
                } else {
                    System.out.println("Invalid selection.");
                }
            }
        }
    }

    private static <T> void setRemark(T object, String remark){
        for(Schedule schedule : Database.schedules){
            if(schedule.equals(object)){
                schedule.setRemark(remark);
                schedule.setStatus("Requested");
                scheduledList.remove((Schedule) object);
                break;
            }
        }
    }
    
    private static <T> void setConfirm(T obj1, T obj2, T obj3){
        for (JobApplication jobApplication : Database.jobApplicationList) {
            if (jobApplication.getApplicant().equals(obj1) && jobApplication.getJob().equals(obj2)) {
                jobApplication.setStatus("Confirmed");
            }
        }

        for (Schedule schedule : Database.schedules) {
            if (schedule.equals(obj3)) {
                schedule.setStatus("Confirmed");
                scheduledList.remove((Schedule) obj3);
            }
        }
    }
    
    private static <T> void setDeactive(T obj1, T obj2, T obj3){
        for (JobApplication jobApplication : Database.jobApplicationList) {
            if (jobApplication.getApplicant().equals(obj1) && jobApplication.getJob().equals(obj2)) {
                jobApplication.setStatus("Deactive");
            }
        }

        for (Schedule schedule : Database.schedules) {
            if (schedule.equals(obj3)) {
                schedule.setStatus("Canceled");
                scheduledList.remove((Schedule) obj3);
            }
        }
    }
}
