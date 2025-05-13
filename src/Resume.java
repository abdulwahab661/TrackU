import java.io.IOException;
import java.io.FileWriter;
import java.util.*;

public class Resume {
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

    public void setGeneralInfo(GeneralInfo info) {
        this.generalInfo = info;
    }

    public GeneralInfo getGeneralInfo() {
        return generalInfo;
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

    public void addEducation(Education e) {
        educationList.add(e);
    }

    public void addCertificate(Certification c) {
        certificates.add(c);
    }

    public void addInternship(Internship i) {
        internships.add(i);
    }

    public void addJob(Job j) {
        jobs.add(j);
    }

    public void addLanguage(Language l) {
        languages.add(l);
    }

    public void addSoftSkill(SoftSkill s) {
        softSkills.add(s);
    }

    public void addAchievement(Achievement a) {
        achievements.add(a);
    }

    public void addReference(Reference r) {
        references.add(r);
    }

    public void addProject(Project p) {
        projects.add(p);
    }

    public void displayInteractiveResume(Scanner sc) {
        System.out.println("\n=== RESUME ===");
        System.out.println("\n--- GENERAL INFORMATION ---");
        System.out.println(generalInfo != null ? generalInfo : "Not provided");

        System.out.println("\n--- EDUCATION ---");
        if (educationList.isEmpty()) {
            System.out.println("No education entries.");
        } else {
            for (Education e : educationList) {
                System.out.println(e);
            }
        }

        String[] categories = {
                "Certificates", "Internships", "Jobs", "Languages",
                "Soft Skills", "Achievements", "References", "Projects"
        };

        List[] dataLists = new List[]{
                certificates, internships, jobs, languages,
                softSkills, achievements, references, projects
        };

        List<List<Object>> selectedItems = new ArrayList<>();
        for (int i = 0; i < categories.length; i++) {
            selectedItems.add(new ArrayList<>());
        }

        while (true) {
            System.out.println("\n==== RESUME BUILDER MENU ====");
            for (int i = 0; i < categories.length; i++) {
                System.out.printf("%d. %s\n", (i + 1), categories[i]);
            }
            System.out.println((categories.length + 1) + ". Finish and Display Resume");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine().trim();

            int index = -1;
            try {
                int num = Integer.parseInt(choice);
                if (num == categories.length + 1) break;
                if (num >= 1 && num <= categories.length) {
                    index = num - 1;
                } else {
                    System.out.println("Invalid menu choice.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            List<?> entries = dataLists[index];
            List<Object> selected = selectedItems.get(index);

            while (true) {
                System.out.println("\n--- " + categories[index].toUpperCase() + " ---");
                if (entries.isEmpty()) {
                    System.out.println("No entries available.");
                    break;
                }

                System.out.println("Available:");
                for (int i = 0; i < entries.size(); i++) {
                    System.out.printf("%d.%s\n", (i + 1), entries.get(i).toString());
                }

                System.out.println("\nSelected:");
                for (int i = 0; i < selected.size(); i++) {
                    System.out.printf("%d.%s\n", (i + 1), selected.get(i).toString());
                }

                System.out.println("\nType numbers to include (e.g., 1,2), -n to remove (e.g., -1), or M to return to main menu:");
                String input = sc.nextLine().trim();
                if (input.equalsIgnoreCase("M")) break;

                String[] parts = input.split("[,\\s]+");
                for (String part : parts) {
                    try {
                        if (part.startsWith("-")) {
                            int removeIndex = Integer.parseInt(part.substring(1)) - 1;
                            if (removeIndex >= 0 && removeIndex < selected.size()) {
                                Object removed = selected.remove(removeIndex);
                                System.out.println("Removed: " + removed);
                            } else {
                                System.out.println("Invalid selected index to remove.");
                            }
                        } else {
                            int addIndex = Integer.parseInt(part) - 1;
                            if (addIndex >= 0 && addIndex < entries.size()) {
                                Object toAdd = entries.get(addIndex);
                                if (!selected.contains(toAdd)) {
                                    selected.add(toAdd);
                                    System.out.println("Added: " + toAdd);
                                } else {
                                    System.out.println("Already selected: " + toAdd);
                                }
                            } else {
                                System.out.println("Invalid index to add.");
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input: " + part);
                    }
                }
            }
        }

        // Display final resume
        System.out.println("\n=== FINAL RESUME ===");

        System.out.println("\n=== GENERAL INFORMATION ===");
        System.out.println(generalInfo != null ? generalInfo : "No general info provided.");

        System.out.println("\n=== EDUCATION ===");
        if (educationList.isEmpty()) {
            System.out.println("No education provided.");
        } else {
            for (Education e : educationList) {
                System.out.println(e);
            }
        }

        for (int i = 0; i < categories.length; i++) {
            List<Object> selected = selectedItems.get(i);
            if (!selected.isEmpty()) {
                System.out.println("\n=== " + categories[i].toUpperCase() + " ===");
                for (Object o : selected) {
                    System.out.println(o);
                }
            }
        }
    }

    // Method for Printing (File Handling)

    public void exportFinalResumeToFile(String filename) {
        StringBuilder resumeContent = new StringBuilder();

        resumeContent.append("===========================================\n");
        resumeContent.append("                FINAL RESUME               \n");
        resumeContent.append("===========================================\n\n");

        resumeContent.append("GENERAL INFORMATION:\n");
        resumeContent.append(generalInfo != null ? generalInfo.toString() : "  Not provided").append("\n\n");

        appendFormattedSection(resumeContent, "EDUCATION", educationList);
        appendFormattedSection(resumeContent, "CERTIFICATIONS", certificates);
        appendFormattedSection(resumeContent, "INTERNSHIPS", internships);
        appendFormattedSection(resumeContent, "JOBS", jobs);
        appendFormattedSection(resumeContent, "LANGUAGES", languages);
        appendFormattedSection(resumeContent, "SOFT SKILLS", softSkills);
        appendFormattedSection(resumeContent, "ACHIEVEMENTS", achievements);
        appendFormattedSection(resumeContent, "REFERENCES", references);
        appendFormattedSection(resumeContent, "PROJECTS", projects);

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(resumeContent.toString());
            System.out.println("Resume successfully exported to: " + filename);
        } catch (IOException e) {
            System.out.println("Error writing resume: " + e.getMessage());
        }
    }

    private <T> void appendFormattedSection(StringBuilder sb, String title, List<T> items) {
        sb.append(title).append(":\n");
        if (items.isEmpty()) {
            sb.append("  None listed.\n\n");
        } else {
            for (T item : items) {
                sb.append("  • ").append(item.toString()).append("\n");
            }
            sb.append("\n");
        }
    }

    public void displayAll() {
        System.out.println("\n=== FINAL RESUME (All Entries Included) ===");

        System.out.println("\n=== GENERAL INFORMATION ===");
        System.out.println(generalInfo != null ? generalInfo : "No general info provided.");

        printSection("EDUCATION", educationList);
        printSection("CERTIFICATES", certificates);
        printSection("INTERNSHIPS", internships);
        printSection("JOBS", jobs);
        printSection("LANGUAGES", languages);
        printSection("SOFT SKILLS", softSkills);
        printSection("ACHIEVEMENTS", achievements);
        printSection("REFERENCES", references);
        printSection("PROJECTS", projects);
    }

    private <T> void printSection(String title, List<T> list) {
        System.out.println("\n=== " + title + " ===");
        if (list.isEmpty()) {
            System.out.println("No " + title.toLowerCase() + " provided.");
        } else {
            for (T item : list) {
                System.out.println(item);
            }
        }
    }
}
