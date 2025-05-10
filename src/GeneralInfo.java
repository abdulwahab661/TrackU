public class GeneralInfo {
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String linkedIn;
    private String github;
    private String website;

    // Constructor
    public GeneralInfo(String name, String email, String phoneNumber, String address,
                       String linkedIn, String github, String website) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.linkedIn = linkedIn;
        this.github = github;
        this.website = website;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    // toString method for display
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Phone: ").append(phoneNumber).append("\n");
        sb.append("Address: ").append(address).append("\n");

        if (linkedIn != null && !linkedIn.isEmpty())
            sb.append("LinkedIn: ").append(linkedIn).append("\n");
        if (github != null && !github.isEmpty())
            sb.append("GitHub: ").append(github).append("\n");
        if (website != null && !website.isEmpty())
            sb.append("Website: ").append(website).append("\n");

        return sb.toString();
    }
}