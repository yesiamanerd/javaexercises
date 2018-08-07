import java.util.Scanner;

/**
 * Created by geoffrey on 1/30/18.
 */
public class LetterGrades0509 {
    public static void main(String[] args){
        int total = 0;
        int gradeCounter = 0;
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int dCount = 0;
        int fCount = 0;

        Scanner input = new Scanner(System.in);

        System.out.printf("%s%n%s%n  %s%n  %s%n",
                "Enter the integer grades in the range 0-100.",
                "Type the end-of-file indicator to terminate input:",
                "On UNIX/Linux/Mac OS X type <Ctrl> d then press Enter",
                "On Windows type <Ctrl> z then press Enter");

        while(input.hasNext()){
            int grade = input.nextInt();
            total += grade;
            ++gradeCounter;

            switch (grade / 10){
                case 9:
                case 10:
                    ++aCount;
                    break;
                case 8:
                    ++bCount;
                    break;
                case 7:
                    ++cCount;
                    break;
                case 6:
                    ++dCount;
                    break;
                default:
                    ++fCount;
                    break;
            }
        }

        System.out.printf("%nGrade Report: %n");

        if(gradeCounter > 0){
            double average = (double) total / gradeCounter;

            System.out.printf("%nThe total of the %d grades entered is %d.", gradeCounter, total);

            System.out.printf("%nClass average is %.2f%n", average);
            System.out.printf("%n%s%n%s%d%n%s%d%n%s%d%n%s%d%n%s%d%n",
                    "Number of students who received each grade:",
                    "A: ", aCount,  // display number of A grades
                    "B: ", bCount,  // display number of B grades
                    "C: ", cCount,  // display number of C grades
                    "D: ", dCount,  // display number of D grades
                    "F: ", fCount); // display number of F grades
        } else{
            System.out.printf("%nNo grades were entered.%n");
        }
    }
}
