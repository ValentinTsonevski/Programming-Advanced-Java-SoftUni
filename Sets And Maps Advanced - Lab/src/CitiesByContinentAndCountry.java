import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countInputs = Integer.parseInt(scanner.nextLine());
        Map<String,Map<String,List<String>>> map = new LinkedHashMap<>();

        for (int i = 0; i < countInputs; i++) {
            String[] inputInfo = scanner.nextLine().split(" ");
            String continent = inputInfo[0];
            String country = inputInfo[1];
            String city = inputInfo[2];

            map.putIfAbsent(continent,new LinkedHashMap<>());

            map.get(continent).putIfAbsent(country,new ArrayList<>());
            map.get(continent).get(country).add(city);

        }

        for (var entry :map.entrySet()){
            System.out.printf("%s:%n",entry.getKey());
            for (var secondEntry : entry.getValue().entrySet()){
                String readyOutput = String.join(", ",secondEntry.getValue());
                System.out.printf("%s -> %s%n",secondEntry.getKey(),readyOutput);

            }

        }



    }
}
