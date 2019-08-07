public class GenericMethodTest {

    public static void main(String[] args) {
        // create arrays of Integer, Double and Character
        Integer[] integerArray = {1, 2, 3, 4, 5, 6};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};

        System.out.println("Array integerArray contains: ");
        printArray(integerArray);
        System.out.println("Array doubleArray contains: ");
        printArray(doubleArray);
        System.out.println("Array characterArray contains: ");
        printArray(characterArray);
    }

    private static <T> void printArray(T[] array){
        for(T element: array)
            System.out.printf("%s ", element);
        System.out.println();
    }
}
