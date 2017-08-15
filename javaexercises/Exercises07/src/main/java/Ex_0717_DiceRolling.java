/*
7.17 (Dice Rolling) Write an application to simulate the rolling of two dice. The application
should use an object of class Random once to roll the first die and again to roll the second die. The
sum of the two values should then be calculated. Each die can show an integer value from 1 to 6, so
the sum of the values will vary from 2 to 12, with 7 being the most frequent sum, and 2 and 12 the
least frequent. Figure 7.28 shows the 36 possible combinations of the two dice. Your application
should roll the dice 36,000,000 times. Use a one-dimensional array to tally the number of times
each possible sum appears. Display the results in tabular format.
 */

import java.security.SecureRandom;

public class Ex_0717_DiceRolling {
    public static void main(String[] args){
        SecureRandom randomNumbers = new SecureRandom();
        int[] frequency = new int[13];

        // roll die 6,000,000 times;  use die value as frequency index
        for(int i = 1; i <= 36000000; i++)
            ++frequency[(1 + randomNumbers.nextInt(6)) + (1 + randomNumbers.nextInt(6))];

        // display the number of occurrences
        System.out.println("Sum of Two Dice");
        System.out.printf("%3s%15s%n", "Sum", "Occurrences");
        for(int i = 2; i < frequency.length; i++)
            System.out.printf("%2d %12d%n", i, frequency[i]);

    }
}
