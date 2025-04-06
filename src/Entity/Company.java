/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import ADT.DoublyLinkedList;
import ADT.ListInterface;

/**
 *
 * Author - KitChinJieYing
 * 
 * Explanations:
 * 1. 
 * 
 */
public class Company implements Comparable<Company>{

    private String companyName;
    private String industryType;
    private int employeeCount;
    private int foundedYear;
    private String location;
    private String address;
    private String coreServices;
    private String companyCulture;
    private String website;
    private String verifications;
    private ListInterface<Employer> employer = new DoublyLinkedList<>();
    
    public Company() {
        
    }
    
    public Company(String companyName, String industryType, int employeeCount, int foundedYear, String location, 
                   String address, String coreServices, String companyCulture, String website, String verifications, 
                   ListInterface<Employer> employer) {
        this.companyName = companyName;
        this.industryType = industryType;
        this.employeeCount = employeeCount;
        this.foundedYear = foundedYear;
        this.location = location;
        this.address = address;
        this.coreServices = coreServices;
        this.companyCulture = companyCulture;
        this.website = website;
        this.verifications = verifications;
        this.employer = employer;
    }
    
    public ListInterface<Employer> getEmployer() {
        return employer;
    }

    public void addEmployer(ListInterface<Employer> employer) {
        this.employer = employer;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public int getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(int foundedYear) {
        this.foundedYear = foundedYear;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoreServices() {
        return coreServices;
    }

    public void setCoreServices(String coreServices) {
        this.coreServices = coreServices;
    }

    public String getCompanyCulture() {
        return companyCulture;
    }

    public void setCompanyCulture(String companyCulture) {
        this.companyCulture = companyCulture;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getVerifications() {
        return verifications;
    }

    public void setVerifications(String verifications) {
        this.verifications = verifications;
    }

    @Override
    public String toString() {
        return "Company{" + "companyName=" + companyName + ", industryType=" + industryType + ", employeeCount=" + employeeCount + ", foundedYear=" + foundedYear + ", location=" + location + ", address=" + address + ", coreServices=" + coreServices + ", companyCulture=" + companyCulture + ", website=" + website + ", verifications=" + verifications + '}';
    }
    
    @Override
    public int compareTo(Company other) {
        return this.companyName.compareTo(other.companyName);
    }

}
