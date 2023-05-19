package org.proyectoPokemon.model;

import org.junit.Test;
import org.proyectoPokemon.model.movimiento.Movimiento;
import org.proyectoPokemon.model.movimiento.MovimientoDeAtaque;

import static org.junit.Assert.*;

public class PokemonTest {

    @Test
    public void subirNivel() {
        Pokemon p1 = new Pokemon("mikel",100);
        p1.subirNivel();
    }

    @Test
    public void aprenderMovimiento() {
        Movimiento m1 = new MovimientoDeAtaque("impaktrueno",10,Tipo.ELECTRICO);
        Movimiento[] listaP1 = new Movimiento[3];
        Pokemon p1 = new Pokemon("mikel",Tipo.ELECTRICO, Tipo.AGUA,listaP1);
        p1.aprenderMovimiento(m1);
    }

    @Test
    public void quitarmoviento() {

    }

    @Test
    public void descansar() {
        Pokemon p1 = new Pokemon("mikel",12);
        p1.setEstamina(0);
        p1.descansar();

    }

    @Test
    public void comprobarVentaja() {
        Pokemon p1 = new Pokemon("mikel", Tipo.ELECTRICO,Tipo.AGUA);
        Pokemon p2 = new Pokemon("ruben", Tipo.AGUA,Tipo.AGUA);
        p1.comprobarVentaja(p2);
    }
}