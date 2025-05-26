import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class InternshipPane {

    public static Node getPane(Resume resume) {

        VBox box = new VBox(10); box.setPadding(new Insets(20));

    TextField title = new TextField();
    TextField description = new TextField();
    TextField date = new TextField();
    TextField company = new TextField();
    TextField duration = new TextField();
    TextField location = new TextField();
    TextField supervisor = new TextField();
    CheckBox paidCheck = new CheckBox("Paid Internship");
    CheckBox certCheck = new CheckBox("Certificate Received");
    Button addBtn = new Button("Add Internship");
    Label status = new Label();

    addBtn.setOnAction(e -> {
        Internship i = new Internship(
                title.getText(), description.getText(), date.getText(),
                company.getText(), duration.getText(), location.getText(),
                paidCheck.isSelected(), supervisor.getText(), certCheck.isSelected()
        );
        resume.addInternship(i);
        status.setText("Internship Added Successfully");
        title.clear(); description.clear(); date.clear();
        company.clear();
        duration.clear(); location.clear(); supervisor.clear();
        paidCheck.setSelected(false);
        certCheck.setSelected(false);

    });

    box.getChildren().addAll(
            new Label("Title"), title,
            new Label("Description"), description,
            new Label("Date"), date,
            new Label("Company Name"), company,
            new Label("Duration"), duration,
            new Label("Location"), location,
            new Label("Supervisor Name"), supervisor,
            paidCheck, certCheck, addBtn, status
    );

    return new ScrollPane(box);
}

}

