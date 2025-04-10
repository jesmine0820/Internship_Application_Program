/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * Author - ChanJingHui
 * 
 * Explanations:
 * 1. 
 * 
 */

public class Schedule implements Comparable<Schedule>{

    private Date interviewDate;
    private Date interviewTime;
    private String interviewMode;
    private String venue;
    private Date followUpDate;
    private Date followUpTime;
    private String status;
    private Employer employer;
    private Applicant applicant;

    public Schedule() {
    }

    public Schedule(Date interviewDate, Date interviewTime, String interviewMode, 
            String venue, Date followUpDate, Date followUpTime, String status, 
            Employer employer, Applicant applicant) {
        this.interviewDate = interviewDate;
        this.interviewTime = interviewTime;
        this.interviewMode = interviewMode;
        this.venue = venue;
        this.followUpDate = followUpDate;
        this.followUpTime = followUpTime;
        this.status = status;
        this.employer = employer;
        this.applicant = applicant;
    }
    
    public Employer getEmployer(){
        return employer;
    }
    
    public void setEmployer(Employer employer){
        this.employer = employer;
    }
    
    public Applicant getApplicant(){
        return applicant;
    }
    
    public void setApplicant(Applicant applicant){
        this.applicant = applicant;
    }
    
    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }
    
    public Date getInterviewTime(){
        return interviewTime;
    }
    
    public void setInterviewTime(Date interviewTime){
        this.interviewTime = interviewTime;
    }

    public String getInterviewMode() {
        return interviewMode;
    }

    public void setInterviewMode(String interviewMode) {
        this.interviewMode = interviewMode;
    }
    
    public String getVenue(){
        return venue;
    }
    
    public void setVenue(String venue){
        this.venue = venue;
    }

    public Date getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(Date followUpDate) {
        this.followUpDate = followUpDate;
    }
    
    public Date getFollowUpTime(){
        return followUpTime;
    }
    
    public void setFollowUpTime(Date followUpTime){
        this.followUpTime = followUpTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Schedule{" + "interviewDate=" + interviewDate + ", interviewMode=" + interviewMode + ", followUpDate=" + followUpDate + ", status=" + status + '}';
    }

    @Override
    public int compareTo(Schedule other) {
        return this.getInterviewDate().compareTo(other.getInterviewDate());
    }

}
