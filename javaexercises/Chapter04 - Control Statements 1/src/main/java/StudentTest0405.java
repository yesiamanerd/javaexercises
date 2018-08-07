/**
 * Created by geoffrey on 1/28/18.
 */
public class StudentTest0405 {
    public static void main(String[] args){
        Student0404 account1 = new Student0404("Jane Green", 93.5);
        Student0404 account2 = new Student0404("John Blue", 72.75);
        System.out.printf("%s's letter grade is: %s%n",
                account1.getName(), account1.getLetterGrade() );
        System.out.printf("%s's letter grade is: %s%n",
                account2.getName(), account2.getLetterGrade() );
    }
}
