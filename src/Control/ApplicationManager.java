package Control;

import ADT.*;
import Dao.Database;
import Entity.*;
import Utility.MessageUI;

/**
 *
 * @author User
 */
public class ApplicationManager {
    private static void arrangeApplication(ListInterface<JobApplication> list){
        MatchingEngine match = new MatchingEngine();
        Applicant applicants = new Applicant();
        Employer employer = Database.getEmployer();
        ListInterface<Job> jobMatchList = new DoublyLinkedList<>();
        
        if (!employer.getJob().isEmpty()) {
                for (Job job : employer.getJob()) {
                    jobMatchList.add(job);
                    ListInterface<Applicant> applicantMatchList = new DoublyLinkedList<>();

                    // Collect applicants who applied for this job
                    for (JobApplication jobApplication : job.getJobApplication()) {
                        applicantMatchList.add(jobApplication.getApplicant());
                    }

                    // Sort the applicants 
                    ListInterface<Applicant> sortedList = match.heapSort(applicantMatchList, applicants);

                    // Print job title
                    System.out.println("Job: " + job.getJobTitle());

                    // Print matched applicants with scores
                    if (!sortedList.isEmpty()) {
                        for (int i = 0; i < sortedList.size(); i++) {
                            Applicant applicant = sortedList.get(i);
                            System.out.println(i + ") " + applicant.getName());
                        }
                    } else {
                        MessageUI.noMatchFound();
                    }
                    System.out.println("-------------------------------------------"); 
                }
            }
        
    }
}
