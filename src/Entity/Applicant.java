package Entity;

import ADT.ListInterface;
import java.util.Date;

/**
 *
 * Author - GanKhaiLi
 * 
 * Explanations:
 * 1. 
 * 
 */
public class Applicant extends Person implements Comparable<Applicant>{

    private String location;
    private String portfolioLink;
    private String preferredWorkMode;
    private String desiredJobType;
    private int yearOfExperience;
    private String desiredSalaryRange;
    private boolean willingToRelocate;
    private String availability;
    private Resume resume;
    private ListInterface<JobApplication> jobApplication;

    public Applicant(){
        
    }

    //ADD-ON ===========================
    public Applicant(String id, String name, Date dateOfBirth, String gender, String address, String ic, String phoneNumber, String email, String socialMedia, String maritalStatus) {
        super(id, name, dateOfBirth, gender, address, ic, phoneNumber, email, socialMedia, maritalStatus);
    }

    public Applicant(String location, String portfolioLink, String preferredWorkMode, String desiredJobType, int yearOfExperience, String desiredSalaryRange, boolean willingToRelocate, String availability, Resume resume, String id, String name, Date dateOfBirth, String gender, String address, String ic, String phoneNumber, String email, String socialMedia, String maritalStatus) {
        super(id, name, dateOfBirth, gender, address, ic, phoneNumber, email, socialMedia, maritalStatus);
        this.location = location;
        this.portfolioLink = portfolioLink;
        this.preferredWorkMode = preferredWorkMode;
        this.desiredJobType = desiredJobType;
        this.yearOfExperience = yearOfExperience;
        this.desiredSalaryRange = desiredSalaryRange;
        this.willingToRelocate = willingToRelocate;
        this.availability = availability;
        this.resume = resume;
    }

    public Applicant(String location, String portfolioLink, String preferredWorkMode, String desiredJobType, int yearOfExperience, String desiredSalaryRange, boolean willingToRelocate, String availability) {
        this.location = location;
        this.portfolioLink = portfolioLink;
        this.preferredWorkMode = preferredWorkMode;
        this.desiredJobType = desiredJobType;
        this.yearOfExperience = yearOfExperience;
        this.desiredSalaryRange = desiredSalaryRange;
        this.willingToRelocate = willingToRelocate;
        this.availability = availability;
    }
    
    //===============================================================
    public Applicant(String location, String portfolioLink, String preferredWorkMode, String desiredJobType, int yearOfExperience, String desiredSalaryRange, boolean willingToRelocate, String availability, Resume resume, ListInterface<JobApplication> jobApplication) {
        this.location = location;
        this.portfolioLink = portfolioLink;
        this.preferredWorkMode = preferredWorkMode;
        this.desiredJobType = desiredJobType;
        this.yearOfExperience = yearOfExperience;
        this.desiredSalaryRange = desiredSalaryRange;
        this.willingToRelocate = willingToRelocate;
        this.availability = availability;
        this.resume = resume;
        this.jobApplication = jobApplication;
    }

    public Applicant(String location, String portfolioLink, String preferredWorkMode, String desiredJobType, int yearOfExperience, String desiredSalaryRange, boolean willingToRelocate, String availability, Resume resume, ListInterface<JobApplication> jobApplication, String id, String name, Date dateOfBirth, String gender, String address, String ic, String phoneNumber, String email, String socialMedia, String maritalStatus) {
        super(id, name, dateOfBirth, gender, address, ic, phoneNumber, email, socialMedia, maritalStatus);
        this.location = location;
        this.portfolioLink = portfolioLink;
        this.preferredWorkMode = preferredWorkMode;
        this.desiredJobType = desiredJobType;
        this.yearOfExperience = yearOfExperience;
        this.desiredSalaryRange = desiredSalaryRange;
        this.willingToRelocate = willingToRelocate;
        this.availability = availability;
        this.resume = resume;
        this.jobApplication = jobApplication;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public ListInterface<JobApplication> getJobApplication() {
        return jobApplication;
    }

    public void setJobApplication(ListInterface<JobApplication> jobApplication) {
        this.jobApplication = jobApplication;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPortfolioLink() {
        return portfolioLink;
    }

    public void setPortfolioLink(String portfolioLink) {
        this.portfolioLink = portfolioLink;
    }

    public String getPreferredWorkMode() {
        return preferredWorkMode;
    }

    public void setPreferredWorkMode(String preferredWorkMode) {
        this.preferredWorkMode = preferredWorkMode;
    }

    public String getDesiredJobType() {
        return desiredJobType;
    }

    public void setDesiredJobType(String desiredJobType) {
        this.desiredJobType = desiredJobType;
    }
    
    public int getYearOfExperience(){
        return yearOfExperience;
    }

    public void setYearOfExperience(int yearOfExperience){
        this.yearOfExperience = yearOfExperience;
    }
    
    public String getDesiredSalaryRange() {
        return desiredSalaryRange;
    }

    public void setDesiredSalaryRange(String desiredSalaryRange) {
        this.desiredSalaryRange = desiredSalaryRange;
    }

    public boolean isWillingToRelocate() {
        return willingToRelocate;
    }

    public void setWillingToRelocate(boolean willingToRelocate) {
        this.willingToRelocate = willingToRelocate;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    //need to change
    @Override
    public String toString() {
        return super.toString() + "Applicant{" + "location=" + location + ", portfolioLink=" + portfolioLink + ", preferredWorkMode=" + preferredWorkMode + ", desiredJobType=" + desiredJobType + ", desiredSalaryRange=" + desiredSalaryRange + ", willingToRelocate=" + willingToRelocate + ", availability=" + availability + '}';
    }

    @Override
    public int compareTo(Applicant other) {
        return super.getName().compareTo(other.getName());
    }

}
