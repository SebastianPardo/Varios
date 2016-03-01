package co.edu.unal.ds.main;

import java.util.Comparator;
import java.util.Random;

import co.edu.unal.ds.list.ShuffleList;
import co.edu.unal.ds.pokemon.*;

public class ShufflePokemon {

    public static PokemonLevelComparator LV = new PokemonLevelComparator();
    public static PokemonNameComparator NAME = new PokemonNameComparator();

    public static Pokemon getRandomPokemon() {
        Random r = new Random();
        int randomInt = r.nextInt(4);
        if (randomInt == 0) {
            return new Flareon();
        } else if (randomInt == 1) {
            return new Wartortle();
        } else if (randomInt == 2) {
            return new Venasaur();
        } else {
            return new MrMime();
        }
    }

    public static void main(String args[]) {
        ShuffleList<Pokemon> listPokemon = new ShuffleList<Pokemon>();
        for (int i = 0; i < 10; i++) {
            listPokemon.add(i, getRandomPokemon());
        }
        System.out.println("List Original");
        System.out.println(listPokemon);
        System.out.println("List suffle");
        listPokemon.toShuffle();
        System.out.println(listPokemon);
        System.out.println("Ordening ascending by PokeId");
        listPokemon.sort();
        System.out.println(listPokemon);
        System.out.println("Ordering ascending by level");
        listPokemon.sort(LV);
        System.out.println(listPokemon);
        System.out.println("Ordering ascending by name");
        listPokemon.sort(NAME);
        System.out.println(listPokemon);
    }

    static class PokemonLevelComparator implements Comparator<Pokemon> {

        @Override
        public int compare(Pokemon a, Pokemon b) {
            return (a.getLevel() - b.getLevel());
        }
    }

    static class PokemonNameComparator implements Comparator<Pokemon> {

        @Override
        public int compare(Pokemon a, Pokemon b) {
            return a.getPokeName().compareToIgnoreCase(b.getPokeName());
        }
    }
}
