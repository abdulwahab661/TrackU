import java.util.List;
import java.util.ArrayList;
public class Person {
    private GeneralInfo generalInfo;
    private List<Education> educationList = new ArrayList<>();
    private List<Certification> certificates = new ArrayList<>();
    private List<Internship> internships = new ArrayList<>();
    private List<Job> jobs = new ArrayList<>();
    private List<Language> languages = new ArrayList<>();
    private List<SoftSkill> softSkills = new ArrayList<>();
    private List<Achievement> achievements = new ArrayList<>();
    private List<Reference> references = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();

    // Constructor
    public Person() {}

    // Getters and Setters for each field (you can generate these or write manually)

    public GeneralInfo getGeneralInfo() {
        return generalInfo;
    }

    public void setGeneralInfo(GeneralInfo generalInfo) {
        this.generalInfo = generalInfo;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public List<Certification> getCertificates() {
        return certificates;
    }

    public List<Internship> getInternships() {
        return internships;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public List<SoftSkill> getSoftSkills() {
        return softSkills;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public List<Reference> getReferences() {
        return references;
    }

    public List<Project> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== GENERAL INFO ===\n").append(generalInfo != null ? generalInfo : "No Info").append("\n");
        sb.append("=== EDUCATION ===\n").append(educationList.isEmpty() ? "None\n" : "");
        for (Education e : educationList) sb.append(e).append("\n");

        sb.append("=== CERTIFICATES ===\n").append(certificates.isEmpty() ? "None\n" : "");
        for (Certification c : certificates) sb.append(c).append("\n");

        sb.append("=== INTERNSHIPS ===\n").append(internships.isEmpty() ? "None\n" : "");
        for (Internship i : internships) sb.append(i).append("\n");

        sb.append("=== JOBS ===\n").append(jobs.isEmpty() ? "None\n" : "");
        for (Job j : jobs) sb.append(j).append("\n");

        sb.append("=== LANGUAGES ===\n").append(languages.isEmpty() ? "None\n" : "");
        for (Language l : languages) sb.append(l).append("\n");

        sb.append("=== SOFT SKILLS ===\n").append(softSkills.isEmpty() ? "None\n" : "");
        for (SoftSkill s : softSkills) sb.append(s).append("\n");

        sb.append("=== ACHIEVEMENTS ===\n").append(achievements.isEmpty() ? "None\n" : "");
        for (Achievement a : achievements) sb.append(a).append("\n");

        sb.append("=== REFERENCES ===\n").append(references.isEmpty() ? "None\n" : "");
        for (Reference r : references) sb.append(r).append("\n");

        sb.append("=== PROJECTS ===\n").append(projects.isEmpty() ? "None\n" : "");
        for (Project p : projects) sb.append(p).append("\n");

        return sb.toString();
    }
}