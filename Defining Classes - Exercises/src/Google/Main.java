package Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> allPersons = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] token = input.split("\\s+");
            String name = token[0];

            allPersons.putIfAbsent(name, new Person(name));
            Person person = allPersons.get(name);

            String currentClass = token[1];
            switch (currentClass) {
                case "company":
                    String companyName = token[2];
                    String department = token[3];
                    double salary = Double.parseDouble(token[4]);

                    person.setCompany(new Company(companyName, department, salary));
                    break;

                case "car":
                    String carModel = token[2];
                    int carSpeed = Integer.parseInt(token[3]);

                    person.setCar(new Car(carModel, carSpeed));
                    break;

                case "pokemon":
                    String pokemonName = token[2];
                    String pokemonType = token[3];

                    person.addPokemon(new Pokemon(pokemonName,pokemonType));
                    break;

                case "parents":
                    String parentName = token[2];
                    String parentBirthday = token[3];

                    person.addParent(new Parents(parentName, parentBirthday));
                    break;

                case "children":
                    String childrenName = token[2];
                    String childrenBirthday = token[3];

                    person.addChild(new Children(childrenName,childrenBirthday));
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(allPersons.get(scanner.nextLine()));
    }
}
