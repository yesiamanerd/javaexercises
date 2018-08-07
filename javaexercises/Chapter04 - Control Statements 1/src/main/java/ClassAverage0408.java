import java.util.Scanner;

/**
 * Created by geoffrey on 1/29/18.
 */
public class ClassAverage0408 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int TOTAL_GRADES = 10;

        int total = 0;
        int gradeCounter = 1;

        while(gradeCounter <= TOTAL_GRADES){
            System.out.print("Enter grade: ");
            int grade = input.nextInt();
            total += grade;
            gradeCounter++;
        }

        int average = total / TOTAL_GRADES;

        System.out.printf("%nTotal of all 10 grades is %d%n", total);
        System.out.printf("Class averages is %d.%n%n", average);
    }
}
