package org.proyectoPokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainMenuController {
    @FXML
    private Button botonCerrarSesion;
    @FXML
    private Button botonEquipoPokemon;
    @FXML
    private Button botonCombate;
    @FXML
    private Button botonCapturar;
    @FXML
    private Button botonTienda;



    @FXML
    public void backWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/PokemonApplication.fxml")));
        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Menú principal.");
        stage.setScene(scene);
        stage.show();
    }

}
