package eg2g19.Controllers;

import eg2g19.Classifier;
import eg2g19.FunctionHandler;
import eg2g19.LiveFeed;
import eg2g19.MenuBarHandler;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.openimaj.time.Timer;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.video.Video;
import org.openimaj.video.VideoDisplay;
import org.openimaj.video.VideoDisplayListener;
import org.openimaj.video.capture.VideoCaptureException;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RealTimeController {

    private LiveFeed liveFeed;
    private boolean areDisplayingVideo = false;
    private boolean areClassifying = false;
    private JFrame frame = new JFrame("WebCam Feed");
    private Video video = null;
    private VideoDisplay<MBFImage> display = null;
    private String result = null;
    private String probability = null;
    private Timer timer = null;
    private Image imageToClassify = null;
    private final int realTimeDelay = 3000;

//    private long classifyingTime = 0;
//    private int classifications = 0;

    @FXML
    public ImageView imageView;
    public Label resultLabel;
    public Label probabilityLabel;
    public Button classifyingBtn;
    public Button startStopBtn;



    public RealTimeController() {
        liveFeed = new LiveFeed();
    }

    @FXML
    public void onCloseClicked() {
        MenuBarHandler.close();
    }

    @FXML
    public void onGoBackClicked() throws IOException {
        if(!(video == null)) video.close();
        if(areDisplayingVideo) display.close();
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        MenuBarHandler.goBack(classifyingBtn);
    }

    @FXML
    public void classifyingBtnClicked() {
        if(areClassifying) {
            areClassifying = false;
            classifyingBtn.setText("Start Classifying");
        }
        else {
            areClassifying = true;
            classifyingBtn.setText("Pause Classifying");
        }
    }

    @FXML
    public void startStopVideo() {
        if(areDisplayingVideo) {
            frame = FunctionHandler.stopVideo(frame, video);
            timer = null;
            startStopBtn.setText("Start Video");
        } else {
            areDisplayingVideo = true;
            initVideo();
            timer = new Timer();
            timer.start();
            display = liveFeed.displayVideoFeed(video, frame);
            addClassifyListener();
            startStopBtn.setText("Stop Video");
        }
    }

    public void initVideo() {
        addJFrameListener(frame);
        try {
            video = FunctionHandler.startVideo(liveFeed);
        } catch (VideoCaptureException e) {
            e.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Could not find webcam");
            errorAlert.setContentText("Please connect video device");
            errorAlert.showAndWait();
            areDisplayingVideo = false;
        }
    }

    @FXML
    public void reset() {
        if(areDisplayingVideo) {
            areDisplayingVideo = false;
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            display.close();
            video.close();
            frame = new JFrame("WebCam Feed");
            addJFrameListener(frame);
            timer = null;
            classifyingBtn.setText("Start Classifying");
            startStopBtn.setText("Start Video");
        }
        areClassifying = false;
        imageView.setImage(null);
        setResult("Result");
        setProbability("Confidence");

    }

    public void addJFrameListener(JFrame frame) {
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if(areDisplayingVideo) {
                    areDisplayingVideo = false;
                    display.close();
                    video.close();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            startStopBtn.setText("Start Video");
                        }
                    });
                }
            }
        });
    }

    public void addClassifyListener() {
        display.addVideoListener(
                new VideoDisplayListener<MBFImage>() {
                    public void beforeUpdate(MBFImage frame) {
                        if(areClassifying && timer.duration() > realTimeDelay) {
                            File outF = new File("./Classify.jpeg");
                            try {
                                MBFImage openImage = frame.extractCenter(320, 320);
                                ImageUtilities.write(openImage, outF);
                                String reply = Classifier.classifyImage(outF);
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        setImageView(openImage);
                                        setResult(FunctionHandler.findTag(reply));
                                        setProbability(FunctionHandler.findProbability(reply));
                                    }
                                });
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            outF.delete();
                            timer.stop();
                            timer = new Timer();
                            timer.start();
                        }
                    }

                    public void afterUpdate(VideoDisplay<MBFImage> display) {

                    }
                });
    }

    private void setResult(String result) {
        resultLabel.setText(result);
    }

    private void setProbability(String probability) {
        probabilityLabel.setText(probability);
    }

    private void setImageView(MBFImage frame) {
        BufferedImage bufferedImage = ImageUtilities.createBufferedImage(frame);
        imageToClassify = SwingFXUtils.toFXImage(bufferedImage, null);
        imageView.setImage(imageToClassify);
    }

}
