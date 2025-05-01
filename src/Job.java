import java.util.ArrayList;
import java.util.List;

public class Job extends Entry {
    private String companyName;
    private String location;
    private String duration;
    private String employmentType;
    private List<String> technologiesUsed;
    private int teamSize;

    public Job(String title, String description, String date, String companyName,
               String location, String duration, String employmentType,
               List<String> technologiesUsed, int teamSize) {
        super(title, description, date);
        this.companyName = companyName;
        this.location = location;
        this.duration = duration;
        this.employmentType = employmentType;
        this.technologiesUsed = technologiesUsed != null ? technologiesUsed : new ArrayList<>();
        this.teamSize = teamSize;
    }

    public String getCompanyName() { return companyName; }
    public String getLocation() { return location; }
    public String getDuration() { return duration; }
    public String getEmploymentType() { return employmentType; }
    public List<String> getTechnologiesUsed() { return technologiesUsed; }
    public int getTeamSize() { return teamSize; }

    @Override
    public String toString() {
        return super.toString() +
                "\n  Company: " + companyName +
                "\n  Location: " + location +
                "\n  Duration: " + duration +
                "\n  Type: " + employmentType +
                (technologiesUsed.isEmpty() ? "" : "\n  Technologies: " + String.join(", ", technologiesUsed)) +
                (teamSize > 0 ? "\n  Team Size: " + teamSize : "");
    }
}