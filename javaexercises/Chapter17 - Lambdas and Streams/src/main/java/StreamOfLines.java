import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamOfLines {
   public static void main(String[] args) throws IOException{
      // regex that matches one or more consecutive whitespace characters
      Pattern pattern = Pattern.compile("\\s+");

      // count occurrences of each word in a Stream<String> sorted by word
      Map<String, Long> wordCounts =
         Files.lines(Paths.get("D:///Java/deitel/javaexercises/Chapter17 - Lambdas and Streams/src/main/resources/TextFile.txt"))
            .map(line -> line.replaceAll("(?!')\\p{P}", ""))
            .flatMap(line -> pattern.splitAsStream(line))
            .collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting()));

      // display the workds grouped by starting letter
      wordCounts.entrySet()
         .stream()
         .collect(
            Collectors.groupingBy(entry -> entry.getKey().charAt(0), TreeMap::new, Collectors.toList()))
         .forEach((letter, wordList)->
         {
            System.out.printf("%n%C%n", letter);
            wordList.stream().forEach(word -> System.out.printf(
               "%13s: %d%n", word.getKey(), word.getValue()
            ));
         });


   }
}
