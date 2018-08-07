/**
 * Created by geoffrey on 2/11/18.
 */
public class BreakTest {
    public static void main(String[] args){
        int count;

        for(count = 1; count <=10; count++){
            if (count == 5)
                break;

            System.out.printf("%d ", count);
        }

        System.out.printf("%nBroke out of loop at %d%n", count);
    }

}
