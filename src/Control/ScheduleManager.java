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
import java.util.Date;

/**
 *
 * @author User
 */
public class ScheduleManager {
    
    private static final ListInterface<Schedule> scheduleList = new DoublyLinkedList<>();
    
    public static void employerScheduleMenu(){
        int choice;
        do{
            choice = ScheduleUI.employerScheduleMenu();
            switch(choice){
                case 1 -> addSchedule();
                case 2 -> updateSchedule();
                case 3 -> cancelInterview();
                case 4 -> Tools.back();
                default -> MessageUI.errorMessage();
            }
        }while(choice != 4);
    }
    
    public static void addSchedule(){
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
        String status = null;
        Employer employer;
        Applicant applicant = null;
        
        employer = Database.getEmployer();
        
        do{
            error = false;
            name = ScheduleUI.getApplicantName();
            if(!Validation.checkString(name) || !Validation.checkApplicant(name)){
                if(!Validation.checkString(name)){
                    System.out.println("Check string");
                }
                if(!Validation.checkApplicant(name)){
                    System.out.println("no applicant");
                }
                error = true;
            }
            if(!error){
                applicant = getApplicant(name);
            }
        }while(error);
        
        do{
            error = false;
            dateString = ScheduleUI.getDate();
            if(Validation.checkDate(dateString) == null){
                error = true;
            } else {
                interviewDate = Validation.checkDate(dateString);
            }
        }while(error);
        
        do{
            error = false;
            timeString = ScheduleUI.getTime();
            if(Validation.checkTime(timeString) == null ){
                error = true;
            } else {
                interviewTime = Validation.checkTime(timeString);
            }
        }while(error);
        
        do{
            error = false;
            int choice = ScheduleUI.getInterviewMode();
            switch(choice){
                case 1 -> {
                    interviewMode = "Online";
                    venue = "N/A";
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
        }while(error);
        
        followUpDate = null;
        followUpTime = null;

        Schedule schedule = new Schedule(interviewDate, interviewTime, interviewMode, venue, followUpDate, followUpTime, status, employer, applicant);

        //add the schedule into local list
        scheduleList.add(schedule);
        //add the schedule into global list
        Database.schedules.add(schedule);
    }
    
    public static void updateSchedule(){
        boolean error;
        String name;
        String dateString;
        Date followUpDate = null;
        String timeString;
        Date followUpTime = null;
        String status = null;
        Applicant applicant = null;
        Schedule schedule = null;
        
        do{
            error = false;
            name = ScheduleUI.getApplicantName();
            if(!Validation.checkString(name) || !Validation.checkApplicant(name)){
                error = true;
            }
            if(!error){
                applicant = getApplicant(name);
                schedule = getSchedule(name);
            }
        }while(error);
        
        do{
            error = false;
            dateString = ScheduleUI.getDate();
            if(Validation.checkDate(dateString) == null){
                error = true;
            } else {
                followUpDate = Validation.checkDate(dateString);
            }
        }while(error);
        
        do{
            error = false;
            timeString = ScheduleUI.getTime();
            if(Validation.checkTime(timeString) == null ){
                error = true;
            } else {
                followUpTime = Validation.checkTime(timeString);
            }
        }while(error);
        
        do{
            error = false;
            int choice = ScheduleUI.updateStatus();
            switch(choice){
                case 1 -> status = "Scheduled";
                case 2 -> status = "Completed";
                case 3 -> status = "Canceled";
                default -> {
                    error = true;
                    MessageUI.errorMessage();
                }
            }
        }while(error);
        
        schedule.setFollowUpDate(followUpDate);
        schedule.setFollowUpTime(followUpTime);
        schedule.setStatus(status);
        
    }
    
    public static void displaySchedule(){
        ListInterface<Schedule> schedule = Database.schedules;
        ListInterface<Schedule> results = new DoublyLinkedList<>();
        Employer currentEmployer = null;
        Applicant currentApplicant = null;
        
        if(UserManager.isEmployer()){
            currentEmployer = Database.getEmployer();
        } else if(UserManager.isApplicant()){
            currentApplicant = Database.getApplicant();
        }
        
        if(currentEmployer != null){
            for(Schedule sc : schedule){
                Employer employer = sc.getEmployer();
                if(employer.equals(currentEmployer)){
                    results.add(sc);
                }
            }
        } else if (currentApplicant != null){
            for(Schedule sc : schedule){
                Applicant applicant = sc.getApplicant();
                if(applicant.equals(currentApplicant)){
                    results.add(sc);
                }
            }
        }
        
        if(!results.isEmpty()){
            ScheduleUI.displaySchedule(results);
        } else {
            MessageUI.noScheduled();
            Tools.systemPause();
        }
    }
    
    public static void cancelInterview(){
        boolean error;
        String name;
        Applicant applicant = null;
        Schedule schedule = null;
        String dateString;
        Date interviewDate = null;
        Schedule removeScheduled = null;
        
        do{
            error = false;
            name = ScheduleUI.getApplicantName();
            if(!Validation.checkString(name) || !Validation.checkApplicant(name)){
                error = true;
            }
            if(!error){
                applicant = getApplicant(name);
                schedule = getSchedule(name);
            }
        }while(error);
        
        do{
            error = false;
            dateString = ScheduleUI.getDate();
            if(Validation.checkDate(dateString) == null){
                error = true;
            } else {
                interviewDate = Validation.checkDate(dateString);
            }
        }while(error);
        
        for(Schedule list : scheduleList){
            if(list.getApplicant().equals(applicant) && list.getInterviewDate().equals(interviewDate)){
                removeScheduled = list;
            }
        }
        
        if(removeScheduled != null){
            scheduleList.remove(removeScheduled);
            Database.schedules.remove(removeScheduled);
        }
        
    }
    
    // Get the specific applicant
    private static Applicant getApplicant(String name){
        Applicant applicant = null;
        ListInterface<Applicant> applicantList = Database.applicants;
        for(int i = 0; i < applicantList.size(); i++){
            if(applicantList.get(i).getName().equals(name)){
                applicant = applicantList.get(i);
            }
        }
        return applicant;
    }
    
    private static Schedule getSchedule(String name){
        Schedule schedule = null;
        ListInterface<Schedule> list = Database.schedules;
        for(int i = 0; i < list.size(); i++){
            Applicant applicant = list.get(i).getApplicant();
            if(applicant.getName().equals(name)){
                schedule = list.get(i);
            }
        }
        return schedule;
    }
    
}
