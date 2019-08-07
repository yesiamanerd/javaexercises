import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaStrings003 {
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);;

        List<String> list = new ArrayList<>();

        for(int x = 0; x < s.length() - k + 1; x++){
            if(s.substring(x, x + k).compareTo(smallest) < 0)
                smallest = s.substring(x, x + k);
            if(s.substring(x, x + k).compareTo(largest) > 0)
                largest = s.substring(x, x + k);
        }

        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
