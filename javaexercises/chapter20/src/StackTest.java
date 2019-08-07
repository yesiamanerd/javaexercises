public class StackTest {
    public static void main(String[] args) {
        double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6};
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        // create a stack double and a stack integer
        Stack<Double> doubleStack = new Stack<>(6);
        Stack<Integer> integerStack = new Stack<>(intArray.length);

        // push elements of doubleArray onto doubleStack
        testPushDoubleStack(doubleStack, doubleArray);
        // pop elements from doubleStack
        testPopDoubleStack(doubleStack);

        // push elements of integerArray onto integerStack
        testPushIntegerStack(integerStack, intArray);
        // pop elements from integerStack
        testPopIntegerStack(integerStack);
    }

    private static void testPopIntegerStack(Stack<Integer> integerStack) {
        System.out.println("Pop integer elements from integerStack: ");
        try{
            Integer popValue;

            while(true){
                popValue = integerStack.pop();
                System.out.printf("%d ", popValue);
            }


        }
        catch (EmptyStackException emptyStackException){
            System.err.println();
            emptyStackException.printStackTrace();
        }
        System.out.println();
    }

    private static void testPushIntegerStack(Stack<Integer> integerStack, int[] intArray) {
        System.out.println("Push integer elements onto integerStack:");
        for(int element: intArray) {
            System.out.printf("%d ", element);
            integerStack.push(element);
        }
        System.out.println();
    }

    private static void testPopDoubleStack(Stack<Double> doubleStack) {
        System.out.println("Pop double elements from doubleStack: ");
        try{
            double popValue;

            while(true){
                popValue = doubleStack.pop();
                System.out.printf("%.1f ", popValue);
            }
        }
        catch (EmptyStackException emptyStackException){
            System.err.println();
            emptyStackException.printStackTrace();
        }
        System.out.println();
    }

    private static void testPushDoubleStack(Stack<Double> doubleStack, double[] doubleArray) {
        System.out.println("Push double elements onto doubleStack:");
        for(double element: doubleArray) {
            System.out.printf("%.1f ", element);
            doubleStack.push(element);
        }
        System.out.println();
    }
}
