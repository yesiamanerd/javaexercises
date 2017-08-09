public class GradeBookTest0715 {
    public static void main(String[] args){
        int[] gradesArray = { 87, 68, 94, 100, 83, 78, 85, 91, 76, 87 };

        GradeBook0714 gradeBook = new GradeBook0714(
                "CS101 Introduction to Java Programming", gradesArray
        );

        System.out.printf("Welcome to gradebook for %s%n%n", gradeBook.getCourseName());

        gradeBook.processGrades();
    }
}
