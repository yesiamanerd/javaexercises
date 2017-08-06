import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraysAndStreams2 {
   public static void main(String[] args){
      String[] strings = {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};

      // display original strings
      System.out.printf("Original strings: %s%n", Arrays.asList(strings));

      // strings in uppercase
      System.out.printf("Strings in uppercase: %s%n",
         Arrays.stream(strings)
            .map(String::toUpperCase)
            .collect(Collectors.toList()));

      // string less than "n" (case insensitive) sorted ascending
      System.out.printf("Strings greater than m sorted ascending: %s%n",
         Arrays.stream(strings).
            filter(s -> s.compareToIgnoreCase("n") > 0)
            .sorted(String.CASE_INSENSITIVE_ORDER)
            .collect(Collectors.toList()));

      // strings less than "n" (case insensitive) sorted descending
      System.out.printf("Strings greater than m sorted descending: %s%n",
         Arrays.stream(strings)
            .map(String::toUpperCase)
            .filter(s -> s.compareToIgnoreCase("n") > 0)
            .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
            .collect(Collectors.toList()));

      // test System.out in map
      System.out.println("Test of println inside of the stream: ");
      Arrays.stream(strings).map(String::toUpperCase)
         .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
         .collect(Collectors.toList()).forEach(System.out::println);
   }
}
