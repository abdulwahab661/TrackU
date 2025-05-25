import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import java.util.Arrays;

public class JobPane {

    public static Node getPane(Resume resume) {

        VBox box = new VBox(10); box.setPadding(new Insets(20));

    TextField title = new TextField();
    TextField description = new TextField();
    TextField date = new TextField();
    TextField company = new TextField();
    TextField location = new TextField();
    TextField duration = new TextField();
    TextField employmentType = new TextField();
    TextField techs = new TextField();
    TextField teamSize = new TextField();
    Button addBtn = new Button("Add Job");
    Label status = new Label();

    addBtn.setOnAction(e -> {
        try {
            int size = Integer.parseInt(teamSize.getText());
            Job job = new Job(
                    title.getText(), description.getText(), date.getText(),
                    company.getText(), location.getText(), duration.getText(),
                    employmentType.getText(),
                    Arrays.asList(techs.getText().split("\\s*,\\s*")),
                    size
            );
            resume.addJob(job);
            status.setText("Job Added Successfully");
        } catch (NumberFormatException ex) {
            status.setText("Invalid team size (must be an integer)");
        }
    });

    box.getChildren().addAll(
            new Label("Title"), title,
            new Label("Description"), description,
            new Label("Date"), date,
            new Label("Company Name"), company,
            new Label("Location"), location,
            new Label("Duration"), duration,
            new Label("Employment Type"), employmentType,
            new Label("Technologies (comma-separated)"), techs,
            new Label("Team Size"), teamSize,
            addBtn, status
    );

    return new ScrollPane(box);
}

}

