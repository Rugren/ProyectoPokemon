package org.proyectoPokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Stage;
import org.proyectoPokemon.Logger;
import org.proyectoPokemon.model.Entrenador;
import org.proyectoPokemon.model.Pokemon;

import java.io.IOException;
import java.util.Objects;

public class PonerMoteController {
    @FXML
    private TextField mote;
    @FXML
    private Label lblMensaje;

    @FXML
    private Button botonAceptar;

    @FXML
    public String validaMote(ActionEvent event) throws IOException {
        String validaMote = mote.getText();
        if (validaMote.matches("puta") ||
                validaMote.matches("polla") ||
                validaMote.matches("putas") ||
                validaMote.matches("pollas") ||
                validaMote.matches("gilipollas") ||
                validaMote.matches("tonto") ||
                validaMote.matches("inutil")){
            lblMensaje.setText("El mote tiene una palabra malsonante");
        }else
            addMote(validaMote);
        return validaMote;


    }
    @FXML
    public void addMote(String moteNuevo) throws IOException {
        Entrenador.getListaPokemon().get(Entrenador.getListaPokemon().size()- 1).setMote(moteNuevo);
        Stage stage = (Stage) botonAceptar.getScene().getWindow();
        stage.close();
        Logger log = new Logger();
        log.logger("Has capturado al pokemon :" + (Entrenador.getListaPokemon().get(Entrenador.getListaPokemon().size()-1)));
    }

    @FXML
    public void aceptarMote(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/CapturarPokemon.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Poner mote.");
        stage.setScene(scene);
        stage.show();

    }
}
