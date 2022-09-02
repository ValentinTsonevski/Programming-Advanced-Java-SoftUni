package RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carCount = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            String[] carParts = scanner.nextLine().split(" ");
            String model = carParts[0];

            int engineSpeed = Integer.parseInt(carParts[1]);
            int enginePower = Integer.parseInt(carParts[2]);
            Engine engine = new Engine(engineSpeed, enginePower);
            int cargoWeight = Integer.parseInt(carParts[3]);
            String cargoType = carParts[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            List<Tire> tires = new ArrayList<>();
            for (int j = 5; j < carParts.length; j = j + 2) {
                double tyrePressure = Double.parseDouble(carParts[j]);
                int tyreAge = Integer.parseInt(carParts[j + 1]);
                Tire tire = new Tire(tyrePressure, tyreAge);
                tires.add(tire);
            }
                Car car = new Car(model,engine,cargo,tires);
            cars.add(car);
        }
      String cargoTypeCommand = scanner.nextLine();

        switch (cargoTypeCommand){
            case "fragile":
            cars.stream().filter(car -> car.getCargo().getType().equals("fragile"))
                    .filter(car -> car.getTires().stream().anyMatch(tire -> tire.getTirePressure() < 1))
                    .forEach(car -> System.out.println(car.getModel()));
                break;

            case"flamable":
            cars.stream().filter(car -> car.getCargo().getType().equals("flamable"))
                    .filter(car -> car.getEngine().getEnginePower() > 250)
                    .forEach(car -> System.out.println(car.getModel()));
                break;

        }

    }
}
