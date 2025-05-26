import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ResumeDashboard extends Application {

    private Resume resume = new Resume();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TrackU - Resume Dashboard");

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
        Tab customBuilderTab = new Tab("Custom Resume Builder");
        customBuilderTab.setContent(new Label("Click to load...")); // Placeholder
        customBuilderTab.setOnSelectionChanged(event -> {
            if (customBuilderTab.isSelected()) {
                customBuilderTab.setContent(CustomResumeBuilderPane.getPane(resume));
            }
        });

        tabPane.getTabs().add(customBuilderTab);


        tabPane.getTabs().forEach(tab -> tab.setClosable(false));

        Scene scene = new Scene(tabPane, 1000, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}