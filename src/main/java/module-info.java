module ProyectoPokemon {
    requires javafx.fxml;
    requires javafx.controls;

    // Hemos sustituido el demofx por nuestra carpeta, org.javafx.model y org.javafx.controller
    //    opens org.demofx.model;
    //    opens org.demofx.controller;
    opens org.javafx.model;
    opens org.javafx.controller;

}