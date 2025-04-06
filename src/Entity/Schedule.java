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
    private String interviewMode;
    private Date followUpDate;
    private String status;
    private Employer employer;

    public Schedule() {
    }

    public Schedule(Date interviewDate, String interviewMode, Date followUpDate, String status, Employer employer) {
        this.interviewDate = interviewDate;
        this.interviewMode = interviewMode;
        this.followUpDate = followUpDate;
        this.status = status;
        this.employer = employer;
    }
    
    public Employer getEmployer(){
        return employer;
    }
    
    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getInterviewMode() {
        return interviewMode;
    }

    public void setInterviewMode(String interviewMode) {
        this.interviewMode = interviewMode;
    }

    public Date getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(Date followUpDate) {
        this.followUpDate = followUpDate;
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
