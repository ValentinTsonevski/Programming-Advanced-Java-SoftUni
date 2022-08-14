import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args)throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Programing Advanced\\Streams Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        int sum = 0;
        String line = reader.readLine();
        while (line != null){

            for (char element : line.toCharArray()){

                sum += element;
            }

            line = reader.readLine();
        }
        System.out.println(sum);


    }
}
