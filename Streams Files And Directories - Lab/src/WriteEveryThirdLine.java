import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {


       // FileInputStream fileInputStream = new FileInputStream("04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
      //  FileOutputStream fileOutputStream = new FileOutputStream("04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader("04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt"));
        PrintWriter printWriter = new PrintWriter(new FileWriter("04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt"));



        String line = bufferedReader.readLine();
        int counter = 0;
        while (line != null){
            counter ++;
            if(counter % 3 == 0){
              printWriter.println(line);
            }

            line = bufferedReader.readLine();
        }
        printWriter.close();



    }
}
