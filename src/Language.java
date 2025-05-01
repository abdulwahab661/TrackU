public class Language {
    private String name;
    private String proficiency; // e.g., Beginner, Intermediate, Fluent
    private Certificate proofCertificate; // Link to Certificate

    public Language(String name, String proficiency, Certificate proofCertificate) {
        this.name = name;
        this.proficiency = proficiency;
        this.proofCertificate = proofCertificate;
    }

    public String getName(){
        return name; }

    public String getProficiency() {
        return proficiency; }

    public Certificate getProofCertificate() {
        return proofCertificate; }

    @Override
    public String toString() {
        String result = name + " - " + proficiency;
        if (proofCertificate != null) {
            result += "\n  Proof: " + proofCertificate.getTitle() + " (Issued by: " + proofCertificate.getIssuer() + ")";
        }
        return result;
    }
}