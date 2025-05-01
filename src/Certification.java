public class Certification extends Entry {
    private String issuer;
    private String certificateId;
    private String certificateURL;
    private String validityPeriod;
    private String level;

    public Certification(String title, String description, String date, String issuer,
                         String certificateId, String certificateURL, String validityPeriod, String level) {
        super(title, description, date);
        this.issuer = issuer;
        this.certificateId = certificateId;
        this.certificateURL = certificateURL;
        this.validityPeriod = validityPeriod;
        this.level = level;
    }

    public String getIssuer() { return issuer; }
    public String getCertificateId() { return certificateId; }
    public String getCertificateURL() { return certificateURL; }
    public String getValidityPeriod() { return validityPeriod; }
    public String getLevel() { return level; }

    @Override
    public String toString() {
        return super.toString() +
                "\n  Issuer: " + issuer +
                (certificateId != null ? "\n  ID: " + certificateId : "") +
                (certificateURL != null ? "\n  URL: " + certificateURL : "") +
                (validityPeriod != null ? "\n  Validity: " + validityPeriod : "") +
                (level != null ? "\n  Level: " + level : "");
    }
}