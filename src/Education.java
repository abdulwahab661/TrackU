public class Education extends Entry {
    private String institution;
    private String startDate;
    private String endDate;
    private String gpa;
    private String honors;

    public Education(String title, String description, String date,
                     String institution, String startDate, String endDate,
                     String gpa, String honors) {
        super(title, description, date);
        this.institution = institution;
        this.startDate = startDate;
        this.endDate = endDate;
        this.gpa = gpa;
        this.honors = honors;
    }

    public String getInstitution() { return institution; }

    @Override
    public String toString() {
        return super.toString() +
                "\n  Institution: " + institution +
                "\n  Start Date: " + startDate +
                "\n  End Date: " + endDate +
                "\n  GPA: " + gpa +
                (honors != null ? "\n  Honors: " + honors : "");
    }
}