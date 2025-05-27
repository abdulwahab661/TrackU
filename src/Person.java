import java.io.Serializable;
import java.util.*;

public class Person extends Resume implements Serializable {
    private String username;
    private String password;

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

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }

    public GeneralInfo getGeneralInfo() { return generalInfo; }
    public void setGeneralInfo(GeneralInfo generalInfo) { this.generalInfo = generalInfo; }

    public List<Education> getEducationList() { return educationList; }
    public List<Certification> getCertificates() { return certificates; }
    public List<Internship> getInternships() { return internships; }
    public List<Job> getJobs() { return jobs; }
    public List<Language> getLanguages() { return languages; }
    public List<SoftSkill> getSoftSkills() { return softSkills; }
    public List<Achievement> getAchievements() { return achievements; }
    public List<Reference> getReferences() { return references; }
    public List<Project> getProjects() { return projects; }


    public Resume getResume() {
        return this;
    }
}