/*
7.11
Write statements that perform the following one-dimensional-array operations:
a) Set the 10 elements of integer array "counts" to zero.
b) Add one to each of the 15 elements of integer array "bonus" .
c) Display the five values of integer array "bestScores" in column format.
 */


import java.util.Arrays;

public class Ex_0711_OneDimensionOperations {
    public static void main(String[] args){
        int[] counts = new int[10];
        Arrays.fill(counts, 0);
        for(int count : counts)
            System.out.printf("%d ", count);
        System.out.println();

        int[] bonus = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        for(int i = 0; i < bonus.length; i++)
            bonus[i] += 1;
        for(int value : bonus)
            System.out.printf("%d ", value);
        System.out.println();

        int[] bestScores = { 2, 4, 6, 8, 10 };
        for(int score : bestScores)
            System.out.printf("%d\t", score);
        System.out.println();
    }
}
