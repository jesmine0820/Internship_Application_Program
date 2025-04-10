/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import ADT.DoublyLinkedList;
import ADT.ListInterface;
import Entity.*;

/**
 *
 * @author User
 */
public class Database {
    
    // Define current user
    private static Employer currentEmployer = null;
    private static Applicant currentApplicant = null;
    
    // Create List
    public static final ListInterface<Company> companies = new DoublyLinkedList<>();
    public static final ListInterface<Applicant> applicants = new DoublyLinkedList();
    public static final ListInterface<Job> jobList = new DoublyLinkedList();
    public static final ListInterface<Employer> employers = new DoublyLinkedList();
    public static final ListInterface<Schedule> schedules = new DoublyLinkedList<>();
    
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
    
}
