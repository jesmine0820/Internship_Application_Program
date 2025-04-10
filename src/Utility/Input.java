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
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        int choice = Validation.getValidatedChoice(options.length);
        return options[choice - 1];
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
    
    //yes/no
    public static String getYesNoInput(String question) {
        String value;

        while (true) {
            System.out.print(question);
            value = input.nextLine().trim().toLowerCase();

            if (Validation.validateYesNo(value)) {
                return (value.equals("y") || value.equals("yes")) ? "yes" : "no";
            } else {
                System.out.println("Invalid input. Please enter 'yes'/'y' or 'no'/'n'.");
            }
        }
    }

}
