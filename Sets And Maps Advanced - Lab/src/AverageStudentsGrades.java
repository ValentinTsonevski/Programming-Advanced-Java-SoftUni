import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsInfoMap = new TreeMap<>();



        for (int i = 0; i < numberOfStudents; i++) {
            String[] inputStudentsInfo = scanner.nextLine().split(" ");
            String studentName = inputStudentsInfo[0];
            double studentGrade = Double.parseDouble(inputStudentsInfo[1]);
            
            studentsInfoMap.putIfAbsent(studentName,new ArrayList<>());
            studentsInfoMap.get(studentName).add(studentGrade);
        }

        for (var gradesList : studentsInfoMap.entrySet()) {
            double avgGrade = 0;
            for (Double grade : gradesList.getValue()){
                avgGrade+= grade;
            }
            avgGrade /= gradesList.getValue().size();

         List<String> studentGrades = gradesList.getValue().stream().map(e -> String.format("%.2f",e)).collect(Collectors.toList());
         String finalGrades = String.join(" ",studentGrades);
            System.out.printf("%s -> %s (avg: %.2f)%n", gradesList.getKey(),finalGrades,avgGrade);

        }

    }
}
