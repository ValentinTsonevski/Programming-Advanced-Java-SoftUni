package CarInfo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carCount = Integer.parseInt(scanner.nextLine());


        while (carCount-- != 0) {
            String[] tokens = scanner.nextLine().split(" ");
            String brand = tokens[1];
            String model = tokens[0];
            int horsePower = Integer.parseInt(tokens[2]);

            Car car = new Car(brand,model,horsePower);
            System.out.println(car);
        }


    }
}
