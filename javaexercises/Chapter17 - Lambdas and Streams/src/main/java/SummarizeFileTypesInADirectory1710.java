/*
 *    Summarize the types of files in a specified directory
 */

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SummarizeFileTypesInADirectory1710 {
   public static void main(String[] args) throws IOException{
      Scanner input = new Scanner(System.in);

      System.out.println("Enter a file or directory name:");

      // create Path object based on user input
      Path path = Paths.get(input.nextLine());


      if(Files.exists(path)){    // if path exists, output info about it
         // display file (or directory) information
         System.out.printf("%n%s exists%n", path.getFileName());

         if(Files.isDirectory(path)){
            System.out.printf("%nDirectory contents: %n");

            // object for iterating through a directory's contents
            DirectoryStream<Path> directoryStream =Files.newDirectoryStream(path);
            Files.newDirectoryStream(path).forEach(p -> System.out.println(p.getFileName().toString().substring(p.getName(3).getFileName().toString().lastIndexOf('.')+ 1)));
            //String str = path.getFileName().toString().substring(path.getName(3).getFileName().toString().lastIndexOf('.')+ 1);
                //  .forEach(p -> (p.getFileName().toString().substring(p.getName(3).getFileName().toString().lastIndexOf('.')+ 1)));




//            for(Path p : directoryStream) {
//               System.out.println(p.
//
//            }

         }
      }
   }

}
