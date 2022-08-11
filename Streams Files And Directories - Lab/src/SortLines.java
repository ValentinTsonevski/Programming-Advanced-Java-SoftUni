import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args)throws IOException {

     //   FileOutputStream fileOutputStream = new FileOutputStream("04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt");

     //   PrintWriter printWriter = new PrintWriter(fileOutputStream);

      List<String> sortedLines = Files.readAllLines(Path.of("04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt"))
              .stream().sorted().collect(Collectors.toList());

      Path outputPath = Path.of("04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt");



        Path write = Files.write(outputPath,sortedLines);




    }
}
