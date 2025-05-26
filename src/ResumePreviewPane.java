

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.List;
import java.util.Map;

public class ResumePreviewPane {

    public static Node getPane(Resume resume) {
        VBox box = new VBox(10);
        box.setPadding(new Insets(20));

        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefRowCount(40);

        ComboBox<String> modeSelector = new ComboBox<>();
        modeSelector.getItems().addAll("Full Resume", "Custom Resume");
        modeSelector.setValue("Full Resume");

        Button generateBtn = new Button("Generate");
        Button exportBtn = new Button("Export to File");
        Label status = new Label();

        generateBtn.setOnAction(e -> {
            if (modeSelector.getValue().equals("Full Resume")) {
                outputArea.setText(generateFullResume(resume));
            } else {
                outputArea.setText(generateCustomResume(resume));
            }
        });

        exportBtn.setOnAction(e -> {
            if (modeSelector.getValue().equals("Full Resume")) {
                resume.exportFinalResumeToFile("My_Resume.txt");
                status.setText("Exported full resume to My_Resume.txt");
            } else {
                CustomResumeState.exportToFile("Selected_Resume.txt", resume);
                status.setText("Exported custom resume to Selected_Resume.txt");
            }
        });

        HBox controls = new HBox(10, modeSelector, generateBtn, exportBtn);

        box.getChildren().addAll(controls, outputArea, status);
        return new ScrollPane(box);
    }

    private static String generateFullResume(Resume resume) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== FULL RESUME ===\n\n");
        sb.append(resume.getGeneralInfo() != null ? resume.getGeneralInfo().toString() + "\n" : "No general info\n");
        sb.append("\n=== EDUCATION ===\n");
        for (var edu : resume.getEducationList()) sb.append(edu).append("\n");

        sb.append("\n=== CERTIFICATIONS ===\n");
        for (var c : resume.getCertificates()) sb.append(c).append("\n");
        sb.append("\n=== INTERNSHIPS ===\n");
        for (var i : resume.getInternships()) sb.append(i).append("\n");
        sb.append("\n=== JOBS ===\n");
        for (var j : resume.getJobs()) sb.append(j).append("\n");
        sb.append("\n=== LANGUAGES ===\n");
        for (var l : resume.getLanguages()) sb.append(l).append("\n");
        sb.append("\n=== SOFT SKILLS ===\n");
        for (var s : resume.getSoftSkills()) sb.append(s).append("\n");
        sb.append("\n=== ACHIEVEMENTS ===\n");
        for (var a : resume.getAchievements()) sb.append(a).append("\n");
        sb.append("\n=== REFERENCES ===\n");
        for (var r : resume.getReferences()) sb.append(r).append("\n");
        sb.append("\n=== PROJECTS ===\n");
        for (var p : resume.getProjects()) sb.append(p).append("\n");

        return sb.toString();
    }

    private static String generateCustomResume(Resume resume) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== CUSTOM RESUME ===\n\n");
        sb.append("GENERAL INFO:\n");
        sb.append(resume.getGeneralInfo() != null ? resume.getGeneralInfo().toString() + "\n" : "No general info\n");
        sb.append("\nEDUCATION:\n");
        if (resume.getEducationList().isEmpty()) {
            sb.append("  None listed.\n\n");
        } else {
            for (var edu : resume.getEducationList()) {
                sb.append("  • ").append(edu).append("\n");
            }
        }
        sb.append("\n");

        Map<String, List<Object>> selected = CustomResumeState.getSelectedItems();
        for (Map.Entry<String, List<Object>> entry : selected.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                sb.append(entry.getKey().toUpperCase()).append(":\n");
                for (Object obj : entry.getValue()) {
                    sb.append("  • ").append(obj).append("\n");
                }
                sb.append("\n");
            }
        }

        return sb.toString();
    }

}