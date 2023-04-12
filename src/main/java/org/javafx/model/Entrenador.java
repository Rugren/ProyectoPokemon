package org.javafx.model;

import org.javafx.model.objeto.Objeto;

import java.util.LinkedList;

public class Entrenador {
    private LinkedList<Pokemon> equipoPokemon = new LinkedList<>();
    private LinkedList<Pokemon> grupoSecundario = new LinkedList<>();
    private String nombre;
    private int pokedollar;
    private LinkedList<Objeto> listaObjetos = new LinkedList<>();

    public Entrenador(LinkedList<Pokemon> equipoPokemon, LinkedList<Pokemon> grupoSecundario,
                      String nombre, int pokedollar, LinkedList<Objeto> listaObjetos) {
        this.equipoPokemon = equipoPokemon;
        this.grupoSecundario = grupoSecundario;
        this.nombre = nombre;
        this.pokedollar = pokedollar;
        this.listaObjetos = listaObjetos;
    }

    public LinkedList<Pokemon> getEquipoPokemon() {
        return equipoPokemon;
    }

    public void setEquipoPokemon(LinkedList<Pokemon> equipoPokemon) {
        this.equipoPokemon = equipoPokemon;
    }

    public LinkedList<Pokemon> getGrupoSecundario() {
        return grupoSecundario;
    }

    public void setGrupoSecundario(LinkedList<Pokemon> grupoSecundario) {
        this.grupoSecundario = grupoSecundario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPokedollar() {
        return pokedollar;
    }

    public void setPokedollar(int pokedollar) {
        this.pokedollar = pokedollar;
    }

    public LinkedList<Objeto> getListaObjetos() {
        return listaObjetos;
    }

    public void setListaObjetos(LinkedList<Objeto> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    //Funciones del entrenador
}
