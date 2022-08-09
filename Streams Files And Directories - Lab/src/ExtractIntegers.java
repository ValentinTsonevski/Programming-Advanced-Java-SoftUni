import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {


            FileInputStream fileInputStream = new FileInputStream("04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
            FileOutputStream fileOutputStream = new FileOutputStream("04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt");

            Scanner scanner = new Scanner(fileInputStream);
         PrintWriter printWriter = new PrintWriter(fileOutputStream);

            while (scanner.hasNext()){

                if(scanner.hasNextInt()) {

                    printWriter.println(scanner.next());
                }else {
                    scanner.next();
                }
            }

            printWriter.close();

    }
}
