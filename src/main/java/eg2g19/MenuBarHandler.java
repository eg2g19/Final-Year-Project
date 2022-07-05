package eg2g19;

import eg2g19.Controllers.SettingsController;
import eg2g19.Controllers.WelcomeController;
import eg2g19.Controllers.appSelectionController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.openimaj.video.Video;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class MenuBarHandler {

    public static void stopVideo() {

    }

    public static void goBack(Node node) throws IOException {
        Stage welcomeStage = (Stage) node.getScene().getWindow();
        welcomeStage.close();

        Stage stage = new Stage();
        appSelectionController.addCloseHandler(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(MenuBarHandler.class.getClassLoader().getResource("appSelection.fxml"));
        stage.setTitle("Main Application");
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Welcome.class.getResource(WelcomeController.styleSheetCol).toExternalForm());
        scene.getStylesheets().add(Welcome.class.getResource(WelcomeController.styleSheetFont).toExternalForm());
        stage.setScene(scene);
        stage.setMinWidth(800);
        stage.setMinHeight(500);
        stage.show();
    }

    public static void goBackToWelcome(Node node) throws IOException {
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        Stage menuStage = new Stage();
        FXMLLoader loader = new FXMLLoader(WelcomeController.class.getClassLoader().getResource("welcome.fxml"));
        menuStage.setTitle("Dashboard");
        Scene scene = new Scene(loader.load());
        menuStage.setScene(scene);
        scene.getStylesheets().add(Welcome.class.getResource(WelcomeController.styleSheetCol).toExternalForm());
        scene.getStylesheets().add(Welcome.class.getResource(WelcomeController.styleSheetFont).toExternalForm());

        menuStage.setMinWidth(800);
        menuStage.setMinHeight(500);
        menuStage.show();
    }

    public static void settingsClicked(Node node) throws IOException {
        Stage welcomeStage = (Stage) node.getScene().getWindow();
        welcomeStage.close();

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MenuBarHandler.class.getClassLoader().getResource("settings.fxml"));
        stage.setTitle("Settings");
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Welcome.class.getResource(WelcomeController.styleSheetCol).toExternalForm());
        scene.getStylesheets().add(Welcome.class.getResource(WelcomeController.styleSheetFont).toExternalForm());
        stage.setScene(scene);
        stage.setMinWidth(800);
        stage.setMinHeight(500);
        SettingsController settingsController = fxmlLoader.getController();
        settingsController.initData();
        stage.show();
    }

    public static void close() {
        Platform.exit();
        System.exit(0);
    }
}
