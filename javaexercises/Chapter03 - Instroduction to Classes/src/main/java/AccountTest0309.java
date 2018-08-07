import java.util.Scanner;

/**
 * Created by geoffrey on 1/28/18.
 */
public class AccountTest0309 {
    public static void main(String[] args){
        Account0308 Account1 = new Account0308("Jane Green", 50.0);
        Account0308 Account2 = new Account0308("John Blue", -7.53);

        System.out.printf("Account1 is: %s, Balance is $%.2f%n",
                Account1.getName(), Account1.getBalance());
        System.out.printf("Account2 is: %s, Balance is $%.2f%n",
                Account2.getName(), Account2.getBalance());

        Scanner input = new Scanner(System.in);

        System.out.println("Enter deposit amount for Account1");
        double depositAccount = input.nextDouble();
        System.out.printf("%nAdding $%.2f to the Account1 balance%n%n", depositAccount);
        Account1.deposit(depositAccount);

        System.out.printf("%s balance: $%.2f%n", Account1.getName(), Account1.getBalance());
        System.out.printf("%s balance: $%.2f%n", Account2.getName(), Account2.getBalance());

        System.out.println("Enter deposit amount for Account2");
        depositAccount = input.nextDouble();
        System.out.printf("%nAdding $%.2f to the Account2 balance%n%n", depositAccount);
        Account2.deposit(depositAccount);

        System.out.printf("%s balance: $%.2f%n", Account1.getName(), Account1.getBalance());
        System.out.printf("%s balance: $%.2f%n", Account2.getName(), Account2.getBalance());
    }
}
