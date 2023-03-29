package org.javafx.controller;

//import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
//import javafx.stage.Stage;

public class PokemonController {
    @FXML
    private Button btnCrear;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtNivel;


    //esto crear en pokemon:
//    private Pokemon

    @FXML
    public void setPokemonProperties(){
        String nombre = txtNombre.getText();
        int nivel = Integer.parseInt(txtNivel.getText()); //Integer.parseInt para que el int me lo pase a String.

     //   setPokemonProperties();

      //  pokemon.setNivel(nivel);
        // pokemon.setNombre(nombre);

 //       System.out.println("El pokemon " + pokemon.getNombre() + " tiene nivel: " + pokemon.getNivel());
        txtMsg.setText("El pokemon " + pokemon.getNombre() + " tiene nivel: " + pokemon.getNivel());

    }


}
