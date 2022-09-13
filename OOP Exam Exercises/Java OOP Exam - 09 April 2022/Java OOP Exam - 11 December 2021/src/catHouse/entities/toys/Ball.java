package catHouse.entities.toys;

public class Ball extends BaseToy{
    private static final int SOFTNESS = 1;
    private static final double PRICE = 10.0;

    public Ball() {
        super(SOFTNESS, PRICE);
    }

    @Override
    public int getSoftness() {
        return this.SOFTNESS;
    }

    @Override
    public double getPrice() {
        return this.PRICE;
    }
}
