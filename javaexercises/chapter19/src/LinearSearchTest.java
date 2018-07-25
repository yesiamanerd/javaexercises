import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class LinearSearchTest {
    // perform a linear search on data
    public static int linearSearch(int data[], int searchKey){
        // loop through array sequentially
        for(int index = 0; index < data.length; index++)
            if(data[index] == searchKey)
                return index;  // integer found at this index
        return -1; // integer not found
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SecureRandom generator = new SecureRandom();

        // create data
        int[] data = new int[10];

        for(int i = 0; i < data.length; i++){
            data[i] = 10 + generator.nextInt(90);
        }

        System.out.printf("%s%n%n", Arrays.toString(data));

        // get input from user
        System.out.print("Please enter an integer value (-1 to quit): ");
        int searchInput = input.nextInt();

        // repeatedly input an integer.  -1 to quit
        while(searchInput != -1){
            // perform search
            int position = linearSearch(data, searchInput);

            // not found
            if(position == -1)
                System.out.printf("%d was not found.%n%n", searchInput);
            else
                System.out.printf("%d was found at position %d%n%n", searchInput, position);

            // get input from user
            System.out.print("Please enter an integer value (-1 to quit): ");
            searchInput = input.nextInt();
        }
    }
}
