/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import ADT.ListInterface;
import java.util.Date;

/**
 *
 * Author - KitChinJieYing
 * 
 * Explanations:
 * 1. 
 * 
 */
public class Employer extends Person implements Comparable<Employer>{

    private String department;
    private String position;
    private Date joinedDate;
    private int yearOfExperience;
    private ListInterface<Job> job;
    private Company company;
    
    // Constructor
    public Employer(){
    
    }
    
    public Employer(String id, String name, Date dateOfBirth, String gender, String address,
                    String ic, String phoneNumber, String email, String socialMedia, String maritalStatus, 
                    String nationality, String department, String position, Date joinedDate, int yearOfExperience,
                    ListInterface<Job> job, Company company) {
        super(id, name, dateOfBirth, gender, address, ic, phoneNumber, email, socialMedia, maritalStatus, nationality);
        this.department = department;
        this.position = position;
        this.joinedDate = joinedDate;
        this.yearOfExperience = yearOfExperience;
        this.job = job;
        this.company = company;
    }
    
    public Company getCompany(){
        return company;
    }

    public ListInterface<Job> getJob() {
        return job;
    }

    public void setJob(ListInterface<Job> job) {
        this.job = job;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public int getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(int yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Employer{" + "department=" + department + ", position=" + position + ", joinedDate=" + joinedDate + ", yearOfExperience=" + yearOfExperience + '}';
    }

    @Override
    public int compareTo(Employer other) {
        int experienceComparison = Integer.compare(this.yearOfExperience, other.yearOfExperience);
        if (experienceComparison != 0) {
            return experienceComparison;
        }
        return super.getName().compareTo(other.getName()); // If experience is the same, sort by name
    }
}
