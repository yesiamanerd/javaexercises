import java.util.ArrayList;

public class TotalNumbers {
    public static void main(String[] args) {
        Number[] numbers = { 1, 2.4, 3, 4.5};
        ArrayList<Number> numberList = new ArrayList<>();

        for(Number number: numbers){
            numberList.add(number);
        }

        System.out.printf("List of the elements in numberList: %s%n", numberList);
        System.out.printf("Sum of the elements in numberList: %s%n", sum(numberList));
    }

    public static double sum(ArrayList<Number> list){
        double sum = 0.0;

        for(Number number: list)
            sum += number.doubleValue();

        return sum;
    }
}
