package org.proyectoPokemon.database;

import org.proyectoPokemon.model.Pokemon;
import org.proyectoPokemon.model.PokemonApplication;
import org.proyectoPokemon.model.Tipo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PokemonCRUD {
    public static void createPokemon() {

    }

    public static List<Pokemon> readPokemon() {
        String query = "SELECT p.NOM_POKEMON,t.NOM_TIPO as TIPO1,t.NOM_TIPO as TIPO2\n" +
                "from pokedex p\n" +
                "inner JOIN tipos t\n" +
                "on t.ID_TIPO = p.TIPO1";

        PreparedStatement preparedStatement = null;
        LinkedList<Pokemon> listaPokemon = new LinkedList<>();
        try {
            preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
            //preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nomPokemon = resultSet.getString("NOM_POKEMON");
                String tipo1 = resultSet.getString("TIPO1");
                String tipo2 = resultSet.getString("TIPO2");
                listaPokemon.add(new Pokemon(nomPokemon,Tipo.valueOf(tipo1),Tipo.valueOf(tipo2)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaPokemon;
    }

    public static void updatePokemon() {
        System.out.println(Pokemon.getPokedex());
    }

    public static boolean deletePokemon() {
        return true;
    }
}
