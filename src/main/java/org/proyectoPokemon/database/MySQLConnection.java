package org.proyectoPokemon.database;

import java.sql.*;

public class MySQLConnection {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
            if (connection == null)
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon",
                        "root","");
            return connection;
    }
}
