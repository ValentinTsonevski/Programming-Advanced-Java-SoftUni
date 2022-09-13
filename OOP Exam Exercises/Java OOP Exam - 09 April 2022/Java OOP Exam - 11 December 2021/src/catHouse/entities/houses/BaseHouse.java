package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT;
import static catHouse.common.ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseHouse implements House{

    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public void setName(String name) {

        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
       this.name = name;
    }

    @Override
    public int sumSoftness() {
        return toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {

        if(this.capacity <= cats.size()){
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
     cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
    cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s:",this.name,getClass().getSimpleName()));
        sb.append(System.lineSeparator());
        if(cats.isEmpty()){
            sb.append("Cats: none");
            sb.append(System.lineSeparator());
        }else{
            sb.append("Cats: ").append(this.cats.stream().map(Cat::getName).collect(Collectors.joining(" ")));
            sb.append(System.lineSeparator());
        }
        sb.append(String.format("Toys: %d Softness: %d",toys.size(),sumSoftness()));
        return sb.toString();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Cat> getCats() {
        return Collections.unmodifiableCollection(cats);
    }

    @Override
    public Collection<Toy> getToys() {
        return Collections.unmodifiableCollection(toys);
    }
}
