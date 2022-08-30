package CarConstructors;

public class Car {
    private String model;
    private String brand;
    private int horsePower;

    public Car(String brand) {
        this.brand = brand;
        this.model ="unknown";
        this.horsePower = -1;
    }

    public Car(String brand,String model, int horsePower) {
        this(brand);
        this.model = model;
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

    public String carInfo() {
        return String.format("The car is: %s %s - %d HP.",this.getBrand(),this.getModel(),this.getHorsePower());
    }

}
