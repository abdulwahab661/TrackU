import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ReferencePane {

    public static Node getPane(Resume resume) {

        VBox box = new VBox(10); box.setPadding(new Insets(20));

    TextField name = new TextField();
    TextField designation = new TextField();
    TextField contact = new TextField();
    Button addBtn = new Button("Add Reference");
    Label status = new Label();

    addBtn.setOnAction(e -> {
        Reference ref = new Reference(name.getText(), designation.getText(), contact.getText());
        resume.addReference(ref);
        status.setText("Reference Added Successfully");
        name.clear();
        designation.clear();
        contact.clear();

    });

    box.getChildren().addAll(
            new Label("Name"), name,
            new Label("Designation"), designation,
            new Label("Contact Info"), contact,
            addBtn, status
    );

    return new ScrollPane(box);
}

}