package eg2g19.Controllers;

import eg2g19.Classifier;
import eg2g19.FunctionHandler;
import eg2g19.MenuBarHandler;
import eg2g19.Welcome;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class FromFileController {

    @FXML
    private Button selectFileBtn;
    @FXML
    private Button classifyBtn;
    @FXML
    private ImageView imageView;
    @FXML
    private Label resultLabel;
    @FXML
    private Label probabilityLabel;
    @FXML
    private Button saveBtn;
    @FXML
    private MenuItem settingsMenu;


    private File imageFile = null;
    private String result = null;
    private boolean imageReady = false;
    private Image image = null;

    @FXML
    public void reset() {
        imageView.setImage(null);
        imageReady = false;
        image = null;
        setProbabilityLabel("Confidence");
        setResultLabel("Result");
    }

    @FXML
    public void onCloseBtnClicked() {
        MenuBarHandler.close();
    }

    @FXML
    protected void onGoBackClicked() throws IOException {
        MenuBarHandler.goBack(saveBtn);
    }

    @FXML
    public void onSaveBtnClicked() {
        if(imageReady) {
            try {
                Classifier.saveFile(saveBtn, image, resultLabel.getText());
                Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
                errorAlert.setHeaderText("File Saved");
                errorAlert.setContentText("File save successful");
                errorAlert.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Error Saving File");
                errorAlert.setContentText("Please try again");
                errorAlert.showAndWait();
            }
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("No File Selected");
            errorAlert.setContentText("Please select a file before requesting a classifcation");
            errorAlert.showAndWait();
        }
    }

    @FXML
    public void onSelectFileBtnClicked() {
        imageFile = selectFile();
        if(!(imageFile == null)) {
            image = new Image(imageFile.toURI().toString());
            imageView.setImage(image);
            imageReady = true;
        }
    }

    @FXML
    public void onClassifyBtnClicked() {

        //NOTE: requests  iteration 1!!!!
        Classifier classifier = new Classifier();
        if(imageReady) {
            String reply = classifier.classifyImage(imageFile);
            setResultLabel(FunctionHandler.findTag(reply));
            setProbabilityLabel(FunctionHandler.findProbability(reply));
        } else {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("No File Selected");
        errorAlert.setContentText("Please select a file before requesting a classifcation");
        errorAlert.showAndWait();
        }
    }


    //can return null
    private File selectFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.bmp"));
        File selectedFile = fileChooser.showOpenDialog(selectFileBtn.getScene().getWindow());
        if(selectedFile == null) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Error Selecting File");
            errorAlert.setContentText("File must be of image format");
            errorAlert.showAndWait();
            imageReady = false;
        }
        return selectedFile;
    }

    private void setResultLabel(String result) {
        this.result = result;
        resultLabel.setText(result);
    }

    private void setProbabilityLabel(String probability) {
        probabilityLabel.setText(probability);
    }
}
