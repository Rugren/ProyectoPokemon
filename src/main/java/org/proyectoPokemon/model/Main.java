package org.proyectoPokemon.model;

import org.proyectoPokemon.database.PokemonCRUD;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Pokemon> miLista = (LinkedList<Pokemon>) PokemonCRUD.readPokemon();
        for (Pokemon p:miLista) {
            Pokemon.getPokedex().add(p);
        }

        PokemonCRUD.updatePokemon();
    }
}
