package org.proyectoPokemon.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class EntrenadorTest {

    @Test
    public void capturar() {
        Pokemon p1 = new Pokemon(1,"si",Sexo.MACHO);
        Entrenador.getEntrenador().capturar(p1);
    }
}