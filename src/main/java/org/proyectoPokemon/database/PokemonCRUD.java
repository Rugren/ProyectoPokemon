package org.proyectoPokemon.database;

import org.proyectoPokemon.model.Pokemon;
import org.proyectoPokemon.model.Tipo;

import java.sql.*;
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

    public static void insertPokemon(Pokemon pokemon){

        Statement preparedStatement = null;
        try {
            String query = "INSERT INTO POKEMON (ID_POKEDEX, MOTE, SEXO, ATAQUE, AT_ESPECIAL,DEFENSA," +
                    "DEF_ESPECIAL, ESTAMINA, FERTILIDAD, VITALIDAD, NIVEL, EXPERIENCIA, VELOCIDAD ) " +
                    "VALUES (" + pokemon.getIdPokedex() + ", " + "'" + pokemon.getMote() + "',"
                     + " '" + pokemon.getSexoString() + "', " +
                        pokemon.getAtaque() + ", " +
                        pokemon.getAtaqueEspecial() + ", " +
                        pokemon.getDefensa() + ", " +
                        pokemon.getDefensaEspecial() + ", " +
                        pokemon.getEstamina() + ", " +
                        pokemon.getFertilidad() + ", " +
                        pokemon.getVitalidad() + ", " +
                        pokemon.getNivel() + ", " +
                        pokemon.getNivelExperiencia() + ", " +
                        pokemon.getVelocidad() + ");";
            preparedStatement = MySQLConnection.getConnection().createStatement();
            int i = preparedStatement.executeUpdate(query);
            if (i > 0) {
                System.out.println("ROW INSERTED");
            } else
                System.out.println("ROW NOT INSERTED");
            /*preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, pokemon.getIdPokemon());
            preparedStatement.setInt(2, pokemon.getTipo1().ordinal());
            preparedStatement.setInt(2, pokemon.getIdPokedex());
            preparedStatement.setString(3, pokemon.getMote());*/
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void updatePokemon() {
        System.out.println(Pokemon.getPokedex());
    }

    public static Tipo getTipo1(int idPokedex){
        String Tipo1 = "";
        String query = "SELECT t1.NOM_TIPO as TIPO1\n" +
                "FROM pokedex P\n" +
                "JOIN tipos t1\n" +
                "on t1.ID_TIPO = p.TIPO1\n" +
                "WHERE ID_POKEDEX = " + idPokedex ;

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Tipo1 = resultSet.getString("TIPO1");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Tipo.valueOf(Tipo1);
    }
    public static boolean deletePokemon() {
        return true;
    }
}
