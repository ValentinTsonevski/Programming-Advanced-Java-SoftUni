package parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }


    public void add(Parrot parrot) {

        if(this.data.size() < this.capacity){
            this.data.add(parrot);
        }
    }


    public boolean remove(String name) {

        for (Parrot parrot : this.data) {
            if(parrot.getName().equals(name)){
                this.data.remove(parrot);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name){
        for (Parrot parrot : this.data) {
            if (parrot.getName().equals(name)){
              parrot.setAvailable(false);
            return parrot;
            }
        }
        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species){

        List<Parrot> sortedBySpeciesParrots = new ArrayList<>();

        this.data.stream().filter(parrot -> parrot.getSpecies().equals(species)).forEach(parrot -> parrot.setAvailable(false));
        this.data.stream().filter(parrot -> parrot.getSpecies().equals(species)).forEach(sortedBySpeciesParrots::add);

        return sortedBySpeciesParrots;
    }

    public int count(){
        return this.data.size();
    }


    public String report() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("Parrots available at %s:%n",this.name));

        data.forEach(parrot -> stringBuilder.append(parrot.isAvailable()).append(String.format("%n")));

        return stringBuilder.toString().trim();
    }

}
