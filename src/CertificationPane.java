import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

public class CertificationPane {

    public static Node getPane(Resume resume) {

        GridPane grid = new GridPane();
        grid.setHgap(12);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        // === Input Fields ===
        TextField titleField = new TextField();
        titleField.setPromptText("e.g., Java Developer Certificate");

        TextField descField = new TextField();
        descField.setPromptText("e.g., Issued after passing exam");

        DatePicker datePicker = new DatePicker();

        TextField issuerField = new TextField();
        issuerField.setPromptText("e.g., Oracle");

        TextField certIdField = new TextField();
        certIdField.setPromptText("e.g., ORCL-123456");

        TextField certURLField = new TextField();
        certURLField.setPromptText("e.g., https://cert.oracle.com/cert/verify");

        TextField validityField = new TextField();
        validityField.setPromptText("e.g., 2 years / Lifetime");

        ComboBox<String> levelBox = new ComboBox<>(FXCollections.observableArrayList("Beginner", "Intermediate", "Advanced"));
        levelBox.setPromptText("Select Level");

        Button addBtn = new Button("Add Certification");
        Label statusLabel = new Label();

        // === Layout ===
        grid.add(new Label("Title:"), 0, 0); grid.add(titleField, 1, 0);
        grid.add(new Label("Description:"), 0, 1); grid.add(descField, 1, 1);
        grid.add(new Label("Date:"), 0, 2); grid.add(datePicker, 1, 2);
        grid.add(new Label("Issuer:"), 0, 3); grid.add(issuerField, 1, 3);
        grid.add(new Label("Certificate ID:"), 0, 4); grid.add(certIdField, 1, 4);
        grid.add(new Label("Certificate URL:"), 0, 5); grid.add(certURLField, 1, 5);
        grid.add(new Label("Validity Period:"), 0, 6); grid.add(validityField, 1, 6);
        grid.add(new Label("Level:"), 0, 7); grid.add(levelBox, 1, 7);
        grid.add(addBtn, 1, 8);
        grid.add(statusLabel, 1, 9);

        // === Action Logic ===
        addBtn.setOnAction(e -> {
            LocalDate date = datePicker.getValue();
            if (date == null) {
                statusLabel.setText("❌ Please select a valid date.");
                return;
            }

            String certId = certIdField.getText().trim();
            String certURL = certURLField.getText().trim();

            if (!certId.matches("^[A-Za-z0-9\\-]{3,30}$")) {
                statusLabel.setText("❌ Certificate ID must be 3-30 characters (letters/numbers/dashes).");
                return;
            }

            if (!certURL.matches("^(https?|ftp)://[^\\s/$.?#].[^\\s]*$")) {
                statusLabel.setText("❌ Invalid certificate URL.");
                return;
            }

            if (levelBox.getValue() == null) {
                statusLabel.setText("❌ Please select a level.");
                return;
            }

            Certification cert = new Certification(
                    titleField.getText(),
                    descField.getText(),
                    date.toString(),
                    issuerField.getText(),
                    certId,
                    certURL,
                    validityField.getText(),
                    levelBox.getValue()
            );

            resume.addCertificate(cert);
            statusLabel.setText("✅ Certification added successfully!");

            // Clear fields
            titleField.clear(); descField.clear(); issuerField.clear(); certIdField.clear();
            certURLField.clear(); validityField.clear(); datePicker.setValue(null);
            levelBox.setValue(null);
        });

        VBox wrapper = new VBox(10, grid);
        wrapper.setPadding(new Insets(10));
        return new ScrollPane(wrapper);
    }
}
