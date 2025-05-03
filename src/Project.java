import java.util.Scanner;

public class Project {
    private String title;
    private String description;
    private String technologiesUsed;
    private String duration;
    private String role;
    private String link;

    public Project(String title, String description, String technologiesUsed,
                   String duration, String role, String link) {
        this.title = title;
        this.description = description;
        this.technologiesUsed = technologiesUsed;
        this.duration = duration;
        this.role = role;
        this.link = link;
    }

    @Override
    public String toString() {
        return "\nProject Title: " + title +
                "\nDescription: " + description +
                "\nTechnologies Used: " + technologiesUsed +
                "\nDuration: " + duration +
                "\nRole: " + role +
                "\nLink: " + (link.isEmpty() ? "N/A" : link);
    }
}