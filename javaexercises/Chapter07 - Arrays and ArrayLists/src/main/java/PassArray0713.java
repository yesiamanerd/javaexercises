public class PassArray0713 {
    public static void main(String[] args){
        int[] array = {1,2 ,3 ,4, 5};

        System.out.printf(
                "Effects of passing reference to entire array:%n" +
                        "The values of the original array are:%n");

        for(int value : array){
            System.out.printf("    %d", value);
        }

        modifyArray(array);

        System.out.printf("%nThe array has been altered%n");

        for(int value : array){
            System.out.printf("    %d", value);
        }

        System.out.printf(
            "%n%nEffects of passing array element value:%n" +
            "array[3] before modifyElement: %d%n", array[3]);

        modifyElement(array[3]); // attempt to modify array[3]

        System.out.printf(
            "array[3] after modifyElement: %d%n", array[3]);
    }

    private static void modifyElement(int element) {
        element *= 2;
        System.out.printf("%nValue of element in modifyElement: %d%n", element);
    }

    private static void modifyArray(int[] array2) {
        for(int counter =0; counter < array2.length; counter++)
            array2[counter] *= 2;

    }
}
