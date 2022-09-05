package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges = 0;
    private List<Pokemon> pokemonList = new ArrayList<>();

    public Trainer(String name, int numberOfBadges, List<Pokemon> pokemonList) {
        this.name = name;
        this.numberOfBadges = numberOfBadges;
        this.pokemonList = pokemonList;
    }

    public Trainer(String name) {
        this.name = name;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    public boolean hasElement(String element) {
        return this.pokemonList.stream().anyMatch(s -> s.getElement().equals(element));
    }

    public void applyCommand(String element) {
        if (hasElement(element)) {
            this.numberOfBadges++;
        } else {
            this.pokemonList.forEach(Pokemon::looseHealth);
            this.pokemonList.removeIf(Pokemon::isDead);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    @Override
    public String toString() {
        return name + " " + numberOfBadges + " " + pokemonList.size();
    }
}
