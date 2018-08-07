

// File class to obtain file and directory information

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileAndDirectoryInfo{
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter file or directory name: ");

        // Create path object based on the users input
        @Deprecated
        Path path = Paths.get(input.nextLine());

        if(Files.exists(path)){
            System.out.printf("%n%s exists %n", path.getFileName());
            System.out.printf("%s %s a directory", path.getFileName(), Files.isDirectory(path)? "is": "is not");
            System.out.printf("%n%s %s an absolute path", path.getFileName(), path.isAbsolute()? "is": "is not");
            System.out.printf("%nLast modified: %s", Files.getLastModifiedTime(path));
            System.out.printf("%nSize: %s", Files.size(path));
            System.out.printf("%nPath: %s", path);
//            Path absolutePath = path.toAbsolutePath();
//            System.out.printf("%Absolute path: %s", Paths.get(path.toString()));




        }


    }


}