package proyectoPokemon.model;

import proyectoPokemon.model.objeto.Objeto;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Entrenador {
    // private Pokemon[] listaPokemon = new Pokemon[];
    private String nombre;
    private Pokemon[] equipoPokemon = new Pokemon[6];
    private Pokemon[] grupoSecundario = new Pokemon[6];

    //   private int pokedollar; //asi es como lo tenia mikel
    private int pokedollar = new Random().nextInt(201) + 800; // random entre 800 y 1000;
    private Objeto[] listaObjetos = new Objeto[4]; // La listaObjetos viene a ser "mochila", la equipada.
    // puesto[4] un máximo de 5 objetos para la mochila (para luego testear que entren 5 objetos y no más.

    public Entrenador(String nombre, Pokemon[] equipoPokemon, Pokemon[] grupoSecundario,
                      int pokedollar, Objeto[] listaObjetos) {
        this.nombre = nombre;
        this.equipoPokemon = equipoPokemon;
        this.grupoSecundario = grupoSecundario;
        this.pokedollar = pokedollar;
        this.listaObjetos = listaObjetos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getPokedollar() {
        return pokedollar;
    }

    public void setPokedollar(int pokedollar) {
        this.pokedollar = pokedollar;
    }

    public Objeto[] getListaObjetos() {
        return listaObjetos;
    }

    public void setListaObjetos(Objeto[] listaObjetos) {
        this.listaObjetos = listaObjetos;
    }


    // Métodos para la Clase Combate
    public int getNivelMaximoEquipo() {
        return 0;
    }
    public void recibirPokedollar(int pokedollar) {
        this.pokedollar += pokedollar;
    }

    //Funciones del entrenador

    public void moverPokemonACaja(int indice) {
        if (equipoPokemon.size() > 1) { // al menos debe quedar un Pokemon en el equipo principal
            Pokemon pokemon = equipoPokemon.remove(indice);
            grupoSecundario.add(pokemon);
            System.out.println(nombre + " ha movido a " + pokemon.getNombre() + " a la caja.");
        }
    }

    public void moverPokemonAEquipo(int indice) {
        if (equipoPokemon.size() < 4 && indice < grupoSecundario.size()) { // no se deben tener más de 4 Pokemon en el equipo y el índice debe ser válido
            Pokemon pokemon = grupoSecundario.remove(indice);
            equipoPokemon.add(pokemon);
            System.out.println(nombre + " ha movido a " + pokemon.getNombre() + " a su equipo.");
        }
    }

    public void entrenarPokemon(Pokemon pokemon, TipoEntrenamiento tipoEntrenamiento) {
        int costo, ataque, defensa, ataqueEspecial, defensaEspecial, velocidad, vitalidad;
        switch (tipoEntrenamiento) {
            // Se puede sustituir el switch al darle a la bombilla y te lo hace así:
            // if ("pesado".equals(TipoEntrenamiento)) { // entrenamiento pesado
            case "pesado": // entrenamiento pesado
                costo = 20 * pokemon.getNivel();
                ataque = 0; defensa = 5; ataqueEspecial = 0; defensaEspecial = 5; velocidad = 0; vitalidad = 5;

                if (pokedollars >= costo) {
                    // por ejemplo si fuese un entrenamiento "pesado":
                    pokemon.setDefensa(pokemon.getDefensa() + defensa);
                    pokemon.setDefensaEspecial(pokemon.getDefensaEspecial() + defensaEspecial);
                    pokemon.setVitalidad(pokemon.getVitalidad() + vitalidad);
                    System.out.println(nombre + " ha entrenado a " + pokemon.getNombre() + " mediante un entrenamiento de tipo " + TipoEntrenamiento + ".");
                    pokedollar -= costo;
                }

                break;
            case "furioso": // entrenamiento furioso
                costo = 30 * pokemon.getNivel();
                ataque = 5; defensa = 0; ataqueEspecial = 5; defensaEspecial = 0; velocidad = 5; vitalidad = 0;
                break;
            case "funcional": // entrenamiento funcional
                costo = 40 * pokemon.getNivel();
                ataque = 5; defensa = 5; ataqueEspecial = 0; defensaEspecial = 0; velocidad = 5; vitalidad = 5;
                break;
            case "onírico": // entrenamiento onírico
                costo = 40 * pokemon.getNivel();
                ataque = 0; defensa = 0; ataqueEspecial = 5; defensaEspecial = 5; velocidad = 5; vitalidad = 5;
                break;
            default:
                System.out.println("Tipo de entrenamiento no válido.");
                return;
        }
 /*
            if (pokedollar >= costo) {
                pokemon.equals(TipoEntrenamiento.equals("pesado"));
 */
/*
             if (pokedollar >= costo) {
                pokemon.entrenar(ataque, defensa, ataqueEspecial, defensaEspecial, velocidad, vitalidad);
                pokedollar -= costo;
                System.out.println(nombre + " ha entrenado a " + pokemon.getNombre() + " mediante un entrenamiento de tipo " + TipoEntrenamiento + ".");
            }
 */
        // *HACIENDO ASÍ
        if (pokedollars >= costo) {
            // por ejemplo si fuese un entrenamiento "pesado":
            pokemon.setDefensa(pokemon.getDefensa() + defensa);
            pokemon.setDefensaEspecial(pokemon.getDefensaEspecial() + defensaEspecial);
            pokemon.setVitalidad(pokemon.getVitalidad() + vitalidad);
            System.out.println(nombre + " ha entrenado a " + pokemon.getNombre() + " mediante un entrenamiento de tipo " + TipoEntrenamiento + ".");
            pokedollar -= costo;
        }



    }
}

