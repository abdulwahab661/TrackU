

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ResumeDashboard extends Application { private static Person currentUser;

    public static void launchWithUser(Person user) {
        currentUser = user;
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TrackU - Resume Dashboard");

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

        Tab customTab = new Tab("Custom Resume Builder");
        customTab.setContent(new Label("Click to load..."));
        customTab.setOnSelectionChanged(e -> {
            if (customTab.isSelected()) {
                customTab.setContent(CustomResumeBuilderPane.getPane(resume));
            }
        });
        tabPane.getTabs().add(customTab);

        tabPane.getTabs().forEach(t -> t.setClosable(false));

        Button saveBtn = new Button("Save Resume");
        saveBtn.setOnAction(e -> {
            UserManager.savePerson(currentUser);
        });

        VBox root = new VBox(tabPane, saveBtn);
        Scene scene = new Scene(root, 1000, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}