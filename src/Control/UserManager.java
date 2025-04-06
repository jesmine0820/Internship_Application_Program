package Control;

import ADT.ListInterface;
import Boundary.UserUI;
import Dao.Database;
import Control.BrowseManager;
import Entity.*;
import Utility.MessageUI;
import Utility.Tools;

/**
 *
 * @author User
 * 
 * Register belum siap
 * 
 */
public class UserManager {
    
    public void login(){
        boolean error;
        int loginChoice;
        
        do{
            error = false;
            loginChoice = UserUI.loginUI();    
        
            switch(loginChoice){
                case 1 -> Database.setEmployer(authenticateEmployer());
                case 2 -> Database.setApplicant(authenticateApplicant());
                //case 3 -> registerHandler();
                case 4 -> Tools.exit();
                default -> {
                    MessageUI.errorMessage();
                    error = true;
                }
            }
            
            if(Database.getEmployer() == null && Database.getApplicant() == null){
                MessageUI.emptyDatabase();
            }
            
            if(Database.getEmployer() != null){
                userMenu("Employer");
            } else {
                userMenu("Applicant");
            }
            
        }while (error || loginChoice != 4);
        
    }
    
    private Employer authenticateEmployer(){
        Employer employer;
        
        if(Database.employers.isEmpty()){
            MessageUI.emptyEmployerMessage();
            employer = null;
        } else {
            employer = selectEntity(Database.employers, "Employer");
        }
        return employer;
    }
    
    private Applicant authenticateApplicant(){
        Applicant applicant;
        
        if(Database.applicants.isEmpty()){
            MessageUI.emptyApplicantMessage();
            applicant = null;
        } else {
            applicant = selectEntity(Database.applicants, "Applicant");
        }
        return applicant;
    }
    
    private <T extends Comparable<T>> T selectEntity(ListInterface<T> list, String string){
        final int ENTRIES_PER_PAGE = 10;
        int page = 0;
        int totalPages = (int)Math.ceil((double)list.size() / ENTRIES_PER_PAGE);
        
        while(true){
            Tools.clearScreen();
            System.out.println(string + " List ( Page " + (page + 1) + " of " + totalPages + "):\n");
            System.out.println("-------------------------------------------");
            
            int start = page * ENTRIES_PER_PAGE;
            int end = Math.min(start + ENTRIES_PER_PAGE, list.size());
            
            for(int i = start; i < end; i++){
                T entity = list.get(i);
                
                if(entity instanceof Employer employer){
                    System.out.println((i + 1) + ". " + employer.getName());
                    System.out.println("-------------------------------------------");
                }
                
                if (entity instanceof Applicant applicant) {
                    System.out.println((i + 1) + ". " + applicant.getName());
                    System.out.println("-------------------------------------------");
                }
            }
            
            String userInput = UserUI.chooseEntity();
            
            switch (userInput.toUpperCase()){
                case "P" -> {
                    if(page > 0) page--;
                }
                case "N" -> {
                    if (page < totalPages - 1) page++;
                }
                case "X" -> {
                    return null;
                }
                default -> {
                    try {
                        int choice = Integer.parseInt(userInput);
                        if (choice >= 1 && choice <= list.size()){
                            return list.get(choice-1);
                        } else {
                            MessageUI.errorMessage();
                        }
                    } catch (NumberFormatException e){
                        MessageUI.errorMessage();
                    }
                }
            }
            
        }

    }
    
    private static void userMenu(String user){
        int moduleChoose;
        
        if(user.equals("Employer")){
            do{
                moduleChoose = UserUI.employerMenu();
                switch(moduleChoose){
                    case 1 -> System.out.println("Job Posting");
                    case 2 -> System.out.println("Job Application");
                    case 3 -> System.out.println("Interview");
                    case 4 -> System.out.println("View Schedule");
                    case 5 -> BrowseManager.browseMenu();
                    case 6 -> System.out.println("Edit Profile");
                    case 7 -> ReportManager.reportMenu();
                    case 8 -> {
                        MessageUI.logOutMessage();
                        Tools.exit();
                    }
                    default -> MessageUI.errorMessage();
                }  
            } while (moduleChoose != 8);
        } else {
            do{
                moduleChoose = UserUI.applicantMenu();
                switch(moduleChoose){
                    case 1 -> BrowseManager.browseMenu();
                    case 2 -> System.out.println("View my application");
                    case 3 -> System.out.println("Edit profile");
                    case 4 -> ReportManager.reportMenu();
                    case 5 -> {
                        MessageUI.logOutMessage();
                        Tools.exit();
                    }
                    default -> MessageUI.errorMessage();
                    }  
            } while (moduleChoose != 5);
        }
    }
    
    public static void profileHeadLine(){
        String name, user;
        
        if(isEmployer()){
            name = Database.getEmployer().getName();
            user = "Employer";
        } else {
            name = Database.getApplicant().getName();
            user = "Applicant";
        }
        UserUI.profile(name, user);
    }
    
    public static boolean isEmployer(){
        return Database.getEmployer() != null;
    }
    
    public static boolean isApplicant(){
        return Database.getApplicant() != null;
    }
    
}
