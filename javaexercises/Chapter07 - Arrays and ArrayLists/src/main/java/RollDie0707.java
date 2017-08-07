import java.security.SecureRandom;

public class RollDie0707 {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();

        SecureRandom randomNumbers = new SecureRandom();
        int[] frequency = new int[7];

        // roll die 6,000,000 times;  use die value as frequency index
        for(int i = 1; i <= 6000000; i++)
            ++frequency[1 + randomNumbers.nextInt(6)];

        System.out.printf("%s%10s%n", "Face", "Frequency");

        for(int face = 1; face < frequency.length; face++)
            System.out.printf("%4d%10d%n", face, frequency[face]);

        System.out.printf(
                "%nRunning time in milliseconds: %d",
                (System.currentTimeMillis() - startTime));
    }
}
