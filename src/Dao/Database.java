/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import ADT.DoublyLinkedList;
import ADT.ListInterface;
import Entity.Applicant;
import Entity.Company;
import Entity.Employer;
import Entity.Job;
import Entity.JobApplication;
import Entity.Schedule;
import java.util.Date;

/**
 *
 * @author User
 */
public class Database {
    
    // Define current user
    private static Employer currentEmployer = null;
    private static Applicant currentApplicant = null;
    
    private static Date currentDate = null;
    private static Date currentTime = null;
    
    // Create List
    public static final ListInterface<Company> companies = new DoublyLinkedList<>();
    public static final ListInterface<Applicant> applicants = new DoublyLinkedList();
    public static final ListInterface<Job> jobList = new DoublyLinkedList();
    public static final ListInterface<Employer> employers = new DoublyLinkedList();
    public static final ListInterface<Schedule> schedules = new DoublyLinkedList<>();
    public static final ListInterface<JobApplication> jobApplicationList = new DoublyLinkedList<>(); 
    public static final ListInterface<String> searchHistory = new DoublyLinkedList<>();
    
    // Get and setter for current user
    public static Employer getEmployer(){
        return currentEmployer;
    }
    
    public static void setEmployer(Employer employer){
        currentEmployer = employer;
    }
    
    public static Applicant getApplicant(){
        return currentApplicant;
    }
    
    public static void setApplicant(Applicant applicant){
        currentApplicant = applicant;
    }
    
    public static Date getCurrentDate(){
        return currentDate;
    }
    
    public static void setCurrentDate(Date date){
        currentDate = date;
    }
    
    public static Date getCurrentTime(){
        return currentTime;
    }
    
    public static void setCurrentTime(Date time){
        currentTime = time;
    }
    
}
