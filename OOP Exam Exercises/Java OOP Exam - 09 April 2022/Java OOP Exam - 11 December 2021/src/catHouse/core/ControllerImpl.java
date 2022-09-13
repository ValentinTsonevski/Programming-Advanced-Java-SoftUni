package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;

        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;

            case "LongHouse":
                house = new LongHouse(name);
                break;

            default:
                throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        houses.add(house);

        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE,type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;

        switch (type) {
            case "Ball":
                toy = new Ball();
                break;

            case "Mouse":
                toy = new Mouse();
                break;

            default:
                throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        toys.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE,type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        House house = createHouseByName(houseName);
        Toy toy = toys.findFirst(toyType);

        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }

        if (house != null) {
            house.buyToy(toy);
            toys.removeToy(toy);
        }
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        House house = createHouseByName(houseName);
        Cat cat;

        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;

            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;

            default:
                throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }

        if ((cat instanceof ShorthairCat && house instanceof ShortHouse) ||
                (cat instanceof LonghairCat && house instanceof LongHouse)) {
            house.addCat(cat);
        } else {
            return UNSUITABLE_HOUSE;
        }

        return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    private House createHouseByName(String houseName) {
        return this.houses.stream().filter(house1 -> house1.getName().equals(houseName)).findFirst().orElse(null);
    }

    @Override
    public String feedingCat(String houseName) {
        House house = createHouseByName(houseName);
        Collection<Cat> cats = house.getCats();

        int counter = 0;
        for (Cat cat : cats) {
            cat.eating();
            counter++;
        }

        return String.format(FEEDING_CAT, counter);
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = createHouseByName(houseName);
        double value = 0;
        Collection<Cat> cats = house.getCats();
        Collection<Toy> toys = house.getToys();

        for (Cat cat : cats) {
            value += cat.getPrice();
        }

        for (Toy toy : toys) {
            value += toy.getPrice();
        }

        return String.format(VALUE_HOUSE,houseName,value);
    }

    @Override
    public String getStatistics() {
        return this.houses.stream().map(House::getStatistics).collect(Collectors.joining(System.lineSeparator()));
    }
}
