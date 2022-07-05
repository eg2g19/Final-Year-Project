package eg2g19.Controllers;

import eg2g19.MenuBarHandler;
import eg2g19.Welcome;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class appSelectionController {

    @FXML
    private Button takeImageBtn;
    @FXML
    private Button fromFileBtn;

    @FXML
    protected void onGoBackClicked() throws IOException {
        MenuBarHandler.goBackToWelcome(takeImageBtn);
    }

    @FXML
    protected void onSettingsButtonClicked() throws IOException {
        MenuBarHandler.settingsClicked(takeImageBtn);
    }


    @FXML
    protected void onLiveVideoBtnClicked() throws IOException {
        Stage welcomeStage = (Stage) takeImageBtn.getScene().getWindow();
        welcomeStage.close();

        Stage stage = new Stage();
        addCloseHandler(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("realTime.fxml"));
        stage.setTitle("Live Classification");
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Welcome.class.getResource(WelcomeController.styleSheetCol).toExternalForm());
        scene.getStylesheets().add(Welcome.class.getResource(WelcomeController.styleSheetFont).toExternalForm());
        stage.setScene(scene);
        stage.setMinWidth(800);
        stage.setMinHeight(500);
        stage.show();


    }

    @FXML
    protected void onTakeImageBtnClicked() throws IOException {
        Stage welcomeStage = (Stage) takeImageBtn.getScene().getWindow();
        welcomeStage.close();

        Stage stage = new Stage();
        addCloseHandler(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("takePicture.fxml"));
        stage.setTitle("Take An Image To Classify");
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Welcome.class.getResource(WelcomeController.styleSheetCol).toExternalForm());
        scene.getStylesheets().add(Welcome.class.getResource(WelcomeController.styleSheetFont).toExternalForm());
        stage.setScene(scene);
        stage.setMinWidth(800);
        stage.setMinHeight(500);
        stage.show();

        TakePictureController tpc = fxmlLoader.getController();
        tpc.initDropDown();

    }

    @FXML
    protected void onFromFileBtnClicked() throws IOException {
        Stage welcomeStage = (Stage) fromFileBtn.getScene().getWindow();
        welcomeStage.close();

        Stage stage = new Stage();
        addCloseHandler(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("fromFile.fxml"));
        stage.setTitle("Classify From File");
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Welcome.class.getResource(WelcomeController.styleSheetCol).toExternalForm());
        scene.getStylesheets().add(Welcome.class.getResource(WelcomeController.styleSheetFont).toExternalForm());
        stage.setScene(scene);
        stage.setMinWidth(800);
        stage.setMinHeight(500);
        stage.show();
    }

    public static void addCloseHandler(Stage stage) {
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
    }
}
