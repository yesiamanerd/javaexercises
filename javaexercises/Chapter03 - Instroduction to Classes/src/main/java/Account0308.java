/**
 * Created by geoffrey on 1/28/18.
 */
public class Account0308 {
    private String name;
    private double balance;

    public Account0308(String name, double balance){
        this.name = name;

        if (balance > 0.0)
                this.balance = balance;
    }

    public void deposit(double depositAmount){
        if(depositAmount > 0.0)
            balance += depositAmount;
    }

    public double getBalance(){
        return balance;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
