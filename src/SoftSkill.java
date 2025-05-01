public class SoftSkill {
    private String skillName;
    private String example; // New: a real-life example showing the skill

    public SoftSkill(String skillName, String example) {
        this.skillName = skillName;
        this.example = example;
    }

    @Override
    public String toString() {
        return "\nSkill: " + skillName +
                (example.isEmpty() ? "" : "\nExample: " + example);
    }
}