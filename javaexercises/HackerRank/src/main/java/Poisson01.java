import java.text.DecimalFormat;
import java.util.Scanner;

public class Poisson01 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String lamdaStr = input.nextLine();
        String numberStr = input.nextLine();

        double lambda = Double.parseDouble(lamdaStr);
        int number = Integer.parseInt(numberStr);
        double poisson = (Math.pow(lambda, number) * Math.pow(Math.E, -lambda))/factorial(number);

        DecimalFormat df = new DecimalFormat("#.###");
        System.out.println(df.format(poisson));
    }

    public static int factorial(int n){
        int product = 1;
        for(int i = n; i > 0; i--)
            product *= i;

        return product;
    }
}
