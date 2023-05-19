package org.proyectoPokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.proyectoPokemon.Logger;
import org.proyectoPokemon.database.PokemonCRUD;
import org.proyectoPokemon.model.Entrenador;
import org.proyectoPokemon.model.Pokemon;
import org.proyectoPokemon.model.Sexo;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class CapturarPokemonController {

    @FXML
    private Button botonCapturar;
    @FXML
    private Label numPokeballs;
    @FXML
    private Label numPokedollars;
    @FXML
    private Label mensajeCapturado;
    @FXML
    private ImageView pokeball;


    /**
     * El metodo volver para ir al Menu principal
     * @param event
     * @throws IOException
     */
    @FXML
    public void volver(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/MainMenu.fxml")));
        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Menú principal.");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Para cargar los atributos del Entrenador en los Label
     */
    @FXML
    public void initialize(){
        numPokedollars.setText("Pokedollars: " + Entrenador.getEntrenador().getPokedollar() + "$");
        numPokeballs.setText("Pokeballs: " + Entrenador.getEntrenador().getPokeballs());
        PokemonCRUD.readPokemon();
    }

    /**
     * Con este metodo compronbamos si se puede capturar o no al pokemon y salta la ventana
     * emergente para poner mote al pokemon capturado
     * @param event
     * @throws IOException
     */
    @FXML
    public void capturar(ActionEvent event) throws IOException {
        Random rnd = new Random();
        int numAleatorio = rnd.nextInt(19); //tamaño de la listaPokedex
        if(Entrenador.getEntrenador().getPokeballs() == 0){
            mensajeCapturado.setText("Ya no te quedan Pokeballs. Compra más en la tienda");
        }else if (Entrenador.getEntrenador().capturar(PokemonCRUD.readPokemon().get(numAleatorio))){
            mensajeCapturado.setText("Pokemon Capturado");
            numPokeballs.setText("Pokeballs: " + Entrenador.getEntrenador().getPokeballs());
            ventanaMote();
        }else
            mensajeCapturado.setText("Pokemon no capturado");



    }

    /**
     * Con este metodo se cammbia de ventana a la ventana de poner mote al pokemon
     * @throws IOException
     */
    @FXML
    public void ventanaMote() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/PonerMote.fxml")));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Añadir mote al pokemon.");
        stage.setScene(scene);
        stage.showAndWait();
    }

}

