import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

public class ProjectPane {

    public static Node getPane(Resume resume) {
        GridPane grid = new GridPane();
        grid.setHgap(12);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        // === Input Fields ===
        TextField titleField = new TextField();
        titleField.setPromptText("e.g., Student Portal System");

        TextField descField = new TextField();
        descField.setPromptText("Brief description of the project");

        DatePicker startDatePicker = new DatePicker();
        DatePicker endDatePicker = new DatePicker();

        TextField techsField = new TextField();
        techsField.setPromptText("e.g., Java, MySQL, JavaFX");

        TextField roleField = new TextField();
        roleField.setPromptText("e.g., Team Lead / Developer");

        TextField linkField = new TextField();
        linkField.setPromptText("e.g., https://github.com/user/project");

        Button addBtn = new Button("Add Project");
        Label statusLabel = new Label();

        // === Layout ===
        grid.add(new Label("Title:"), 0, 0); grid.add(titleField, 1, 0);
        grid.add(new Label("Description:"), 0, 1); grid.add(descField, 1, 1);
        grid.add(new Label("Start Date:"), 0, 2); grid.add(startDatePicker, 1, 2);
        grid.add(new Label("End Date:"), 0, 3); grid.add(endDatePicker, 1, 3);
        grid.add(new Label("Technologies:"), 0, 4); grid.add(techsField, 1, 4);
        grid.add(new Label("Role:"), 0, 5); grid.add(roleField, 1, 5);
        grid.add(new Label("Project Link:"), 0, 6); grid.add(linkField, 1, 6);
        grid.add(addBtn, 1, 7);
        grid.add(statusLabel, 1, 8);

        // === Button Action ===
        addBtn.setOnAction(e -> {
            LocalDate startDate = startDatePicker.getValue();
            LocalDate endDate = endDatePicker.getValue();

            if (startDate == null || endDate == null) {
                statusLabel.setText("❌ Start and End dates are required.");
                return;
            }

            if (endDate.isBefore(startDate)) {
                statusLabel.setText("❌ End date must be after start date.");
                return;
            }

            String link = linkField.getText().trim();
            if (!link.isEmpty() && !link.matches("^(https?|ftp)://[^\\s/$.?#].[^\\s]*$")) {
                statusLabel.setText("❌ Invalid project URL.");
                return;
            }

            String duration = startDate + " to " + endDate;

            Project project = new Project(
                    titleField.getText(),
                    descField.getText(),
                    techsField.getText(),
                    duration,
                    roleField.getText(),
                    link
            );

            resume.addProject(project);
            statusLabel.setText("✅ Project added successfully!");

            // Clear fields
            titleField.clear(); descField.clear(); techsField.clear(); roleField.clear(); linkField.clear();
            startDatePicker.setValue(null); endDatePicker.setValue(null);
        });

        VBox wrapper = new VBox(10, grid);
        wrapper.setPadding(new Insets(10));
        return new ScrollPane(wrapper);
    }
}
