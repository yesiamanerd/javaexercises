public class RawTypeTest {
    public static void main(String[] args) {
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6};
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        Stack rawTypeStack1 = new Stack(6);

        Stack rawTypeStack2 = new Stack<Double>(6);

        Stack<Integer> integerStack = new Stack<Integer>(intArray.length);

        testPushStack("rawTypeStack1", rawTypeStack1, doubleArray);
        testPopStack("rawTypeStack1", rawTypeStack1);
        testPushStack("rawTypeStack2", rawTypeStack2, doubleArray);
        testPopStack("rawTypeStack2", rawTypeStack2);
        testPushStack("integerStack", integerStack, intArray);
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
