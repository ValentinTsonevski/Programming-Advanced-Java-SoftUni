package CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight = 0;
    private String color = "n/a";

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format(model + ":%n" + engine.getModel() + ":%n" +
                "Power: " + engine.getPower() + "%n"
                + "Displacement: " + (engine.getDisplacement() == 0 ? "n/a" : engine.getDisplacement()) + "%n"
                + "Efficiency: " + engine.getEfficiency() + "%n" +
                "Weight: " + (weight == 0 ? "n/a" : weight) + "%n"
                + "Color: " + color);
    }
}
