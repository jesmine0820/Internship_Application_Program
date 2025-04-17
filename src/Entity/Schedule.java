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
    private String interviewDuration;
    private Date interviewTime;
    private String interviewMode;
    private String venue;
    private Date followUpDate;
    private Date followUpTime;
    private String status;
    private String remark;
    private int score;
    private Employer employer;
    private Applicant applicant;
    private Job job;

    public Schedule() {
    }

    public Schedule(Date interviewDate, String interviewDuration, Date interviewTime, String interviewMode, 
            String venue, Date followUpDate, Date followUpTime, String status, 
            Employer employer, Applicant applicant, Job job, String remark) {
        this.interviewDate = interviewDate;
        this.interviewDuration = interviewDuration;
        this.interviewTime = interviewTime;
        this.interviewMode = interviewMode;
        this.venue = venue;
        this.followUpDate = followUpDate;
        this.followUpTime = followUpTime;
        this.status = status;
        this.employer = employer;
        this.applicant = applicant;
        this.job = job;
        this.remark = remark;
        score = 0;
    }
    
    public Job getJob(){
        return job;
    }
    
    public void setJob(Job job){
        this.job = job;
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
    
    public String getInterviewDuration(){
        return interviewDuration;
    }
    
    public void setInterviewDuration(String interviewDuration){
        this.interviewDuration = interviewDuration;
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
    
    public String getRemark(){
        return remark;
    }
    
    public void setRemark(String remark){
        this.remark = remark;
    }
    
    public int getScore(){
        return score;
    }
    
    public void setScore(int score){
        this.score = score;
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
