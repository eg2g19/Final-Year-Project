package eg2g19;

import javafx.scene.control.Alert;
import org.openimaj.video.Video;
import org.openimaj.video.VideoDisplay;
import org.openimaj.video.capture.VideoCaptureException;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class FunctionHandler {

    public static JFrame stopVideo(JFrame frame, Video video) {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        video.close();
        return new JFrame("WebCam Feed");
    }

    public static Video startVideo(LiveFeed liveFeed) throws VideoCaptureException {
            return liveFeed.getVideoFeed();
    }

    public static String findTag(String s) {
        String body = s.substring(s.indexOf("[")+1, s.indexOf("]"));
        return body.substring(body.indexOf("*")+1, body.indexOf("*")+2);
    }

    public static String findProbability(String s) {
        String body = s.substring(s.indexOf("[")+1, s.indexOf("]"));
        return body.substring(body.indexOf(":")+1, body.indexOf(","));
    }
}
