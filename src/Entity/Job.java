/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * Author - KitChinJieYing
 * 
 * Explanations:
 * 1. 
 * 
 */
import ADT.ListInterface;
import java.util.Date;

public class Job implements Comparable<Job>{

    private String jobID;
    private String jobTitle;
    private String jobType;
    private String jobDescription;
    private String interviewProcess;
    private String employmentType;
    private String probationPeriod;
    private boolean relocationAssistance;
    private ListInterface<String> requiredSkills;
    private int requiredExperience;
    private int teamSize;
    private double salary;
    private ListInterface<String> benefits;
    private Date applicationDeadline;
    private int workHours;
    private String careerDevelopment;
    private ListInterface<JobApplication> jobApplication;
    private ListInterface<Schedule> schedule;
    private Employer employer;

    public Job() {
    }

    public Job(String jobID, String jobTitle, String jobType, String jobDescription, String interviewProcess, 
               String employmentType, String probationPeriod, boolean relocationAssistance, ListInterface<String> requiredSkills, 
               int requiredExperience, int teamSize, double salary, ListInterface<String> benefits, 
               Date applicationDeadline, int workHours, String careerDevelopment, ListInterface<JobApplication> jobApplication, 
               ListInterface<Schedule> schedule, Employer employer) {
        this.jobID = jobID;
        this.jobTitle = jobTitle;
        this.jobType = jobType;
        this.jobDescription = jobDescription;
        this.interviewProcess = interviewProcess;
        this.employmentType = employmentType;
        this.probationPeriod = probationPeriod;
        this.relocationAssistance = relocationAssistance;
        this.requiredSkills = requiredSkills;
        this.requiredExperience = requiredExperience;
        this.teamSize = teamSize;
        this.salary = salary;
        this.benefits = benefits;
        this.applicationDeadline = applicationDeadline;
        this.workHours = workHours;
        this.careerDevelopment = careerDevelopment;
        this.jobApplication = jobApplication;
        this.schedule = schedule;
        this.employer = employer;
    }

    public ListInterface<JobApplication> getJobApplication() {
        return jobApplication;
    }

    public void setJobApplication(ListInterface<JobApplication> jobApplication) {
        this.jobApplication = jobApplication;
    }

    public ListInterface<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(ListInterface<Schedule> schedule) {
        this.schedule = schedule;
    }
    
    public Employer getEmployer(){
        return employer;
    }

    public String getJobID() {
        return jobID;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getInterviewProcess() {
        return interviewProcess;
    }

    public void setInterviewProcess(String interviewProcess) {
        this.interviewProcess = interviewProcess;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getProbationPeriod() {
        return probationPeriod;
    }

    public void setProbationPeriod(String probationPeriod) {
        this.probationPeriod = probationPeriod;
    }

    public boolean isRelocationAssistance() {
        return relocationAssistance;
    }

    public void setRelocationAssistance(boolean relocationAssistance) {
        this.relocationAssistance = relocationAssistance;
    }

    public ListInterface<String> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(ListInterface<String> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public int getRequiredExperience() {
        return requiredExperience;
    }

    public void setRequiredExperience(int requiredExperience) {
        this.requiredExperience = requiredExperience;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public ListInterface<String> getBenefits() {
        return benefits;
    }

    public void setBenefits(ListInterface<String> benefits) {
        this.benefits = benefits;
    }

    public Date getApplicationDeadline() {
        return applicationDeadline;
    }

    public void setApplicationDeadline(Date applicationDeadline) {
        this.applicationDeadline = applicationDeadline;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public String getCareerDevelopment() {
        return careerDevelopment;
    }

    public void setCareerDevelopment(String careerDevelopment) {
        this.careerDevelopment = careerDevelopment;
    }

    @Override
    public String toString() {
        return "Job{" + "jobID=" + jobID + ", jobTitle=" + jobTitle + ", jobType=" + jobType + ", jobDescription=" + jobDescription + ", interviewProcess=" + interviewProcess + ", employmentType=" + employmentType + ", probationPeriod=" + probationPeriod + ", relocationAssistance=" + relocationAssistance + ", requiredSkills=" + requiredSkills + ", requiredExperience=" + requiredExperience + ", teamSize=" + teamSize + ", salary=" + salary + ", benefits=" + benefits + ", applicationDeadline=" + applicationDeadline + ", workHours=" + workHours + ", careerDevelopment=" + careerDevelopment + '}';
    }

    @Override
    public int compareTo(Job other) {
        return Double.compare(this.salary, other.salary);    
    }
    
}
