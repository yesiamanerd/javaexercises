/**
 * Created by geoffrey on 1/30/18.
 */
public class Sum0505 {
    public static void main(String[] args){
        int total = 0;

        for(int counter = 2; counter <= 20; counter += 2){
            total += counter;
        }

        System.out.printf("Sum total is %d%n", total);
    }
}
