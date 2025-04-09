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

public class JobApplication implements Comparable<JobApplication> {

    private String applicationID;
    private Date applicationDate;
    private String status;
    private boolean resumeSubmitted;
    private boolean interviewScheduled;
    private String recruiterNotes;
    private String feedback;
    private Applicant applicant;
    private Job job;

    public JobApplication() {
        
    }

    public JobApplication(String applicationID, Date applicationDate, String status, boolean resumeSubmitted,  
                          boolean interviewScheduled, String recruiterNotes, String feedback, Applicant applicant, Job job) {
        this.applicationID = applicationID;
        this.applicationDate = applicationDate;
        this.status = status;
        this.resumeSubmitted = resumeSubmitted;
        this.interviewScheduled = interviewScheduled;
        this.recruiterNotes = recruiterNotes;
        this.feedback = feedback;
        this.applicant = applicant;
        this.job = job;
    }
    
    public Applicant getApplicant(){
        return applicant;
    }
    
    public Job getJob(){
        return job;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setapplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isResumeSubmitted() {
        return resumeSubmitted;
    }

    public void setResumeSubmitted(boolean resumeSubmitted) {
        this.resumeSubmitted = resumeSubmitted;
    }

    public boolean isInterviewScheduled() {
        return interviewScheduled;
    }

    public void setInterviewScheduled(boolean interviewScheduled) {
        this.interviewScheduled = interviewScheduled;
    }

    public String getRecruiterNotes() {
        return recruiterNotes;
    }

    public void setRecruiterNotes(String recruiterNotes) {
        this.recruiterNotes = recruiterNotes;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    //need to change
    @Override
    public String toString() {
        return "JobApplication{" + "applicationID=" + applicationID + ", applicantDate=" + applicationDate + ", status=" + status + ", resumeSubmitted=" + resumeSubmitted +  ", interviewScheduled=" + interviewScheduled + ", recruiterNotes=" + recruiterNotes + ", feedback=" + feedback + '}';
    }
    
    @Override
    public int compareTo(JobApplication other) {
        return this.applicationDate.compareTo(other.applicationDate); // Compare by date
    }

}
