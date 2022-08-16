import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args)throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Programing Advanced\\Streams Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Programing Advanced\\Streams Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputCountCharacterTypes.txt");

        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        String readLine = bufferedReader.readLine();

       // List<String> lines = new ArrayList<>();
        int vowels = 0;
        int punctuation = 0;
        int consonants = 0;
        int space = 0;



        while (readLine != null){
            char[] lineToChar = readLine.toCharArray();
            for (char element : lineToChar) {
                if(isVowel(element)){
               vowels ++;
                }else if (isPunctuation(element)){
                  punctuation ++;
                }else if(element == ' '){
                    space ++;
                }else {
                    consonants ++;
                }
            }


            readLine = bufferedReader.readLine();
        }
        printWriter.printf("Vowels: %d%n",vowels);
        printWriter.printf("Consonants: %d%n",consonants);
        printWriter.printf("Punctuation: %d%n",punctuation);
         printWriter.close();
    }

    public  static boolean isVowel(char element){
        return element =='a' || element == 'e' || element == 'i' || element =='o' || element == 'u';
    }
    public  static  boolean isPunctuation(char element){
        return element == '!' || element == '?' || element == '.' || element == ',';
    }

}
