/*
7.16 (Using the Enhanced for Statement) Write an application that uses an enhanced for state-
ment to sum the double values passed by the command-line arguments. [Hint: Use the static
method parseDouble of class Double to convert a String to a double value.]
 */

public class Ex_0716_EnhancedForStatement {
    public static void main(String[] args){
        double sum = 0;
        if(args.length > 0) {
            for (String arg : args)
                sum += Double.parseDouble(arg);
            System.out.println("Sum: " + sum);
        } else {
            System.out.println("No values supplied.");
        }

    }
}
