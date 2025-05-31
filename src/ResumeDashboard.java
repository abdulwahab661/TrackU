import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ResumeDashboard extends Application {

    private static Person currentUser;

    // ✅ This method is used from LoginScreen after successful login
    public static void launchWithUser(Person user, Stage primaryStage) {
        currentUser = user;
        Resume resume = currentUser.getResume();

        TabPane tabPane = new TabPane();

        tabPane.getTabs().add(new Tab("General Info", GeneralInfoPane.getPane(resume)));
        tabPane.getTabs().add(new Tab("Education", EducationPane.getPane(resume)));
        tabPane.getTabs().add(new Tab("Certifications", CertificationPane.getPane(resume)));
        tabPane.getTabs().add(new Tab("Internships", InternshipPane.getPane(resume)));
        tabPane.getTabs().add(new Tab("Jobs", JobPane.getPane(resume)));
        tabPane.getTabs().add(new Tab("Languages", LanguagePane.getPane(resume)));
        tabPane.getTabs().add(new Tab("Soft Skills", SoftSkillPane.getPane(resume)));
        tabPane.getTabs().add(new Tab("Achievements", AchievementPane.getPane(resume)));
        tabPane.getTabs().add(new Tab("References", ReferencePane.getPane(resume)));
        tabPane.getTabs().add(new Tab("Projects", ProjectPane.getPane(resume)));
        tabPane.getTabs().add(new Tab("Resume Preview", ResumePreviewPane.getPane(resume)));


        // Lazy-load custom builder when selected
        Tab customBuilderTab = new Tab("Custom Resume Builder");
        customBuilderTab.setContent(new Label("Click to load..."));
        customBuilderTab.setOnSelectionChanged(e -> {
            if (customBuilderTab.isSelected()) {
                customBuilderTab.setContent(CustomResumeBuilderPane.getPane(resume));
            }
        });
        tabPane.getTabs().add(customBuilderTab);

        tabPane.getTabs().forEach(tab -> tab.setClosable(false));

        Button saveBtn = new Button("Save Resume");
        saveBtn.setOnAction(e -> {
            UserManager.savePerson(currentUser);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Saved");
            alert.setHeaderText(null);
            alert.setContentText("Resume saved successfully!");
            alert.showAndWait();
        });

        VBox root = new VBox(tabPane, saveBtn);
        Scene scene = new Scene(root, 1000, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TrackU - Resume Dashboard");

    }

    // Only used if you run ResumeDashboard directly
    @Override
    public void start(Stage primaryStage) {
        if (currentUser == null) {
            System.out.println("No user logged in. Redirecting to LoginScreen...");
            new LoginScreen().start(primaryStage); // Go to login screen
        } else {
            launchWithUser(currentUser, primaryStage); // ResumeDashboard only works after login
        }
    }

    // Optional: if you still want to allow launching directly from here (for testing)
    public static void main(String[] args) {
        launch(args);
    }
}