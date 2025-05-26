import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ResumeBuilderFX extends Application {

    private Resume resume = new Resume();
    private Map<String, List<Object>> selectedItems = new HashMap<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TrackU - Resume Builder");

        TabPane tabPane = new TabPane();

        tabPane.getTabs().add(createObjectTab("Projects", resume.getProjects(), resume::addProject));
        tabPane.getTabs().add(createObjectTab("Internships", resume.getInternships(), resume::addInternship));
        tabPane.getTabs().add(createObjectTab("Soft Skills", resume.getSoftSkills(), resume::addSoftSkill));
        tabPane.getTabs().add(createObjectTab("Achievements", resume.getAchievements(), resume::addAchievement));

        Button exportButton = new Button("Export Selected");
        exportButton.setOnAction(e -> exportSelectedResumeToFile("resume_output.txt"));

        VBox root = new VBox(tabPane, exportButton);
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private <T> Tab createObjectTab(String category, List<T> dataList, java.util.function.Consumer<T> adder) {
        Tab tab = new Tab(category);
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        TextArea inputArea = new TextArea();
        inputArea.setPromptText("Enter new " + category + " info here...");

        ListView<T> listView = new ListView<>();
        listView.getItems().addAll(dataList);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Button addButton = new Button("Add");
        Label status = new Label();

        addButton.setOnAction(e -> {
            String text = inputArea.getText().trim();
            if (!text.isEmpty()) {
                T entry = null;

                switch (category) {
                    case "Projects" -> entry = (T) new Project(text, "desc", "tech", "dur", "role", "");
                    case "Internships" -> entry = (T) new Internship(text, "desc", "date", "comp", "dur", "loc", false, "sup", false);
                    case "Soft Skills" -> entry = (T) new SoftSkill(text, "example");
                    case "Achievements" -> entry = (T) new Achievement(text, "desc", "date", "cat", "issuer", "loc", "link");
                }

                if (entry != null) {
                    adder.accept(entry);
                    listView.getItems().add(entry);
                    inputArea.clear();
                    status.setText(category + " added.");
                }
            }
        });

        Button selectButton = new Button("Select for Export");
        selectButton.setOnAction(e -> {
            List<T> selected = listView.getSelectionModel().getSelectedItems();
            selectedItems.put(category, new ArrayList<>(selected));
            status.setText("Selected " + selected.size() + " " + category + " items.");
        });

        vbox.getChildren().addAll(new Label("Enter " + category + ":"), inputArea, addButton, listView, selectButton, status);
        tab.setContent(vbox);
        return tab;
    }

    private void exportSelectedResumeToFile(String filename) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== SELECTED RESUME CONTENT ===\n\n");

        if (resume.getGeneralInfo() != null) {
            sb.append("GENERAL INFO:\n").append(resume.getGeneralInfo()).append("\n\n");
        }

        if (!resume.getEducationList().isEmpty()) {
            sb.append("EDUCATION:\n");
            for (var e : resume.getEducationList()) {
                sb.append(e).append("\n");
            }
            sb.append("\n");
        }

        for (var entry : selectedItems.entrySet()) {
            sb.append(entry.getKey().toUpperCase()).append(":\n");
            for (Object obj : entry.getValue()) {
                sb.append(obj).append("\n");
            }
            sb.append("\n");
        }

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(sb.toString());
            System.out.println("Exported selected resume to: " + filename);
        } catch (IOException e) {
            System.out.println("Error writing resume: " + e.getMessage());
        }
    }
}