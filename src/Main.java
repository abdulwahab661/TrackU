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
            System.out.println("1. Add Education");
            System.out.println("2. Add Certificate");
            System.out.println("3. Add Internship");
            System.out.println("4. Add Job");
            System.out.println("5. Add Language");
            System.out.println("6. Add Soft Skill");
            System.out.println("7. Add Achievement");
            System.out.println("8. Add Reference");
            System.out.println("9. Add Project");
            System.out.println("10. Add General Info");
            System.out.println("11. Display all Entries");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> educationList.add(InputHelper.inputEducation(sc));
                case 2 -> certificates.add(InputHelper.inputCertificate(sc));
                case 3 -> internships.add(InputHelper.inputInternship(sc));
                case 4 -> jobs.add(InputHelper.inputJob(sc));
                case 5 -> languages.add(InputHelper.inputLanguage(sc, certificates));
                case 6 -> softSkills.add(InputHelper.inputSoftSkill(sc));
                case 7 -> achievements.add(InputHelper.inputAchievement(sc));
                case 8 -> references.add(InputHelper.inputReference(sc));
                case 9 -> projects.add(InputHelper.inputProject(sc));
                case 10 -> generalInfo = InputHelper.inputGeneralInfo(sc);
                case 11 -> {
                    System.out.println("\n=== GENERAL INFORMATION ===");
                    if (generalInfo != null) {
                        System.out.println(generalInfo);
                    } else {
                        System.out.println("No general info provided.");
                    }

                    System.out.println("\n=== EDUCATION ===");
                    for (Education education : educationList) {
                        System.out.println(education);
                    }

                    System.out.println("\n=== CERTIFICATES ===");
                    for (Certification certificate : certificates) {
                        System.out.println(certificate);
                    }

                    System.out.println("\n=== INTERNSHIPS ===");
                    for (Internship internship : internships) {
                        System.out.println(internship);
                    }

                    System.out.println("\n=== JOBS ===");
                    for (Job job : jobs) {
                        System.out.println(job);
                    }

                    System.out.println("\n=== LANGUAGES ===");
                    for (Language language : languages) {
                        System.out.println(language);
                    }

                    System.out.println("\n=== SOFT SKILLS ===");
                    for (SoftSkill softSkill : softSkills) {
                        System.out.println(softSkill);
                    }

                    System.out.println("\n=== ACHIEVEMENTS ===");
                    for (Achievement achievement : achievements) {
                        System.out.println(achievement);
                    }

                    System.out.println("\n=== REFERENCES ===");
                    for (Reference reference : references) {
                        System.out.println(reference);
                    }

                    System.out.println("\n=== PROJECTS ===");
                    for (Project project : projects) {
                        System.out.println(project);
                    }
                }

                case 0 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid option. Try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}