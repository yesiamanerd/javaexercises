/*
7.15 (Command-Line Arguments) Rewrite Fig. 7.2 so that the size of the array is specified by the
first command-line argument. If no command-line argument is supplied, use 10 as the default size
of the array.
 */

public class Ex_0715_CommandLineArguments {
    public static void main(String[] args){
        int size;
        if(args.length > 0) {
            size = Integer.parseInt(args[0]);
            if (size <= 0)
                size = 10;
        }
        else
            size = 10;


        int[] array = new int[size];


        System.out.printf("%s%8s%n", "Index", "Value");

        for(int counter = 0; counter < array.length; counter++)
            System.out.printf("%5d%8d%n", counter, array[counter]);
    }
}
