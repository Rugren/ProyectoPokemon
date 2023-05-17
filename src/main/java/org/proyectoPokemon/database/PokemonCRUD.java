package org.proyectoPokemon.database;

import org.proyectoPokemon.model.Pokemon;
import org.proyectoPokemon.model.Tipo;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PokemonCRUD {

    /**
     * Método que devuelve una lista con todos los pokemon y sus tipos
     * @return
     */
    public static List<Pokemon> readPokemon() {
        String query = "SELECT P.NOM_POKEMON, T.NOM_TIPO AS TIPO, T2.NOM_TIPO AS TIPO2\n" +
                "FROM pokedex P\n" +
                "JOIN TIPOS T\n" +
                "ON T.ID_TIPO = P.TIPO1\n" +
                "left JOIN TIPOS T2\n" +
                "ON T2.ID_TIPO = P.TIPO2";

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
                listaPokemon.add(new Pokemon(nomPokemon,Tipo.valueOf(tipo1)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaPokemon;
    }


    /**
     * Método para insertar un Pokemon en la base de datos pokemon.
     * @param pokemon
     */
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

    /**
     * Metodo para coger el nombre de ka tabla Pokedex y aplicarselo al constructor de la clase
     * Pokemon
     * @param idPokedex
     * @return
     */
    public static String getNombre(int idPokedex){
        String query = "select pokedex.NOM_POKEMON as NOM_POKEMON\n" +
                "from pokedex\n" +
                "where pokedex.ID_POKEDEX=" + idPokedex ;

        PreparedStatement preparedStatement = null;
        String nomPokemon = null;
        try {
            preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                nomPokemon = resultSet.getString("NOM_POKEMON");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return nomPokemon;
    }

    /**
     * Con este método seleccionamos el nombre del tipo de la tabla Tipos para aplicarselo
     * al constructor de la clase Pokemon
     * @param idPokedex
     * @return
     */
    public static Tipo getTipo1(int idPokedex){
        String query = "SELECT t1.NOM_TIPO as TIPO1\n" +
                "FROM pokedex P\n" +
                "JOIN tipos t1\n" +
                "on t1.ID_TIPO = p.TIPO1\n" +
                "WHERE ID_POKEDEX = " + idPokedex ;

        PreparedStatement preparedStatement = null;
        String tipo1 = null;
        try {
            preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tipo1 = resultSet.getString("TIPO1");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Tipo.valueOf(tipo1);
    }

    /**
     * con este método realizamos exactamente el mismo proceso que con el PokemonCRUD.getTipo1
     * @param idPokedex
     * @return
     */
    public static Tipo getTipo2(int idPokedex) {

        String query = "SELECT t2.NOM_TIPO as TIPO2\n" +
                "FROM pokedex P\n" +
                "JOIN tipos t2\n" +
                "on t2.ID_TIPO = p.TIPO2\n" +
                "WHERE ID_POKEDEX = " + idPokedex;

        PreparedStatement preparedStatement = null;

        String tipo2 = null;
        try {
            preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tipo2 = resultSet.getString("TIPO2");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Tipo.valueOf(tipo2);
    }
    public static boolean deletePokemon() {
        return true;
    }
}
