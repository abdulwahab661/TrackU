import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class CertificationPane {

    public static Node getPane(Resume resume) {
        VBox box = new VBox(10);
        box.setPadding(new Insets(20));

        TextField title = new TextField();
        TextField description = new TextField();
        TextField date = new TextField();
        TextField issuer = new TextField();
        TextField certId = new TextField();
        TextField url = new TextField();
        TextField validity = new TextField();
        TextField level = new TextField();
        Button addBtn = new Button("Add Certificate");
        Label status = new Label();

        addBtn.setOnAction(e -> {
            if (!url.getText().matches("^(https?|ftp)://[^\\s/$.?#].[^\\s]*$")) {
                status.setText("Invalid URL Format");
                return;
            }
            Certification cert = new Certification(
                    title.getText(), description.getText(), date.getText(), issuer.getText(),
                    certId.getText(), url.getText(), validity.getText(), level.getText()
            );
            resume.addCertificate(cert);
            status.setText("Certificate Added Successfully");
        });

        box.getChildren().addAll(
                new Label("Certificate Title"), title,
                new Label("Description"), description,
                new Label("Date (e.g. Jan 2024)"), date,
                new Label("Issuer"), issuer,
                new Label("Certificate ID"), certId,
                new Label("Certificate URL"), url,
                new Label("Validity Period"), validity,
                new Label("Level (Beginner, Intermediate, etc.)"), level,
                addBtn, status
        );

        return new ScrollPane(box);
    }

}