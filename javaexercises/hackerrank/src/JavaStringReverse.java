import java.util.Scanner;

public class JavaStringReverse {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();

        boolean isPalidrome = true;

        for(int x = 0; x < A.length();x++) {

            if (A.charAt(x) != A.charAt(A.length() - x - 1))
                isPalidrome = false;
        }

        System.out.println(isPalidrome? "Yes": "No");


    }
}
