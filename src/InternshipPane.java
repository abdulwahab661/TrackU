import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

public class InternshipPane {

    public static Node getPane(Resume resume) {

        GridPane grid = new GridPane();
        grid.setHgap(12);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        // === Input Fields ===
        TextField titleField = new TextField();
        titleField.setPromptText("e.g., Software Intern");

        TextField descField = new TextField();
        descField.setPromptText("e.g., Worked on web dev project");

        DatePicker datePicker = new DatePicker();

        TextField companyField = new TextField();
        companyField.setPromptText("e.g., Google");

        TextField durationField = new TextField();
        durationField.setPromptText("e.g., 3 months");

        TextField locationField = new TextField();
        locationField.setPromptText("e.g., Remote / Lahore");

        TextField supervisorField = new TextField();
        supervisorField.setPromptText("e.g., John Doe");

        CheckBox paidCheck = new CheckBox("Paid Internship");
        CheckBox certCheck = new CheckBox("Certificate Received");

        Button addBtn = new Button("Add Internship");
        Label statusLabel = new Label();

        // === Layout ===
        grid.add(new Label("Title:"), 0, 0); grid.add(titleField, 1, 0);
        grid.add(new Label("Description:"), 0, 1); grid.add(descField, 1, 1);
        grid.add(new Label("Date:"), 0, 2); grid.add(datePicker, 1, 2);
        grid.add(new Label("Company:"), 0, 3); grid.add(companyField, 1, 3);
        grid.add(new Label("Duration:"), 0, 4); grid.add(durationField, 1, 4);
        grid.add(new Label("Location:"), 0, 5); grid.add(locationField, 1, 5);
        grid.add(new Label("Supervisor:"), 0, 6); grid.add(supervisorField, 1, 6);
        grid.add(paidCheck, 1, 7);
        grid.add(certCheck, 1, 8);
        grid.add(addBtn, 1, 9);
        grid.add(statusLabel, 1, 10);

        // === Button Logic ===
        addBtn.setOnAction(e -> {
            // Validate date
            LocalDate date = datePicker.getValue();
            if (date == null) {
                statusLabel.setText("❌ Please select a valid date.");
                return;
            }

            // Validate company & location using regex
            String company = companyField.getText().trim();
            String location = locationField.getText().trim();
            String supervisor = supervisorField.getText().trim();

            if (!company.matches("^[\\w\\s&.()-]{2,50}$")) {
                statusLabel.setText("❌ Invalid company name.");
                return;
            }

            if (!location.matches("^[\\w\\s,.-]{2,50}$")) {
                statusLabel.setText("❌ Invalid location format.");
                return;
            }

            if (supervisor.isEmpty()) {
                statusLabel.setText("❌ Supervisor name cannot be empty.");
                return;
            }

            Internship internship = new Internship(
                    titleField.getText(),
                    descField.getText(),
                    date.toString(),
                    company,
                    durationField.getText(),
                    location,
                    paidCheck.isSelected(),
                    supervisor,
                    certCheck.isSelected()
            );

            resume.addInternship(internship);
            statusLabel.setText("✅ Internship added successfully!");

            // Clear fields
            titleField.clear(); descField.clear(); companyField.clear(); durationField.clear();
            locationField.clear(); supervisorField.clear(); datePicker.setValue(null);
            paidCheck.setSelected(false); certCheck.setSelected(false);
        });

        VBox wrapper = new VBox(10, grid);
        wrapper.setPadding(new Insets(10));
        return new ScrollPane(wrapper);
    }
}
