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
    public static Project inputProject(Scanner sc) {
        System.out.println("Enter project details:");
        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Description: ");
        String description = sc.nextLine();

        System.out.print("Technologies Used: ");
        String technologies = sc.nextLine();

        System.out.print("Duration: ");
        String duration = sc.nextLine();

        System.out.print("Role: ");
        String role = sc.nextLine();

        System.out.print("Link (optional): ");
        String link = sc.nextLine();

        return new Project(title, description, technologies, duration, role, link);
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