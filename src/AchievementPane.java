import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

import javafx.scene.layout.VBox;

public class AchievementPane {

    public static Node getPane(Resume resume) {

        VBox box = new VBox(10); box.setPadding(new Insets(20));

    TextField title = new TextField();
    TextField description = new TextField();
    TextField date = new TextField();
    TextField category = new TextField();
    TextField issuer = new TextField();
    TextField location = new TextField();
    TextField link = new TextField();
    Button addBtn = new Button("Add Achievement");
    Label status = new Label();

    addBtn.setOnAction(e -> {
        Achievement a = new Achievement(
                title.getText(), description.getText(), date.getText(),
                category.getText(), issuer.getText(),
                location.getText(), link.getText()
        );
        resume.addAchievement(a);
        status.setText("Achievement Added Successfully");
        title.clear(); description.clear(); date.clear();
        category.clear();
        issuer.clear(); location.clear(); link.clear();

    });

    box.getChildren().addAll(
            new Label("Title"), title,
            new Label("Description"), description,
            new Label("Date"), date,
            new Label("Category"), category,
            new Label("Issuer"), issuer,
            new Label("Location"), location,
            new Label("Link"), link,
            addBtn, status
    );

    return new ScrollPane(box);
}

}

