import java.io.*;

public class CopyBytes {
    public static void main(String[] args) {

        try{
            FileInputStream inputStream = new FileInputStream("04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
            FileOutputStream fileOutputStream = new FileOutputStream("04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt");

            int read = inputStream.read();
            PrintWriter printWriter = new PrintWriter(fileOutputStream);

            while (read != -1) {
                if(read == ' '){
                 printWriter.print(' ');
                }else if (read == 10){
                    printWriter.println();
                }else {
                    printWriter.print(read);
                }
            read = inputStream.read();
            }
            printWriter.close();
        }
        catch (IOException ignored){

        }

    }
}
