package Utility;

import ADT.ListInterface;
import Dao.Database;
import Entity.Applicant;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author All
 * Explanation:
 * 1. Validate common user input
 * 
 */
public class Validation {
    
    // Check whether the applicant is exist
    public static boolean checkApplicant(String name){
        ListInterface<Applicant> applicantList = Database.applicants;
        for(Applicant applicant : applicantList){
            if(applicant.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    // Check whether there is digit in the string
    public static boolean checkString(String text){
        while(text == null || !text.matches("[a-zA-Z]+")){
            MessageUI.invalidName();
            return false;
        }
        return true;
    }
    
    // Check date format
    public static Date checkDate(String dateInput){
        Date date;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        
        if(dateInput == null){
            return null;
        }
        try{
            date = dateFormat.parse(dateInput);
            return date;
        } catch (ParseException e){
            MessageUI.invalidDate();
        }
        return null;
    }
    
    // Check time format
    public static Date checkTime(String timeInput){
        Date time;
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        dateFormat.setLenient(false);
        
        if(timeInput == null){
            return null;
        }
        try{
            time = dateFormat.parse(timeInput);
            return time;
        } catch (ParseException e){
            MessageUI.invalidTime();
        }
        return null;
    }
    
    // Check gender
    public static boolean checkGender(String input){
        String gender = input.toLowerCase();
    
        if (!(gender.equals("male") || gender.equals("female"))) {
            MessageUI.errorMessage();
            return false;
        } 
        return true;
    }
    
    // Check ic format
    public static boolean checkIcInput(String input){
        String ic = input;
        String regex = "^\\d{6}-\\d{2}-\\d{4}$";
        String dob = ic.substring(0,6);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        dateFormat.setLenient(false);
        
        if(!ic.matches(regex)){
            MessageUI.invalidIC();
            return false;
        }
        try{
            dateFormat.parse(dob);
            return true;
        } catch (ParseException e){
            MessageUI.invalidDOB();
            return false;
        }
    }
    
    // Check phone format
    public static boolean checkPhoneInput(String input){
        String phone = input;
        String regex = "01\\d-\\d{7,8}";
        
        if(phone == null || !phone.matches(regex)){
            MessageUI.invalidPhone();
            return false;
        }
        return true;
    }
    
    // Check email input
    public static boolean checkEmailFormat(String input){
        String email = input;
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        
        if(email == null || !email.matches(regex)){
            MessageUI.invalidEmail();
            return false;
        }
        return true;
    }
    
    public static int getValidatedChoice(int numberOfOptions) {
        int choice = -1;
        while (choice < 1 || choice > numberOfOptions) {
            choice = Input.getIntegerInput("Please enter the number for your choice: ");
            if (choice < 1 || choice > numberOfOptions) {
                MessageUI.invalidList();
            }
        }
        return choice;
    }
    
    // Check for multiple choice input
    public static boolean validateMultipleChoices(String input, String[] options, ListInterface<String> outputList) {
        String[] indexes = input.split(",");

        for (String index : indexes) {
            try {
                int choiceIndex = Integer.parseInt(index.trim()) - 1;

                if (choiceIndex >= 0 && choiceIndex < options.length) {
                    outputList.add(options[choiceIndex]);
                } else {
                    MessageUI.errorMessage();
                    return false;
                }
            } catch (NumberFormatException e) {
                MessageUI.errorMessage();
                return false;
            }
        }

        return true;
    }
    
    public static boolean validateYesNo(String input) {
        return input.equals("yes") || input.equals("y") || input.equals("no") || input.equals("n");
    }

}
