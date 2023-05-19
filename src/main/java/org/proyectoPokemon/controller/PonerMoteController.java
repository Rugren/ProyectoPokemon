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
import org.proyectoPokemon.database.PokemonCRUD;
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

    /**
     * Con este metodo validaremos el mote de nuestro Pokemon y usaremos expresiones regulares
     * para controlar palabras malsonantes, saltandonos un aviso sobre nuestro mote
     * @param event
     * @return
     * @throws IOException
     */
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

    /**
     * Si el mote es valido, se le añade al pokemon y este pasa a ser capturado agregandolo a la
     * caja del entrenador
     * Ademas el Logger registra todos los pokemon capturados
     * @param moteNuevo
     * @throws IOException
     */
    @FXML
    public void addMote(String moteNuevo) throws IOException {
        Entrenador.getListaPokemon().get(Entrenador.getListaPokemon().size()- 1).setMote(moteNuevo);
        Stage stage = (Stage) botonAceptar.getScene().getWindow();
        stage.close();
        Logger log = new Logger();
        log.logger("Has capturado al pokemon :" + (Entrenador.getListaPokemon().get(Entrenador.getListaPokemon().size()-1)));
    }

    /**
     *
     * @param event
     * @throws IOException
     */
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
