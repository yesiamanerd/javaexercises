package sortedlistmerge;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
This is an exercise in Chap 21 of How To Program Java 8

Merging Ordered Lists

Modify the SortedList class from Exercise 21.7 to include a merge
method that can merge the SortedList it receives as an argument
with the SortedList that calls the method. Write an application
to test method merge .
*/

class SortedListNode<T> {
    // package access members; List can access these directly
    T data; // data for this node
    SortedListNode<T> nextNode; // reference to the next node in the list
    List<T> list = new ArrayList<T>();

    SortedListNode(T object) {
        this(object, null);
    }

    // constructor creates ListNode that refers to the specified
    // object and to the next ListNode
    SortedListNode(T object, SortedListNode<T> node) {
        data = object;
        nextNode = node;
    }

    T getData() {
        return data;
    }

    SortedListNode<T> getNext() {
        return nextNode;
    }
}

public class SortedList<T> {
    private SortedListNode<T> firstNode;
    private SortedListNode<T> lastNode;
    String name;

    // constructor creates empty List with "list" as the name
    public SortedList(){
        this("list");
    }

    public SortedList(String listName){
        name = listName;
        firstNode = lastNode = null;
    }


    // insert item at the back of the list
    public void internalInsert(T insertItem){
        if(isEmpty())
            firstNode = lastNode = new SortedListNode<>(insertItem);
        else
            lastNode = lastNode.nextNode = new SortedListNode<>(insertItem);


    }

    // insert item at the back of the list
    public void insert(T insertItem){
        if(isEmpty())
            firstNode = lastNode = new SortedListNode<>(insertItem);
        else
            lastNode = lastNode.nextNode = new SortedListNode<>(insertItem);

        this.sort();
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
            SortedListNode<T> current = firstNode;

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
        SortedListNode<T> current = firstNode;

        // while not at end of list, output current node's data
        while(current != null){
            System.out.printf("%s ", current.data);
            current = current.nextNode;
        }

        System.out.println();
    }

    // sort list contents
    private void sort(){
        if(isEmpty()){
            System.out.printf("Empty %s%n", name);
            return;
        }

        SortedListNode<T> current = firstNode;
        List<T> list = new ArrayList<T>();

        while(current != null){
            list.add(current.data);
            current = current.nextNode;
        }

        list = list.stream().sorted().collect(Collectors.toList());
        firstNode = lastNode = null;

        for(T value : list){
            this.internalInsert(value);
        }
    }

    // merge two sorted lists
    public void merge(SortedList<T> list2){
        while(!list2.isEmpty()){
            this.internalInsert(list2.removeFromFront());
        }

        this.sort();
    }

    public static void main(String[] args) {
        SortedList<Integer> list1 = new SortedList<>();
        SortedList<Integer> list2 = new SortedList<>();


        addRandomValues(list1);
        addRandomValues(list2);

        System.out.printf("List 1: %n");
        list1.print();
        System.out.printf("%n%nList 2: %n");
        list2.print();

        list1.merge(list2);

        System.out.printf("%n%nList 1 after merge: %n");
        list1.print();

    }

    private static void addRandomValues(SortedList<Integer> list) {
        SecureRandom random = new SecureRandom();
        Set<Integer> set = new HashSet<>();
        while(set.size() != 25){
            set.add(random.nextInt(100));
        }

        for(Integer value: set)
            list.insert(value);
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


