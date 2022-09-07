package CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleCount = Integer.parseInt(scanner.nextLine());

        Map<String,Department> finalInfoEmployees = new LinkedHashMap<>();

            Employee employee = null;

        for (int i = 0; i < peopleCount; i++) {
            String[] peopleParts = scanner.nextLine().split("\\s+");
            String name = peopleParts[0];
            Double salary = Double.parseDouble(peopleParts[1]);
            String position = peopleParts[2];
            String department = peopleParts[3];

            switch (peopleParts.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;

                case 5:
                    if (peopleParts[4].matches("\\d+")) {
                        int age = Integer.parseInt(peopleParts[4]);
                        employee = new Employee(name, salary, position, department, age);
                    } else {
                        String email = peopleParts[4];
                        employee = new Employee(name, salary, position, department, email);
                    }
                    break;

                case 6:
                    String email = peopleParts[4];
                    int age = Integer.parseInt(peopleParts[5]);
                    employee = new Employee(name, salary, position, department, email, age);
                    break;
            }
            finalInfoEmployees.putIfAbsent(department,new Department(department));
            finalInfoEmployees.get(department).getEmployees().add(employee);
        }
        Department highestPayDepartment = finalInfoEmployees.entrySet().stream()
                .max(Comparator.comparingDouble(e -> e.getValue().getAverageSalary()))
                .get().getValue();

        System.out.println("Highest Average Salary: " + highestPayDepartment.getName());
      highestPayDepartment.getEmployees().stream().sorted((e1,e2) -> Double.compare(e2.getSalary(), e1.getSalary())).forEach(System.out::println);
    }
}
