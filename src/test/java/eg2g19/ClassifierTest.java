package eg2g19;

import static java.util.stream.Collectors.summingDouble;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openimaj.time.Timer;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

/**
 * Unit test for simple App.
 */
public class ClassifierTest {
    /**
     * Rigourous Test :-)
     */

    private File[] signPhotos;
    private Double[] confidences;
    private char[] results;
    private char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private double truePosMult = 1;
    private double trueNegMult = 0.04;
    private double falsePosMult = 0.20;
    private double falseNegMult = 0.5;


    @Before
    public void loadData() {
//        File dir = new File("C:\\Users\\Ed\\OneDrive - University of Southampton\\3rd Yeard\\Project\\SIGNDATA\\TestImages");
//        signPhotos = dir.listFiles();
//        try {
//            getResponses();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        setIteration5();

    }

    @Test
    public void testLetterA() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i], 'A');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }












    @Test
    public void testLetterB() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+5], 'B');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterC() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+10], 'C');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterD() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+15], 'D');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterE() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+20], 'E');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterF() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+25], 'F');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterG() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+30], 'G');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterH() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+35], 'H');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterI() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+40], 'I');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterJ() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+45], 'J');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterK() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+50], 'K');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterL() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+55], 'L');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterM() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+60], 'M');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterN() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+65], 'N');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterO() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+70], 'O');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterP() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+75], 'P');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterQ() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+80], 'Q');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterR() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+85], 'R');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterS() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+90], 'S');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterT() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+95], 'T');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterU() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+100], 'U');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterV() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+105], 'V');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterW() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+110], 'W');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterX() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+115], 'X');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterY() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+120], 'Y');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }

    @Test
    public void testLetterZ() {
        boolean[] resultsCorrect = new boolean[5];
        for(int i = 0; i < 5; i++) {
            resultsCorrect[i] = testResult(results[i+125], 'Z');
        }
        int correct = 0;
        for(boolean b : resultsCorrect) {
            if(b == true) correct++;
        }
        System.out.println("Correct = " + correct + "/5");
        assertTrue((correct >= 4));
    }




    public boolean testResult(char actual, char expected) {
        if(actual == expected) return true;
        else return false;
    }

//    iteration 1 output
//    NJNAABBBBBCCKXKDQQDQNNONNFFFFFGGGGGHHHHHOVOONNNNNNKQXKKHHLLLMMMMNNNHMNOOOONQQQQQQQQQQRNMNZFFXGKNNNTUUETUNVVLMMWZZWWXXXXXYYNYYZMZZZ
//    0.42730656, 0.36938286, 0.73662376, 0.21284138, 0.8059333, 0.78401816, 0.9109767, 0.98700714, 0.7683048, 0.93467695, 0.5254324, 0.23105508, 0.20559458, 0.20745432, 0.28795773, 0.5439746, 0.26962578, 0.42712387, 0.47828236, 0.47022173, 0.81125885, 0.4484748, 0.32954282, 0.33127788, 0.61447245, 0.57477593, 0.56180537, 0.8491949, 0.48324597, 0.86146015, 0.9880201, 0.99017465, 0.9952179, 0.99674976, 0.30070174, 0.55057436, 0.8369604, 0.202188, 0.7614455, 0.8967787, 0.58421594, 0.6369251, 0.8185531, 0.49364448, 0.5576697, 0.74219924, 0.76870275, 0.9379446, 0.91584396, 0.892685, 0.75553286, 0.5572801, 0.38629717, 0.70321625, 0.5310719, 0.4876669, 0.37495777, 0.5839831, 0.63675857, 0.74437284, 0.69991946, 0.7695464, 0.8879848, 0.62430924, 0.4507086, 0.44754356, 0.6531948, 0.42245203, 0.7996362, 0.72646224, 0.8259661, 0.9526307, 0.8473742, 0.9850213, 0.28295916, 0.4613461, 0.744518, 0.89375687, 0.58953875, 0.47533858, 0.6708721, 0.5777307, 0.7254688, 0.64393866, 0.98983675, 0.8493928, 0.4699009, 0.7181907, 0.692873, 0.45470664, 0.46233335, 0.40434095, 0.48474935, 0.53699833, 0.4849105, 0.53807014, 0.64584225, 0.64173377, 0.66718143, 0.39227673, 0.23909345, 0.36319405, 0.41508004, 0.5754582, 0.4737569, 0.37098068, 0.57524616, 0.43644968, 0.4656291, 0.38908902, 0.380337, 0.7297787, 0.6789091, 0.8257221, 0.7174034, 0.8291209, 0.908479, 0.88878226, 0.7884873, 0.95862836, 0.9611667, 0.92451245, 0.32593507, 0.7253863, 0.33688903, 0.9861128, 0.62779737, 0.9977769, 0.97409564, 0.98197615,

    //iteration 2 output
//    AJNJABBBBBCCCCCDDDDDOOOOOFFFFFGGGGGHHGHSOOOOOJMNJMKKKKKLLLLLMMMMMMMMMMOOOOOPPPPPPDPPQRMMNYFSSGKTJTTTEUUUULHLLLWWWWWXXXXXYYYYYZMZZZ
//    0.4668988,0.51794547,0.36834565,0.52194417,0.98432434,0.84655017,0.9534779,0.99895406,0.9579364,0.95834124,0.99367356,0.94519174,0.9696493,0.84718275,0.9501303,0.9548708,0.58445823,0.9853125,0.82495517,0.9274087,0.87271446,0.7306644,0.9852218,0.6293992,0.9567212,0.8936067,0.9333045,0.9797355,0.8483604,0.947202,0.99990153,0.9999374,0.9999485,0.9999566,0.9269118,0.8878134,0.9314739,0.6925516,0.93388593,0.34621093,0.9984534,0.96294236,0.99928266,0.99233574,0.99038965,0.33326235,0.7948409,0.6383973,0.47212487,0.52448666,0.9765732,0.38612956,0.9353038,0.9596146,0.85999066,0.67640835,0.41935524,0.9142826,0.91333747,0.95615286,0.91029364,0.95903575,0.9909285,0.9699462,0.47930267,0.8552395,0.6610615,0.78721637,0.8252323,0.89737046,0.99746823,0.99026614,0.991646,0.99975663,0.9400641,0.9928986,0.9888572,0.95347065,0.98273426,0.92483413,0.3921932,0.38773003,0.77076846,0.48353204,0.7817782,0.6823581,0.43914357,0.87518525,0.47502795,0.5565385,0.65647745,0.4516478,0.7683522,0.35325116,0.4649207,0.5537795,0.43771315,0.48047003,0.7211521,0.3587603,0.60810465,0.41720793,0.5676471,0.6614172,0.3786646,0.7779432,0.39146033,0.7832922,0.94731873,0.9441373,0.7566795,0.39981255,0.6172145,0.9798226,0.9835488,0.9530158,0.99923956,0.97653747,0.9261614,0.9943663,0.99890625,0.9992834,0.5680909,0.9825701,0.9825768,0.9901732,0.8982248,0.9994093,0.9241253,0.98065627

//    iteration 3 output
//    AANEABBBBBCCCCCDDDDDOOOEOFFFFFGGGGGHHSHHOOOOONMNNNKKKKKLLLLLMMMMNMNMMMOOOOOPPPPPPPPQQRMMNNFSSSKTTTTTEUUUELLLLLWWWWWXXXXXYYYYYZMZZZ
//    0.6945601, 0.6363694, 0.7745794, 0.37041682, 0.99883777, 0.84676415, 0.98191476, 0.99965966, 0.9816705, 0.9457152, 0.998197, 0.9522829, 0.9896339, 0.9486833, 0.9320661, 0.9548866, 0.4664359, 0.9933878, 0.8819169, 0.912319, 0.436994, 0.48637202, 0.962806, 0.54373246, 0.81105447, 0.90693814, 0.9501279, 0.97891116, 0.8686744, 0.9632688, 0.9999205, 0.99989045, 0.99993694, 0.9999666, 0.9600319, 0.8439453, 0.9270411, 0.58534205, 0.91110724, 0.38941687, 0.9906523, 0.84699655, 0.9969919, 0.99583495, 0.9754615, 0.5944116, 0.5973278, 0.8630365, 0.78564453, 0.622412, 0.9869016, 0.48821184, 0.96955276, 0.9720428, 0.9125151, 0.82421136, 0.70507115, 0.9257497, 0.96611196, 0.9798558, 0.89505035, 0.88511056, 0.99509454, 0.99344844, 0.54769427, 0.518508, 0.5984157, 0.73748416, 0.8212685, 0.5348265, 0.9931155, 0.98162925, 0.9666194, 0.9982608, 0.8811994, 0.9970726, 0.99647504, 0.988679, 0.9957302, 0.98528916, 0.4965354, 0.35155928, 0.63162047, 0.7043163, 0.96582216, 0.61296314, 0.42223674, 0.7571706, 0.76694673, 0.58432466, 0.7176966, 0.61067265, 0.8368688, 0.38919103, 0.43842608, 0.8662481, 0.64895654, 0.8346911, 0.89919275, 0.6797906, 0.58928585, 0.6171879, 0.46361145, 0.7008068, 0.39322838, 0.83504283, 0.38146564, 0.81770927, 0.9640641, 0.97223186, 0.75838375, 0.5647975, 0.7294558, 0.9883288, 0.9902298, 0.97198325, 0.999587, 0.9897376, 0.95728904, 0.9981173, 0.9980432, 0.998483, 0.46335563, 0.99150205, 0.9503015, 0.993233, 0.5388292, 0.99978656, 0.94168794, 0.9864515

//    iteration 4 output
//    AJEJABBBBBCCCCCDDDDDOIOOOFFFFFGGGGGHHSHHOOOOOJNNJNKKKKKLLLLLMMMMMMMMMMOOOOOPPPPPPPQQQRMMRNSSSSSTTTTTUUUUUVVLLLWWWWWXXXXXYYYYYZMZZZ
//    0.60359746, 0.5253626, 0.37204358, 0.53772265, 0.99775416, 0.829895, 0.9799487, 0.9997161, 0.97675747, 0.94920516, 0.99820375, 0.96964014, 0.9886254, 0.9608388, 0.8969762, 0.96643317, 0.5113593, 0.99465734, 0.7214495, 0.9189731, 0.46954697, 0.4092114, 0.96246964, 0.44522026, 0.7684966, 0.8588633, 0.87703574, 0.95253694, 0.6926051, 0.91913253, 0.9998354, 0.99977106, 0.9999305, 0.9999813, 0.9663275, 0.8863662, 0.89317715, 0.43749207, 0.9201534, 0.30296975, 0.9662149, 0.7201178, 0.9934689, 0.9913701, 0.9277416, 0.58774275, 0.50562066, 0.6008792, 0.7312436, 0.5189193, 0.97671163, 0.38358685, 0.93222684, 0.9729868, 0.7614258, 0.8606014, 0.6987715, 0.85979694, 0.9652172, 0.9938858, 0.9546927, 0.923047, 0.9868057, 0.98927224, 0.8663382, 0.90055466, 0.83346117, 0.8150293, 0.69623137, 0.89484507, 0.99238354, 0.968288, 0.9762296, 0.99871576, 0.8773575, 0.99730265, 0.9980749, 0.9919441, 0.99564666, 0.98944163, 0.6754727, 0.50910836, 0.64033884, 0.78803337, 0.97777766, 0.925528, 0.5846634, 0.74018997, 0.7032492, 0.56917787, 0.57383007, 0.87752694, 0.9334936, 0.8411207, 0.44242215, 0.94634956, 0.9704396, 0.9934551, 0.9772692, 0.890883, 0.5144291, 0.8039832, 0.51434225, 0.9220461, 0.681342, 0.64147574, 0.43393695, 0.8036504, 0.9638661, 0.9219515, 0.828464, 0.7109128, 0.8697162, 0.9942934, 0.98906064, 0.97805804, 0.9994772, 0.98813313, 0.9614824, 0.9977344, 0.98269373, 0.9944101, 0.4059074, 0.9450711, 0.9559299, 0.9954496, 0.6051297, 0.9998956, 0.9646793, 0.9959345

    private void setIteration1() {
        results = "NJNAABBBBBCCKXKDQQDQNNONNFFFFFGGGGGHHHHHOVOONNNNNNKQXKKHHLLLMMMMNNNHMNOOOONQQQQQQQQQQRNMNZFFXGKNNNTUUETUNVVLMMWZZWWXXXXXYYNYYZMZZZ".toCharArray();
        confidences = new Double[]{ 0.6945601, 0.6363694, 0.7745794, 0.37041682, 0.99883777, 0.84676415, 0.98191476, 0.99965966, 0.9816705, 0.9457152, 0.998197, 0.9522829, 0.9896339, 0.9486833, 0.9320661, 0.9548866, 0.4664359, 0.9933878, 0.8819169, 0.912319, 0.436994, 0.48637202, 0.962806, 0.54373246, 0.81105447, 0.90693814, 0.9501279, 0.97891116, 0.8686744, 0.9632688, 0.9999205, 0.99989045, 0.99993694, 0.9999666, 0.9600319, 0.8439453, 0.9270411, 0.58534205, 0.91110724, 0.38941687, 0.9906523, 0.84699655, 0.9969919, 0.99583495, 0.9754615, 0.5944116, 0.5973278, 0.8630365, 0.78564453, 0.622412, 0.9869016, 0.48821184, 0.96955276, 0.9720428, 0.9125151, 0.82421136, 0.70507115, 0.9257497, 0.96611196, 0.9798558, 0.89505035, 0.88511056, 0.99509454, 0.99344844, 0.54769427, 0.518508, 0.5984157, 0.73748416, 0.8212685, 0.5348265, 0.9931155, 0.98162925, 0.9666194, 0.9982608, 0.8811994, 0.9970726, 0.99647504, 0.988679, 0.9957302, 0.98528916, 0.4965354, 0.35155928, 0.63162047, 0.7043163, 0.96582216, 0.61296314, 0.42223674, 0.7571706, 0.76694673, 0.58432466, 0.7176966, 0.61067265, 0.8368688, 0.38919103, 0.43842608, 0.8662481, 0.64895654, 0.8346911, 0.89919275, 0.6797906, 0.58928585, 0.6171879, 0.46361145, 0.7008068, 0.39322838, 0.83504283, 0.38146564, 0.81770927, 0.9640641, 0.97223186, 0.75838375, 0.5647975, 0.7294558, 0.9883288, 0.9902298, 0.97198325, 0.999587, 0.9897376, 0.95728904, 0.9981173, 0.9980432, 0.998483, 0.46335563, 0.99150205, 0.9503015, 0.993233, 0.5388292, 0.99978656, 0.94168794, 0.9864515 };
    }

    private void setIteration2() {
        results = "AJNJABBBBBCCCCCDDDDDOOOOOFFFFFGGGGGHHGHSOOOOOJMNJMKKKKKLLLLLMMMMMMMMMMOOOOOPPPPPPDPPQRMMNYFSSGKTJTTTEUUUULHLLLWWWWWXXXXXYYYYYZMZZZ".toCharArray();
        confidences = new Double[]{    0.60359746, 0.5253626, 0.37204358, 0.53772265, 0.99775416, 0.829895, 0.9799487, 0.9997161, 0.97675747, 0.94920516, 0.99820375, 0.96964014, 0.9886254, 0.9608388, 0.8969762, 0.96643317, 0.5113593, 0.99465734, 0.7214495, 0.9189731, 0.46954697, 0.4092114, 0.96246964, 0.44522026, 0.7684966, 0.8588633, 0.87703574, 0.95253694, 0.6926051, 0.91913253, 0.9998354, 0.99977106, 0.9999305, 0.9999813, 0.9663275, 0.8863662, 0.89317715, 0.43749207, 0.9201534, 0.30296975, 0.9662149, 0.7201178, 0.9934689, 0.9913701, 0.9277416, 0.58774275, 0.50562066, 0.6008792, 0.7312436, 0.5189193, 0.97671163, 0.38358685, 0.93222684, 0.9729868, 0.7614258, 0.8606014, 0.6987715, 0.85979694, 0.9652172, 0.9938858, 0.9546927, 0.923047, 0.9868057, 0.98927224, 0.8663382, 0.90055466, 0.83346117, 0.8150293, 0.69623137, 0.89484507, 0.99238354, 0.968288, 0.9762296, 0.99871576, 0.8773575, 0.99730265, 0.9980749, 0.9919441, 0.99564666, 0.98944163, 0.6754727, 0.50910836, 0.64033884, 0.78803337, 0.97777766, 0.925528, 0.5846634, 0.74018997, 0.7032492, 0.56917787, 0.57383007, 0.87752694, 0.9334936, 0.8411207, 0.44242215, 0.94634956, 0.9704396, 0.9934551, 0.9772692, 0.890883, 0.5144291, 0.8039832, 0.51434225, 0.9220461, 0.681342, 0.64147574, 0.43393695, 0.8036504, 0.9638661, 0.9219515, 0.828464, 0.7109128, 0.8697162, 0.9942934, 0.98906064, 0.97805804, 0.9994772, 0.98813313, 0.9614824, 0.9977344, 0.98269373, 0.9944101, 0.4059074, 0.9450711, 0.9559299, 0.9954496, 0.6051297, 0.9998956, 0.9646793, 0.9959345};
    }

    private void setIteration3() {
        results = "AANEABBBBBCCCCCDDDDDOOOEOFFFFFGGGGGHHSHHOOOOONMNNNKKKKKLLLLLMMMMNMNMMMOOOOOPPPPPPPPQQRMMNNFSSSKTTTTTEUUUELLLLLWWWWWXXXXXYYYYYZMZZZ".toCharArray();
        confidences = new Double[] {    0.6945601, 0.6363694, 0.7745794, 0.37041682, 0.99883777, 0.84676415, 0.98191476, 0.99965966, 0.9816705, 0.9457152, 0.998197, 0.9522829, 0.9896339, 0.9486833, 0.9320661, 0.9548866, 0.4664359, 0.9933878, 0.8819169, 0.912319, 0.436994, 0.48637202, 0.962806, 0.54373246, 0.81105447, 0.90693814, 0.9501279, 0.97891116, 0.8686744, 0.9632688, 0.9999205, 0.99989045, 0.99993694, 0.9999666, 0.9600319, 0.8439453, 0.9270411, 0.58534205, 0.91110724, 0.38941687, 0.9906523, 0.84699655, 0.9969919, 0.99583495, 0.9754615, 0.5944116, 0.5973278, 0.8630365, 0.78564453, 0.622412, 0.9869016, 0.48821184, 0.96955276, 0.9720428, 0.9125151, 0.82421136, 0.70507115, 0.9257497, 0.96611196, 0.9798558, 0.89505035, 0.88511056, 0.99509454, 0.99344844, 0.54769427, 0.518508, 0.5984157, 0.73748416, 0.8212685, 0.5348265, 0.9931155, 0.98162925, 0.9666194, 0.9982608, 0.8811994, 0.9970726, 0.99647504, 0.988679, 0.9957302, 0.98528916, 0.4965354, 0.35155928, 0.63162047, 0.7043163, 0.96582216, 0.61296314, 0.42223674, 0.7571706, 0.76694673, 0.58432466, 0.7176966, 0.61067265, 0.8368688, 0.38919103, 0.43842608, 0.8662481, 0.64895654, 0.8346911, 0.89919275, 0.6797906, 0.58928585, 0.6171879, 0.46361145, 0.7008068, 0.39322838, 0.83504283, 0.38146564, 0.81770927, 0.9640641, 0.97223186, 0.75838375, 0.5647975, 0.7294558, 0.9883288, 0.9902298, 0.97198325, 0.999587, 0.9897376, 0.95728904, 0.9981173, 0.9980432, 0.998483, 0.46335563, 0.99150205, 0.9503015, 0.993233, 0.5388292, 0.99978656, 0.94168794, 0.9864515 };
    }


    private void setIteration4() {
        results = "AJEJABBBBBCCCCCDDDDDOIOOOFFFFFGGGGGHHSHHOOOOOJNNJNKKKKKLLLLLMMMMMMMMMMOOOOOPPPPPPPQQQRMMRNSSSSSTTTTTUUUUUVVLLLWWWWWXXXXXYYYYYZMZZZ".toCharArray();
        confidences = new Double[]{
                0.4668988,0.51794547,0.36834565,0.52194417,0.98432434,0.84655017,0.9534779,0.99895406,0.9579364,0.95834124,0.99367356,0.94519174,0.9696493,0.84718275,0.9501303,0.9548708,0.58445823,0.9853125,0.82495517,0.9274087,0.87271446,0.7306644,0.9852218,0.6293992,0.9567212,0.8936067,0.9333045,0.9797355,0.8483604,0.947202,0.99990153,0.9999374,0.9999485,0.9999566,0.9269118,0.8878134,0.9314739,0.6925516,0.93388593,0.34621093,0.9984534,0.96294236,0.99928266,0.99233574,0.99038965,0.33326235,0.7948409,0.6383973,0.47212487,0.52448666,0.9765732,0.38612956,0.9353038,0.9596146,0.85999066,0.67640835,0.41935524,0.9142826,0.91333747,0.95615286,0.91029364,0.95903575,0.9909285,0.9699462,0.47930267,0.8552395,0.6610615,0.78721637,0.8252323,0.89737046,0.99746823,0.99026614,0.991646,0.99975663,0.9400641,0.9928986,0.9888572,0.95347065,0.98273426,0.92483413,0.3921932,0.38773003,0.77076846,0.48353204,0.7817782,0.6823581,0.43914357,0.87518525,0.47502795,0.5565385,0.65647745,0.4516478,0.7683522,0.35325116,0.4649207,0.5537795,0.43771315,0.48047003,0.7211521,0.3587603,0.60810465,0.41720793,0.5676471,0.6614172,0.3786646,0.7779432,0.39146033,0.7832922,0.94731873,0.9441373,0.7566795,0.39981255,0.6172145,0.9798226,0.9835488,0.9530158,0.99923956,0.97653747,0.9261614,0.9943663,0.99890625,0.9992834,0.5680909,0.9825701,0.9825768,0.9901732,0.8982248,0.9994093,0.9241253,0.98065627 };
    }

    private void setIteration5() {
        results = "AAEAABBBBBCCCCCDDDDDEIEEEFFFFFGGGGGHHSHHIIIIOTMNJMKQKKKLLLLLMMMMMMNMMMOOOOOPPPPPQQQQQRRRRMSSSSSTTTTTUUUUULVLLLWWWWWXXXXXYYYYYZZZZZ".toCharArray();
        confidences = new Double[]{
                0.50756824, 0.83039147, 0.43851668, 0.8837918, 0.99857795, 0.8700527, 0.9609828, 0.9998878, 0.95904285, 0.8608343, 0.9997608, 0.97145545, 0.99709177, 0.9852887, 0.95826524, 0.99172544, 0.9013565, 0.99847, 0.96162206, 0.9783052, 0.4063559, 0.46206805, 0.91812843, 0.49506184, 0.5488969, 0.9127527, 0.6489267, 0.72880214, 0.7926902, 0.95415336, 0.9998915, 0.999889, 0.9999244, 0.9999784, 0.9743766, 0.8721333, 0.93447787, 0.52162385, 0.9144601, 0.43198678, 0.9830755, 0.72789085, 0.98990774, 0.98913467, 0.89613456, 0.61169004, 0.8064811, 0.46075, 0.5444825, 0.5278081, 0.97526836, 0.45989445, 0.60683274, 0.93192697, 0.8016676, 0.9213822, 0.8809859, 0.83025765, 0.9618844, 0.9991198, 0.99749714, 0.99852556, 0.9993931, 0.9992299, 0.98745966, 0.9798995, 0.99251986, 0.95612866, 0.9596721, 0.99149996, 0.99525356, 0.9827642, 0.87573504, 0.99830097, 0.7875488, 0.99566615, 0.99363506, 0.98404884, 0.99634796, 0.97871107, 0.7344552, 0.40967917, 0.8092241, 0.91857, 0.98892564, 0.9528089, 0.8616792, 0.9534391, 0.88599813, 0.35536358, 0.951945, 0.9685857, 0.99097437, 0.9776084, 0.9731513, 0.9104609, 0.95631206, 0.9874845, 0.9763204, 0.89852935, 0.95333755, 0.86718804, 0.54875594, 0.9829003, 0.8857981, 0.50529855, 0.6683755, 0.8266143, 0.8816541, 0.83332354, 0.96533805, 0.8983007, 0.96215487, 0.9988217, 0.99856216, 0.9979984, 0.9999198, 0.9652716, 0.95893717, 0.99978775, 0.99848807, 0.9988065, 0.8667517, 0.9917727, 0.9924523, 0.9982406, 0.5551372, 0.9999411, 0.9844508, 0.9921948 };
    }

    // Method  to get responses from classifier based on 130 sample images
    // Sets result and confidence arrays
    public void getResponses() throws InterruptedException {
        ArrayList<Character> rs = new ArrayList<>();
        ArrayList<Double> cs = new ArrayList<>();
        if(signPhotos != null) {
            for(File dir : signPhotos) {
                for(File sign : dir.listFiles()) {
                    Timer timer = new Timer();
                    timer.start();
                    while(timer.duration() < 500) { }
                    String reply = Classifier.classifyImage(sign);
                    rs.add(FunctionHandler.findTag(reply).charAt(0));
                    cs.add(Double.parseDouble(FunctionHandler.findProbability(reply)));
                }
            }
//            results = rs.toArray(new Character[rs.size()]);
            confidences = cs.toArray(new Double[cs.size()]);
        }
    }
}
