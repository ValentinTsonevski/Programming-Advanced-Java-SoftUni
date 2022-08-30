package CarConstructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carsCount = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carsCount; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String brand = tokens[0];

            Car car = null;

            if (tokens.length != 1) {
                String model = tokens[1];
                int horsePower = Integer.parseInt(tokens[2]);
                car = new Car(brand, model, horsePower);

            } else {
                car = new Car(brand);
            }
            cars.add(car);
        }
        cars.forEach(car -> System.out.println(car.carInfo()));


    }
}
