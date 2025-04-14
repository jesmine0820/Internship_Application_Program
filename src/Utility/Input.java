package Utility;

import ADT.DoublyLinkedList;
import ADT.ListInterface;
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
            if(Validation.validateChoice(options, choice)){
                error = true;
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
    
    // Get paginated multi-select input --- for skill
    public static ListInterface<String> getPaginatedMultiSelectInput(String question, String[] options){
        ListInterface<String> listItem = new DoublyLinkedList<>();
        listItem = null;
        return listItem;
    }
}
