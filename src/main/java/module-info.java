module ProyectoPokemon {
    requires javafx.fxml;
    requires javafx.controls;
    requires org.junit.jupiter.api;
    requires java.sql;
    requires javafx.graphics;

    opens org.proyectoPokemon.model;
    opens org.proyectoPokemon.controller;

}