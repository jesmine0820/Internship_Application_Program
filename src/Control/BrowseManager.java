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
                    BrowseUI.displayBrowserHeader(title);
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
                        return "Any";
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
        
        list = sortList(list, object);
        
        selectEntity(list, title);
     
    }

    // Search for something in the list
    public static <T extends Comparable<T>> void searchEngine() {
        
        boolean isContinue;
        
        do{
            isContinue = true;
            
            BrowseUI.displaySearchHeader();
            
            // Linked list to perform searching
            ListInterface<String> searching = new DoublyLinkedList<>();
            
            // Declare the important list
            ListInterface<Job> jobList = (ListInterface<Job>) selectList("Job");
            ListInterface<Company> companyList = (ListInterface<Company>) selectList("Company");
            ListInterface<Applicant> applicantList = (ListInterface<Applicant>) selectList("Applicant");

            
            String input = Input.getStringInput().toLowerCase();
            
            if(input.equalsIgnoreCase("x")){
                break;
            }

            if (jobList.isEmpty() && companyList.isEmpty() && applicantList.isEmpty()) {
                MessageUI.emptyDatabase();
                return;
            }

            // Declare local list to store the results
            ListInterface<Job> jobResults = new DoublyLinkedList<>();
            ListInterface<Company> companyResults = new DoublyLinkedList<>();
            ListInterface<Applicant> applicantResults = new DoublyLinkedList<>();
            ListInterface<Job> mergeResults;
            
            // Declare the false step in fuzzy matching
            int falseStep = 10;
            String lowerInput = input.toLowerCase();
 
            // Search in Job List (Exact & Fuzzy)
            for (int i = 0; i < jobList.size(); i++) {
                Job job = jobList.get(i);
                String jobTitle = job.getJobTitle().toLowerCase();
                String description = job.getJobDescription().toLowerCase();
                String type = job.getJobType().toLowerCase();
                
                if(searching.search(jobTitle, lowerInput) || searching.fuzzyMatching(jobTitle, lowerInput) <= falseStep){
                    jobResults.add(job);
                } else if (searching.search(description, lowerInput) || searching.fuzzyMatching(description, lowerInput) <= falseStep){
                    jobResults.add(job);
                } else if (searching.search(type, lowerInput )|| searching.fuzzyMatching(description, lowerInput) <= falseStep){
                    jobResults.add(job);
                }
                jobResults = sortList(jobResults, job);
            }

            // Search in Company List (Exact & Fuzzy)
            for (int i = 0; i < companyList.size(); i++) {
                Company company = companyList.get(i);
                String companyName = company.getCompanyName().toLowerCase();
                if (searching.search(companyName, lowerInput) || searching.fuzzyMatching(companyName, input) <= falseStep) {
                    companyResults.add(company);
                    companyResults = sortList(companyResults, company);
                }
            }
            
            for (int i = 0; i < applicantList.size(); i++) {
                Applicant applicant = applicantList.get(i);
                String applicantName = applicant.getName().toLowerCase();
                if(searching.search(applicantName, lowerInput) || searching.fuzzyMatching(applicantName, input) <= falseStep){
                    applicantResults.add(applicant);
                    applicantResults = sortList(applicantResults, applicant);
                }
            }
            
            // Need to match all the result
            if(UserManager.isEmployer()){
                System.out.println("\n Search Results for '" + input + "'");
                if(!jobResults.isEmpty() && !companyResults.isEmpty()){
                    mergeResults = (ListInterface<Job>)mergeList((ListInterface<T>)jobResults, (ListInterface<T>)companyResults);
                    selectEntity(mergeResults, "Job");
                } else {
                    if(!jobResults.isEmpty()){
                        selectEntity(jobResults, "Job");
                    } else if(!companyResults.isEmpty()){
                        selectEntity(companyResults, "Company");
                    } else if(!applicantResults.isEmpty()){
                        selectEntity(applicantResults, "Applicant");
                    }
                }
            } else {
                System.out.println("\n Search Results for '" + input + "'");
                if(!jobResults.isEmpty() && !companyResults.isEmpty()){
                    mergeResults = (ListInterface<Job>)mergeList((ListInterface<T>)jobResults, (ListInterface<T>)companyResults);
                    selectEntity(mergeResults, "Job");
                } else {
                    if(!jobResults.isEmpty()){
                        selectEntity(jobResults, "Job");
                    } else if(!companyResults.isEmpty()){
                        selectEntity(companyResults, "Company");
                    }
                }
            }
            
            if(jobResults.isEmpty() && companyResults.isEmpty()){
                MessageUI.noMatchFound();
            }
            
        } while(isContinue);
    }
    
    // Call Sorting Method
    private static <T extends Comparable<T>> ListInterface<T> sortList(ListInterface<T> list, Object object){

        MatchingEngine match = new MatchingEngine();
        
        list = match.heapSort(list, object);
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
                        Employer employer = job.getEmployer();
                        Company company = employer.getCompany();
                        String companyName = company.getCompanyName();
                        String jobTitle = job.getJobTitle();
                        String jobType = job.getJobType();
                        String jobDescription = job.getJobDescription();
                        Double salary = job.getSalary();
                        
                        System.out.println("---------------------------------------------------------------");
                        System.out.printf ("│ %-3s %-70s │\n", (i + 1) + ".", companyName);
                        System.out.printf ("│     Position:     %-60s │\n", jobTitle);
                        System.out.printf ("│     Type:         %-60s │\n", jobType);
                        System.out.printf ("│     Salary:       RM%-57.2f │\n", salary);
                        System.out.printf ("│     Description:  %-60s │\n", jobDescription);
                        System.out.println("---------------------------------------------------------------");

                    }
                    case Applicant applicant -> {
                        String name = applicant.getName();
                        String preferredWorkMode = applicant.getPreferredWorkMode();
                        String desiredJobType = applicant.getDesiredJobType();
                        String portfolioLink = applicant.getPortfolioLink();
                        
                        System.out.println("-----------------------------------------------------------------------------------------");
                        System.out.println("| " + String.format("%-75s", (i + 1) + ". " + name) + " |");
                        System.out.println("| " + String.format("%-75s", "Preferred Work Mode: " + preferredWorkMode) + " |");
                        System.out.println("| " + String.format("%-75s", "Desired Job Type: " + desiredJobType) + " |");
                        System.out.println("| " + String.format("%-75s", "Portfolio Link: " + portfolioLink) + " |");
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
    
     private static <T extends Comparable<T>> ListInterface<T> mergeList(ListInterface<T> list1, ListInterface<T> list2){
        if(list1.isEmpty() && list2.isEmpty()){
            return null;
        }
        
        // Declare new list to store the merge result
        ListInterface<T> mergeList = new DoublyLinkedList<>();
        
        // Check list 1 is instance of what
        if(!list1.isEmpty()){
            T elementList1 = list1.get(0);
            if(elementList1 instanceof Job){
                mergeList.add(list1);
            } else if(elementList1 instanceof Company){
                mergeList.add(extractJob(list1));
            }
        }
        
        // Check list 2 is instance of what
        if(!list2.isEmpty()){
            T elementList2 = list2.get(0);
            if(elementList2 instanceof Job){
                mergeList.add(list2);
            } else if(elementList2 instanceof Company){
                mergeList.add(extractJob(list2));
            }
        }
        
        for(T result: mergeList){
            mergeList = sortList(mergeList, result);
        }
        
        return mergeList;
    }
    
    // Get the job from the company
    private static <T extends Comparable<T>> ListInterface<T> extractJob(ListInterface<T> list){
        // Check empty list
        if(list.isEmpty()){
            return null;
        }

        // Get the Database
        ListInterface<Job> allJobs = Database.jobList;
        
        // Declare a new list to store the result that extract from the companies
        ListInterface<T> matchedJob = new DoublyLinkedList<>();
        
        T firstElement = list.get(0);
        if(firstElement instanceof Company){
            for(int i = 0; i < list.size(); i++){
                Company company = (Company)list.get(i);
                String companyName = company.getCompanyName();
                
                for(int j = 0; j < allJobs.size(); j++){
                    Job job = allJobs.get(j);
                    Employer employer = job.getEmployer();
                    Company hisCompany = employer.getCompany();
                    if(hisCompany.getCompanyName().equals(companyName)){
                        matchedJob.add((T)job);
                    }
                }
            }
        }
        return matchedJob;
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
