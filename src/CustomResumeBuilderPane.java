import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;

public class CustomResumeBuilderPane {

    public static Node getPane(Resume resume) {
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));

        Label title = new Label("Custom Resume Builder - Select Entries to Export");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        root.getChildren().add(title);

        // Store categories
        List<String> categories = List.of(
                "Certifications", "Internships", "Jobs", "Languages",
                "Soft Skills", "Achievements", "References", "Projects"
        );

        // All source and selected views
        List<ListView<Object>> availableViews = new ArrayList<>();
        List<ListView<Object>> selectedViews = new ArrayList<>();
        List<String> selectedCategories = new ArrayList<>();
        List<List<Object>> selectedEntries = new ArrayList<>();

        for (String category : categories) {
            VBox categoryBox = new VBox(10);
            categoryBox.setStyle("-fx-border-color: gray; -fx-padding: 10");

            Label catLabel = new Label(category);
            catLabel.setStyle("-fx-font-weight: bold");

            ListView<Object> availableList = new ListView<>();
            availableList.setPrefHeight(100);
            availableViews.add(availableList);

            ListView<Object> selectedList = new ListView<>();
            selectedList.setPrefHeight(100);
            selectedViews.add(selectedList);

            // Fill data into available list
            switch (category) {
                case "Certifications" -> availableList.getItems().addAll(resume.getCertificates());
                case "Internships" -> availableList.getItems().addAll(resume.getInternships());
                case "Jobs" -> availableList.getItems().addAll(resume.getJobs());
                case "Languages" -> availableList.getItems().addAll(resume.getLanguages());
                case "Soft Skills" -> availableList.getItems().addAll(resume.getSoftSkills());
                case "Achievements" -> availableList.getItems().addAll(resume.getAchievements());
                case "References" -> availableList.getItems().addAll(resume.getReferences());
                case "Projects" -> availableList.getItems().addAll(resume.getProjects());
            }

            List<Object> selected = new ArrayList<>();
            selectedEntries.add(selected);
            selectedCategories.add(category);

            Button addBtn = new Button("Add >>");
            Button removeBtn = new Button("<< Remove");

            int index = availableViews.size() - 1;

            addBtn.setOnAction(e -> {
                Object item = availableList.getSelectionModel().getSelectedItem();
                if (item != null && !selectedList.getItems().contains(item)) {
                    selectedList.getItems().add(item);
                    selected.add(item);
                }
            });

            removeBtn.setOnAction(e -> {
                Object item = selectedList.getSelectionModel().getSelectedItem();
                if (item != null) {
                    selectedList.getItems().remove(item);
                    selected.remove(item);
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
            for (int i = 0; i < selectedCategories.size(); i++) {
                if (!selectedEntries.get(i).isEmpty()) {
                    CustomResumeState.setSelected(selectedCategories.get(i), selectedEntries.get(i));
                }
            }
            status.setText("Selected items saved. Preview tab will show them.");
        });

        root.getChildren().addAll(exportBtn, status);
        return new ScrollPane(root);
    }
}