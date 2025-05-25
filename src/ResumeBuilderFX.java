import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;

public class ResumeBuilderFX extends Application {

    private Resume resume = new Resume();


    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();

        tabPane.getTabs().add(createGeneralInfoTab());
        tabPane.getTabs().add(createListTab("Education", resume.getEducationList()));
        tabPane.getTabs().add(createListTab("Certifications", resume.getCertificates()));
        tabPane.getTabs().add(createListTab("Internships", resume.getInternships()));
        tabPane.getTabs().add(createListTab("Jobs", resume.getJobs()));
        tabPane.getTabs().add(createListTab("Languages", resume.getLanguages()));
        tabPane.getTabs().add(createListTab("Soft Skills", resume.getSoftSkills()));
        tabPane.getTabs().add(createListTab("Achievements", resume.getAchievements()));
        tabPane.getTabs().add(createListTab("References", resume.getReferences()));
        tabPane.getTabs().add(createListTab("Projects", resume.getProjects()));

        Button exportButton = new Button("Export Resume");
        exportButton.setOnAction(e -> {
            resume.exportFinalResumeToFile("resume_output.txt");
        });

        VBox layout = new VBox(tabPane, exportButton);
        layout.setSpacing(10);
        layout.setPadding(new Insets(10));

        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setTitle("Resume Builder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Tab createGeneralInfoTab() {
        Tab tab = new Tab("General Info");
        VBox box = new VBox(10);
        box.setPadding(new Insets(10));

        TextField nameField = new TextField();
        nameField.setPromptText("Full Name");
        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        TextField phoneField = new TextField();
        phoneField.setPromptText("Phone Number");
        TextField addressField = new TextField();
        addressField.setPromptText("Address");
        TextField linkedInField = new TextField();
        linkedInField.setPromptText("LinkedIn");
        TextField gitField = new TextField();
        gitField.setPromptText("Github");
        TextField websiteField = new TextField();
        websiteField.setPromptText("Website");

        Button saveButton = new Button("Save Info");
        saveButton.setOnAction(e -> {
            GeneralInfo info = new GeneralInfo(nameField.getText(), emailField.getText(), phoneField.getText(),addressField.getText(), linkedInField.getText(), gitField.getText(),websiteField.getText());
            resume.setGeneralInfo(info);
        });

        box.getChildren().addAll(
                new Label("Enter General Info:"),
                nameField, emailField, phoneField,
                saveButton
        );

        tab.setContent(box);
        return tab;
    }

    private <T> Tab createListTab(String title, List<T> list) {
        Tab tab = new Tab(title);
        VBox box = new VBox(10);
        box.setPadding(new Insets(10));

        TextField inputField = new TextField();
        inputField.setPromptText("Enter " + title + " info");

        ListView<T> listView = new ListView<>();
        listView.getItems().addAll(list);

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            String text = inputField.getText();
            if (!text.isEmpty()) {
                try {
                    @SuppressWarnings("unchecked")
                    T entry = (T) new GenericEntry(text);
                    list.add(entry);
                    listView.getItems().add(entry);
                    inputField.clear();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        Button removeButton = new Button("Remove Selected");
        removeButton.setOnAction(e -> {
            T selected = listView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                list.remove(selected);
                listView.getItems().remove(selected);
            }
        });

        box.getChildren().addAll(
                new Label("Manage " + title + ":"),
                inputField, addButton, removeButton,
                listView
        );
        tab.setContent(box);
        return tab;
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Generic class wrapper for plain string entries
    public static class GenericEntry {
        private String data;
        public GenericEntry(String data) { this.data = data; }
        @Override
        public String toString() { return data; }
    }

}