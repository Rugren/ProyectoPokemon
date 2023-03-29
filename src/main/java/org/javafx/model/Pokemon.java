package org.javafx.model;

public class Pokemon {
    private String nombre;
    private int nivel;

    public Pokemon(String nombre, int nivel){
        this.nivel = nivel;
        this.nombre = nombre;
    }
    /*
    public Pokemon(String nombre, int nivel) {
        this.nivel = 1;
        this.nombre = nombre;
    }
    */

    // Los métodos get y set de: nombre y nivel.
    public String getNombre(){
        return nombre;
    }
    public int getNivel(){
        return nivel;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }




}
