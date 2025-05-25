import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class SoftSkillPane {

    public static Node getPane(Resume resume) {

        VBox box = new VBox(10); box.setPadding(new Insets(20));

    TextField name = new TextField();
    TextField example = new TextField();
    Button addBtn = new Button("Add Soft Skill");
    Label status = new Label();

    addBtn.setOnAction(e -> {
        SoftSkill s = new SoftSkill(name.getText(), example.getText());
        resume.addSoftSkill(s);
        status.setText("Soft Skill Added Successfully");
    });

    box.getChildren().addAll(
            new Label("Skill Name"), name,
            new Label("Example or Description"), example,
            addBtn, status
    );

    return new ScrollPane(box);
}

}

