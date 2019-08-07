import java.util.Scanner;

public class JavaStrings001 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();

        int aLength = A.length();
        int bLength = B.length();

        System.out.println(aLength + bLength);

        System.out.println(B.compareTo(A) < 0? "Yes": "No");

        System.out.println(Character.toUpperCase(A.charAt(0)) + A.substring(1, aLength) + " " +
                Character.toUpperCase(B.charAt(0)) + B.substring(1, bLength));

    }
}
