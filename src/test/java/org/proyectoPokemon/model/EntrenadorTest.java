package org.proyectoPokemon.model;

import org.junit.Test;
import org.proyectoPokemon.model.objeto.Objeto;
import org.proyectoPokemon.model.objeto.TipoObjeto;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class EntrenadorTest {

    @Test
    public void entrenarPokemon() { //Método entrenar funciona correctamente.
        Pokemon pokemon1 = new Pokemon("Poke1","kk", Sexo.MACHO,Tipo.ELECTRICO,Tipo.FUEGO);
        Pokemon pokemon2 = new Pokemon("Poke2","pp", Sexo.HEMBRA,Tipo.FUEGO,Tipo.VOLADOR);
        Pokemon[] lista1 = new Pokemon[4];
        Pokemon[] lista2 = new Pokemon[4];

        Objeto cuch = new Objeto ("cuchillo", TipoObjeto.PESA);
        Objeto[] listaObjetos = new Objeto[10];

        Entrenador rubens = new Entrenador("Ruben", "Hola123", lista1, lista2, 900, listaObjetos);
        System.out.println("El entrenador: " + rubens.getNombre() + " ha sido creado");

        rubens.entrenarPokemon(pokemon1, TipoEntrenamiento.PESADO); // aquí lo ha entrenado
        System.out.println("El " + rubens.getNombre() + " ha entrenado a " + pokemon1.getNombre()
                + " con entrenamiento de tipo: " + TipoEntrenamiento.PESADO); //que devuelva el nombre

    }

    @Test
    public void moverPokemonACaja() {
        Pokemon pokemon3 = new Pokemon("Pokemon3","ruu", Sexo.MACHO,Tipo.FUEGO,null);
        Pokemon pokemon4 = new Pokemon("Pokemon4","mik", Sexo.MACHO,Tipo.FANTASMA,Tipo.BICHO);
        Pokemon pokemon5 = new Pokemon("Pokemon5","picapi", Sexo.HEMBRA,Tipo.ROCA,Tipo.TIERRA);
        Pokemon pokemon6 = new Pokemon("Pokemon6","", Sexo.HEMBRA,Tipo.VENENO,null);

        Pokemon[] equipoPokemonRuben = new Pokemon[5];
        equipoPokemonRuben[0] = pokemon3; // metido pokemon3 en el equipoPokemonRuben en la posición[0] 1. //1.1
        equipoPokemonRuben[2] = pokemon4; // metido pokemon4 en el equipoPokemonRuben en la posición[2] 3.
//        System.out.println("Equipo Pokemon Ruben: " + Arrays.deepToString(equipoPokemonRuben)); // muestra los huecos llenos y los vacíos

        Pokemon[] equipoSecundarioRuben = new Pokemon[6];
        equipoSecundarioRuben[2] = pokemon5; // metido pokemon5 en el equipoSecundarioRuben en la posición[2] 3. //1.2
        equipoSecundarioRuben[3] = pokemon6; // metido pokemon6 en el equipoSecundarioRuben en la posición[3] 4.
//        System.out.println("Equipo Secundario Ruben: " + Arrays.deepToString(equipoSecundarioRuben)); // muestra los huecos llenos y los vacíos

        Objeto tijera = new Objeto ("tijeras", TipoObjeto.PESA);
        Objeto[] listaObjetosDeRuben = new Objeto[5];

        Entrenador rubens2 = new Entrenador("Ruben", "Hola123", equipoPokemonRuben, equipoSecundarioRuben, 900, listaObjetosDeRuben); //1.0
        System.out.println("1.0 " + "El entrenador: " + rubens2.getNombre() + " ha sido creado");

        System.out.println("Equipo Pokemon del entrenador: " + rubens2.getNombre() + ": " + Arrays.deepToString(equipoPokemonRuben)); // muestra los huecos llenos y los vacíos
        System.out.println("Equipo Secundario del entrenador: " + rubens2.getNombre() + ": " + Arrays.deepToString(equipoSecundarioRuben)); // muestra los huecos llenos y los vacíos

        System.out.println("1.1 " + "El entrenador " + rubens2.getNombre() + " ha añadido a " + pokemon3.getNombre() + " [" + pokemon3.getMote() + "]" + " a su equipo: " + "equipoPokemonRuben"); // como el equipoPokemon y el equipoSecundario no tienen nombre como tal, lo hemos entrecomillado para saber el nombre
        System.out.println("1.2 " + "El entrenador " + rubens2.getNombre() + " ha añadido a " + pokemon5.getNombre() + " [" + pokemon5.getMote() + "]" + " al equipo secundario: " + "equipoSecundarioRuben"); // como el equipoPokemon y el equipoSecundario no tienen nombre como tal, lo hemos entrecomillado para saber el nombre

        rubens2.moverPokemonACaja(0);
/*
        Si en rubens2.moverPokemonACaja pongo una posición que no está con un pokemon, ( por ejemplo: rubens2.moverPokemonACaja(1); ) no lo mueve porque no está en esa posición
        Si muevo un pokemon que si está en una posición, si lo cambia a equipoSecundario o caja ( por ejemplo: rubens2.moverPokemonACaja(0); ) si lo mueve

        Así es el array (si = está en la posición / no = no hay nada en la posición )
        Equipo si no si no no
        no no si si no no
// Con rubens2.moverPokemonACaja(1); no lo mueve porque no está en esa posición
        si no si no no
        no no si si no no
// Con rubens2.moverPokemonACaja(0); lo mueve (ha movido el pokemon que queremos)
        NO no si no no
        SI no si si no no
*/
        System.out.println("1.3 " + "El entrenador " + rubens2.getNombre() + " ha movido a " + pokemon3.getNombre() + "(Apodo: " + pokemon3.getMote() + ")" + " a la caja.");

    }
    @Test
    public void capturar() {
        Pokemon p1 = new Pokemon(1,"si",Sexo.MACHO);
        Entrenador.getEntrenador().capturar(p1);
    }

    @Test
    public void moverPokemonAEquipo() {
        Pokemon pokemon7 = new Pokemon("pokemon7","crack77", Sexo.MACHO,Tipo.ROCA,null);
        Pokemon pokemon8 = new Pokemon("pokemon8","el88", Sexo.MACHO,Tipo.ROCA,Tipo.PLANTA);
        Pokemon pokemon9 = new Pokemon("pokemon9","capitan9", Sexo.HEMBRA,Tipo.PSIQUICO,Tipo.PLANTA);
        Pokemon pokemon10 = new Pokemon("pokemon10","", Sexo.HEMBRA,Tipo.PSIQUICO,null);

        Pokemon[] equipoPokemonRubencito = new Pokemon[5];
        equipoPokemonRubencito[0] = pokemon7; // metido pokemon7 en el equipoPokemonRubencito en la posición[0] 1. //2.1
        equipoPokemonRubencito[2] = pokemon8; // metido pokemon8 en el equipoPokemonRubencito en la posición[2] 3.
        System.out.println("Equipo Pokemon Rubencito: " + Arrays.deepToString(equipoPokemonRubencito)); // muestra los huecos llenos y los vacíos

        Pokemon[] equipoSecundarioRubencito = new Pokemon[6];
        equipoSecundarioRubencito[2] = pokemon9; // metido pokemon9 en el equipoSecundarioRubencito en la posición[2] 3. //2.2
        equipoSecundarioRubencito[3] = pokemon10; // metido pokemon10 en el equipoSecundarioRubencito en la posición[3] 4.
        System.out.println("Equipo Secundario Rubencito: " + Arrays.deepToString(equipoSecundarioRubencito)); // muestra los huecos llenos y los vacíos

        Objeto lanzacohetes = new Objeto ("lanzacohetes", TipoObjeto.PESA);
        Objeto[] listaObjetosDeRubencito = new Objeto[5];

        Entrenador rubencito = new Entrenador("Rubencito", "Hola123", equipoPokemonRubencito, equipoSecundarioRubencito, 1000, listaObjetosDeRubencito); //2.0
        System.out.println("2.0 " + "El entrenador: " + rubencito.getNombre() + " ha sido creado");

        System.out.println("Equipo Pokemon del entrenador: " + rubencito.getNombre() + ": " + Arrays.deepToString(equipoPokemonRubencito)); // muestra los huecos llenos y los vacíos
        System.out.println("Equipo Secundario del entrenador: " + rubencito.getNombre() + ": " + Arrays.deepToString(equipoSecundarioRubencito)); // muestra los huecos llenos y los vacíos

        System.out.println("2.1 " + "El entrenador " + rubencito.getNombre() + " ha añadido a " + pokemon7.getNombre() + " [" + pokemon7.getMote() + "]" + " a su equipo: " + "equipoPokemonRubencito"); // como el equipoPokemon y el equipoSecundario no tienen nombre como tal, lo hemos entrecomillado para saber el nombre
        System.out.println("2.2 " + "El entrenador " + rubencito.getNombre() + " ha añadido a " + pokemon9.getNombre() + " [" + pokemon9.getMote() + "]" + " al equipo secundario: " + "equipoSecundarioRubencito");  // como el equipoPokemon y el equipoSecundario no tienen nombre como tal, lo hemos entrecomillado para saber el nombre

        rubencito.moverPokemonAEquipo(2); // con el índice 2 movemos el pokemon9 de mote capitan9.
        System.out.println("2.3 " + "El entrenador " + rubencito.getNombre() + " ha movido a " + pokemon7.getNombre() + "(Apodo: " + pokemon7.getMote() + ")" + " al equipo.");

    }

}