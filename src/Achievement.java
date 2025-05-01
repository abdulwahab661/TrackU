public class Achievement extends Entry {
    private String category; // e.g., "Competition", "Award", "Publication"
    private String issuer;   // e.g., "Google", "ACM", "IEEE"
    private String location; // Optional: e.g., "Lahore, Pakistan" or "Online"
    private String link;     // Optional: link to proof or details

    public Achievement(String title, String description, String date,
                       String category, String issuer, String location, String link) {
        super(title, description, date);
        this.category = category;
        this.issuer = issuer;
        this.location = location;
        this.link = link;
    }

    public String getCategory() { return category; }
    public String getIssuer() { return issuer; }
    public String getLocation() { return location; }
    public String getLink() { return link; }

    @Override
    public String toString() {
        String result = super.toString() +
                "\n  Category: " + category +
                "\n  Issuer: " + issuer;

        if (location != null && !location.isEmpty())
            result += "\n  Location: " + location;

        if (link != null && !link.isEmpty())
            result += "\n  Link: " + link;

        return result;
    }
}