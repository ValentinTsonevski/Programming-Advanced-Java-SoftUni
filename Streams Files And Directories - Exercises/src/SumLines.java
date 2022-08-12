import java.io.*;


public class SumLines {
    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new FileReader("C:\\Programing Advanced\\Streams Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));

        String line = reader.readLine();

        while (line != null) {
            int sum = 0;

            for (char element : line.toCharArray()){
                sum += element;
            }
            System.out.println(sum);
        line = reader.readLine();
        }

    }
}
