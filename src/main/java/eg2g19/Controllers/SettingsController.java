package eg2g19.Controllers;

import eg2g19.MenuBarHandler;
import eg2g19.Welcome;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class SettingsController {
    @FXML
    public ChoiceBox <String> fontSizePicker;
    public ChoiceBox <String>  colorPicker;
    public Button applyBtn;

    public void initData() {
        fontSizePicker.getItems().add("Small");
        fontSizePicker.getItems().add("Medium");
        fontSizePicker.getItems().add("Large");

//        fontSizePicker.setValue("Medium");

        colorPicker.getItems().add("Purple");
        colorPicker.getItems().add("Black");
        colorPicker.getItems().add("Red");
        colorPicker.getItems().add("Blue");
        colorPicker.getItems().add("Green");

//        colorPicker.setValue("Purple");
    }

    public void apply(ActionEvent actionEvent) throws IOException {

        if(fontSizePicker.getValue() == "Small") WelcomeController.styleSheetFont = "Styles/stylesSmall.css";
        else if(fontSizePicker.getValue() == "Medium") WelcomeController.styleSheetFont = "Styles/stylesMedium.css";
        else if(fontSizePicker.getValue() == "Large") WelcomeController.styleSheetFont = "Styles/stylesLarge.css";

        if(colorPicker.getValue() == "Red") WelcomeController.styleSheetCol = "Styles/stylesRED.css";
        else if(colorPicker.getValue() == "Purple") WelcomeController.styleSheetCol = "Styles/stylesPURPLE.css";
        else if(colorPicker.getValue() == "Black") WelcomeController.styleSheetCol = "Styles/stylesBLACK.css";
        else if(colorPicker.getValue() == "Blue") WelcomeController.styleSheetCol = "Styles/stylesBLUE.css";
        else if(colorPicker.getValue() == "Green") WelcomeController.styleSheetCol = "Styles/stylesGREEN.css";

        MenuBarHandler.goBackToWelcome(applyBtn);
    }

//    private void openWelcome() throws IOException {
//        Stage stage = (Stage) applyBtn.getScene().getWindow();
//        stage.close();
//
//        Stage menuStage = new Stage();
//        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("welcome.fxml"));
//        menuStage.setTitle("Dashboard");
//        Scene scene = new Scene(loader.load());
//        menuStage.setScene(scene);
//        scene.getStylesheets().add(Welcome.class.getResource(WelcomeController.styleSheetCol).toExternalForm());
//        scene.getStylesheets().add(Welcome.class.getResource(WelcomeController.styleSheetFont).toExternalForm());
//
//        menuStage.setMinWidth(800);
//        menuStage.setMinHeight(700);
//        menuStage.show();
//    }

}
