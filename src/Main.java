import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Resume resume = new Resume();

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
            System.out.println("13. Print Resume");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());


            switch (choice) {
                case 1 -> resume.setGeneralInfo(InputHelper.inputGeneralInfo(sc));
                case 2 -> resume.addEducation(InputHelper.inputEducation(sc));
                case 3 -> resume.addCertificate(InputHelper.inputCertificate(sc));
                case 4 -> resume.addInternship(InputHelper.inputInternship(sc));
                case 5 -> resume.addJob(InputHelper.inputJob(sc));
                case 6 -> resume.addLanguage(InputHelper.inputLanguage(sc, new ArrayList<>()));
                case 7 -> resume.addSoftSkill(InputHelper.inputSoftSkill(sc));
                case 8 -> resume.addAchievement(InputHelper.inputAchievement(sc));
                case 9 -> resume.addReference(InputHelper.inputReference(sc));
                case 10 -> resume.addProject(InputHelper.inputProject(sc));
                case 11 -> resume.displayAll();
                case 12 -> resume.displayInteractiveResume(sc);
                case 13 -> resume.exportFinalResumeToFile("My Resume.txt");
                case 0 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid option. Try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}