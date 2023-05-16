package org.proyectoPokemon.model;

import org.proyectoPokemon.database.PokemonCRUD;

import java.sql.SQLException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws SQLException {
        LinkedList<Pokemon> miLista = (LinkedList<Pokemon>) PokemonCRUD.readPokemon();
        for (Pokemon p:miLista) {
            Pokemon.getPokedex().add(p);
        }

        PokemonCRUD.updatePokemon();

        Pokemon p1 = new Pokemon(1,"lolo",Sexo.MACHO);
        PokemonCRUD.insertPokemon(p1);
        System.out.println(p1.toString());




    }
}
