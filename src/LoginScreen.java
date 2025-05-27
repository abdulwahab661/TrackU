import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoginScreen extends Application {

    @Override
    public void start(Stage stage) {
        VBox box = new VBox(10);
        box.setPadding(new Insets(20));

        TextField username = new TextField();
        PasswordField password = new PasswordField();

        Button login = new Button("Login");
        Button register = new Button("Register");
        Label status = new Label();

        login.setOnAction(e -> {
            Person user = UserManager.login(username.getText(), password.getText());
            if (user != null) {
                ResumeDashboard.launchWithUser(user);
                stage.close();
            } else {
                status.setText("Login failed: Invalid credentials");
            }
        });

        register.setOnAction(e -> {
            if (UserManager.register(username.getText(), password.getText())) {
                status.setText("User registered successfully. You can now log in.");
            } else {
                status.setText("Username already taken.");
            }
        });

        box.getChildren().addAll(
                new Label("Username:"), username,
                new Label("Password:"), password,
                new HBox(10, login, register),
                status
        );

        stage.setScene(new Scene(box, 350, 200));
        stage.setTitle("Resume Login");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}