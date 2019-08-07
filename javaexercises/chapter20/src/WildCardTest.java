import java.util.ArrayList;

public class WildCardTest {
    public static void main(String[] args) {
        Integer[] integers = { 1, 2, 3, 4, 5};
        ArrayList<Integer> integerList = new ArrayList<>();

        for(Integer integer: integers)
            integerList.add(integer);

        System.out.printf("List of the elements in integerList: %s%n", integerList);
        System.out.printf("Sum of the elements in integerList: %s%n", sum(integerList));


        Double[] doubles = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        ArrayList<Double> doubleList = new ArrayList<>();

        for(Double value : doubles){
            doubleList.add(value);
        }

        System.out.printf("List of the elements in doubleList: %s%n", doubleList);
        System.out.printf("Sum of the elements in doubleList: %s%n", sum(doubleList));

        Number[] numbers = { 1, 2.4, 3, 5.6 };
        ArrayList<Number> numberList = new ArrayList<>();

        for(Number value: numbers){
            numberList.add(value);
        }

        System.out.printf("List of the elements in numberList: %s%n", numberList);
        System.out.printf("Sum of the elements in numberList: %s%n", sum(numberList));
    }

    public static double sum(ArrayList<? extends Number> elements){
        double total = 0.0;

        for(Number value: elements) {
            total += value.doubleValue();
        }

        return total;
    }
}
