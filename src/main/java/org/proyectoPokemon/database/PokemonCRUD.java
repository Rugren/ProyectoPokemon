package org.proyectoPokemon.database;

import org.proyectoPokemon.model.Pokemon;
import org.proyectoPokemon.model.Tipo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PokemonCRUD {
    public static void createPokemon() {

    }

    public static List<Tipo> readPokemon() {
        String query = "SELECT * FROM TIPOS";

        PreparedStatement preparedStatement = null;
        LinkedList<Tipo> listaTipos = new LinkedList<>();
        try {
            preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
            //preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("nom_tipo");
                String tipo = resultSet.getString("id_tipo");
                listaTipos.add(Tipo.valueOf(tipo));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaTipos;
    }

    public static void updatePokemon() {

    }

    public static boolean deletePokemon() {
        return true;
    }
}
