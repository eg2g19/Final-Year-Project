package eg2g19.Controllers;

import eg2g19.Welcome;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class WelcomeController {
    @FXML
    public Button tutorialBtn;
    public Button startBtn;

    public static String styleSheetCol = "Styles/stylesDefault.css";
    public static String styleSheetFont = "Styles/stylesSmall.css";

    @FXML
    protected void onTutorialButtonClick(ActionEvent event) throws URISyntaxException, IOException {

        URI uri = new URI("https://youtu.be/p1h3IIdcclc");
        java.awt.Desktop.getDesktop().browse(uri);
    }


    @FXML
    protected void onStartButtonClick(ActionEvent event) throws IOException {
        Stage welcomeStage = (Stage) startBtn.getScene().getWindow();
        welcomeStage.close();

        Stage stage = new Stage();
        appSelectionController.addCloseHandler(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("appSelection.fxml"));
        stage.setTitle("App Mode Selection");
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Welcome.class.getResource(WelcomeController.styleSheetCol).toExternalForm());
        scene.getStylesheets().add(Welcome.class.getResource(WelcomeController.styleSheetFont).toExternalForm());
        stage.setScene(scene);
        stage.setMinWidth(800);
        stage.setMinHeight(500);
        stage.show();
    }

    public static void setFontSize(String string) {
        styleSheetFont = string;
    }

}