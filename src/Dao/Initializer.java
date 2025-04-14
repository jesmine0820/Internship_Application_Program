package Dao;

import ADT.DoublyLinkedList;
import ADT.ListInterface;
import Entity.*;
import Utility.Validation;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;


/**
 *
 * Author - JesmineTeyKhaiJing
 * 
 * Explanations:
 * 1. Hard Code for Initialize Data into system
 * 
 */

public class Initializer {
    
    public static void initialize() {
        initializeData();
    }

    private static void initializeData() {
        
        // Creating Companies
        Company techCompany = new Company("Tech Innovations", "Technology", 500, 2010,
                "Kuala Lumpur", "123 Tech Park", "Software Development, AI Solutions",
                "Innovative, Inclusive", "www.techinnovations.com", "Verified", new DoublyLinkedList<>());

        Company hrCompany = new Company("People First HR", "Human Resources", 200, 2015,
                "Selangor", "456 HR Towers", "Recruitment, Training, Payroll Management",
                "Diverse, Employee-Centric", "www.peoplefirsthr.com", "Verified", new DoublyLinkedList<>());

        Company financeCompany = new Company("Secure Finance", "Finance", 300, 2012,
                "Penang", "789 Financial Avenue", "Investment Banking, Wealth Management",
                "Trustworthy, Client-Focused", "www.securefinance.com", "Verified", new DoublyLinkedList<>());

        Company healthCompany = new Company("HealthPlus Medical", "Healthcare", 250, 2018,
                "Johor Bahru", "321 Wellness Street", "General Health, Specialist Services",
                "Caring, Patient-Centered", "www.healthplus.com", "Verified", new DoublyLinkedList<>());

        Company educationCompany = new Company("Future Academy", "Education", 150, 2016,
                "Melaka", "567 Learning Lane", "Higher Education, Online Learning",
                "Innovative, Knowledge-Driven", "www.futureacademy.com", "Verified", new DoublyLinkedList<>());

        // Creating Employers
        Employer alice = new Employer("E001", "Alice Tan",
                new GregorianCalendar(1985, Calendar.MAY, 15).getTime(), "Female", "123 Street, KL",
                "850515-14-1234", "012-3456789", "alice.tan@example.com", "@alice_tan", "Married",
                "Engineering", "Senior Engineer",
                new GregorianCalendar(2015, Calendar.MARCH, 20).getTime(), 10,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), techCompany);

        Employer bob = new Employer("E002", "Bob Lim",
                new GregorianCalendar(1990, Calendar.AUGUST, 10).getTime(), "Male", "45 Tech Park, KL",
                "900810-10-5678", "017-9876543", "bob.lim@example.com", "@boblim", "Single",
                "Software", "Software Developer",
                new GregorianCalendar(2018, Calendar.JULY, 5).getTime(), 6,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), techCompany);

        Employer carol = new Employer("E003", "Carol Wong",
                new GregorianCalendar(1982, Calendar.DECEMBER, 5).getTime(), "Female", "678 HR Towers, Selangor",
                "821205-08-2345", "016-1112233", "carol.wong@example.com", "@carol_hr", "Married",
                "Human Resources", "HR Manager",
                new GregorianCalendar(2016, Calendar.JUNE, 12).getTime(), 8,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), hrCompany);

        Employer david = new Employer("E004", "David Tan",
                new GregorianCalendar(1988, Calendar.JANUARY, 20).getTime(), "Male", "789 People Street, Selangor",
                "880120-05-6789", "018-4445566", "david.tan@example.com", "@davidtan", "Single",
                "Talent Acquisition", "Recruitment Specialist",
                new GregorianCalendar(2019, Calendar.SEPTEMBER, 25).getTime(), 5,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), hrCompany);

        Employer emily = new Employer("E005", "Emily Chan",
                new GregorianCalendar(1993, Calendar.MARCH, 3).getTime(), "Female", "432 Bank Road, Penang",
                "930303-07-5678", "014-7654321", "emily.chan@example.com", "@emilychan", "Single",
                "Investment", "Financial Analyst",
                new GregorianCalendar(2020, Calendar.NOVEMBER, 1).getTime(), 4,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), financeCompany);

        Employer frank = new Employer("E006", "Frank Lee",
                new GregorianCalendar(1985, Calendar.JULY, 29).getTime(), "Male", "987 Wealth Avenue, Penang",
                "850729-02-3456", "013-2223344", "frank.lee@example.com", "@franklee", "Married",
                "Banking", "Branch Manager",
                new GregorianCalendar(2013, Calendar.MAY, 18).getTime(), 11,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), financeCompany);

        Employer grace = new Employer("E007", "Grace Ng",
                new GregorianCalendar(1991, Calendar.OCTOBER, 17).getTime(), "Female", "222 Health Street, JB",
                "911017-06-7890", "019-3334455", "grace.ng@example.com", "@graceng", "Single",
                "General Medicine", "Medical Officer",
                new GregorianCalendar(2017, Calendar.DECEMBER, 9).getTime(), 7,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), healthCompany);

        Employer henry = new Employer("E008", "Henry Goh",
                new GregorianCalendar(1984, Calendar.APRIL, 21).getTime(), "Male", "567 Hospital Road, JB",
                "840421-11-2345", "015-5556677", "henry.goh@example.com", "@henrygoh", "Married",
                "Specialist", "Cardiologist",
                new GregorianCalendar(2010, Calendar.FEBRUARY, 14).getTime(), 14,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), healthCompany);

        Employer irene = new Employer("E009", "Irene Chua",
                new GregorianCalendar(1986, Calendar.SEPTEMBER, 9).getTime(), "Female", "888 Academy Road, Melaka",
                "860909-09-8765", "017-6667788", "irene.chua@example.com", "@irenechua", "Married",
                "Education", "Lecturer",
                new GregorianCalendar(2012, Calendar.JANUARY, 7).getTime(), 12,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), educationCompany);

        Employer jack = new Employer("E010", "Jack Yeo",
                new GregorianCalendar(1994, Calendar.FEBRUARY, 28).getTime(), "Male", "123 Learning Lane, Melaka",
                "940228-12-5432", "012-8889990", "jack.yeo@example.com", "@jackyeo", "Single",
                "Administration", "Academic Coordinator",
                new GregorianCalendar(2021, Calendar.MARCH, 15).getTime(), 3,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), educationCompany);
        
        //Creating Job
        Job job1 = new Job("J001", "Software Engineer", "Full-Time", "Develop and maintain software applications", 
            "Technical test, HR interview", "Permanent", "On-site","3 months", true, 
            getRandom("skill", 3), 3, 5, 5000.0, 
            getRandom("benefit",2), 
            new GregorianCalendar(2025, Calendar.JUNE, 30).getTime(), 40, "Growth opportunities available", 
            new DoublyLinkedList<>(), new DoublyLinkedList<>(), alice);

        Job job2 = new Job("J002", "HR Manager", "Full-Time", "Manage recruitment and employee relations", 
                "HR interview, case study", "Permanent", "On-site","6 months", false, 
                getRandom("skill", 4), 5, 8, 6000.0, 
                getRandom("benefit",2), 
                new GregorianCalendar(2025, Calendar.JULY, 15).getTime(), 45, "Career growth in HR leadership", 
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), bob);

        Job job3 = new Job("J003", "Financial Analyst", "Full-Time", "Analyze financial data and market trends", 
                "Aptitude test, panel interview", "Permanent", "Hybrid", "3 months", false, 
                getRandom("skill", 2), 4, 6, 7000.0, 
                getRandom("benefit",4), 
                new GregorianCalendar(2025, Calendar.AUGUST, 10).getTime(), 40, "Path to senior finance roles", 
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), carol);

        Job job4 = new Job("J004", "Marketing Director", "Full-Time", "Oversee marketing campaigns and strategy", 
                "Presentation, strategic discussion", "Permanent", "Remote","6 months", false, 
                getRandom("skill", 5), 7, 10, 9000.0, 
                getRandom("benefit",5), 
                new GregorianCalendar(2025, Calendar.SEPTEMBER, 5).getTime(), 50, "High-level executive role", 
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), david);

        Job job5 = new Job("J005", "Data Scientist", "Full-Time", "Develop machine learning models for business insights", 
                "Technical test, HR discussion", "Permanent", "Remote","3 months", true, 
                getRandom("skill", 3), 5, 6, 8000.0, 
                getRandom("benefit",2), 
                new GregorianCalendar(2025, Calendar.OCTOBER, 1).getTime(), 40, "Opportunities in AI and analytics", 
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), frank);

        Job job6 = new Job("J006", "UI/UX Designer", "Full-Time", "Design user interfaces and experiences", 
                "Portfolio review, design challenge", "Permanent", "On-site", "3 months", true, 
                getRandom("skill", 2), 3, 4, 5500.0, 
                getRandom("benefit",2), 
                new GregorianCalendar(2025, Calendar.NOVEMBER, 10).getTime(), 40, "Exciting design projects", 
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), grace);
        
        Job job7 = new Job("J007", "Cybersecurity Analyst", "Full-Time", "Monitor and secure IT infrastructure", 
                "Technical assessment, security scenario test", "Permanent", "On-site", "6 months", false, 
                getRandom("skill", 3), 4, 5, 6500.0, 
                getRandom("benefit",3), 
                new GregorianCalendar(2025, Calendar.DECEMBER, 15).getTime(), 42, "Opportunities in cyber defense", 
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), henry);

        Job job8 = new Job("J008", "Content Strategist", "Full-Time", "Develop and manage content marketing strategy", 
                "Portfolio review, creative writing test", "Permanent", "On-site", "3 months", false, 
                getRandom("skill", 2), 3, 4, 5000.0, 
                getRandom("benefit",2), 
                new GregorianCalendar(2025, Calendar.OCTOBER, 5).getTime(), 40, "Creative content leadership", 
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), henry);

        Job job9 = new Job("J009", "Mechanical Engineer", "Full-Time", "Design and develop mechanical systems", 
                "Technical interview, CAD test", "Permanent", "Remote","3 months", true, 
                getRandom("skill", 3), 5, 6, 7200.0, 
                getRandom("benefit",3), 
                new GregorianCalendar(2025, Calendar.SEPTEMBER, 20).getTime(), 45, "Growth in engineering projects", 
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), irene);

        Job job10 = new Job("J010", "Legal Consultant", "Full-Time", "Provide legal advice to corporate clients", 
                "Case study, legal consultation simulation", "Permanent", "Remote","6 months", false, 
                getRandom("skill", 3), 6, 3, 8500.0, 
                getRandom("benefit",4), 
                new GregorianCalendar(2025, Calendar.DECEMBER, 1).getTime(), 40, "Corporate legal leadership", 
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), jack);

        Job job11 = new Job("J011", "Operations Manager", "Full-Time", "Oversee and optimize business operations", 
                "Leadership assessment, case study", "Permanent", "On-site", "3 months", false, 
                getRandom("skill", 3), 7, 8, 9000.0, 
                getRandom("benefit",4), 
                new GregorianCalendar(2025, Calendar.NOVEMBER, 30).getTime(), 45, "Leadership in operations", 
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), carol);
        
        Job job12 = new Job("J012", "Pharmaceutical Researcher", "Full-Time", "Conduct research on new drug formulations", 
                "Technical interview, lab test", "Permanent", "Remote","6 months", false, 
                getRandom("skill", 3), 5, 5, 7500.0, 
                getRandom("benefit",3), 
                new GregorianCalendar(2025, Calendar.SEPTEMBER, 15).getTime(), 40, "Advanced research opportunities", 
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), alice);

        Job job13 = new Job("J013", "Customer Success Manager", "Full-Time", "Ensure customer satisfaction and retention", 
                "Behavioral interview, problem-solving test", "Permanent", "On-site", "3 months", false, 
                getRandom("skill", 2), 4, 6, 6000.0, 
                getRandom("benefit",3), 
                new GregorianCalendar(2025, Calendar.NOVEMBER, 20).getTime(), 40, "Opportunities in client management", 
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), bob);

        Job job14 = new Job("J014", "Game Developer", "Full-Time", "Design and develop game applications", 
                "Portfolio review, coding test", "Permanent", "On-site", "3 months", true, 
                getRandom("skill", 3), 4, 5, 7000.0, 
                getRandom("benefit",4), 
                new GregorianCalendar(2025, Calendar.DECEMBER, 10).getTime(), 42, "Growth in gaming industry", 
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), bob);

        Job job15 = new Job("J015", "AI Research Scientist", "Full-Time", "Develop and research artificial intelligence models", 
                "Machine learning test, research presentation", "Permanent", "Remote", "6 months", true, 
                getRandom("skill", 4), 6, 7, 9000.0, 
                getRandom("benefit", 5), 
                new GregorianCalendar(2025, Calendar.OCTOBER, 5).getTime(), 45, "Leading AI innovations", 
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), irene);

        //Create Resume
        Resume resume1 = new Resume("Bachelor's in Computer Science", 
            getRandom("skill", 5), 
            getRandom("experience", 3), 
            getRandom("certification", 2), 
            getRandom("project", 3), 
            getRandom("language", 3), 
            getRandom("award", 2));

        Resume resume2 = new Resume("Master's in Business Administration", 
            getRandom("skill", 4), 
            getRandom("experience", 3), 
            getRandom("certification", 3), 
            getRandom("project", 2), 
            getRandom("language", 4), 
            getRandom("award", 3));

        Resume resume3 = new Resume("Bachelor's in Data Science", 
            getRandom("skill", 6), 
            getRandom("experience", 4), 
            getRandom("certification", 2), 
            getRandom("project", 3), 
            getRandom("language", 2), 
            getRandom("award", 1));

        Resume resume4 = new Resume("Diploma in Graphic Design", 
            getRandom("skill", 4), 
            getRandom("experience", 3), 
            getRandom("certification", 2), 
            getRandom("project", 3), 
            getRandom("language", 3), 
            getRandom("award", 2));

        Resume resume5 = new Resume("Master's in Cybersecurity", 
            getRandom("skill", 6), 
            getRandom("experience", 4), 
            getRandom("certification", 3), 
            getRandom("project", 3), 
            getRandom("language", 2), 
            getRandom("award", 3));
        
        // Create Applicant
        Applicant applicant1 = new Applicant("Kuala Lumpur, Malaysia", "www.ahmaddevportfolio.com", "Hybrid", "Full-Time", 
                5, "RM70,000 - RM90,000", true, 
                "Available Immediately", resume1, new DoublyLinkedList<>(), 
                "A001", "Ahmad Razak", new GregorianCalendar(1990, Calendar.MAY, 15).getTime(), 
                "Male", "12 Jalan Ampang, Kuala Lumpur, Malaysia", "900515-14-5678", "+60 12-3456789", "ahmad@example.com", 
                "@ahmad_dev", "Married");

        Applicant applicant2 = new Applicant("Petaling Jaya, Malaysia", "www.liuxinuiux.com", "Remote", "Part-Time", 
                3, "RM50,000 - RM60,000", false,
                "Available in 1 Month", resume2, new DoublyLinkedList<>(), 
                "A002", "Liu Xin", new GregorianCalendar(1995, Calendar.FEBRUARY, 28).getTime(), 
                "Female", "18 Jalan SS2, Petaling Jaya, Malaysia", "950228-08-7654", "+60 16-7890123", "liuxin@example.com", 
                "@liuxin_uiux", "Single");

        Applicant applicant3 = new Applicant("George Town, Malaysia", "www.suryafinance.com", "On-Site", "Full-Time", 
                7, "RM80,000 - RM100,000", false, 
                "Available in 2 Weeks", resume3, new DoublyLinkedList<>(), 
                "A003", "Surya Krishnan", new GregorianCalendar(1987, Calendar.AUGUST, 10).getTime(), 
                "Male", "45 Lebuh Chulia, George Town, Malaysia", "870810-07-4321", "+60 19-8765432", "surya@example.com", 
                "@surya_finance", "Married");

        Applicant applicant4 = new Applicant("Johor Bahru, Malaysia", "www.ayeshadatascience.com", "Remote", "Contract", 
                4, "RM60,000 - RM75,000", true, 
                "Available in 3 Months", resume4, new DoublyLinkedList<>(), 
                "A004", "Ayesha Tan", new GregorianCalendar(1992, Calendar.DECEMBER, 5).getTime(), 
                "Female", "78 Jalan Tebrau, Johor Bahru, Malaysia", "921205-01-8765", "+60 17-6543210", "ayesha@example.com", 
                "@ayesha_data", "Single");

        Applicant applicant5 = new Applicant("Shah Alam, Malaysia", "www.danielmarketing.com", "Hybrid", "Full-Time", 
                6, "RM85,000 - RM95,000", false, 
                "Available Immediately", resume5, new DoublyLinkedList<>(), 
                "A005", "Daniel Nair", new GregorianCalendar(1988, Calendar.APRIL, 20).getTime(), 
                "Male", "23 Persiaran Raja Muda, Shah Alam, Malaysia", "880420-10-3456", "+60 13-5678901", "daniel@example.com", 
                "@daniel_marketing", "Married");

        JobApplication app1 = new JobApplication("A001", new GregorianCalendar(2025, Calendar.MARCH, 5).getTime(), "Pending",
                true, false, "Reviewed application", "Awaiting interview", applicant1, job1);

        JobApplication app2 = new JobApplication("A002", new GregorianCalendar(2025, Calendar.MARCH, 7).getTime(), "Shortlisted",
                true, true, "Good experience", "Interview scheduled", applicant2, job2);

        JobApplication app3 = new JobApplication("A003", new GregorianCalendar(2025, Calendar.MARCH, 10).getTime(), "Rejected",
                false, false, "Lacks required skills", "Not suitable for role", applicant3, job5);

        JobApplication app4 = new JobApplication("A004", new GregorianCalendar(2025, Calendar.MARCH, 12).getTime(), "Pending",
                true, false, "Resume is strong", "Awaiting response", applicant4, job4);

        JobApplication app5 = new JobApplication("A005", new GregorianCalendar(2025, Calendar.MARCH, 15).getTime(), "Shortlisted",
                false, true, "Great portfolio", "Interview in progress", applicant5, job5);

        JobApplication app6 = new JobApplication("A006", new GregorianCalendar(2025, Calendar.MARCH, 18).getTime(), "Pending",
                true, false, "Interesting background", "Awaiting further review", applicant2, job3);

        JobApplication app7 = new JobApplication("A007", new GregorianCalendar(2025, Calendar.MARCH, 20).getTime(), "Rejected",
                true, false, "Lacks experience", "Better suited for junior role", applicant3, job7);

        JobApplication app8 = new JobApplication("A008", new GregorianCalendar(2025, Calendar.MARCH, 22).getTime(), "Pending",
                false, false, "Did not submit resume", "Awaiting documents", applicant2, job3);

        JobApplication app9 = new JobApplication("A009", new GregorianCalendar(2025, Calendar.MARCH, 25).getTime(), "Shortlisted",
                true, true, "Excellent leadership skills", "Interview passed", applicant1, job9);

        JobApplication app10 = new JobApplication("A010", new GregorianCalendar(2025, Calendar.MARCH, 27).getTime(), "Shortlisted",
                true, true, "Strong legal background", "Final interview scheduled", applicant3, job4);

        // Create schedules
        Schedule s1 = new Schedule(Validation.checkDate("2025-04-11"), Validation.checkTime("10:00"), "Online", "Zoom",
                Validation.checkDate("2025-04-12"), Validation.checkTime("12:00"), "Completed", alice, applicant1);

        Schedule s2 = new Schedule(Validation.checkDate("2025-04-12"), Validation.checkTime("11:30"), "Offline", "Office",
                Validation.checkDate("2025-04-15"), Validation.checkTime("14:00"), "Completed", bob, applicant2);
        
        Schedule s3 = new Schedule(Validation.checkDate("2025-04-13"), Validation.checkTime("09:15"), "Online", "Zoom",
                Validation.checkDate("2025-04-14"), Validation.checkTime("10:30"), "Completed", carol, applicant3);
        
        Schedule s4 = new Schedule(Validation.checkDate("2025-04-14"), Validation.checkTime("13:45"), "Offline", "HQ",
                Validation.checkDate("2025-04-16"), Validation.checkTime("09:00"), "Scheduled", david, applicant4);
        
        Schedule s5 = new Schedule(Validation.checkDate("2025-04-15"), Validation.checkTime("16:20"), "Online", "Zoom",
                Validation.checkDate("2025-04-17"), Validation.checkTime("11:15"), "Completed", emily, applicant5);
        
        Schedule s6 = new Schedule(Validation.checkDate("2025-04-16"), Validation.checkTime("08:00"), "Offline", "Lab",
                Validation.checkDate("2025-04-18"), Validation.checkTime("13:30"), "Completed", frank, applicant1);
        
        Schedule s7 = new Schedule(Validation.checkDate("2025-04-17"), Validation.checkTime("14:10"), "Online", "Zoom",
                Validation.checkDate("2025-04-19"), Validation.checkTime("15:45"), "Completed", grace, applicant2);
        
        Schedule s8 = new Schedule(Validation.checkDate("2025-04-18"), Validation.checkTime("10:30"), "Offline", "Room 101",
                Validation.checkDate("2025-04-20"), Validation.checkTime("10:00"), "Scheduled", henry, applicant3);
        
        Schedule s9 = new Schedule(Validation.checkDate("2025-04-19"), Validation.checkTime("11:00"), "Online", "Zoom",
                Validation.checkDate("2025-04-21"), Validation.checkTime("16:20"), "Completed", irene, applicant4);
        
        Schedule s10 = new Schedule(Validation.checkDate("2025-04-20"), Validation.checkTime("09:45"), "Offline", "Floor 3",
                Validation.checkDate("2025-04-22"), Validation.checkTime("14:15"), "Completed", jack, applicant5);

        Schedule s11 = new Schedule(Validation.checkDate("2025-04-21"), Validation.checkTime("13:00"), "Online", "Zoom",
                Validation.checkDate("2025-04-23"), Validation.checkTime("09:30"), "Completed", alice, applicant2);
        
        Schedule s12 = new Schedule(Validation.checkDate("2025-04-22"), Validation.checkTime("15:30"), "Offline", "Annex",
                Validation.checkDate("2025-04-24"), Validation.checkTime("11:00"), "Scheduled", bob, applicant3);
        
        Schedule s13 = new Schedule(Validation.checkDate("2025-04-23"), Validation.checkTime("08:45"), "Online", "Zoom",
                Validation.checkDate("2025-04-25"), Validation.checkTime("14:45"), "Completed", carol, applicant4);
        
        Schedule s14 = new Schedule(Validation.checkDate("2025-04-24"), Validation.checkTime("12:15"), "Offline", "Room 202",
                Validation.checkDate("2025-04-26"), Validation.checkTime("10:15"), "Completed", david, applicant5);
        
        Schedule s15 = new Schedule(Validation.checkDate("2025-04-25"), Validation.checkTime("16:00"), "Online", "Zoom",
                Validation.checkDate("2025-04-27"), Validation.checkTime("13:00"), "Completed", emily, applicant1);
        
        Schedule s16 = new Schedule(Validation.checkDate("2025-04-26"), Validation.checkTime("09:30"), "Offline", "Main Office",
                Validation.checkDate("2025-04-28"), Validation.checkTime("16:30"), "Scheduled", frank, applicant2);
        
        Schedule s17 = new Schedule(Validation.checkDate("2025-04-27"), Validation.checkTime("14:00"), "Online", "Zoom",
                Validation.checkDate("2025-04-29"), Validation.checkTime("08:45"), "Completed", grace, applicant3);
        
        Schedule s18 = new Schedule(Validation.checkDate("2025-04-28"), Validation.checkTime("10:45"), "Offline", "Lab 2",
                Validation.checkDate("2025-04-30"), Validation.checkTime("12:45"), "Completed", henry, applicant4);
        
        Schedule s19 = new Schedule(Validation.checkDate("2025-04-29"), Validation.checkTime("11:30"), "Online", "Webex",
                Validation.checkDate("2025-05-01"), Validation.checkTime("15:00"), "Completed", irene, applicant5);
        
        Schedule s20 = new Schedule(Validation.checkDate("2025-04-30"), Validation.checkTime("08:15"), "Offline", "Room 303",
                Validation.checkDate("2025-05-02"), Validation.checkTime("09:30"), "Scheduled", jack, applicant1);
        
        // Add companies to DataStore
        Database.companies.add(techCompany);
        Database.companies.add(hrCompany);
        Database.companies.add(financeCompany);
        Database.companies.add(healthCompany);
        Database.companies.add(educationCompany);
        
        Database.applicants.add(applicant1);
        Database.applicants.add(applicant2);
        Database.applicants.add(applicant3);
        Database.applicants.add(applicant4);
        Database.applicants.add(applicant5);
        
        // Add schedules to DataStore
        Database.schedules.add(s1);
        Database.schedules.add(s2);
        Database.schedules.add(s3);
        Database.schedules.add(s4);
        Database.schedules.add(s5);
        Database.schedules.add(s6);
        Database.schedules.add(s7);
        Database.schedules.add(s8);
        Database.schedules.add(s9);
        Database.schedules.add(s10);
        Database.schedules.add(s11);
        Database.schedules.add(s12);
        Database.schedules.add(s13);
        Database.schedules.add(s14);
        Database.schedules.add(s15);
        Database.schedules.add(s16);
        Database.schedules.add(s17);
        Database.schedules.add(s18);
        Database.schedules.add(s19);
        Database.schedules.add(s20);

        // Add employers to DataStore and assign them to their respective companies
        addEmployerToCompany(techCompany, alice);
        addEmployerToCompany(techCompany, bob);
        addEmployerToCompany(hrCompany, carol);
        addEmployerToCompany(hrCompany, david);
        addEmployerToCompany(financeCompany, frank);
        addEmployerToCompany(financeCompany, grace);
        addEmployerToCompany(healthCompany, henry);
        addEmployerToCompany(educationCompany, irene);
        addEmployerToCompany(educationCompany, jack);
        
        addJobToEmployer(alice, job1);
        addJobToEmployer(bob, job2);
        addJobToEmployer(carol, job3);
        addJobToEmployer(david, job4);
        addJobToEmployer(frank, job5);
        addJobToEmployer(grace, job6);
        addJobToEmployer(henry, job7);
        addJobToEmployer(henry, job8);
        addJobToEmployer(irene, job9);
        addJobToEmployer(jack, job10);
        addJobToEmployer(carol, job11);
        addJobToEmployer(alice, job12);
        addJobToEmployer(bob, job13);
        addJobToEmployer(bob, job14);
        addJobToEmployer(alice, job15);
        
        addResumeToApplicant(applicant1, resume1);
        addResumeToApplicant(applicant2, resume2);
        addResumeToApplicant(applicant3, resume3);
        addResumeToApplicant(applicant4, resume4);
        addResumeToApplicant(applicant5, resume5);
        
        addJobApplicationToApplicant(applicant1, job1, app1);
        addJobApplicationToApplicant(applicant2, job2, app2);
        addJobApplicationToApplicant(applicant3, job5, app3);
        addJobApplicationToApplicant(applicant4, job4, app4);
        addJobApplicationToApplicant(applicant5, job4, app5);
        addJobApplicationToApplicant(applicant2, job3, app6);
        addJobApplicationToApplicant(applicant3, job7, app7);
        addJobApplicationToApplicant(applicant2, job4, app8);
        addJobApplicationToApplicant(applicant1, job9, app9);
        addJobApplicationToApplicant(applicant3, job4, app10);
        
        addScheduleToEmployer(s1);
        addScheduleToEmployer(s2);
        addScheduleToEmployer(s3);
        addScheduleToEmployer(s4);
        addScheduleToEmployer(s5);
        addScheduleToEmployer(s6);
        addScheduleToEmployer(s7);
        addScheduleToEmployer(s8);
        addScheduleToEmployer(s9);
        addScheduleToEmployer(s10);
        addScheduleToEmployer(s11);
        addScheduleToEmployer(s12);
        addScheduleToEmployer(s13);
        addScheduleToEmployer(s14);
        addScheduleToEmployer(s15);
        addScheduleToEmployer(s16);
        addScheduleToEmployer(s17);
        addScheduleToEmployer(s18);
        addScheduleToEmployer(s19);
        addScheduleToEmployer(s20);
    }

    private static void addEmployerToCompany(Company company, Employer employer) {
        company.getEmployer().add(employer); 
        Database.employers.add(employer); 
    }
    
    private static void addJobToEmployer(Employer employer, Job job){
        employer.getJob().add(job);
        Database.jobList.add(job);
    }
    
    private static void addResumeToApplicant(Applicant applicant, Resume resume){
        applicant.setResume(resume);
    }
    
    private static void addJobApplicationToApplicant(Applicant applicant, Job job, JobApplication jobApplication){
        job.getJobApplication().add(jobApplication);
        applicant.getJobApplication().add(jobApplication);
    }
    
    private static void addScheduleToEmployer(Schedule schedule){
        schedule.getEmployer().getSchedule().add(schedule);
    }
    
    private static ListInterface<String> getRandom(String title, int count) {
        String[] pool;

        String[] skillPool = {
            "Java", "Spring Boot", "SQL", "Python", "Machine Learning", "Data Analysis",
            "Cloud Computing", "Cybersecurity", "JavaScript", "React", "Angular",
            "Financial Modeling", "Accounting", "Risk Management", "Budgeting",
            "SEO", "Content Strategy", "Market Research", "Social Media Marketing",
            "Employee Relations", "HR Software", "Recruitment", "Compensation & Benefits",
            "Leadership", "Communication", "Problem Solving", "Project Management"
        };

        String[] benefitPool = {
            "Health Insurance", "Annual Bonus", "Remote Work", "Flexible Hours",
            "Gym Membership", "Stock Options", "Paid Time Off", "Tuition Reimbursement",
            "Retirement Plan", "Company Car", "Free Meals", "Wellness Programs",
            "Professional Development", "Childcare Support", "Travel Allowance"
        };
        
        String[] experiencePool = {
            "Software Developer at XYZ Tech (2 years)", 
            "Senior Software Engineer at ABC Solutions (5 years)", 
            "Marketing Executive at ABC Corp (3 years)", 
            "Data Analyst at FinTech Solutions (4 years)", 
            "Project Manager at Creative Design (5 years)", 
            "Cybersecurity Analyst at SecureNet (3 years)", 
            "Machine Learning Engineer at AI Innovations (4 years)", 
            "Graphic Designer at PixelArt Studio (3 years)", 
            "IT Consultant at CloudWave Technologies (5 years)", 
            "Digital Marketing Specialist at AdVision (3 years)"
        };

        String[] certificationPool = {
            "AWS Certified Solutions Architect", 
            "Google Data Analytics Certification", 
            "Certified Digital Marketing Professional", 
            "PMP (Project Management Professional)", 
            "CISSP (Certified Information Systems Security Professional)", 
            "Microsoft Azure Security Engineer", 
            "Certified Ethical Hacker (CEH)", 
            "Scrum Master Certification", 
            "Adobe Certified Expert (ACE)", 
            "Chartered Financial Analyst (CFA)"
        };

        String[] projectPool = {
            "Developed an AI-powered chatbot for customer support", 
            "Led a rebranding campaign for a major fashion brand", 
            "Created a financial risk assessment model", 
            "Designed a UI/UX prototype for a mobile app", 
            "Implemented a network security framework for an enterprise", 
            "Built an e-commerce recommendation system", 
            "Developed a real-time fraud detection system", 
            "Created a blockchain-based voting system", 
            "Redesigned a corporate website for better UX", 
            "Launched a successful digital ad campaign"
        };

        String[] awardPool = {
            "Best Employee of the Year 2022", 
            "Top Innovator Award 2021", 
            "Excellence in Leadership 2023", 
            "Outstanding Project Achievement 2020", 
            "Cybersecurity Defender of the Year 2024", 
            "Data Science Excellence Award 2022", 
            "UI/UX Design Award 2023", 
            "Most Valuable Marketer 2021", 
            "Financial Analyst of the Year 2020", 
            "Top Software Engineer Award 2023"
        };

        String[] languagePool = {
            "English", "Malay", "Mandarin", "Tamil", "Japanese", "Korean", "French", "German", "Spanish", "Arabic"
        };

        switch (title) {
            case "skill" -> pool = skillPool;
            case "benefit" -> pool = benefitPool;
            case "language" -> pool = languagePool;
            case "experience" -> pool = experiencePool;
            case "certification" -> pool = certificationPool;
            case "project" -> pool = projectPool;
            case "award" -> pool = awardPool;
            default -> {
                return new DoublyLinkedList<>();
            }
        }

        ListInterface<String> selected = new DoublyLinkedList<>();
        Random random = new Random();

        if (count > pool.length) {
            count = pool.length; 
        }

        while (selected.size() < count) {
            String randomItem = pool[random.nextInt(pool.length)];
            if (!selected.contains(randomItem)) {
                selected.add(randomItem);
            }
        }

        return selected;
    }

 
}
