import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pairsCount = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> graduatedPeople = new TreeMap<>();

        for (int i = 0; i < pairsCount; i++) {
            String name = scanner.nextLine();

            List<Double> grades = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());

            graduatedPeople.put(name,grades);
        }
        String pattern = "#.#########################";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        for (var entry : graduatedPeople.entrySet()) {
            double avgGrade = 0;

            for (var grade : entry.getValue()){
                avgGrade += grade;
            }
            avgGrade /= entry.getValue().size();
            System.out.printf("%s is graduated with %s%n",entry.getKey(),decimalFormat.format(avgGrade));
        }


    }
}
