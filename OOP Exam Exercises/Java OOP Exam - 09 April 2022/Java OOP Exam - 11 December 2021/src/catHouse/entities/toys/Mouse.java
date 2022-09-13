package catHouse.entities.toys;

public class Mouse extends BaseToy{
    private static final int SOFTNESS = 5;
    private static final double PRICE = 15.0;

    public Mouse() {
        super(SOFTNESS,PRICE);
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
