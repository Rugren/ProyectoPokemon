package org.proyectoPokemon.model;

import org.proyectoPokemon.database.PokemonCRUD;

import java.sql.SQLException;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws SQLException {
        /**
         * Recorremos la tabla pokedex de la base de datos y la metemos en una lista para
         * mostrarla por pantalla
         */
        LinkedList<Pokemon> miLista = (LinkedList<Pokemon>) PokemonCRUD.readPokemon();
        for (Pokemon p:miLista) {
            Pokemon.getPokedex().add(p);
        }

        PokemonCRUD.updatePokemon();

        /**
         * Con esto probamos la insercion de un pokemon en la base de datos
         */
        Pokemon p1 = new Pokemon(1,"lolo",Sexo.MACHO);
        PokemonCRUD.insertPokemon(p1);
        System.out.println(p1.toString());




    }
}
