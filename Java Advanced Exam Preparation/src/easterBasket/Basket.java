package easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
    List<Egg> data;
    String material;
    int capacity;

    public Basket(String materials, int capacity) {
        this.data = new ArrayList<>();
        this.material = materials;
        this.capacity = capacity;
    }

    public void addEgg(Egg egg) {
        if(data.size() < capacity){
        data.add(egg);
        }
    }


    public boolean removeEgg(String color) {
        Egg egg = this.getEgg(color);
        data.remove(egg);
        return egg!= null;
    }


    public Egg getStrongestEgg() {

    return data.stream().max(Comparator.comparing(Egg::getStrength)).orElse(null);
    }

    public Egg getEgg(String color) {
        return data.stream().filter(e -> e.getColor().equals(color)).findFirst().orElse(null);
    }

    public int getCount(){
        return data.size();
    }

    public String report() {
    StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%s basket contains:%n", material));

        data.forEach(egg -> stringBuilder.append(egg.toString()).append(String.format("%n")));

        return stringBuilder.toString().trim();
    }
}
