import java.security.SecureRandom;

public class SortedListTest {
    public static void main(String[] args) {
        SortedList<Integer> list = new SortedList<>();
        SecureRandom random = new SecureRandom();

        for(int i = 0; i < 25; i++){
            list.insert(random.nextInt(100));
        }

        list.print();

        // remove objects from the list.  Print after each removal
        try{
            int removedItem = list.removeFromFront();
            System.out.printf("%n%d removed %n", removedItem);
            list.print();

            removedItem = list.removeFromFront();
            System.out.printf("%n%d removed %n", removedItem);
            list.print();

            removedItem = list.removeFromBack();
            System.out.printf("%n%d removed %n", removedItem);
            list.print();

            removedItem = list.removeFromBack();
            System.out.printf("%n%d removed %n", removedItem);
            list.print();
        }
        catch (EmptyListException emptyListException){
            emptyListException.printStackTrace();
        }
    }
}
