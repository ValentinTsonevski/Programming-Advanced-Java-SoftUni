package catHouse.entities.cat;

import static catHouse.common.ExceptionMessages.*;

public abstract class BaseCat implements Cat{

    private String name;
    private String breed;
    private int kilograms;
    private double price;

    public BaseCat(String name, String breed,double price) {
        setName(name);
        setBreed(breed);
        setPrice(price);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {

     if(name == null || name.trim().isEmpty()){
     throw new NullPointerException(CAT_NAME_NULL_OR_EMPTY);
     }
     this.name = name;
    }

    protected void setBreed(String breed) {

        if(breed == null || breed.trim().isEmpty()){
            throw new NullPointerException(CAT_BREED_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.breed = breed;
    }

    protected void setPrice(double price) {

        if(price <= 0){
            throw new IllegalArgumentException(CAT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }

        this.price = price;
    }

    @Override
    public int getKilograms() {
        return this.kilograms;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public abstract void eating();

}
