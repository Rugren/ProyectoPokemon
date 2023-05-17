package org.proyectoPokemon.model;

import org.junit.Test;
import org.proyectoPokemon.model.objeto.Objeto;
import org.proyectoPokemon.model.objeto.TipoObjeto;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class EntrenadorTest {

    @Test
    public void entrenarPokemon() {
        Pokemon pokemon1 = new Pokemon("Poke1","kk", Sexo.MACHO,Tipo.ELECTRICO,null);
        Pokemon pokemon2 = new Pokemon("Poke2","pp", Sexo.MACHO,Tipo.ELECTRICO,null);
        Pokemon[] lista1 = new Pokemon[4];
        Pokemon[] lista2 = new Pokemon[4];


        Objeto cuch = new Objeto ("cuchillo", TipoObjeto.PESA);
        Objeto[] listaObjetos = new Objeto[10];

        Entrenador rubens = new Entrenador("Ruben", "Hola123", lista1, lista2, 900, listaObjetos);

        System.out.println("El " + Entrenador.getEntrenador().getNombre() + " ha sido creado");

        rubens.entrenarPokemon(pokemon1, TipoEntrenamiento.PESADO);
        System.out.println(Entrenador.getEntrenador().getNombre() + " ha entrenado a " + pokemon1.getNombre()
                + " con entrenamiento de tipo: " + TipoEntrenamiento.PESADO //que devuelva el nombre);

    }
}