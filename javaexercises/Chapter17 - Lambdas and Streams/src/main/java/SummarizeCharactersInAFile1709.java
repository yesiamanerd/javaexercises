/*
 *    Summarize the occurrence of every character in a file
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SummarizeCharactersInAFile1709 {
   public static void main(String[] args) throws IOException {
      // regex that matches one or more consecutive whitespace characters
      Pattern pattern = Pattern.compile("\\s+");

      // count occurrences of each letter in a Stream<String> sorted by word
      Map<String, Long> wordCounts =
         //Files.lines(Paths.get("D:///Java/deitel/javaexercises/Chapter17 - Lambdas and Streams/src/main/resources/TextFile.txt"))
         Files.lines(Paths.get("/home/geoffrey/Java/javaexercises/javaexercises/Chapter17 - Lambdas and Streams/src/main/resources/TextFile.txt"))
            .map(line -> line.replaceAll("(?!'')\\p{P}", ""))
            .map(line -> line.replaceAll(".(?!$)", "$0 "))
            .flatMap(line -> pattern.splitAsStream(line))
            .collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting()));

      // display the letter and occurrence count
      wordCounts.entrySet()
         .stream()
         .collect(
            Collectors.groupingBy(entry -> entry.getKey().charAt(0), TreeMap::new, Collectors.toList()))
         .forEach((letter, wordList) -> {
               wordList.stream().forEach(word -> System.out.printf(
                  "%s: %d%n", word.getKey(), word.getValue()));
      });
   }
}
