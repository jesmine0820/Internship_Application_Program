package Control;

import ADT.DoublyLinkedList;
import ADT.ListInterface;
import Dao.Database;
import Entity.*;

/**
 * Author - JesmineTeyKhaiJing
 * 
 * Explanations:
 * 1. Sorting Algorithm
 * 
 */
public class MatchingEngine{
    
    public int getScore(Object obj1, Object obj2){
        return computeMatchingScore(obj1, obj2);
    }
    
    // Heat Sort for Top K ranking
    public <T extends Comparable<T>> ListInterface<T> heapSort(ListInterface<T> list, Object obj){
        int size = list.size();
        
        for(int i = size / 2 - 1; i >= 0; i--){
            heapify(list, size, i, obj);
        }
        
        for(int i = size - 1; i > 0; i--){
            list.swap(0, i);
            heapify(list, i, 0, obj);
        }
        
        return list;
        
    }
    
    // Helper function for Heap Sort
    private <T extends Comparable<T>> void heapify(ListInterface<T> list, int size, int i, Object obj){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if(left < size && compareList(list.get(left), list.get(largest), obj) > 0)
        {
            largest = left;
        }
        if(right < size && compareList(list.get(right), list.get(largest), obj) > 0){
            largest = right;
        }
        if(largest != i){
            list.swap(i, largest);
            heapify(list, size, largest, obj);
        }
    }
    
    // Compare Two items
    private <T> int compareList(Object obj1, Object obj2, Object main) {
        int score1 = 0;
        int score2 = 0;

        if (obj1 == null || obj2 == null || main == null) {
            return 0;
        }

        Job jobs = null;
        Applicant applicants = null;

        switch (main) {
            case Job job -> jobs = job;
            case Applicant applicant -> applicants = applicant;
            default -> {
            }
        }

        // Sorting logic based on the current user
        if (jobs != null) {         
            Job job1 = getInstance(obj1, Job.class);
            Job job2 = getInstance(obj2, Job.class);
            // Applicant: Sort jobs based on score
            score1 = computeMatchingScore(job1.getEmployer().getCompany(), Database.getApplicant());
            score2 = computeMatchingScore(job2.getEmployer().getCompany(), Database.getApplicant());
            
            // If scores are equal, sort by salary in descending order (higher salary first)
            if (score1 == score2) {
                return Integer.compare((int) job2.getSalary(), (int) job1.getSalary());
            }

        } else if (applicants != null) {
            Applicant applicant1 = getInstance(obj1, Applicant.class);
            Applicant applicant2 = getInstance(obj2, Applicant.class);
            // Employer: Sort applicants based on matching score
            score1 = computeMatchingScore(applicant1, Database.getEmployer());
            score2 = computeMatchingScore(applicant2, Database.getEmployer());
        }

        // Sort in descending order (higher score first)
        return Integer.compare(score2, score1);
    }

    
    // Compute Company and Job to Applicant and Resume
    // Compute Employer to Applicant
    private int computeMatchingScore(Object obj1, Object obj2){
        int score = 0;
        
        if(obj1 == null || obj2 == null){
            return score;
        }
        
        Company companies = null;
        Applicant applicants = null;
        
        if(obj2 instanceof Applicant){
            companies = getInstance(obj1, Company.class);
        } else if (obj2 instanceof Employer){
            applicants = getInstance(obj1, Applicant.class);
        }
        
        // Compute Compare and Job to Applicant
        if(companies != null){ 
            // Match Location
            int locationScore = computeScore(companies.getLocation(), companies.getLocation());
            score += locationScore;

            // Match industry type with desired job type
            int typeScore = computeScore(companies.getIndustryType(), Database.getApplicant().getDesiredJobType());
            score += typeScore;
            
            // Match experience and salary
            if (companies.getEmployer() != null) {
                for (Employer emp : companies.getEmployer()) {
                    if (emp.getJob() != null) {
                        for (Job job : emp.getJob()) {
                            int experienceScore = computeScore(job.getRequiredExperience(),Database.getApplicant().getYearOfExperience());
                            int salaryScore = computeScore(job.getSalary(), Database.getApplicant().getDesiredSalaryRange());
                            int skillScore = computeScore(job.getRequiredSkills(), Database.getApplicant().getResume().getSkills());
                            score += experienceScore;
                            score += salaryScore;
                            score += skillScore;
                        }
                    }
                }
            }

        } else if(Database.getEmployer() != null){ // Compute Employer and Applicant
            // Match industry type with desired job type
            int typeScore = computeScore(Database.getEmployer().getCompany().getIndustryType(), applicants.getDesiredJobType());
            score += typeScore;
            
            for(Job job: Database.getEmployer().getJob()){
                int experienceScore = computeScore(job.getRequiredExperience(), applicants.getYearOfExperience());
                int salaryScore = computeScore(job.getSalary(), applicants.getDesiredSalaryRange());
                int skillScore = computeScore(job.getRequiredSkills(), applicants.getResume().getSkills());
                score += experienceScore;
                score += salaryScore;
                score += skillScore;
            }
            
            int educationScore = computeScore(applicants.getResume().getEducationLevel());
            score += educationScore;
            
            int experienceScore = computeScore(applicants.getResume().getExperience());
            int certificationScore = computeScore(applicants.getResume().getCertifications());
            int projectsScore = computeScore(applicants.getResume().getProjects());
            int languageSpoken = computeScore(applicants.getResume().getLanguagesSpoken());
            int awards = computeScore(applicants.getResume().getAwards());
            
            score += experienceScore;
            score += certificationScore;
            score += projectsScore;
            score += languageSpoken;
            score += awards;
        } else { // Compute the Job application with applicant
            Applicant applicant = Database.getApplicant();
            
            for(JobApplication jobApplication: Database.getApplicant().getJobApplication()){
                Job job = jobApplication.getJob();
                String jobType = job.getEmployer().getCompany().getIndustryType();
                int typeScore = computeScore(jobType, applicant.getDesiredJobType());
                int experienceScore = computeScore(job.getRequiredExperience(), applicant.getYearOfExperience());
                int salaryScore = computeScore(job.getSalary(), applicant.getDesiredSalaryRange());
                int skillScore = computeScore(job.getRequiredSkills(), applicant.getResume().getSkills());
                score += typeScore;
                score += experienceScore;
                score += salaryScore;
                score += skillScore;
            }
            
            int educationScore = computeScore(applicant.getResume().getEducationLevel());
            int experienceScore = computeScore(applicant.getResume().getExperience());
            int certificationScore = computeScore(applicant.getResume().getCertifications());
            int projectsScore = computeScore(applicant.getResume().getProjects());
            int languageSpoken = computeScore(applicant.getResume().getLanguagesSpoken());
            int awards = computeScore(applicant.getResume().getAwards());
            
            score += educationScore;
            score += experienceScore;
            score += certificationScore;
            score += projectsScore;
            score += languageSpoken;
            score += awards;
        }

        return score;
    }
    
    // Computer score based on one string
    private int computeScore(String string){
        int score = 0;
        
        if(string == null || string.isEmpty()){
            return score;
        }
        
        if(string.equalsIgnoreCase("Diploma")){
            score += 10;
        } else if(string.equalsIgnoreCase("Degree")){
            score += 15;
        } else if(string.equalsIgnoreCase("Master")){
            score += 20;
        } else if(string.equalsIgnoreCase("PHD")){
            score += 30;
        } else {
            score += 3;
        }
        
        return score;
    }
    
    // Compute score between two string
    private int computeScore(String string1, String string2){
        int score = 0;
        
        if(string1.isEmpty() || string2.isEmpty()){
            return score;
        } else {
            if(string1.equalsIgnoreCase(string2)){
                score += 10;
            } else {
                ListInterface<String> searching = new DoublyLinkedList<>();
                int falseStep = 5;
                if(searching.fuzzyMatching(string1, string2) < falseStep){
                    score += 5;
                }
            }
        }
        return score;
    }
    
    // Compute score between two integer
    private int computeScore(int num1, int num2){
        int score = 0;
        
        if(num1 == 0 || num2 == 0){
            return score;
        } else {
            if(num1 <= num2){
                score += 10;
            } else {
                int diff = num1 - num2;
                if(diff < 3){
                    score += 5;
                }
            }
        }
        return score;
    }
    
    // Compute score between two double
    private int computeScore(double num, String string){
        int score = 0;
        
        if(string == null || string.isEmpty()){
            return score;
        }
        
        // Extract numeric values from salary range
        String[] parts = string.replace("RM", "").replace(",","").split(" - ");
        if (parts.length < 2){
            return score;
        }
        
        double minNum = Double.parseDouble(parts[0].trim());
        double maxNum = Double.parseDouble(parts[1].trim());
        
        if(num >= maxNum){
            score += 10;
        } else if(num >= minNum){
            score += 5;
        } else if(minNum - num <= 500){
            score += 5;
        }
        
        return score;
    }
    
    private int computeScore(ListInterface<String> list){
        int score = 0;
        
        if(list == null || list.isEmpty()){
            return score;
        }
        
        for(int i = 0; i < list.size(); i++){
            score += 5;
        }
        return score;
    }
    
    private int computeScore(ListInterface<String> list1, ListInterface<String> list2){
        int score = 0;
        
        if(list1 == null || list2 == null){
            return score;
        }
        
        for (String matchList: list1){
            for (String compareList: list2){    
                if(matchList.trim().equalsIgnoreCase(compareList.trim())){
                    score += 20;
                } else {
                    ListInterface<String> searching = new DoublyLinkedList<>();
                    int falseStep = 5;
                    if(searching.fuzzyMatching(matchList, compareList) < falseStep){
                        score += 5;
                    }
            
                }
            }
        }
        return score;
    }
    
    @SuppressWarnings("unchecked")
    private <T> T getInstance(Object obj, Class<T> clazz) {
        return obj != null && obj.getClass() == clazz ? (T) obj : null;
    }
    
}