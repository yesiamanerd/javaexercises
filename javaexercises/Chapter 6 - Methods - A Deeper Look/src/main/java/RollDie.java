import java.security.SecureRandom;

/**
 * Created by geoffrey on 2/11/18.
 */
public class RollDie {
    public static void main(String[] args){
        SecureRandom secureRandom = new SecureRandom();
        int frequency[] = new int[6];

        for(int roll = 1; roll <= 6000000; roll++){
            int face = secureRandom.nextInt(6);
            ++frequency[face];
        }

        System.out.println("FACE\tFREQUENCY");

        for(int i = 0; i < 6; i++){
            System.out.printf("%d\t\t%d%n", (i + 1), frequency[i]);
        }

    }
}
