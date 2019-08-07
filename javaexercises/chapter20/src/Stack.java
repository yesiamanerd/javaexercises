import java.util.ArrayList;


public class Stack<T> {
    private final ArrayList<T> elements; // ArrayList will hold values of the stack

    public Stack(){
        this(10);
    }

    public Stack(int capacity){
        int intCapacity = capacity > 0? capacity: 10;
        elements = new ArrayList<>(intCapacity);
    }

    // push value onto the stack
    public void push(T element){
        elements.add(element);
    }

    // remove an element from the stack
    public T pop(){
        if(elements.isEmpty())
            throw new EmptyStackException("Stack is empty, cannot pop");
        return elements.remove(elements.size() - 1);
    }

}
