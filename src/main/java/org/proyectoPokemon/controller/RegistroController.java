package org.proyectoPokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RegistroController {
    @FXML
    private TextField user;
    @FXML
    private PasswordField password;

    @FXML
    private Label texto1;
    @FXML
    private Label texto2;
    @FXML
    private Button botonRegistrarse;

    @FXML
    public void registrarse (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/MainMenu.fxml")));
        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Menu principal");
        stage.setScene(scene);
        stage.show();

    }



}
