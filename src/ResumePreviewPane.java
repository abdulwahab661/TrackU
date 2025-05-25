import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ResumePreviewPane {

    public static Node getPane(Resume resume) {
        VBox box = new VBox(10); box.setPadding(new Insets(20));

    TextArea outputArea = new TextArea();
    outputArea.setEditable(false);
    outputArea.setPrefRowCount(40);

    Button generateBtn = new Button("Generate Full Resume");
    Button exportBtn = new Button("Export to File");
    Label status = new Label();

    generateBtn.setOnAction(e -> {
        resume.displayAll();
        outputArea.setText(resume.toString());
    });

    exportBtn.setOnAction(e -> {
        resume.exportFinalResumeToFile("My_Resume.txt");
        status.setText("Resume exported to My_Resume.txt");
    });

    box.getChildren().addAll(
            generateBtn, exportBtn, outputArea, status
    );

    return new ScrollPane(box);
}

}

