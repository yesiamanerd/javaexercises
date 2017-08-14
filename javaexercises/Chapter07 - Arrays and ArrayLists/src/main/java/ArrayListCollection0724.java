import java.util.ArrayList;

public class ArrayListCollection0724 {
    public static void main(String[] args){
        ArrayList<String> items = new ArrayList<String>();

        items.add("red");
        items.add(0, "yellow");

        System.out.printf("Display contents of list with counter controlled loop:%n");

        for(int i = 0; i < items.size(); i++){
            System.out.printf(" %s ", items.get(i));
        }
        System.out.println();

        display(items, "Display list contents with enhanced for statement: ");

        items.add("green");
        items.add("yellow");
        display(items, "List with two new elements");

        items.remove("yellow");
        display(items, "Remove first instance of yellow");

        items.remove(1);
        display(items, "Remove second item in the list (green)");

        System.out.printf("\"Red\" is %sin the list%n%n",
                items.contains("red")? "" : "not ");
        System.out.printf("Size: %s%n", items.size());
    }

    private static void display(ArrayList<String> items, String header) {
        System.out.printf("%s%n", header);

        for(String item : items)
            System.out.printf(" %s ", item);

        System.out.println();
    }
}
