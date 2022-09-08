package CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Engine> engineTypes = new LinkedHashMap<>();
        List<Car> carTypes = new ArrayList<>();

        int engineCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < engineCount; i++) {
            String[] engineParts = scanner.nextLine().split(" ");
            String model = engineParts[0];
            int power = Integer.parseInt(engineParts[1]);
            int displacement = 0;
            String efficiency = "n/a";

            if (engineParts.length == 3) {
                if (engineParts[2].matches("\\d+")) {

                    displacement = Integer.parseInt(engineParts[2]);
                } else {
                    efficiency = engineParts[2];
                }
            } else if (engineParts.length == 4) {
                displacement = Integer.parseInt(engineParts[2]);
                efficiency = engineParts[3];
            }

            Engine engine = new Engine(model, power, displacement, efficiency);
            engineTypes.put(model,engine);
        }

        int carCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < carCount; i++) {
            String[] carParts = scanner.nextLine().split(" ");

            String model = carParts[0];
            String engineModelForCar = carParts[1];
            int weight = 0;
            String color = "n/a";

            if(carParts.length == 3){

                if(carParts[2].matches("\\d+")){
                    weight = Integer.parseInt(carParts[2]);
                }else{
                    color = carParts[2];
                }

            }else if (carParts.length == 4){
                weight = Integer.parseInt(carParts[2]);
                color = carParts[3];
            }
            Engine temporaryEngine = engineTypes.get(engineModelForCar);
          Car car = new Car(model,temporaryEngine,weight,color);
         carTypes.add(car);
        }
          carTypes.forEach(System.out::println);

    }
}
