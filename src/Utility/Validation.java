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

    // Get and Check whether there is digit in the string
    public static String checkString(String question) {
        String input;
        boolean error;
        int countDigit;
        do{
            countDigit = 0;
            error = false;
            input = Input.getStringInput(question);
            for (int i = 0; i < input.length(); i++) {
                char check = input.charAt(i);
                if (Character.isDigit(check)) {
                    countDigit++;
                }
            }
            if(countDigit > 0){
                error = true;
            }
        } while(error);
        return input;
    }
    
    // Check date format
    public static Date checkDate(String question){
        boolean error;
        String dateString;
        Date date;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        
        do{
            dateString = Input.getStringInput(question);
            try{
                date = dateFormat.parse(dateString);
                return date;
            } catch (ParseException e){
                MessageUI.invalidDate();
                error = true;
            }
        }while(error);
        return null;
    }
    
    // Check time format
    public static Date checkTime(String question){
        boolean error;
        String timeString;
        Date time;
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        dateFormat.setLenient(false);
        
        do{
            timeString = Input.getStringInput(question);
            try{
                time = dateFormat.parse(timeString);
                return time;
            } catch (ParseException e){
                MessageUI.invalidDate();
                error = true;
            }
        }while(error);
        return null;
    }
    
    // Check gender
    public static String checkGender(String question){
        boolean error;
        String gender;
        
        do{
            error = false;
            gender = Input.getStringInput(question);
            if (!(gender.equals("male") || gender.equals("female"))) {
                MessageUI.errorMessage();
                error = true;
            } 
        } while(error);
        
        return gender;
    }
    
    // Check ic format
    public static String checkIcInput(String question){
        boolean error;
        String ic;
        String regex = "^\\d{6}-\\d{2}-\\d{4}$";
        String dob;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        dateFormat.setLenient(false);
        
        do{
            error = false;
            ic = Input.getStringInput(question);
            if(!ic.matches(regex)){
                MessageUI.invalidIC();
                error = true;
            }
            try{
                dob = ic.substring(0,6);
                dateFormat.parse(dob);
            } catch (ParseException e){
                MessageUI.invalidDOB();
            }
        } while(error);
        
        return ic;
    }
    
    // Check phone format
    public static String checkPhoneNumber(String question){
        boolean error;
        String phone;
        String regex = "01\\d-\\d{7,8}";
        
        do{
            error = false;
            phone = Input.getStringInput(question);
            if(phone == null || !phone.matches(regex)){
                MessageUI.invalidPhone();
                error = true;
            }
        } while(error);
        
        return phone;
    }
    
    // Check email input
    public static String checkEmailFormat(String question){
        boolean error;
        String email;
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        
        do{
            error = false;
            email = Input.getStringInput(question);
            if(email == null || !email.matches(regex)){
                MessageUI.invalidEmail();
                error = true;
            }
        } while(error);
        
        return email;
    }
    
    //Validate social media format
    public static String checkSocialMedia(String question){
        boolean error;
        String socialMedia;
        String regex = "^@[A-Za-z0-9._]{3,30}$";
        
        do{
            error = false;
            socialMedia = Input.getStringInput(question);
            if(socialMedia == null || !socialMedia.matches(regex)){
                MessageUI.invalidSocialMedia();
                error = true;
            }
        } while(error);
        
        return socialMedia;
    }
    
    // Validate link format
    public static String checkLink(String question){
        boolean error;
        String link;
        String regex = "^[A-Za-z0-9+_.-]+[A-Za-z0-9.-]+$";
        
        do{
            error = false;
            link = Input.getStringInput(question);
            if(link == null || !link.matches(regex)){
                MessageUI.invalidEmail();
                error = true;
            }
        } while(error);
        
        return link;
    }
    
    // Check for the single choice
    public static boolean validateChoice(String[] options, int input) {
        boolean choice = true;
        if(input <= 0 || input > options.length){
            choice = false;
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
    
    // Validate yes no input
    public static boolean validateYesNoInput(String input){
        if(input == null){
            return false;
        }
        
        return input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no");
    }
}
