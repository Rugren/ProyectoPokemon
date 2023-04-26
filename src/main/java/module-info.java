module ProyectoPokemon {
    requires javafx.fxml;
    requires javafx.controls;
    requires org.junit.jupiter.api;
    opens proyectoPokemon.model;
    opens proyectoPokemon.controller;
    opens proyectoPokemon.model.objeto;
    opens proyectoPokemon.model.movimiento;
}