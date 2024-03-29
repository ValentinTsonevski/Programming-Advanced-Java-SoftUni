package OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int personCount = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < personCount; i++) {
            String[] personParts = scanner.nextLine().split(" ");
            String name = personParts[0];
            int age = Integer.parseInt(personParts[1]);
            Person person = new Person(name,age);
            people.add(person);

        }
         people.stream().filter(person ->  person.getAge() > 30)
                 .sorted(Comparator.comparing(Person::getName))
                 .forEach(System.out::println);
    }
}
