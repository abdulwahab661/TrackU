import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

public class EducationPane {

    public static Node getPane(Resume resume) {
        GridPane grid = new GridPane();
        grid.setHgap(12);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        // === Input Fields ===
        TextField titleField = new TextField();
        titleField.setPromptText("e.g., BS Computer Science");

        TextField descField = new TextField();
        descField.setPromptText("e.g., Focused on software development");

        TextField institutionField = new TextField();
        institutionField.setPromptText("e.g., COMSATS University");

        DatePicker startDatePicker = new DatePicker();
        DatePicker endDatePicker = new DatePicker();

        TextField gpaField = new TextField();
        gpaField.setPromptText("e.g., 3.85");

        TextField honorsField = new TextField();
        honorsField.setPromptText("e.g., Magna Cum Laude or 'None'");

        Button addBtn = new Button("Add Education");
        Label statusLabel = new Label();

        // === Layout ===
        grid.add(new Label("Degree Title:"), 0, 0); grid.add(titleField, 1, 0);
        grid.add(new Label("Description:"), 0, 1); grid.add(descField, 1, 1);
        grid.add(new Label("Institution:"), 0, 2); grid.add(institutionField, 1, 2);
        grid.add(new Label("Start Date:"), 0, 3); grid.add(startDatePicker, 1, 3);
        grid.add(new Label("End Date:"), 0, 4); grid.add(endDatePicker, 1, 4);
        grid.add(new Label("GPA:"), 0, 5); grid.add(gpaField, 1, 5);
        grid.add(new Label("Honors:"), 0, 6); grid.add(honorsField, 1, 6);
        grid.add(addBtn, 1, 7);
        grid.add(statusLabel, 1, 8);

        // === Button Action ===
        addBtn.setOnAction(e -> {
            LocalDate startDate = startDatePicker.getValue();
            LocalDate endDate = endDatePicker.getValue();

            if (!gpaField.getText().matches("^(?:[0-3](\\.\\d{1,2})?|4\\.0{1,2})$")) {
                gpaField.setStyle("-fx-border-color: red;");
                statusLabel.setText("❌ Invalid GPA. Use format like 3.85");
                return;
            } else {
                gpaField.setStyle(null);
            }

            if (startDate == null || endDate == null) {
                statusLabel.setText("❌ Please select both start and end dates.");
                return;
            }

            if (endDate.isBefore(startDate)) {
                statusLabel.setText("❌ End date must be after Start date.");
                return;
            }

            String startStr = startDate.toString(); // or format as needed
            String endStr = endDate.toString();
            String dateRange = startStr + " to " + endStr;

            Education edu = new Education(
                    titleField.getText(),
                    descField.getText(),
                    dateRange,
                    institutionField.getText(),
                    startStr,
                    endStr,
                    gpaField.getText(),
                    honorsField.getText()
            );

            resume.addEducation(edu);
            statusLabel.setText("✅ Education Added Successfully!");

            // Clear fields
            titleField.clear(); descField.clear(); institutionField.clear();
            gpaField.clear(); honorsField.clear();
            startDatePicker.setValue(null); endDatePicker.setValue(null);
        });

        VBox wrapper = new VBox(10, grid);
        wrapper.setPadding(new Insets(10));
        return new ScrollPane(wrapper);
    }
}
