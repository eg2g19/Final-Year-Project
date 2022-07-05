package eg2g19;

import org.openimaj.image.MBFImage;
import org.openimaj.image.colour.RGBColour;
import org.openimaj.math.geometry.shape.Rectangle;
import org.openimaj.video.Video;
import org.openimaj.video.VideoDisplay;
import org.openimaj.video.VideoDisplayListener;
import org.openimaj.video.capture.VideoCapture;
import org.openimaj.video.capture.VideoCaptureException;

import javax.swing.*;

public class LiveFeed {

    public LiveFeed() {

    }

    public Video<MBFImage> getVideoFeed() throws VideoCaptureException {

        Video<MBFImage> video = new VideoCapture(640, 640);
        return video;
    }

    public VideoDisplay<MBFImage> displayVideoFeed(Video video, JFrame frame) {
        VideoDisplay<MBFImage> display = VideoDisplay.createVideoDisplay(video, frame);
        final Rectangle rect = new Rectangle(160, 80, 320, 320);
        display.addVideoListener(
                new VideoDisplayListener<MBFImage>() {
                    int frameNo = 0;
                    public void beforeUpdate(MBFImage frame) {
                        frame.drawShape(rect, RGBColour.RED );
                        frame.flipX();
                    }

                    public void afterUpdate(VideoDisplay<MBFImage> display) {

                    }
                });
        return display;
    }
}
