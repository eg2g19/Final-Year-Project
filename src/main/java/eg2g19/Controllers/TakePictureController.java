package eg2g19.Controllers;import eg2g19.*;import javafx.embed.swing.SwingFXUtils;import javafx.fxml.FXML;import javafx.fxml.FXMLLoader;import javafx.scene.Parent;import javafx.scene.Scene;import javafx.scene.control.Alert;import javafx.scene.control.Button;import javafx.scene.control.ChoiceBox;import javafx.scene.control.Label;import javafx.scene.image.Image;import javafx.scene.image.ImageView;import javafx.stage.Stage;import org.openimaj.image.MBFImage;import org.openimaj.image.processing.resize.ResizeProcessor;import org.openimaj.video.Video;import org.openimaj.video.VideoDisplay;import org.openimaj.video.capture.VideoCaptureException;import org.openimaj.image.ImageUtilities;import org.openimaj.time.Timer;import javax.swing.*;import java.awt.event.WindowEvent;import java.awt.image.BufferedImage;import java.io.File;import java.io.IOException;import java.util.function.Function;import static org.openimaj.image.processing.resize.ResizeProcessor.doubleSize;public class TakePictureController {    @FXML    private ImageView imageView;    @FXML    public ChoiceBox timerBox;    @FXML    private Button saveBtn;    @FXML    private Label resultLabel;    @FXML    private Label probabilityLabel;    @FXML    private Button startStopBtn;    private LiveFeed liveFeed;    private Video video = null;    private VideoDisplay<MBFImage> display = null;    // to be set to false when pic is taken or closed    private boolean areDisplayingVideo = false;    private org.openimaj.image.Image openImage = null;    private JFrame frame = new JFrame("WebCam Feed");    private Image imageToClassify = null;    private File outF = null;    private boolean imageReady = false;    private String timerValue = "3 Seconds";    private String reply = null;    public TakePictureController() {        liveFeed = new LiveFeed();    }    @FXML    protected void onGoBackClicked() throws IOException {        if(!(video == null)) video.close();        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));        if(areDisplayingVideo) display.close();        MenuBarHandler.goBack(saveBtn);    }    @FXML    public void save() {        try {            Classifier.saveFile(saveBtn, openImage, resultLabel.getText());            Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);            errorAlert.setHeaderText("File Saved");            errorAlert.setContentText("File save successful");            errorAlert.showAndWait();        } catch(IOException e) {            Alert errorAlert = new Alert(Alert.AlertType.ERROR);            errorAlert.setHeaderText("Error Saving File");            errorAlert.setContentText("Please try again");            errorAlert.showAndWait();        }    }    @FXML    public void onCloseClicked() {        MenuBarHandler.close();    }    @FXML    public void reset() {        if (areDisplayingVideo) {            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));            frame = new JFrame("WebCam Feed");            addJFrameListener(frame);            if (imageReady) {                outF.delete();            }        } else {            if(imageReady) outF.delete();        }        imageReady = false;        imageView.setImage(null);        resultLabel.setText("Result");        probabilityLabel.setText("Confidence");        startStopBtn.setText("Start Camera Feed");    }    @FXML    public void takePicture() {        Timer timer = new Timer();        int time = 0;        if(timerValue.substring(0,1).equals("3")) time = 3000;        if(timerValue.substring(0,1).equals("5")) time = 5000;        if(timerValue.substring(0,1).equals("7")) time = 7000;        timer.start();        while(timer.duration() < time)        timer.stop();        openImage = video.getCurrentFrame();        openImage = openImage.extractCenter(320, 320).flipX();        BufferedImage bufferedImage = ImageUtilities.createBufferedImage(openImage);        imageToClassify = SwingFXUtils.toFXImage(bufferedImage, null);        imageView.setImage(imageToClassify);        outF = new File("." + File.separator + "Classify.jpeg");        try {            ImageUtilities.write(openImage, outF);            imageReady = true;        } catch (IOException e) {            e.printStackTrace();        }    }    @FXML    public void classify() {        if(imageReady) {            reply = Classifier.classifyImage(outF);            setResult(FunctionHandler.findTag(reply));            setProbability(FunctionHandler.findProbability(reply));        }        else {            Alert errorAlert = new Alert(Alert.AlertType.ERROR);            errorAlert.setHeaderText("No Picture Taken");            errorAlert.setContentText("Please Take a picture before requesting a classifcation");            errorAlert.showAndWait();        }    }    @FXML    public void startStopVideo() throws VideoCaptureException {        if(areDisplayingVideo) {            areDisplayingVideo = false;            frame = FunctionHandler.stopVideo(frame, video);            addJFrameListener(frame);            startStopBtn.setText("Start Camera Feed");        } else {            areDisplayingVideo = true;            initVideo();            startStopBtn.setText("Stop Camera Feed");        }    }    public void initDropDown() {        timerBox.getItems().add("No Timer");        timerBox.getItems().add("3 Seconds (Default)");        timerBox.getItems().add("5 Seconds");        timerBox.getItems().add("7 Seconds");        timerBox.setOnAction(event -> {            timerValue = (String) timerBox.getValue();        });        timerBox.setValue(timerValue);    }    public void initVideo() {        addJFrameListener(frame);        try {            video = FunctionHandler.startVideo(liveFeed);            display = liveFeed.displayVideoFeed(video, frame);        } catch (VideoCaptureException e) {            e.printStackTrace();            Alert errorAlert = new Alert(Alert.AlertType.ERROR);            errorAlert.setHeaderText("Could not find webcam");            errorAlert.setContentText("Please connect video device");            errorAlert.showAndWait();            areDisplayingVideo = false;        }    }    public void addJFrameListener(JFrame frame) {        frame.addWindowListener(new java.awt.event.WindowAdapter() {            @Override            public void windowClosing(java.awt.event.WindowEvent windowEvent) {                if(areDisplayingVideo) {                    areDisplayingVideo = false;                    display.close();                    video.close();                }            }        });    }    private void setResult(String result) { resultLabel.setText(result); }    private void setProbability(String probability){ probabilityLabel.setText(probability); }}