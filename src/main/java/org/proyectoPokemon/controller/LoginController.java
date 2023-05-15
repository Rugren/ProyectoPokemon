package org.proyectoPokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.proyectoPokemon.model.Entrenador;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    @FXML
    private Button botonLogin;
    @FXML
    private Button botonRegistrarse;
    @FXML
    private Label texto1;
    @FXML
    private Label texto2;

    @FXML
    private TextField user;

    @FXML
    private PasswordField password;

    @FXML
    public ImageView logo;

    @FXML
    private Label lblConectado;

    @FXML
    public void cambiarMenu (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/MainMenu.fxml")));
        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void login (ActionEvent event) throws IOException{
        if(Entrenador.entrenadornull()){
            lblConectado.setText("Debe registrarse primero.");
        }
        else if (user.getText().equals(Entrenador.getEntrenador().getNombre()) && password.getText().equals(Entrenador.getEntrenador().getPassword())){
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/MainMenu.fxml")));
            Scene scene = new Scene(root, 600, 400);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();
            lblConectado.setText("Conectado.");
        }else
            lblConectado.setText("Usuario o contraseña incorrectos.");
        //Logger.write("Inicio de sesion");
    }

    @FXML
    public void conectado(){
        lblConectado.setText("Conectado");
    }



    @FXML
    public void registrar (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/RegistroEntrenador.fxml")));
        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Menu principal");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void initialize (){

    }
}
