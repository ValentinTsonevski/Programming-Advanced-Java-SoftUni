import java.io.*;

public class ALLCAPITALS {
    public static void main(String[] args)throws IOException {

        BufferedReader reader  = new BufferedReader(new FileReader("C:\\Programing Advanced\\Streams Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Programing Advanced\\Streams Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");

        String line = reader.readLine();
        PrintWriter printWriter = new PrintWriter(fileOutputStream);

        while (line != null){
          printWriter.println(line.toUpperCase());


          line = reader.readLine();
        }
        printWriter.close();

    }
}
