package PokemonTrainer;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainerMap = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("Tournament")) {
            String[] info = line.split("\\s+");

            String trainerName = info[0];
            String pokemonName = info[1];
            String pokemonElement = info[2];
            int pokemonHealth = Integer.parseInt(info[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            trainerMap.putIfAbsent(trainerName, new Trainer(trainerName));
            Trainer oneTrainer = trainerMap.get(trainerName);

            oneTrainer.addPokemon(pokemon);

            line = scanner.nextLine();
        }


        String element = scanner.nextLine();
        while (!element.equals("End")) {
          String elementToFind = element;

          trainerMap.values().forEach(s -> s.applyCommand(elementToFind));

            element = scanner.nextLine();
        }
        trainerMap.values().stream().sorted(Comparator.comparing(Trainer::getNumberOfBadges).reversed()).forEach(System.out::println);


    }
}
