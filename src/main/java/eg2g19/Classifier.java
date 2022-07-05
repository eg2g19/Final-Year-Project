package eg2g19;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.DirectoryChooser;
import org.openimaj.image.DisplayUtilities;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.image.colour.RGBColour;
import org.openimaj.math.geometry.shape.Rectangle;
import org.openimaj.time.Timer;
import org.openimaj.video.Video;
import org.openimaj.video.VideoDisplay;
import org.openimaj.video.VideoDisplayListener;
import org.openimaj.video.capture.VideoCapture;
import org.openimaj.video.capture.VideoCaptureException;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalDateTime;

public class Classifier {

    //returns result or null
    public static String classifyImage(File imageFile) {
        //NOTE: requests  iteration 1!!!!
        String url1 = "https://eg2g19visionproject-prediction.cognitiveservices.azure.com/customvision/v3.0/Prediction/" +
                "6a6ac36c-a414-4bf6-9ca8-75a5adde0318/classify/iterations/Iteration1/image";
        //Iteration 2
        String url2 = "https://eg2g19visionproject-prediction.cognitiveservices.azure.com/customvision/v3.0/Prediction/" +
                "6a6ac36c-a414-4bf6-9ca8-75a5adde0318/classify/iterations/Iteration2/image";
        //Iteration 3
        String url3 = "https://eg2g19visionproject-prediction.cognitiveservices.azure.com/customvision/v3.0/Prediction/" +
                "6a6ac36c-a414-4bf6-9ca8-75a5adde0318/classify/iterations/Iteration3/image";
        //Iteration 4
        String url4 = "https://eg2g19visionproject-prediction.cognitiveservices.azure.com/customvision/v3.0/Prediction/" +
                "6a6ac36c-a414-4bf6-9ca8-75a5adde0318/classify/iterations/Iteration4/image";
        String url5 = "https://eg2g19visionproject-prediction.cognitiveservices.azure.com/customvision/v3.0/Prediction/" +
                "6a6ac36c-a414-4bf6-9ca8-75a5adde0318/classify/iterations/Iteration5/image";

        String contentType = "application/octet-stream";
        String predictionKey = "2d028e08fde340b3b30ae7fed06ba54b";
        String appName = "Sample App";

        String result;

        if(!(imageFile == null)) {
            RequestHandler rq = new RequestHandler(url5, contentType, predictionKey, appName);

            result = rq.makeRequest(imageFile);
//            setResultLabel(result);
            return result;
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("No File Selected");
            errorAlert.setContentText("Please select a file before requesting a classifcation");
            errorAlert.showAndWait();
            return null;
        }


    }

    public static void saveFile(Node node, org.openimaj.image.Image image, String tag) throws IOException {
        LocalDateTime ldt = LocalDateTime.now();
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(node.getScene().getWindow());
        File fileLocation = new File(selectedDirectory.toPath() + File.separator + ldt.getDayOfYear() + ldt.getHour() + ldt.getMinute() + tag + ".png");
        ImageUtilities.write(image, fileLocation);
    }

    public static void saveFile(Node node, javafx.scene.image.Image image, String tag) throws IOException{
        LocalDateTime ldt = LocalDateTime.now();
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(node.getScene().getWindow());
        File fileLocation = new File(selectedDirectory.toPath() + File.separator + ldt.getHour() + tag + ".png");
        ImageIO.write(bImage, "png", fileLocation);
    }
}
