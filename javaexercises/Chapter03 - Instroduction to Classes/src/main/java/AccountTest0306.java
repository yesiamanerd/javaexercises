import java.util.Scanner;

/**
 * Created by geoffrey on 1/28/18.
 */
public class AccountTest0306 {
    public static void main(String[] args){
        Account0305 Account1 = new Account0305("Jane Green");
        Account0305 Account2 = new Account0305("John Blue");

        System.out.printf("Account1 is: %s%n%n", Account1.getName());
        System.out.printf("Account2 is: %s%n%n", Account2.getName());
    }
}
