import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GeneralInfoPane {

    public static Node getPane(Resume resume) {

        VBox box = new VBox(10); box.setPadding(new Insets(20));

    TextField nameField = new TextField();
    TextField emailField = new TextField();
    TextField phoneField = new TextField();
    TextField addressField = new TextField();
    TextField linkedInField = new TextField();
    TextField githubField = new TextField();
    TextField websiteField = new TextField();

    Button saveButton = new Button("Save Info");
    Label status = new Label();

    saveButton.setOnAction(e -> {
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
        String phoneRegex = "^\\d{4}-\\d{7}$";
        if (!emailField.getText().matches(emailRegex)) {
            status.setText("Invalid Email Format");
            return;
        }
        if (!phoneField.getText().matches(phoneRegex)) {
            status.setText("Invalid Phone Format");
            return;
        }
        GeneralInfo info = new GeneralInfo(
                nameField.getText(), emailField.getText(), phoneField.getText(),
                addressField.getText(), linkedInField.getText(),
                githubField.getText(), websiteField.getText()
        );
        resume.setGeneralInfo(info);
        status.setText("General Info Saved Successfully");
    });

    box.getChildren().addAll(
            new Label("Full Name"), nameField,
            new Label("Email"), emailField,
            new Label("Phone"), phoneField,
            new Label("Address"), addressField,
            new Label("LinkedIn"), linkedInField,
            new Label("GitHub"), githubField,
            new Label("Website"), websiteField,
            saveButton, status
    );

    return new ScrollPane(box);
}

}