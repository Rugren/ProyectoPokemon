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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.proyectoPokemon.model.Entrenador;

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
    private Label numPokedollars;
    @FXML
    private ImageView logo;

    /**
     * con este boton cerramos sesion y volvemos a la pagina de login
     * @param event
     * @throws IOException
     */
    @FXML
    public void cerrarSesion(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/PokemonApplication.fxml")));
        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Menú principal.");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Metodo que se acciona al pulsar el boton de Capturar pokemon y cambiamos a la ventana
     * de captura
     * @param event
     * @throws IOException
     */
    @FXML
    public void ventanaCapturarPokemon(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/CapturarPokemon.fxml")));
        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Captura un pokemon.");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Se acciona el metodo al pulsar el boton de Ir a la tienda y se cambia de ventana
     * a la ventana Tienda
     * @param event
     * @throws IOException
     */
    @FXML
    public void ventanaTienda(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/TiendaPokemon.fxml")));
        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Captura un pokemon.");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Al accionar el boton de COmbate Pokemon cambiaremos de ventana a la ventana de Combate
     * @param event
     * @throws IOException
     */
    @FXML
    public void ventanaCombate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/MiEquipoPokemon.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Mi equipo Pokemon");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Para ir a la ventana de Mi equipo pokemon accionaremos el boton Mi equipo Pokemon
     * @param event
     * @throws IOException
     */
    @FXML
    public void ventanaMiEquipoPokemon(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/MiEquipoPokemon.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Mi equipo Pokemon");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * En el initialize se cargan los datos de los Pokedollars de nuestro entrenador
     */
    @FXML
    public void initialize(){
        numPokedollars.setText("Pokedollars: " + Entrenador.getEntrenador().getPokedollar() + "$");
    }

}
