import java.util.ArrayList;

public class StudentProfile {
    private ArrayList<String> globalSkills = new ArrayList<>();
    private ArrayList<Certification> certifications = new ArrayList<>();
    private ArrayList<Job> jobs = new ArrayList<>();
    private ArrayList<Project> projects = new ArrayList<>();

    public void addGlobalSkill(String skill) {
        if (!globalSkills.contains(skill)) {
            globalSkills.add(skill);
        }
    }

    public ArrayList<String> getGlobalSkills() {
        return globalSkills;
    }

    public void addCertification(Certification cert) {
        certifications.add(cert);
    }

    public void addJob(Job job) {
        jobs.add(job);
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public ArrayList<Certification> getCertifications() { return certifications; }
    public ArrayList<Job> getJobs() { return jobs; }
    public ArrayList<Project> getProjects() { return projects; }
}
