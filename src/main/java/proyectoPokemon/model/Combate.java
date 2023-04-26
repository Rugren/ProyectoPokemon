package proyectoPokemon.model;

import java.util.LinkedList;
import java.util.Random;

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
    public Combate(Entrenador jugador, Entrenador rival) {
        this.jugador = jugador;
        this.rival = rival;
        this.turno = turno;
        this.numPokemonsKOjugador = 0;
        this.numPokemonsKOrival = 0;
    }


    public void inicioCombate() {
        System.out.println("¡Comienza el combate!");
        LinkedList<Pokemon> equipoJugador = jugador.getEquipoPokemon();
        LinkedList<Pokemon> equipoRival = rival.getEquipoPokemon();

        while (numPokemonsKOjugador < 6 && numPokemonsKOrival < 6) {
            System.out.println("Turno " + turno + ":");
            Pokemon pokemonJugador = equipoJugador.get(numPokemonsKOjugador);
            Pokemon pokemonRival = equipoRival.get(numPokemonsKOrival);

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

        // Se reparte la experiencia entre los Pokémon del equipo del ganador
        LinkedList<Pokemon> equipoGanador = ganador.getEquipoPokemon();
        for (Pokemon pokemon : equipoGanador) {
            int experiencia = (pokemon.getNivel() + nivelMaximo * 10) / 4; // nivelMaximo del rival o pokemon.getNivelRival, algo así?
            pokemon.añadirExperiencia(experiencia);
            //uSAR LOS GET Y SET DEL POKEMON
            // this.nivelExperiencia += experiencia;
        }
    }



}

