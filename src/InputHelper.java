import java.util.List;
import java.util.Scanner;

public class InputHelper {

    private static String promptNonEmpty(Scanner sc, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("This field cannot be empty. Please try again.");
            }
        } while (input.isEmpty());
        return input;
    }

    private static String promptValidated(Scanner sc, String prompt, String regex, String errorMsg) {
        String input;
        do {
            System.out.print(prompt);
            input = sc.nextLine().trim();
            if (!input.matches(regex)) {
                System.out.println(errorMsg);
            }
        } while (!input.matches(regex));
        return input;
    }

    private static int promptInt(Scanner sc, String prompt, int min, int max) {
        int choice;
        while (true) {
            try {
                System.out.print(prompt);
                choice = Integer.parseInt(sc.nextLine().trim());
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.println("Enter a number between " + min + " and " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    private static boolean promptBoolean(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt + " (yes/no): ");
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("yes")) return true;
            if (input.equals("no")) return false;
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
        }
    }
    public static Education inputEducation(Scanner sc) {
        System.out.println("\n--- Add Education ---");
        String title = promptNonEmpty(sc, "Degree Title: ");
        String description = promptNonEmpty(sc, "Degree Description: ");
        String date = promptValidated(sc, "Date (e.g., 2020-2024): ", "^\\d{4}-\\d{4}$", "Invalid date format. Use YYYY-YYYY.");
        String institution = promptNonEmpty(sc, "Institution: ");
        String major = promptNonEmpty(sc, "Major: ");
        String location = promptNonEmpty(sc, "Location: ");
        String gpa = promptValidated(sc, "GPA: ", "^(?:[0-3](?:\\.\\d{1,2})?|4(?:\\.0{1,2})?)$", "Enter valid GPA (0.00 - 4.00)");
        String honors = promptNonEmpty(sc, "Honors (or type 'None'): ");
        System.out.println("--- Added Education Details Successfully! --- \n");
        return new Education(title, description, date, institution, major, location, gpa, honors);
    }

    public static Certification inputCertificate(Scanner sc) {
        System.out.println("\n--- Add Certificate ---");
        String title = promptNonEmpty(sc, "Title: ");
        String description = promptNonEmpty(sc, "Description: ");
        String date = promptValidated(sc, "Date (e.g., Jan 2024): ", "^\\w{3,9} \\d{4}$", "Invalid date format. Use 'Jan 2024'.");
        String issuer = promptNonEmpty(sc, "Issuer: ");
        String certificateId = promptNonEmpty(sc, "Certificate ID: ");
        String certificateURL = promptValidated(sc, "Certificate URL: ", "^(https?|ftp)://[^\s/$.?#].[^\s]*$", "Invalid URL format.");
        String validityPeriod = promptNonEmpty(sc, "Validity Period: ");
        String level = promptNonEmpty(sc, "Level: ");
        System.out.println("\n--- Added Certification Details Successfully! --- \n");
        return new Certification(title, description, date, issuer, certificateId, certificateURL, validityPeriod, level);
    }

    public static Internship inputInternship(Scanner sc) {
        System.out.println("\n--- Add Internship ---");
        String title = promptNonEmpty(sc, "Title: ");
        String description = promptNonEmpty(sc, "Description: ");
        String date = promptNonEmpty(sc, "Date: ");
        String company = promptNonEmpty(sc, "Company Name: ");
        String duration = promptNonEmpty(sc, "Duration: ");
        String location = promptNonEmpty(sc, "Location: ");
        boolean isPaid = promptBoolean(sc, "Is it a paid internship?");
        String supervisorName = promptNonEmpty(sc, "Supervisor Name: ");
        boolean certificateReceived = promptBoolean(sc, "Certificate Received?");
        System.out.println("\n--- Added Internship Details Successfully! --- \n");
        return new Internship(title, description, date, company, duration, location, isPaid, supervisorName, certificateReceived);
    }

    public static Job inputJob(Scanner sc) {
        System.out.println("\n--- Add Job ---");
        String title = promptNonEmpty(sc, "Title: ");
        String description = promptNonEmpty(sc, "Description: ");
        String date = promptNonEmpty(sc, "Date: ");
        String companyName = promptNonEmpty(sc, "Company Name: ");
        String location = promptNonEmpty(sc, "Location: ");
        String duration = promptNonEmpty(sc, "Duration: ");
        String employmentType = promptNonEmpty(sc, "Employment Type: ");
        String techs = promptNonEmpty(sc, "Technologies Used (comma separated): ");
        List<String> technologiesUsed = List.of(techs.split("\\s*,\\s*"));
        int teamSize = promptInt(sc, "Team Size: ", 1, 100);
        System.out.println("\n--- Added Job Details Successfully! --- \n");
        return new Job(title, description, date, companyName, location, duration, employmentType, technologiesUsed, teamSize);
    }

    public static Language inputLanguage(Scanner sc, List<Certification> existingCertificates) {
        System.out.println("\n--- Add Language ---");
        String name = promptNonEmpty(sc, "Language Name: ");
        String proficiency = promptNonEmpty(sc, "Proficiency (e.g., Beginner, Fluent): ");
        Certification linkedCert = null;
        if (!existingCertificates.isEmpty() && promptBoolean(sc, "Do you want to link a certificate?")) {
            System.out.println("Available Certificates:");
            for (int i = 0; i < existingCertificates.size(); i++) {
                System.out.println((i + 1) + ". " + existingCertificates.get(i).toString());
            }
            int certIndex = promptInt(sc, "Enter certificate number to link: ", 1, existingCertificates.size()) - 1;
            linkedCert = existingCertificates.get(certIndex);
            System.out.println("\n--- Added Language Details Successfully! --- \n");
        }
        return new Language(name, proficiency, linkedCert);
    }

    public static SoftSkill inputSoftSkill(Scanner sc) {
        System.out.println("\n--- Add Soft Skill ---");
        String name = promptNonEmpty(sc, "Skill Name: ");
        String description = promptNonEmpty(sc, "Example or Description: ");
        System.out.println("\n--- Added Soft Skill Details Successfully! --- \n");
        return new SoftSkill(name, description);
    }

    public static Achievement inputAchievement(Scanner sc) {
        System.out.println("\n--- Add Achievement ---");
        String title = promptNonEmpty(sc, "Title: ");
        String description = promptNonEmpty(sc, "Description: ");
        String date = promptNonEmpty(sc, "Date: ");
        String category = promptNonEmpty(sc, "Category: ");
        String issuer = promptNonEmpty(sc, "Issuer: ");
        String location = promptNonEmpty(sc, "Location: ");
        String link = promptNonEmpty(sc, "Link: ");
        System.out.println("\n--- Added Achievement Details Successfully! --- \n");
        return new Achievement(title, description, date, category, issuer, location, link);
    }

    public static Reference inputReference(Scanner sc) {
        System.out.println("\n--- Add Reference ---");
        String name = promptNonEmpty(sc, "Name: ");
        String designation = promptNonEmpty(sc, "Designation: ");
        String contact = promptNonEmpty(sc, "Contact Info: ");
        System.out.println("\n--- Added Reference Details Successfully! --- \n");
        return new Reference(name, designation, contact);
    }

    public static Project inputProject(Scanner sc) {
        System.out.println("\n--- Add Project ---");
        String title = promptNonEmpty(sc, "Title: ");
        String description = promptNonEmpty(sc, "Description: ");
        String technologies = promptNonEmpty(sc, "Technologies Used: ");
        String duration = promptNonEmpty(sc, "Duration: ");
        String role = promptNonEmpty(sc, "Role: ");
        System.out.print("Link (optional): ");
        String link = sc.nextLine().trim();
        System.out.println("\n--- Added Project Details Successfully! --- \n");
        return new Project(title, description, technologies, duration, role, link);
    }

    public static GeneralInfo inputGeneralInfo(Scanner sc) {
        System.out.println("\n--- Add General Info ---");
        String name = promptNonEmpty(sc, "Full Name: ");
        String email = promptValidated(sc, "Email: ", "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$", "Invalid email format.");
        String phoneNumber = promptValidated(sc, "Phone Number (e.g., xxxx-xxxxxxx): ", "^\\d{4}-\\d{7}$", "Invalid phone number format.");
        String address = promptNonEmpty(sc, "Address: ");
        System.out.print("LinkedIn (optional): ");
        String linkedIn = sc.nextLine().trim();
        System.out.print("GitHub (optional): ");
        String github = sc.nextLine().trim();
        System.out.print("Website (optional): ");
        String website = sc.nextLine().trim();
        System.out.println("\n--- Added General Info Successfully! ---\n");
        return new GeneralInfo(name, email, phoneNumber, address, linkedIn, github, website);
    }
}
