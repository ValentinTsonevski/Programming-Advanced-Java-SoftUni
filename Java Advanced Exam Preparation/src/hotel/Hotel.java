package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person){
      if(this.roster.size() < this.capacity){
        this.roster.add(person);
      }
    }

    public boolean remove(String name){
        for (Person person : this.roster) {
            if(person.getName().equals(name)){
                roster.remove(person);
                return true;
            }
        }
        return false;
    }

    public Person getPerson(String name,String hometown){
        for (Person person : this.roster) {
            if(person.getName().equals(name) && person.getHometown().equals(hometown)){
                return person;
            }
        }
        return null;
    }

    public int getCount(){
        return roster.size();
    }

    public String getStatistics(){
       StringBuilder sb = new StringBuilder();

        sb.append(String.format("The people in the hotel %s are:%n",name));
        this.roster.forEach(person -> sb.append(person).append(String.format("%n")));

        return sb.toString().trim();
    }
}
