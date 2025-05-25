import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class EducationPane {

    public static Node getPane(Resume resume) {

        VBox box = new VBox(10);
        box.setPadding(new Insets(20));

    TextField title = new TextField();
    TextField description = new TextField();
    TextField date = new TextField();
    TextField institution = new TextField();
    TextField startDate = new TextField();
    TextField endDate = new TextField();
    TextField gpa = new TextField();
    TextField honors = new TextField();
    Button addBtn = new Button("Add Education");
    Label status = new Label();

    addBtn.setOnAction(e -> {
        if (!gpa.getText().matches("^(?:[0-3](?:\\.\\d{1,2})?|4(?:\\.0{1,2})?)$")) {
            status.setText("Invalid GPA Format (0.00 - 4.00)");
            return;
        }
        Education edu = new Education(
                title.getText(), description.getText(), date.getText(),
                institution.getText(), startDate.getText(), endDate.getText(),
                gpa.getText(), honors.getText()
        );
        resume.addEducation(edu);
        status.setText("Education Added Successfully");
    });

    box.getChildren().addAll(
            new Label("Degree Title"), title,
            new Label("Degree Description"), description,
            new Label("Date (e.g. 2020-2024)"), date,
            new Label("Institution"), institution,
            new Label("Start Date"), startDate,
            new Label("End Date"), endDate,
            new Label("GPA"), gpa,
            new Label("Honors (or 'None')"), honors,
            addBtn, status
    );

    return new ScrollPane(box);
 }

}

