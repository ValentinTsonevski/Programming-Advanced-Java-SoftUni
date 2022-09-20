package aquarium;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Aquarium {
    private Map<String,Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new HashMap<>();
    }


    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }
    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add(Fish fish){
        if(this.fishInPool.size() < this.capacity){
        fishInPool.putIfAbsent(fish.getName(),fish);
        }
    }

    public boolean remove(String name){
        if(fishInPool.containsKey(name)){
            fishInPool.remove(name);
            return  true;
        }
        return false;
    }

    public Fish findFish(String name){

           return fishInPool.get(name);
    }

    public String report(){

     StringBuilder stringBuilder = new StringBuilder();

     stringBuilder.append(String.format("Aquarium: %s ^ Size: %s%n",this.name,this.size));

     stringBuilder.append(this.fishInPool.values().stream().map(Fish::toString).collect(Collectors.joining(", ")));

     return stringBuilder.toString().trim();
    }

}
