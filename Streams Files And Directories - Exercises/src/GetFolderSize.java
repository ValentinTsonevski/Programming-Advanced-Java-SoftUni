import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class GetFolderSize {
    public static void main(String[] args) throws IOException {

        File folder = new File("C:\\Programing Advanced\\Streams Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

        Deque<File> files = new ArrayDeque<>();

        files.offer(folder);
      int totalSize = 0;
        while (!files.isEmpty()){
       File currentFile = files.poll();
      File[] nestedFile = currentFile.listFiles();
            for (File file : nestedFile) {
                if(file.isDirectory()){
                    files.offer(file);
                }else{
                    totalSize += file.length();
                }
            }

        }
        System.out.println("Folder size: " + totalSize);

    }
}
