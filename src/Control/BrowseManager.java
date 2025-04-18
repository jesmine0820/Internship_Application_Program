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
 * @author Jesmine Tey Khai Jing
 * 
 */
public class BrowseManager {
    
    // Declare local variable
    private static final ListInterface<String> searchHistory = new DoublyLinkedList<>();
    private static String title = "";
    private static Boolean cancel;
    
    // This cancel is used to control the exit when choosing entity
    public static void setCancel(Boolean yesNo){
        cancel = yesNo;
    }
    
    // Choose browse job or applicant
    public static void browseMenu(){
        UserUI.headLine();
        UserManager.profileHeadLine();
        
        do{
            title = getBrowseSelection();

            if(!title.isEmpty()){
                switch (title) {
                    case "Job", "Applicant" -> displayAll(title);
                    case "3" -> ApplicantManager.filterApplicant();
                    case "4" -> {
                        String searchTerm = Input.getStringInput("Enter keyword to search resume details: ");
                        ApplicantManager.searchResume(searchTerm);
                    }
                    default -> {
                    }
                }
            }
        }while (!cancel);
    }
    
    // Search for something in the list
    public static <T extends Comparable<T>> void searchEngine() {
        
        boolean isContinue;
        Job goJob = null;
        Applicant goApplicant = null;
        Company goCompany = null;
        
        do{
            isContinue = true;
            
            Tools.clearScreen();
            BrowseUI.displaySearchHeader();
            
            // Linked list to perform searching
            ListInterface<String> searching = new DoublyLinkedList<>();
            
            // Declare the important list
            ListInterface<Job> jobList = (ListInterface<Job>) selectList("Job");
            ListInterface<Company> companyList = (ListInterface<Company>) selectList("Company");
            ListInterface<Applicant> applicantList = (ListInterface<Applicant>) selectList("Applicant");

            // Get input from user
            String input = Input.getStringInput("Search > ").toLowerCase();
            
            // Store the input into search history list for future analysis
            if(!input.equals("x")){
                searchHistory.add(input);
                Database.searchHistory.add(input);
            }
            
            // Break the loop
            if(input.equals("x")){
                break;
            }

            // Check if the database is empty
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
            int falseStep = 5;
            String lowerInput = input.toLowerCase();
 
            // Search in Job List (Exact & Fuzzy & Contains Keyword)
            for (int i = 0; i < jobList.size(); i++) {
                Job job = jobList.get(i);
                String jobTitle = job.getJobTitle().toLowerCase();
                String description = job.getJobDescription().toLowerCase();
                String type = job.getJobType().toLowerCase();
                
                if(searching.search(jobTitle, lowerInput) || searching.fuzzyMatching(jobTitle, lowerInput) <= falseStep || jobList.get(i).getJobTitle().contains(input)){
                    jobResults.add(job);
                } else if (searching.search(description, lowerInput) || searching.fuzzyMatching(description, lowerInput) <= falseStep|| jobList.get(i).getJobDescription().contains(input)){
                    jobResults.add(job);
                } else if (searching.search(type, lowerInput )|| searching.fuzzyMatching(description, lowerInput) <= falseStep|| jobList.get(i).getJobType().contains(input)){
                    jobResults.add(job);
                }
                jobResults = sortList(jobResults, job);
            }

            // Search in Company List (Exact & Fuzzy & Contains Keyword)
            for (int i = 0; i < companyList.size(); i++) {
                Company company = companyList.get(i);
                String companyName = company.getCompanyName().toLowerCase();
                if (searching.search(companyName, lowerInput) || searching.fuzzyMatching(companyName, input) <= falseStep || companyList.get(i).getCompanyName().contains(input)) {
                    companyResults.add(company);
                    companyResults = sortList(companyResults, company);
                }
            }
            
            // Search in Applicant List (Exact & Fuzzy & Contains Keyword)
            for (int i = 0; i < applicantList.size(); i++) {
                Applicant applicant = applicantList.get(i);
                String applicantName = applicant.getName().toLowerCase();
                if(searching.search(applicantName, lowerInput) || searching.fuzzyMatching(applicantName, input) <= falseStep || applicantList.get(i).getName().contains(input)){
                    applicantResults.add(applicant);
                    applicantResults = sortList(applicantResults, applicant);
                }
            }
   
            // If there is multiple results list, merge it into one
            if(UserManager.isEmployer()){
                if(!jobResults.isEmpty() && !companyResults.isEmpty()){
                    mergeResults = (ListInterface<Job>)mergeList((ListInterface<T>)jobResults, (ListInterface<T>)companyResults);
                    goJob = Input.selectEntity(mergeResults, input);
                } else { 
                    if(!jobResults.isEmpty()){
                        goJob = Input.selectEntity(jobResults, input);
                    } else if(!companyResults.isEmpty()){
                        goCompany = Input.selectEntity(companyResults, input);
                    } else if(!applicantResults.isEmpty()){
                        goApplicant = Input.selectEntity(applicantResults, input);
                    }
                }
            } else {
                if(!jobResults.isEmpty() && !companyResults.isEmpty()){
                    mergeResults = (ListInterface<Job>)mergeList((ListInterface<T>)jobResults, (ListInterface<T>)companyResults);
                    goJob = Input.selectEntity(mergeResults, input);
                } else {
                    if(!jobResults.isEmpty()){
                        goJob = Input.selectEntity(jobResults, input);
                    } else if(!companyResults.isEmpty()){
                        goCompany = Input.selectEntity(companyResults, input);
                    }
                }
            }
            
            // Check if result is empty
            if(jobResults.isEmpty() && companyResults.isEmpty()){
                MessageUI.noMatchFound();
            }
            
            // Display the entity user choose
            if(UserManager.isEmployer()){
                if(goJob != null){
                    JobManager.displayJobDetails(goJob);
                    Tools.clearScreen();
                } else if (goCompany != null) {
                    EmployerManager.displayCompany(goCompany);
                    Tools.clearScreen();
                } else if (goApplicant != null){
                    ApplicantManager.displayEssentialInfo(goApplicant);
                    Tools.clearScreen();
                } else {isContinue = goJob == null && goCompany == null && goApplicant == null;}
            } else {
                if(goJob != null){
                    JobManager.displayJobDetails(goJob);
                    Tools.clearScreen();
                } else if (goCompany != null) {
                    EmployerManager.displayCompany(goCompany);
                    Tools.clearScreen();
                } else {isContinue = goJob == null && goCompany == null && goApplicant == null;}
            }
            
        } while(isContinue);
    }
    
    // Display all the job / applicant in database
    private static <T extends Comparable<T>> void displayAll(String title) {
        
        // Declare a list to store the list from database locally
        ListInterface<T> list = selectList(title); 
        
        // Dynamically identify object types
        T object = getObject(title);
        Job goJob;
        Applicant goApplicant;

        System.out.println("\n       Available " + title );

        // Check if the list is empty
        if (list.isEmpty()) {
            MessageUI.emptyDatabase();
            return;
        }
        
        // Sort the list by using matching engine
        list = sortList(list, object);
        
        // Select the entity and display it
        if(UserManager.isEmployer()){
            if (object instanceof Job) {
                goJob = (Job) Input.selectEntity(list, title);
                if (goJob != null) {
                    cancel = false;
                    JobManager.displayJobDetails(goJob);
                } else {
                    cancel = true;
                }
            } else if (object instanceof Applicant) {
                goApplicant = (Applicant) Input.selectEntity(list, title);
                if (goApplicant != null) {
                    cancel = false;
                    ApplicantManager.displayEssentialInfo(goApplicant);
                } else {
                    cancel = true;
                }
            }
        } else {
            if (object instanceof Job) {
                goJob = (Job) Input.selectEntity(list, title);
                if (goJob != null) {
                    cancel = false;
                    JobApplicationManager.displayBrowseJobs(goJob);
                } else {
                    cancel = true;
                }
            } 
        }
    }
    
    // Call Sorting Method from Matching Engine
    private static <T extends Comparable<T>> ListInterface<T> sortList(ListInterface<T> list, Object object){
        list = MatchingEngine.heapSort(list, object);
        return list;
    }
    
    // Merge two list into one list
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
    
    // Get the title that user choose to display
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
                    case 3 -> {}
                    case 4 -> {}
                    case 5 -> { 
                        return "";
                    }
                    default -> MessageUI.errorMessage();
                } 
            }
        } else {
            return "Job";
        }
    }
    
    // Create and return a specific object
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
}
