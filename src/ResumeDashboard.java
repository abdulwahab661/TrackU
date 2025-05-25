import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ResumeDashboard extends Application {

    private Resume resume = new Resume();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TrackU - Resume Dashboard");

        TabPane tabPane = new TabPane();

        Tab generalInfoTab = new Tab("General Info", GeneralInfoPane.getPane(resume));
        Tab educationTab = new Tab("Education", EducationPane.getPane(resume));
        Tab certificationsTab = new Tab("Certifications", CertificationPane.getPane(resume));
        Tab internshipsTab = new Tab("Internships", InternshipPane.getPane(resume));
        Tab jobsTab = new Tab("Jobs", JobPane.getPane(resume));
        Tab languagesTab = new Tab("Languages", LanguagePane.getPane(resume));
        Tab softSkillsTab = new Tab("Soft Skills", SoftSkillPane.getPane(resume));
        Tab achievementsTab = new Tab("Achievements", AchievementPane.getPane(resume));
        Tab referencesTab = new Tab("References", ReferencePane.getPane(resume));
        Tab projectsTab = new Tab("Projects", ProjectPane.getPane(resume));
        Tab previewTab = new Tab("Resume Preview", ResumePreviewPane.getPane(resume));

        tabPane.getTabs().addAll(
                generalInfoTab, educationTab, certificationsTab, internshipsTab, jobsTab,
                languagesTab, softSkillsTab, achievementsTab, referencesTab, projectsTab, previewTab
        );

        tabPane.getTabs().forEach(tab -> tab.setClosable(false));

        Scene scene = new Scene(tabPane, 1000, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

