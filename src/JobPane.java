import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class JobPane {

    public static Node getPane(Resume resume) {
        GridPane grid = new GridPane();
        grid.setHgap(12);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        // === Input Fields ===
        TextField titleField = new TextField();
        titleField.setPromptText("e.g., Software Engineer");

        TextField descField = new TextField();
        descField.setPromptText("Job Description");

        DatePicker datePicker = new DatePicker();

        TextField companyField = new TextField();
        companyField.setPromptText("e.g., Google");

        TextField locationField = new TextField();
        locationField.setPromptText("e.g., Mountain View, CA");

        TextField durationField = new TextField();
        durationField.setPromptText("e.g., 6 months");

        TextField employmentTypeField = new TextField();
        employmentTypeField.setPromptText("e.g., Full-time, Internship");

        TextField techsField = new TextField();
        techsField.setPromptText("Comma-separated e.g., Java, Spring, MySQL");

        TextField teamSizeField = new TextField();
        teamSizeField.setPromptText("e.g., 4");

        Button addBtn = new Button("Add Job");
        Label statusLabel = new Label();

        // === Layout ===
        grid.add(new Label("Title:"), 0, 0); grid.add(titleField, 1, 0);
        grid.add(new Label("Description:"), 0, 1); grid.add(descField, 1, 1);
        grid.add(new Label("Date:"), 0, 2); grid.add(datePicker, 1, 2);
        grid.add(new Label("Company:"), 0, 3); grid.add(companyField, 1, 3);
        grid.add(new Label("Location:"), 0, 4); grid.add(locationField, 1, 4);
        grid.add(new Label("Duration:"), 0, 5); grid.add(durationField, 1, 5);
        grid.add(new Label("Employment Type:"), 0, 6); grid.add(employmentTypeField, 1, 6);
        grid.add(new Label("Technologies (comma-separated):"), 0, 7); grid.add(techsField, 1, 7);
        grid.add(new Label("Team Size:"), 0, 8); grid.add(teamSizeField, 1, 8);
        grid.add(addBtn, 1, 9);
        grid.add(statusLabel, 1, 10);

        // === Button Logic ===
        addBtn.setOnAction(e -> {
            String teamInput = teamSizeField.getText().trim();
            int teamSize;
            try {
                teamSize = Integer.parseInt(teamInput);
                if (teamSize < 1) throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                statusLabel.setText("❌ Invalid team size. Must be a positive integer.");
                return;
            }

            if (datePicker.getValue() == null) {
                statusLabel.setText("❌ Please select a valid date.");
                return;
            }

            LocalDate date = datePicker.getValue();
            List<String> technologies = Arrays.asList(techsField.getText().split("\\s*,\\s*"));

            Job job = new Job(
                    titleField.getText(),
                    descField.getText(),
                    date.toString(),
                    companyField.getText(),
                    locationField.getText(),
                    durationField.getText(),
                    employmentTypeField.getText(),
                    technologies,
                    teamSize
            );

            resume.addJob(job);
            statusLabel.setText("✅ Job added successfully!");

            // Clear all fields
            titleField.clear(); descField.clear(); companyField.clear(); locationField.clear();
            durationField.clear(); employmentTypeField.clear(); techsField.clear(); teamSizeField.clear();
            datePicker.setValue(null);
        });

        VBox wrapper = new VBox(10, grid);
        wrapper.setPadding(new Insets(10));
        return new ScrollPane(wrapper);
    }
}
