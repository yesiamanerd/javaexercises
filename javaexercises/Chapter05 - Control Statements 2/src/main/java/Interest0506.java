/**
 * Created by geoffrey on 1/30/18.
 */
public class Interest0506 {
    public static void main(String[] args){
        double amount;
        double principal = 1000.0;
        double rate = 0.05;

        // print headers
        System.out.printf("%s%20s%n", "Year", "Amount on Deposit");

        for(int year = 1; year <= 10; year++){
            amount = principal * Math.pow(1.0 + rate, year);

            System.out.printf("%4d%,20.2f%n", year, amount);
        }
    }
}
