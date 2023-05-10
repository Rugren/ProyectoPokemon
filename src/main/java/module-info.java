module ProyectoPokemon {
    requires javafx.fxml;
    requires javafx.controls;
    requires org.junit.jupiter.api;
    requires java.sql;

    opens org.proyectoPokemon.model;
    opens org.proyectoPokemon.controller;

}