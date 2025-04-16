package Utility;

import ADT.DoublyLinkedList;
import ADT.ListInterface;
import Boundary.BrowseUI;
import Boundary.UserUI;
import Control.ApplicantManager;
import Control.BrowseManager;
import Control.JobManager;
import Control.UserManager;
import Dao.Database;
import Entity.Applicant;
import Entity.Company;
import Entity.Employer;
import Entity.Job;
import Entity.JobApplication;
import static Utility.Tools.BLUE;
import static Utility.Tools.GREY;
import static Utility.Tools.RESET;
import static java.lang.Character.toUpperCase;
import java.util.Scanner;

/**
 * Author - JesmineTeyKhaiJing
 * 
 * Explanations:
 * 1. Used for validation like checking User Input
 * 
 */

public class Input {
    
    static Scanner input = new Scanner(System.in);
    
    // Get Integer Input from User Keyboard
    public static int getIntegerInput(){
        int value;
        
        try{
            value = input.nextInt();
            input.nextLine();
        } catch (Exception e) {
            input.nextLine();
            MessageUI.inputIntegerMessage();
            return -1;
        }
        
        return value;
    }
    
    // Get Integer Input from User Keyboard with Defined Question
    public static int getIntegerInput(String question){
        int value;
        
        try{
            System.out.print(question);
            value = input.nextInt();
            input.nextLine();
        }catch (Exception e) {
            input.nextLine();
            MessageUI.inputIntegerMessage();
            return -1;
        }
        
        return value;
    }
    
    // Get Double
    public static double getDoubleInput(String question){
        double value;
        
        try{
            System.out.println(question);
            value = input.nextDouble();
        }catch (Exception e) {
            input.nextLine();
            MessageUI.inputIntegerMessage();
            return -1;
        }
        
        return value;
    }
    
    // Get String Input from User Keyboard
    public static String getStringInput(){
        String value;
        
        try{
            value = input.nextLine();
        } catch (Exception e){
            input.nextLine();
            return null;
        }
        
        return value;
    }
    
    // Get String Input from User Keyboard with Defined Question
    public static String getStringInput(String question){
        String value;
        
        try{
            System.out.print(question);
            value = input.nextLine();
        } catch (Exception e){
            input.nextLine();
            return null;
        }
        
        return value;
    }
    
    public static boolean getBooleanInput(String question){
        boolean yes = false;
        int choice;
        boolean error;
        do{
            error = false;
            System.out.println("[1] for 'yes', [0] for 'no'");
            choice = getIntegerInput(question);
            switch (choice){
                case 1 -> yes = true;
                case 2 -> yes = false;
                default -> {
                    MessageUI.errorMessage();
                    error = true;
                }
            }
        }while(error);
        return yes;
    }
    
    // Check whether the user want to continue the operation
    public static int getIsContinue(String answer){
        if (toUpperCase(answer.charAt(0)) != 'Y' && toUpperCase(answer.charAt(0)) != 'N'){
            MessageUI.inputIntegerMessage();
            return -1;
        }
        
        if (toUpperCase(answer.charAt(0)) == 'Y'){
            return 1;
        } else {
            return 0;
        }
    }
    
    // Get single choice function
    public static String getChoiceInput(String question, String[] options) {
        int choice;
        boolean error;
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        do{
            error = false;
            choice = getIntegerInput(question);
            if(!Validation.validateChoice(options, choice)){
                error = true;
                MessageUI.errorMessage();
            }
        } while(error);
        return options[choice-1];
    }

    //multiple choice
    public static ListInterface<String> getMultipleChoiceInput(String question, String[] options) {
        ListInterface<String> selectedChoices = new DoublyLinkedList<>();

        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        boolean validInput = false;
        while (!validInput) {
            String value = getStringInput("Enter numbers of your choices (comma-separated): ");
            selectedChoices.clear(); 
            validInput = Validation.validateMultipleChoices(value, options, selectedChoices);

            if (!validInput) {
                MessageUI.invalidList();
            }
        }

        return selectedChoices;
    }
    
    // Get String list
    public static ListInterface<String> getStringListInput(String question){
        ListInterface<String> listItem = new DoublyLinkedList<>();
        try{
            System.out.println("question");
            String value = input.nextLine();
            String[] items = value.split("\\s*,\\s*");
            for(String item : items){
                listItem.add(item);
            }
        } catch (Exception e){
            input.nextLine();
            return null;
        }
        return listItem;
    }
    
    //yes/no
    public static String getYesNoInput(String question) {
        boolean error;
        String yesNo;
        do{
            error = false;
            yesNo = Input.getStringInput(question);
            if(!Validation.validateYesNoInput(yesNo)){
                error = true;
            }
        }while(error);
        return yesNo;
    }
    
    // Select attribute in pages
    public static ListInterface<String> getPaginatedMultiSelectInput(String question, String[] options) {
        int pageSize = 10;
        int currentPage = 0;
        boolean finished = false;
        ListInterface<String> selectedItems = new DoublyLinkedList<>();
        int totalItems = options.length;
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);
        boolean firstPage = false;
        boolean lastPage = false;

        while (!finished) {
            int startIndex = currentPage * pageSize;
            int endIndex = Math.min(startIndex + pageSize, totalItems);

            System.out.println(question);
            System.out.println("Page " + (currentPage + 1) + " of " + totalPages);
            for (int i = startIndex; i < endIndex; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            if(currentPage == 0){
                firstPage = true;
            }
            
            if(currentPage == totalPages-1){
                lastPage = true;
                lastPage();
            }
            
            if(firstPage && lastPage){
                String selectedOption = chooseOnePageEntity();
                switch(selectedOption){
                    case "X" -> {
                        finished = true;
                        return null;
                    }
                    case "x" -> {
                        finished = true;
                        return null;
                    }
                    default -> {
                        String[] choices = selectedOption.split(",");
                        for (String choice : choices) {
                            try {
                                int index = Integer.parseInt(choice.trim()) - 1;
                                if (index >= 0 && index < options.length) {
                                    String item = options[index];
                                    if (!selectedItems.contains(item)) {
                                        selectedItems.add(item);
                                    }
                                }
                            } catch (NumberFormatException e) {
                                MessageUI.errorMessage();
                            }
                        }
                    }
                }
            } else if(firstPage){
                String selectedOption = chooseFirstPageEntity();
                switch(selectedOption){
                    case "N" -> {
                        if (currentPage < totalPages - 1) currentPage++;
                    }
                    case "X" -> {
                        finished = true;
                        return null;
                    }
                    case "x" -> {
                        finished = true;
                        return null;
                    }
                    default -> {
                        String[] choices = selectedOption.split(",");
                        for (String choice : choices) {
                            try {
                                int index = Integer.parseInt(choice.trim()) - 1;
                                if (index >= 0 && index < options.length) {
                                    String item = options[index];
                                    if (!selectedItems.contains(item)) {
                                        selectedItems.add(item);
                                    }
                                }
                            } catch (NumberFormatException e) {
                                MessageUI.errorMessage();
                            }
                        }
                    }
                }
            } else if(lastPage){
                String selectedOption = chooseLastPageEntity();
                switch(selectedOption){
                    case "P" -> {
                        if(currentPage > 0) currentPage--;
                    }
                    case "X" -> {
                        finished = true;
                        return null;
                    }
                    case "x" -> {
                        finished = true;
                        return null;
                    }
                    default -> {
                        String[] choices = selectedOption.split(",");
                        for (String choice : choices) {
                            try {
                                int index = Integer.parseInt(choice.trim()) - 1;
                                if (index >= 0 && index < options.length) {
                                    String item = options[index];
                                    if (!selectedItems.contains(item)) {
                                        selectedItems.add(item);
                                    }
                                }
                            } catch (NumberFormatException e) {
                                MessageUI.errorMessage();
                            }
                        }
                    }
                }
            } else {
                String selectedOption = chooseLastPageEntity();
                switch(selectedOption){
                    case "N" -> {
                        if (currentPage < totalPages - 1) currentPage++;
                    }
                    case "P" -> {
                        if(currentPage > 0) currentPage--;
                    }
                    case "X" -> {
                        finished = true;
                        return null;
                    }
                    case "x" -> {
                        finished = true;
                        return null;
                    }
                    default -> {
                        String[] choices = selectedOption.split(",");
                        for (String choice : choices) {
                            try {
                                int index = Integer.parseInt(choice.trim()) - 1;
                                if (index >= 0 && index < options.length) {
                                    String item = options[index];
                                    if (!selectedItems.contains(item)) {
                                        selectedItems.add(item);
                                    }
                                }
                            } catch (NumberFormatException e) {
                                MessageUI.errorMessage();
                            }
                        }
                    }
                }
            }
        }
        return selectedItems;
    }
    
    // Select one entity
    public static <T> T selectUser(ListInterface<T> list, String string){
        final int ENTRIES_PER_PAGE = 10;
        int page = 0;
        int totalPages = (int)Math.ceil((double)list.size() / ENTRIES_PER_PAGE);
        boolean firstPage = false;
        boolean lastPage = false;
        
        while(true){
            Tools.clearScreen();
            UserManager.profileHeadLine();
            System.out.println("            -------------------------------------------");
            System.out.println("                " + string + "List ( Page " + (page + 1) + " of " + totalPages + " )");
            System.out.println("            -------------------------------------------\n");
            System.out.println("            -------------------------------------------");
            
            int start = page * ENTRIES_PER_PAGE;
            int end = Math.min(start + ENTRIES_PER_PAGE, list.size());
            
            for(int i = start; i < end; i++){
                T entity = list.get(i);
                
                if(entity instanceof Employer employer){
                    System.out.println("                " + (i + 1) + ". " + employer.getName() + " ( " + employer.getCompany().getCompanyName() + " )");
                    System.out.println("            -------------------------------------------");
                }
                
                if (entity instanceof Applicant applicant) {
                    System.out.println("                " + (i + 1) + ". " + applicant.getName());
                    System.out.println("            -------------------------------------------");
                }
            }
            
            if(page == 0){
                firstPage = true;
            }
            
            if(page == totalPages - 1){
                lastPage = true;
                lastPage();
            }
            
            if(firstPage){
                String userInput = UserUI.chooseFirstPageEntity();
                switch (userInput.toUpperCase()){
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
                                UserManager.setCurrentDateTime();
                                return list.get(choice-1);
                            } else {
                                MessageUI.errorMessage();
                            }
                        } catch (NumberFormatException e){
                            MessageUI.errorMessage();
                        }
                    }
                }
            } else if(lastPage){
                String userInput = UserUI.chooseLastPageEntity();
                switch (userInput.toUpperCase()){
                    case "P" -> {
                        if(page > 0) page--;
                    }
                    case "X" -> {
                        return null;
                    }
                    default -> {
                        try {
                            int choice = Integer.parseInt(userInput);
                            if (choice >= 1 && choice <= list.size()){
                                UserManager.setCurrentDateTime();
                                return list.get(choice-1);
                            } else {
                                MessageUI.errorMessage();
                            }
                        } catch (NumberFormatException e){
                            MessageUI.errorMessage();
                        }
                    }
                }
            } else {
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
                                UserManager.setCurrentDateTime();
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
    }
    
    // Select entity based on string
    public static <T> T selectEntity(ListInterface<T> list, String input){
        final int ENTRIES_PER_PAGE = 10;
        int page = 0;
        int totalPages = (int)Math.ceil((double)list.size() / ENTRIES_PER_PAGE);
        T entity;
        Applicant currentApplicant;
        ListInterface<JobApplication> application = new DoublyLinkedList<>();
        boolean isGrey = false;
        boolean firstPage = false;
        boolean lastPage = false;
        
        if(UserManager.isApplicant()){
            currentApplicant = Database.getApplicant();
            for(JobApplication apply : Database.jobApplicationList){
                if(apply.getApplicant().equals(currentApplicant)){
                    application.add(apply);
                }
            }
        }
        
        System.out.println("Search Result for  " + BLUE + input + RESET + " : ");
        
        while(true){
            
            Tools.clearScreen();
            UserManager.profileHeadLine();

            int start = page * ENTRIES_PER_PAGE;
            int end = Math.min(start + ENTRIES_PER_PAGE, list.size());
            
            for(int i = start; i < end; i++){ 
                Object obj = list.get(i);
                
                if(UserManager.isApplicant()){
                    for(JobApplication applied : application){
                        Job appliedJob = applied.getJob();
                        if(appliedJob == obj){
                            System.out.println(GREY);
                            isGrey = true;
                        }
                    }
                }
                
                System.out.println(obj);

                switch (obj) {
                    case Job job -> {
                        JobManager.displayBrowseJobDetail(job, i);
                    }
                    case Applicant applicant -> {
                        ApplicantManager.displayBrowseApplicant(applicant, i);
                    }
                    case Company company -> {
                        JobManager.displayJobUnderCompany(company);
                    }
                    default -> {
                        MessageUI.invalidTitle();
                    }
                }
            }
            
            if(isGrey){
                System.out.println(RESET);
            }
            
            if (page == 0){
                firstPage = true;
            }
            
            if (page == totalPages - 1) {
                lastPage = true;
                lastPage();
            }
            
            if(firstPage && lastPage){
                String userInput = chooseOnePageEntity();
                switch(userInput){
                    case "X" -> {
                        BrowseManager.setCancel(true);
                        return null;
                    }
                    case "x" -> {
                        BrowseManager.setCancel(true);
                        return null;
                    }
                    default -> {
                        try {
                            int choice = Integer.parseInt(userInput);
                            if (choice >= 1 && choice <= list.size()){
                                entity = list.get(choice-1);
                                return entity;
                            } else {
                                MessageUI.errorMessage();
                            }
                        } catch (NumberFormatException e){
                            MessageUI.errorMessage();
                        }
                    }
                }
            } else if(firstPage){
                String userInput = chooseFirstPageEntity();
                switch (userInput.toUpperCase()){
                    case "N" -> {
                        if (page < totalPages - 1) page++;
                    }
                    case "X" -> {
                        BrowseManager.setCancel(true);
                        return null;
                    }
                    case "x" -> {
                        BrowseManager.setCancel(true);
                        return null;
                    }
                    default -> {
                        try {
                            int choice = Integer.parseInt(userInput);
                            if (choice >= 1 && choice <= list.size()){
                                entity = list.get(choice-1);
                                return entity;
                            } else {
                                MessageUI.errorMessage();
                            }
                        } catch (NumberFormatException e){
                            MessageUI.errorMessage();
                        }
                    }
                } 
            } else if (lastPage){
                String userInput = chooseLastPageEntity();
                switch (userInput.toUpperCase()){
                    case "P" -> {
                        if(page > 0) page--;
                    }
                    case "X" -> {
                        BrowseManager.setCancel(true);
                        return null;
                    }
                    case "x" -> {
                        BrowseManager.setCancel(true);
                        return null;
                    }
                    default -> {
                        try {
                            int choice = Integer.parseInt(userInput);
                            if (choice >= 1 && choice <= list.size()){
                                entity = list.get(choice-1);
                                return entity;
                            } else {
                                MessageUI.errorMessage();
                            }
                        } catch (NumberFormatException e){
                            MessageUI.errorMessage();
                        }
                    }
                } 
            } else {
                String userInput = chooseEntity();
                switch (userInput.toUpperCase()){
                    case "P" -> {
                        if(page > 0) page--;
                    }
                    case "N" -> {
                        if (page < totalPages - 1) page++;
                    }
                    case "X" -> {
                        BrowseManager.setCancel(true);
                        return null;
                    }
                    default -> {
                        try {
                            int choice = Integer.parseInt(userInput);
                            if (choice >= 1 && choice <= list.size()){
                                entity = list.get(choice-1);
                                return entity;
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
    }
    
    public static void lastPage(){
        System.out.println("            ************No More Page Available**********");
    }
    
    public static String chooseEntity(){
        String choice;
        
        System.out.println("\n      Options: [P] Previous Page  [N] Next Page  [X] Cancel Selection");
        
        choice = Input.getStringInput("Enter choice > ").trim();
        
        return choice;
    }
    
    public static String chooseFirstPageEntity(){
        String choice;
        
        System.out.println("\n            Options: [N] Next Page  [X] Cancel Selection");
        
        choice = Input.getStringInput("Enter choice > ").trim();
        
        return choice;
    }
    
    public static String chooseLastPageEntity(){
        String choice;
        
        System.out.println("\n            Options: [P] Previous Page  [X] Cancel Selection");
        
        choice = Input.getStringInput("Enter choice > ").trim();
        
        return choice;
    }
    
    public static String chooseOnePageEntity(){
        String choice;
        
        System.out.println("\n                      Options: [X] Cancel Selection");
    
        choice = Input.getStringInput("Enter choice > ").trim();
        
        return choice;
    }
}
