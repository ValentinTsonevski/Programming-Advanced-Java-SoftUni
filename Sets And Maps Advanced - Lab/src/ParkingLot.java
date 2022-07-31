import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> cars = new LinkedHashSet<>();

        while (!input.equals("END")){
         String[] commandCars = input.split(", ");
      String inOrOur = commandCars[0];
      String carNumber = commandCars[1];

      if(inOrOur.equals("IN")){
      cars.add(carNumber);
      }else if (inOrOur.equals("OUT")){
          cars.remove(carNumber);
      }

            input = scanner.nextLine();
        }
        if(cars.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else{
            for (String place : cars) {
                System.out.println(place);
            }
        }




    }
}
