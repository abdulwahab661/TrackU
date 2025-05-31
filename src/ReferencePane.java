import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ReferencePane {

    public static Node getPane(Resume resume) {
        GridPane grid = new GridPane();
        grid.setHgap(12); grid.setVgap(10); grid.setPadding(new Insets(20));

        TextField nameField = new TextField();
        nameField.setPromptText("e.g., Dr. Salman Ahmad");

        TextField designationField = new TextField();
        designationField.setPromptText("e.g., Professor of CS");

        TextField contactField = new TextField();
        contactField.setPromptText("Email or Phone");

        Button addBtn = new Button("Add Reference");
        Label statusLabel = new Label();

        grid.add(new Label("Name:"), 0, 0); grid.add(nameField, 1, 0);
        grid.add(new Label("Designation:"), 0, 1); grid.add(designationField, 1, 1);
        grid.add(new Label("Contact Info:"), 0, 2); grid.add(contactField, 1, 2);
        grid.add(addBtn, 1, 3); grid.add(statusLabel, 1, 4);

        addBtn.setOnAction(e -> {
            String contact = contactField.getText().trim();
            boolean isEmail = contact.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$");
            boolean isPhone = contact.matches("^\\d{10,15}$");

            if (!nameField.getText().matches("^[A-Za-z\\s]{3,50}$")) {
                statusLabel.setText("❌ Invalid name.");
                return;
            }

            if (!isEmail && !isPhone) {
                statusLabel.setText("❌ Contact must be email or phone number.");
                return;
            }

            Reference ref = new Reference(
                    nameField.getText().trim(),
                    designationField.getText().trim(),
                    contact
            );

            resume.addReference(ref);
            statusLabel.setText("✅ Reference added!");
            nameField.clear(); designationField.clear(); contactField.clear();
        });

        VBox wrapper = new VBox(10, grid); wrapper.setPadding(new Insets(10));
        return new ScrollPane(wrapper);
    }
}
