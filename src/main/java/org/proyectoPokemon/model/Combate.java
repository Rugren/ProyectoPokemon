
package org.proyectoPokemon.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Clase principal de nuestro proyecto Pokemon / Combate
 * @author
 * @version
 */
public class Combate {
    private Entrenador ganador;
    private Entrenador jugador;
    private Entrenador jugadorEquipo;
    private Entrenador rival;
    // private Turno turno;
    private int turno;
    private int numPokemonsKOjugador;
    private int numPokemonsKOrival;

    public Entrenador getGanador() {
        return ganador;
    }

    public Entrenador getJugador() {
        return jugador;
    }

    public Entrenador getRival() {
        return rival;
    }

    public int getTurno() {
        return turno;
    }

    public int getnumPokemonsKOjugador() {
        return numPokemonsKOjugador;
    }

    public int getnumPokemonsKOrival() {
        return numPokemonsKOrival;
    }

    /**
     * Método Combate
     * realiza un combate entre jugador y rival
     * @param jugador
     * @param rival
     * se puede combatir hasta que todos los pokemon (tanto del jugador como del rival) estén KO, es decir, estén a 0.
     */

    public Combate(Entrenador jugador, Entrenador rival) {
        this.jugador = jugador;
        this.rival = rival;
        this.turno = turno;
        this.numPokemonsKOjugador = 0;
        this.numPokemonsKOrival = 0;
    }

    /**
     * Método inicioCombate
     * - realiza el inicio del combate entre jugador y rival, respetando los turnos entre ambos.
     * - se establece el nivel máximo del Pokémon rival, para que no haya descompesación de nivel entre nuestro jugador.
     * - se establece el combate entre los dos Pokémon
     * - se determina el ganador del combate; si somos nosotros(jugador) o el rival
     * - se entrega el premio al ganador, si ganamos nosotros(jugador) o rival
     * - se reparte la experiencia(llamada: nivelExperiencia) entre los Pokémon del equipo del ganador
     */
    public void inicioCombate() {
        System.out.println("¡Comienza el combate!");
        Pokemon[] equipoJugador = jugador.getEquipoPokemon();
        Pokemon[] equipoRival = rival.getEquipoPokemon();

        while (numPokemonsKOjugador < 6 && numPokemonsKOrival < 6) {
            System.out.println("Turno " + turno + ":");
            Pokemon pokemonJugador = equipoJugador[numPokemonsKOjugador];
            Pokemon pokemonRival = equipoRival[numPokemonsKOrival];

            // Para establecer el nivel máximo del Pokémon rival
            int nivelMaximo = jugador.getNivelMaximoEquipo();
            int nivelPokemonRival = new Random().nextInt(nivelMaximo) + 1;
            pokemonRival.setNivel(nivelPokemonRival);

            // Para establecer el combate entre los dos Pokémon
            boolean jugadorGana = pokemonJugador.combatir(pokemonRival);

            if (jugadorGana) {
                System.out.println("¡" + jugador.getNombre() + " gana el turno!");
                numPokemonsKOrival++;
            } else {
                System.out.println("¡" + rival.getNombre() + " gana el turno!");
                numPokemonsKOjugador++;
            }
            turno++;
        }

        // Se determina el ganador del combate; si somos nosotros(jugador) o el rival.
        if (numPokemonsKOjugador >= 6) {
            ganador = rival;
            System.out.println(rival.getNombre() + " ha ganado el combate.");
        } else {
            ganador = jugador;
            System.out.println(jugador.getNombre() + " ha ganado el combate.");
        }

        // Se entrega el premio al ganador
        int pokedollar = (int) Math.floor(rival.getPokedollar() / 3);
        ganador.recibirPokedollar(pokedollar);

        // Se reparte la experiencia(llamada: nivelExperiencia) entre los Pokémon del equipo del ganador
        Pokemon[] equipoGanador = ganador.getEquipoPokemon();
        for (Pokemon pokemon : equipoGanador) {
            int nivelMaximo = jugador.getNivelMaximoEquipo(); // ¿dejar así el "int nivelMaximo"?

            int nivelExperiencia = (pokemon.getNivel() + nivelMaximo * 10) / 4; // nivelMaximo del rival o pokemon.getNivelRival, algo así?
            pokemon.anadirExperiencia(nivelExperiencia);
        }
    }

}

