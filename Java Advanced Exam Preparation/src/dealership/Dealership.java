package dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    public List<Car> data;
    public String name;
    public int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car){
        if(capacity > data.size()){
           data.add(car);
        }
    }

    public boolean buy(String manufacturer,String model){
        for (Car car : data) {
            if(car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar(){
        return this.data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }

    public Car getCar(String manufacturer,String model){
        for (Car car : data) {
            if(car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                return car;
            }
        }
        return null;
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("The cars are in a car dealership %s:%n",this.name));
        for (Car car : data) {
            sb.append(String.format("%s%n",car));
        }


        return sb.toString();
    }
}
