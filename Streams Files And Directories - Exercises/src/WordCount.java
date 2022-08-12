import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args)throws IOException {


        Scanner scanner = new Scanner(new FileReader("C:\\Programing Advanced\\Streams Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt"));
        Scanner secondScanner = new Scanner(new FileReader("C:\\Programing Advanced\\Streams Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt"));
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Programing Advanced\\Streams Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputWords.txt");
        PrintWriter printWriter = new PrintWriter(fileOutputStream);

        Map<String,Integer> words = new LinkedHashMap<>();
        Arrays.stream(scanner.nextLine().split(" ")).forEach(word -> words.put(word,0));


        while (secondScanner.hasNext()){
        String textInput = secondScanner.next();
        if(words.containsKey(textInput)){
            int count = words.get(textInput);
            count++;
       words.put(textInput,count);
        }

        }

        words.entrySet().stream().forEach(entry ->printWriter.printf("%s - %d%n",entry.getKey(),entry.getValue()));
        printWriter.close();
        }


    }

