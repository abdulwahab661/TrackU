import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GeneralInfo generalInfo = null;
        List<Language> languages = new ArrayList<>();
        List<SoftSkill> softSkills = new ArrayList<>();
        List<Certification> certificates = new ArrayList<>();
        List<Education> educationList = new ArrayList<>();
        List<Internship> internships = new ArrayList<>();
        List<Job> jobs = new ArrayList<>();
        List<Achievement> achievements = new ArrayList<>();
        List<Reference> references = new ArrayList<>();
        List<Project> projects = new ArrayList<>();

        int choice;
        do {
            System.out.println("\n=== STUDENT TRACKER MENU ===");
            System.out.println("1. Add General Info");
            System.out.println("2. Add Education");
            System.out.println("3. Add Certificate");
            System.out.println("4. Add Internship");
            System.out.println("5. Add Job");
            System.out.println("6. Add Language");
            System.out.println("7. Add Soft Skill");
            System.out.println("8. Add Achievement");
            System.out.println("9. Add Reference");
            System.out.println("10. Add Project");
            System.out.println("11. Display All Entries");
            System.out.println("12. Build Resume");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> generalInfo = InputHelper.inputGeneralInfo(sc);
                case 2 -> educationList.add(InputHelper.inputEducation(sc));
                case 3 -> certificates.add(InputHelper.inputCertificate(sc));
                case 4 -> internships.add(InputHelper.inputInternship(sc));
                case 5 -> jobs.add(InputHelper.inputJob(sc));
                case 6 -> languages.add(InputHelper.inputLanguage(sc, certificates));
                case 7 -> softSkills.add(InputHelper.inputSoftSkill(sc));
                case 8 -> achievements.add(InputHelper.inputAchievement(sc));
                case 9 -> references.add(InputHelper.inputReference(sc));
                case 10 -> projects.add(InputHelper.inputProject(sc));
                case 11 -> DisplayAll.displayAllEntries(
                        generalInfo, educationList, certificates,
                        internships, jobs, languages, softSkills,
                        achievements, references,projects);
                case 12 -> Resume.buildResume(sc, generalInfo, educationList, certificates,
                        internships, jobs, languages, softSkills,
                        achievements, references, projects);
                case 0 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid option. Try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}