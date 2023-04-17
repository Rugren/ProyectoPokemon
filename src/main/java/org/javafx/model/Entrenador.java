package org.javafx.model;

import org.javafx.model.objeto.Objeto;

import java.util.LinkedList;
import java.util.Random;

public class Entrenador {
    private Pokemon[] equipoPokemon = new Pokemon[5];
    private Pokemon[] grupoSecundario = new Pokemon[5];
    private String nombre;
    private int pokedollars;
    private Objeto[] listaObjetos = new Objeto[4];

    public Entrenador(String nombre, Pokemon[] equipoPokemon, Pokemon[] grupoSecundario,
                      Objeto[] listaObjetos) {
        Random rnd = new Random();
        this.equipoPokemon = equipoPokemon;
        this.grupoSecundario = grupoSecundario;
        this.nombre = nombre;
        this.pokedollars = rnd.nextInt(800,1000);
        this.listaObjetos = listaObjetos;
    }

    public Pokemon[] getEquipoPokemon() {
        return equipoPokemon;
    }

    public void setEquipoPokemon(Pokemon[] equipoPokemon) {
        this.equipoPokemon = equipoPokemon;
    }

    public Pokemon[] getGrupoSecundario() {
        return grupoSecundario;
    }

    public void setGrupoSecundario(Pokemon[] grupoSecundario) {
        this.grupoSecundario = grupoSecundario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPokedollars() {
        return pokedollars;
    }

    public void setPokedollars(int pokedollars) {
        this.pokedollars = pokedollars;
    }

    public Objeto[] getListaObjetos() {
        return listaObjetos;
    }

    public void setListaObjetos(Objeto[] listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    //Funciones del entrenador

    public void moverACajaPrincipal(){

    }
    public void moverACajaSecundaria(){

    }

    public static Pokemon entrenarPokemon(Pokemon pokemon){
        return Pokemon;
    }

    public void entrenamientoPesado();
