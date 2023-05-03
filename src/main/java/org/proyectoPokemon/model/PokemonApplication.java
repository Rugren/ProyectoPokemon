package org.proyectoPokemon.model;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;

import javafx.scene.Scene;

import javafx.stage.Stage;
import org.proyectoPokemon.database.PokemonCRUD;

import java.io.IOException;

import java.util.LinkedList;
import java.util.Objects;

public class PokemonApplication extends Application {

    @Override

    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/PokemonApplication.fxml")));
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Inicio de sesión");
        stage.setScene(scene);
        stage.show();


    }



    public static void main(String[] args) {
        launch();
    }


}
