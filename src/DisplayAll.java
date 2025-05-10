import java.util.List;
import java.util.ArrayList;
public class DisplayAll {

    public static void displayAllEntries(
            GeneralInfo generalInfo,
            List<Education> educationList,
            List<Certification> certificates,
            List<Internship> internships,
            List<Job> jobs,
            List<Language> languages,
            List<SoftSkill> softSkills,
            List<Achievement> achievements,
            List<Reference> references,
            List<Project> projects) {

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
}