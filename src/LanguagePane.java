import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class LanguagePane {

    public static Node getPane(Resume resume) {

        VBox box = new VBox(10); box.setPadding(new Insets(20));

    TextField name = new TextField();
    TextField proficiency = new TextField();
    Label note = new Label("(Certificate linking not available yet in GUI)");
    Button addBtn = new Button("Add Language");
    Label status = new Label();

    addBtn.setOnAction(e -> {
        Language lang = new Language(
                name.getText(), proficiency.getText(), null
        );
        resume.addLanguage(lang);
        status.setText("Language Added Successfully");
    });

    box.getChildren().addAll(
            new Label("Language Name"), name,
            new Label("Proficiency Level"), proficiency,
            note, addBtn, status
    );

    return new ScrollPane(box);
}

}