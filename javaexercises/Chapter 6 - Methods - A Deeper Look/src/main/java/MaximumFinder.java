import java.util.Scanner;

/**
 * Created by geoffrey on 2/11/18.
 */
public class MaximumFinder {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 3 floating point numbers separated by spaces:");

        double number1 = input.nextDouble();
        double number2 = input.nextDouble();
        double number3 = input.nextDouble();

        double result = maximum(number1, number2, number3);

        System.out.println("The Max value is " + result);
    }

    private static double maximum(double x, double y, double z) {
        double maximumValue = x;

        if (y > maximumValue)
            maximumValue = y;
        if (z > maximumValue)
            maximumValue = z;

        return maximumValue;
    }
}
