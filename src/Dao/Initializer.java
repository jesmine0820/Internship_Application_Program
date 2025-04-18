package Dao;

import ADT.DoublyLinkedList;
import ADT.ListInterface;
import Entity.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 *
 * @author All
 *
 * Explanations: 1. Hard Code for Initialize Data into system
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

        Company cloudCompany = new Company("SkyNet Cloud Solutions", "Cloud Computing", 400, 2013,
                "Cyberjaya", "88 SkyHub Drive", "Cloud Infrastructure, DevOps",
                "Agile, Scalable", "www.skynetcloud.com", "Verified", new DoublyLinkedList<>());

        Company aiCompany = new Company("Neuron Labs", "Artificial Intelligence", 280, 2014,
                "Kuala Lumpur", "22 Innovation Road", "Machine Learning, Predictive Analytics",
                "Forward-Thinking, Research-Driven", "www.neuronlabs.ai", "Verified", new DoublyLinkedList<>());

        Company marketingCompany = new Company("ClickWise Digital", "Marketing", 180, 2017,
                "Petaling Jaya", "77 Creative Square", "SEO, Content Strategy, Digital Campaigns",
                "Creative, Data-Driven", "www.clickwise.com", "Verified", new DoublyLinkedList<>());

        Company cybersecurityCompany = new Company("ShieldNet Security", "Cybersecurity", 220, 2011,
                "Putrajaya", "901 Cyber Shield Center", "Network Security, Threat Detection",
                "Secure, Proactive", "www.shieldnetsecurity.com", "Verified", new DoublyLinkedList<>());

        Company fintechCompany = new Company("FinNova Tech", "Fintech", 350, 2015,
                "Penang", "999 FinTech Tower", "Mobile Banking, Financial Modeling",
                "Innovative, Transparent", "www.finnovatech.com", "Verified", new DoublyLinkedList<>());

        Company edtechCompany = new Company("BrightMind EdTech", "Education Technology", 170, 2018,
                "Shah Alam", "18 Knowledge Park", "Online Learning, Personalized Education",
                "Empowering, Adaptive", "www.brightmind.com", "Verified", new DoublyLinkedList<>());

        Company devCompany = new Company("CodeSmiths", "Software Development", 290, 2012,
                "Kuala Lumpur", "100 Developer Way", "Java, Spring Boot, React Projects",
                "Clean Code, Team-Oriented", "www.codesmiths.dev", "Verified", new DoublyLinkedList<>());

        Company analyticsCompany = new Company("Insightlytics", "Data Analytics", 260, 2016,
                "Penang", "55 Data Drive", "Data Visualization, Predictive Modeling",
                "Analytical, Curious", "www.insightlytics.com", "Verified", new DoublyLinkedList<>());

        Company hrTechCompany = new Company("Empower HR Tech", "HR Technology", 200, 2019,
                "Kota Kinabalu", "34 People Plaza", "HR Software, Employee Engagement",
                "Supportive, Tech-Enabled", "www.empowerhrtech.com", "Verified", new DoublyLinkedList<>());

        Company healthTechCompany = new Company("MediSync Digital", "HealthTech", 230, 2020,
                "Ipoh", "102 MedTech Avenue", "Telemedicine, Patient Portals",
                "Compassionate, Connected", "www.medisync.com", "Verified", new DoublyLinkedList<>());

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

        Employer jason = new Employer("E011", "Jason Lim",
                new GregorianCalendar(1992, Calendar.JULY, 25).getTime(), "Male", "100 Tech Hub, KL",
                "920725-03-4321", "012-6789012", "jason.lim@example.com", "@jasonlim", "Single",
                "Software", "Full Stack Developer",
                new GregorianCalendar(2020, Calendar.JUNE, 15).getTime(), 4,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), techCompany);

        Employer lily = new Employer("E012", "Lily Tan",
                new GregorianCalendar(1990, Calendar.AUGUST, 30).getTime(), "Female", "123 Software Street, KL",
                "900830-09-5678", "019-2345678", "lily.tan@example.com", "@lilytan", "Single",
                "Development", "Frontend Developer",
                new GregorianCalendar(2017, Calendar.FEBRUARY, 10).getTime(), 7,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), techCompany);

        Employer samuel = new Employer("E013", "Samuel Chia",
                new GregorianCalendar(1987, Calendar.MARCH, 18).getTime(), "Male", "456 Dev Center, KL",
                "870318-08-1234", "013-2345678", "samuel.chia@example.com", "@samuelchia", "Married",
                "Engineering", "DevOps Engineer",
                new GregorianCalendar(2016, Calendar.APRIL, 22).getTime(), 9,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), techCompany);

        Employer natalie = new Employer("E014", "Natalie Lim",
                new GregorianCalendar(1989, Calendar.NOVEMBER, 12).getTime(), "Female", "78 HR Plaza, Selangor",
                "891112-10-4321", "012-3456789", "natalie.lim@example.com", "@natalielim", "Single",
                "Human Resources", "HR Assistant",
                new GregorianCalendar(2018, Calendar.MAY, 18).getTime(), 5,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), hrCompany);

        Employer kevin = new Employer("E015", "Kevin Tan",
                new GregorianCalendar(1993, Calendar.FEBRUARY, 14).getTime(), "Male", "234 HR Towers, Selangor",
                "930214-04-1234", "016-5556677", "kevin.tan@example.com", "@kevintan", "Single",
                "Employee Relations", "HR Officer",
                new GregorianCalendar(2020, Calendar.AUGUST, 3).getTime(), 4,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), hrCompany);

        Employer sophia = new Employer("E016", "Sophia Goh",
                new GregorianCalendar(1984, Calendar.JUNE, 22).getTime(), "Female", "876 Talent Park, Selangor",
                "840622-02-2345", "018-6789012", "sophia.goh@example.com", "@sophiagoh", "Married",
                "Learning & Development", "L&D Specialist",
                new GregorianCalendar(2012, Calendar.SEPTEMBER, 10).getTime(), 13,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), hrCompany);

        Employer oliver = new Employer("E017", "Oliver Tan",
                new GregorianCalendar(1990, Calendar.MAY, 9).getTime(), "Male", "432 Financial Road, Penang",
                "900509-07-1234", "013-7890123", "oliver.tan@example.com", "@olivertan", "Single",
                "Accounting", "Accountant",
                new GregorianCalendar(2017, Calendar.JUNE, 5).getTime(), 7,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), financeCompany);

        Employer rachel = new Employer("E018", "Rachel Lim",
                new GregorianCalendar(1988, Calendar.SEPTEMBER, 15).getTime(), "Female", "123 Wealth Avenue, Penang",
                "880915-06-9876", "016-1112233", "rachel.lim@example.com", "@rachellim", "Married",
                "Investment", "Investment Analyst",
                new GregorianCalendar(2014, Calendar.NOVEMBER, 30).getTime(), 10,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), financeCompany);

        Employer vincent = new Employer("E019", "Vincent Lee",
                new GregorianCalendar(1982, Calendar.DECEMBER, 3).getTime(), "Male", "987 Bank Street, Penang",
                "821203-09-5678", "019-1234567", "vincent.lee@example.com", "@vincentlee", "Married",
                "Risk Management", "Risk Manager",
                new GregorianCalendar(2011, Calendar.AUGUST, 15).getTime(), 14,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), financeCompany);

        Employer weiLing = new Employer("E020", "Wei Ling Tan",
                new GregorianCalendar(1991, Calendar.JANUARY, 12).getTime(), "Female", "789 Wellness Lane, JB",
                "910112-05-7890", "012-5678901", "weiling.tan@example.com", "@weilingtan", "Single",
                "Nursing", "Senior Nurse",
                new GregorianCalendar(2016, Calendar.JULY, 1).getTime(), 8,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), healthCompany);

        Employer ahmad = new Employer("E021", "Ahmad Zaki",
                new GregorianCalendar(1987, Calendar.MARCH, 8).getTime(), "Male", "56 Medical Park, JB",
                "870308-01-2345", "017-2345678", "ahmad.zaki@example.com", "@ahmadzaki", "Married",
                "Surgery", "Orthopedic Surgeon",
                new GregorianCalendar(2012, Calendar.MARCH, 10).getTime(), 12,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), healthCompany);

        Employer amira = new Employer("E022", "Amira Ismail",
                new GregorianCalendar(1995, Calendar.OCTOBER, 2).getTime(), "Female", "101 Clinic Street, JB",
                "951002-10-6789", "018-3456789", "amira.ismail@example.com", "@amirahealth", "Single",
                "Pediatrics", "Pediatrician",
                new GregorianCalendar(2020, Calendar.JANUARY, 5).getTime(), 4,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), healthCompany);

        Employer zafran = new Employer("E023", "Zafran Halim",
                new GregorianCalendar(1994, Calendar.APRIL, 3).getTime(), "Male", "AI & Analytics Hub, KL",
                "940403-09-2233", "016-7788990", "zafran.halim@example.com", "@zafhalim", "Single",
                "Predictive Analytics", "Machine Learning Analyst",
                new GregorianCalendar(2021, Calendar.SEPTEMBER, 1).getTime(), 3,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), analyticsCompany);

        Employer farah = new Employer("E024", "Farah Aziz",
                new GregorianCalendar(1992, Calendar.APRIL, 18).getTime(), "Female", "22 Academy Lane, Melaka",
                "920418-06-9876", "013-8765432", "farah.aziz@example.com", "@farahaziz", "Single",
                "Mathematics", "Math Lecturer",
                new GregorianCalendar(2017, Calendar.JULY, 10).getTime(), 7,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), educationCompany);

        Employer zhiHao = new Employer("E025", "Zhi Hao Lee",
                new GregorianCalendar(1989, Calendar.FEBRUARY, 1).getTime(), "Male", "44 Learning Rd, Melaka",
                "890201-02-1234", "015-3334445", "zhihao.lee@example.com", "@lee_zhihao", "Married",
                "Computer Science", "IT Instructor",
                new GregorianCalendar(2016, Calendar.AUGUST, 8).getTime(), 8,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), educationCompany);

        Employer nadia = new Employer("E026", "Nadia Rahman",
                new GregorianCalendar(1993, Calendar.JUNE, 6).getTime(), "Female", "76 Edu Street, Melaka",
                "930606-08-3456", "016-5558887", "nadia.rahman@example.com", "@nadiarahman", "Single",
                "Student Affairs", "Counselor",
                new GregorianCalendar(2021, Calendar.FEBRUARY, 1).getTime(), 3,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), educationCompany);

        Employer faiz = new Employer("E027", "Faiz Rahim",
                new GregorianCalendar(1986, Calendar.MAY, 20).getTime(), "Male", "999 Cloud Blvd, Cyberjaya",
                "860520-04-2345", "019-9998887", "faiz.rahim@example.com", "@faizcloud", "Married",
                "Infrastructure", "Cloud Architect",
                new GregorianCalendar(2015, Calendar.MARCH, 5).getTime(), 9,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), cloudCompany);

        Employer meera = new Employer("E028", "Meera Nair",
                new GregorianCalendar(1990, Calendar.SEPTEMBER, 15).getTime(), "Female", "12 DevOps Road, Cyberjaya",
                "900915-07-6789", "014-3332221", "meera.nair@example.com", "@meeranair", "Single",
                "DevOps", "Site Reliability Engineer",
                new GregorianCalendar(2018, Calendar.JUNE, 20).getTime(), 6,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), cloudCompany);

        Employer arif = new Employer("E029", "Arif Yusof",
                new GregorianCalendar(1988, Calendar.DECEMBER, 30).getTime(), "Male", "808 Cloud Center, Cyberjaya",
                "881230-05-1122", "012-5566778", "arif.yusof@example.com", "@arifyusof", "Married",
                "Engineering", "Cloud Support Engineer",
                new GregorianCalendar(2014, Calendar.OCTOBER, 15).getTime(), 10,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), cloudCompany);

        Employer joanna = new Employer("E030", "Joanna Ng",
                new GregorianCalendar(1995, Calendar.APRIL, 3).getTime(), "Female", "102 SkyNet Plaza, Cyberjaya",
                "950403-08-4455", "017-3344556", "joanna.ng@example.com", "@joannang", "Single",
                "Software", "Cloud Application Engineer",
                new GregorianCalendar(2021, Calendar.DECEMBER, 1).getTime(), 3,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), cloudCompany);

        Employer irfan = new Employer("E031", "Irfan Hafiz",
                new GregorianCalendar(1992, Calendar.NOVEMBER, 10).getTime(), "Male", "67 Infra Park, Cyberjaya",
                "921110-12-7890", "018-2223344", "irfan.hafiz@example.com", "@irfanhafiz", "Single",
                "IT Operations", "Cloud Systems Analyst",
                new GregorianCalendar(2019, Calendar.SEPTEMBER, 9).getTime(), 5,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), cloudCompany);

        Employer teh = new Employer("E032", "Jason Teh",
                new GregorianCalendar(1991, Calendar.AUGUST, 19).getTime(), "Male", "88 Innovation Hub, KL",
                "910819-08-1234", "016-4433221", "jason.teh@example.com", "@jasont", "Single",
                "AI Development", "Machine Learning Engineer",
                new GregorianCalendar(2018, Calendar.JANUARY, 10).getTime(), 6,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), aiCompany);

        Employer shalini = new Employer("E033", "Shalini Kumar",
                new GregorianCalendar(1987, Calendar.MARCH, 22).getTime(), "Female", "123 Neural Street, KL",
                "870322-05-6789", "014-2233445", "shalini.k@example.com", "@shalinikumar", "Married",
                "AI Research", "AI Research Scientist",
                new GregorianCalendar(2015, Calendar.MARCH, 12).getTime(), 9,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), aiCompany);

        Employer leon = new Employer("E034", "Leon Chua",
                new GregorianCalendar(1993, Calendar.MAY, 30).getTime(), "Male", "66 Deep Learning Lane, KL",
                "930530-06-1122", "017-3344556", "leon.chua@example.com", "@leonchua", "Single",
                "NLP", "NLP Engineer",
                new GregorianCalendar(2021, Calendar.AUGUST, 5).getTime(), 3,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), aiCompany);

        Employer hazirah = new Employer("E035", "Hazirah Mohd",
                new GregorianCalendar(1990, Calendar.JULY, 11).getTime(), "Female", "22 AI Park, KL",
                "900711-10-3344", "018-9988776", "hazirah.mohd@example.com", "@hazirahai", "Single",
                "Computer Vision", "Computer Vision Specialist",
                new GregorianCalendar(2017, Calendar.MAY, 7).getTime(), 7,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), aiCompany);

        Employer kelvin = new Employer("E036", "Kelvin Ong",
                new GregorianCalendar(1985, Calendar.NOVEMBER, 4).getTime(), "Male", "18 Algorithm Ave, KL",
                "851104-12-7788", "012-3344556", "kelvin.ong@example.com", "@kelvinong", "Married",
                "AI Product", "AI Product Manager",
                new GregorianCalendar(2013, Calendar.DECEMBER, 2).getTime(), 11,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), aiCompany);

        Employer linda = new Employer("E037", "Linda Chew",
                new GregorianCalendar(1992, Calendar.SEPTEMBER, 25).getTime(), "Female", "22 Campaign Street, Selangor",
                "920925-11-2345", "014-6667788", "linda.chew@example.com", "@lindachew", "Single",
                "Marketing", "Digital Marketing Executive",
                new GregorianCalendar(2019, Calendar.MARCH, 1).getTime(), 5,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), marketingCompany);

        Employer ryan = new Employer("E038", "Ryan Foo",
                new GregorianCalendar(1988, Calendar.DECEMBER, 18).getTime(), "Male", "101 Brand Avenue, Selangor",
                "881218-09-3456", "013-8899001", "ryan.foo@example.com", "@ryanfoo", "Married",
                "Strategy", "Marketing Strategist",
                new GregorianCalendar(2014, Calendar.APRIL, 12).getTime(), 10,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), marketingCompany);

        Employer tracy = new Employer("E039", "Tracy Goh",
                new GregorianCalendar(1996, Calendar.FEBRUARY, 2).getTime(), "Female", "76 Content Blvd, Selangor",
                "960202-03-6789", "012-5566778", "tracy.goh@example.com", "@tracygoh", "Single",
                "Content", "Content Strategist",
                new GregorianCalendar(2020, Calendar.JUNE, 20).getTime(), 4,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), marketingCompany);

        Employer jamal = new Employer("E040", "Jamal Hafiz",
                new GregorianCalendar(1984, Calendar.OCTOBER, 9).getTime(), "Male", "11 SEO Street, Selangor",
                "841009-08-1234", "018-2233445", "jamal.hafiz@example.com", "@jamalhafiz", "Married",
                "SEO", "SEO Manager",
                new GregorianCalendar(2011, Calendar.MARCH, 15).getTime(), 13,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), marketingCompany);

        Employer cindy = new Employer("E041", "Cindy Lau",
                new GregorianCalendar(1991, Calendar.JUNE, 14).getTime(), "Female", "55 Brand Blvd, Selangor",
                "910614-10-5678", "015-6677889", "cindy.lau@example.com", "@cindylau", "Single",
                "Social Media", "Social Media Manager",
                new GregorianCalendar(2016, Calendar.AUGUST, 8).getTime(), 8,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), marketingCompany);

        Employer yap = new Employer("E042", "Kevin Yap",
                new GregorianCalendar(1989, Calendar.NOVEMBER, 11).getTime(), "Male", "Cyber Lane, Cyberjaya",
                "891111-04-1234", "019-1122334", "kevin.yap@example.com", "@kevinyap", "Single",
                "Security", "Cybersecurity Analyst",
                new GregorianCalendar(2016, Calendar.OCTOBER, 1).getTime(), 8,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), cybersecurityCompany);

        Employer sarah = new Employer("E043", "Sarah Ng",
                new GregorianCalendar(1993, Calendar.APRIL, 29).getTime(), "Female", "Security Park, Cyberjaya",
                "930429-06-5566", "017-4455667", "sarah.ng@example.com", "@sarahng", "Single",
                "IT Risk", "Risk Analyst",
                new GregorianCalendar(2020, Calendar.APRIL, 1).getTime(), 4,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), cybersecurityCompany);

        Employer haikal = new Employer("E044", "Haikal Azman",
                new GregorianCalendar(1987, Calendar.MAY, 7).getTime(), "Male", "45 Firewall Street, Cyberjaya",
                "870507-09-4321", "013-3344556", "haikal.azman@example.com", "@haikalazman", "Married",
                "Network Security", "Security Engineer",
                new GregorianCalendar(2013, Calendar.AUGUST, 15).getTime(), 11,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), cybersecurityCompany);

        Employer vivian = new Employer("E045", "Vivian Leong",
                new GregorianCalendar(1992, Calendar.MARCH, 3).getTime(), "Female", "88 Secure Ave, Cyberjaya",
                "920303-02-7890", "014-7788990", "vivian.leong@example.com", "@vivianleong", "Single",
                "Governance", "IT Governance Officer",
                new GregorianCalendar(2017, Calendar.JUNE, 10).getTime(), 7,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), cybersecurityCompany);

        Employer danish = new Employer("E046", "Danish Rahim",
                new GregorianCalendar(1990, Calendar.JULY, 27).getTime(), "Male", "76 CyberTech Lane, Cyberjaya",
                "900727-10-9988", "012-3344556", "danish.rahim@example.com", "@danishrahim", "Married",
                "Penetration Testing", "Ethical Hacker",
                new GregorianCalendar(2015, Calendar.DECEMBER, 1).getTime(), 9,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), cybersecurityCompany);

        Employer shafiq = new Employer("E047", "Shafiq Iskandar",
                new GregorianCalendar(1988, Calendar.JUNE, 6).getTime(), "Male", "FinTech Tower, KL",
                "880606-04-5678", "016-7788990", "shafiq.iskandar@example.com", "@shafiqfin", "Married",
                "Payments", "Fintech Product Manager",
                new GregorianCalendar(2015, Calendar.MARCH, 18).getTime(), 9,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), fintechCompany);

        Employer elaine = new Employer("E048", "Elaine Choo",
                new GregorianCalendar(1995, Calendar.AUGUST, 23).getTime(), "Female", "Digital Finance Street, KL",
                "950823-08-9988", "013-5566778", "elaine.choo@example.com", "@elainechoo", "Single",
                "Mobile Banking", "UI/UX Designer",
                new GregorianCalendar(2021, Calendar.JANUARY, 5).getTime(), 3,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), fintechCompany);

        Employer nash = new Employer("E049", "Nash Ariffin",
                new GregorianCalendar(1986, Calendar.SEPTEMBER, 14).getTime(), "Male", "99 Crypto Avenue, KL",
                "860914-11-3344", "017-1234567", "nash.ariffin@example.com", "@nashcrypto", "Married",
                "Blockchain", "Blockchain Developer",
                new GregorianCalendar(2016, Calendar.SEPTEMBER, 9).getTime(), 8,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), fintechCompany);

        Employer beatrice = new Employer("E050", "Beatrice Law",
                new GregorianCalendar(1991, Calendar.DECEMBER, 10).getTime(), "Female", "89 Wallet Drive, KL",
                "911210-09-2233", "014-3344556", "beatrice.law@example.com", "@beatricefin", "Single",
                "Analytics", "Financial Data Analyst",
                new GregorianCalendar(2018, Calendar.MAY, 1).getTime(), 6,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), fintechCompany);

        Employer hafeez = new Employer("E051", "Hafeez Ramli",
                new GregorianCalendar(1993, Calendar.JANUARY, 9).getTime(), "Male", "FinPark 101, KL",
                "930109-05-1111", "018-7788991", "hafeez.ramli@example.com", "@hafeezramli", "Single",
                "Credit Risk", "Risk Analyst",
                new GregorianCalendar(2020, Calendar.JULY, 7).getTime(), 4,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), fintechCompany);

        Employer aaron = new Employer("E052", "Aaron Lim",
                new GregorianCalendar(1990, Calendar.MARCH, 12).getTime(), "Male", "EdTech Towers, KL",
                "900312-08-1234", "012-3334455", "aaron.lim@example.com", "@aaronlim", "Single",
                "E-Learning", "Course Designer",
                new GregorianCalendar(2017, Calendar.APRIL, 10).getTime(), 7,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), edtechCompany);

        Employer jenny = new Employer("E053", "Jenny Tan",
                new GregorianCalendar(1987, Calendar.JUNE, 21).getTime(), "Female", "88 Virtual Campus, Selangor",
                "870621-05-5678", "014-2233445", "jenny.tan@example.com", "@jennytan", "Married",
                "Instructional Design", "Instructional Designer",
                new GregorianCalendar(2014, Calendar.SEPTEMBER, 1).getTime(), 10,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), edtechCompany);

        Employer syafiq = new Employer("E054", "Syafiq Ahmad",
                new GregorianCalendar(1993, Calendar.JANUARY, 7).getTime(), "Male", "Digital Academy, Penang",
                "930107-10-4455", "017-5566778", "syafiq.ahmad@example.com", "@syafiqedu", "Single",
                "Content Development", "Educational Content Creator",
                new GregorianCalendar(2020, Calendar.NOVEMBER, 20).getTime(), 4,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), edtechCompany);

        Employer michelle = new Employer("E055", "Michelle Chong",
                new GregorianCalendar(1991, Calendar.FEBRUARY, 14).getTime(), "Female", "Learning Street, JB",
                "910214-06-8899", "018-8899001", "michelle.chong@example.com", "@mchong", "Married",
                "Curriculum", "Curriculum Developer",
                new GregorianCalendar(2016, Calendar.JUNE, 5).getTime(), 8,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), edtechCompany);

        Employer darren = new Employer("E056", "Darren Yap",
                new GregorianCalendar(1985, Calendar.APRIL, 30).getTime(), "Male", "Online Edu HQ, KL",
                "850430-11-3344", "016-4455667", "darren.yap@example.com", "@darrenyap", "Married",
                "Tech Support", "LMS Administrator",
                new GregorianCalendar(2012, Calendar.JANUARY, 12).getTime(), 12,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), edtechCompany);

        Employer azmi = new Employer("E057", "Nadia Azmi",
                new GregorianCalendar(1992, Calendar.MAY, 8).getTime(), "Female", "CodeBase HQ, Selangor",
                "920508-09-1234", "013-9988776", "nadia.azmi@example.com", "@nadiazmi", "Single",
                "Frontend", "Frontend Developer",
                new GregorianCalendar(2019, Calendar.JULY, 1).getTime(), 5,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), devCompany);

        Employer sean = new Employer("E058", "Sean Ng",
                new GregorianCalendar(1990, Calendar.SEPTEMBER, 18).getTime(), "Male", "Developers Lane, KL",
                "900918-07-3344", "015-7788990", "sean.ng@example.com", "@seanng", "Married",
                "Backend", "Backend Developer",
                new GregorianCalendar(2016, Calendar.MAY, 20).getTime(), 8,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), devCompany);

        Employer shah = new Employer("E059", "Amira Shah",
                new GregorianCalendar(1995, Calendar.NOVEMBER, 26).getTime(), "Female", "DevTech Street, Penang",
                "951126-04-5566", "017-3344556", "amira.shah@example.com", "@amirashah", "Single",
                "QA", "QA Engineer",
                new GregorianCalendar(2021, Calendar.DECEMBER, 10).getTime(), 3,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), devCompany);

        Employer khoo = new Employer("E060", "Daniel Khoo",
                new GregorianCalendar(1988, Calendar.MARCH, 15).getTime(), "Male", "88 Code Block, KL",
                "880315-03-7788", "012-6677889", "daniel.khoo@example.com", "@danieldev", "Married",
                "Full Stack", "Full Stack Developer",
                new GregorianCalendar(2015, Calendar.FEBRUARY, 2).getTime(), 9,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), devCompany);

        Employer siti = new Employer("E061", "Siti Rohani",
                new GregorianCalendar(1986, Calendar.JUNE, 10).getTime(), "Female", "Developer's Park, Johor",
                "860610-06-1122", "014-7788990", "siti.rohani@example.com", "@sitirohani", "Married",
                "DevOps", "DevOps Engineer",
                new GregorianCalendar(2013, Calendar.AUGUST, 18).getTime(), 11,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), devCompany);

        Employer abdullah = new Employer("E062", "Faiz Abdullah",
                new GregorianCalendar(1989, Calendar.APRIL, 17).getTime(), "Male", "HRTech Towers, KL",
                "890417-08-3344", "017-4455667", "faiz.abdullah@example.com", "@faizhr", "Single",
                "HR Systems", "HRIS Analyst",
                new GregorianCalendar(2016, Calendar.OCTOBER, 10).getTime(), 8,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), hrTechCompany);

        Employer goh = new Employer("E063", "Alina Goh",
                new GregorianCalendar(1991, Calendar.JULY, 5).getTime(), "Female", "Smart HR Hub, Selangor",
                "910705-11-7788", "015-9988776", "alina.goh@example.com", "@alinagoh", "Single",
                "Payroll", "Payroll Specialist",
                new GregorianCalendar(2019, Calendar.MARCH, 3).getTime(), 5,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), hrTechCompany);

        Employer hafizah = new Employer("E064", "Hafizah Ismail",
                new GregorianCalendar(1985, Calendar.AUGUST, 9).getTime(), "Female", "Digital HR Lane, KL",
                "850809-09-1122", "012-3344556", "hafizah.ismail@example.com", "@hafizahtech", "Married",
                "Recruitment", "Talent Tech Consultant",
                new GregorianCalendar(2012, Calendar.DECEMBER, 1).getTime(), 12,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), hrTechCompany);

        Employer leonard = new Employer("E065", "Leonard Chew",
                new GregorianCalendar(1994, Calendar.MAY, 22).getTime(), "Male", "HR Analytics Hub, KL",
                "940522-03-5566", "018-6677889", "leonard.chew@example.com", "@leonardchew", "Single",
                "Analytics", "People Analytics Specialist",
                new GregorianCalendar(2021, Calendar.MAY, 15).getTime(), 3,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), hrTechCompany);

        Employer nurul = new Employer("E066", "Nurul Izzah",
                new GregorianCalendar(1990, Calendar.JANUARY, 30).getTime(), "Female", "HR Platform HQ, Penang",
                "900130-06-4455", "013-7788991", "nurul.izzah@example.com", "@nurulizzah", "Married",
                "HR Integration", "HR Tech Specialist",
                new GregorianCalendar(2015, Calendar.JUNE, 25).getTime(), 9,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), hrTechCompany);

        Employer anand = new Employer("E067", "Anand Raj",
                new GregorianCalendar(1986, Calendar.FEBRUARY, 11).getTime(), "Male", "MediTech HQ, JB",
                "860211-08-2233", "014-1122334", "anand.raj@example.com", "@anandraj", "Married",
                "Telemedicine", "Telehealth Consultant",
                new GregorianCalendar(2014, Calendar.NOVEMBER, 1).getTime(), 10,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), healthTechCompany);

        Employer elly = new Employer("E068", "Elly Chong",
                new GregorianCalendar(1992, Calendar.OCTOBER, 6).getTime(), "Female", "88 Digital Health Ave, KL",
                "921006-07-7788", "016-4455667", "elly.chong@example.com", "@ellymed", "Single",
                "Healthcare IT", "Health Data Analyst",
                new GregorianCalendar(2018, Calendar.JULY, 18).getTime(), 6,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), healthTechCompany);

        Employer roslan = new Employer("E069", "Roslan Osman",
                new GregorianCalendar(1983, Calendar.JUNE, 2).getTime(), "Male", "HealthTech Towers, KL",
                "830602-05-3344", "012-9988776", "roslan.osman@example.com", "@roslanosman", "Married",
                "EHR", "Electronic Health Record Specialist",
                new GregorianCalendar(2010, Calendar.MAY, 2).getTime(), 14,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), healthTechCompany);

        Employer sheila = new Employer("E070", "Sheila Tan",
                new GregorianCalendar(1989, Calendar.DECEMBER, 17).getTime(), "Female", "Connected Care Blvd, Penang",
                "891217-10-5566", "018-5566778", "sheila.tan@example.com", "@sheilatan", "Single",
                "Mobile Health", "mHealth App Developer",
                new GregorianCalendar(2016, Calendar.JANUARY, 25).getTime(), 8,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), healthTechCompany);

        Employer fauzi = new Employer("E071", "Haziq Fauzi",
                new GregorianCalendar(1995, Calendar.AUGUST, 29).getTime(), "Male", "Digital Clinic HQ, JB",
                "950829-06-1122", "015-6677889", "haziq.fauzi@example.com", "@haziqf", "Single",
                "MedTech", "Medical Tech Support Specialist",
                new GregorianCalendar(2020, Calendar.APRIL, 14).getTime(), 4,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), healthTechCompany);

        Employer liew = new Employer("E072", "Kevin Liew",
                new GregorianCalendar(1988, Calendar.JANUARY, 10).getTime(), "Male", "Data Tower, KL",
                "880110-08-3344", "012-3344556", "kevin.liew@example.com", "@kevinliew", "Married",
                "Data Science", "Data Scientist",
                new GregorianCalendar(2016, Calendar.MARCH, 5).getTime(), 8,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), analyticsCompany);

        Employer tasha = new Employer("E073", "Natasha Kaur",
                new GregorianCalendar(1993, Calendar.SEPTEMBER, 2).getTime(), "Female", "Insight HQ, Selangor",
                "930902-05-7788", "017-5566778", "natasha.kaur@example.com", "@tashak", "Single",
                "Analytics", "Business Analyst",
                new GregorianCalendar(2020, Calendar.JANUARY, 15).getTime(), 4,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), analyticsCompany);

        Employer ivan = new Employer("E074", "Ivan Teh",
                new GregorianCalendar(1985, Calendar.DECEMBER, 25).getTime(), "Male", "Big Data Boulevard, Penang",
                "851225-03-9988", "013-8899001", "ivan.teh@example.com", "@ivanteh", "Married",
                "Big Data", "Big Data Engineer",
                new GregorianCalendar(2013, Calendar.JUNE, 18).getTime(), 11,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), analyticsCompany);

        Employer mei = new Employer("E075", "Mei Ying",
                new GregorianCalendar(1991, Calendar.JULY, 12).getTime(), "Female", "Analytics Park, Johor",
                "910712-11-4455", "015-6677889", "mei.ying@example.com", "@meiying", "Single",
                "Market Research", "Market Intelligence Analyst",
                new GregorianCalendar(2017, Calendar.AUGUST, 10).getTime(), 7,
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), analyticsCompany);

        //Creating Job
        Job job1 = new Job("J001", "Software Engineer", "Full-Time", "Develop and maintain software applications",
                "Technical test, HR interview", "Permanent", "On-site", "3 months", true,
                getRandom("skill", 3), 3, 5, 5000.0,
                getRandom("benefit", 2),
                new GregorianCalendar(2024, Calendar.JANUARY, 30).getTime(), 40, "Growth opportunities available",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), alice);

        Job job2 = new Job("J002", "HR Manager", "Full-Time", "Manage recruitment and employee relations",
                "HR interview, case study", "Permanent", "On-site", "6 months", false,
                getRandom("skill", 4), 5, 8, 6000.0,
                getRandom("benefit", 2),
                new GregorianCalendar(2024, Calendar.JANUARY, 30).getTime(), 45, "Career growth in HR leadership",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), bob);

        Job job3 = new Job("J003", "Financial Analyst", "Full-Time", "Analyze financial data and market trends",
                "Aptitude test, panel interview", "Permanent", "Hybrid", "3 months", false,
                getRandom("skill", 2), 4, 6, 7000.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.FEBRUARY, 20).getTime(), 40, "Path to senior finance roles",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), carol);

        Job job4 = new Job("J004", "Marketing Director", "Full-Time", "Oversee marketing campaigns and strategy",
                "Presentation, strategic discussion", "Permanent", "Remote", "6 months", false,
                getRandom("skill", 5), 7, 10, 9000.0,
                getRandom("benefit", 5),
                new GregorianCalendar(2024, Calendar.FEBRUARY, 20).getTime(), 50, "High-level executive role",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), david);

        Job job5 = new Job("J005", "Data Scientist", "Full-Time", "Develop machine learning models for business insights",
                "Technical test, HR discussion", "Permanent", "Remote", "3 months", true,
                getRandom("skill", 3), 5, 6, 8000.0,
                getRandom("benefit", 2),
                new GregorianCalendar(2024, Calendar.FEBRUARY, 20).getTime(), 40, "Opportunities in AI and analytics",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), frank);

        Job job6 = new Job("J006", "UI/UX Designer", "Full-Time", "Design user interfaces and experiences",
                "Portfolio review, design challenge", "Permanent", "On-site", "3 months", true,
                getRandom("skill", 2), 3, 4, 5500.0,
                getRandom("benefit", 2),
                new GregorianCalendar(2024, Calendar.FEBRUARY, 28).getTime(), 40, "Exciting design projects",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), grace);

        Job job7 = new Job("J007", "Cybersecurity Analyst", "Full-Time", "Monitor and secure IT infrastructure",
                "Technical assessment, security scenario test", "Permanent", "On-site", "6 months", false,
                getRandom("skill", 3), 4, 5, 6500.0,
                getRandom("benefit", 3),
                new GregorianCalendar(2024, Calendar.FEBRUARY, 28).getTime(), 42, "Opportunities in cyber defense",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), henry);

        Job job8 = new Job("J008", "Content Manager", "Full-Time", "Develop and manage content marketing strategy",
                "Portfolio review, creative writing test", "Permanent", "On-site", "3 months", false,
                getRandom("skill", 2), 3, 4, 5000.0,
                getRandom("benefit", 2),
                new GregorianCalendar(2024, Calendar.FEBRUARY, 28).getTime(), 40, "Creative content leadership",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), henry);

        Job job9 = new Job("J009", "Mechanical Engineer", "Full-Time", "Design and develop mechanical systems",
                "Technical interview, CAD test", "Permanent", "Remote", "3 months", true,
                getRandom("skill", 3), 5, 6, 7200.0,
                getRandom("benefit", 3),
                new GregorianCalendar(2024, Calendar.FEBRUARY, 28).getTime(), 45, "Growth in engineering projects",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), irene);

        Job job10 = new Job("J010", "Legal Advisor", "Full-Time", "Provide legal advice to corporate clients",
                "Case study, legal consultation simulation", "Permanent", "Remote", "6 months", false,
                getRandom("skill", 3), 6, 3, 8500.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.MARCH, 15).getTime(), 40, "Corporate legal leadership",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), jack);

        Job job11 = new Job("J011", "Operations Manager", "Full-Time", "Oversee and optimize business operations",
                "Leadership assessment, case study", "Permanent", "On-site", "3 months", false,
                getRandom("skill", 3), 7, 8, 9000.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.MARCH, 15).getTime(), 45, "Leadership in operations",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), carol);

        Job job12 = new Job("J012", "Research Scientist", "Full-Time", "Conduct research on new drug formulations",
                "Technical interview, lab test", "Permanent", "Remote", "6 months", false,
                getRandom("skill", 3), 5, 5, 7500.0,
                getRandom("benefit", 3),
                new GregorianCalendar(2024, Calendar.MARCH, 15).getTime(), 40, "Advanced research opportunities",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), alice);

        Job job13 = new Job("J013", "Customer Relationship Manager", "Full-Time", "Ensure customer satisfaction and retention",
                "Behavioral interview, problem-solving test", "Permanent", "On-site", "3 months", false,
                getRandom("skill", 2), 4, 6, 6000.0,
                getRandom("benefit", 3),
                new GregorianCalendar(2024, Calendar.MARCH, 25).getTime(), 40, "Opportunities in client management",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), bob);

        Job job14 = new Job("J014", "Software Developer", "Full-Time", "Design and develop game applications",
                "Portfolio review, coding test", "Permanent", "On-site", "3 months", true,
                getRandom("skill", 3), 4, 5, 7000.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.MARCH, 25).getTime(), 42, "Growth in gaming industry",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), bob);

        Job job15 = new Job("J015", "AI Engineer", "Full-Time", "Develop and research artificial intelligence models",
                "Machine learning test, research presentation", "Permanent", "Remote", "6 months", true,
                getRandom("skill", 4), 6, 7, 9000.0,
                getRandom("benefit", 5),
                new GregorianCalendar(2024, Calendar.MARCH, 30).getTime(), 45, "Leading AI innovations",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), irene);

        Job job16 = new Job("J016", "HR Analyst", "Full-Time", "Analyse HR metrics to guide talent strategy",
                "Case study review, SQL test", "Permanent", "On-Site", "Immediate", true,
                getRandom("skill", 3), 3, 5, 5500.0,
                getRandom("benefit", 3),
                new GregorianCalendar(2024, Calendar.MARCH, 30).getTime(), 30, "HR analytics & workforce planning",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), kevin);

        Job job17 = new Job("J017", "Training Specialist", "Contract", "Design and deliver training programmes",
                "Presentation and mock facilitation", "Contract", "Hybrid", "1 month", true,
                getRandom("skill", 4), 2, 4, 4600.0,
                getRandom("benefit", 2),
                new GregorianCalendar(2024, Calendar.APRIL, 15).getTime(), 28, "Empowering employee growth",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), kevin);

        Job job18 = new Job("J018", "Recruitment Specialist", "Full-Time", "Lead end-to-end hiring for global roles",
                "Live interview simulation, sourcing challenge", "Permanent", "Remote", "2 weeks", true,
                getRandom("skill", 4), 4, 6, 6200.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.APRIL, 15).getTime(), 35, "Scaling teams strategically",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), david);

        Job job19 = new Job("J019", "Financial Analyst", "Full-Time", "Conduct forecasts and financial modelling",
                "Excel modelling task, case interview", "Permanent", "On-Site", "Immediate", true,
                getRandom("skill", 5), 2, 4, 5800.0,
                getRandom("benefit", 3),
                new GregorianCalendar(2024, Calendar.APRIL, 15).getTime(), 32, "Drive data-backed decisions",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), frank);

        Job job20 = new Job("J020", "Investment Analyst", "Full-Time", "Evaluate market trends and recommend portfolios",
                "Pitch deck, investment analysis", "Permanent", "Hybrid", "1 month", true,
                getRandom("skill", 4), 5, 7, 8800.0,
                getRandom("benefit", 5),
                new GregorianCalendar(2024, Calendar.APRIL, 25).getTime(), 40, "Shaping client portfolios",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), emily);

        Job job21 = new Job("J021", "Risk Analyst", "Contract", "Assess financial and regulatory risk",
                "Compliance scenario, audit report", "Contract", "Remote", "3 months", true,
                getRandom("skill", 3), 4, 6, 7300.0,
                getRandom("benefit", 2),
                new GregorianCalendar(2024, Calendar.APRIL, 25).getTime(), 38, "Secure and strategic finances",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), oliver);

        Job job22 = new Job("J022", "Accountant", "Full-Time", "Oversee monthly closing and financial reports",
                "Ledger task, journal entry quiz", "Permanent", "On-Site", "2 weeks", true,
                getRandom("skill", 3), 3, 5, 6100.0,
                getRandom("benefit", 3),
                new GregorianCalendar(2024, Calendar.APRIL, 30).getTime(), 34, "Reliable financial stewardship",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), oliver);

        Job job23 = new Job("J023", "Product Analyst", "Full-Time", "Analyse data to optimise finance platforms",
                "UX data scenario, Python test", "Permanent", "Hybrid", "1 month", true,
                getRandom("skill", 4), 2, 4, 6600.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.APRIL, 30).getTime(), 29, "Innovating financial tech",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), emily);

        Job job24 = new Job("J024", "Data Analyst", "Full-Time", "Analyse and manage clinical trial data",
                "SQL challenge, case study", "Permanent", "Hybrid", "Immediate", true,
                getRandom("skill", 4), 3, 5, 6800.0,
                getRandom("benefit", 3),
                new GregorianCalendar(2023, Calendar.MAY, 15).getTime(), 33, "Enabling precision medicine",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), grace);

        Job job25 = new Job("J025", "Project Manager", "Contract", "Coordinate digital health projects",
                "Project case simulation, stakeholder mapping", "Contract", "Remote", "2 months", true,
                getRandom("skill", 4), 5, 7, 7900.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.MAY, 15).getTime(), 39, "Improving care delivery systems",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), henry);

        Job job26 = new Job("J026", "AI Engineer", "Full-Time", "Develop AI tools for diagnostics and imaging",
                "Python test, research discussion", "Permanent", "On-Site", "1 month", true,
                getRandom("skill", 5), 4, 6, 9200.0,
                getRandom("benefit", 5),
                new GregorianCalendar(2024, Calendar.MAY, 15).getTime(), 41, "Transforming healthcare with AI",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), henry);

        Job job27 = new Job("J027", "Instructional Designer", "Full-Time", "Design engaging learning experiences",
                "Storyboard task, LMS test", "Permanent", "Remote", "Immediate", true,
                getRandom("skill", 4), 2, 4, 5100.0,
                getRandom("benefit", 3),
                new GregorianCalendar(2024, Calendar.MAY, 25).getTime(), 29, "Redefining digital learning",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), irene);

        Job job28 = new Job("J028", "Programme Coordinator", "Contract", "Oversee academic calendar & curriculum",
                "Planning simulation, communication test", "Contract", "On-Site", "3 weeks", true,
                getRandom("skill", 3), 3, 5, 4600.0,
                getRandom("benefit", 2),
                new GregorianCalendar(2024, Calendar.MAY, 25).getTime(), 27, "Streamlining academic operations",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), farah);

        Job job29 = new Job("J029", "eLearning Developer", "Full-Time", "Build SCORM and HTML5-based learning content",
                "Code snippet review, visual demo", "Permanent", "Hybrid", "1 month", true,
                getRandom("skill", 5), 2, 4, 5400.0,
                getRandom("benefit", 3),
                new GregorianCalendar(2024, Calendar.MAY, 31).getTime(), 31, "Driving innovation in learning tech",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), jack);

        Job job30 = new Job("J030", "Policy Researcher", "Contract", "Conduct research on national education policies",
                "Writing sample, policy analysis", "Contract", "Remote", "2 months", true,
                getRandom("skill", 4), 4, 6, 6000.0,
                getRandom("benefit", 3),
                new GregorianCalendar(2024, Calendar.MAY, 31).getTime(), 36, "Evidence-based education change",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), jack);

        Job job31 = new Job("J031", "Cloud Engineer", "Full-Time", "Design and maintain cloud infrastructure",
                "Terraform test, architecture review", "Permanent", "Hybrid", "Immediate", true,
                getRandom("skill", 5), 4, 6, 8700.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.JUNE, 15).getTime(), 40, "Scaling systems with reliability",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), faiz);

        Job job32 = new Job("J032", "DevOps Engineer", "Full-Time", "Implement CI/CD and monitoring pipelines",
                "Live pipeline design challenge", "Permanent", "Remote", "2 weeks", true,
                getRandom("skill", 4), 3, 5, 7600.0,
                getRandom("benefit", 3),
                new GregorianCalendar(2024, Calendar.JUNE, 15).getTime(), 35, "Automating cloud delivery",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), arif);

        Job job33 = new Job("J033", "Security Analyst", "Contract", "Conduct cloud risk assessments and hardening",
                "Security audit exercise", "Contract", "On-Site", "1 month", true,
                getRandom("skill", 4), 5, 7, 8300.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.JUNE, 15).getTime(), 38, "Protecting cloud-native environments",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), arif);

        Job job34 = new Job("J034", "Machine Learning Engineer", "Full-Time", "Build and deploy ML models at scale",
                "Model tuning task, code test", "Permanent", "Remote", "Immediate", true,
                getRandom("skill", 5), 3, 5, 8900.0,
                getRandom("benefit", 5),
                new GregorianCalendar(2024, Calendar.JUNE, 30).getTime(), 42, "Deploying intelligent systems",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), leon);

        Job job35 = new Job("J035", "Product Manager", "Full-Time", "Define roadmap for AI-powered features",
                "Product case challenge", "Permanent", "Hybrid", "1 month", true,
                getRandom("skill", 4), 4, 6, 9100.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.JUNE, 30).getTime(), 36, "Shaping AI user experiences",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), teh);

        Job job36 = new Job("J036", "Research Scientist", "Contract", "Research visual recognition algorithms",
                "Publication review, deep learning test", "Contract", "Remote", "2 months", true,
                getRandom("skill", 5), 5, 7, 9500.0,
                getRandom("benefit", 5),
                new GregorianCalendar(2024, Calendar.JUNE, 30).getTime(), 45, "Advancing visual intelligence",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), leon);

        Job job37 = new Job("J037", "NLP Engineer", "Full-Time", "Develop and fine-tune LLMs for chatbot applications",
                "Transformer task, text generation challenge", "Permanent", "Remote", "Immediate", true,
                getRandom("skill", 5), 4, 6, 9800.0,
                getRandom("benefit", 5),
                new GregorianCalendar(2024, Calendar.JUNE, 30).getTime(), 43, "Conversational AI at scale",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), teh);

        Job job38 = new Job("J038", "Cloud Architect", "Full-Time", "Design scalable cloud-native solutions",
                "Architecture case, cloud scenario test", "Permanent", "Hybrid", "Immediate", true,
                getRandom("skill", 5), 6, 8, 9400.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.JULY, 15).getTime(), 44, "Crafting scalable cloud architectures",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), arif);

        Job job39 = new Job("J039", "Site Reliability Engineer", "Full-Time", "Maintain uptime across cloud platforms",
                "Systems simulation, on-call scenario", "Permanent", "Remote", "2 weeks", true,
                getRandom("skill", 4), 4, 6, 8600.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.JULY, 18).getTime(), 38, "Reliability at internet scale",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), joanna);

        Job job40 = new Job("J040", "Cloud Cost Analyst", "Contract", "Optimise and forecast cloud spend",
                "Cost report audit, financial analysis task", "Contract", "On-Site", "1 month", true,
                getRandom("skill", 4), 3, 5, 6900.0,
                getRandom("benefit", 3),
                new GregorianCalendar(2024, Calendar.JULY, 18).getTime(), 30, "Driving cloud cost efficiency",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), joanna);

        Job job41 = new Job("J041", "AI Researcher", "Full-Time", "Research bias and responsible AI methods",
                "Paper review, ethical scenario discussion", "Permanent", "Remote", "Immediate", true,
                getRandom("skill", 5), 5, 7, 9100.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.JULY, 21).getTime(), 41, "Promoting ethical AI innovation",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), kelvin);

        Job job42 = new Job("J042", "AI Consultant", "Contract", "Advise clients on tailored AI implementations",
                "Use-case proposal, client interaction test", "Contract", "Hybrid", "2 weeks", true,
                getRandom("skill", 4), 4, 6, 8800.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.APRIL, 29).getTime(), 39, "Bridging business with intelligent tech",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), kelvin);

        Job job43 = new Job("J043", "Cybersecurity Analyst", "Full-Time", "Monitor and respond to security incidents",
                "Log analysis task, threat triage test", "Permanent", "Hybrid", "Immediate", true,
                getRandom("skill", 4), 3, 5, 7700.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.JULY, 29).getTime(), 38, "Keeping systems safe and secure",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), yap);

        Job job44 = new Job("J044", "Penetration Tester", "Contract", "Perform security assessments and red teaming",
                "Vulnerability exploitation task", "Contract", "Remote", "2 months", true,
                getRandom("skill", 5), 4, 6, 8800.0,
                getRandom("benefit", 3),
                new GregorianCalendar(2024, Calendar.AUGUST, 10).getTime(), 36, "Offensive testing for stronger defence",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), sarah);

        Job job45 = new Job("J045", "Digital Digital Marketer", "Full-Time", "Plan and optimise online campaigns",
                "Ad targeting exercise, strategy pitch", "Permanent", "Remote", "1 month", true,
                getRandom("skill", 4), 2, 4, 5800.0,
                getRandom("benefit", 3),
                new GregorianCalendar(2024, Calendar.AUGUST, 10).getTime(), 30, "Shaping data-driven brand success",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), linda);

        Job job46 = new Job("J046", "Content Manager", "Full-Time", "Lead content creation and SEO strategy",
                "Editorial brief test, SEO audit", "Permanent", "Hybrid", "Immediate", true,
                getRandom("skill", 3), 3, 5, 6100.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.AUGUST, 15).getTime(), 28, "Engaging audiences through story",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), linda);

        Job job47 = new Job("J047", "Blockchain Developer", "Full-Time", "Build smart contracts and DeFi protocols",
                "Solidity coding test, security Q&A", "Permanent", "Remote", "2 weeks", true,
                getRandom("skill", 5), 4, 6, 9300.0,
                getRandom("benefit", 5),
                new GregorianCalendar(2024, Calendar.AUGUST, 15).getTime(), 41, "Powering trustless finance",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), elaine);

        Job job48 = new Job("J048", "Financial Data Engineer", "Full-Time", "Design data pipelines for financial insights",
                "ETL challenge, SQL test", "Permanent", "On-Site", "1 month", true,
                getRandom("skill", 4), 3, 5, 8600.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.AUGUST, 30).getTime(), 37, "Making data-driven finance happen",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), elaine);

        Job job49 = new Job("J049", "Security Operations Center (SOC) Engineer", "Full-Time", "Manage real-time threat detection systems",
                "Alert triage scenario, SIEM hands-on", "Permanent", "On-Site", "Immediate", true,
                getRandom("skill", 4), 3, 5, 7900.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.AUGUST, 30).getTime(), 39, "Keeping enterprise secure 24/7",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), yap);

        Job job50 = new Job("J050", "Cloud Security Engineer", "Full-Time", "Secure cloud-native applications and infrastructure",
                "Architecture audit, threat modeling", "Permanent", "Remote", "2 weeks", true,
                getRandom("skill", 5), 5, 7, 9200.0,
                getRandom("benefit", 5),
                new GregorianCalendar(2024, Calendar.SEPTEMBER, 15).getTime(), 42, "Defending the cloud frontier",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), yap);

        Job job51 = new Job("J051", "Product Analyst", "Full-Time", "Analyse market trends and product usage",
                "Case analysis, dashboard design test", "Permanent", "Hybrid", "1 month", true,
                getRandom("skill", 4), 2, 4, 7100.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.SEPTEMBER, 15).getTime(), 34, "Data-led financial innovation",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), shafiq);

        Job job52 = new Job("J052", "Software Engineer", "Contract", "Build secure APIs for digital payments",
                "REST API task, payment flow discussion", "Contract", "Remote", "2 months", true,
                getRandom("skill", 5), 4, 6, 8800.0,
                getRandom("benefit", 3),
                new GregorianCalendar(2024, Calendar.SEPTEMBER, 20).getTime(), 36, "Engineering seamless transactions",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), nash);

        Job job53 = new Job("J053", "Brand Strategist", "Full-Time", "Craft compelling brand narratives",
                "Brand audit task, pitch exercise", "Permanent", "Hybrid", "1 month", true,
                getRandom("skill", 4), 3, 5, 6400.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.SEPTEMBER, 20).getTime(), 29, "Shaping identity with creativity",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), ryan);

        Job job54 = new Job("J054", "Marketing Analyst", "Full-Time", "Optimise PPC and conversion strategies",
                "Campaign performance analysis, Google Ads test", "Permanent", "Remote", "2 weeks", true,
                getRandom("skill", 4), 2, 4, 6000.0,
                getRandom("benefit", 3),
                new GregorianCalendar(2024, Calendar.SEPTEMBER, 30).getTime(), 31, "Driving ROI through precision targeting",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), ryan);

        Job job55 = new Job("J055", "Quantitative Analyst", "Full-Time", "Develop trading algorithms and risk models",
                "Time-series problem, modelling task", "Permanent", "On-Site", "Immediate", true,
                getRandom("skill", 5), 5, 7, 9700.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.SEPTEMBER, 30).getTime(), 42, "Turning numbers into strategies",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), shafiq);

        Job job56 = new Job("J056", "Solutions Architect", "Full-Time", "Design tools to automate regulatory compliance",
                "Architecture case, RegTech proposal", "Permanent", "Hybrid", "2 weeks", true,
                getRandom("skill", 5), 4, 6, 8900.0,
                getRandom("benefit", 5),
                new GregorianCalendar(2024, Calendar.OCTOBER, 15).getTime(), 39, "Innovation meets regulation",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), nash);

        Job job57 = new Job("J057", "Threat Analyst", "Full-Time", "Gather and analyse threat intel to improve defences",
                "Threat report synthesis, TTP identification", "Permanent", "Remote", "Immediate", true,
                getRandom("skill", 4), 4, 6, 8500.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.OCTOBER, 15).getTime(), 37, "Know your adversary, stay ahead",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), sarah);

        Job job58 = new Job("J058", "Application Security Engineer", "Full-Time", "Secure SDLC and conduct code audits",
                "Static code review, threat modelling", "Permanent", "Hybrid", "1 month", true,
                getRandom("skill", 5), 5, 7, 9100.0,
                getRandom("benefit", 5),
                new GregorianCalendar(2024, Calendar.OCTOBER, 20).getTime(), 40, "Building secure software from the ground up",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), sarah);

        Job job59 = new Job("J059", "Social Media Manager", "Full-Time", "Drive engagement across social platforms",
                "Content calendar, audience analysis task", "Permanent", "Remote", "Immediate", true,
                getRandom("skill", 3), 2, 4, 5600.0,
                getRandom("benefit", 3),
                new GregorianCalendar(2024, Calendar.OCTOBER, 20).getTime(), 29, "Voice of the brand online",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), cindy);

        Job job60 = new Job("J060", "Marketing Analyst", "Full-Time", "Analyse campaign data to generate insights",
                "A/B test analysis, reporting task", "Permanent", "On-Site", "2 weeks", true,
                getRandom("skill", 4), 3, 5, 6200.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.OCTOBER, 30).getTime(), 31, "Data-driven marketing excellence",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), ryan);

        Job job61 = new Job("J061", "Instructional Designer", "Full-Time", "Create engaging digital learning content",
                "Storyboard assignment, curriculum outline", "Permanent", "Remote", "1 month", true,
                getRandom("skill", 4), 3, 5, 6000.0,
                getRandom("benefit", 3),
                new GregorianCalendar(2024, Calendar.OCTOBER, 30).getTime(), 33, "Designing modern education experiences",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), syafiq);

        Job job62 = new Job("J062", "Frontend Developer", "Full-Time", "Build interactive UI for learning platforms",
                "UI component task, accessibility audit", "Permanent", "Hybrid", "Immediate", true,
                getRandom("skill", 5), 4, 6, 7200.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.OCTOBER, 30).getTime(), 36, "Interactive tech meets education",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), syafiq);

        Job job63 = new Job("J063", "Education Product Manager", "Full-Time", "Lead digital learning product roadmap",
                "Feature prioritisation task, product pitch", "Permanent", "Hybrid", "2 weeks", true,
                getRandom("skill", 4), 5, 7, 8100.0,
                getRandom("benefit", 5),
                new GregorianCalendar(2024, Calendar.NOVEMBER, 10).getTime(), 39, "Building the future of learning",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), jenny);

        Job job64 = new Job("J064", "Full Stack Developer", "Full-Time", "Develop scalable web applications",
                "Code task, API integration test", "Permanent", "Hybrid", "Immediate", true,
                getRandom("skill", 5), 3, 5, 8000.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.NOVEMBER, 15).getTime(), 36, "Code across the stack, make impact",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), siti);

        Job job65 = new Job("J065", "DevOps Engineer", "Full-Time", "Automate CI/CD pipelines and monitor systems",
                "Pipeline setup task, containerisation test", "Permanent", "Remote", "2 weeks", true,
                getRandom("skill", 4), 4, 6, 8700.0,
                getRandom("benefit", 5),
                new GregorianCalendar(2024, Calendar.NOVEMBER, 20).getTime(), 37, "Ops meets code at scale",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), khoo);

        Job job66 = new Job("J066", "Mobile Developer", "Full-Time", "Build and maintain cross-platform mobile apps",
                "UI task, performance tuning", "Permanent", "On-Site", "1 month", true,
                getRandom("skill", 4), 3, 5, 7600.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.NOVEMBER, 20).getTime(), 35, "Crafting seamless mobile experiences",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), khoo);

        Job job67 = new Job("J067", "Software QA Engineer", "Full-Time", "Write automated tests and validate releases",
                "Bug reproduction, test case design", "Permanent", "Hybrid", "Immediate", true,
                getRandom("skill", 3), 2, 4, 6200.0,
                getRandom("benefit", 3),
                new GregorianCalendar(2024, Calendar.NOVEMBER, 30).getTime(), 32, "Quality-first engineering culture",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), azmi);

        Job job68 = new Job("J068", "Data Analyst", "Full-Time", "Create dashboards and visual analytics tools",
                "Visualisation challenge, storytelling test", "Permanent", "Remote", "1 month", true,
                getRandom("skill", 4), 3, 5, 7200.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.NOVEMBER, 30).getTime(), 34, "Telling stories with data",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), liew);

        Job job69 = new Job("J069", "Machine Learning Engineer", "Full-Time", "Build ML models for forecasting and optimisation",
                "Feature engineering task, model tuning", "Permanent", "On-Site", "Immediate", true,
                getRandom("skill", 5), 5, 7, 9400.0,
                getRandom("benefit", 5),
                new GregorianCalendar(2024, Calendar.DECEMBER, 10).getTime(), 41, "Models that power real-time insight",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), liew);

        Job job70 = new Job("J070", "Backend Developer", "Full-Time", "Design and develop scalable server-side solutions",
                "API design task, load balancing scenario", "Permanent", "Remote", "Immediate", true,
                getRandom("skill", 4), 4, 6, 8200.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.DECEMBER, 15).getTime(), 38, "Building robust backends that scale",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), azmi);

        Job job71 = new Job("J071", "Site Reliability Engineer", "Full-Time", "Monitor, maintain, and scale infrastructure",
                "Incident management case, performance test", "Permanent", "On-Site", "2 weeks", true,
                getRandom("skill", 5), 5, 7, 9200.0,
                getRandom("benefit", 5),
                new GregorianCalendar(2024, Calendar.DECEMBER, 15).getTime(), 40, "Ensuring uptime and reliability",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), siti);

        Job job72 = new Job("J072", "Data Scientist", "Full-Time", "Develop machine learning models to extract insights from data",
                "Model selection, data preprocessing", "Permanent", "Hybrid", "1 month", true,
                getRandom("skill", 5), 5, 7, 9500.0,
                getRandom("benefit", 5),
                new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), 42, "Turning data into predictive power",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), zafran);

        Job job73 = new Job("J073", "Data Engineer", "Full-Time", "Build and optimise data pipelines for data processing",
                "ETL pipeline task, data lake setup", "Permanent", "Remote", "Immediate", true,
                getRandom("skill", 4), 4, 6, 8800.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), 37, "Empowering decisions through data",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), ivan);

        Job job74 = new Job("J074", "Business Intelligence Analyst", "Full-Time", "Design and implement BI reports and dashboards",
                "Reporting task, dashboard query challenge", "Permanent", "Hybrid", "2 weeks", true,
                getRandom("skill", 4), 3, 5, 7300.0,
                getRandom("benefit", 3),
                new GregorianCalendar(2024, Calendar.DECEMBER, 31).getTime(), 33, "Transforming business data into actionable insights",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), ivan);

        Job job75 = new Job("J075", "AI Researcher", "Full-Time", "Conduct cutting-edge AI research to push the boundaries of innovation",
                "Research paper review, algorithm proposal", "Permanent", "Remote", "2 months", true,
                getRandom("skill", 5), 5, 7, 10000.0,
                getRandom("benefit", 5),
                new GregorianCalendar(2025, Calendar.JANUARY, 10).getTime(), 43, "Pioneering the future of artificial intelligence",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), ivan);

        Job job76 = new Job("J076", "Learning Experience Designer", "Full-Time", "Create immersive learning experiences for digital platforms",
                "Storyboarding task, user journey mapping", "Permanent", "Hybrid", "Immediate", true,
                getRandom("skill", 4), 4, 6, 7000.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2025, Calendar.JANUARY, 15).getTime(), 35, "Revolutionising learning through design",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), darren);

        Job job77 = new Job("J077", "E-learning Specialist", "Full-Time", "Develop and deliver engaging online courses",
                "Course development task, usability test", "Permanent", "Remote", "1 month", true,
                getRandom("skill", 4), 3, 5, 6500.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2025, Calendar.JANUARY, 31).getTime(), 32, "Delivering knowledge through technology",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), jenny);

        Job job78 = new Job("J078", "Educational Technology Consultant", "Full-Time", "Advise educational institutions on tech integration",
                "Tech assessment task, solution pitch", "Permanent", "Hybrid", "2 weeks", true,
                getRandom("skill", 5), 5, 7, 8200.0,
                getRandom("benefit", 5),
                new GregorianCalendar(2025, Calendar.JANUARY, 31).getTime(), 38, "Bringing the latest tech to the classroom",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), jenny);

        Job job79 = new Job("J079", "HR Systems Analyst", "Full-Time", "Implement and optimise HR software systems",
                "System integration task, HR tool evaluation", "Permanent", "Hybrid", "1 month", true,
                getRandom("skill", 4), 4, 6, 7300.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2025, Calendar.FEBRUARY, 10).getTime(), 34, "Optimising HR through technology",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), nurul);

        Job job80 = new Job("J080", "Employee Experience Manager", "Full-Time", "Enhance employee engagement and satisfaction",
                "Employee survey analysis, engagement strategy", "Permanent", "Remote", "Immediate", true,
                getRandom("skill", 5), 4, 6, 8100.0,
                getRandom("benefit", 5),
                new GregorianCalendar(2025, Calendar.FEBRUARY, 15).getTime(), 36, "Creating meaningful employee experiences",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), goh);

        Job job81 = new Job("J081", "Data Scientist", "Full-Time", "Analyse patient data to optimise healthcare services",
                "Data cleaning, modelling task", "Permanent", "Hybrid", "Immediate", true,
                getRandom("skill", 5), 4, 6, 9000.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2025, Calendar.FEBRUARY, 22).getTime(), 39, "Improving health outcomes with data",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), fauzi);

        Job job82 = new Job("J082", "Software Developer", "Full-Time", "Build and maintain healthcare software solutions",
                "API development task, testing phase", "Permanent", "Remote", "2 weeks", true,
                getRandom("skill", 5), 3, 5, 7500.0,
                getRandom("benefit", 3),
                new GregorianCalendar(2025, Calendar.FEBRUARY, 28).getTime(), 35, "Tech that improves patient care",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), fauzi);

        Job job83 = new Job("J083", "Systems Integration Engineer", "Full-Time", "Integrate medical devices into healthcare networks",
                "System integration task, network design", "Permanent", "On-Site", "1 month", true,
                getRandom("skill", 4), 5, 7, 8800.0,
                getRandom("benefit", 5),
                new GregorianCalendar(2025, Calendar.FEBRUARY, 28).getTime(), 40, "Bringing healthcare devices to life",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), fauzi);

        Job job84 = new Job("J084", "Recruiter", "Full-Time", "Attract and retain top talent for clients",
                "Recruitment strategy, candidate sourcing", "Permanent", "Hybrid", "Immediate", true,
                getRandom("skill", 3), 3, 5, 6800.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2025, Calendar.MARCH, 10).getTime(), 31, "Matching great talent with great companies",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), nurul);

        Job job85 = new Job("J085", "Operations Manager", "Full-Time", "Oversee operations for virtual healthcare services",
                "Operational planning task, remote care setup", "Permanent", "Hybrid", "1 month", true,
                getRandom("skill", 5), 5, 7, 9500.0,
                getRandom("benefit", 5),
                new GregorianCalendar(2025, Calendar.MARCH, 10).getTime(), 42, "Innovating healthcare with remote solutions",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), elly);

        Job job86 = new Job("J086", "Project Manager", "Full-Time", "Manage IT projects for healthcare institutions",
                "Project planning, resource allocation", "Permanent", "On-Site", "2 weeks", true,
                getRandom("skill", 4), 4, 6, 8500.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2025, Calendar.MARCH, 12).getTime(), 38, "Managing projects for better health IT systems",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), elly);

        Job job87 = new Job("J087", "HR Data Analyst", "Full-Time", "Analyse HR data to drive strategic decisions",
                "Data processing, report creation", "Permanent", "Remote", "Immediate", true,
                getRandom("skill", 4), 4, 6, 7300.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2025, Calendar.MARCH, 20).getTime(), 35, "Making HR decisions with data-driven insights",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), nurul);

        Job job88 = new Job("J088", "Learning Management System (LMS) Specialist", "Full-Time", "Implement and maintain LMS for organisations",
                "LMS configuration, user training", "Permanent", "Hybrid", "1 month", true,
                getRandom("skill", 5), 4, 6, 7600.0,
                getRandom("benefit", 4),
                new GregorianCalendar(2025, Calendar.MARCH, 25).getTime(), 37, "Optimising employee learning and development",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), goh);

        Job job89 = new Job("J089", "HRIS Consultant", "Full-Time", "Consult on HR Information System implementations",
                "System integration task, consulting proposal", "Permanent", "On-Site", "Immediate", true,
                getRandom("skill", 5), 4, 6, 8000.0,
                getRandom("benefit", 5),
                new GregorianCalendar(2025, Calendar.MARCH, 30).getTime(), 40, "Guiding HR teams to better systems",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), goh);

        Job job90 = new Job("J090", "Compliance Officer", "Full-Time", "Ensure healthcare data is compliant with regulations",
                "Compliance audit, policy development", "Permanent", "Remote", "Immediate", true,
                getRandom("skill", 4), 5, 7, 9500.0,
                getRandom("benefit", 5),
                new GregorianCalendar(2025, Calendar.APRIL, 12).getTime(), 43, "Ensuring privacy and compliance in healthcare",
                new DoublyLinkedList<>(), new DoublyLinkedList<>(), elly);

        //Create Resume
        Resume resume1 = new Resume("Bachelor's Degree",
                getRandom("skill", 5),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume2 = new Resume("Master's Degree",
                getRandom("skill", 4),
                getRandom("experience", 3),
                getRandom("certification", 3),
                getRandom("project", 2),
                getRandom("language", 4),
                getRandom("award", 3));

        Resume resume3 = new Resume("Bachelor's Degree",
                getRandom("skill", 6),
                getRandom("experience", 4),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 2),
                getRandom("award", 1));

        Resume resume4 = new Resume("Diploma",
                getRandom("skill", 4),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume5 = new Resume("Master's Degree",
                getRandom("skill", 6),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 2),
                getRandom("award", 3));

        Resume resume6 = new Resume("Bachelor's Degree",
                getRandom("skill", 5),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume7 = new Resume("Master's Degree",
                getRandom("skill", 4),
                getRandom("experience", 3),
                getRandom("certification", 3),
                getRandom("project", 2),
                getRandom("language", 4),
                getRandom("award", 3));

        Resume resume8 = new Resume("Bachelor's Degree",
                getRandom("skill", 5),
                getRandom("experience", 2),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume9 = new Resume("Diploma",
                getRandom("skill", 6),
                getRandom("experience", 2),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 1));

        Resume resume10 = new Resume("Doctorate (PhD)",
                getRandom("skill", 7),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 4),
                getRandom("award", 3));

        Resume resume11 = new Resume("Bachelor's Degree",
                getRandom("skill", 4),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume12 = new Resume("Master's Degree",
                getRandom("skill", 6),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 2),
                getRandom("award", 2));

        Resume resume13 = new Resume("Diploma",
                getRandom("skill", 5),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 1));

        Resume resume14 = new Resume("Bachelor's Degree",
                getRandom("skill", 4),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume15 = new Resume("Master's Degree",
                getRandom("skill", 6),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 2),
                getRandom("award", 3));

        Resume resume16 = new Resume("Bachelor's Degree",
                getRandom("skill", 6),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 4),
                getRandom("award", 1));

        Resume resume17 = new Resume("Master's Degree",
                getRandom("skill", 4),
                getRandom("experience", 3),
                getRandom("certification", 3),
                getRandom("project", 2),
                getRandom("language", 2),
                getRandom("award", 2));

        Resume resume18 = new Resume("Bachelor's Degree",
                getRandom("skill", 7),
                getRandom("experience", 4),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 2),
                getRandom("award", 3));

        Resume resume19 = new Resume("Master's Degree",
                getRandom("skill", 7),
                getRandom("experience", 2),
                getRandom("certification", 3),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 1));

        Resume resume20 = new Resume("Bachelor's in Multimedia DesignDegree",
                getRandom("skill", 6),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 3));

        Resume resume21 = new Resume("Bachelor's Degree",
                getRandom("skill", 6),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 4),
                getRandom("award", 3));

        Resume resume22 = new Resume("Master's Degree",
                getRandom("skill", 5),
                getRandom("experience", 2),
                getRandom("certification", 3),
                getRandom("project", 2),
                getRandom("language", 4),
                getRandom("award", 1));

        Resume resume23 = new Resume("Bachelor's Degree",
                getRandom("skill", 4),
                getRandom("experience", 2),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume24 = new Resume("Bachelor's Degree",
                getRandom("skill", 5),
                getRandom("experience", 2),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 3));

        Resume resume25 = new Resume("Bachelor's Degree",
                getRandom("skill", 5),
                getRandom("experience", 3),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 4),
                getRandom("award", 1));

        Resume resume26 = new Resume("Bachelor's Degree",
                getRandom("skill", 5),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 3));

        Resume resume27 = new Resume("Master's Degree",
                getRandom("skill", 6),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 2),
                getRandom("language", 4),
                getRandom("award", 2));

        Resume resume28 = new Resume("Diploma",
                getRandom("skill", 4),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume29 = new Resume("Diploma",
                getRandom("skill", 4),
                getRandom("experience", 3),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 4),
                getRandom("award", 3));

        Resume resume30 = new Resume("Doctorate (PhD)",
                getRandom("skill", 7),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 2),
                getRandom("award", 2));

        Resume resume31 = new Resume("Associate Degree",
                getRandom("skill", 7),
                getRandom("experience", 2),
                getRandom("certification", 3),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 3));

        Resume resume32 = new Resume("Associate Degree",
                getRandom("skill", 7),
                getRandom("experience", 3),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 2),
                getRandom("award", 1));

        Resume resume33 = new Resume("Diploma",
                getRandom("skill", 6),
                getRandom("experience", 2),
                getRandom("certification", 3),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 1));

        Resume resume34 = new Resume("Doctorate (PhD)",
                getRandom("skill", 7),
                getRandom("experience", 3),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 4),
                getRandom("award", 3));

        Resume resume35 = new Resume("Diploma",
                getRandom("skill", 7),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 1));

        Resume resume36 = new Resume("Master's Degree",
                getRandom("skill", 6),
                getRandom("experience", 2),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 1));

        Resume resume37 = new Resume("Associate Degree",
                getRandom("skill", 4),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume38 = new Resume("Bachelor's Degree",
                getRandom("skill", 6),
                getRandom("experience", 3),
                getRandom("certification", 3),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 1));

        Resume resume39 = new Resume("Master's Degree",
                getRandom("skill", 7),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 2),
                getRandom("award", 3));

        Resume resume40 = new Resume("Associate Degree",
                getRandom("skill", 4),
                getRandom("experience", 2),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume41 = new Resume("Doctorate (PhD)",
                getRandom("skill", 7),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume42 = new Resume("Diploma",
                getRandom("skill", 5),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 4),
                getRandom("award", 1));

        Resume resume43 = new Resume("Bachelor's Degree",
                getRandom("skill", 6),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 2),
                getRandom("award", 2));

        Resume resume44 = new Resume("Master's Degree",
                getRandom("skill", 5),
                getRandom("experience", 3),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 3));

        Resume resume45 = new Resume("Doctorate (PhD)",
                getRandom("skill", 7),
                getRandom("experience", 4),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 4),
                getRandom("award", 3));

        Resume resume46 = new Resume("Associate Degree",
                getRandom("skill", 5),
                getRandom("experience", 2),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 2),
                getRandom("award", 1));

        Resume resume47 = new Resume("Bachelor's Degree",
                getRandom("skill", 6),
                getRandom("experience", 3),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume48 = new Resume("Diploma",
                getRandom("skill", 4),
                getRandom("experience", 2),
                getRandom("certification", 3),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume49 = new Resume("Master's Degree",
                getRandom("skill", 6),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 2),
                getRandom("award", 1));

        Resume resume50 = new Resume("Bachelor's Degree",
                getRandom("skill", 5),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume51 = new Resume("Diploma",
                getRandom("skill", 4),
                getRandom("experience", 2),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 2),
                getRandom("award", 3));

        Resume resume52 = new Resume("Doctorate (PhD)",
                getRandom("skill", 7),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume53 = new Resume("Associate Degree",
                getRandom("skill", 5),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 1));

        Resume resume54 = new Resume("Bachelor's Degree",
                getRandom("skill", 6),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 2),
                getRandom("award", 3));

        Resume resume55 = new Resume("Doctorate (PhD)",
                getRandom("skill", 7),
                getRandom("experience", 4),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume56 = new Resume("Diploma",
                getRandom("skill", 4),
                getRandom("experience", 2),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 1));

        Resume resume57 = new Resume("Master's Degree",
                getRandom("skill", 6),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 2),
                getRandom("language", 4),
                getRandom("award", 3));

        Resume resume58 = new Resume("Associate Degree",
                getRandom("skill", 5),
                getRandom("experience", 2),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 2),
                getRandom("award", 2));

        Resume resume59 = new Resume("Bachelor's Degree",
                getRandom("skill", 6),
                getRandom("experience", 3),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 2),
                getRandom("award", 3));

        Resume resume60 = new Resume("Diploma",
                getRandom("skill", 4),
                getRandom("experience", 2),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 1));

        Resume resume61 = new Resume("Master's Degree",
                getRandom("skill", 6),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume62 = new Resume("Doctorate (PhD)",
                getRandom("skill", 7),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 4),
                getRandom("award", 3));

        Resume resume63 = new Resume("Bachelor's Degree",
                getRandom("skill", 5),
                getRandom("experience", 3),
                getRandom("certification", 3),
                getRandom("project", 2),
                getRandom("language", 2),
                getRandom("award", 2));

        Resume resume64 = new Resume("Associate Degree",
                getRandom("skill", 4),
                getRandom("experience", 2),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 1));

        Resume resume65 = new Resume("Master's Degree",
                getRandom("skill", 6),
                getRandom("experience", 3),
                getRandom("certification", 3),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume66 = new Resume("Diploma",
                getRandom("skill", 4),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 1));

        Resume resume67 = new Resume("Doctorate (PhD)",
                getRandom("skill", 7),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 2),
                getRandom("award", 3));

        Resume resume68 = new Resume("Bachelor's Degree",
                getRandom("skill", 5),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 2),
                getRandom("award", 1));

        Resume resume69 = new Resume("Master's Degree",
                getRandom("skill", 6),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume70 = new Resume("Diploma",
                getRandom("skill", 4),
                getRandom("experience", 2),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 2),
                getRandom("award", 1));

        Resume resume71 = new Resume("Doctorate (PhD)",
                getRandom("skill", 7),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 3));

        Resume resume72 = new Resume("Associate Degree",
                getRandom("skill", 5),
                getRandom("experience", 2),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 2),
                getRandom("award", 2));

        Resume resume73 = new Resume("Master's Degree",
                getRandom("skill", 6),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume74 = new Resume("Bachelor's Degree",
                getRandom("skill", 6),
                getRandom("experience", 3),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 4),
                getRandom("award", 2));

        Resume resume75 = new Resume("Diploma",
                getRandom("skill", 4),
                getRandom("experience", 2),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 2),
                getRandom("award", 1));

        Resume resume76 = new Resume("Associate Degree",
                getRandom("skill", 4),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 1));

        Resume resume77 = new Resume("Doctorate (PhD)",
                getRandom("skill", 7),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 3));

        Resume resume78 = new Resume("Master's Degree",
                getRandom("skill", 6),
                getRandom("experience", 4),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume79 = new Resume("Bachelor's Degree",
                getRandom("skill", 6),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 2),
                getRandom("award", 2));

        Resume resume80 = new Resume("Diploma",
                getRandom("skill", 5),
                getRandom("experience", 2),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 1));

        Resume resume81 = new Resume("Doctorate (PhD)",
                getRandom("skill", 7),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 4),
                getRandom("award", 3));

        Resume resume82 = new Resume("Associate Degree",
                getRandom("skill", 4),
                getRandom("experience", 2),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 2),
                getRandom("award", 2));

        Resume resume83 = new Resume("Bachelor's Degree",
                getRandom("skill", 6),
                getRandom("experience", 3),
                getRandom("certification", 3),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume84 = new Resume("Master's Degree",
                getRandom("skill", 6),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 3));

        Resume resume85 = new Resume("Diploma",
                getRandom("skill", 4),
                getRandom("experience", 2),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 2),
                getRandom("award", 1));

        Resume resume86 = new Resume("Doctorate (PhD)",
                getRandom("skill", 7),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 4),
                getRandom("award", 3));

        Resume resume87 = new Resume("Associate Degree",
                getRandom("skill", 4),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume88 = new Resume("Bachelor's Degree",
                getRandom("skill", 6),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume89 = new Resume("Master's Degree",
                getRandom("skill", 6),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume90 = new Resume("Doctorate (PhD)",
                getRandom("skill", 7),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 3));

        Resume resume91 = new Resume("Diploma",
                getRandom("skill", 4),
                getRandom("experience", 2),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 1));

        Resume resume92 = new Resume("Associate Degree",
                getRandom("skill", 5),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 2),
                getRandom("award", 2));

        Resume resume93 = new Resume("Bachelor's Degree",
                getRandom("skill", 6),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 2),
                getRandom("award", 2));

        Resume resume94 = new Resume("Master's Degree",
                getRandom("skill", 6),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 4),
                getRandom("award", 3));

        Resume resume95 = new Resume("Doctorate (PhD)",
                getRandom("skill", 7),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 2),
                getRandom("language", 3),
                getRandom("award", 3));

        Resume resume96 = new Resume("Diploma",
                getRandom("skill", 4),
                getRandom("experience", 3),
                getRandom("certification", 2),
                getRandom("project", 2),
                getRandom("language", 2),
                getRandom("award", 1));

        Resume resume97 = new Resume("Associate Degree",
                getRandom("skill", 5),
                getRandom("experience", 2),
                getRandom("certification", 2),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 2));

        Resume resume98 = new Resume("Bachelor's Degree",
                getRandom("skill", 6),
                getRandom("experience", 3),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 2),
                getRandom("award", 2));

        Resume resume99 = new Resume("Master's Degree",
                getRandom("skill", 6),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 3),
                getRandom("award", 3));

        Resume resume100 = new Resume("Doctorate (PhD)",
                getRandom("skill", 7),
                getRandom("experience", 4),
                getRandom("certification", 3),
                getRandom("project", 3),
                getRandom("language", 4),
                getRandom("award", 3));

        // Create Applicant
        Applicant applicant1 = new Applicant("Kuala Lumpur, Malaysia", "www.ahmaddevportfolio.com", "Hybrid", "Full-Time",
                5, "RM6,000 - RM7,500", true,
                "Available Immediately", resume1, new DoublyLinkedList<>(),
                "A001", "Ahmad Razak", new GregorianCalendar(1990, Calendar.MAY, 15).getTime(),
                "Male", "12 Jalan Ampang, Kuala Lumpur, Malaysia", "900515-14-5678", "+60 12-3456789", "ahmad@example.com",
                "@ahmad_dev", "Married");

        Applicant applicant2 = new Applicant("Petaling Jaya, Malaysia", "www.liuxinuiux.com", "Remote", "Part-Time",
                3, "RM4,500 - RM6,000", false,
                "Available in 1 Month", resume2, new DoublyLinkedList<>(),
                "A002", "Liu Xin", new GregorianCalendar(1995, Calendar.FEBRUARY, 28).getTime(),
                "Female", "18 Jalan SS2, Petaling Jaya, Malaysia", "950228-08-7654", "+60 16-7890123", "liuxin@example.com",
                "@liuxin_uiux", "Single");

        Applicant applicant3 = new Applicant("George Town, Malaysia", "www.suryafinance.com", "On-Site", "Full-Time",
                7, "RM7500 and above", false,
                "Available in 2 Weeks", resume3, new DoublyLinkedList<>(),
                "A003", "Surya Krishnan", new GregorianCalendar(1987, Calendar.AUGUST, 10).getTime(),
                "Male", "45 Lebuh Chulia, George Town, Malaysia", "870810-07-4321", "+60 19-8765432", "surya@example.com",
                "@surya_finance", "Married");

        Applicant applicant4 = new Applicant("Johor Bahru, Malaysia", "www.ayeshadatascience.com", "Remote", "Contract",
                4, "RM6,000 - RM7,500", true,
                "Available in 3 Months", resume4, new DoublyLinkedList<>(),
                "A004", "Ayesha Tan", new GregorianCalendar(1992, Calendar.DECEMBER, 5).getTime(),
                "Female", "78 Jalan Tebrau, Johor Bahru, Malaysia", "921205-01-8765", "+60 17-6543210", "ayesha@example.com",
                "@ayesha_data", "Single");

        Applicant applicant5 = new Applicant("Shah Alam, Malaysia", "www.danielmarketing.com", "Hybrid", "Full-Time",
                6, "RM4,500 - RM6,000", false,
                "Available Immediately", resume5, new DoublyLinkedList<>(),
                "A005", "Daniel Nair", new GregorianCalendar(1988, Calendar.APRIL, 20).getTime(),
                "Male", "23 Persiaran Raja Muda, Shah Alam, Malaysia", "880420-10-3456", "+60 13-5678901", "daniel@example.com",
                "@daniel_marketing", "Married");

        Applicant applicant6 = new Applicant(
                "Kuala Lumpur", "www.zarinawebdesigns.com", "Remote", "Full-Time",
                2, "RM3,500 - RM4,500", false, "Within 1 Month", resume6, new DoublyLinkedList<>(),
                "A006", "Zarina Osman", new GregorianCalendar(1998, Calendar.JULY, 12).getTime(),
                "Female", "22 Jalan Tun Razak, Kuala Lumpur, Malaysia", "980712-10-1122", "+60 12-9988776", "zarina@example.com",
                "@zarina_web", "Single"
        );

        Applicant applicant7 = new Applicant(
                "Sabah", "www.hakimdataanalyst.com", "On-Site", "Full-Time",
                4, "RM4,500 - RM6,000", true, "Immediate", resume7, new DoublyLinkedList<>(),
                "A007", "Hakim Abdullah", new GregorianCalendar(1991, Calendar.MARCH, 3).getTime(),
                "Male", "15 Jalan Damai, Kota Kinabalu, Malaysia", "910303-12-3344", "+60 14-5566778", "hakim@example.com",
                "@hakim_analytics", "Married"
        );

        Applicant applicant8 = new Applicant(
                "Negeri Sembilan", "www.nurulcreative.com", "Hybrid", "Part-Time",
                1, "RM2,500 - RM3,500", false, "Within 2 Weeks", resume8, new DoublyLinkedList<>(),
                "A008", "Nurul Izzah", new GregorianCalendar(1999, Calendar.NOVEMBER, 21).getTime(),
                "Female", "50 Jalan Rasah, Seremban, Malaysia", "991121-05-4455", "+60 11-2233445", "nurul@example.com",
                "@nurul_creative", "Single"
        );

        Applicant applicant9 = new Applicant(
                "Perak", "www.rajeshvfx.com", "On-Site", "Full-Time",
                5, "RM6,000 - RM7,500", true, "Within 1 Month", resume9, new DoublyLinkedList<>(),
                "A009", "Rajesh Kumar", new GregorianCalendar(1989, Calendar.SEPTEMBER, 9).getTime(),
                "Male", "89 Jalan Sultan Azlan Shah, Ipoh, Malaysia", "890909-06-5566", "+60 16-7788990", "rajesh@example.com",
                "@rajesh_vfx", "Married"
        );

        Applicant applicant10 = new Applicant(
                "Melaka", "www.sofiyaqa.com", "Remote", "Full-Time",
                3, "RM4,500 - RM6,000", false, "Within 1 Month", resume10, new DoublyLinkedList<>(),
                "A010", "Sofiya Rahman", new GregorianCalendar(1994, Calendar.JANUARY, 18).getTime(),
                "Female", "30 Jalan Hang Tuah, Melaka, Malaysia", "940118-04-6677", "+60 13-3322110", "sofiya@example.com",
                "@sofiya_qa", "Single"
        );

        Applicant applicant11 = new Applicant(
                "Terengganu", "www.anuarfullstack.com", "Hybrid", "Full-Time",
                6, "RM6,000 - RM7,500", true, "Immediate", resume11, new DoublyLinkedList<>(),
                "A011", "Anuar Salleh", new GregorianCalendar(1986, Calendar.JUNE, 30).getTime(),
                "Male", "71 Jalan Sultan Ismail, Kuala Terengganu, Malaysia", "860630-11-7788", "+60 17-8899001", "anuar@example.com",
                "@anuar_fullstack", "Married"
        );

        Applicant applicant12 = new Applicant(
                "Perlis", "www.jessicalocalisation.com", "Remote", "Part-Time",
                2, "RM3,500 - RM4,500", false, "Within 1 Month", resume12, new DoublyLinkedList<>(),
                "A012", "Jessica Tan", new GregorianCalendar(1997, Calendar.APRIL, 5).getTime(),
                "Female", "12 Jalan Sena, Kangar, Malaysia", "970405-09-8899", "+60 15-6677889", "jessica@example.com",
                "@jess_localise", "Single"
        );

        Applicant applicant13 = new Applicant(
                "Kelantan", "www.fadzildatabase.com", "On-Site", "Full-Time",
                7, "RM7,500 and above", true, "Within 1 Month", resume13, new DoublyLinkedList<>(),
                "A013", "Fadzil Yusof", new GregorianCalendar(1985, Calendar.MAY, 25).getTime(),
                "Male", "55 Jalan Telipot, Kota Bharu, Malaysia", "850525-03-9900", "+60 14-4455667", "fadzil@example.com",
                "@fadzil_dbadmin", "Married"
        );

        Applicant applicant14 = new Applicant(
                "Sarawak", "www.ainulproject.com", "Hybrid", "Full-Time",
                4, "RM5,500 - RM7,000", false, "Within 2 Months", resume14, new DoublyLinkedList<>(),
                "A014", "Ainul Faizah", new GregorianCalendar(1993, Calendar.OCTOBER, 2).getTime(),
                "Female", "88 Jalan Satok, Kuching, Malaysia", "931002-13-1112", "+60 12-1234567", "ainul@example.com",
                "@ainul_pm", "Single"
        );

        Applicant applicant15 = new Applicant(
                "Putrajaya", "www.imranml.com", "Remote", "Full-Time",
                5, "RM8,000 - RM10,000", true, "Immediate", resume15, new DoublyLinkedList<>(),
                "A015", "Imran Mahmud", new GregorianCalendar(1984, Calendar.DECEMBER, 15).getTime(),
                "Male", "10 Jalan Diplomatik, Putrajaya, Malaysia", "841215-14-1213", "+60 19-1010101", "imran@example.com",
                "@imran_ml", "Married"
        );

        Applicant applicant16 = new Applicant(
                "Labuan", "www.syedcybersec.com", "Remote", "Full-Time",
                3, "RM5,000 - RM6,500", false, "Within 1 Month", resume16, new DoublyLinkedList<>(),
                "A016", "Syed Ali", new GregorianCalendar(1992, Calendar.AUGUST, 14).getTime(),
                "Male", "27 Jalan Merdeka, Labuan, Malaysia", "920814-12-0001", "+60 13-8888001", "syed@example.com",
                "@syed_cybersec", "Married"
        );

        Applicant applicant17 = new Applicant(
                "Selangor", "www.emilycontent.com", "Hybrid", "Full-Time",
                2, "RM3,800 - RM4,200", false, "Within 1 Month", resume17, new DoublyLinkedList<>(),
                "A017", "Emily Chong", new GregorianCalendar(1996, Calendar.MARCH, 9).getTime(),
                "Female", "92 Jalan Semarak, Klang, Malaysia", "960309-10-2323", "+60 11-9988776", "emily@example.com",
                "@emily_content", "Single"
        );

        Applicant applicant18 = new Applicant(
                "Penang", "www.thineshproduct.com", "On-Site", "Full-Time",
                6, "RM6,500 - RM8,000", true, "Within 2 Weeks", resume18, new DoublyLinkedList<>(),
                "A018", "Thinesh Raj", new GregorianCalendar(1987, Calendar.JULY, 19).getTime(),
                "Male", "39 Jalan Perak, George Town, Malaysia", "870719-07-5522", "+60 18-6677885", "thinesh@example.com",
                "@thinesh_pm", "Married"
        );

        Applicant applicant19 = new Applicant(
                "Johor", "www.mariamuxresearch.com", "Remote", "Part-Time",
                4, "RM4,000 - RM5,000", false, "Within 1 Month", resume19, new DoublyLinkedList<>(),
                "A019", "Mariam Isa", new GregorianCalendar(1993, Calendar.SEPTEMBER, 12).getTime(),
                "Female", "40 Jalan Larkin, Johor Bahru, Malaysia", "930912-01-3344", "+60 10-1122334", "mariam@example.com",
                "@mariam_ux", "Single"
        );

        Applicant applicant20 = new Applicant(
                "Kuala Lumpur", "www.farhaninfra.com", "On-Site", "Full-Time",
                7, "RM9,000 - RM10,500", true, "Immediate", resume20, new DoublyLinkedList<>(),
                "A020", "Farhan Zain", new GregorianCalendar(1985, Calendar.OCTOBER, 20).getTime(),
                "Male", "78 Jalan Sultan, Kuala Lumpur, Malaysia", "851020-14-1212", "+60 16-3216548", "farhan@example.com",
                "@farhan_engineer", "Married"
        );

        Applicant applicant21 = new Applicant(
                "Melaka", "www.shalinihr.com", "Remote", "Full-Time",
                3, "RM4,500 - RM5,800", false, "Within 2 Months", resume21, new DoublyLinkedList<>(),
                "A021", "Shalini Menon", new GregorianCalendar(1994, Calendar.APRIL, 16).getTime(),
                "Female", "33 Jalan Hang Lekiu, Melaka, Malaysia", "940416-04-3345", "+60 12-7894561", "shalini@example.com",
                "@shalini_hr", "Single"
        );

        Applicant applicant22 = new Applicant(
                "Sarawak", "www.alfianiot.com", "Hybrid", "Full-Time",
                5, "RM6,000 - RM7,200", true, "Within 1 Month", resume22, new DoublyLinkedList<>(),
                "A022", "Alfian Hamid", new GregorianCalendar(1990, Calendar.JUNE, 5).getTime(),
                "Male", "41 Jalan Padungan, Kuching, Malaysia", "900605-13-4466", "+60 14-8899222", "alfian@example.com",
                "@alfian_iot", "Married"
        );

        Applicant applicant23 = new Applicant(
                "Perak", "www.yusriwebapps.com", "Remote", "Full-Time",
                6, "RM5,800 - RM7,000", false, "Within 1 Month", resume23, new DoublyLinkedList<>(),
                "A023", "Yusri Hassan", new GregorianCalendar(1988, Calendar.FEBRUARY, 27).getTime(),
                "Male", "88 Jalan Tambun, Ipoh, Malaysia", "880227-06-5566", "+60 17-1234567", "yusri@example.com",
                "@yusri_web", "Married"
        );

        Applicant applicant24 = new Applicant(
                "Kelantan", "www.noraisahmlops.com", "On-Site", "Full-Time",
                4, "RM6,000 - RM7,500", true, "Immediate", resume24, new DoublyLinkedList<>(),
                "A024", "Noraisah Mat", new GregorianCalendar(1991, Calendar.NOVEMBER, 3).getTime(),
                "Female", "53 Jalan Wakaf, Kota Bharu, Malaysia", "911103-03-7788", "+60 11-8899775", "noraisah@example.com",
                "@noraisah_mlops", "Single"
        );

        Applicant applicant25 = new Applicant(
                "Putrajaya", "www.adamrobotics.com", "Hybrid", "Full-Time",
                8, "RM10,000 - RM12,000", true, "Immediate", resume25, new DoublyLinkedList<>(),
                "A025", "Adam Faiz", new GregorianCalendar(1983, Calendar.DECEMBER, 28).getTime(),
                "Male", "8 Jalan Diplomatik, Putrajaya, Malaysia", "831228-14-8888", "+60 19-1112223", "adam@example.com",
                "@adam_robotics", "Married"
        );

        Applicant applicant26 = new Applicant(
                "Sabah", "www.elinmobile.com", "Remote", "Part-Time",
                2, "RM3,200 - RM4,000", false, "Within 1 Month", resume26, new DoublyLinkedList<>(),
                "A026", "Elin George", new GregorianCalendar(1997, Calendar.JANUARY, 10).getTime(),
                "Female", "21 Jalan Tanjung Aru, Kota Kinabalu, Malaysia", "970110-12-2233", "+60 15-3344556", "elin@example.com",
                "@elin_mobile", "Single"
        );

        Applicant applicant27 = new Applicant(
                "Negeri Sembilan", "www.juliangamingdev.com", "Hybrid", "Full-Time",
                3, "RM4,000 - RM5,500", false, "Within 2 Weeks", resume27, new DoublyLinkedList<>(),
                "A027", "Julian Lim", new GregorianCalendar(1995, Calendar.MAY, 7).getTime(),
                "Male", "55 Jalan Forest Heights, Seremban, Malaysia", "950507-05-4567", "+60 16-7788992", "julian@example.com",
                "@julian_gamedev", "Single"
        );

        Applicant applicant28 = new Applicant(
                "Labuan", "www.latifblockchain.com", "On-Site", "Full-Time",
                5, "RM7,000 - RM8,500", true, "Within 1 Month", resume28, new DoublyLinkedList<>(),
                "A028", "Latif Rozlan", new GregorianCalendar(1989, Calendar.SEPTEMBER, 23).getTime(),
                "Male", "90 Jalan Merdeka, Labuan, Malaysia", "890923-12-2233", "+60 13-9999988", "latif@example.com",
                "@latif_chain", "Married"
        );

        Applicant applicant29 = new Applicant(
                "Johor", "www.aidasecurity.com", "Remote", "Full-Time",
                4, "RM5,000 - RM6,000", false, "Within 2 Months", resume29, new DoublyLinkedList<>(),
                "A029", "Aida Yeo", new GregorianCalendar(1992, Calendar.APRIL, 2).getTime(),
                "Female", "65 Jalan Skudai, Johor Bahru, Malaysia", "920402-01-5566", "+60 12-2244667", "aida@example.com",
                "@aida_infosec", "Single"
        );

        Applicant applicant30 = new Applicant(
                "Kuala Lumpur", "www.hanafibigdata.com", "Hybrid", "Full-Time",
                6, "RM7,500 - RM9,000", true, "Immediate", resume30, new DoublyLinkedList<>(),
                "A030", "Hanifi Zakaria", new GregorianCalendar(1986, Calendar.JULY, 15).getTime(),
                "Male", "101 Jalan Taman Desa, Kuala Lumpur, Malaysia", "860715-14-3344", "+60 18-1122334", "hanifi@example.com",
                "@hanifi_bigdata", "Married"
        );

        Applicant applicant31 = new Applicant(
                "Perlis", "www.fatimafrontend.com", "Remote", "Part-Time",
                2, "RM3,500 - RM4,500", false, "Within 1 Month", resume31, new DoublyLinkedList<>(),
                "A031", "Fatima Abdullah", new GregorianCalendar(1998, Calendar.JUNE, 25).getTime(),
                "Female", "11 Jalan Sena, Kangar, Malaysia", "980625-09-5566", "+60 10-4433221", "fatima@example.com",
                "@fatima_frontend", "Single"
        );

        Applicant applicant32 = new Applicant(
                "Selangor", "www.mikhailcloud.com", "On-Site", "Full-Time",
                5, "RM8,000 - RM9,500", true, "Within 1 Month", resume32, new DoublyLinkedList<>(),
                "A032", "Mikhail Ong", new GregorianCalendar(1987, Calendar.MARCH, 13).getTime(),
                "Male", "88 Jalan SS22, Petaling Jaya, Malaysia", "870313-10-1111", "+60 17-9988774", "mikhail@example.com",
                "@mikhail_cloud", "Married"
        );

        Applicant applicant33 = new Applicant(
                "Penang", "www.hazelnlp.com", "Remote", "Full-Time",
                4, "RM6,500 - RM7,800", false, "Immediate", resume33, new DoublyLinkedList<>(),
                "A033", "Hazel Goh", new GregorianCalendar(1991, Calendar.FEBRUARY, 24).getTime(),
                "Female", "20 Jalan Burma, George Town, Malaysia", "910224-07-1234", "+60 12-3444555", "hazel@example.com",
                "@hazel_nlp", "Single"
        );

        Applicant applicant34 = new Applicant(
                "Johor", "www.najibmobileapps.com", "Hybrid", "Full-Time",
                3, "RM4,800 - RM6,000", false, "Within 2 Weeks", resume34, new DoublyLinkedList<>(),
                "A034", "Najib Musa", new GregorianCalendar(1993, Calendar.MAY, 30).getTime(),
                "Male", "42 Jalan Pasir Gudang, Johor Bahru, Malaysia", "930530-01-2211", "+60 16-5677890", "najib@example.com",
                "@najib_apps", "Single"
        );

        Applicant applicant35 = new Applicant(
                "Sabah", "www.alinasrecruitment.com", "Remote", "Full-Time",
                5, "RM6,200 - RM7,300", true, "Within 1 Month", resume35, new DoublyLinkedList<>(),
                "A035", "Alina Rahim", new GregorianCalendar(1990, Calendar.SEPTEMBER, 8).getTime(),
                "Female", "76 Jalan Signal Hill, Kota Kinabalu, Malaysia", "900908-12-3344", "+60 19-5566778", "alina@example.com",
                "@alina_recruit", "Married"
        );

        Applicant applicant36 = new Applicant(
                "Selangor", "www.zamirdata.com", "Remote", "Full-Time",
                4, "RM6,000 - RM7,500", true, "Immediate", resume36, new DoublyLinkedList<>(),
                "A036", "Zamir Hussein", new GregorianCalendar(1990, Calendar.OCTOBER, 15).getTime(),
                "Male", "88 Jalan Setia Alam, Shah Alam, Malaysia", "901015-10-1122", "+60 12-3344556", "zamir@example.com",
                "@zamir_data", "Married"
        );

        Applicant applicant37 = new Applicant(
                "Perak", "www.amirultesting.com", "On-Site", "Full-Time",
                3, "RM5,000 - RM6,200", false, "Within 1 Month", resume37, new DoublyLinkedList<>(),
                "A037", "Amirul Ikhwan", new GregorianCalendar(1994, Calendar.MARCH, 11).getTime(),
                "Male", "19 Jalan Kampar, Ipoh, Malaysia", "940311-06-5566", "+60 16-9988775", "amirul@example.com",
                "@amirul_qa", "Single"
        );

        Applicant applicant38 = new Applicant(
                "Kelantan", "www.suhanidigital.com", "Hybrid", "Full-Time",
                2, "RM4,000 - RM5,200", false, "Within 2 Weeks", resume38, new DoublyLinkedList<>(),
                "A038", "Suhani Abdul", new GregorianCalendar(1997, Calendar.JUNE, 4).getTime(),
                "Female", "33 Jalan Kubang Kerian, Kota Bharu, Malaysia", "970604-03-7788", "+60 11-8899001", "suhani@example.com",
                "@suhani_digital", "Single"
        );

        Applicant applicant39 = new Applicant(
                "Penang", "www.harrisuiux.com", "Remote", "Full-Time",
                4, "RM5,800 - RM7,000", true, "Immediate", resume39, new DoublyLinkedList<>(),
                "A039", "Harris Tan", new GregorianCalendar(1991, Calendar.SEPTEMBER, 28).getTime(),
                "Male", "62 Jalan Tanjung Tokong, George Town, Malaysia", "910928-07-3344", "+60 18-4455667", "harris@example.com",
                "@harris_uiux", "Single"
        );

        Applicant applicant40 = new Applicant(
                "Melaka", "www.lailasoftware.com", "On-Site", "Full-Time",
                5, "RM7,000 - RM8,200", true, "Within 1 Month", resume40, new DoublyLinkedList<>(),
                "A040", "Laila Samad", new GregorianCalendar(1989, Calendar.MAY, 17).getTime(),
                "Female", "57 Jalan Tun Perak, Melaka, Malaysia", "890517-04-4455", "+60 14-7788991", "laila@example.com",
                "@laila_software", "Married"
        );

        Applicant applicant41 = new Applicant(
                "Sarawak", "www.ariffml.com", "Remote", "Part-Time",
                3, "RM5,000 - RM6,000", false, "Within 1 Month", resume41, new DoublyLinkedList<>(),
                "A041", "Ariff Ghani", new GregorianCalendar(1993, Calendar.FEBRUARY, 5).getTime(),
                "Male", "90 Jalan Satok, Kuching, Malaysia", "930205-13-2233", "+60 13-5544332", "ariff@example.com",
                "@ariff_ml", "Single"
        );

        Applicant applicant42 = new Applicant(
                "Sabah", "www.intanwebdesign.com", "Hybrid", "Full-Time",
                2, "RM4,200 - RM5,300", false, "Within 2 Weeks", resume42, new DoublyLinkedList<>(),
                "A042", "Intan Zulkifli", new GregorianCalendar(1996, Calendar.JULY, 9).getTime(),
                "Female", "13 Jalan Api-Api, Kota Kinabalu, Malaysia", "960709-12-6655", "+60 15-6677889", "intan@example.com",
                "@intan_web", "Single"
        );

        Applicant applicant43 = new Applicant(
                "Johor", "www.shahrulmldev.com", "On-Site", "Full-Time",
                6, "RM7,500 - RM9,000", true, "Immediate", resume43, new DoublyLinkedList<>(),
                "A043", "Shahrul Nizam", new GregorianCalendar(1988, Calendar.NOVEMBER, 21).getTime(),
                "Male", "71 Jalan Kempas, Johor Bahru, Malaysia", "881121-01-1122", "+60 19-7788994", "shahrul@example.com",
                "@shahrul_ml", "Married"
        );

        Applicant applicant44 = new Applicant(
                "Kuala Lumpur", "www.aisyahux.com", "Remote", "Full-Time",
                3, "RM5,200 - RM6,800", false, "Within 1 Month", resume44, new DoublyLinkedList<>(),
                "A044", "Aisyah Rahman", new GregorianCalendar(1995, Calendar.DECEMBER, 1).getTime(),
                "Female", "25 Jalan Bangsar, Kuala Lumpur, Malaysia", "951201-14-7788", "+60 12-8877665", "aisyah@example.com",
                "@aisyah_ux", "Single"
        );

        Applicant applicant45 = new Applicant(
                "Terengganu", "www.fadhliiot.com", "Hybrid", "Full-Time",
                4, "RM6,200 - RM7,400", true, "Within 2 Weeks", resume45, new DoublyLinkedList<>(),
                "A045", "Fadhli Musa", new GregorianCalendar(1992, Calendar.AUGUST, 19).getTime(),
                "Male", "44 Jalan Batu Buruk, Kuala Terengganu, Malaysia", "920819-11-4433", "+60 17-3322114", "fadhli@example.com",
                "@fadhli_iot", "Married"
        );

        Applicant applicant46 = new Applicant("Perlis", "www.izzahdev.com", "Remote", "Part-Time",
                2, "RM3,800 - RM4,500", false, "Within 2 Weeks", resume46, new DoublyLinkedList<>(),
                "A046", "Izzah Karim", new GregorianCalendar(1998, Calendar.MARCH, 30).getTime(),
                "Female", "12 Jalan Raja Syed Alwi, Kangar, Malaysia", "980330-02-1234", "+60 12-7654321", "izzah@example.com",
                "@izzah_dev", "Single");

        Applicant applicant47 = new Applicant("Negeri Sembilan", "www.ridzuansoftware.com", "Hybrid", "Full-Time",
                5, "RM6,800 - RM8,000", true, "Immediate", resume47, new DoublyLinkedList<>(),
                "A047", "Ridzuan Hamzah", new GregorianCalendar(1987, Calendar.MAY, 9).getTime(),
                "Male", "20 Jalan Seremban, Seremban, Malaysia", "870509-05-7890", "+60 13-8888777", "ridzuan@example.com",
                "@ridzuan_software", "Married");

        Applicant applicant48 = new Applicant("Selangor", "www.fatimabrand.com", "Remote", "Full-Time",
                3, "RM5,000 - RM6,500", false, "Within 1 Month", resume48, new DoublyLinkedList<>(),
                "A048", "Fatima Zahra", new GregorianCalendar(1996, Calendar.DECEMBER, 17).getTime(),
                "Female", "34 Jalan SS15, Subang Jaya, Malaysia", "961217-10-2345", "+60 17-4455667", "fatima@example.com",
                "@fatima_brand", "Single");

        Applicant applicant49 = new Applicant("Pahang", "www.azmansoftware.com", "On-Site", "Full-Time",
                4, "RM6,500 - RM7,700", true, "Within 2 Weeks", resume49, new DoublyLinkedList<>(),
                "A049", "Azman Othman", new GregorianCalendar(1989, Calendar.SEPTEMBER, 6).getTime(),
                "Male", "91 Jalan Mahkota, Kuantan, Malaysia", "890906-06-7788", "+60 19-9988776", "azman@example.com",
                "@azman_software", "Married");

        Applicant applicant50 = new Applicant("Kelantan", "www.shazatech.com", "Remote", "Full-Time",
                5, "RM6,200 - RM7,000", true, "Immediate", resume50, new DoublyLinkedList<>(),
                "A050", "Shaza Aziz", new GregorianCalendar(1993, Calendar.JULY, 12).getTime(),
                "Female", "15 Jalan Wakaf Mek Zainab, Kota Bharu, Malaysia", "930712-03-5566", "+60 15-6677884", "shaza@example.com",
                "@shaza_tech", "Single");

        Applicant applicant51 = new Applicant("Penang", "www.hakimops.com", "Hybrid", "Full-Time",
                6, "RM7,500 - RM8,800", true, "Within 1 Month", resume51, new DoublyLinkedList<>(),
                "A051", "Hakim Faris", new GregorianCalendar(1986, Calendar.JANUARY, 23).getTime(),
                "Male", "70 Jalan Air Itam, George Town, Malaysia", "860123-07-3344", "+60 11-3344556", "hakim@example.com",
                "@hakim_ops", "Married");

        Applicant applicant52 = new Applicant("Terengganu", "www.amnasoft.com", "Remote", "Part-Time",
                2, "RM3,500 - RM4,500", false, "Within 2 Weeks", resume52, new DoublyLinkedList<>(),
                "A052", "Amna Salleh", new GregorianCalendar(1999, Calendar.NOVEMBER, 10).getTime(),
                "Female", "29 Jalan Tok Jembal, Kuala Terengganu, Malaysia", "991110-11-7788", "+60 12-7788996", "amna@example.com",
                "@amna_soft", "Single");

        Applicant applicant53 = new Applicant("Johor", "www.zulkitech.com", "On-Site", "Full-Time",
                4, "RM6,000 - RM7,200", true, "Immediate", resume53, new DoublyLinkedList<>(),
                "A053", "Zulki Ramli", new GregorianCalendar(1991, Calendar.APRIL, 2).getTime(),
                "Male", "52 Jalan Molek, Johor Bahru, Malaysia", "910402-01-1234", "+60 19-8877665", "zulki@example.com",
                "@zulki_tech", "Married");

        Applicant applicant54 = new Applicant("Melaka", "www.raniadesign.com", "Hybrid", "Full-Time",
                3, "RM5,500 - RM6,800", false, "Within 1 Month", resume54, new DoublyLinkedList<>(),
                "A054", "Rania Yusuf", new GregorianCalendar(1994, Calendar.AUGUST, 5).getTime(),
                "Female", "36 Jalan Melaka Raya, Melaka, Malaysia", "940805-04-1122", "+60 13-6677885", "rania@example.com",
                "@rania_design", "Single");

        Applicant applicant55 = new Applicant("Sabah", "www.miqdadtech.com", "Remote", "Full-Time",
                5, "RM6,800 - RM8,000", true, "Within 2 Weeks", resume55, new DoublyLinkedList<>(),
                "A055", "Miqdad Rahim", new GregorianCalendar(1988, Calendar.MAY, 20).getTime(),
                "Male", "61 Jalan Tuaran, Kota Kinabalu, Malaysia", "880520-12-9988", "+60 18-5544332", "miqdad@example.com",
                "@miqdad_tech", "Married");

        Applicant applicant56 = new Applicant("Kuala Lumpur", "www.liyanaai.com", "Hybrid", "Full-Time",
                4, "RM6,000 - RM7,300", true, "Immediate", resume56, new DoublyLinkedList<>(),
                "A056", "Liyana Ismail", new GregorianCalendar(1990, Calendar.JUNE, 25).getTime(),
                "Female", "83 Jalan TAR, Kuala Lumpur, Malaysia", "900625-14-5566", "+60 16-2233445", "liyana@example.com",
                "@liyana_ai", "Married");

        Applicant applicant57 = new Applicant("Perak", "www.izzatdata.com", "Remote", "Part-Time",
                2, "RM4,200 - RM5,200", false, "Within 1 Month", resume57, new DoublyLinkedList<>(),
                "A057", "Izzat Faiz", new GregorianCalendar(1997, Calendar.SEPTEMBER, 11).getTime(),
                "Male", "17 Jalan Chemor, Ipoh, Malaysia", "970911-06-7766", "+60 15-3344552", "izzat@example.com",
                "@izzat_data", "Single");

        Applicant applicant58 = new Applicant("Negeri Sembilan", "www.hanadesign.com", "Hybrid", "Full-Time",
                3, "RM5,500 - RM6,500", false, "Within 2 Weeks", resume58, new DoublyLinkedList<>(),
                "A058", "Hana Alias", new GregorianCalendar(1995, Calendar.OCTOBER, 14).getTime(),
                "Female", "48 Jalan Sendayan, Seremban, Malaysia", "951014-05-1122", "+60 14-6655443", "hana@example.com",
                "@hana_design", "Single");

        Applicant applicant59 = new Applicant("Selangor", "www.adambackend.com", "Remote", "Full-Time",
                6, "RM7,200 - RM8,500", true, "Immediate", resume59, new DoublyLinkedList<>(),
                "A059", "Adam Hilmi", new GregorianCalendar(1987, Calendar.MARCH, 7).getTime(),
                "Male", "58 Jalan Bukit Jelutong, Shah Alam, Malaysia", "870307-10-4433", "+60 19-6677883", "adam@example.com",
                "@adam_backend", "Married");

        Applicant applicant60 = new Applicant("Pulau Pinang", "www.maisarahtech.com", "Remote", "Full-Time",
                3, "RM5,500 - RM6,800", false, "Within 1 Month", resume60, new DoublyLinkedList<>(),
                "A060", "Maisarah Jamal", new GregorianCalendar(1994, Calendar.JANUARY, 29).getTime(),
                "Female", "27 Jalan Bayan Lepas, Bayan Baru, Malaysia", "940129-07-7788", "+60 11-2233446", "maisarah@example.com",
                "@maisarah_tech", "Single");

        Applicant applicant61 = new Applicant("Johor", "www.firdausnetwork.com", "Hybrid", "Full-Time",
                5, "RM6,700 - RM8,100", true, "Immediate", resume61, new DoublyLinkedList<>(),
                "A061", "Firdaus Zahari", new GregorianCalendar(1989, Calendar.APRIL, 12).getTime(),
                "Male", "90 Jalan Tampoi, Johor Bahru, Malaysia", "890412-01-5566", "+60 12-1234567", "firdaus@example.com",
                "@firdaus_net", "Married");

        Applicant applicant62 = new Applicant("Selangor", "www.sofeait.com", "Remote", "Full-Time",
                4, "RM6,000 - RM7,500", true, "Within 1 Month", resume62, new DoublyLinkedList<>(),
                "A062", "Sofea Anuar", new GregorianCalendar(1992, Calendar.DECEMBER, 1).getTime(),
                "Female", "27 Jalan USJ 11, Subang Jaya, Malaysia", "921201-10-2233", "+60 14-9988776", "sofea@example.com",
                "@sofea_it", "Single");

        Applicant applicant63 = new Applicant("Penang", "www.aliffsecurity.com", "On-Site", "Full-Time",
                6, "RM7,200 - RM8,600", true, "Immediate", resume63, new DoublyLinkedList<>(),
                "A063", "Aliff Syah", new GregorianCalendar(1988, Calendar.JULY, 19).getTime(),
                "Male", "32 Jalan Macalister, George Town, Malaysia", "880719-07-4433", "+60 13-2233445", "aliff@example.com",
                "@aliff_sec", "Married");

        Applicant applicant64 = new Applicant("Perak", "www.balqisux.com", "Remote", "Part-Time",
                2, "RM3,800 - RM4,900", false, "Within 1 Month", resume64, new DoublyLinkedList<>(),
                "A064", "Balqis Yusof", new GregorianCalendar(1997, Calendar.JUNE, 3).getTime(),
                "Female", "11 Jalan Kuala Kangsar, Ipoh, Malaysia", "970603-06-7788", "+60 15-2233446", "balqis@example.com",
                "@balqis_ux", "Single");

        Applicant applicant65 = new Applicant("Sabah", "www.hazimiot.com", "On-Site", "Full-Time",
                5, "RM6,500 - RM7,800", true, "Within 2 Weeks", resume65, new DoublyLinkedList<>(),
                "A065", "Hazim Shah", new GregorianCalendar(1991, Calendar.FEBRUARY, 11).getTime(),
                "Male", "56 Jalan Likas, Kota Kinabalu, Malaysia", "910211-12-6677", "+60 17-1122334", "hazim@example.com",
                "@hazim_iot", "Married");

        Applicant applicant66 = new Applicant("Kelantan", "www.mariamdata.com", "Remote", "Full-Time",
                3, "RM5,500 - RM6,500", false, "Within 1 Month", resume66, new DoublyLinkedList<>(),
                "A066", "Mariam Aziz", new GregorianCalendar(1995, Calendar.APRIL, 24).getTime(),
                "Female", "42 Jalan Kubang Kerian, Kota Bharu, Malaysia", "950424-03-2233", "+60 11-2233441", "mariam@example.com",
                "@mariam_data", "Single");

        Applicant applicant67 = new Applicant("Negeri Sembilan", "www.akmalweb.com", "Hybrid", "Full-Time",
                4, "RM6,000 - RM7,200", true, "Immediate", resume67, new DoublyLinkedList<>(),
                "A067", "Akmal Musa", new GregorianCalendar(1990, Calendar.SEPTEMBER, 16).getTime(),
                "Male", "19 Jalan Rasah, Seremban, Malaysia", "900916-05-4433", "+60 18-1122334", "akmal@example.com",
                "@akmal_web", "Married");

        Applicant applicant68 = new Applicant("Melaka", "www.ainfintech.com", "Remote", "Full-Time",
                3, "RM5,800 - RM6,900", false, "Within 1 Month", resume68, new DoublyLinkedList<>(),
                "A068", "Ain Kamal", new GregorianCalendar(1993, Calendar.NOVEMBER, 29).getTime(),
                "Female", "87 Jalan Tun Perak, Melaka, Malaysia", "931129-04-3344", "+60 19-8877665", "ain@example.com",
                "@ain_fintech", "Single");

        Applicant applicant69 = new Applicant("Kedah", "www.rayyanmedia.com", "On-Site", "Full-Time",
                6, "RM7,000 - RM8,400", true, "Immediate", resume69, new DoublyLinkedList<>(),
                "A069", "Rayyan Fikri", new GregorianCalendar(1986, Calendar.MARCH, 5).getTime(),
                "Male", "73 Jalan Langgar, Alor Setar, Malaysia", "860305-02-7788", "+60 13-4455667", "rayyan@example.com",
                "@rayyan_media", "Married");

        Applicant applicant70 = new Applicant("Terengganu", "www.nuruldesigns.com", "Remote", "Part-Time",
                2, "RM3,700 - RM4,500", false, "Within 2 Weeks", resume70, new DoublyLinkedList<>(),
                "A070", "Nurul Nadiah", new GregorianCalendar(1998, Calendar.MAY, 9).getTime(),
                "Female", "65 Jalan Tok Adis, Kuala Terengganu, Malaysia", "980509-11-3344", "+60 14-5566771", "nurul@example.com",
                "@nurul_design", "Single");

        Applicant applicant71 = new Applicant("Labuan", "www.ismailblockchain.com", "Hybrid", "Full-Time",
                5, "RM6,600 - RM7,800", true, "Immediate", resume71, new DoublyLinkedList<>(),
                "A071", "Ismail Harun", new GregorianCalendar(1989, Calendar.OCTOBER, 18).getTime(),
                "Male", "22 Jalan Merdeka, Labuan, Malaysia", "891018-12-2233", "+60 17-2233445", "ismail@example.com",
                "@ismail_block", "Married");

        Applicant applicant72 = new Applicant("Putrajaya", "www.haniffmarketing.com", "Remote", "Full-Time",
                3, "RM5,500 - RM6,800", false, "Within 1 Month", resume72, new DoublyLinkedList<>(),
                "A072", "Haniff Rosli", new GregorianCalendar(1994, Calendar.JULY, 22).getTime(),
                "Male", "39 Jalan Diplomatik, Putrajaya, Malaysia", "940722-14-6677", "+60 12-3344556", "haniff@example.com",
                "@haniff_marketing", "Single");

        Applicant applicant73 = new Applicant("Selangor", "www.sitiux.com", "Remote", "Full-Time",
                4, "RM6,000 - RM7,400", false, "Within 2 Weeks", resume73, new DoublyLinkedList<>(),
                "A073", "Siti Maisarah", new GregorianCalendar(1991, Calendar.MARCH, 1).getTime(),
                "Female", "80 Jalan Puchong, Puchong, Malaysia", "910301-10-8899", "+60 15-2233445", "siti@example.com",
                "@siti_ux", "Single");

        Applicant applicant74 = new Applicant("Pahang", "www.azruldigital.com", "Hybrid", "Full-Time",
                6, "RM7,200 - RM8,600", true, "Immediate", resume74, new DoublyLinkedList<>(),
                "A074", "Azrul Idris", new GregorianCalendar(1987, Calendar.AUGUST, 25).getTime(),
                "Male", "49 Jalan Bukit Sekilau, Kuantan, Malaysia", "870825-06-3344", "+60 16-1122334", "azrul@example.com",
                "@azrul_digital", "Married");

        Applicant applicant75 = new Applicant("Kuala Lumpur", "www.diyanait.com", "Remote", "Full-Time",
                3, "RM5,500 - RM6,700", false, "Within 1 Month", resume75, new DoublyLinkedList<>(),
                "A075", "Diyana Omar", new GregorianCalendar(1995, Calendar.SEPTEMBER, 15).getTime(),
                "Female", "18 Jalan Bukit Bintang, Kuala Lumpur, Malaysia", "950915-14-7788", "+60 11-9988776", "diyana@example.com",
                "@diyana_it", "Single");

        Applicant applicant76 = new Applicant("Perlis", "www.syafiqdata.com", "On-Site", "Full-Time",
                4, "RM6,100 - RM7,300", true, "Immediate", resume76, new DoublyLinkedList<>(),
                "A076", "Syafiq Ramli", new GregorianCalendar(1992, Calendar.NOVEMBER, 11).getTime(),
                "Male", "24 Jalan Padang Besar, Kangar, Malaysia", "921111-02-3344", "+60 13-4455667", "syafiq@example.com",
                "@syafiq_data", "Married");

        Applicant applicant77 = new Applicant("Pulau Pinang", "www.alyafinance.com", "Hybrid", "Full-Time",
                5, "RM6,800 - RM8,000", true, "Within 1 Month", resume77, new DoublyLinkedList<>(),
                "A077", "Alya Shafina", new GregorianCalendar(1990, Calendar.MAY, 8).getTime(),
                "Female", "92 Jalan Gelugor, George Town, Malaysia", "900508-07-5566", "+60 14-9988775", "alya@example.com",
                "@alya_finance", "Married");

        Applicant applicant78 = new Applicant("Johor", "www.nazrisoftware.com", "Remote", "Full-Time",
                4, "RM6,200 - RM7,400", false, "Immediate", resume78, new DoublyLinkedList<>(),
                "A078", "Nazri Ghani", new GregorianCalendar(1991, Calendar.JANUARY, 30).getTime(),
                "Male", "21 Jalan Larkin, Johor Bahru, Malaysia", "910130-01-1122", "+60 12-3344551", "nazri@example.com",
                "@nazri_soft", "Married");

        Applicant applicant79 = new Applicant("Kelantan", "www.salmadeveloper.com", "Remote", "Part-Time",
                2, "RM3,900 - RM4,800", false, "Within 2 Weeks", resume79, new DoublyLinkedList<>(),
                "A079", "Salma Fauziah", new GregorianCalendar(1999, Calendar.OCTOBER, 6).getTime(),
                "Female", "66 Jalan Sultan Yahya Petra, Kota Bharu, Malaysia", "991006-03-7788", "+60 17-2233442", "salma@example.com",
                "@salma_dev", "Single");

        Applicant applicant80 = new Applicant("Terengganu", "www.firdausdesigns.com", "Hybrid", "Full-Time",
                4, "RM6,300 - RM7,500", true, "Immediate", resume80, new DoublyLinkedList<>(),
                "A080", "Firdaus Khalid", new GregorianCalendar(1993, Calendar.FEBRUARY, 13).getTime(),
                "Male", "78 Jalan Sultan Omar, Kuala Terengganu, Malaysia", "930213-11-2233", "+60 18-3344557", "dfirdaus@example.com",
                "@firdaus_design", "Single");

        Applicant applicant81 = new Applicant("Selangor", "www.azwantech.com", "On-Site", "Full-Time",
                5, "RM6,800 - RM8,200", true, "Immediate", resume81, new DoublyLinkedList<>(),
                "A081", "Azwan Razak", new GregorianCalendar(1989, Calendar.MARCH, 10).getTime(),
                "Male", "55 Jalan Ampang, Klang, Malaysia", "890310-10-1234", "+60 13-8899776", "azwan@example.com",
                "@azwan_tech", "Married");

        Applicant applicant82 = new Applicant("Penang", "www.hazirahai.com", "Remote", "Part-Time",
                3, "RM4,100 - RM5,200", false, "Within 2 Weeks", resume82, new DoublyLinkedList<>(),
                "A082", "Hazirah Ain", new GregorianCalendar(1996, Calendar.AUGUST, 25).getTime(),
                "Female", "16 Jalan Tanjung Tokong, George Town, Malaysia", "960825-07-7788", "+60 12-7788990", "hazirah@example.com",
                "@hazirah_ai", "Single");

        Applicant applicant83 = new Applicant("Melaka", "www.ismailai.com", "Remote", "Full-Time",
                4, "RM5,900 - RM7,100", true, "Immediate", resume83, new DoublyLinkedList<>(),
                "A083", "Ismail Sabri", new GregorianCalendar(1992, Calendar.JUNE, 17).getTime(),
                "Male", "23 Jalan Tun Fatimah, Melaka, Malaysia", "920617-04-5544", "+60 11-3344551", "ismail@example.com",
                "@ismail_ai", "Single");

        Applicant applicant84 = new Applicant("Johor", "www.amalfinance.com", "Hybrid", "Full-Time",
                6, "RM7,300 - RM8,800", true, "Immediate", resume84, new DoublyLinkedList<>(),
                "A084", "Amal Husna", new GregorianCalendar(1988, Calendar.MAY, 5).getTime(),
                "Female", "102 Jalan Nusa Bestari, Johor Bahru, Malaysia", "880505-01-3344", "+60 17-1122330", "amal@example.com",
                "@amal_finance", "Married");

        Applicant applicant85 = new Applicant("Kuala Lumpur", "www.irfansoftware.com", "Remote", "Full-Time",
                4, "RM6,000 - RM7,200", false, "Within 1 Month", resume85, new DoublyLinkedList<>(),
                "A085", "Irfan Hadi", new GregorianCalendar(1994, Calendar.JANUARY, 28).getTime(),
                "Male", "9 Jalan Damai, Kuala Lumpur, Malaysia", "940128-14-8899", "+60 16-5566772", "irfan@example.com",
                "@irfan_soft", "Single");

        Applicant applicant86 = new Applicant("Negeri Sembilan", "www.nurulcreative.com", "Hybrid", "Full-Time",
                3, "RM5,600 - RM6,700", false, "Within 2 Weeks", resume86, new DoublyLinkedList<>(),
                "A086", "Nurul Nabila", new GregorianCalendar(1997, Calendar.DECEMBER, 2).getTime(),
                "Female", "43 Jalan Seremban, Seremban, Malaysia", "971202-05-6677", "+60 18-7788991", "nabila@example.com",
                "@nurul_creative", "Single");

        Applicant applicant87 = new Applicant("Perak", "www.izzulcloud.com", "Remote", "Full-Time",
                5, "RM6,700 - RM7,900", true, "Immediate", resume87, new DoublyLinkedList<>(),
                "A087", "Izzul Azhar", new GregorianCalendar(1991, Calendar.APRIL, 8).getTime(),
                "Male", "30 Jalan Tambun, Ipoh, Malaysia", "910408-06-2244", "+60 13-8899001", "izzul@example.com",
                "@izzul_cloud", "Married");

        Applicant applicant88 = new Applicant("Pahang", "www.lianmarketing.com", "On-Site", "Full-Time",
                4, "RM5,800 - RM6,900", true, "Within 1 Month", resume88, new DoublyLinkedList<>(),
                "A088", "Lian Wei", new GregorianCalendar(1993, Calendar.MARCH, 6).getTime(),
                "Male", "7 Jalan Mahkota, Kuantan, Malaysia", "930306-06-1122", "+60 14-6677885", "lian@example.com",
                "@lian_marketing", "Single");

        Applicant applicant89 = new Applicant("Kedah", "www.zarinaapps.com", "Remote", "Full-Time",
                3, "RM5,400 - RM6,500", false, "Within 2 Weeks", resume89, new DoublyLinkedList<>(),
                "A089", "Zarina Arifin", new GregorianCalendar(1995, Calendar.OCTOBER, 11).getTime(),
                "Female", "88 Jalan Kuala Kedah, Alor Setar, Malaysia", "951011-02-3344", "+60 15-2233441", "zarina@example.com",
                "@zarina_apps", "Single");

        Applicant applicant90 = new Applicant("Terengganu", "www.ridzuanengineer.com", "Hybrid", "Full-Time",
                5, "RM6,900 - RM8,200", true, "Immediate", resume90, new DoublyLinkedList<>(),
                "A090", "Ridzuan Bahar", new GregorianCalendar(1989, Calendar.SEPTEMBER, 27).getTime(),
                "Male", "75 Jalan Sultan Zainal Abidin, Kuala Terengganu, Malaysia", "890927-11-2233", "+60 17-1122335", "ridzuan@example.com",
                "@ridzuan_engineer", "Married");

        Applicant applicant91 = new Applicant("Putrajaya", "www.zafrananalytics.com", "Remote", "Full-Time",
                4, "RM6,200 - RM7,400", false, "Within 1 Month", resume91, new DoublyLinkedList<>(),
                "A091", "Zafran Ishak", new GregorianCalendar(1992, Calendar.JULY, 12).getTime(),
                "Male", "28 Jalan Presint 15, Putrajaya, Malaysia", "920712-14-7788", "+60 19-3344556", "zafran@example.com",
                "@zafran_analytics", "Single");

        Applicant applicant92 = new Applicant("Selangor", "www.aisyahmedia.com", "Hybrid", "Full-Time",
                3, "RM5,700 - RM6,800", false, "Within 2 Weeks", resume92, new DoublyLinkedList<>(),
                "A092", "Aisyah Hassan", new GregorianCalendar(1996, Calendar.JUNE, 22).getTime(),
                "Female", "63 Jalan Seksyen 9, Shah Alam, Malaysia", "960622-10-3344", "+60 12-3344567", "aisyah@example.com",
                "@aisyah_media", "Single");

        Applicant applicant93 = new Applicant("Sabah", "www.fikrifullstack.com", "Remote", "Full-Time",
                5, "RM6,800 - RM8,000", true, "Immediate", resume93, new DoublyLinkedList<>(),
                "A093", "Fikri Nasir", new GregorianCalendar(1990, Calendar.NOVEMBER, 20).getTime(),
                "Male", "20 Jalan Lintas, Kota Kinabalu, Malaysia", "901120-12-5566", "+60 11-8899776", "fikri@example.com",
                "@fikri_fullstack", "Married");

        Applicant applicant94 = new Applicant("Melaka", "www.wardahtech.com", "Hybrid", "Full-Time",
                3, "RM5,900 - RM7,000", false, "Within 1 Month", resume94, new DoublyLinkedList<>(),
                "A094", "Wardah Fatin", new GregorianCalendar(1995, Calendar.MARCH, 14).getTime(),
                "Female", "37 Jalan Hang Tuah, Melaka, Malaysia", "950314-04-7788", "+60 13-2233445", "wardah@example.com",
                "@wardah_tech", "Single");

        Applicant applicant95 = new Applicant("Sarawak", "www.hakimisecurity.com", "On-Site", "Full-Time",
                6, "RM7,100 - RM8,300", true, "Immediate", resume95, new DoublyLinkedList<>(),
                "A095", "Hakimi Yusuf", new GregorianCalendar(1987, Calendar.JANUARY, 3).getTime(),
                "Male", "15 Jalan Petrajaya, Kuching, Malaysia", "870103-13-3344", "+60 14-5566770", "hakimi@example.com",
                "@hakimi_security", "Married");

        Applicant applicant96 = new Applicant("Labuan", "www.yasminit.com", "Remote", "Full-Time",
                3, "RM5,600 - RM6,700", false, "Within 2 Weeks", resume96, new DoublyLinkedList<>(),
                "A096", "Yasmin Rahim", new GregorianCalendar(1997, Calendar.FEBRUARY, 26).getTime(),
                "Female", "51 Jalan Tanjung Aru, Labuan, Malaysia", "970226-12-4455", "+60 15-3344551", "yasmin@example.com",
                "@yasmin_it", "Single");

        Applicant applicant97 = new Applicant("Johor", "www.akramblockchain.com", "Hybrid", "Full-Time",
                4, "RM6,400 - RM7,600", true, "Immediate", resume97, new DoublyLinkedList<>(),
                "A097", "Akram Zain", new GregorianCalendar(1991, Calendar.DECEMBER, 6).getTime(),
                "Male", "88 Jalan Skudai, Johor Bahru, Malaysia", "911206-01-3344", "+60 16-8899002", "akram@example.com",
                "@akram_blockchain", "Married");

        Applicant applicant98 = new Applicant("Kelantan", "www.wardahapps.com", "Remote", "Part-Time",
                2, "RM4,000 - RM5,000", false, "Within 2 Weeks", resume98, new DoublyLinkedList<>(),
                "A098", "Wardah Aina", new GregorianCalendar(1998, Calendar.JULY, 18).getTime(),
                "Female", "90 Jalan Panji, Kota Bharu, Malaysia", "980718-03-5566", "+60 17-2233447", "aina@example.com",
                "@wardah_apps", "Single");

        Applicant applicant99 = new Applicant("Kuala Lumpur", "www.shahirux.com", "Hybrid", "Full-Time",
                4, "RM6,000 - RM7,300", true, "Immediate", resume99, new DoublyLinkedList<>(),
                "A099", "Shahir Latif", new GregorianCalendar(1993, Calendar.AUGUST, 1).getTime(),
                "Male", "45 Jalan Sentul, Kuala Lumpur, Malaysia", "930801-14-4455", "+60 13-8899778", "shahir@example.com",
                "@shahir_ux", "Single");

        Applicant applicant100 = new Applicant("Perlis", "www.hananimedia.com", "Remote", "Full-Time",
                3, "RM5,700 - RM6,900", false, "Within 2 Weeks", resume100, new DoublyLinkedList<>(),
                "A100", "Hanani Musa", new GregorianCalendar(1996, Calendar.SEPTEMBER, 5).getTime(),
                "Female", "62 Jalan Kangar, Kangar, Malaysia", "960905-02-7788", "+60 12-5566778", "hanani@example.com",
                "@hanani_media", "Single");

        JobApplication app1 = new JobApplication("APP001", new GregorianCalendar(2024, Calendar.JANUARY, 15).getTime(), "Shortlisted",
                true, false, "Reviewed application", "Awaiting interview", applicant1, job1);

        JobApplication app2 = new JobApplication("APP002", new GregorianCalendar(2024, Calendar.JANUARY, 17).getTime(), "Shortlisted",
                true, true, "Good experience", "Interview scheduled", applicant2, job2);

        JobApplication app3 = new JobApplication("APP003", new GregorianCalendar(2024, Calendar.FEBRUARY, 10).getTime(), "Shortlisted",
                false, false, "Lacks required skills", "Not suitable for role", applicant3, job5);

        JobApplication app4 = new JobApplication("APP004", new GregorianCalendar(2024, Calendar.FEBRUARY, 12).getTime(), "Shortlisted",
                true, false, "Resume is strong", "Awaiting response", applicant4, job4);

        JobApplication app5 = new JobApplication("APP005", new GregorianCalendar(2024, Calendar.FEBRUARY, 15).getTime(), "Shortlisted",
                false, true, "Great portfolio", "Interview in progress", applicant5, job5);

        JobApplication app6 = new JobApplication("APP006", new GregorianCalendar(2024, Calendar.FEBRUARY, 18).getTime(), "Shortlisted",
                true, false, "Interesting background", "Awaiting further review", applicant2, job3);

        JobApplication app7 = new JobApplication("APP007", new GregorianCalendar(2024, Calendar.FEBRUARY, 20).getTime(), "Shortlisted",
                true, false, "Lacks experience", "Better suited for junior role", applicant3, job7);

        JobApplication app8 = new JobApplication("APP008", new GregorianCalendar(2024, Calendar.FEBRUARY, 22).getTime(), "Shortlisted",
                false, false, "Did not submit resume", "Awaiting documents", applicant2, job5);

        JobApplication app9 = new JobApplication("APP009", new GregorianCalendar(2024, Calendar.FEBRUARY, 25).getTime(), "Shortlisted",
                true, true, "Excellent leadership skills", "Interview passed", applicant1, job9);

        JobApplication app10 = new JobApplication("APP010", new GregorianCalendar(2024, Calendar.FEBRUARY, 25).getTime(), "Shortlisted",
                true, true, "Strong legal background", "Final interview scheduled", applicant3, job8);

        JobApplication app11 = new JobApplication("APP011", new GregorianCalendar(2024, Calendar.MARCH, 1).getTime(), "Shortlisted",
                true, false, "Highly motivated", "Waiting for assessment", applicant6, job10);

        JobApplication app12 = new JobApplication("APP012", new GregorianCalendar(2024, Calendar.MARCH, 2).getTime(), "Shortlisted",
                true, true, "Relevant technical background", "Interview confirmed", applicant7, job11);

        JobApplication app13 = new JobApplication("APP013", new GregorianCalendar(2024, Calendar.MARCH, 3).getTime(), "Shortlisted",
                true, false, "Incomplete documentation", "Re-application encouraged", applicant8, job12);

        JobApplication app14 = new JobApplication("APP014", new GregorianCalendar(2024, Calendar.MARCH, 4).getTime(), "Shortlisted",
                true, false, "Fresh graduate, promising", "Awaiting initial review", applicant9, job13);

        JobApplication app15 = new JobApplication("APP015", new GregorianCalendar(2024, Calendar.MARCH, 5).getTime(), "Shortlisted",
                true, true, "Strong project portfolio", "Second round scheduled", applicant10, job14);

        JobApplication app16 = new JobApplication("APP016", new GregorianCalendar(2024, Calendar.MARCH, 6).getTime(), "Shortlisted",
                true, false, "Good soft skills", "Assigned to reviewer", applicant11, job15);

        JobApplication app17 = new JobApplication("APP017", new GregorianCalendar(2024, Calendar.MARCH, 7).getTime(), "Shortlisted",
                true, false, "Didn’t meet language requirement", "Not shortlisted", applicant12, job16);

        JobApplication app18 = new JobApplication("APP018", new GregorianCalendar(2024, Calendar.MARCH, 8).getTime(), "Shortlisted",
                true, true, "Exceptional interview performance", "Recommended for hiring", applicant13, job10);

        JobApplication app19 = new JobApplication("APP019", new GregorianCalendar(2024, Calendar.MARCH, 9).getTime(), "Shortlisted",
                true, false, "Interesting academic background", "Under initial screening", applicant14, job11);

        JobApplication app20 = new JobApplication("APP020", new GregorianCalendar(2024, Calendar.MARCH, 10).getTime(), "Shortlisted",
                true, true, "Aligned with company values", "In negotiation", applicant15, job12);

        JobApplication app21 = new JobApplication("APP021", new GregorianCalendar(2024, Calendar.MARCH, 11).getTime(), "Requested",
                true, false, "Insufficient experience", "Application closed", applicant16, job13);

        JobApplication app22 = new JobApplication("APP022", new GregorianCalendar(2024, Calendar.MARCH, 12).getTime(), "Pending",
                true, false, "Profile under review", "Awaiting manager feedback", applicant17, job14);

        JobApplication app23 = new JobApplication("APP023", new GregorianCalendar(2024, Calendar.MARCH, 13).getTime(), "Pending",
                true, true, "Strong work ethic", "Second round underway", applicant18, job15);

        JobApplication app24 = new JobApplication("APP024", new GregorianCalendar(2024, Calendar.MARCH, 14).getTime(), "Pending",
                true, false, "Overqualified", "Position not suitable", applicant19, job16);

        JobApplication app25 = new JobApplication("APP025", new GregorianCalendar(2024, Calendar.MARCH, 15).getTime(), "Pending",
                true, false, "Awaiting verification", "Document check ongoing", applicant20, job13);

        JobApplication app26 = new JobApplication("APP026", new GregorianCalendar(2024, Calendar.MARCH, 16).getTime(), "Pending",
                true, true, "Excellent communication skills", "Interview complete", applicant21, job14);

        JobApplication app27 = new JobApplication("APP027", new GregorianCalendar(2024, Calendar.MARCH, 17).getTime(), "Pending",
                true, false, "High potential", "Referred to hiring team", applicant22, job13);

        JobApplication app28 = new JobApplication("APP028", new GregorianCalendar(2024, Calendar.MARCH, 18).getTime(), "Requested",
                true, false, "Skills mismatch", "Not selected", applicant23, job13);

        JobApplication app29 = new JobApplication("APP029", new GregorianCalendar(2024, Calendar.MARCH, 19).getTime(), "Pending",
                true, true, "Great fit for role", "Final review ongoing", applicant24, job16);

        JobApplication app30 = new JobApplication("APP030", new GregorianCalendar(2024, Calendar.MARCH, 25).getTime(), "Pending",
                true, false, "Application received", "Awaiting feedback", applicant25, job15);

        JobApplication app31 = new JobApplication("APP031", new GregorianCalendar(2024, Calendar.APRIL, 1).getTime(), "Shortlisted",
                true, false, "Resume reviewed", "Initial screening", applicant20, job17);

        JobApplication app32 = new JobApplication("APP032", new GregorianCalendar(2024, Calendar.APRIL, 2).getTime(), "Shortlisted",
                true, true, "Great technical foundation", "Scheduled for interview", applicant21, job18);

        JobApplication app33 = new JobApplication("APP033", new GregorianCalendar(2024, Calendar.APRIL, 3).getTime(), "Requested",
                true, false, "Not enough experience", "Declined after screening", applicant22, job19);

        JobApplication app34 = new JobApplication("APP034", new GregorianCalendar(2024, Calendar.APRIL, 4).getTime(), "Shortlisted",
                true, false, "Waiting for documentation", "Pending review", applicant23, job20);

        JobApplication app35 = new JobApplication("APP035", new GregorianCalendar(2024, Calendar.APRIL, 5).getTime(), "Shortlisted",
                true, true, "Excellent leadership", "Second round confirmed", applicant24, job21);

        JobApplication app36 = new JobApplication("APP036", new GregorianCalendar(2024, Calendar.APRIL, 6).getTime(), "Pending",
                true, false, "Entry-level candidate", "Awaiting technical test", applicant25, job22);

        JobApplication app37 = new JobApplication("APP037", new GregorianCalendar(2024, Calendar.APRIL, 7).getTime(), "Requested",
                true, false, "Application incomplete", "Not considered", applicant26, job23);

        JobApplication app38 = new JobApplication("APP038", new GregorianCalendar(2024, Calendar.APRIL, 8).getTime(), "Pending",
                true, false, "Referral from internal", "Fast-track pending", applicant27, job17);

        JobApplication app39 = new JobApplication("APP039", new GregorianCalendar(2024, Calendar.APRIL, 9).getTime(), "Shortlisted",
                true, true, "Top-tier education", "Interview passed", applicant28, job18);

        JobApplication app40 = new JobApplication("APP040", new GregorianCalendar(2024, Calendar.APRIL, 10).getTime(), "Requested",
                true, false, "Unclear motivations", "Not moved forward", applicant29, job19);

        JobApplication app41 = new JobApplication("APP041", new GregorianCalendar(2024, Calendar.APRIL, 11).getTime(), "Pending",
                true, false, "Promising background", "Technical interview pending", applicant30, job20);

        JobApplication app42 = new JobApplication("APP042", new GregorianCalendar(2024, Calendar.APRIL, 12).getTime(), "Shortlisted",
                true, true, "High competency", "Awaiting final round", applicant31, job21);

        JobApplication app43 = new JobApplication("APP043", new GregorianCalendar(2024, Calendar.APRIL, 13).getTime(), "Pending",
                true, false, "Review in progress", "Waiting for response", applicant32, job22);

        JobApplication app44 = new JobApplication("APP044", new GregorianCalendar(2024, Calendar.APRIL, 14).getTime(), "Requested",
                true, false, "Overqualified", "Position mismatch", applicant33, job23);

        JobApplication app45 = new JobApplication("APP045", new GregorianCalendar(2024, Calendar.APRIL, 15).getTime(), "Pending",
                true, false, "Good certifications", "Forwarded to hiring lead", applicant34, job23);

        JobApplication app46 = new JobApplication("APP046", new GregorianCalendar(2024, Calendar.APRIL, 16).getTime(), "Shortlisted",
                true, true, "Excellent team skills", "Hiring manager interview next", applicant35, job21);

        JobApplication app47 = new JobApplication("APP047", new GregorianCalendar(2024, Calendar.APRIL, 17).getTime(), "Pending",
                true, false, "Resume flagged for review", "Awaiting recruiter review", applicant36, job22);

        JobApplication app48 = new JobApplication("APP048", new GregorianCalendar(2024, Calendar.APRIL, 18).getTime(), "Requested",
                true, false, "Interview feedback not positive", "Application declined", applicant37, job20);

        JobApplication app49 = new JobApplication("APP049", new GregorianCalendar(2024, Calendar.APRIL, 19).getTime(), "Shortlisted",
                true, true, "Strong problem-solving", "Final round in progress", applicant38, job21);

        JobApplication app50 = new JobApplication("APP050", new GregorianCalendar(2024, Calendar.APRIL, 20).getTime(), "Pending",
                true, false, "Pending team review", "Awaiting slot allocation", applicant39, job22);

        JobApplication app51 = new JobApplication("APP051", new GregorianCalendar(2024, Calendar.APRIL, 21).getTime(), "Pending",
                true, false, "Awaiting HR review", "Under evaluation", applicant40, job23);

        JobApplication app52 = new JobApplication("APP052", new GregorianCalendar(2024, Calendar.APRIL, 22).getTime(), "Shortlisted",
                true, true, "Strong analytics experience", "Panel interview completed", applicant41, job22);

        JobApplication app53 = new JobApplication("APP053", new GregorianCalendar(2024, Calendar.APRIL, 23).getTime(), "Requested",
                true, false, "Weak communication skills", "Not selected", applicant42, job20);

        JobApplication app54 = new JobApplication("APP054", new GregorianCalendar(2024, Calendar.APRIL, 24).getTime(), "Pending",
                true, false, "New graduate", "Awaiting team assessment", applicant43, job21);

        JobApplication app55 = new JobApplication("APP055", new GregorianCalendar(2024, Calendar.APRIL, 25).getTime(), "Shortlisted",
                true, true, "Advanced industry certifications", "Offer in progress", applicant44, job22);

        JobApplication app56 = new JobApplication("APP056", new GregorianCalendar(2024, Calendar.APRIL, 26).getTime(), "Pending",
                true, false, "Awaiting background check", "In verification stage", applicant45, job23);

        JobApplication app57 = new JobApplication("APP057", new GregorianCalendar(2024, Calendar.APRIL, 27).getTime(), "Requested",
                true, false, "Not a cultural fit", "Declined post-interview", applicant46, job24);

        JobApplication app58 = new JobApplication("APP058", new GregorianCalendar(2024, Calendar.APRIL, 28).getTime(), "Pending",
                true, false, "Recently referred", "Fast-track review", applicant47, job23);

        JobApplication app59 = new JobApplication("APP059", new GregorianCalendar(2024, Calendar.APRIL, 29).getTime(), "Shortlisted",
                true, true, "Exceptional portfolio", "Second round scheduled", applicant48, job24);

        JobApplication app60 = new JobApplication("APP060", new GregorianCalendar(2024, Calendar.APRIL, 29).getTime(), "Requested",
                true, false, "Failed assessment", "Not moving forward", applicant49, job25);

        JobApplication app61 = new JobApplication("APP061", new GregorianCalendar(2024, Calendar.APRIL, 29).getTime(), "Pending",
                true, false, "Awaiting department feedback", "In internal review", applicant50, job26);

        JobApplication app62 = new JobApplication("APP062", new GregorianCalendar(2024, Calendar.APRIL, 29).getTime(), "Shortlisted",
                true, true, "Top communication scores", "Final interview pending", applicant51, job22);

        JobApplication app63 = new JobApplication("APP063", new GregorianCalendar(2024, Calendar.APRIL, 29).getTime(), "Pending",
                true, false, "Manager recommendation", "Document review in progress", applicant52, job26);

        JobApplication app64 = new JobApplication("APP064", new GregorianCalendar(2024, Calendar.APRIL, 29).getTime(), "Requested",
                true, false, "Did not attend interview", "Application closed", applicant53, job22);

        JobApplication app65 = new JobApplication("APP065", new GregorianCalendar(2024, Calendar.APRIL, 29).getTime(), "Pending",
                true, false, "Profile in final review", "Awaiting hiring decision", applicant54, job23);

        JobApplication app66 = new JobApplication("APP066", new GregorianCalendar(2024, Calendar.APRIL, 29).getTime(), "Shortlisted",
                true, true, "Strong culture alignment", "Final round passed", applicant55, job22);

        JobApplication app67 = new JobApplication("APP067", new GregorianCalendar(2024, Calendar.APRIL, 29).getTime(), "Pending",
                true, false, "Awaiting technical assignment", "Task scheduled", applicant56, job23);

        JobApplication app68 = new JobApplication("APP068", new GregorianCalendar(2024, Calendar.APRIL, 29).getTime(), "Requested",
                true, false, "Interview panel did not recommend", "Candidate removed", applicant57, job24);

        JobApplication app69 = new JobApplication("APP069", new GregorianCalendar(2024, Calendar.APRIL, 29).getTime(), "Pending",
                true, false, "Resume forwarded", "Waiting for feedback", applicant58, job28);

        JobApplication app70 = new JobApplication("APP070", new GregorianCalendar(2024, Calendar.APRIL, 29).getTime(), "Shortlisted",
                true, true, "Very strong leadership traits", "Final offer underway", applicant59, job24);

        JobApplication app71 = new JobApplication("APP071", new GregorianCalendar(2024, Calendar.MAY, 1).getTime(), "Pending",
                true, false, "Strong resume", "Awaiting initial review", applicant60, job24);

        JobApplication app72 = new JobApplication("APP072", new GregorianCalendar(2024, Calendar.MAY, 2).getTime(), "Shortlisted",
                true, true, "Relevant project experience", "Technical interview passed", applicant61, job25);

        JobApplication app73 = new JobApplication("APP073", new GregorianCalendar(2024, Calendar.MAY, 3).getTime(), "Pending",
                true, false, "Overqualified for the role", "Application closed", applicant62, job26);

        JobApplication app74 = new JobApplication("APP074", new GregorianCalendar(2024, Calendar.MAY, 4).getTime(), "Pending",
                true, false, "Awaiting assignment submission", "Pending next steps", applicant63, job27);

        JobApplication app75 = new JobApplication("APP075", new GregorianCalendar(2024, Calendar.MAY, 5).getTime(), "Shortlisted",
                true, true, "Exceptional interview performance", "Offer under discussion", applicant64, job28);

        JobApplication app76 = new JobApplication("APP076", new GregorianCalendar(2024, Calendar.MAY, 6).getTime(), "Pending",
                true, false, "Strong references provided", "Awaiting hiring team input", applicant65, job29);

        JobApplication app77 = new JobApplication("APP077", new GregorianCalendar(2024, Calendar.MAY, 7).getTime(), "Pending",
                true, false, "Failed to meet technical criteria", "Candidate not suitable", applicant66, job30);

        JobApplication app78 = new JobApplication("APP078", new GregorianCalendar(2024, Calendar.MAY, 8).getTime(), "Pending",
                true, false, "Fresh graduate", "Screening scheduled", applicant67, job24);

        JobApplication app79 = new JobApplication("APP079", new GregorianCalendar(2024, Calendar.MAY, 9).getTime(), "Shortlisted",
                true, true, "Impressive background in field", "Team interview complete", applicant68, job25);

        JobApplication app80 = new JobApplication("APP080", new GregorianCalendar(2024, Calendar.MAY, 10).getTime(), "Requested",
                true, false, "Did not show for interview", "Process terminated", applicant69, job26);

        JobApplication app81 = new JobApplication("APP081", new GregorianCalendar(2024, Calendar.MAY, 11).getTime(), "Pending",
                true, false, "Awaiting final evaluation", "Manager review in progress", applicant70, job27);

        JobApplication app82 = new JobApplication("APP082", new GregorianCalendar(2024, Calendar.MAY, 12).getTime(), "Shortlisted",
                true, true, "Recommended by internal team", "Second round cleared", applicant71, job28);

        JobApplication app83 = new JobApplication("APP083", new GregorianCalendar(2024, Calendar.MAY, 13).getTime(), "Pending",
                true, false, "Submitted required documents", "Awaiting HR call", applicant72, job29);

        JobApplication app84 = new JobApplication("APP084", new GregorianCalendar(2024, Calendar.MAY, 14).getTime(), "Requested",
                true, false, "Skillset mismatch", "Not aligned with job expectations", applicant73, job30);

        JobApplication app85 = new JobApplication("APP085", new GregorianCalendar(2024, Calendar.MAY, 15).getTime(), "Pending",
                true, false, "Needs second opinion", "Team deliberating", applicant74, job27);

        JobApplication app86 = new JobApplication("APP086", new GregorianCalendar(2024, Calendar.MAY, 16).getTime(), "Shortlisted",
                true, true, "Excellent academic credentials", "HR round cleared", applicant75, job28);

        JobApplication app87 = new JobApplication("APP087", new GregorianCalendar(2024, Calendar.MAY, 17).getTime(), "Pending",
                true, false, "Technical test in review", "Evaluation ongoing", applicant76, job29);

        JobApplication app88 = new JobApplication("APP088", new GregorianCalendar(2024, Calendar.MAY, 18).getTime(), "Requested",
                true, false, "Inadequate team skills", "Feedback from interview panel", applicant77, job27);

        JobApplication app89 = new JobApplication("APP089", new GregorianCalendar(2024, Calendar.MAY, 19).getTime(), "Requested",
                true, false, "Interview scheduled", "Awaiting result", applicant78, job28);

        JobApplication app90 = new JobApplication("APP090", new GregorianCalendar(2024, Calendar.MAY, 20).getTime(), "Shortlisted",
                true, true, "Passed all rounds", "Offer letter initiated", applicant79, job29);

        JobApplication app91 = new JobApplication("APP091", new GregorianCalendar(2024, Calendar.MAY, 21).getTime(), "Pending",
                true, false, "Awaiting panel feedback", "Initial review in progress", applicant80, job27);

        JobApplication app92 = new JobApplication("APP092", new GregorianCalendar(2024, Calendar.MAY, 22).getTime(), "Shortlisted",
                true, true, "Excellent project alignment", "Final discussion scheduled", applicant81, job28);

        JobApplication app93 = new JobApplication("APP093", new GregorianCalendar(2024, Calendar.MAY, 23).getTime(), "Requested",
                true, false, "Missing qualifications", "Role mismatch", applicant82, job29);

        JobApplication app94 = new JobApplication("APP094", new GregorianCalendar(2024, Calendar.MAY, 24).getTime(), "Shortlisted",
                true, false, "Resume under review", "Waiting for recruiter feedback", applicant83, job30);

        JobApplication app95 = new JobApplication("APP095", new GregorianCalendar(2024, Calendar.MAY, 25).getTime(), "Shortlisted",
                true, true, "Great interpersonal skills", "Offer discussion underway", applicant84, job31);

        JobApplication app96 = new JobApplication("APP096", new GregorianCalendar(2024, Calendar.MAY, 26).getTime(), "Pending",
                true, false, "Interview scheduled next week", "Awaiting candidate response", applicant85, job32);

        JobApplication app97 = new JobApplication("APP097", new GregorianCalendar(2024, Calendar.MAY, 27).getTime(), "Requested",
                true, false, "Not available on project timeline", "Position closed", applicant86, job33);

        JobApplication app98 = new JobApplication("APP098", new GregorianCalendar(2024, Calendar.MAY, 28).getTime(), "Pending",
                true, false, "Good potential", "In shortlist discussion", applicant87, job34);

        JobApplication app99 = new JobApplication("APP099", new GregorianCalendar(2024, Calendar.MAY, 29).getTime(), "Shortlisted",
                true, true, "Strong fit for team", "Final review in progress", applicant88, job35);

        JobApplication app100 = new JobApplication("APP100", new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), "Pending",
                true, false, "Awaiting background check", "Pre-hire stage", applicant89, job29);

        JobApplication app101 = new JobApplication("APP101", new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), "Requested",
                true, false, "Declined offer", "Position remains open", applicant90, job29);

        JobApplication app102 = new JobApplication("APP102", new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), "Pending",
                true, false, "Awaiting HR assignment", "Review in progress", applicant91, job29);

        JobApplication app103 = new JobApplication("APP103", new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), "Shortlisted",
                true, true, "Highly qualified candidate", "Offer extended", applicant92, job30);

        JobApplication app104 = new JobApplication("APP104", new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), "Pending",
                true, false, "Interview completed", "Waiting final decision", applicant93, job31);

        JobApplication app105 = new JobApplication("APP105", new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), "Requested",
                true, false, "Unfavourable team feedback", "No offer extended", applicant94, job32);

        JobApplication app106 = new JobApplication("APP106", new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), "Pending",
                true, false, "Needs further review", "Additional input required", applicant95, job33);

        JobApplication app107 = new JobApplication("APP107", new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), "Shortlisted",
                true, true, "Great technical skills", "Team ready to proceed", applicant96, job34);

        JobApplication app108 = new JobApplication("APP108", new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), "Pending",
                true, false, "Referred by senior manager", "Fast-track pending", applicant97, job35);

        JobApplication app109 = new JobApplication("APP109", new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), "Requested",
                true, false, "Poor interview performance", "Application archived", applicant98, job35);

        JobApplication app110 = new JobApplication("APP110", new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), "Pending",
                true, false, "Interview panel liked candidate", "Awaiting final sign-off", applicant99, job36);

        JobApplication app111 = new JobApplication("APP111", new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), "Shortlisted",
                true, true, "Outstanding achievements", "Offer ready", applicant100, job30);

        JobApplication app112 = new JobApplication("APP112", new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), "Pending",
                true, false, "Good domain experience", "Awaiting department reply", applicant1, job30);

        JobApplication app113 = new JobApplication("APP113", new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), "Requested",
                true, false, "Lack of leadership skills", "Declined after interview", applicant12, job31);

        JobApplication app114 = new JobApplication("APP114", new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), "Pending",
                true, false, "Awaiting test results", "In process", applicant10, job32);

        JobApplication app115 = new JobApplication("APP115", new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), "Shortlisted",
                true, true, "Strong referrals", "Negotiation in progress", applicant14, job33);

        JobApplication app116 = new JobApplication("APP116", new GregorianCalendar(2024, Calendar.JUNE, 1).getTime(), "Pending",
                true, false, "Awaiting portfolio review", "Under consideration", applicant15, job31);

        JobApplication app117 = new JobApplication("APP117", new GregorianCalendar(2024, Calendar.JUNE, 2).getTime(), "Shortlisted",
                true, true, "Excellent credentials", "Interview scheduled", applicant8, job32);

        JobApplication app118 = new JobApplication("APP118", new GregorianCalendar(2024, Calendar.JUNE, 3).getTime(), "Requested",
                true, false, "Incomplete application", "Declined", applicant45, job33);

        JobApplication app119 = new JobApplication("APP119", new GregorianCalendar(2024, Calendar.JUNE, 4).getTime(), "Pending",
                true, false, "Good experience", "Further review required", applicant20, job34);

        JobApplication app120 = new JobApplication("APP120", new GregorianCalendar(2024, Calendar.JUNE, 5).getTime(), "Shortlisted",
                true, true, "Aligned with role", "Offer under review", applicant57, job35);

        JobApplication app121 = new JobApplication("APP121", new GregorianCalendar(2024, Calendar.JUNE, 6).getTime(), "Pending",
                true, false, "Needs additional documentation", "Waiting for updates", applicant10, job36);

        JobApplication app122 = new JobApplication("APP122", new GregorianCalendar(2024, Calendar.JUNE, 7).getTime(), "Requested",
                true, false, "Skills mismatch", "Candidate notified", applicant25, job37);

        JobApplication app123 = new JobApplication("APP123", new GregorianCalendar(2024, Calendar.JUNE, 8).getTime(), "Pending",
                true, false, "Awaiting recruiter feedback", "First round completed", applicant33, job38);

        JobApplication app124 = new JobApplication("APP124", new GregorianCalendar(2024, Calendar.JUNE, 9).getTime(), "Shortlisted",
                true, true, "Strong profile", "Negotiation underway", applicant90, job39);

        JobApplication app125 = new JobApplication("APP125", new GregorianCalendar(2024, Calendar.JUNE, 10).getTime(), "Pending",
                true, false, "Awaiting interview outcome", "In review", applicant60, job40);

        JobApplication app126 = new JobApplication("APP126", new GregorianCalendar(2024, Calendar.JUNE, 11).getTime(), "Requested",
                true, false, "Did not meet expectations", "Process ended", applicant51, job41);

        JobApplication app127 = new JobApplication("APP127", new GregorianCalendar(2024, Calendar.JUNE, 12).getTime(), "Pending",
                true, false, "Awaiting team feedback", "Still being considered", applicant3, job42);

        JobApplication app128 = new JobApplication("APP128", new GregorianCalendar(2024, Calendar.JUNE, 13).getTime(), "Shortlisted",
                true, true, "Excellent communication", "Onboarding initiated", applicant100, job43);

        JobApplication app129 = new JobApplication("APP129", new GregorianCalendar(2024, Calendar.JUNE, 14).getTime(), "Pending",
                true, false, "Passed assessment", "Next round scheduled", applicant72, job44);

        JobApplication app130 = new JobApplication("APP130", new GregorianCalendar(2024, Calendar.JUNE, 15).getTime(), "Requested",
                true, false, "Limited domain expertise", "Not selected", applicant5, job45);

        JobApplication app131 = new JobApplication("APP131", new GregorianCalendar(2024, Calendar.JUNE, 16).getTime(), "Pending",
                true, false, "Interviewed by panel", "Decision awaited", applicant28, job46);

        JobApplication app132 = new JobApplication("APP132", new GregorianCalendar(2024, Calendar.JUNE, 17).getTime(), "Shortlisted",
                true, true, "Well-qualified", "Accepted offer", applicant70, job47);

        JobApplication app133 = new JobApplication("APP133", new GregorianCalendar(2024, Calendar.JUNE, 18).getTime(), "Pending",
                true, false, "Needs technical evaluation", "Panel assigned", applicant6, job48);

        JobApplication app134 = new JobApplication("APP134", new GregorianCalendar(2024, Calendar.JUNE, 19).getTime(), "Requested",
                true, false, "Low test scores", "Not moving forward", applicant92, job49);

        JobApplication app135 = new JobApplication("APP135", new GregorianCalendar(2024, Calendar.JUNE, 20).getTime(), "Pending",
                true, false, "Team reviewing", "Awaiting consensus", applicant22, job35);

        JobApplication app136 = new JobApplication("APP136", new GregorianCalendar(2024, Calendar.JUNE, 21).getTime(), "Shortlisted",
                true, true, "Great project portfolio", "Offer extended", applicant18, job36);

        JobApplication app137 = new JobApplication("APP137", new GregorianCalendar(2024, Calendar.JUNE, 22).getTime(), "Pending",
                true, false, "Background check in progress", "HR stage", applicant40, job37);

        JobApplication app138 = new JobApplication("APP138", new GregorianCalendar(2024, Calendar.JUNE, 23).getTime(), "Requested",
                true, false, "Withdrawn by candidate", "Closed", applicant31, job34);

        JobApplication app139 = new JobApplication("APP139", new GregorianCalendar(2024, Calendar.JUNE, 24).getTime(), "Pending",
                true, false, "Managerial approval pending", "Final review", applicant77, job35);

        JobApplication app140 = new JobApplication("APP140", new GregorianCalendar(2024, Calendar.JUNE, 25).getTime(), "Shortlisted",
                true, true, "Meets all requirements", "Offer ready to be issued", applicant13, job36);

        JobApplication app141 = new JobApplication("APP141", new GregorianCalendar(2024, Calendar.JUNE, 25).getTime(), "Pending",
                true, false, "Strong candidate", "Awaiting feedback", applicant12, job37);

        JobApplication app142 = new JobApplication("APP142", new GregorianCalendar(2024, Calendar.JUNE, 25).getTime(), "Shortlisted",
                true, true, "Impressive interview", "Offer being prepared", applicant36, job38);

        JobApplication app143 = new JobApplication("APP143", new GregorianCalendar(2024, Calendar.JUNE, 26).getTime(), "Pending",
                true, false, "Referred by employee", "Initial review", applicant63, job39);

        JobApplication app144 = new JobApplication("APP144", new GregorianCalendar(2024, Calendar.JUNE, 26).getTime(), "Requested",
                true, false, "Lacks industry experience", "Not proceeding", applicant4, job40);

        JobApplication app145 = new JobApplication("APP145", new GregorianCalendar(2024, Calendar.JUNE, 27).getTime(), "Pending",
                true, false, "Has potential", "Assigned to recruiter", applicant55, job41);

        JobApplication app146 = new JobApplication("APP146", new GregorianCalendar(2024, Calendar.JUNE, 27).getTime(), "Shortlisted",
                true, true, "Excellent presentation", "Final round scheduled", applicant26, job42);

        JobApplication app147 = new JobApplication("APP147", new GregorianCalendar(2024, Calendar.JUNE, 27).getTime(), "Pending",
                true, false, "Awaiting test results", "Pending decision", applicant84, job43);

        JobApplication app148 = new JobApplication("APP148", new GregorianCalendar(2024, Calendar.JUNE, 28).getTime(), "Requested",
                true, false, "Not a cultural fit", "Feedback shared", applicant91, job44);

        JobApplication app149 = new JobApplication("APP149", new GregorianCalendar(2024, Calendar.JUNE, 28).getTime(), "Pending",
                true, false, "Needs language proficiency review", "On hold", applicant17, job45);

        JobApplication app150 = new JobApplication("APP150", new GregorianCalendar(2024, Calendar.JUNE, 28).getTime(), "Shortlisted",
                true, true, "Strong technical background", "Final offer phase", applicant99, job46);

        JobApplication app151 = new JobApplication("APP151", new GregorianCalendar(2024, Calendar.JUNE, 29).getTime(), "Pending",
                true, false, "Awaiting executive sign-off", "Decision expected", applicant19, job47);

        JobApplication app152 = new JobApplication("APP152", new GregorianCalendar(2024, Calendar.JUNE, 29).getTime(), "Requested",
                true, false, "Low score on written test", "Application closed", applicant39, job48);

        JobApplication app153 = new JobApplication("APP153", new GregorianCalendar(2024, Calendar.JUNE, 29).getTime(), "Pending",
                true, false, "Interview completed", "HR preparing feedback", applicant73, job49);

        JobApplication app154 = new JobApplication("APP154", new GregorianCalendar(2024, Calendar.JUNE, 29).getTime(), "Shortlisted",
                true, true, "Fast learner", "Offer sent", applicant35, job37);

        JobApplication app155 = new JobApplication("APP155", new GregorianCalendar(2024, Calendar.JUNE, 29).getTime(), "Pending",
                true, false, "Good soft skills", "Needs second round", applicant10, job37);

        JobApplication app156 = new JobApplication("APP156", new GregorianCalendar(2024, Calendar.JULY, 1).getTime(), "Pending",
                true, false, "Strong interest in role", "Waiting for team review", applicant70, job38);

        JobApplication app157 = new JobApplication("APP157", new GregorianCalendar(2024, Calendar.JULY, 2).getTime(), "Shortlisted",
                true, true, "Great communication", "Final interview scheduled", applicant71, job39);

        JobApplication app158 = new JobApplication("APP158", new GregorianCalendar(2024, Calendar.JULY, 5).getTime(), "Pending",
                true, false, "Portfolio submitted", "Assessment in progress", applicant72, job40);

        JobApplication app159 = new JobApplication("APP159", new GregorianCalendar(2024, Calendar.JULY, 10).getTime(), "Requested",
                true, false, "Skills not aligned", "Not proceeding", applicant73, job41);

        JobApplication app160 = new JobApplication("APP160", new GregorianCalendar(2024, Calendar.JULY, 11).getTime(), "Pending",
                true, false, "Awaiting internal feedback", "Still open", applicant74, job42);

        JobApplication app161 = new JobApplication("APP161", new GregorianCalendar(2024, Calendar.JULY, 12).getTime(), "Shortlisted",
                true, true, "Top performer in interview", "Offer sent", applicant75, job43);

        JobApplication app162 = new JobApplication("APP162", new GregorianCalendar(2024, Calendar.JULY, 13).getTime(), "Pending",
                true, false, "Under second review", "Pending manager decision", applicant76, job38);

        JobApplication app163 = new JobApplication("APP163", new GregorianCalendar(2024, Calendar.JULY, 13).getTime(), "Requested",
                true, false, "No domain experience", "Candidate informed", applicant77, job39);

        JobApplication app164 = new JobApplication("APP164", new GregorianCalendar(2024, Calendar.JULY, 17).getTime(), "Pending",
                true, false, "Awaiting technical evaluation", "Test scheduled", applicant78, job40);

        JobApplication app165 = new JobApplication("APP165", new GregorianCalendar(2024, Calendar.JULY, 18).getTime(), "Shortlisted",
                true, true, "Outstanding portfolio", "Final round cleared", applicant79, job41);

        JobApplication app166 = new JobApplication("APP166", new GregorianCalendar(2024, Calendar.JULY, 28).getTime(), "Pending",
                true, false, "Needs follow-up call", "Coordinator assigned", applicant80, job42);

        JobApplication app167 = new JobApplication("APP167", new GregorianCalendar(2024, Calendar.JULY, 28).getTime(), "Requested",
                true, false, "Application withdrawn", "Process closed", applicant81, job43);

        JobApplication app168 = new JobApplication("APP168", new GregorianCalendar(2024, Calendar.JULY, 29).getTime(), "Pending",
                true, false, "Reviewing test results", "HR follow-up pending", applicant82, job44);

        JobApplication app169 = new JobApplication("APP169", new GregorianCalendar(2024, Calendar.JULY, 29).getTime(), "Shortlisted",
                true, true, "Excellent team fit", "Ready for offer", applicant83, job49);

        JobApplication app170 = new JobApplication("APP170", new GregorianCalendar(2024, Calendar.JULY, 29).getTime(), "Pending",
                true, false, "Initial call completed", "Next steps in progress", applicant84, job50);

        JobApplication app171 = new JobApplication("APP171", new GregorianCalendar(2024, Calendar.AUGUST, 1).getTime(), "Pending",
                true, false, "Motivated and punctual", "Resume forwarded", applicant1, job44);

        JobApplication app172 = new JobApplication("APP172", new GregorianCalendar(2024, Calendar.AUGUST, 2).getTime(), "Shortlisted",
                true, true, "Excellent interview", "Awaiting offer", applicant3, job45);

        JobApplication app173 = new JobApplication("APP173", new GregorianCalendar(2024, Calendar.AUGUST, 3).getTime(), "Pending",
                true, false, "Needs team evaluation", "Initial review done", applicant5, job46);

        JobApplication app174 = new JobApplication("APP174", new GregorianCalendar(2024, Calendar.AUGUST, 4).getTime(), "Requested",
                true, false, "Poor test performance", "Email sent", applicant7, job47);

        JobApplication app175 = new JobApplication("APP175", new GregorianCalendar(2024, Calendar.AUGUST, 5).getTime(), "Pending",
                true, false, "Experience aligns well", "Awaiting HR call", applicant9, job48);

        JobApplication app176 = new JobApplication("APP176", new GregorianCalendar(2024, Calendar.AUGUST, 6).getTime(), "Shortlisted",
                true, true, "Great leadership skills", "Final round booked", applicant11, job49);

        JobApplication app177 = new JobApplication("APP177", new GregorianCalendar(2024, Calendar.AUGUST, 7).getTime(), "Pending",
                true, false, "Strong references", "Background check initiated", applicant13, job50);

        JobApplication app178 = new JobApplication("APP178", new GregorianCalendar(2024, Calendar.AUGUST, 8).getTime(), "Pending",
                true, false, "Awaiting department head review", "To be confirmed", applicant15, job51);

        JobApplication app179 = new JobApplication("APP179", new GregorianCalendar(2024, Calendar.AUGUST, 9).getTime(), "Requested",
                true, false, "Overqualified", "Position filled", applicant17, job52);

        JobApplication app180 = new JobApplication("APP180", new GregorianCalendar(2024, Calendar.AUGUST, 10).getTime(), "Pending",
                true, false, "CV under screening", "Initial feedback pending", applicant19, job53);

        JobApplication app181 = new JobApplication("APP181", new GregorianCalendar(2024, Calendar.AUGUST, 11).getTime(), "Shortlisted",
                true, true, "Recommended by partner team", "Offer pending", applicant21, job54);

        JobApplication app182 = new JobApplication("APP182", new GregorianCalendar(2024, Calendar.AUGUST, 13).getTime(), "Pending",
                true, false, "Need more info on certifications", "Waiting on reply", applicant23, job55);

        JobApplication app183 = new JobApplication("APP183", new GregorianCalendar(2024, Calendar.AUGUST, 14).getTime(), "Requested",
                true, false, "Incomplete application", "Follow-up sent", applicant25, job46);

        JobApplication app184 = new JobApplication("APP184", new GregorianCalendar(2024, Calendar.AUGUST, 16).getTime(), "Pending",
                true, false, "High scoring aptitude test", "Interview being scheduled", applicant27, job48);

        JobApplication app185 = new JobApplication("APP185", new GregorianCalendar(2024, Calendar.AUGUST, 17).getTime(), "Shortlisted",
                true, true, "Excellent problem-solving", "Hiring manager impressed", applicant29, job50);

        JobApplication app186 = new JobApplication("APP186", new GregorianCalendar(2024, Calendar.AUGUST, 19).getTime(), "Pending",
                true, false, "References verified", "Manager to decide", applicant31, job48);

        JobApplication app187 = new JobApplication("APP187", new GregorianCalendar(2024, Calendar.AUGUST, 21).getTime(), "Requested",
                true, false, "Interview no-show", "Case closed", applicant33, job48);

        JobApplication app188 = new JobApplication("APP188", new GregorianCalendar(2024, Calendar.AUGUST, 23).getTime(), "Pending",
                true, false, "Still under review", "Next steps TBC", applicant35, job49);

        JobApplication app189 = new JobApplication("APP189", new GregorianCalendar(2024, Calendar.AUGUST, 26).getTime(), "Shortlisted",
                true, true, "Team impressed with candidate", "Offer negotiation", applicant37, job50);

        JobApplication app190 = new JobApplication("APP190", new GregorianCalendar(2024, Calendar.AUGUST, 29).getTime(), "Pending",
                true, false, "Awaiting final approval", "Pending update", applicant39, job51);

        JobApplication app191 = new JobApplication("APP191", new GregorianCalendar(2024, Calendar.SEPTEMBER, 1).getTime(), "Pending",
                true, false, "Awaiting document verification", "Screening stage", applicant50, job50);

        JobApplication app192 = new JobApplication("APP192", new GregorianCalendar(2024, Calendar.SEPTEMBER, 2).getTime(), "Shortlisted",
                true, true, "Outstanding technical round", "Next interview confirmed", applicant51, job51);

        JobApplication app193 = new JobApplication("APP193", new GregorianCalendar(2024, Calendar.SEPTEMBER, 4).getTime(), "Pending",
                true, false, "Team impressed", "Awaiting leadership review", applicant52, job52);

        JobApplication app194 = new JobApplication("APP194", new GregorianCalendar(2024, Calendar.SEPTEMBER, 6).getTime(), "Requested",
                true, false, "Lack of role-specific experience", "Feedback sent", applicant53, job53);

        JobApplication app195 = new JobApplication("APP195", new GregorianCalendar(2024, Calendar.SEPTEMBER, 8).getTime(), "Pending",
                true, false, "Portfolio under assessment", "Initial contact made", applicant54, job54);

        JobApplication app196 = new JobApplication("APP196", new GregorianCalendar(2024, Calendar.SEPTEMBER, 10).getTime(), "Shortlisted",
                true, true, "Highly engaged in interviews", "Offer under review", applicant55, job55);

        JobApplication app197 = new JobApplication("APP197", new GregorianCalendar(2024, Calendar.SEPTEMBER, 12).getTime(), "Requested",
                true, false, "Good potential", "Second round pending", applicant56, job56);

        JobApplication app198 = new JobApplication("APP198", new GregorianCalendar(2024, Calendar.SEPTEMBER, 14).getTime(), "Requested",
                true, false, "Did not meet culture fit", "No further action", applicant57, job57);

        JobApplication app199 = new JobApplication("APP199", new GregorianCalendar(2024, Calendar.SEPTEMBER, 16).getTime(), "Pending",
                true, false, "Follow-up interview needed", "Scheduling ongoing", applicant58, job58);

        JobApplication app200 = new JobApplication("APP200", new GregorianCalendar(2024, Calendar.SEPTEMBER, 18).getTime(), "Shortlisted",
                true, true, "Excellent teamwork evidence", "Offer in progress", applicant59, job59);

        JobApplication app201 = new JobApplication("APP201", new GregorianCalendar(2024, Calendar.SEPTEMBER, 20).getTime(), "Shortlisted",
                true, false, "Awaiting reference check", "Background review pending", applicant60, job60);

        JobApplication app202 = new JobApplication("APP202", new GregorianCalendar(2024, Calendar.SEPTEMBER, 22).getTime(), "Pending",
                true, false, "Role withdrawn", "Candidate informed", applicant61, job54);

        JobApplication app203 = new JobApplication("APP203", new GregorianCalendar(2024, Calendar.SEPTEMBER, 24).getTime(), "Pending",
                true, false, "Waiting for hiring manager feedback", "Still open", applicant62, job55);

        JobApplication app204 = new JobApplication("APP204", new GregorianCalendar(2024, Calendar.SEPTEMBER, 26).getTime(), "Pending",
                true, true, "Creative thinker", "Joining date being finalised", applicant63, job56);

        JobApplication app205 = new JobApplication("APP205", new GregorianCalendar(2024, Calendar.SEPTEMBER, 29).getTime(), "Pending",
                true, false, "CV forwarded to technical lead", "Response expected soon", applicant64, job58);

        JobApplication app206 = new JobApplication("APP206", new GregorianCalendar(2024, Calendar.OCTOBER, 1).getTime(), "Pending",
                true, false, "Strong academic background", "Under review", applicant80, job56);

        JobApplication app207 = new JobApplication("APP207", new GregorianCalendar(2024, Calendar.OCTOBER, 3).getTime(), "Shortlisted",
                true, true, "Excellent problem-solving", "Final interview booked", applicant82, job57);

        JobApplication app208 = new JobApplication("APP208", new GregorianCalendar(2024, Calendar.OCTOBER, 5).getTime(), "Pending",
                true, false, "Awaiting technical assessment", "HR notified", applicant84, job58);

        JobApplication app209 = new JobApplication("APP209", new GregorianCalendar(2024, Calendar.OCTOBER, 8).getTime(), "Requested",
                true, false, "Low test scores", "Not progressing", applicant86, job59);

        JobApplication app210 = new JobApplication("APP210", new GregorianCalendar(2024, Calendar.OCTOBER, 11).getTime(), "Pending",
                true, false, "Great communication", "Awaiting feedback", applicant88, job60);

        JobApplication app211 = new JobApplication("APP211", new GregorianCalendar(2024, Calendar.OCTOBER, 14).getTime(), "Shortlisted",
                true, true, "Positive references", "Onboarding in progress", applicant90, job61);

        JobApplication app212 = new JobApplication("APP212", new GregorianCalendar(2024, Calendar.OCTOBER, 17).getTime(), "Requested",
                true, false, "Portfolio under team review", "Next update soon", applicant92, job62);

        JobApplication app213 = new JobApplication("APP213", new GregorianCalendar(2024, Calendar.OCTOBER, 21).getTime(), "Requested",
                true, false, "Did not meet minimum criteria", "Informed candidate", applicant94, job63);

        JobApplication app214 = new JobApplication("APP214", new GregorianCalendar(2024, Calendar.OCTOBER, 25).getTime(), "Requested",
                true, false, "Manager review pending", "Awaiting feedback", applicant96, job64);

        JobApplication app215 = new JobApplication("APP215", new GregorianCalendar(2024, Calendar.OCTOBER, 29).getTime(), "Shortlisted",
                true, true, "Excellent skill match", "Verifying start date", applicant98, job65);

        JobApplication app216 = new JobApplication("APP216", new GregorianCalendar(2024, Calendar.NOVEMBER, 1).getTime(), "Pending",
                true, false, "Good fit for team", "Awaiting technical review", applicant80, job63);

        JobApplication app217 = new JobApplication("APP217", new GregorianCalendar(2024, Calendar.NOVEMBER, 1).getTime(), "Shortlisted",
                true, true, "Exceptional interview", "HR offer initiated", applicant81, job64);

        JobApplication app218 = new JobApplication("APP218", new GregorianCalendar(2024, Calendar.NOVEMBER, 2).getTime(), "Pending",
                true, false, "Reviewed by recruiter", "Awaiting manager input", applicant82, job65);

        JobApplication app219 = new JobApplication("APP219", new GregorianCalendar(2024, Calendar.NOVEMBER, 2).getTime(), "Requested",
                true, false, "Skill mismatch", "Not advancing", applicant83, job66);

        JobApplication app220 = new JobApplication("APP220", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), "Pending",
                true, false, "Background check in progress", "Final review pending", applicant84, job67);

        JobApplication app221 = new JobApplication("APP221", new GregorianCalendar(2024, Calendar.NOVEMBER, 4).getTime(), "Shortlisted",
                true, true, "Strong leadership skills", "Offer discussion scheduled", applicant85, job68);

        JobApplication app222 = new JobApplication("APP222", new GregorianCalendar(2024, Calendar.NOVEMBER, 5).getTime(), "Shortlisted",
                true, false, "Candidate interested", "Interview being scheduled", applicant86, job69);

        JobApplication app223 = new JobApplication("APP223", new GregorianCalendar(2024, Calendar.NOVEMBER, 5).getTime(), "Requested",
                true, false, "No relevant certifications", "Application closed", applicant87, job70);

        JobApplication app224 = new JobApplication("APP224", new GregorianCalendar(2024, Calendar.NOVEMBER, 6).getTime(), "Requeted",
                true, false, "Awaiting internal discussion", "Follow-up scheduled", applicant88, job71);

        JobApplication app225 = new JobApplication("APP225", new GregorianCalendar(2024, Calendar.NOVEMBER, 6).getTime(), "Shortlisted",
                true, true, "Excellent coding assessment", "Final round booked", applicant89, job72);

        JobApplication app226 = new JobApplication("APP226", new GregorianCalendar(2024, Calendar.NOVEMBER, 7).getTime(), "Pending",
                true, false, "Potential candidate", "CV shared with team", applicant90, job73);

        JobApplication app227 = new JobApplication("APP227", new GregorianCalendar(2024, Calendar.NOVEMBER, 8).getTime(), "Requested",
                true, false, "Incomplete application", "No further action", applicant91, job74);

        JobApplication app228 = new JobApplication("APP228", new GregorianCalendar(2024, Calendar.NOVEMBER, 9).getTime(), "Pending",
                true, false, "Candidate referred", "Resume in circulation", applicant92, job75);

        JobApplication app229 = new JobApplication("APP229", new GregorianCalendar(2024, Calendar.NOVEMBER, 9).getTime(), "Shortlisted",
                true, true, "Team recommendation", "Offer in process", applicant93, job76);

        JobApplication app230 = new JobApplication("APP230", new GregorianCalendar(2024, Calendar.NOVEMBER, 10).getTime(), "Shortlisted",
                true, false, "Profile forwarded to tech lead", "Awaiting feedback", applicant94, job77);

        JobApplication app231 = new JobApplication("APP231", new GregorianCalendar(2024, Calendar.NOVEMBER, 11).getTime(), "Requested",
                true, false, "Did not pass behavioural round", "Closed", applicant95, job64);

        JobApplication app232 = new JobApplication("APP232", new GregorianCalendar(2024, Calendar.NOVEMBER, 12).getTime(), "Pending",
                true, false, "Further screening required", "Tech team notified", applicant96, job64);

        JobApplication app233 = new JobApplication("APP233", new GregorianCalendar(2024, Calendar.NOVEMBER, 13).getTime(), "Shortlisted",
                true, true, "Great culture fit", "Contract under preparation", applicant97, job65);

        JobApplication app234 = new JobApplication("APP234", new GregorianCalendar(2024, Calendar.NOVEMBER, 14).getTime(), "Pending",
                true, false, "Second opinion required", "Awaiting final go-ahead", applicant98, job66);

        JobApplication app235 = new JobApplication("APP235", new GregorianCalendar(2024, Calendar.NOVEMBER, 15).getTime(), "Shortlisted",
                true, true, "Highly skilled", "Negotiating start date", applicant99, job67);

        JobApplication app236 = new JobApplication("APP236", new GregorianCalendar(2024, Calendar.NOVEMBER, 16).getTime(), "Pending",
                true, false, "Resume reviewed", "Awaiting panel scheduling", applicant1, job65);

        JobApplication app237 = new JobApplication("APP237", new GregorianCalendar(2024, Calendar.NOVEMBER, 16).getTime(), "Shortlisted",
                true, true, "Excellent domain knowledge", "Offer discussion scheduled", applicant2, job66);

        JobApplication app238 = new JobApplication("APP238", new GregorianCalendar(2024, Calendar.NOVEMBER, 17).getTime(), "Pending",
                true, false, "Manager review complete", "Awaiting HR clearance", applicant3, job67);

        JobApplication app239 = new JobApplication("APP239", new GregorianCalendar(2024, Calendar.NOVEMBER, 17).getTime(), "Requested",
                true, false, "Insufficient experience", "Application closed", applicant4, job68);

        JobApplication app240 = new JobApplication("APP240", new GregorianCalendar(2024, Calendar.NOVEMBER, 18).getTime(), "Pending",
                true, false, "Strong communication", "Feedback awaited", applicant5, job69);

        JobApplication app241 = new JobApplication("APP241", new GregorianCalendar(2024, Calendar.NOVEMBER, 18).getTime(), "Shortlisted",
                true, true, "Impressive project portfolio", "Next steps initiated", applicant6, job70);

        JobApplication app242 = new JobApplication("APP242", new GregorianCalendar(2024, Calendar.NOVEMBER, 19).getTime(), "Pending",
                true, false, "Awaiting peer review", "Technical input pending", applicant7, job65);

        JobApplication app243 = new JobApplication("APP243", new GregorianCalendar(2024, Calendar.NOVEMBER, 19).getTime(), "Requested",
                true, false, "Interview score too low", "Closing application", applicant8, job66);

        JobApplication app244 = new JobApplication("APP244", new GregorianCalendar(2024, Calendar.NOVEMBER, 20).getTime(), "Pending",
                true, false, "Needs further assessment", "Pending internal discussion", applicant9, job67);

        JobApplication app245 = new JobApplication("APP245", new GregorianCalendar(2024, Calendar.NOVEMBER, 21).getTime(), "Shortlisted",
                true, true, "Fit with team culture", "Final HR round booked", applicant10, job68);

        JobApplication app246 = new JobApplication("APP246", new GregorianCalendar(2024, Calendar.NOVEMBER, 22).getTime(), "Pending",
                true, false, "Screening results positive", "Scheduling next round", applicant11, job69);

        JobApplication app247 = new JobApplication("APP247", new GregorianCalendar(2024, Calendar.NOVEMBER, 22).getTime(), "Requested",
                true, false, "Better candidates available", "Closing role", applicant12, job70);

        JobApplication app248 = new JobApplication("APP248", new GregorianCalendar(2024, Calendar.NOVEMBER, 23).getTime(), "Pending",
                true, false, "Awaiting input from hiring lead", "On hold", applicant13, job67);

        JobApplication app249 = new JobApplication("APP249", new GregorianCalendar(2024, Calendar.NOVEMBER, 24).getTime(), "Shortlisted",
                true, true, "Stellar background check", "Contract prep underway", applicant14, job68);

        JobApplication app250 = new JobApplication("APP250", new GregorianCalendar(2024, Calendar.NOVEMBER, 25).getTime(), "Pending",
                true, false, "Test assignment received", "Being evaluated", applicant15, job67);

        JobApplication app251 = new JobApplication("APP251", new GregorianCalendar(2024, Calendar.NOVEMBER, 26).getTime(), "Pending",
                true, false, "Preliminary review complete", "Feedback in process", applicant16, job68);

        JobApplication app252 = new JobApplication("APP252", new GregorianCalendar(2024, Calendar.NOVEMBER, 27).getTime(), "Requested",
                true, false, "Candidate declined interview", "Withdrawn", applicant17, job69);

        JobApplication app253 = new JobApplication("APP253", new GregorianCalendar(2024, Calendar.NOVEMBER, 28).getTime(), "Pending",
                true, false, "Manager interested", "Team feedback awaited", applicant18, job70);

        JobApplication app254 = new JobApplication("APP254", new GregorianCalendar(2024, Calendar.NOVEMBER, 29).getTime(), "Shortlisted",
                true, true, "Great communication skills", "Offer sent", applicant19, job70);

        JobApplication app255 = new JobApplication("APP255", new GregorianCalendar(2024, Calendar.NOVEMBER, 29).getTime(), "Pending",
                true, false, "Follow-up interview pending", "HR in touch", applicant20, job71);

        JobApplication app256 = new JobApplication("APP256", new GregorianCalendar(2024, Calendar.DECEMBER, 1).getTime(), "Pending",
                true, false, "Initial screening complete", "Waiting for interview slot", applicant31, job69);

        JobApplication app257 = new JobApplication("APP257", new GregorianCalendar(2024, Calendar.DECEMBER, 1).getTime(), "Shortlisted",
                true, true, "Strong technical skills", "Next stage interview scheduled", applicant32, job70);

        JobApplication app258 = new JobApplication("APP258", new GregorianCalendar(2024, Calendar.DECEMBER, 2).getTime(), "Pending",
                true, false, "CV shortlisted", "Pending team review", applicant33, job71);

        JobApplication app259 = new JobApplication("APP259", new GregorianCalendar(2024, Calendar.DECEMBER, 3).getTime(), "Requested",
                true, false, "Did not meet criteria", "Role closed", applicant34, job72);

        JobApplication app260 = new JobApplication("APP260", new GregorianCalendar(2024, Calendar.DECEMBER, 3).getTime(), "Pending",
                true, false, "Undergoing HR review", "Awaiting feedback", applicant35, job73);

        JobApplication app261 = new JobApplication("APP261", new GregorianCalendar(2024, Calendar.DECEMBER, 4).getTime(), "Shortlisted",
                true, true, "Strong leadership potential", "Interview scheduled", applicant36, job74);

        JobApplication app262 = new JobApplication("APP262", new GregorianCalendar(2024, Calendar.DECEMBER, 5).getTime(), "Pending",
                true, false, "Awaiting technical assessment", "Next step: interview", applicant37, job75);

        JobApplication app263 = new JobApplication("APP263", new GregorianCalendar(2024, Calendar.DECEMBER, 5).getTime(), "Requested",
                true, false, "Insufficient relevant experience", "Closed", applicant38, job76);

        JobApplication app264 = new JobApplication("APP264", new GregorianCalendar(2024, Calendar.DECEMBER, 6).getTime(), "Pending",
                true, false, "Profile being reviewed", "Awaiting further input", applicant39, job77);

        JobApplication app265 = new JobApplication("APP265", new GregorianCalendar(2024, Calendar.DECEMBER, 7).getTime(), "Shortlisted",
                true, true, "Excellent educational background", "Second interview scheduled", applicant40, job78);

        JobApplication app266 = new JobApplication("APP266", new GregorianCalendar(2024, Calendar.DECEMBER, 8).getTime(), "Pending",
                true, false, "Application under review", "Awaiting initial feedback", applicant41, job79);

        JobApplication app267 = new JobApplication("APP267", new GregorianCalendar(2024, Calendar.DECEMBER, 9).getTime(), "Requested",
                true, false, "Candidate withdrew from process", "Application closed", applicant42, job80);

        JobApplication app268 = new JobApplication("APP268", new GregorianCalendar(2024, Calendar.DECEMBER, 9).getTime(), "Requested",
                true, false, "Background check initiated", "Interview follow-up", applicant43, job81);

        JobApplication app269 = new JobApplication("APP269", new GregorianCalendar(2024, Calendar.DECEMBER, 10).getTime(), "Shortlisted",
                true, true, "Highly recommended by team", "Offer extended", applicant44, job82);

        JobApplication app270 = new JobApplication("APP270", new GregorianCalendar(2024, Calendar.DECEMBER, 11).getTime(), "Shortlisted",
                true, false, "Awaiting final interview round", "Scheduled for review", applicant45, job83);

        JobApplication app271 = new JobApplication("APP271", new GregorianCalendar(2024, Calendar.DECEMBER, 11).getTime(), "Requested",
                true, false, "Did not pass technical assessment", "Not proceeding further", applicant46, job70);

        JobApplication app272 = new JobApplication("APP272", new GregorianCalendar(2024, Calendar.DECEMBER, 12).getTime(), "Pending",
                true, false, "Waiting for interview feedback", "Further evaluation pending", applicant47, job70);

        JobApplication app273 = new JobApplication("APP273", new GregorianCalendar(2024, Calendar.DECEMBER, 12).getTime(), "Shortlisted",
                true, true, "Impressive problem-solving skills", "Offer details to be discussed", applicant48, job71);

        JobApplication app274 = new JobApplication("APP274", new GregorianCalendar(2024, Calendar.DECEMBER, 12).getTime(), "Pending",
                true, false, "Review in progress", "Final decision awaiting", applicant49, job72);

        JobApplication app275 = new JobApplication("APP275", new GregorianCalendar(2024, Calendar.DECEMBER, 12).getTime(), "Requested",
                true, false, "Better match found", "Role closed", applicant50, job73);

        JobApplication app276 = new JobApplication("APP276", new GregorianCalendar(2024, Calendar.DECEMBER, 15).getTime(), "Pending",
                true, false, "CV reviewed", "Awaiting interview scheduling", applicant61, job72);

        JobApplication app277 = new JobApplication("APP277", new GregorianCalendar(2024, Calendar.DECEMBER, 16).getTime(), "Shortlisted",
                true, true, "Strong portfolio", "Interview scheduled", applicant62, job73);

        JobApplication app278 = new JobApplication("APP278", new GregorianCalendar(2024, Calendar.DECEMBER, 17).getTime(), "Pending",
                true, false, "Waiting for manager's feedback", "Waiting for response", applicant63, job74);

        JobApplication app279 = new JobApplication("APP279", new GregorianCalendar(2024, Calendar.DECEMBER, 18).getTime(), "Requested",
                true, false, "Not enough experience", "Closed", applicant64, job75);

        JobApplication app280 = new JobApplication("APP280", new GregorianCalendar(2024, Calendar.DECEMBER, 19).getTime(), "Pending",
                true, false, "Awaiting technical assessment result", "To be reviewed", applicant65, job76);

        JobApplication app281 = new JobApplication("APP281", new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), "Shortlisted",
                true, true, "Impressive background", "Offer in progress", applicant66, job77);

        JobApplication app282 = new JobApplication("APP282", new GregorianCalendar(2024, Calendar.DECEMBER, 21).getTime(), "Pending",
                true, false, "Undergoing reference check", "Awaiting results", applicant67, job78);

        JobApplication app283 = new JobApplication("APP283", new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), "Requested",
                true, false, "Lacked required skills", "Role closed", applicant68, job79);

        JobApplication app284 = new JobApplication("APP284", new GregorianCalendar(2024, Calendar.DECEMBER, 23).getTime(), "Pending",
                true, false, "Pending interview results", "Awaiting final decision", applicant69, job80);

        JobApplication app285 = new JobApplication("APP285", new GregorianCalendar(2024, Calendar.DECEMBER, 24).getTime(), "Shortlisted",
                true, true, "Solid leadership experience", "Final interview scheduled", applicant70, job81);

        JobApplication app286 = new JobApplication("APP286", new GregorianCalendar(2025, Calendar.JANUARY, 1).getTime(), "Pending",
                true, false, "Application under review", "Awaiting interview scheduling", applicant81, job75);

        JobApplication app287 = new JobApplication("APP287", new GregorianCalendar(2025, Calendar.JANUARY, 3).getTime(), "Shortlisted",
                true, true, "Strong candidate with relevant skills", "Interview scheduled", applicant82, job76);

        JobApplication app288 = new JobApplication("APP288", new GregorianCalendar(2025, Calendar.JANUARY, 5).getTime(), "Pending",
                true, false, "Background check in progress", "Awaiting response", applicant83, job77);

        JobApplication app289 = new JobApplication("APP289", new GregorianCalendar(2025, Calendar.JANUARY, 10).getTime(), "Requested",
                true, false, "Did not meet requirements", "Role closed", applicant84, job78);

        JobApplication app290 = new JobApplication("APP290", new GregorianCalendar(2025, Calendar.JANUARY, 25).getTime(), "Pending",
                true, false, "Waiting for technical review", "Under evaluation", applicant85, job77);

        JobApplication app291 = new JobApplication("APP291", new GregorianCalendar(2025, Calendar.FEBRUARY, 1).getTime(), "Pending",
                true, false, "Initial application received", "Awaiting interview schedule", applicant1, job79);

        JobApplication app292 = new JobApplication("APP292", new GregorianCalendar(2025, Calendar.FEBRUARY, 5).getTime(), "Shortlisted",
                true, true, "Strong qualifications and experience", "Interview scheduled", applicant2, job80);

        JobApplication app293 = new JobApplication("APP293", new GregorianCalendar(2025, Calendar.FEBRUARY, 10).getTime(), "Shortlisted",
                true, false, "CV under review", "Further details required", applicant3, job85);

        JobApplication app294 = new JobApplication("APP294", new GregorianCalendar(2025, Calendar.FEBRUARY, 15).getTime(), "Pending",
                true, false, "Lacks required qualifications", "Application not progressed", applicant4, job89);

        JobApplication app295 = new JobApplication("APP295", new GregorianCalendar(2025, Calendar.MARCH, 1).getTime(), "Shortlisted",
                true, false, "Application received", "Awaiting screening", applicant5, job84);

        JobApplication app296 = new JobApplication("APP296", new GregorianCalendar(2025, Calendar.MARCH, 5).getTime(), "Shortlisted",
                true, true, "Great credentials", "Interview scheduled", applicant8, job85);

        JobApplication app297 = new JobApplication("APP297", new GregorianCalendar(2025, Calendar.MARCH, 10).getTime(), "Pending",
                true, false, "Referred by employee", "Awaiting interview invitation", applicant12, job86);

        JobApplication app298 = new JobApplication("APP298", new GregorianCalendar(2025, Calendar.MARCH, 15).getTime(), "Requested",
                true, false, "Missing qualifications", "Not a fit", applicant15, job87);

        JobApplication app299 = new JobApplication("APP299", new GregorianCalendar(2025, Calendar.MARCH, 25).getTime(), "Requested",
                true, false, "Needs further evaluation", "Pending final screening", applicant18, job88);

        JobApplication app300 = new JobApplication("APP300", new GregorianCalendar(2025, Calendar.APRIL, 5).getTime(), "Shortlisted",
                true, true, "Excellent interview", "Awaiting final offer", applicant20, job90);

        // Create schedules
        Schedule s1 = new Schedule(
                new GregorianCalendar(2024, Calendar.JANUARY, 26).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 10, 0).getTime(),
                "Online", "Zoom",
                new GregorianCalendar(2024, Calendar.JANUARY, 30).getTime(),
                new GregorianCalendar(0, 0, 0, 12, 0).getTime(),
                "Completed", alice, applicant1, job1, null);

        Schedule s2 = new Schedule(
                new GregorianCalendar(2024, Calendar.JANUARY, 26).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 11, 30).getTime(),
                "Offline", "Office",
                new GregorianCalendar(2024, Calendar.JANUARY, 30).getTime(),
                new GregorianCalendar(0, 0, 0, 14, 0).getTime(),
                "Completed", bob, applicant2, job13, null);

        Schedule s3 = new Schedule(
                new GregorianCalendar(2024, Calendar.FEBRUARY, 13).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 9, 15).getTime(),
                "Online", "Zoom",
                new GregorianCalendar(2024, Calendar.FEBRUARY, 14).getTime(),
                new GregorianCalendar(0, 0, 0, 10, 30).getTime(),
                "Completed", frank, applicant3, job5, null);

        Schedule s4 = new Schedule(
                new GregorianCalendar(2024, Calendar.FEBRUARY, 14).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 13, 45).getTime(),
                "Offline", "HQ",
                new GregorianCalendar(2024, Calendar.FEBRUARY, 16).getTime(),
                new GregorianCalendar(0, 0, 0, 9, 0).getTime(),
                "Scheduled", david, applicant4, job18, null);

        Schedule s5 = new Schedule(
                new GregorianCalendar(2024, Calendar.FEBRUARY, 20).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 16, 20).getTime(),
                "Online", "Zoom",
                new GregorianCalendar(2024, Calendar.FEBRUARY, 21).getTime(),
                new GregorianCalendar(0, 0, 0, 11, 15).getTime(),
                "Completed", frank, applicant5, job5, null);

        Schedule s6 = new Schedule(
                new GregorianCalendar(2024, Calendar.FEBRUARY, 20).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 8, 0).getTime(),
                "Offline", "Lab",
                new GregorianCalendar(2024, Calendar.FEBRUARY, 22).getTime(),
                new GregorianCalendar(0, 0, 0, 13, 30).getTime(),
                "Completed", carol, applicant2, job3, null);

        Schedule s7 = new Schedule(
                new GregorianCalendar(2024, Calendar.FEBRUARY, 21).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 14, 10).getTime(),
                "Online", "Zoom",
                new GregorianCalendar(2024, Calendar.FEBRUARY, 22).getTime(),
                new GregorianCalendar(0, 0, 0, 15, 45).getTime(),
                "Completed", henry, applicant3, job7, null);

        Schedule s8 = new Schedule(
                new GregorianCalendar(2024, Calendar.FEBRUARY, 24).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 10, 30).getTime(),
                "Offline", "Room 101",
                new GregorianCalendar(2024, Calendar.FEBRUARY, 26).getTime(),
                new GregorianCalendar(0, 0, 0, 10, 0).getTime(),
                "Scheduled", frank, applicant2, job19, null);

        Schedule s9 = new Schedule(
                new GregorianCalendar(2024, Calendar.FEBRUARY, 25).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 11, 0).getTime(),
                "Online", "Zoom",
                new GregorianCalendar(2024, Calendar.FEBRUARY, 26).getTime(),
                new GregorianCalendar(0, 0, 0, 16, 20).getTime(),
                "Completed", irene, applicant1, job27, null);

        Schedule s10 = new Schedule(
                new GregorianCalendar(2024, Calendar.FEBRUARY, 26).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 9, 45).getTime(),
                "Offline", "Floor 3",
                new GregorianCalendar(2024, Calendar.APRIL, 27).getTime(),
                new GregorianCalendar(0, 0, 0, 14, 15).getTime(),
                "Completed", henry, applicant3,  job8, null);

        Schedule s11 = new Schedule(
                new GregorianCalendar(2024, Calendar.MARCH, 5).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 13, 0).getTime(),
                "Online", "Zoom",
                new GregorianCalendar(2024, Calendar.MARCH, 6).getTime(),
                new GregorianCalendar(0, 0, 0, 9, 30).getTime(),
                "Completed", jack, applicant6, job30, null);

        Schedule s12 = new Schedule(
                new GregorianCalendar(2024, Calendar.MARCH, 6).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 15, 30).getTime(),
                "Offline", "Annex",
                new GregorianCalendar(2024, Calendar.MARCH, 7).getTime(),
                new GregorianCalendar(0, 0, 0, 11, 0).getTime(),
                "Scheduled", carol, applicant7, job11, null);

        Schedule s13 = new Schedule(
                new GregorianCalendar(2024, Calendar.MARCH, 7).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 8, 45).getTime(),
                "Online", "Zoom",
                new GregorianCalendar(2024, Calendar.MARCH, 9).getTime(),
                new GregorianCalendar(0, 0, 0, 14, 45).getTime(),
                "Completed", alice, applicant8, job1, null);

        Schedule s14 = new Schedule(
                new GregorianCalendar(2024, Calendar.MARCH, 7).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 12, 15).getTime(),
                "Offline", "Room 202",
                new GregorianCalendar(2024, Calendar.APRIL, 8).getTime(),
                new GregorianCalendar(0, 0, 0, 10, 15).getTime(),
                "Completed", bob, applicant9, job14, null);

        Schedule s15 = new Schedule(
                new GregorianCalendar(2024, Calendar.MARCH, 8).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 16, 0).getTime(),
                "Online", "Zoom",
                new GregorianCalendar(2024, Calendar.MARCH, 9).getTime(),
                new GregorianCalendar(0, 0, 0, 13, 0).getTime(),
                "Completed", bob, applicant10, job14, null);

        Schedule s16 = new Schedule(
                new GregorianCalendar(2024, Calendar.MARCH, 8).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 9, 30).getTime(),
                "Offline", "Main Office",
                new GregorianCalendar(2024, Calendar.MARCH, 9).getTime(),
                new GregorianCalendar(0, 0, 0, 16, 30).getTime(),
                "Scheduled", alice, applicant11, job1, null);

        Schedule s17 = new Schedule(
                new GregorianCalendar(2024, Calendar.MARCH, 10).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 14, 0).getTime(),
                "Online", "Zoom",
                new GregorianCalendar(2024, Calendar.MARCH, 11).getTime(),
                new GregorianCalendar(0, 0, 0, 8, 45).getTime(),
                "Completed", kevin, applicant12, job17, null);

        Schedule s18 = new Schedule(
                new GregorianCalendar(2024, Calendar.MARCH, 12).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 10, 45).getTime(),
                "Offline", "Lab 2",
                new GregorianCalendar(2024, Calendar.MARCH, 14).getTime(),
                new GregorianCalendar(0, 0, 0, 12, 45).getTime(),
                "Completed", jack, applicant13, job30, null);

        Schedule s19 = new Schedule(
                new GregorianCalendar(2024, Calendar.MARCH, 15).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 11, 30).getTime(),
                "Online", "Webex",
                new GregorianCalendar(2024, Calendar.MARCH, 16).getTime(),
                new GregorianCalendar(0, 0, 0, 15, 0).getTime(),
                "Completed", carol, applicant4, job11, null);

        Schedule s20 = new Schedule(
                new GregorianCalendar(2024, Calendar.MARCH, 15).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 8, 15).getTime(),
                "Offline", "Room 303",
                new GregorianCalendar(2024, Calendar.MAY, 16).getTime(),
                new GregorianCalendar(0, 0, 0, 9, 30).getTime(),
                "Scheduled", alice, applicant15, job1, null);

        Schedule s21 = new Schedule(
                new GregorianCalendar(2024, Calendar.APRIL, 5).getTime(), "45 mins",
                new GregorianCalendar(0, 0, 0, 10, 0).getTime(),
                "Online", "Zoom",
                new GregorianCalendar(2024, Calendar.APRIL, 6).getTime(),
                new GregorianCalendar(0, 0, 0, 14, 30).getTime(),
                "Completed", kevin, applicant20, job17, null);

        Schedule s22 = new Schedule(
                new GregorianCalendar(2024, Calendar.APRIL, 6).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 9, 0).getTime(),
                "Offline", "Room 101",
                new GregorianCalendar(2024, Calendar.APRIL, 7).getTime(),
                new GregorianCalendar(0, 0, 0, 10, 0).getTime(),
                "Completed", david, applicant21, job4, null);

        Schedule s23 = new Schedule(
                new GregorianCalendar(2024, Calendar.APRIL, 7).getTime(), "60 mins",
                new GregorianCalendar(0, 0, 0, 13, 0).getTime(),
                "Online", "Google Meet",
                new GregorianCalendar(2024, Calendar.APRIL, 8).getTime(),
                new GregorianCalendar(0, 0, 0, 15, 0).getTime(),
                "Completed", frank, applicant22, job19, null);

        Schedule s24 = new Schedule(
                new GregorianCalendar(2024, Calendar.APRIL, 8).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 15, 15).getTime(),
                "Offline", "Room 205",
                new GregorianCalendar(2024, Calendar.APRIL, 10).getTime(),
                new GregorianCalendar(0, 0, 0, 16, 0).getTime(),
                "Completed", emily, applicant23, job20, null);

        Schedule s25 = new Schedule(
                new GregorianCalendar(2024, Calendar.APRIL, 9).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 8, 45).getTime(),
                "Online", "Skype",
                new GregorianCalendar(2024, Calendar.APRIL, 11).getTime(),
                new GregorianCalendar(0, 0, 0, 11, 0).getTime(),
                "Completed", oliver, applicant24, job21, null);

        Schedule s26 = new Schedule(
                new GregorianCalendar(2024, Calendar.APRIL, 10).getTime(), "45 mins",
                new GregorianCalendar(0, 0, 0, 9, 30).getTime(),
                "Offline", "Room 312",
                new GregorianCalendar(2024, Calendar.APRIL, 12).getTime(),
                new GregorianCalendar(0, 0, 0, 10, 30).getTime(),
                "Completed", oliver, applicant25, job22, "I want to change to 10-4-2024 because I have dinner with family on 08-4-2024");

        Schedule s27 = new Schedule(
                new GregorianCalendar(2024, Calendar.APRIL, 11).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 14, 15).getTime(),
                "Online", "Webex",
                new GregorianCalendar(2024, Calendar.APRIL, 13).getTime(),
                new GregorianCalendar(0, 0, 0, 15, 45).getTime(),
                "Completed", emily, applicant23, job20, null);

        Schedule s28 = new Schedule(
                new GregorianCalendar(2024, Calendar.APRIL, 28).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 11, 45).getTime(),
                "Offline", "Room 110",
                new GregorianCalendar(2024, Calendar.APRIL, 29).getTime(),
                new GregorianCalendar(0, 0, 0, 13, 0).getTime(),
                "Completed", grace, applicant46, job24, null);

        Schedule s29 = new Schedule(
                new GregorianCalendar(2024, Calendar.APRIL, 30).getTime(), "60 mins",
                new GregorianCalendar(0, 0, 0, 10, 30).getTime(),
                "Online", "Zoom",
                new GregorianCalendar(2024, Calendar.MAY, 1).getTime(),
                new GregorianCalendar(0, 0, 0, 12, 0).getTime(),
                "Completed", henry, applicant49, job7, null);

        Schedule s30 = new Schedule(
                new GregorianCalendar(2024, Calendar.MAY, 5).getTime(), "45 mins",
                new GregorianCalendar(0, 0, 0, 13, 30).getTime(),
                "Offline", "Room 209",
                new GregorianCalendar(2024, Calendar.MAY, 6).getTime(),
                new GregorianCalendar(0, 0, 0, 14, 15).getTime(),
                "Completed", henry, applicant62, job8, null);

        Schedule s31 = new Schedule(
                new GregorianCalendar(2024, Calendar.MAY, 15).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 9, 0).getTime(),
                "Online", "Google Meet",
                new GregorianCalendar(2024, Calendar.MAY, 16).getTime(),
                new GregorianCalendar(0, 0, 0, 10, 0).getTime(),
                "Scheduled", irene, applicant70, job15, null);

        Schedule s32 = new Schedule(
                new GregorianCalendar(2024, Calendar.MAY, 17).getTime(), "45 mins",
                new GregorianCalendar(0, 0, 0, 10, 30).getTime(),
                "Offline", "Room 201",
                new GregorianCalendar(2024, Calendar.MAY, 18).getTime(),
                new GregorianCalendar(0, 0, 0, 11, 15).getTime(),
                "Completed", farah, applicant71, job28, null);

        Schedule s33 = new Schedule(
                new GregorianCalendar(2024, Calendar.MAY, 20).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 14, 0).getTime(),
                "Online", "Zoom",
                new GregorianCalendar(2024, Calendar.MAY, 21).getTime(),
                new GregorianCalendar(0, 0, 0, 15, 0).getTime(),
                "Completed", jack, applicant72, job30, null);

        Schedule s34 = new Schedule(
                new GregorianCalendar(2024, Calendar.MAY, 22).getTime(), "60 mins",
                new GregorianCalendar(0, 0, 0, 8, 30).getTime(),
                "Offline", "Room 105",
                new GregorianCalendar(2024, Calendar.MAY, 23).getTime(),
                new GregorianCalendar(0, 0, 0, 10, 0).getTime(),
                "Scheduled", jack, applicant73, job30, null);

        Schedule s35 = new Schedule(
                new GregorianCalendar(2024, Calendar.MAY, 27).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 13, 45).getTime(),
                "Online", "Skype",
                new GregorianCalendar(2024, Calendar.MAY, 29).getTime(),
                new GregorianCalendar(0, 0, 0, 15, 15).getTime(),
                "Completed", faiz, applicant84, job31, null);

        Schedule s36 = new Schedule(
                new GregorianCalendar(2024, Calendar.MAY, 28).getTime(), "45 mins",
                new GregorianCalendar(0, 0, 0, 10, 15).getTime(),
                "Offline", "Room 307",
                new GregorianCalendar(2024, Calendar.MAY, 29).getTime(),
                new GregorianCalendar(0, 0, 0, 11, 45).getTime(),
                "Cancelled", arif, applicant85, job32, null);

        Schedule s37 = new Schedule(
                new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 11, 0).getTime(),
                "Online", "Webex",
                new GregorianCalendar(2024, Calendar.MAY, 31).getTime(),
                new GregorianCalendar(0, 0, 0, 12, 30).getTime(),
                "Completed", arif, applicant86, job33, null);

        Schedule s38 = new Schedule(
                new GregorianCalendar(2024, Calendar.JUNE, 2).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 9, 30).getTime(),
                "Offline", "Room 114",
                new GregorianCalendar(2024, Calendar.JUNE, 3).getTime(),
                new GregorianCalendar(0, 0, 0, 10, 30).getTime(),
                "Scheduled", leon, applicant87, job36, null);

        Schedule s39 = new Schedule(
                new GregorianCalendar(2024, Calendar.JUNE, 5).getTime(), "60 mins",
                new GregorianCalendar(0, 0, 0, 14, 0).getTime(),
                "Online", "Microsoft Teams",
                new GregorianCalendar(2024, Calendar.JUNE, 6).getTime(),
                new GregorianCalendar(0, 0, 0, 15, 0).getTime(),
                "Completed", teh, applicant88, job37, null);

        Schedule s40 = new Schedule(
                new GregorianCalendar(2024, Calendar.JUNE, 10).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 10, 45).getTime(),
                "Offline", "Room 220",
                new GregorianCalendar(2024, Calendar.JUNE, 11).getTime(),
                new GregorianCalendar(0, 0, 0, 11, 30).getTime(),
                "Scheduled", leon, applicant99, job36, null);

        Schedule s41 = new Schedule(
                new GregorianCalendar(2024, Calendar.JUNE, 15).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 9, 30).getTime(),
                "Online", "Zoom",
                new GregorianCalendar(2024, Calendar.JUNE, 16).getTime(),
                new GregorianCalendar(0, 0, 0, 10, 30).getTime(),
                "Completed", teh, applicant25, job37, null);

        Schedule s42 = new Schedule(
                new GregorianCalendar(2024, Calendar.JUNE, 17).getTime(), "60 mins",
                new GregorianCalendar(0, 0, 0, 14, 0).getTime(),
                "Offline", "Room 108",
                new GregorianCalendar(2024, Calendar.JUNE, 18).getTime(),
                new GregorianCalendar(0, 0, 0, 15, 0).getTime(),
                "Scheduled", arif, applicant33, job32, null);

        Schedule s43 = new Schedule(
                new GregorianCalendar(2024, Calendar.JUNE, 20).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 10, 45).getTime(),
                "Online", "Google Meet",
                new GregorianCalendar(2024, Calendar.JUNE, 21).getTime(),
                new GregorianCalendar(0, 0, 0, 11, 45).getTime(),
                "Completed", joanna, applicant90, job39, null);

        Schedule s44 = new Schedule(
                new GregorianCalendar(2024, Calendar.JUNE, 23).getTime(), "45 mins",
                new GregorianCalendar(0, 0, 0, 9, 15).getTime(),
                "Offline", "Room 302",
                new GregorianCalendar(2024, Calendar.JUNE, 24).getTime(),
                new GregorianCalendar(0, 0, 0, 10, 30).getTime(),
                "Completed", joanna, applicant60, job40, null);

        Schedule s45 = new Schedule(
                new GregorianCalendar(2024, Calendar.JUNE, 26).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 13, 0).getTime(),
                "Online", "Webex",
                new GregorianCalendar(2024, Calendar.JUNE, 27).getTime(),
                new GregorianCalendar(0, 0, 0, 14, 0).getTime(),
                "Completed", kelvin, applicant3, job42, null);

        Schedule s46 = new Schedule(
                new GregorianCalendar(2024, Calendar.JUNE, 29).getTime(), "60 mins",
                new GregorianCalendar(0, 0, 0, 15, 0).getTime(),
                "Offline", "Room 214",
                new GregorianCalendar(2024, Calendar.JUNE, 30).getTime(),
                new GregorianCalendar(0, 0, 0, 16, 0).getTime(),
                "Cancelled", yap, applicant84, job50, null);

        Schedule s47 = new Schedule(
                new GregorianCalendar(2024, Calendar.JULY, 2).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 11, 30).getTime(),
                "Online", "Skype",
                new GregorianCalendar(2024, Calendar.JULY, 3).getTime(),
                new GregorianCalendar(0, 0, 0, 12, 30).getTime(),
                "Scheduled", sarah, applicant91, job57, null);

        Schedule s48 = new Schedule(
                new GregorianCalendar(2024, Calendar.JULY, 5).getTime(), "45 mins",
                new GregorianCalendar(0, 0, 0, 9, 0).getTime(),
                "Offline", "Room 100",
                new GregorianCalendar(2024, Calendar.JULY, 6).getTime(),
                new GregorianCalendar(0, 0, 0, 10, 15).getTime(),
                "Completed", linda, applicant17, job46, null);

        Schedule s49 = new Schedule(
                new GregorianCalendar(2024, Calendar.JULY, 8).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 10, 0).getTime(),
                "Online", "Zoom",
                new GregorianCalendar(2024, Calendar.JULY, 9).getTime(),
                new GregorianCalendar(0, 0, 0, 11, 0).getTime(),
                "Completed", elaine, applicant19, job47, null);

        Schedule s50 = new Schedule(
                new GregorianCalendar(2024, Calendar.JULY, 11).getTime(), "60 mins",
                new GregorianCalendar(0, 0, 0, 14, 30).getTime(),
                "Offline", "Room 115",
                new GregorianCalendar(2024, Calendar.JULY, 12).getTime(),
                new GregorianCalendar(0, 0, 0, 15, 45).getTime(),
                "Completed", elaine, applicant39, job48, null);

        Schedule s51 = new Schedule(
                new GregorianCalendar(2024, Calendar.JULY, 14).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 9, 45).getTime(),
                "Online", "Microsoft Teams",
                new GregorianCalendar(2024, Calendar.JULY, 15).getTime(),
                new GregorianCalendar(0, 0, 0, 10, 45).getTime(),
                "Completed", yap, applicant73, job50, null);

        Schedule s52 = new Schedule(
                new GregorianCalendar(2024, Calendar.JULY, 27).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 13, 15).getTime(),
                "Offline", "Room 303",
                new GregorianCalendar(2024, Calendar.JULY, 28).getTime(),
                new GregorianCalendar(0, 0, 0, 14, 15).getTime(),
                "Scheduled", yap, applicant84, job50, null);

        Schedule s53 = new Schedule(
                new GregorianCalendar(2024, Calendar.AUGUST, 10).getTime(), "45 mins",
                new GregorianCalendar(0, 0, 0, 11, 0).getTime(),
                "Online", "Google Meet",
                new GregorianCalendar(2024, Calendar.AUGUST, 12).getTime(),
                new GregorianCalendar(0, 0, 0, 12, 30).getTime(),
                "Completed", shafiq, applicant15, job55, null);

        Schedule s54 = new Schedule(
                new GregorianCalendar(2024, Calendar.AUGUST, 16).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 14, 0).getTime(),
                "Offline", "Room 401",
                new GregorianCalendar(2024, Calendar.AUGUST, 17).getTime(),
                new GregorianCalendar(0, 0, 0, 15, 0).getTime(),
                "Scheduled", nash, applicant17, job56, null);

        Schedule s55 = new Schedule(
                new GregorianCalendar(2024, Calendar.AUGUST, 16).getTime(), "60 mins",
                new GregorianCalendar(0, 0, 0, 10, 30).getTime(),
                "Online", "Webex",
                new GregorianCalendar(2024, Calendar.AUGUST, 16).getTime(),
                new GregorianCalendar(0, 0, 0, 12, 0).getTime(),
                "Scheduled", ryan, applicant19, job60, null);

        Schedule s56 = new Schedule(
                new GregorianCalendar(2024, Calendar.AUGUST, 20).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 10, 0).getTime(),
                "Online", "Zoom",
                new GregorianCalendar(2024, Calendar.AUGUST, 21).getTime(),
                new GregorianCalendar(0, 0, 0, 11, 0).getTime(),
                "Completed", ryan, applicant21, job60, null);

        Schedule s57 = new Schedule(
                new GregorianCalendar(2024, Calendar.AUGUST, 23).getTime(), "60 mins",
                new GregorianCalendar(0, 0, 0, 14, 30).getTime(),
                "Offline", "Room 202",
                new GregorianCalendar(2024, Calendar.AUGUST, 24).getTime(),
                new GregorianCalendar(0, 0, 0, 15, 30).getTime(),
                "Scheduled", shafiq, applicant23, job55, null);

        Schedule s58 = new Schedule(
                new GregorianCalendar(2024, Calendar.SEPTEMBER, 14).getTime(), "45 mins",
                new GregorianCalendar(0, 0, 0, 9, 15).getTime(),
                "Online", "Microsoft Teams",
                new GregorianCalendar(2024, Calendar.SEPTEMBER, 16).getTime(),
                new GregorianCalendar(0, 0, 0, 10, 0).getTime(),
                "Completed", nash, applicant56, job56, null);

        Schedule s59 = new Schedule(
                new GregorianCalendar(2024, Calendar.SEPTEMBER, 17).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 13, 0).getTime(),
                "Offline", "Room 101",
                new GregorianCalendar(2024, Calendar.SEPTEMBER, 18).getTime(),
                new GregorianCalendar(0, 0, 0, 14, 0).getTime(),
                "Scheduled", sarah, applicant57, job57, null);

        Schedule s60 = new Schedule(
                new GregorianCalendar(2024, Calendar.SEPTEMBER, 23).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 11, 30).getTime(),
                "Online", "Skype",
                new GregorianCalendar(2024, Calendar.SEPTEMBER, 24).getTime(),
                new GregorianCalendar(0, 0, 0, 12, 30).getTime(),
                "Completed", cindy, applicant59, job59, null);

        Schedule s61 = new Schedule(
                new GregorianCalendar(2024, Calendar.SEPTEMBER, 26).getTime(), "60 mins",
                new GregorianCalendar(0, 0, 0, 15, 0).getTime(),
                "Offline", "Room 405",
                new GregorianCalendar(2024, Calendar.SEPTEMBER, 27).getTime(),
                new GregorianCalendar(0, 0, 0, 16, 0).getTime(),
                "Scheduled", ryan, applicant60, job60, null);

        Schedule s62 = new Schedule(
                new GregorianCalendar(2024, Calendar.OCTOBER, 20).getTime(), "45 mins",
                new GregorianCalendar(0, 0, 0, 10, 15).getTime(),
                "Online", "Google Meet",
                new GregorianCalendar(2024, Calendar.OCTOBER, 21).getTime(),
                new GregorianCalendar(0, 0, 0, 11, 0).getTime(),
                "Completed", syafiq, applicant90, job62, null);

        Schedule s63 = new Schedule(
                new GregorianCalendar(2024, Calendar.OCTOBER, 21).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 9, 0).getTime(),
                "Offline", "Room 118",
                new GregorianCalendar(2024, Calendar.OCTOBER, 22).getTime(),
                new GregorianCalendar(0, 0, 0, 10, 0).getTime(),
                "Scheduled", shafiq, applicant92, job62, null);

        Schedule s64 = new Schedule(
                new GregorianCalendar(2024, Calendar.OCTOBER, 25).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 13, 30).getTime(),
                "Online", "Webex",
                new GregorianCalendar(2024, Calendar.OCTOBER, 26).getTime(),
                new GregorianCalendar(0, 0, 0, 14, 30).getTime(),
                "Completed", jenny, applicant94, job78, null);

        Schedule s65 = new Schedule(
                new GregorianCalendar(2024, Calendar.OCTOBER, 28).getTime(), "45 mins",
                new GregorianCalendar(0, 0, 0, 10, 30).getTime(),
                "Offline", "Room 119",
                new GregorianCalendar(2024, Calendar.OCTOBER, 30).getTime(),
                new GregorianCalendar(0, 0, 0, 11, 15).getTime(),
                "Completed", siti, applicant96, job64, null);

        Schedule s66 = new Schedule(
                new GregorianCalendar(2024, Calendar.OCTOBER, 28).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 14, 15).getTime(),
                "Online", "Zoom",
                new GregorianCalendar(2024, Calendar.OCTOBER, 30).getTime(),
                new GregorianCalendar(0, 0, 0, 15, 15).getTime(),
                "Completed", khoo, applicant98, job66, null);

        Schedule s67 = new Schedule(
                new GregorianCalendar(2024, Calendar.NOVEMBER, 5).getTime(), "60 mins",
                new GregorianCalendar(0, 0, 0, 9, 30).getTime(),
                "Offline", "Room 205",
                new GregorianCalendar(2024, Calendar.NOVEMBER, 6).getTime(),
                new GregorianCalendar(0, 0, 0, 10, 30).getTime(),
                "Cancelled", azmi, applicant86, job70, null);

        Schedule s68 = new Schedule(
                new GregorianCalendar(2024, Calendar.NOVEMBER, 18).getTime(), "45 mins",
                new GregorianCalendar(0, 0, 0, 13, 0).getTime(),
                "Online", "Google Meet",
                new GregorianCalendar(2024, Calendar.NOVEMBER, 19).getTime(),
                new GregorianCalendar(0, 0, 0, 13, 45).getTime(),
                "Scheduled", liew, applicant85, job69, null);

        Schedule s69 = new Schedule(
                new GregorianCalendar(2024, Calendar.NOVEMBER, 19).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 15, 15).getTime(),
                "Offline", "Room 220",
                new GregorianCalendar(2024, Calendar.NOVEMBER, 20).getTime(),
                new GregorianCalendar(0, 0, 0, 16, 15).getTime(),
                "Completed", liew, applicant86, job85, null);

        Schedule s70 = new Schedule(
                new GregorianCalendar(2024, Calendar.NOVEMBER, 21).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 10, 45).getTime(),
                "Online", "Skype",
                new GregorianCalendar(2024, Calendar.NOVEMBER, 23).getTime(),
                new GregorianCalendar(0, 0, 0, 11, 45).getTime(),
                "Scheduled", azmi, applicant87, job70, null);

        Schedule s71 = new Schedule(
                new GregorianCalendar(2024, Calendar.NOVEMBER, 27).getTime(), "45 mins",
                new GregorianCalendar(0, 0, 0, 9, 30).getTime(),
                "Online", "Zoom",
                new GregorianCalendar(2024, Calendar.NOVEMBER, 28).getTime(),
                new GregorianCalendar(0, 0, 0, 10, 15).getTime(),
                "Scheduled", siti, applicant88, job71, null);

        Schedule s72 = new Schedule(
                new GregorianCalendar(2024, Calendar.DECEMBER, 2).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 11, 0).getTime(),
                "Offline", "Room 201",
                new GregorianCalendar(2024, Calendar.DECEMBER, 3).getTime(),
                new GregorianCalendar(0, 0, 0, 12, 0).getTime(),
                "Completed", zafran, applicant89, job72, null);

        Schedule s73 = new Schedule(
                new GregorianCalendar(2024, Calendar.DECEMBER, 6).getTime(), "60 mins",
                new GregorianCalendar(0, 0, 0, 13, 15).getTime(),
                "Online", "Microsoft Teams",
                new GregorianCalendar(2024, Calendar.DECEMBER, 7).getTime(),
                new GregorianCalendar(0, 0, 0, 14, 15).getTime(),
                "Scheduled", ivan, applicant90, job74, null);

        Schedule s74 = new Schedule(
                new GregorianCalendar(2024, Calendar.DECEMBER, 10).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 10, 45).getTime(),
                "Offline", "Room 305",
                new GregorianCalendar(2024, Calendar.DECEMBER, 11).getTime(),
                new GregorianCalendar(0, 0, 0, 11, 45).getTime(),
                "Completed", ivan, applicant91, job75, null);

        Schedule s75 = new Schedule(
                new GregorianCalendar(2024, Calendar.DECEMBER, 15).getTime(), "45 mins",
                new GregorianCalendar(0, 0, 0, 14, 0).getTime(),
                "Online", "Skype",
                new GregorianCalendar(2024, Calendar.DECEMBER, 16).getTime(),
                new GregorianCalendar(0, 0, 0, 14, 45).getTime(),
                "Scheduled", ivan, applicant92, job74, null);

        Schedule s76 = new Schedule(
                new GregorianCalendar(2024, Calendar.DECEMBER, 19).getTime(), "60 mins",
                new GregorianCalendar(0, 0, 0, 15, 30).getTime(),
                "Offline", "Room 118",
                new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(),
                new GregorianCalendar(0, 0, 0, 16, 30).getTime(),
                "Completed", darren, applicant93, job76, null);

        Schedule s77 = new Schedule(
                new GregorianCalendar(2025, Calendar.JANUARY, 3).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 9, 15).getTime(),
                "Online", "Google Meet",
                new GregorianCalendar(2025, Calendar.JANUARY, 4).getTime(),
                new GregorianCalendar(0, 0, 0, 10, 15).getTime(),
                "Scheduled", jenny, applicant94, job78, null);

        Schedule s78 = new Schedule(
                new GregorianCalendar(2025, Calendar.JANUARY, 8).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 11, 30).getTime(),
                "Offline", "Room 214",
                new GregorianCalendar(2025, Calendar.JANUARY, 9).getTime(),
                new GregorianCalendar(0, 0, 0, 12, 30).getTime(),
                "Completed", jenny, applicant67, job78, null);

        Schedule s79 = new Schedule(
                new GregorianCalendar(2025, Calendar.JANUARY, 14).getTime(), "60 mins",
                new GregorianCalendar(0, 0, 0, 13, 0).getTime(),
                "Online", "Webex",
                new GregorianCalendar(2025, Calendar.JANUARY, 15).getTime(),
                new GregorianCalendar(0, 0, 0, 14, 0).getTime(),
                "Scheduled", nurul, applicant68, job79,null);

        Schedule s80 = new Schedule(
                new GregorianCalendar(2025, Calendar.JANUARY, 28).getTime(), "45 mins",
                new GregorianCalendar(0, 0, 0, 10, 0).getTime(),
                "Offline", "Room 305",
                new GregorianCalendar(2025, Calendar.JANUARY, 30).getTime(),
                new GregorianCalendar(0, 0, 0, 10, 45).getTime(),
                "Scheduled", goh, applicant69, job89, null);

        Schedule s81 = new Schedule(
                new GregorianCalendar(2025, Calendar.JANUARY, 30).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 11, 15).getTime(),
                "Online", "Zoom",
                new GregorianCalendar(2025, Calendar.JANUARY, 31).getTime(),
                new GregorianCalendar(0, 0, 0, 12, 0).getTime(),
                "Scheduled", fauzi, applicant43, job82, null);

        Schedule s82 = new Schedule(
                new GregorianCalendar(2025, Calendar.FEBRUARY, 3).getTime(), "60 mins",
                new GregorianCalendar(0, 0, 0, 14, 0).getTime(),
                "Offline", "Room 109",
                new GregorianCalendar(2025, Calendar.FEBRUARY, 4).getTime(),
                new GregorianCalendar(0, 0, 0, 15, 0).getTime(),
                "Completed", fauzi, applicant44, job82, null);

        Schedule s83 = new Schedule(
                new GregorianCalendar(2025, Calendar.FEBRUARY, 8).getTime(), "45 mins",
                new GregorianCalendar(0, 0, 0, 10, 30).getTime(),
                "Online", "Google Meet",
                new GregorianCalendar(2025, Calendar.FEBRUARY, 9).getTime(),
                new GregorianCalendar(0, 0, 0, 11, 15).getTime(),
                "Scheduled", fauzi, applicant45, job83, null);

        Schedule s84 = new Schedule(
                new GregorianCalendar(2025, Calendar.FEBRUARY, 13).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 9, 0).getTime(),
                "Offline", "Room 207",
                new GregorianCalendar(2025, Calendar.FEBRUARY, 14).getTime(),
                new GregorianCalendar(0, 0, 0, 10, 0).getTime(),
                "Completed", elly, applicant3, job85, null);

        Schedule s85 = new Schedule(
                new GregorianCalendar(2025, Calendar.FEBRUARY, 20).getTime(), "60 mins",
                new GregorianCalendar(0, 0, 0, 13, 45).getTime(),
                "Online", "Webex",
                new GregorianCalendar(2025, Calendar.FEBRUARY, 21).getTime(),
                new GregorianCalendar(0, 0, 0, 14, 45).getTime(),
                "Scheduled", goh, applicant2, job88, null);

        Schedule s86 = new Schedule(
                new GregorianCalendar(2025, Calendar.MARCH, 15).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 15, 15).getTime(),
                "Offline", "Room 122",
                new GregorianCalendar(2025, Calendar.MARCH, 17).getTime(),
                new GregorianCalendar(0, 0, 0, 16, 0).getTime(),
                "Scheduled", elly, applicant12, job86, null);

        Schedule s87 = new Schedule(
                new GregorianCalendar(2025, Calendar.MARCH, 18).getTime(), "45 mins",
                new GregorianCalendar(0, 0, 0, 8, 30).getTime(),
                "Online", "Skype",
                new GregorianCalendar(2025, Calendar.MARCH, 19).getTime(),
                new GregorianCalendar(0, 0, 0, 9, 15).getTime(),
                "Completed", nurul, applicant15, job84, null);

        Schedule s88 = new Schedule(
                new GregorianCalendar(2025, Calendar.MARCH, 28).getTime(), "60 mins",
                new GregorianCalendar(0, 0, 0, 10, 0).getTime(),
                "Offline", "Room 404",
                new GregorianCalendar(2025, Calendar.MARCH, 29).getTime(),
                new GregorianCalendar(0, 0, 0, 11, 0).getTime(),
                "Scheduled", goh, applicant18, job89, null);

        Schedule s89 = new Schedule(
                new GregorianCalendar(2025, Calendar.MARCH, 29).getTime(), "30 mins",
                new GregorianCalendar(0, 0, 0, 14, 30).getTime(),
                "Online", "Microsoft Teams",
                new GregorianCalendar(2025, Calendar.MARCH, 31).getTime(),
                new GregorianCalendar(0, 0, 0, 15, 15).getTime(),
                "Scheduled", nurul, applicant5, job87, null);

        Schedule s90 = new Schedule(
                new GregorianCalendar(2025, Calendar.APRIL, 11).getTime(), "45 mins",
                new GregorianCalendar(0, 0, 0, 16, 0).getTime(),
                "Offline", "Room 303",
                new GregorianCalendar(2025, Calendar.APRIL, 12).getTime(),
                new GregorianCalendar(0, 0, 0, 16, 45).getTime(),
                "Scheduled", elly, applicant20, job86, null);

        // Add companies to DataStore
        Database.companies.add(techCompany);
        Database.companies.add(hrCompany);
        Database.companies.add(financeCompany);
        Database.companies.add(healthCompany);
        Database.companies.add(educationCompany);
        Database.companies.add(cloudCompany);
        Database.companies.add(aiCompany);
        Database.companies.add(marketingCompany);
        Database.companies.add(cybersecurityCompany);
        Database.companies.add(fintechCompany);
        Database.companies.add(edtechCompany);
        Database.companies.add(devCompany);
        Database.companies.add(analyticsCompany);
        Database.companies.add(hrTechCompany);
        Database.companies.add(healthTechCompany);

        Database.applicants.add(applicant1);
        Database.applicants.add(applicant2);
        Database.applicants.add(applicant3);
        Database.applicants.add(applicant4);
        Database.applicants.add(applicant5);
        Database.applicants.add(applicant6);
        Database.applicants.add(applicant7);
        Database.applicants.add(applicant8);
        Database.applicants.add(applicant9);
        Database.applicants.add(applicant10);
        Database.applicants.add(applicant11);
        Database.applicants.add(applicant12);
        Database.applicants.add(applicant13);
        Database.applicants.add(applicant14);
        Database.applicants.add(applicant15);
        Database.applicants.add(applicant16);
        Database.applicants.add(applicant17);
        Database.applicants.add(applicant18);
        Database.applicants.add(applicant19);
        Database.applicants.add(applicant20);
        Database.applicants.add(applicant21);
        Database.applicants.add(applicant22);
        Database.applicants.add(applicant23);
        Database.applicants.add(applicant24);
        Database.applicants.add(applicant25);
        Database.applicants.add(applicant26);
        Database.applicants.add(applicant27);
        Database.applicants.add(applicant28);
        Database.applicants.add(applicant29);
        Database.applicants.add(applicant30);
        Database.applicants.add(applicant31);
        Database.applicants.add(applicant32);
        Database.applicants.add(applicant33);
        Database.applicants.add(applicant34);
        Database.applicants.add(applicant35);
        Database.applicants.add(applicant36);
        Database.applicants.add(applicant37);
        Database.applicants.add(applicant38);
        Database.applicants.add(applicant39);
        Database.applicants.add(applicant40);
        Database.applicants.add(applicant41);
        Database.applicants.add(applicant42);
        Database.applicants.add(applicant43);
        Database.applicants.add(applicant44);
        Database.applicants.add(applicant45);
        Database.applicants.add(applicant46);
        Database.applicants.add(applicant47);
        Database.applicants.add(applicant48);
        Database.applicants.add(applicant49);
        Database.applicants.add(applicant50);
        Database.applicants.add(applicant51);
        Database.applicants.add(applicant52);
        Database.applicants.add(applicant53);
        Database.applicants.add(applicant54);
        Database.applicants.add(applicant55);
        Database.applicants.add(applicant56);
        Database.applicants.add(applicant57);
        Database.applicants.add(applicant58);
        Database.applicants.add(applicant59);
        Database.applicants.add(applicant60);
        Database.applicants.add(applicant61);
        Database.applicants.add(applicant62);
        Database.applicants.add(applicant63);
        Database.applicants.add(applicant64);
        Database.applicants.add(applicant65);
        Database.applicants.add(applicant66);
        Database.applicants.add(applicant67);
        Database.applicants.add(applicant68);
        Database.applicants.add(applicant69);
        Database.applicants.add(applicant70);
        Database.applicants.add(applicant71);
        Database.applicants.add(applicant72);
        Database.applicants.add(applicant73);
        Database.applicants.add(applicant74);
        Database.applicants.add(applicant75);
        Database.applicants.add(applicant76);
        Database.applicants.add(applicant77);
        Database.applicants.add(applicant78);
        Database.applicants.add(applicant79);
        Database.applicants.add(applicant80);
        Database.applicants.add(applicant81);
        Database.applicants.add(applicant82);
        Database.applicants.add(applicant83);
        Database.applicants.add(applicant84);
        Database.applicants.add(applicant85);
        Database.applicants.add(applicant86);
        Database.applicants.add(applicant87);
        Database.applicants.add(applicant88);
        Database.applicants.add(applicant89);
        Database.applicants.add(applicant90);
        Database.applicants.add(applicant91);
        Database.applicants.add(applicant92);
        Database.applicants.add(applicant93);
        Database.applicants.add(applicant94);
        Database.applicants.add(applicant95);
        Database.applicants.add(applicant96);
        Database.applicants.add(applicant97);
        Database.applicants.add(applicant98);
        Database.applicants.add(applicant99);
        Database.applicants.add(applicant100);

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
        Database.schedules.add(s16);
        Database.schedules.add(s17);
        Database.schedules.add(s18);
        Database.schedules.add(s19);
        Database.schedules.add(s20);
        Database.schedules.add(s21);
        Database.schedules.add(s22);
        Database.schedules.add(s23);
        Database.schedules.add(s24);
        Database.schedules.add(s25);
        Database.schedules.add(s26);
        Database.schedules.add(s27);
        Database.schedules.add(s28);
        Database.schedules.add(s29);
        Database.schedules.add(s30);
        Database.schedules.add(s21);
        Database.schedules.add(s22);
        Database.schedules.add(s23);
        Database.schedules.add(s24);
        Database.schedules.add(s25);
        Database.schedules.add(s26);
        Database.schedules.add(s27);
        Database.schedules.add(s28);
        Database.schedules.add(s29);
        Database.schedules.add(s30);
        Database.schedules.add(s31);
        Database.schedules.add(s32);
        Database.schedules.add(s33);
        Database.schedules.add(s34);
        Database.schedules.add(s35);
        Database.schedules.add(s36);
        Database.schedules.add(s37);
        Database.schedules.add(s38);
        Database.schedules.add(s39);
        Database.schedules.add(s40);
        Database.schedules.add(s41);
        Database.schedules.add(s42);
        Database.schedules.add(s43);
        Database.schedules.add(s44);
        Database.schedules.add(s45);
        Database.schedules.add(s46);
        Database.schedules.add(s47);
        Database.schedules.add(s48);
        Database.schedules.add(s49);
        Database.schedules.add(s50);
        Database.schedules.add(s51);
        Database.schedules.add(s52);
        Database.schedules.add(s53);
        Database.schedules.add(s54);
        Database.schedules.add(s55);
        Database.schedules.add(s56);
        Database.schedules.add(s57);
        Database.schedules.add(s58);
        Database.schedules.add(s59);
        Database.schedules.add(s60);
        Database.schedules.add(s61);
        Database.schedules.add(s62);
        Database.schedules.add(s63);
        Database.schedules.add(s64);
        Database.schedules.add(s65);
        Database.schedules.add(s66);
        Database.schedules.add(s67);
        Database.schedules.add(s68);
        Database.schedules.add(s69);
        Database.schedules.add(s70);
        Database.schedules.add(s71);
        Database.schedules.add(s72);
        Database.schedules.add(s73);
        Database.schedules.add(s74);
        Database.schedules.add(s75);
        Database.schedules.add(s76);
        Database.schedules.add(s77);
        Database.schedules.add(s78);
        Database.schedules.add(s79);
        Database.schedules.add(s80);
        Database.schedules.add(s81);
        Database.schedules.add(s82);
        Database.schedules.add(s83);
        Database.schedules.add(s84);
        Database.schedules.add(s85);
        Database.schedules.add(s86);
        Database.schedules.add(s87);
        Database.schedules.add(s88);
        Database.schedules.add(s89);
        Database.schedules.add(s90);

        // Add employers to DataStore and assign them to their respective companies
        addEmployerToCompany(techCompany, alice);
        addEmployerToCompany(techCompany, bob);
        addEmployerToCompany(hrCompany, carol);
        addEmployerToCompany(hrCompany, david);
        addEmployerToCompany(financeCompany, emily);
        addEmployerToCompany(financeCompany, frank);
        addEmployerToCompany(healthCompany, grace);
        addEmployerToCompany(healthCompany, henry);
        addEmployerToCompany(educationCompany, irene);
        addEmployerToCompany(educationCompany, jack);
        addEmployerToCompany(techCompany, jason);
        addEmployerToCompany(techCompany, lily);
        addEmployerToCompany(techCompany, samuel);
        addEmployerToCompany(hrCompany, natalie);
        addEmployerToCompany(hrCompany, kevin);
        addEmployerToCompany(hrCompany, sophia);
        addEmployerToCompany(financeCompany, oliver);
        addEmployerToCompany(financeCompany, rachel);
        addEmployerToCompany(financeCompany, vincent);
        addEmployerToCompany(healthCompany, weiLing);
        addEmployerToCompany(healthCompany, ahmad);
        addEmployerToCompany(healthCompany, amira);
        addEmployerToCompany(educationCompany, farah);
        addEmployerToCompany(educationCompany, zhiHao);
        addEmployerToCompany(educationCompany, nadia);
        addEmployerToCompany(cloudCompany, faiz);
        addEmployerToCompany(cloudCompany, meera);
        addEmployerToCompany(cloudCompany, arif);
        addEmployerToCompany(cloudCompany, joanna);
        addEmployerToCompany(cloudCompany, irfan);
        addEmployerToCompany(aiCompany, teh);
        addEmployerToCompany(aiCompany, shalini);
        addEmployerToCompany(aiCompany, leon);
        addEmployerToCompany(aiCompany, hazirah);
        addEmployerToCompany(aiCompany, kelvin);
        addEmployerToCompany(marketingCompany, linda);
        addEmployerToCompany(marketingCompany, ryan);
        addEmployerToCompany(marketingCompany, tracy);
        addEmployerToCompany(marketingCompany, jamal);
        addEmployerToCompany(marketingCompany, cindy);
        addEmployerToCompany(cybersecurityCompany, yap);
        addEmployerToCompany(cybersecurityCompany, sarah);
        addEmployerToCompany(cybersecurityCompany, haikal);
        addEmployerToCompany(cybersecurityCompany, vivian);
        addEmployerToCompany(cybersecurityCompany, danish);
        addEmployerToCompany(fintechCompany, shafiq);
        addEmployerToCompany(fintechCompany, elaine);
        addEmployerToCompany(fintechCompany, nash);
        addEmployerToCompany(fintechCompany, beatrice);
        addEmployerToCompany(fintechCompany, hafeez);
        addEmployerToCompany(edtechCompany, aaron);
        addEmployerToCompany(edtechCompany, jenny);
        addEmployerToCompany(edtechCompany, syafiq);
        addEmployerToCompany(edtechCompany, michelle);
        addEmployerToCompany(edtechCompany, darren);
        addEmployerToCompany(devCompany, azmi);
        addEmployerToCompany(devCompany, sean);
        addEmployerToCompany(devCompany, shah);
        addEmployerToCompany(devCompany, khoo);
        addEmployerToCompany(devCompany, siti);
        addEmployerToCompany(analyticsCompany, liew);
        addEmployerToCompany(analyticsCompany, tasha);
        addEmployerToCompany(analyticsCompany, ivan);
        addEmployerToCompany(analyticsCompany, mei);
        addEmployerToCompany(analyticsCompany, zafran);
        addEmployerToCompany(hrTechCompany, abdullah);
        addEmployerToCompany(hrTechCompany, goh);
        addEmployerToCompany(hrTechCompany, hafizah);
        addEmployerToCompany(hrTechCompany, leonard);
        addEmployerToCompany(hrTechCompany, nurul);
        addEmployerToCompany(healthTechCompany, anand);
        addEmployerToCompany(healthTechCompany, elly);
        addEmployerToCompany(healthTechCompany, roslan);
        addEmployerToCompany(healthTechCompany, sheila);
        addEmployerToCompany(healthTechCompany, fauzi);

        /*job*/
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
        addJobToEmployer(kevin, job16);
        addJobToEmployer(kevin, job17);
        addJobToEmployer(david, job18);
        addJobToEmployer(frank, job19);
        addJobToEmployer(emily, job20);
        addJobToEmployer(oliver, job21);
        addJobToEmployer(oliver, job22);
        addJobToEmployer(emily, job23);
        addJobToEmployer(grace, job24);
        addJobToEmployer(henry, job25);
        addJobToEmployer(henry, job26);
        addJobToEmployer(irene, job27);
        addJobToEmployer(farah, job28);
        addJobToEmployer(jack, job29);
        addJobToEmployer(jack, job30);
        addJobToEmployer(faiz, job31);
        addJobToEmployer(arif, job32);
        addJobToEmployer(arif, job33);
        addJobToEmployer(leon, job34);
        addJobToEmployer(teh, job35);
        addJobToEmployer(leon, job36);
        addJobToEmployer(teh, job37);
        addJobToEmployer(arif, job38);
        addJobToEmployer(joanna, job39);
        addJobToEmployer(joanna, job40);
        addJobToEmployer(kelvin, job41);
        addJobToEmployer(kelvin, job42);
        addJobToEmployer(yap, job43);
        addJobToEmployer(sarah, job44);
        addJobToEmployer(linda, job45);
        addJobToEmployer(linda, job46);
        addJobToEmployer(elaine, job47);
        addJobToEmployer(elaine, job48);
        addJobToEmployer(yap, job49);
        addJobToEmployer(yap, job50);
        addJobToEmployer(shafiq, job51);
        addJobToEmployer(nash, job52);
        addJobToEmployer(ryan, job53);
        addJobToEmployer(ryan, job54);
        addJobToEmployer(shafiq, job55);
        addJobToEmployer(nash, job56);
        addJobToEmployer(sarah, job57);
        addJobToEmployer(sarah, job58);
        addJobToEmployer(cindy, job59);
        addJobToEmployer(ryan, job60);
        addJobToEmployer(syafiq, job61);
        addJobToEmployer(syafiq, job62);
        addJobToEmployer(jenny, job63);
        addJobToEmployer(siti, job64);
        addJobToEmployer(khoo, job65);
        addJobToEmployer(khoo, job66);
        addJobToEmployer(azmi, job67);
        addJobToEmployer(liew, job68);
        addJobToEmployer(liew, job69);
        addJobToEmployer(azmi, job70);
        addJobToEmployer(siti, job71);
        addJobToEmployer(zafran, job72);
        addJobToEmployer(ivan, job73);
        addJobToEmployer(ivan, job74);
        addJobToEmployer(ivan, job75);
        addJobToEmployer(darren, job76);
        addJobToEmployer(jenny, job77);
        addJobToEmployer(jenny, job78);
        addJobToEmployer(nurul, job79);
        addJobToEmployer(goh, job80);
        addJobToEmployer(fauzi, job81);
        addJobToEmployer(fauzi, job82);
        addJobToEmployer(fauzi, job83);
        addJobToEmployer(nurul, job84);
        addJobToEmployer(elly, job85);
        addJobToEmployer(elly, job86);
        addJobToEmployer(nurul, job87);
        addJobToEmployer(goh, job88);
        addJobToEmployer(goh, job89);
        addJobToEmployer(elly, job90);

        /*resume*/
        addResumeToApplicant(applicant1, resume1);
        addResumeToApplicant(applicant2, resume2);
        addResumeToApplicant(applicant3, resume3);
        addResumeToApplicant(applicant4, resume4);
        addResumeToApplicant(applicant5, resume5);
        addResumeToApplicant(applicant6, resume6);
        addResumeToApplicant(applicant7, resume7);
        addResumeToApplicant(applicant8, resume8);
        addResumeToApplicant(applicant9, resume9);
        addResumeToApplicant(applicant10, resume10);
        addResumeToApplicant(applicant11, resume11);
        addResumeToApplicant(applicant12, resume12);
        addResumeToApplicant(applicant13, resume13);
        addResumeToApplicant(applicant14, resume14);
        addResumeToApplicant(applicant15, resume15);
        addResumeToApplicant(applicant16, resume16);
        addResumeToApplicant(applicant17, resume17);
        addResumeToApplicant(applicant18, resume18);
        addResumeToApplicant(applicant19, resume19);
        addResumeToApplicant(applicant20, resume20);
        addResumeToApplicant(applicant21, resume21);
        addResumeToApplicant(applicant22, resume22);
        addResumeToApplicant(applicant23, resume23);
        addResumeToApplicant(applicant24, resume24);
        addResumeToApplicant(applicant25, resume25);
        addResumeToApplicant(applicant26, resume26);
        addResumeToApplicant(applicant27, resume27);
        addResumeToApplicant(applicant28, resume28);
        addResumeToApplicant(applicant29, resume29);
        addResumeToApplicant(applicant30, resume30);
        addResumeToApplicant(applicant31, resume31);
        addResumeToApplicant(applicant32, resume32);
        addResumeToApplicant(applicant33, resume33);
        addResumeToApplicant(applicant34, resume34);
        addResumeToApplicant(applicant35, resume35);
        addResumeToApplicant(applicant36, resume36);
        addResumeToApplicant(applicant37, resume37);
        addResumeToApplicant(applicant38, resume38);
        addResumeToApplicant(applicant39, resume39);
        addResumeToApplicant(applicant40, resume40);
        addResumeToApplicant(applicant41, resume41);
        addResumeToApplicant(applicant42, resume42);
        addResumeToApplicant(applicant43, resume43);
        addResumeToApplicant(applicant44, resume44);
        addResumeToApplicant(applicant45, resume45);
        addResumeToApplicant(applicant46, resume46);
        addResumeToApplicant(applicant47, resume47);
        addResumeToApplicant(applicant48, resume48);
        addResumeToApplicant(applicant49, resume49);
        addResumeToApplicant(applicant50, resume50);
        addResumeToApplicant(applicant51, resume51);
        addResumeToApplicant(applicant52, resume52);
        addResumeToApplicant(applicant53, resume53);
        addResumeToApplicant(applicant54, resume54);
        addResumeToApplicant(applicant55, resume55);
        addResumeToApplicant(applicant56, resume56);
        addResumeToApplicant(applicant57, resume57);
        addResumeToApplicant(applicant58, resume58);
        addResumeToApplicant(applicant59, resume59);
        addResumeToApplicant(applicant60, resume60);
        addResumeToApplicant(applicant61, resume61);
        addResumeToApplicant(applicant62, resume62);
        addResumeToApplicant(applicant63, resume63);
        addResumeToApplicant(applicant64, resume64);
        addResumeToApplicant(applicant65, resume65);
        addResumeToApplicant(applicant66, resume66);
        addResumeToApplicant(applicant67, resume67);
        addResumeToApplicant(applicant68, resume68);
        addResumeToApplicant(applicant69, resume69);
        addResumeToApplicant(applicant70, resume70);
        addResumeToApplicant(applicant71, resume71);
        addResumeToApplicant(applicant72, resume72);
        addResumeToApplicant(applicant73, resume73);
        addResumeToApplicant(applicant74, resume74);
        addResumeToApplicant(applicant75, resume75);
        addResumeToApplicant(applicant76, resume76);
        addResumeToApplicant(applicant77, resume77);
        addResumeToApplicant(applicant78, resume78);
        addResumeToApplicant(applicant79, resume79);
        addResumeToApplicant(applicant80, resume80);
        addResumeToApplicant(applicant81, resume81);
        addResumeToApplicant(applicant82, resume82);
        addResumeToApplicant(applicant83, resume83);
        addResumeToApplicant(applicant84, resume84);
        addResumeToApplicant(applicant85, resume85);
        addResumeToApplicant(applicant86, resume86);
        addResumeToApplicant(applicant87, resume87);
        addResumeToApplicant(applicant88, resume88);
        addResumeToApplicant(applicant89, resume89);
        addResumeToApplicant(applicant90, resume90);
        addResumeToApplicant(applicant91, resume91);
        addResumeToApplicant(applicant92, resume92);
        addResumeToApplicant(applicant93, resume93);
        addResumeToApplicant(applicant94, resume94);
        addResumeToApplicant(applicant95, resume95);
        addResumeToApplicant(applicant96, resume96);
        addResumeToApplicant(applicant97, resume97);
        addResumeToApplicant(applicant98, resume98);
        addResumeToApplicant(applicant99, resume99);
        addResumeToApplicant(applicant100, resume100);

        /*application*/
        addJobApplicationToApplicant(applicant1, job1, app1);
        addJobApplicationToApplicant(applicant2, job2, app2);
        addJobApplicationToApplicant(applicant3, job5, app3);
        addJobApplicationToApplicant(applicant4, job4, app4);
        addJobApplicationToApplicant(applicant5, job4, app5);
        addJobApplicationToApplicant(applicant2, job3, app6);
        addJobApplicationToApplicant(applicant3, job7, app7);
        addJobApplicationToApplicant(applicant2, job4, app8);
        addJobApplicationToApplicant(applicant1, job9, app9);
        addJobApplicationToApplicant(applicant3, job8, app10);
        addJobApplicationToApplicant(applicant6, job10, app11);
        addJobApplicationToApplicant(applicant7, job11, app12);
        addJobApplicationToApplicant(applicant8, job12, app13);
        addJobApplicationToApplicant(applicant9, job13, app14);
        addJobApplicationToApplicant(applicant10, job14, app15);
        addJobApplicationToApplicant(applicant11, job15, app16);
        addJobApplicationToApplicant(applicant12, job16, app17);
        addJobApplicationToApplicant(applicant13, job10, app18);
        addJobApplicationToApplicant(applicant14, job11, app19);
        addJobApplicationToApplicant(applicant15, job12, app20);
        addJobApplicationToApplicant(applicant16, job13, app21);
        addJobApplicationToApplicant(applicant17, job14, app22);
        addJobApplicationToApplicant(applicant18, job15, app23);
        addJobApplicationToApplicant(applicant19, job16, app24);
        addJobApplicationToApplicant(applicant20, job13, app25);
        addJobApplicationToApplicant(applicant21, job14, app26);
        addJobApplicationToApplicant(applicant22, job13, app27);
        addJobApplicationToApplicant(applicant23, job13, app28);
        addJobApplicationToApplicant(applicant24, job16, app29);
        addJobApplicationToApplicant(applicant25, job15, app30);
        addJobApplicationToApplicant(applicant20, job17, app31);
        addJobApplicationToApplicant(applicant21, job18, app32);
        addJobApplicationToApplicant(applicant22, job19, app33);
        addJobApplicationToApplicant(applicant23, job20, app34);
        addJobApplicationToApplicant(applicant24, job21, app35);
        addJobApplicationToApplicant(applicant25, job22, app36);
        addJobApplicationToApplicant(applicant26, job23, app37);
        addJobApplicationToApplicant(applicant27, job17, app38);
        addJobApplicationToApplicant(applicant28, job18, app39);
        addJobApplicationToApplicant(applicant29, job19, app40);
        addJobApplicationToApplicant(applicant30, job20, app41);
        addJobApplicationToApplicant(applicant31, job21, app42);
        addJobApplicationToApplicant(applicant32, job22, app43);
        addJobApplicationToApplicant(applicant33, job23, app44);
        addJobApplicationToApplicant(applicant34, job23, app45);
        addJobApplicationToApplicant(applicant35, job21, app46);
        addJobApplicationToApplicant(applicant36, job22, app47);
        addJobApplicationToApplicant(applicant37, job20, app48);
        addJobApplicationToApplicant(applicant38, job21, app49);
        addJobApplicationToApplicant(applicant39, job22, app50);
        addJobApplicationToApplicant(applicant40, job23, app51);
        addJobApplicationToApplicant(applicant41, job22, app52);
        addJobApplicationToApplicant(applicant42, job20, app53);
        addJobApplicationToApplicant(applicant43, job21, app54);
        addJobApplicationToApplicant(applicant44, job22, app55);
        addJobApplicationToApplicant(applicant45, job23, app56);
        addJobApplicationToApplicant(applicant46, job24, app57);
        addJobApplicationToApplicant(applicant47, job23, app58);
        addJobApplicationToApplicant(applicant48, job24, app59);
        addJobApplicationToApplicant(applicant49, job25, app60);
        addJobApplicationToApplicant(applicant50, job26, app61);
        addJobApplicationToApplicant(applicant51, job22, app62);
        addJobApplicationToApplicant(applicant52, job26, app63);
        addJobApplicationToApplicant(applicant53, job22, app64);
        addJobApplicationToApplicant(applicant54, job23, app65);
        addJobApplicationToApplicant(applicant55, job22, app66);
        addJobApplicationToApplicant(applicant56, job23, app67);
        addJobApplicationToApplicant(applicant57, job24, app68);
        addJobApplicationToApplicant(applicant58, job28, app69);
        addJobApplicationToApplicant(applicant59, job24, app70);
        addJobApplicationToApplicant(applicant60, job24, app71);
        addJobApplicationToApplicant(applicant61, job25, app72);
        addJobApplicationToApplicant(applicant62, job26, app73);
        addJobApplicationToApplicant(applicant63, job27, app74);
        addJobApplicationToApplicant(applicant64, job28, app75);
        addJobApplicationToApplicant(applicant65, job29, app76);
        addJobApplicationToApplicant(applicant66, job30, app77);
        addJobApplicationToApplicant(applicant67, job24, app78);
        addJobApplicationToApplicant(applicant68, job25, app79);
        addJobApplicationToApplicant(applicant69, job26, app80);
        addJobApplicationToApplicant(applicant70, job27, app81);
        addJobApplicationToApplicant(applicant71, job28, app82);
        addJobApplicationToApplicant(applicant72, job29, app83);
        addJobApplicationToApplicant(applicant73, job30, app84);
        addJobApplicationToApplicant(applicant74, job27, app85);
        addJobApplicationToApplicant(applicant75, job28, app86);
        addJobApplicationToApplicant(applicant76, job29, app87);
        addJobApplicationToApplicant(applicant77, job27, app88);
        addJobApplicationToApplicant(applicant78, job28, app89);
        addJobApplicationToApplicant(applicant79, job29, app90);
        addJobApplicationToApplicant(applicant80, job27, app91);
        addJobApplicationToApplicant(applicant81, job28, app92);
        addJobApplicationToApplicant(applicant82, job29, app93);
        addJobApplicationToApplicant(applicant83, job30, app94);
        addJobApplicationToApplicant(applicant84, job31, app95);
        addJobApplicationToApplicant(applicant85, job32, app96);
        addJobApplicationToApplicant(applicant86, job33, app97);
        addJobApplicationToApplicant(applicant87, job34, app98);
        addJobApplicationToApplicant(applicant88, job35, app99);
        addJobApplicationToApplicant(applicant89, job29, app100);

        addJobApplicationToApplicant(applicant90, job29, app101);
        addJobApplicationToApplicant(applicant91, job29, app102);
        addJobApplicationToApplicant(applicant92, job30, app103);
        addJobApplicationToApplicant(applicant93, job31, app104);
        addJobApplicationToApplicant(applicant94, job32, app105);
        addJobApplicationToApplicant(applicant95, job33, app106);
        addJobApplicationToApplicant(applicant96, job34, app107);
        addJobApplicationToApplicant(applicant97, job35, app108);
        addJobApplicationToApplicant(applicant98, job35, app109);
        addJobApplicationToApplicant(applicant99, job36, app110);
        addJobApplicationToApplicant(applicant100, job30, app111);
        addJobApplicationToApplicant(applicant1, job30, app112);
        addJobApplicationToApplicant(applicant12, job31, app113);
        addJobApplicationToApplicant(applicant10, job32, app114);
        addJobApplicationToApplicant(applicant14, job33, app115);
        addJobApplicationToApplicant(applicant15, job31, app116);
        addJobApplicationToApplicant(applicant8, job32, app117);
        addJobApplicationToApplicant(applicant45, job33, app118);
        addJobApplicationToApplicant(applicant20, job34, app119);
        addJobApplicationToApplicant(applicant57, job35, app120);
        addJobApplicationToApplicant(applicant10, job36, app121);
        addJobApplicationToApplicant(applicant25, job37, app122);
        addJobApplicationToApplicant(applicant33, job38, app123);
        addJobApplicationToApplicant(applicant90, job39, app124);
        addJobApplicationToApplicant(applicant60, job40, app125);
        addJobApplicationToApplicant(applicant51, job41, app126);
        addJobApplicationToApplicant(applicant3, job42, app127);
        addJobApplicationToApplicant(applicant100, job43, app128);
        addJobApplicationToApplicant(applicant72, job44, app129);
        addJobApplicationToApplicant(applicant5, job45, app130);
        addJobApplicationToApplicant(applicant28, job46, app131);
        addJobApplicationToApplicant(applicant70, job47, app132);
        addJobApplicationToApplicant(applicant6, job48, app133);
        addJobApplicationToApplicant(applicant92, job49, app134);
        addJobApplicationToApplicant(applicant22, job35, app135);
        addJobApplicationToApplicant(applicant18, job36, app136);
        addJobApplicationToApplicant(applicant40, job37, app137);
        addJobApplicationToApplicant(applicant31, job34, app138);
        addJobApplicationToApplicant(applicant77, job35, app139);
        addJobApplicationToApplicant(applicant13, job36, app140);
        addJobApplicationToApplicant(applicant12, job37, app141);
        addJobApplicationToApplicant(applicant36, job38, app142);
        addJobApplicationToApplicant(applicant63, job39, app143);
        addJobApplicationToApplicant(applicant4, job40, app144);
        addJobApplicationToApplicant(applicant55, job41, app145);
        addJobApplicationToApplicant(applicant26, job42, app146);
        addJobApplicationToApplicant(applicant84, job43, app147);
        addJobApplicationToApplicant(applicant91, job44, app148);
        addJobApplicationToApplicant(applicant17, job45, app149);
        addJobApplicationToApplicant(applicant99, job46, app150);
        addJobApplicationToApplicant(applicant19, job47, app151);
        addJobApplicationToApplicant(applicant39, job48, app152);
        addJobApplicationToApplicant(applicant73, job49, app153);
        addJobApplicationToApplicant(applicant35, job37, app154);
        addJobApplicationToApplicant(applicant10, job37, app155);
        addJobApplicationToApplicant(applicant70, job38, app156);
        addJobApplicationToApplicant(applicant71, job39, app157);
        addJobApplicationToApplicant(applicant72, job40, app158);
        addJobApplicationToApplicant(applicant73, job41, app159);
        addJobApplicationToApplicant(applicant74, job42, app160);
        addJobApplicationToApplicant(applicant75, job43, app161);
        addJobApplicationToApplicant(applicant76, job38, app162);
        addJobApplicationToApplicant(applicant77, job39, app163);
        addJobApplicationToApplicant(applicant78, job40, app164);
        addJobApplicationToApplicant(applicant79, job41, app165);
        addJobApplicationToApplicant(applicant80, job42, app166);
        addJobApplicationToApplicant(applicant81, job43, app167);
        addJobApplicationToApplicant(applicant82, job44, app168);
        addJobApplicationToApplicant(applicant83, job49, app169);
        addJobApplicationToApplicant(applicant84, job50, app170);
        addJobApplicationToApplicant(applicant1, job44, app171);
        addJobApplicationToApplicant(applicant3, job45, app172);
        addJobApplicationToApplicant(applicant5, job46, app173);
        addJobApplicationToApplicant(applicant7, job47, app174);
        addJobApplicationToApplicant(applicant9, job48, app175);
        addJobApplicationToApplicant(applicant11, job49, app176);
        addJobApplicationToApplicant(applicant13, job50, app177);
        addJobApplicationToApplicant(applicant15, job51, app178);
        addJobApplicationToApplicant(applicant17, job52, app179);
        addJobApplicationToApplicant(applicant19, job53, app180);
        addJobApplicationToApplicant(applicant21, job54, app181);
        addJobApplicationToApplicant(applicant23, job55, app182);
        addJobApplicationToApplicant(applicant25, job46, app183);
        addJobApplicationToApplicant(applicant27, job48, app184);
        addJobApplicationToApplicant(applicant29, job50, app185);
        addJobApplicationToApplicant(applicant31, job48, app186);
        addJobApplicationToApplicant(applicant33, job48, app187);
        addJobApplicationToApplicant(applicant35, job49, app188);
        addJobApplicationToApplicant(applicant37, job50, app189);
        addJobApplicationToApplicant(applicant39, job51, app190);
        addJobApplicationToApplicant(applicant50, job50, app191);
        addJobApplicationToApplicant(applicant51, job51, app192);
        addJobApplicationToApplicant(applicant52, job52, app193);
        addJobApplicationToApplicant(applicant53, job53, app194);
        addJobApplicationToApplicant(applicant54, job54, app195);
        addJobApplicationToApplicant(applicant55, job55, app196);
        addJobApplicationToApplicant(applicant56, job56, app197);
        addJobApplicationToApplicant(applicant57, job57, app198);
        addJobApplicationToApplicant(applicant58, job58, app199);
        addJobApplicationToApplicant(applicant59, job59, app200);

        addJobApplicationToApplicant(applicant60, job60, app201);
        addJobApplicationToApplicant(applicant61, job54, app202);
        addJobApplicationToApplicant(applicant62, job55, app203);
        addJobApplicationToApplicant(applicant63, job56, app204);
        addJobApplicationToApplicant(applicant64, job58, app205);
        addJobApplicationToApplicant(applicant80, job56, app206);
        addJobApplicationToApplicant(applicant82, job57, app207);
        addJobApplicationToApplicant(applicant84, job58, app208);
        addJobApplicationToApplicant(applicant86, job59, app209);
        addJobApplicationToApplicant(applicant88, job60, app210);
        addJobApplicationToApplicant(applicant90, job61, app211);
        addJobApplicationToApplicant(applicant92, job62, app212);
        addJobApplicationToApplicant(applicant94, job63, app213);
        addJobApplicationToApplicant(applicant96, job64, app214);
        addJobApplicationToApplicant(applicant98, job65, app215);
        addJobApplicationToApplicant(applicant80, job63, app216);
        addJobApplicationToApplicant(applicant81, job64, app217);
        addJobApplicationToApplicant(applicant82, job65, app218);
        addJobApplicationToApplicant(applicant83, job66, app219);
        addJobApplicationToApplicant(applicant84, job67, app220);
        addJobApplicationToApplicant(applicant85, job68, app221);
        addJobApplicationToApplicant(applicant86, job69, app222);
        addJobApplicationToApplicant(applicant87, job70, app223);
        addJobApplicationToApplicant(applicant88, job71, app224);
        addJobApplicationToApplicant(applicant89, job72, app225);
        addJobApplicationToApplicant(applicant90, job73, app226);
        addJobApplicationToApplicant(applicant91, job74, app227);
        addJobApplicationToApplicant(applicant92, job75, app228);
        addJobApplicationToApplicant(applicant93, job76, app229);
        addJobApplicationToApplicant(applicant94, job77, app230);
        addJobApplicationToApplicant(applicant95, job64, app231);
        addJobApplicationToApplicant(applicant96, job64, app232);
        addJobApplicationToApplicant(applicant97, job65, app233);
        addJobApplicationToApplicant(applicant98, job66, app234);
        addJobApplicationToApplicant(applicant99, job67, app235);
        addJobApplicationToApplicant(applicant1, job65, app236);
        addJobApplicationToApplicant(applicant2, job66, app237);
        addJobApplicationToApplicant(applicant3, job67, app238);
        addJobApplicationToApplicant(applicant4, job68, app239);
        addJobApplicationToApplicant(applicant5, job69, app240);
        addJobApplicationToApplicant(applicant6, job70, app241);
        addJobApplicationToApplicant(applicant7, job65, app242);
        addJobApplicationToApplicant(applicant8, job66, app243);
        addJobApplicationToApplicant(applicant9, job67, app244);
        addJobApplicationToApplicant(applicant10, job68, app245);
        addJobApplicationToApplicant(applicant11, job69, app246);
        addJobApplicationToApplicant(applicant12, job70, app247);
        addJobApplicationToApplicant(applicant13, job67, app248);
        addJobApplicationToApplicant(applicant14, job68, app249);
        addJobApplicationToApplicant(applicant15, job67, app250);
        addJobApplicationToApplicant(applicant16, job68, app251);
        addJobApplicationToApplicant(applicant17, job69, app252);
        addJobApplicationToApplicant(applicant18, job70, app253);
        addJobApplicationToApplicant(applicant19, job70, app254);
        addJobApplicationToApplicant(applicant20, job71, app255);
        addJobApplicationToApplicant(applicant31, job69, app256);
        addJobApplicationToApplicant(applicant32, job70, app257);
        addJobApplicationToApplicant(applicant33, job71, app258);
        addJobApplicationToApplicant(applicant34, job72, app259);
        addJobApplicationToApplicant(applicant35, job73, app260);
        addJobApplicationToApplicant(applicant36, job74, app261);
        addJobApplicationToApplicant(applicant37, job75, app262);
        addJobApplicationToApplicant(applicant38, job76, app263);
        addJobApplicationToApplicant(applicant39, job77, app264);
        addJobApplicationToApplicant(applicant40, job78, app265);
        addJobApplicationToApplicant(applicant41, job79, app266);
        addJobApplicationToApplicant(applicant42, job80, app267);
        addJobApplicationToApplicant(applicant43, job81, app268);
        addJobApplicationToApplicant(applicant44, job82, app269);
        addJobApplicationToApplicant(applicant45, job83, app270);
        addJobApplicationToApplicant(applicant46, job70, app271);
        addJobApplicationToApplicant(applicant47, job70, app272);
        addJobApplicationToApplicant(applicant48, job71, app273);
        addJobApplicationToApplicant(applicant49, job72, app274);
        addJobApplicationToApplicant(applicant50, job73, app275);
        addJobApplicationToApplicant(applicant61, job72, app276);
        addJobApplicationToApplicant(applicant62, job73, app277);
        addJobApplicationToApplicant(applicant63, job74, app278);
        addJobApplicationToApplicant(applicant64, job75, app279);
        addJobApplicationToApplicant(applicant65, job76, app280);
        addJobApplicationToApplicant(applicant66, job77, app281);
        addJobApplicationToApplicant(applicant67, job78, app282);
        addJobApplicationToApplicant(applicant68, job79, app283);
        addJobApplicationToApplicant(applicant69, job80, app284);
        addJobApplicationToApplicant(applicant70, job81, app285);
        addJobApplicationToApplicant(applicant81, job75, app286);
        addJobApplicationToApplicant(applicant82, job76, app287);
        addJobApplicationToApplicant(applicant83, job77, app288);
        addJobApplicationToApplicant(applicant84, job78, app289);
        addJobApplicationToApplicant(applicant85, job77, app290);
        addJobApplicationToApplicant(applicant1, job79, app291);
        addJobApplicationToApplicant(applicant2, job80, app292);
        addJobApplicationToApplicant(applicant3, job85, app293);
        addJobApplicationToApplicant(applicant4, job89, app294);
        addJobApplicationToApplicant(applicant5, job84, app295);
        addJobApplicationToApplicant(applicant8, job85, app296);
        addJobApplicationToApplicant(applicant12, job86, app297);
        addJobApplicationToApplicant(applicant15, job87, app298);
        addJobApplicationToApplicant(applicant18, job88, app299);
        addJobApplicationToApplicant(applicant20, job90, app300);

        /*schedule*/
        addScheduleToEmployer(s1, alice);
        addScheduleToEmployer(s2, bob);
        addScheduleToEmployer(s3, frank);
        addScheduleToEmployer(s4, david);
        addScheduleToEmployer(s5, frank);
        addScheduleToEmployer(s6, carol);
        addScheduleToEmployer(s7, henry);
        addScheduleToEmployer(s8, frank);
        addScheduleToEmployer(s9, irene);
        addScheduleToEmployer(s10, henry);
        addScheduleToEmployer(s11, jack);
        addScheduleToEmployer(s12, carol);
        addScheduleToEmployer(s13, alice);
        addScheduleToEmployer(s14, bob);
        addScheduleToEmployer(s15, bob);
        addScheduleToEmployer(s16, alice);
        addScheduleToEmployer(s17, kevin);
        addScheduleToEmployer(s18, jack);
        addScheduleToEmployer(s19, carol);
        addScheduleToEmployer(s20, alice);
        addScheduleToEmployer(s21, kevin);
        addScheduleToEmployer(s22, david);
        addScheduleToEmployer(s23, frank);
        addScheduleToEmployer(s24, emily);
        addScheduleToEmployer(s25, oliver);
        addScheduleToEmployer(s26, oliver);
        addScheduleToEmployer(s27, emily);
        addScheduleToEmployer(s28, grace);
        addScheduleToEmployer(s29, henry);
        addScheduleToEmployer(s30, henry);
        addScheduleToEmployer(s30, henry);
        addScheduleToEmployer(s31, irene);
        addScheduleToEmployer(s32, farah);
        addScheduleToEmployer(s33, jack);
        addScheduleToEmployer(s34, jack);
        addScheduleToEmployer(s35, faiz);
        addScheduleToEmployer(s36, arif);
        addScheduleToEmployer(s37, arif);
        addScheduleToEmployer(s38, leon);
        addScheduleToEmployer(s39, teh);
        addScheduleToEmployer(s40, leon);
        addScheduleToEmployer(s41, teh);
        addScheduleToEmployer(s42, arif);
        addScheduleToEmployer(s43, joanna);
        addScheduleToEmployer(s44, joanna);
        addScheduleToEmployer(s45, kelvin);
        addScheduleToEmployer(s46, yap);
        addScheduleToEmployer(s47, sarah);
        addScheduleToEmployer(s48, linda);
        addScheduleToEmployer(s49, elaine);
        addScheduleToEmployer(s50, elaine);
        addScheduleToEmployer(s51, yap);
        addScheduleToEmployer(s52, yap);
        addScheduleToEmployer(s53, shafiq);
        addScheduleToEmployer(s54, nash);
        addScheduleToEmployer(s55, ryan);
        addScheduleToEmployer(s56, ryan);
        addScheduleToEmployer(s57, shafiq);
        addScheduleToEmployer(s58, nash);
        addScheduleToEmployer(s59, sarah);
        addScheduleToEmployer(s60, cindy);
        addScheduleToEmployer(s61, ryan);
        addScheduleToEmployer(s62, syafiq);
        addScheduleToEmployer(s63, shafiq);
        addScheduleToEmployer(s64, jenny);
        addScheduleToEmployer(s65, siti);
        addScheduleToEmployer(s66, khoo);
        addScheduleToEmployer(s67, azmi);
        addScheduleToEmployer(s68, liew);
        addScheduleToEmployer(s69, liew);
        addScheduleToEmployer(s70, azmi);
        addScheduleToEmployer(s71, siti);
        addScheduleToEmployer(s72, zafran);
        addScheduleToEmployer(s73, ivan);
        addScheduleToEmployer(s74, ivan);
        addScheduleToEmployer(s75, ivan);
        addScheduleToEmployer(s76, darren);
        addScheduleToEmployer(s77, jenny);
        addScheduleToEmployer(s78, jenny);
        addScheduleToEmployer(s79, nurul);
        addScheduleToEmployer(s80, goh);
        addScheduleToEmployer(s81, fauzi);
        addScheduleToEmployer(s82, fauzi);
        addScheduleToEmployer(s83, fauzi);
        addScheduleToEmployer(s84, elly);
        addScheduleToEmployer(s85, goh);
        addScheduleToEmployer(s86, elly);
        addScheduleToEmployer(s87, nurul);
        addScheduleToEmployer(s88, goh);
        addScheduleToEmployer(s89, nurul);
        addScheduleToEmployer(s90, elly);

    }

    private static void addEmployerToCompany(Company company, Employer employer) {
        company.getEmployer().add(employer);
        Database.employers.add(employer);
    }

    private static void addJobToEmployer(Employer employer, Job job) {
        employer.getJob().add(job);
        Database.jobList.add(job);
    }

    private static void addResumeToApplicant(Applicant applicant, Resume resume) {
        applicant.setResume(resume);
    }

    private static void addJobApplicationToApplicant(Applicant applicant, Job job, JobApplication jobApplication) {
        job.getJobApplication().add(jobApplication);
        applicant.getJobApplication().add(jobApplication);
        Database.jobApplicationList.add(jobApplication);
    }

    private static void addScheduleToEmployer(Schedule schedule, Employer employer) {
        employer.getSchedule().add(schedule);
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
            case "skill" ->
                pool = skillPool;
            case "benefit" ->
                pool = benefitPool;
            case "language" ->
                pool = languagePool;
            case "experience" ->
                pool = experiencePool;
            case "certification" ->
                pool = certificationPool;
            case "project" ->
                pool = projectPool;
            case "award" ->
                pool = awardPool;
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
