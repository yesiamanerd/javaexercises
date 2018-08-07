import java.util.Scanner;

/**
 * Created by geoffrey on 1/28/18.
 */
public class AccountTest0302 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        Account0301 myAccount = new Account0301();

        System.out.printf("Initial name is: %s%n%n", myAccount.getName());

        System.out.println("Please enter the name:");
        String theName = input.nextLine();
        myAccount.setName(theName);
        System.out.println();

        System.out.printf("The name that was entered is: %s%n%n", myAccount.getName());
    }

}
