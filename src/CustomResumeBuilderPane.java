import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.*;

public class CustomResumeBuilderPane {

    public static Node getPane(Resume resume) {
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));

        Label title = new Label("Custom Resume Builder - Select Entries to Export");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        root.getChildren().add(title);

        Map<String, List<?>> sourceMap = Map.of(
                "Certifications", resume.getCertificates(),
                "Internships", resume.getInternships(),
                "Jobs", resume.getJobs(),
                "Languages", resume.getLanguages(),
                "Soft Skills", resume.getSoftSkills(),
                "Achievements", resume.getAchievements(),
                "References", resume.getReferences(),
                "Projects", resume.getProjects()
        );

        Map<String, List<Object>> selectedMap = new LinkedHashMap<>();
        Map<String, ListView<Object>> selectedViews = new HashMap<>();

        for (String category : sourceMap.keySet()) {
            VBox categoryBox = new VBox(10);
            categoryBox.setStyle("-fx-border-color: gray; -fx-padding: 10");

            Label catLabel = new Label(category);
            catLabel.setStyle("-fx-font-weight: bold");

            ListView<Object> availableList = new ListView<>();
            availableList.getItems().addAll(sourceMap.get(category));
            availableList.setPrefHeight(100);

            ListView<Object> selectedList = new ListView<>();
            selectedList.setPrefHeight(100);
            selectedMap.put(category, new ArrayList<>());
            selectedViews.put(category, selectedList);

            Button addBtn = new Button("Add >>");
            Button removeBtn = new Button("<< Remove");

            addBtn.setOnAction(e -> {
                Object item = availableList.getSelectionModel().getSelectedItem();
                if (item != null && !selectedList.getItems().contains(item)) {
                    selectedList.getItems().add(item);
                    selectedMap.get(category).add(item);
                }
            });

            removeBtn.setOnAction(e -> {
                Object item = selectedList.getSelectionModel().getSelectedItem();
                if (item != null) {
                    selectedList.getItems().remove(item);
                    selectedMap.get(category).remove(item);
                }
            });

            HBox buttons = new HBox(10, addBtn, removeBtn);

            categoryBox.getChildren().addAll(catLabel, new Label("Available:"), availableList,
                    buttons, new Label("Selected:"), selectedList);
            root.getChildren().add(categoryBox);
        }

        Button exportBtn = new Button("Save Selected");
        Label status = new Label();

        exportBtn.setOnAction(e -> {
            CustomResumeState.clear();
            for (Map.Entry<String, List<Object>> entry : selectedMap.entrySet()) {
                if (!entry.getValue().isEmpty()) {
                    CustomResumeState.setSelected(entry.getKey(), entry.getValue());
                }
            }
            status.setText("Selected items saved. Preview tab will show them.");
        });

        root.getChildren().addAll(exportBtn, status);
        return new ScrollPane(root);
    }

}