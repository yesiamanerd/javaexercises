package reverselistcopy;

/*
This is an exercise in Chap 21 of How To Program Java 8

Copying a List Backward

Write a static method reverseCopy that receives a List<T> as
an argument and returns a copy of that List<T> with its
elements reversed. Test this method in an application.

*/

class ListNode<T> {
    // package access members; List can access these directly
    T data; // data for this node
    ListNode<T> nextNode; // reference to the next node in the list

    ListNode(T object) {
        this(object, null);
    }

    // constructor creates ListNode that refers to the specified
    // object and to the next ListNode
    ListNode(T object, ListNode<T> node) {
        data = object;
        nextNode = node;
    }

    T getData() {
        return data;
    }

    ListNode<T> getNext() {
        return nextNode;
    }
}


public class List<T> {
    private ListNode<T> firstNode;
    private ListNode<T> lastNode;
    String name;

    // constructor creates empty List with "list" as the name
    public List(){
        this("list");
    }

    public List(String listName){
        name = listName;
        firstNode = lastNode = null;
    }

    // insert item at the front of the list
    public void insertAtFront(T insertItem){
        if(isEmpty())
            firstNode = lastNode = new ListNode<>(insertItem);
        else
            firstNode = new ListNode<>(insertItem, firstNode);
    }

    // insert item at the back of the list
    public void insertAtBack(T insertItem){
        if(isEmpty())
            firstNode = lastNode = new ListNode<>(insertItem);
        else
            lastNode = lastNode.nextNode = new ListNode<>(insertItem);
    }

    // remove first node from the list
    public T removeFromFront() throws EmptyListException {
        if(isEmpty())
            throw new EmptyListException(name);

        // retrieve data being removed
        T removedItem = firstNode.data;

        // update references to firstNode and lastNode
        if(firstNode == lastNode)
            firstNode = lastNode = null;
        else
            firstNode = firstNode.nextNode;

        return removedItem;
    }

    // remove last node from the list
    public T removeFromBack() throws EmptyListException {
        if(isEmpty())
            throw new EmptyListException(name);

        T removedItem = lastNode.data;

        // update references to firstNode and lastNode
        if(firstNode == lastNode)
            firstNode = lastNode = null;
        else{
            ListNode<T> current = firstNode;

            // loop while current node does not refer to lastNode
            while(current.nextNode != lastNode)
                current = current.nextNode;

            lastNode = current;
            current.nextNode = null;
        }

        return removedItem;
    }

    // determine whether a list is empty
    public boolean isEmpty(){
        return firstNode == null;
    }

    // output list contents
    public void print(){
        if(isEmpty()){
            System.out.printf("Empty %s%n", name);
            return;
        }

        System.out.printf("The %s is ", name);
        ListNode<T> current = firstNode;

        // while not at end of list, output current node's data
        while(current != null){
            System.out.printf("%s ", current.data);
            current = current.nextNode;
        }

        System.out.println();
    }

    private List<T> reverseCopy() {
        List<T> originalList = this;
        List<T> reversedlist = new List<T>();

        while(!originalList.isEmpty()){
            reversedlist.insertAtBack(originalList.removeFromBack());
        }

        return reversedlist;
    }

    public static void main(String[] args) {
        List<Integer> list = new List<>();

        // insert integers in the list
        list.insertAtFront(-1);
        list.insertAtFront(0);
        list.insertAtFront(1);
        list.insertAtFront(5);
        System.out.printf("Original List: %n");
        list.print();

        List<Integer> reversedList = list.reverseCopy();
        System.out.printf("%nReversed List: %n");
        reversedList.print();
    }


}

class EmptyListException extends RuntimeException{
    public EmptyListException(){
        this("List");
    }

    public EmptyListException(String name){
        super(name + " is empty");
    }



}
