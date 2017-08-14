import java.util.Arrays;

public class ArrayManipulations0722 {
    public static void main(String[] args){
        double[] doubleArray = { 8.4, 9.3, 0.2, 7.9, 3.4 };
        Arrays.sort(doubleArray);
        System.out.printf("%ndoubleArray: ");

        for(double value : doubleArray)
            System.out.printf("%.1f ", value);
        System.out.println();

        int[] filledIntArray = new int[10];
        Arrays.fill(filledIntArray, 7);
        displayArray("filledIntArray: ", filledIntArray);

        int[] intArray = {1, 2, 3, 4, 5, 6};
        int[] intArrayCopy = new int[intArray.length];
        System.arraycopy(intArray, 0, intArrayCopy, 0, intArray.length);

        displayArray("intArray", intArray);
        displayArray("intArrayCopy", intArrayCopy);

        boolean b = Arrays.equals(intArray, intArrayCopy);
        System.out.printf("%n%nintArray %s intArrayCopy%n",
                b? "==": "!=");

        b = Arrays.equals(intArray, filledIntArray);
        System.out.printf("%n%nintArray %s filledIntArray%n",
                b? "==": "!=");

        int location = Arrays.binarySearch(intArray, 5);
        if(location >= 0 && location < intArray.length){
            System.out.printf("%nFound 5 at position %d in intArray%n", location);
        } else {
            System.out.printf("%n5 is not found in intArray%n");
        }

        location = Arrays.binarySearch(intArray, 8975);
        if(location >= 0){
            System.out.printf("%nFound 8975 at position %d in intArray%n", location);
        } else {
            System.out.printf("%n8975 is not found in intArray%n");
        }
    }

    private static void displayArray(String description, int[] array) {
        System.out.printf("%n%s: ", description);
        for(int value : array)
            System.out.printf("%d ", value);
        System.out.println();
    }
}
