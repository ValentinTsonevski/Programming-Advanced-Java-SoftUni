import java.io.*;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {

        String path = "C:\\Programing Advanced\\Streams Files And Directories - Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            FileOutputStream fileOutputStream = new FileOutputStream("04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt");

            int read = fileInputStream.read();

            Set<Character> table = Set.of(',', '.', '?', '!');

          while (read != -1){
              if(!table.contains((char)read)) {
                  fileOutputStream.write(read);

              }
              read = fileInputStream.read();
          }

        }
        catch (IOException ignored){

        }





    }
}
