/*
7.12 (Duplicate Elimination) Use a one-dimensional array to solve the following problem:
Write an application that inputs five numbers, each between 10 and 100, inclusive. As each number
is read, display it only if it’s not a duplicate of a number already read. Provide for the “worst case,”
in which all five numbers are different. Use the smallest possible array to solve this problem. Display
the complete set of unique values input after the user enters each new value.
 */

import java.util.Scanner;

public class Ex_0712_DuplicateElimination {
    public static void main(String[] args){
        System.out.println("Please input 5 unique integers between 10 and 100:");
        int control = 5;
        int number, tester;
        int[] collection = new int[5];
        Scanner input = new Scanner(System.in);

        for(int i = 0; i < control; ){
            System.out.print("Enter a unique integer: ");
            number = input.nextInt();
            tester = isDuplicateFound(collection, number);
            if(tester >= 0) {
                System.out.printf("%d is not a unique number. Please try again.%n", number);
            } else {
                collection[i] = number;
                i++;
                displayValues(collection);
            }
        }

        System.out.println("Results:");
        displayValues(collection);
    }

    private static void displayValues(int[] collection) {
        for(int num : collection)
            System.out.printf("%d ", num);
        System.out.println();
    }

    private static int isDuplicateFound(int[] collection, int number) {
        for(int num : collection)
            if(num == number)
                return 1;
        return -1;
    }
}
