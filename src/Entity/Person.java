package Entity;

import java.util.Date;

/**
 *
 * Author - GanKhaiLi
 * 
 * Explanations:
 * 1. 
 * 
 */

public class Person {

    private String id;
    private String name;
    private Date dateOfBirth;
    private String gender;
    private String address;
    private String ic;
    private String phoneNumber;
    private String email;
    private String socialMedia;
    private String maritalStatus;
    public static String CURRENTNAME;
    public static String CURRENTID;

    public Person(){
        
    }
    
    public Person(String id, String name, Date dateOfBirth, String gender, String address, 
                  String ic, String phoneNumber, String email, String socialMedia, 
                  String maritalStatus) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.ic = ic;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.socialMedia = socialMedia;
        this.maritalStatus = maritalStatus;
    }

    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public static String getCURRENTNAME() {
        return CURRENTNAME;
    }

    public static void setCURRENTNAME(String CURRENTNAME) {
        Person.CURRENTNAME = CURRENTNAME;
    }

    public static String getCURRENTID() {
        return CURRENTID;
    }

    public static void setCURRENTID(String CURRENTID) {
        Person.CURRENTID = CURRENTID;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", address=" + address + ", ic=" + ic + ", phoneNumber=" + phoneNumber + ", email=" + email + ", socialMedia=" + socialMedia + ", maritalStatus=" + maritalStatus;
    }

    //Validation of user input
    //name
    public static boolean nameValid(String name) {
        boolean valid = false;
        if(name.matches("[a-zA-Z ]+")){
            valid = true;
        }
        return valid;
    }

    //gender
    public static boolean genderValid(String gender) {
        boolean valid = false;
        if(gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")) {
            valid = true;
        }
        return valid;
    }

    //ic
    public static boolean icValid(String ic) {
        boolean valid = false;
        if(ic.matches("\\d{12}")) {
            valid = true;
        }
        return valid;
    }

    //phoneNumber
    public static boolean phoneValid(String phone) {
        boolean valid = false;
        if(phone.matches("01\\d{8,9}")) {
            valid = true;
        }
        return valid;
    }

    //email
    public static boolean emailValid(String email) {
        boolean valid = false;
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if(email.matches(regex)) {
            valid = true;
        }
        return valid;
    }

    //nationality
    public static boolean nationalityValid(String nationality) {
        boolean valid = false;
        if(nationality.matches("^[A-Za-z ]+$")) {
            valid = true;
        }
        return valid;
    }

}
