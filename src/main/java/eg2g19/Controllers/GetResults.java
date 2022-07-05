package eg2g19.Controllers;

import eg2g19.Classifier;
import eg2g19.FunctionHandler;
import org.openimaj.time.Timer;

import java.io.File;
import java.util.ArrayList;

public class GetResults {

    private static Double[] confidences;
    private static Character[] results;

    private static File[] signPhotos;

    public static void main (String[] args) {
        File dir = new File("C:\\Users\\Ed\\OneDrive - University of Southampton\\3rd Yeard\\Project\\SIGNDATA\\TestImages");
        signPhotos = dir.listFiles();
        try {
            getResponses();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(char r : results) {
            System.out.print(r);
        }
        System.out.println();
        for(double d : confidences) System.out.print(d + ", ");
    }

    // Method  to get responses from classifier based on 130 sample images
    // Sets result and confidence arrays
    public static void getResponses() throws InterruptedException {
        ArrayList<Character> rs = new ArrayList<>();
        ArrayList<Double> cs = new ArrayList<>();
        if(signPhotos != null) {
            for(File dir : signPhotos) {
                for(File sign : dir.listFiles()) {
                    Timer timer = new Timer();
                    timer.start();
                    while(timer.duration() < 500) { }
                    timer.stop();
                    String reply = Classifier.classifyImage(sign);
                    rs.add(FunctionHandler.findTag(reply).charAt(0));
                    cs.add(Double.parseDouble(FunctionHandler.findProbability(reply)));
                }
            }
            results = rs.toArray(new Character[rs.size()]);
            confidences = cs.toArray(new Double[cs.size()]);
        }
    }
}
