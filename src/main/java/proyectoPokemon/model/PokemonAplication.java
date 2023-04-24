package proyectoPokemon.model;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;

import javafx.scene.Scene;

import javafx.stage.Stage;
import proyectoPokemon.model.movimiento.Movimiento;
import proyectoPokemon.model.objeto.Baston;

import java.io.IOException;

import java.util.Objects;

public class PokemonAplication extends Application {

    @Override

    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/hello.fxml")));
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
        Movimiento[] movimientosPikachu = new Movimiento[4];
        Baston p1 = new Baston("Baston");

        Pokemon pikachu = new Pokemon("pikachu", "Lolo", movimientosPikachu,Sexo.MACHO,Tipo.ELECTRICO, Estado.CENTRO_DE_ATENCION, p1);

    }

}
