package Control;

import ADT.ListInterface;
import Boundary.BrowseUI;
import Boundary.UserUI;
import Control.BrowseManager;
import Dao.Database;
import Entity.*;
import Utility.Input;
import Utility.MessageUI;
import Utility.Tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jesmine
 * 
 */
public class UserManager {
    
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
    
    public static boolean isEmployer(){
        return Database.getEmployer() != null;
    }
    
    public static boolean isApplicant(){
        return Database.getApplicant() != null;
    }
    
    public static void profileHeadLine(){
        String name, user;
        String date, time;
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE dd MMM yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        
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
    
    private static void userMenu(String user){
        String moduleChoose;
        
        if(user.equals("Employer")){
            do{
                moduleChoose = UserUI.employerMenu();
                switch(moduleChoose.toLowerCase()){
                    case "1" -> EmployerManager.jobPosting();
                    case "2" -> JobApplicationManager.arrangeApplication();
                    case "3" -> ScheduleManager.employerScheduleMenu();
                    case "4" -> ScheduleManager.displaySchedule();
                    case "5" -> BrowseManager.browseMenu();
                    case "6" -> System.out.println("Edit Profile");
                    case "7" -> ReportManager.reportMenu();
                    case "8" -> {
                        MessageUI.logOutMessage();
                        Tools.exit();
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
                moduleChoose = UserUI.applicantMenu();
                switch(moduleChoose.toLowerCase()){
                    case "1" -> BrowseManager.browseMenu();
                    case "2" -> JobApplicationManager.displayMyJobApplication(Database.jobApplicationList);
                    case "3" -> ScheduleManager.displaySchedule();
                    case "4" -> ApplicantManager.editProfile();
                    case "5" -> JobApplicationManager.displaySaveList();
                    case "6" -> ReportManager.reportMenu();
                    case "7" -> {
                        MessageUI.logOutMessage();
                        Tools.exit();
                    }
                    case "s" -> {
                        Tools.clearScreen();
                        BrowseManager.searchEngine();
                    }
                    default -> MessageUI.errorMessage();
                    }  
            } while (!moduleChoose.equals("6"));
        }
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
    
    public static void setCurrentDateTime(){
        Date date = UserUI.userCurrentDate();
        Date time = UserUI.userCurrentTime();
        Database.setCurrentDate(date);
        Database.setCurrentTime(time);
    }    
    
}
