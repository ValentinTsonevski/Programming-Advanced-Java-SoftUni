import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeTwoFiles {
    public static void main(String[] args)throws IOException {

        Scanner scanner = new Scanner(new FileReader("C:\\Programing Advanced\\Streams Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt"));
        Scanner scanner2 = new Scanner(new FileReader("C:\\Programing Advanced\\Streams Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt"));
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Programing Advanced\\Streams Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\mergeTwoFiles.txt");
        PrintWriter printWriter = new PrintWriter(fileOutputStream,true);

      while (scanner.hasNext()){
          printWriter.println(scanner.next());
      }

      while (scanner2.hasNext()){
          printWriter.println(scanner2.next());
      }


    }
}
