package Utility;

import static Utility.Tools.RED;
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
    
}
