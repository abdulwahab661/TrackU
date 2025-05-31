import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class LanguagePane {

    public static Node getPane(Resume resume) {
        GridPane grid = new GridPane();
        grid.setHgap(12); grid.setVgap(10); grid.setPadding(new Insets(20));

        TextField nameField = new TextField();
        nameField.setPromptText("e.g., English");

        ComboBox<String> proficiencyBox = new ComboBox<>(FXCollections.observableArrayList(
                "Beginner", "Intermediate", "Fluent", "Native"
        ));
        proficiencyBox.setPromptText("Select proficiency");

        // Optional: pick a certificate from existing ones
        ComboBox<Certification> certBox = new ComboBox<>();
        certBox.getItems().addAll(resume.getCertificates());
        certBox.setPromptText("Proof Certificate (Optional)");

        Button addBtn = new Button("Add Language");
        Label statusLabel = new Label();

        grid.add(new Label("Language Name:"), 0, 0); grid.add(nameField, 1, 0);
        grid.add(new Label("Proficiency:"), 0, 1); grid.add(proficiencyBox, 1, 1);
        grid.add(new Label("Certificate:"), 0, 2); grid.add(certBox, 1, 2);
        grid.add(addBtn, 1, 3); grid.add(statusLabel, 1, 4);

        addBtn.setOnAction(e -> {
            if (!nameField.getText().matches("^[A-Za-z\\s]{2,30}$")) {
                statusLabel.setText("❌ Invalid language name.");
                return;
            }
            if (proficiencyBox.getValue() == null) {
                statusLabel.setText("❌ Please select proficiency.");
                return;
            }

            Language lang = new Language(
                    nameField.getText().trim(),
                    proficiencyBox.getValue(),
                    certBox.getValue()
            );

            resume.addLanguage(lang);
            statusLabel.setText("✅ Language added!");

            nameField.clear(); proficiencyBox.setValue(null); certBox.setValue(null);
        });

        VBox wrapper = new VBox(10, grid); wrapper.setPadding(new Insets(10));
        return new ScrollPane(wrapper);
    }
}
