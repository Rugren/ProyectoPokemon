module ProyectoPokemon {
    requires javafx.fxml;
    requires javafx.controls;
    opens proyectoPokemon.model;
    opens proyectoPokemon.controller;
    opens proyectoPokemon.model.objeto;
    opens proyectoPokemon.model.movimiento;
}