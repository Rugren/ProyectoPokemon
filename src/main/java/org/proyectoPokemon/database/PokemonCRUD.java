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
        String query = "SELECT P.NOM_POKEMON, T.NOM_TIPO AS TIPO, T2.NOM_TIPO AS TIPO2\n" +
                "FROM pokedex P\n" +
                "INNER JOIN TIPOS T\n" +
                "\tON T.ID_TIPO = P.TIPO1\n" +
                "JOIN TIPOS T2\n" +
                "\tON T2.ID_TIPO = P.TIPO2";

        PreparedStatement preparedStatement = null;
        LinkedList<Pokemon> listaPokemon = new LinkedList<>();
        try {
            preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
            //preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nomPokemon = resultSet.getString("NOM_POKEMON");
                String tipo1 = resultSet.getString("TIPO");
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
