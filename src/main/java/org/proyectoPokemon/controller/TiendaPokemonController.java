package org.proyectoPokemon.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.proyectoPokemon.model.Entrenador;
import org.proyectoPokemon.model.objeto.Objeto;
import org.proyectoPokemon.model.objeto.TipoObjeto;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;

public class TiendaPokemonController {
    @FXML
    private Button botonVolver;
    @FXML
    private Button botonComprarPokeball;
    @FXML
    private ImageView pokemonLogo;
    @FXML
    private ImageView pokeballImage;
    @FXML
    private ListView<Objeto> listaObjetos = new ListView<>();
    @FXML
    private Label lblPokeballs;
    @FXML
    private Label lblPokedollars;

    /**
     * Volver al menu accionando el boton de Volver
     * @param event
     * @throws IOException
     */
    @FXML
    public void volverMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/MainMenu.fxml")));
        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Menú principal.");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Con este metodo compramos pokeballs para nuestro entrenador accionado el boton
     */
    @FXML
    public void comprarPokeball(){
        if (Entrenador.getEntrenador().comprarPokeball()){
            lblPokeballs.setText("Pokeballs: " + Entrenador.getEntrenador().getPokeballs());
            lblPokedollars.setText("Pokeballs: " + Entrenador.getEntrenador().getPokedollar());
        }
    }

    /**
     * En el initialize cargamos los atributos de Pokedollars y Pokeballs de nuestro entrenador
     */
    @FXML
    public void initialize(){
        lblPokeballs.setText("Pokeballs: " + Entrenador.getEntrenador().getPokeballs());
        lblPokedollars.setText("Pokeballs: " + Entrenador.getEntrenador().getPokedollar());
        Objeto o1 = new Objeto("Pluma", TipoObjeto.PLUMA);
        Objeto o2 = new Objeto("chaleco", TipoObjeto.CHALECO);
        Objeto o3 = new Objeto("Pesa", TipoObjeto.PESA);
        Objeto o4 = new Objeto("Pilas", TipoObjeto.PILAS);
    }
}
