import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Set<String>> players = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] nameAndCards = input.split(": ");
            String name = nameAndCards[0];
            String[] cards = nameAndCards[1].split(", ");

            players.putIfAbsent(name, new HashSet<>());

            for (String card : cards) {
                players.get(name).add(card);
            }

            input = scanner.nextLine();
        }

        PrintOutput(players);

    }

    private static void PrintOutput(Map<String, Set<String>> players) {
        for (var entry : players.entrySet()) {
            String playerName = entry.getKey();
            int points = calculatePoints(entry.getValue());
            System.out.printf("%s: %d%n",playerName,points);
        }
    }

    private static int calculatePoints(Set<String> cards) {
        int points = 0;
        for (String card : cards) {
            String power = card.substring(0, card.length() - 1);
            char type = card.charAt(card.length() - 1);
            int cardPoints = calculatePower(power) * calculateType(type);
            points+= cardPoints;
        }
        return points;
    }

    public static int calculateType(Character type) {
        switch (type) {
            case 'S':
                return 4;

            case 'H':
                return 3;

            case 'D':
                return 2;

            case 'C':
                return 1;

            default:
                return 0;
        }
    }

    public static int calculatePower(String power) {
        switch (power) {
            case "J":
                return 11;

            case "Q":
                return 12;

            case "K":
                return 13;

            case "A":
                return 14;

            default:
                return Integer.parseInt(power);
        }

    }
}
