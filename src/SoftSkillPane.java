import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class SoftSkillPane {

    public static Node getPane(Resume resume) {
        GridPane grid = new GridPane();
        grid.setHgap(12); grid.setVgap(10); grid.setPadding(new Insets(20));

        TextField skillNameField = new TextField();
        skillNameField.setPromptText("e.g., Teamwork");

        TextField exampleField = new TextField();
        exampleField.setPromptText("e.g., Led a group project in AI class");

        Button addBtn = new Button("Add Soft Skill");
        Label statusLabel = new Label();

        grid.add(new Label("Skill Name:"), 0, 0); grid.add(skillNameField, 1, 0);
        grid.add(new Label("Example:"), 0, 1); grid.add(exampleField, 1, 1);
        grid.add(addBtn, 1, 2); grid.add(statusLabel, 1, 3);

        addBtn.setOnAction(e -> {
            if (!skillNameField.getText().matches("^[A-Za-z\\s]{2,30}$")) {
                statusLabel.setText("❌ Skill name must be 2–30 letters.");
                return;
            }

            SoftSkill skill = new SoftSkill(
                    skillNameField.getText().trim(),
                    exampleField.getText().trim()
            );

            resume.addSoftSkill(skill);
            statusLabel.setText("✅ Soft skill added!");
            skillNameField.clear(); exampleField.clear();
        });

        VBox wrapper = new VBox(10, grid); wrapper.setPadding(new Insets(10));
        return new ScrollPane(wrapper);
    }
}
