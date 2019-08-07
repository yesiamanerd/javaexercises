

import java.text.DecimalFormat;
import java.util.Scanner;

public class NormalDist2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int mean, stdDev;
        double higherScore;
        double score, lowScore1, lowScore2;

        mean = 250 * 49;
        stdDev = 15;


//        String[] input = scan.nextLine().split(" ");
//        mean = Integer.parseInt(input[0]);
//        stdDev = Integer.parseInt(input[1]);
//
//        higherScore = Double.parseDouble(scan.nextLine());
//        score = Double.parseDouble(scan.nextLine());
        double temp = (9800 - mean) / (stdDev/Math.sqrt(49));
        lowScore1 = getAreaUnderNormalCurve(((0.0 - mean)/stdDev), (9800-mean)/stdDev);
//        lowScore2 = 0.01 + getAreaUnderNormalCurve(((0.0 - mean)/stdDev), (score-mean)/stdDev) * 100;

        DecimalFormat df = new DecimalFormat("###.####");

//        System.out.println(df.format(lowScore2));
        System.out.println(df.format(lowScore1));
//        System.out.println(df.format(lowScore2));



    }

    static double getNormalProbabilityAtZ(double z) {
        return Math.exp(-Math.pow(z, 2) / 2) / Math.sqrt(2 * Math.PI);
    }

    static double getAreaUnderNormalCurve(double z1, double z2) {
        double area = 0.0;
        final int rectangles = 100000;
        final double width = (z2 - z1) / rectangles;
        for(int i = 0; i < rectangles; i++)
            area += width * getNormalProbabilityAtZ(width * i + z1);
        return area;
    }
}
