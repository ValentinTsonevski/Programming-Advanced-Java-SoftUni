import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Programing Advanced\\Streams Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt"));
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Programing Advanced\\Streams Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputLineNumbers.txt");

        PrintWriter printWriter = new PrintWriter(fileOutputStream);

        String line = bufferedReader.readLine();

        List<String> allLines = new ArrayList<>();
        int lineCounter = 0;

        while (line != null) {
            allLines.add(line);
           ;

            line = bufferedReader.readLine();
        }
        for (String singleLane : allLines) {
            lineCounter ++;
            printWriter.printf("%d. %s%n",lineCounter,singleLane);
        }


        printWriter.close();
    }
}
