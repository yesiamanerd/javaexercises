import java.util.Scanner;

/**
 * Created by geoffrey on 1/29/18.
 */
public class Analysis0412 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int passes = 0;
        int failures = 0;
        int studentCounter = 1;

        while(studentCounter <= 10){
            System.out.print("Enter result (1 for pass, 2 for fail): ");
            int result = input.nextInt();

            if (result == 1)
                passes++;
            else
                failures++;

            studentCounter++;
        }

        System.out.printf("%nPasses: %d%nFailures: %d%n", passes, failures);

        if (passes > 8)
            System.out.println("Bonus to instructor.");
    }
}
