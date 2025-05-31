import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class GeneralInfoPane {

    public static Node getPane(Resume resume) {
        GridPane grid = new GridPane();
        grid.setHgap(12);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        // === Fields ===
        TextField nameField = new TextField();
        TextField emailField = new TextField();
        TextField phoneField = new TextField();
        TextField addressField = new TextField();
        TextField linkedInField = new TextField();
        TextField githubField = new TextField();
        TextField websiteField = new TextField();

        nameField.setPromptText("e.g., Ahmed Khan");
        emailField.setPromptText("e.g., you@email.com");
        phoneField.setPromptText("e.g., 03001234567");
        addressField.setPromptText("e.g., Islamabad, Pakistan");
        linkedInField.setPromptText("https://linkedin.com/in/username");
        githubField.setPromptText("https://github.com/username");
        websiteField.setPromptText("https://yourportfolio.com");

        Button submitBtn = new Button("Save Info");
        Label statusLabel = new Label();

        // === Layout ===
        grid.add(new Label("Name:"), 0, 0); grid.add(nameField, 1, 0);
        grid.add(new Label("Email:"), 0, 1); grid.add(emailField, 1, 1);
        grid.add(new Label("Phone Number:"), 0, 2); grid.add(phoneField, 1, 2);
        grid.add(new Label("Address:"), 0, 3); grid.add(addressField, 1, 3);
        grid.add(new Label("LinkedIn URL:"), 0, 4); grid.add(linkedInField, 1, 4);
        grid.add(new Label("GitHub URL:"), 0, 5); grid.add(githubField, 1, 5);
        grid.add(new Label("Website URL:"), 0, 6); grid.add(websiteField, 1, 6);
        grid.add(submitBtn, 1, 7);
        grid.add(statusLabel, 1, 8);

        // === Submit Logic ===
        submitBtn.setOnAction(e -> {
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String phone = phoneField.getText().trim();

            if (!name.matches("^[A-Za-z\\s]{2,50}$")) {
                statusLabel.setText("❌ Invalid name. Only letters and spaces allowed.");
                return;
            }

            if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) {
                statusLabel.setText("❌ Invalid email format.");
                return;
            }

            if (!phone.matches("^\\d{10,15}$")) {
                statusLabel.setText("❌ Phone number must be 10–15 digits.");
                return;
            }

            // Optional URL validation
            if (!linkedInField.getText().isBlank() && !linkedInField.getText().matches("^(https?|ftp)://[^\\s]+$")) {
                statusLabel.setText("❌ Invalid LinkedIn URL.");
                return;
            }

            if (!githubField.getText().isBlank() && !githubField.getText().matches("^(https?|ftp)://[^\\s]+$")) {
                statusLabel.setText("❌ Invalid GitHub URL.");
                return;
            }

            if (!websiteField.getText().isBlank() && !websiteField.getText().matches("^(https?|ftp)://[^\\s]+$")) {
                statusLabel.setText("❌ Invalid website URL.");
                return;
            }

            // Save data to Resume object
            GeneralInfo info = new GeneralInfo(
                    name,
                    email,
                    phone,
                    addressField.getText().trim(),
                    linkedInField.getText().trim(),
                    githubField.getText().trim(),
                    websiteField.getText().trim()
            );

            resume.setGeneralInfo(info);
            statusLabel.setText("✅ Information saved successfully!");
        });

        VBox wrapper = new VBox(10, grid);
        wrapper.setPadding(new Insets(10));
        return new ScrollPane(wrapper);
    }
}
