public class StackTest2 {
    public static void main(String[] args) {
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6};
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        // create a stack double and a stack integer
        Stack<Double> doubleStack = new Stack<>(6);
        Stack<Integer> integerStack = new Stack<>(intArray.length);

        // push elements of doubleArray onto doubleStack
        testPushStack("doubleStack", doubleStack, doubleArray);
        // pop elements from doubleStack
        testPopStack("doubleStack", doubleStack);

        // push elements of integerArray onto integerStack
        testPushStack("integerStack", integerStack, intArray);
        // pop elements from integerStack
        testPopStack("integerStack", integerStack);
    }

    public static <T> void testPushStack(String name, Stack<T> stack, T[] elements){
        System.out.printf("Pushing values onto stack %s%n", name);

        for(T element: elements){
            System.out.printf("%s ", element);
            stack.push(element);
        }

        System.out.println();
    }

    public static <T> void testPopStack(String name, Stack<T> stack){
        System.out.printf("Popping the values from the stack %s%n", name);

        T popValue;
        try{
            while(true){
                popValue = stack.pop();
                System.out.printf("%s ", popValue);
            }
        }
        catch(EmptyStackException emptyStackException){
            System.err.println();
            emptyStackException.printStackTrace();
        }

        System.out.println();
    }
}
