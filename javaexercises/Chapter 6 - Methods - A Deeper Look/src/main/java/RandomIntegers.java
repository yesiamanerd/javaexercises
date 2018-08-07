import java.security.SecureRandom;

/**
 * Created by geoffrey on 2/11/18.
 */
public class RandomIntegers {
    public static void main(String[] args){
        SecureRandom secureRandom = new SecureRandom();

        for (int i = 1; i <= 20; i++){
            int face = 1 + secureRandom.nextInt(6);

            System.out.printf("%d ", face);

            if(i % 5 == 0)
                System.out.println();
        }
    }
}
