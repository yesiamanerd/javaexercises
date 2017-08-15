/*
7.14 (Variable-Length Argument List) Write an application that calculates the product of a series
of integers that are passed to method product using a variable-length argument list. Test your meth-
od with several calls, each with a different number of arguments.
 */

public class Ex_0714_VarLengthArgumentList {
    public static void main(String[] args){
        int[] test1 = { 1, 2, 3 };
        int[] test2 = { 3, 4, 5, 6, 7 };

        System.out.printf("The product of test1 values is: %d%n", calulateProduct(test1));
        System.out.printf("The product of test2 values is: %d%n", calulateProduct(test2));
    }

    private static int calulateProduct(int[] values) {
        int product = 1;
        for(int value : values){
            product *= value;
        }

        return product;
    }
}
