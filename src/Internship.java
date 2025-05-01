public class Internship extends Entry {
    private String companyName;
    private String duration;
    private String location;
    private boolean isPaid;
    private String supervisorName;
    private boolean certificateReceived;

    public Internship(String title, String description, String date,
                      String companyName, String duration, String location,
                      boolean isPaid, String supervisorName, boolean certificateReceived) {
        super(title, description, date);
        this.companyName = companyName;
        this.duration = duration;
        this.location = location;
        this.isPaid = isPaid;
        this.supervisorName = supervisorName;
        this.certificateReceived = certificateReceived;
    }

    public String getCompanyName() { return companyName; }
    public String getDuration() { return duration; }
    public String getLocation() { return location; }
    public boolean isPaid() { return isPaid; }
    public String getSupervisorName() { return supervisorName; }
    public boolean isCertificateReceived() { return certificateReceived; }

    @Override
    public String toString() {
        return super.toString() +
                "\n  Company: " + companyName +
                "\n  Duration: " + duration +
                "\n  Location: " + location +
                "\n  Paid: " + (isPaid ? "Yes" : "No") +
                (supervisorName != null ? "\n  Supervisor: " + supervisorName : "") +
                "\n  Certificate Received: " + (certificateReceived ? "Yes" : "No");
    }
}