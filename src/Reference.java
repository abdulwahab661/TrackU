public class Reference {
    private String name;
    private String designation;
    private String contactInfo;

    public Reference(String name, String designation, String contactInfo) {
        this.name = name;
        this.designation = designation;
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return name + " (" + designation + ") - " + contactInfo;
    }
}
