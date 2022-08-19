import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterByAge {
    static class People{
        String name;
        int age;

        public People(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        List<People> allPeople = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
         String[] people = scanner.nextLine().split(", ");
         String name = people[0];
         int age = Integer.parseInt(people[1]);

         People person = new People(name,age);
         allPeople.add(person);
        }
        String condition = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

    allPeople = filter(allPeople,getPredicate(condition,ageLimit));

        Consumer<People>printer = gerPrinter(format);
       allPeople.forEach(printer);

    }

    private static Consumer<People> gerPrinter(String format) {
        switch (format){
            case "name age":
                return p -> System.out.println(p.name + " - " + p.age);
            case "name":
                return p -> System.out.println(p.name);

            case "age":
            return p -> System.out.println(p.age);
            default: throw new IllegalArgumentException("Unknown format" + format);
        }

    }

    private static Predicate<People> getPredicate(String condition, int ageLimit) {
        switch (condition){
            case "younger":
                return person -> person.age <= ageLimit;
            case "older":
                return person -> person.age >= ageLimit;
            default: throw new IllegalArgumentException("Invalid parameters for age condition" + ageLimit + " " + condition);
        }

    }

    public static List<People> filter (List<People> people,Predicate<People> predicate){
            return people.stream()
                    .filter(predicate)
                    .collect(Collectors.toList());
    }

}
