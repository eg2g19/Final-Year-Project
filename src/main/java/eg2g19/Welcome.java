package eg2g19;

import eg2g19.Controllers.WelcomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Welcome extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("welcome.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 800, 500);
        scene.getStylesheets().add(getClass().getResource(WelcomeController.styleSheetCol).toExternalForm());
        scene.getStylesheets().add(getClass().getResource(WelcomeController.styleSheetFont).toExternalForm());
        stage.setMinWidth(800);
        stage.setMinHeight(500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
