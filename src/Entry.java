import java.util.ArrayList;
import java.util.List;

public class Entry {
    protected String title;
    protected String description;
    protected String date;
    protected List<String> relatedSkills;  // Skills used in this entry

    public Entry(String title, String description, String date) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.relatedSkills = new ArrayList<>();
    }

    public void addSkill(String skill) {
        relatedSkills.add(skill);
    }

    public List<String> getRelatedSkills() {
        return relatedSkills;
    }

    @Override
    public String toString() {
        return title + " - " + description + " (" + date + ")" +
                (relatedSkills.isEmpty() ? "" : "\n  Skills used: " + String.join(", ", relatedSkills));
    }
}
