import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ProjectPane {

    public static Node getPane(Resume resume) {

        VBox box = new VBox(10); box.setPadding(new Insets(20));

    TextField title = new TextField();
    TextField description = new TextField();
    TextField technologies = new TextField();
    TextField duration = new TextField();
    TextField role = new TextField();
    TextField link = new TextField();
    Button addBtn = new Button("Add Project");
    Label status = new Label();

    addBtn.setOnAction(e -> {
        Project p = new Project(
                title.getText(), description.getText(), technologies.getText(),
                duration.getText(), role.getText(), link.getText()
        );
        resume.addProject(p);
        status.setText("Project Added Successfully");
    });

    box.getChildren().addAll(
            new Label("Project Title"), title,
            new Label("Description"), description,
            new Label("Technologies Used"), technologies,
            new Label("Duration"), duration,
            new Label("Role"), role,
            new Label("Link (optional)"), link,
            addBtn, status
    );

    return new ScrollPane(box);
}

}

