package Entity;

import ADT.ListInterface;

/**
 *
 * Author - GanKhaiLi
 * 
 * Explanations:
 * 1. 
 * 
 */

public class Resume implements Comparable<Resume>{

    private String educationLevel;
    private ListInterface<String> skills;
    private ListInterface<String> experience;
    private ListInterface<String> certifications;
    private ListInterface<String> projects;
    private ListInterface<String> languagesSpoken;
    private ListInterface<String> awards;

    public Resume() {
    }

    public Resume(String educationLevel, ListInterface<String> skills, ListInterface<String> experience, ListInterface<String> certifications, ListInterface<String> projects, ListInterface<String> languagesSpoken, ListInterface<String> awards) {
        this.educationLevel = educationLevel;
        this.skills = skills;
        this.experience = experience;
        this.certifications = certifications;
        this.projects = projects;
        this.languagesSpoken = languagesSpoken;
        this.awards = awards;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public ListInterface<String> getSkills() {
        return skills;
    }

    public void setSkills(ListInterface<String> skills) {
        this.skills = skills;
    }

    public ListInterface<String> getExperience() {
        return experience;
    }

    public void setExperience(ListInterface<String> experience) {
        this.experience = experience;
    }

    public ListInterface<String> getCertifications() {
        return certifications;
    }

    public void setCertifications(ListInterface<String> certifications) {
        this.certifications = certifications;
    }

    public ListInterface<String> getProjects() {
        return projects;
    }

    public void setProjects(ListInterface<String> projects) {
        this.projects = projects;
    }

    public ListInterface<String> getLanguagesSpoken() {
        return languagesSpoken;
    }

    public void setLanguagesSpoken(ListInterface<String> languagesSpoken) {
        this.languagesSpoken = languagesSpoken;
    }

    public ListInterface<String> getAwards() {
        return awards;
    }

    public void setAwards(ListInterface<String> awards) {
        this.awards = awards;
    }

    //need to change
    @Override
    public String toString() {
        return "Resume{" + "educationLevel=" + educationLevel + ", skills=" + skills + ", experience=" + experience + ", certifications=" + certifications + ", projects=" + projects + ", languagesSpoken=" + languagesSpoken + ", awards=" + awards + '}';
    }

    @Override
    public int compareTo(Resume other) {
        return this.getEducationLevel().compareTo(other.getEducationLevel());
    }

}
