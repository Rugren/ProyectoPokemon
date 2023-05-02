module javafx {
    requires javafx.fxml;
    requires javafx.controls;
    requires org.junit.jupiter.api;

    opens org.proyectoPokemon.model;
    opens org.proyectoPokemon.controller;
}