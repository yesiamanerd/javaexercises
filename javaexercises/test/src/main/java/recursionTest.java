/**
 * Created by geoffrey on 6/12/18.
 */
public class recursionTest {
    private static char[][] letters = {
            {' ',' ',' '},
            {' ',' ',' '},
            {'A', 'B', 'C'},
            {'D', 'E', 'F'},
            {'G', 'H', 'I'},
            {'J', 'K', 'L'},
            {'M', 'N', 'O'},
            {'P', 'Q', 'R', 'S'},
            {'T', 'U', 'V'},
            {'W', 'X', 'Y', 'Z'},
    };
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        String phoneNumber = "3305738";
//        System.out.println(letters[2][0]);

        doSomething(0, phoneNumber, sb);
    }

    private static void doSomething(int num, String phoneNumber, StringBuilder sb){
        if(num < 7 ){
//            System.out.printf("%s%n", phoneNumber.substring(0, 7- num));
            String newPhoneNumber = phoneNumber.substring(0, 6- num);
            int value = Character.digit(phoneNumber.charAt(6- num), 10);
//            System.out.printf("%d", value);
//            System.out.printf("%s", letters[value][0]);
            sb.append(letters[value][0]);
            for(char c : letters[value]){
                System.out.printf("%s%c%n", newPhoneNumber, c);
                doSomething(num + 1, newPhoneNumber, sb);
            }



        }
        if(num == 0) {
            System.out.println(sb);
        }
    }
}
