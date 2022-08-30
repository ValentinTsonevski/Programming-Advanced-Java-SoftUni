package CarInfo;

public class Car {
    private String model;
    private String brand;
    private int horsePower;

    public Car(String model, String brand, int horsePower) {
        this.model = model;
        this.brand = brand;
        this.horsePower = horsePower;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",this.getBrand(),this.getModel(),this.getHorsePower());
    }
}
