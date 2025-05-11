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

    // Setters/Adders
    public void setGeneralInfo(GeneralInfo info) {
        this.generalInfo = info;
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

    // Display all entries
    public void displayAll() {
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

    // Interactive Resume Builder
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

        List<?>[] dataLists = new List<?>[]{
                certificates, internships, jobs, languages,
                softSkills, achievements, references, projects
        };

        List<List<Object>> selectedItems = new ArrayList<>();
        for (int i = 0; i < categories.length; i++) {
            selectedItems.add(new ArrayList<>());
        }

        int index = 0;
        while (index >= 0 && index < categories.length) {
            String category = categories[index];
            List<?> entries = dataLists[index];

            System.out.println("\n--- SELECT FROM: " + category + " ---");
            if (entries.isEmpty()) {
                System.out.println("No entries available.");
            } else {
                for (int i = 0; i < entries.size(); i++) {
                    String preview = entries.get(i).toString().split("\n")[0];
                    System.out.println((i + 1) + ". " + preview);
                }
            }

            System.out.println("Enter numbers to include, '>' for next, '<' for previous, '#' to finish:");
            String input = sc.nextLine().trim();

            if (input.equals("#")) break;
            else if (input.equals(">")) index++;
            else if (input.equals("<")) index--;
            else {
                String[] parts = input.split("[,\\s]+");
                List<Object> selected = new ArrayList<>();
                for (String part : parts) {
                    try {
                        int i = Integer.parseInt(part) - 1;
                        if (i >= 0 && i < entries.size()) {
                            selected.add(entries.get(i));
                        } else {
                            System.out.println("Invalid index: " + (i + 1));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input: " + part);
                    }
                }
                selectedItems.set(index, selected);
            }
        }

        // Display selected items
        for (int i = 0; i < categories.length; i++) {
            List<Object> selected = selectedItems.get(i);
            if (!selected.isEmpty()) {
                System.out.println("\n--- " + categories[i].toUpperCase() + " ---");
                for (Object o : selected) {
                    System.out.println(o);
                }
            }
        }
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