import java.util.Scanner;

public class NestedLogic1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] inputString = input.nextLine().split(" ");
        int fine;

        int actualDay = Integer.parseInt(inputString[0]);
        int actualMonth = Integer.parseInt(inputString[1]);
        int actualYear = Integer.parseInt(inputString[2]);

        inputString = input.nextLine().split(" ");

        int expectedDay = Integer.parseInt(inputString[0]);
        int expectedMonth = Integer.parseInt(inputString[1]);
        int expectedYear = Integer.parseInt(inputString[2]);


        if(actualYear > expectedYear){
            fine = 10000;
        } else if(actualMonth > expectedMonth && actualYear == expectedYear){
            fine = 500 * (actualMonth - expectedMonth);
        } else if(actualDay > expectedDay && actualMonth == expectedMonth && actualYear == expectedYear){
            fine = 15 * (actualDay - expectedDay);
        } else {
            fine = 0;
        }

        System.out.println(fine);
    }
}
