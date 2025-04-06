package Control;

import ADT.DoublyLinkedList;
import ADT.ListInterface;
import Boundary.UserUI;
import Boundary.BrowseUI;
import Dao.Database;
import Entity.*;
import Utility.*;

/**
 *
 * @author User
 * s
 * display to the applicant and employer
 * 
 */
public class BrowseManager {
    
    private static String title = "";
    
    public static void browseMenu(){
        UserUI.headLine();
        UserManager.profileHeadLine();
        
        do{
            title = getBrowseSelection();

            if(!title.isEmpty()){
                if("Job".equals(title) || "Applicant".equals(title)){
                    displayAll(title);
                } else {
                    BrowseUI.displaySearchBar(title);
                    searchEngine();
                }
            }
        }while (!title.equals(""));
    }
    
    private static String getBrowseSelection(){
        if(UserManager.isEmployer()){
            while(true){
                int choice = BrowseUI.employerBrowseMenu();
                switch (choice) {
                    case 1 -> { 
                        return "Job"; 
                    }
                    case 2 -> { 
                        return "Applicant"; 
                    }
                    case 3 -> {
                        return "Search";
                    }
                    case 4 -> { 
                        return "";
                    }
                    default -> MessageUI.errorMessage();
                } 
            }
        } else {
            while(true){
                int choice = BrowseUI.applicantBrowseMenu();
                switch (choice) {
                    case 1 -> { 
                        return "Job"; 
                    }
                    case 2 -> {
                        return "Browse";
                    }
                    case 3 -> { 
                        return "";
                    }
                    default -> MessageUI.errorMessage();
                }
            }
        }
    }
    
    // Display the list by using matching engine
    private static <T extends Comparable<T>> void displayAll(String title) {
        
        // Declare a doubly linked list
        ListInterface<T> list = selectList(title); 
        
        // Dynamically identify object types
        T object = getObject(title);

        System.out.println("\n       Available " + title );

        if (list.isEmpty()) {
            MessageUI.emptyDatabase();
            return;
        }
        
        list = sortList(list, object, true);
        
        selectEntity(list, title);
     
    }

    // Search for something in the list
    private static <T extends Comparable<T>> void searchEngine() {
        
        boolean isContinue;
        
        do{
            isContinue = true;
            
            // Declare the important list
            ListInterface<Job> jobList = (ListInterface<Job>) selectList("Job");
            ListInterface<Company> companyList = (ListInterface<Company>) selectList("Company");
            ListInterface<Applicant> applicantList = (ListInterface<Applicant>) selectList("Applicant");

            String input = Input.getStringInput("Search (Enter quit to exit) > ").toLowerCase();
            
            if(input.equals("quit")){
                break;
            }

            if (jobList.isEmpty() && companyList.isEmpty() && applicantList.isEmpty()) {
                MessageUI.emptyDatabase();
                return;
            }

            Searching searching = new Searching();
            ListInterface<Job> jobResults = new DoublyLinkedList<>();
            ListInterface<Company> companyResults = new DoublyLinkedList<>();
            ListInterface<Applicant> applicantResults = new DoublyLinkedList<>();
            
            // Declare the false step in fuzzy matching
            int falseStep = 10;

            // Search in Job List (Exact & Fuzzy)
            for (int i = 0; i < jobList.size(); i++) {
                Job job = jobList.get(i);
                if (searching.search(job.getJobTitle().toLowerCase(), input) || searching.fuzzyMatching(job.getJobTitle().toLowerCase(), input) <= falseStep) {
                    jobResults.add(job);
                    jobResults = sortList(jobResults, job, false);
                    
                } else if (searching.search(job.getJobDescription().toLowerCase(), input) || searching.fuzzyMatching(job.getJobDescription().toLowerCase(), input) <= falseStep){
                    jobResults.add(job);
                    jobResults = sortList(jobResults, job, false);
                }else if (searching.search(job.getJobType().toLowerCase(), input) || searching.fuzzyMatching(job.getJobType().toLowerCase(), input) <= falseStep){
                    jobResults.add(job);
                    jobResults = sortList(jobResults, job, false);
                }
            }

            // Search in Company List (Exact & Fuzzy)
            for (int i = 0; i < companyList.size(); i++) {
                Company company = companyList.get(i);
                if (searching.search(company.getCompanyName().toLowerCase(), input) || searching.fuzzyMatching(company.getCompanyName().toLowerCase(), input) <= falseStep) {
                    companyResults.add(company);
                    companyResults = sortList(companyResults, company, false);
                }
            }
            
            for (int i = 0; i < applicantList.size(); i++) {
                Applicant applicant = applicantList.get(i);
                if(searching.search(applicant.getName().toLowerCase(), input) || searching.fuzzyMatching(applicant.getName().toLowerCase(), input) <= falseStep){
                    applicantResults.add(applicant);
                }
            }
            
            if (UserManager.isEmployer()){
                System.out.println("\nSearch Results for '" + input + "':");
                if (!jobResults.isEmpty()) {
                    selectEntity(jobResults, "Job");
                }
                if (!companyResults.isEmpty()) {
                    selectEntity(companyResults, "Company");
                }
                if (!applicantResults.isEmpty()){
                    selectEntity(applicantResults, "Applicant");
                }
            } else {
                System.out.println("\nSearch Results for '" + input + "':");
                if (!jobResults.isEmpty()) {
                    selectEntity(jobResults, "Job");
                }
                if (!companyResults.isEmpty()) {
                    selectEntity(companyResults, "Company");
                }
            }
            
            if (jobResults.isEmpty() && companyResults.isEmpty()) {
                MessageUI.noMatchFound();
            }
        } while(isContinue);
    }
    
    // Call Sorting Method
    private static <T extends Comparable<T>> ListInterface<T> sortList(ListInterface<T> list, Object object, boolean useHeapSort){

        MatchingEngine match = new MatchingEngine();
        
        if(useHeapSort){
            list = match.heapSort(list, object);
        } else {
            list = match.mergeSort(list, object);
        }
        
        return list;
    }

    // Get the list from the data store
    private static <T extends Comparable<T>> ListInterface<T> selectList(String title) {
        return (ListInterface<T>) (switch (title) {
            case "Job" -> Database.jobList;
            case "Company" -> Database.companies;
            case "Employer" -> Database.employers;
            case "Applicant" -> Database.applicants;
            default -> new DoublyLinkedList<>();
        });
    }
    
    private static <T> T getObject(String title) {
        switch (title) {
            case "Job" -> {
                return (T) new Job();  
            }
            case "Company" -> {
                return (T) new Company();
            }
            case "Employer" -> {
                return (T) new Employer();
            }
            case "Applicant" -> {
                return (T) new Applicant(); 
            }
            default -> {
                MessageUI.invalidTitle();
                return null;
            }
        }
    }
    
    // Make specific entries per page to increase readability
    private static <T> void selectEntity(ListInterface<T> list, String string){
        final int ENTRIES_PER_PAGE = 10;
        int page = 0;
        int totalPages = (int)Math.ceil((double)list.size() / ENTRIES_PER_PAGE);
        T entity;
        
        while(true){
            Tools.clearScreen();
            UserManager.profileHeadLine();
            System.out.println(string + " List ( Page " + (page + 1) + " of " + totalPages + "):\n");
            
            int start = page * ENTRIES_PER_PAGE;
            int end = Math.min(start + ENTRIES_PER_PAGE, list.size());
            
            for(int i = start; i < end; i++){ 
                Object obj = list.get(i);

                switch (obj) {
                    case Job job -> {
                        System.out.println((i + 1) + ". " + job.getJobTitle() + "s - " + job.getEmployer().getCompany().getCompanyName() + "\n   -> " + job.getJobDescription());
                        System.out.println("-----------------------------------------------------------------------------------------");
                    }
                    case Company company -> {
                        System.out.println((i + 1) + ". " + company.getCompanyName() + " - " + company.getIndustryType() + "\n   -> " + company.getWebsite());
                        System.out.println("-----------------------------------------------------------------------------------------");
                    }
                    case Applicant applicant -> {
                        System.out.println((i + 1) + ". " + applicant.getName() + " - " + applicant.getDesiredJobType() + "\n   ->" + applicant.getPortfolioLink());
                        System.out.println("-----------------------------------------------------------------------------------------");
                    }
                    default -> {
                        MessageUI.invalidTitle();
                    }
                }
            }
            
            if (page == totalPages - 1) {
                BrowseUI.lastPage();
            }
            
            String userInput = BrowseUI.chooseEntity();
            switch (userInput.toUpperCase()){
                case "P" -> {
                    if(page > 0) page--;
                }
                case "N" -> {
                    if (page < totalPages - 1) page++;
                }
                case "X" -> {
                    return;
                }
                default -> {
                    try {
                        int choice = Integer.parseInt(userInput);
                        if (choice >= 1 && choice <= list.size()){
                            entity = list.get(choice-1);
                            displayEntity(entity);
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
    
    // Suppose at the applicant side / job side
    private static <T> void displayEntity(T entity) {
        if (entity instanceof Job job) {
            System.out.println("Job Details:");
            System.out.println("Title: " + job.getJobTitle());
            System.out.println("Company: " + job.getEmployer().getCompany().getCompanyName());
            System.out.println("Description: " + job.getJobDescription());
            System.out.println("Location: " + job.getEmployer().getCompany().getLocation());
            System.out.println("Salary: " + job.getSalary());
        } else if (entity instanceof Company company) {
            System.out.println("Company Details:");
            System.out.println("Name: " + company.getCompanyName());
            System.out.println("Industry: " + company.getIndustryType());
            System.out.println("Website: " + company.getWebsite());
            System.out.println("Location: " + company.getAddress());
        } else if (entity instanceof Applicant applicant) {
            System.out.println("Applicant Details:");
            System.out.println("Name: " + applicant.getName());
            System.out.println("Desired Job Type: " + applicant.getDesiredJobType());
            System.out.println("Portfolio: " + applicant.getPortfolioLink());
            System.out.println("Experience: " + applicant.getYearOfExperience() + " years");
        } else {
            MessageUI.invalidTitle();
        }
        Tools.systemPause(); 
    }

}
