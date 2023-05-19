
package org.proyectoPokemon.model;

import org.proyectoPokemon.model.objeto.Objeto;

import java.util.*;


/**
 * Clase principal de nuestro proyecto Pokemon / Entrenador
 * @author Rugren MikelAnderson
 * @version
 */
public class Entrenador {

    private int pokeballs;
    private TipoEntrenamiento tipoEntrenamiento;
    private static Entrenador Entrenador = null;
    private String nombre;
    private String password;
    private Pokemon[] equipoPokemon = new Pokemon[5];
    private Pokemon[] grupoSecundario = new Pokemon[19]; // 20 pokemon en el equipo secundario.
    private int pokedollar = new Random().nextInt(201) + 800; // Al crearse tiene que tener un random entre 800 y 1000;
    private Objeto[] listaObjetos = new Objeto[4]; // La listaObjetos viene a ser "mochila", la equipada.
    // puesto[4] un máximo de 5 objetos para la mochila (para luego testear que entren 5 objetos y no más.

    private static LinkedList<Pokemon> listaPokemon = new LinkedList<>();


    public Entrenador(String nombre, String password, Pokemon[] equipoPokemon, Pokemon[] grupoSecundario,
                      int pokedollar, Objeto[] listaObjetos) {
        this.nombre = nombre;
        this.password = password;
        this.equipoPokemon = equipoPokemon;
        this.grupoSecundario = grupoSecundario;
        this.pokedollar = pokedollar;
        this.listaObjetos = listaObjetos;
    }

    /**
     * Usamos este constructor vacío de Entrenador para comprobar el loggin
     */
    public Entrenador(){
        this.nombre = nombre;
        this.password = password;
        this.equipoPokemon = new Pokemon[5];
        this.grupoSecundario = new Pokemon[19];
        this.pokedollar = new Random().nextInt(201) + 800;
        this.pokeballs = 5;
        this.listaObjetos = new Objeto[4];
    }

    //Funciones del entrenador
    public static boolean entrenadornull(){
        synchronized (Entrenador.class){
            if(Entrenador == null){
                return true;
            }
        }return false;
    }

    /**
     * Usamos este constructor vacío de Entrenador para crearlo
     */
    public static Entrenador getEntrenador() {
        synchronized (Entrenador.class){
            if(Entrenador == null){
                Entrenador = new Entrenador();
            }
        }
        return Entrenador;
    }

    public static void setEntrenador(org.proyectoPokemon.model.Entrenador entrenador) {
        Entrenador = new Entrenador();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getPokeballs() {
        return pokeballs;
    }

    public void setPokeballs(int pokeballs) {
        this.pokeballs = pokeballs;
    }

    public Objeto[] getListaObjetos() {
        return listaObjetos;
    }

    public void setListaObjetos(Objeto[] listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    public static LinkedList<Pokemon> getListaPokemon() {
        return listaPokemon;
    }

    public static void setListaPokemon(LinkedList<Pokemon> listaPokemon) {
        org.proyectoPokemon.model.Entrenador.listaPokemon = listaPokemon;
    }

    // Métodos para la Clase Combate

    /**
     * Método que nos devuelve el nivel máximo del equipo.
     * @return indica el nivel máximo del equipo.
     */
    public int getNivelMaximoEquipo() {
        int nivelMaximo = 0;
        for (int i = 0; i < equipoPokemon.length; i++) {
            if (equipoPokemon[i].getNivel() >= nivelMaximo) {
                nivelMaximo = equipoPokemon[i].getNivel();
            }
        }
        return nivelMaximo;
    }

    /**
     * Método constructor para recibir pokedollar
     * @param pokedollar los pokedollar que tenemos más los pokedollar que ganamos al combatir.
     */
    public void recibirPokedollar(int pokedollar) {
        this.pokedollar += pokedollar;
    }

/* Así sería con LinkedList (no borrar este)
    public void moverPokemonACaja(int indice) {
        if (equipoPokemon.size() > 1) { // al menos debe quedar un Pokemon en el equipo principal
            Pokemon pokemon = equipoPokemon.remove(indice);
            grupoSecundario.add(pokemon);
            System.out.println("El entrenador " + nombre + " ha movido a " + pokemon.getNombre() + " a la caja.");
        }
    }

        public void moverPokemonAEquipo(int indice) {
            if (equipoPokemon.size() < 4 && indice < grupoSecundario.size()) { // no se deben tener más de 4 Pokemon en el equipo y el índice debe ser válido
                Pokemon pokemon = grupoSecundario.remove(indice);
                equipoPokemon.add(pokemon);
                System.out.println("El entrenador " + nombre + " ha movido a " + pokemon.getNombre() + " a su equipo.");
            }
        }
*/

    /**
     * Método para mover pokemon del equipo a caja
     * @param indice número del array del orden de nuestro pokemon en equipo que se mueve a caja.
     */

    public void moverPokemonACaja(int indice) { // CORRECTO moverPokemonACaja
        Pokemon pok1 = equipoPokemon[indice];

        // Para buscar el pokemon en el equipoPokemon
        int pokemonACaja = -1;
        for (int i = 0; i < equipoPokemon.length; i++) {
            if (equipoPokemon[i] != null && equipoPokemon[i].equals(pok1)) {
                pokemonACaja = i;
                break;
            }
        }
        if (pokemonACaja != -1) {
        // Mover el pokemon a la caja(que es el grupoSecundario)
            for (int i = 0; i < grupoSecundario.length; i++) {
                if (grupoSecundario[i] == null) {
                    grupoSecundario[i] = equipoPokemon[pokemonACaja];
                    equipoPokemon[pokemonACaja] = null;
                    break;
                }
            }

        } else {
            System.out.println("El pokemon no se encontró en el equipo.");
        }

        System.out.println("Equipo: ");
        for (Pokemon pokemonDelEquipo : equipoPokemon) {
            System.out.println(pokemonDelEquipo);
        }

        System.out.println("Grupo Secundario(Caja): "); // El grupoSecundario es nuestra caja, no lo olvidemos
        for (Pokemon pokemonEnGrupoSecundario : grupoSecundario) {
            System.out.println(pokemonEnGrupoSecundario);
        }
    }

    /*
    public void moverPokemonACaja(int indice) {
    // esta primera parte era otro ejemplo(Paco), pero no finalizado
        Pokemon p = equipoPokemon[indice];
        equipoPokemon[indice] = null;

        for (int i = 0; i < indice; i++) {
            grupoSecundario.length;

            if grupoSecundario [i] == null;
            grupoSecundario[i] = Pokemon p;

        for (int i = 0; i < indice; i++) {
            grupoSecundario[i] = equipoPokemon[indice];

            for (i = indice; i = null; i++) {
                equipoPokemon[i] = null; // sería nulo el que saquemos del equipoPokemon
            }
        }
    }
*/

    /**
     * Método para mover pokemon de caja al equipo
     * @param indice número del array del orden de nuestro pokemon en caja que se mueva a equipo.
     */

    public void moverPokemonAEquipo(int indice) { // CORRECTO moverPokemonAEquipo
        Pokemon pok2 = grupoSecundario[indice];

        // Para buscar el pokemon en el grupoSecundario
        int pokemonAEquipo = -1;
        for (int i = 0; i < grupoSecundario.length; i++) {
            if (grupoSecundario[i] != null && grupoSecundario[i].equals(pok2)) {
                pokemonAEquipo = i;
                break;
            }
        }
        if (pokemonAEquipo != -1) {
            // Mover el pokemon del grupoSecundario(caja) al equipoPokemon
            for (int i = 0; i < equipoPokemon.length; i++) {
                if (equipoPokemon[i] == null) {
                    equipoPokemon[i] = grupoSecundario[pokemonAEquipo];
                    grupoSecundario[pokemonAEquipo] = null;
                    break;
                }
            }

        } else {
            System.out.println("El pokemon no se encontró en el grupoSecundario(Caja).");
        }

        System.out.println("Grupo Secundario(Caja): ");
        for (Pokemon pokemonDelEquipo : grupoSecundario) {
            System.out.println(pokemonDelEquipo);
        }

        System.out.println("Equipo: ");
        for (Pokemon pokemonEnGrupoSecundario : equipoPokemon) {
            System.out.println(pokemonEnGrupoSecundario);
        }
    }

/*
    //editando aqui:
    public void moverPokemonAEquipo(int indice) {
            for (int i = 0; i < equipoPokemon.length; i++)
                grupoSecundario[i] = equipoPokemon[i];

            for (int i = 0; i < indice; i++) {
                grupoSecundario[i] = equipoPokemon[i];
// falta aquí por poner
                }
            }

            // i == indice // sería nulo el que saquemos del equipoPokemon

            System.out.println("El entrenador " + nombre + " ha movido a " + Pokemon.getNombre() + " al equipo.");
        }
*/
    /**
     * Método para entrenar a nuestros pokemon
     * @param pokemon el pokemon que queremos subir de atributos(ataque, defensa, ataqueEspecial, defensaEspecial, velocidad, vitalidad)
     * @param tipoEntrenamiento el entrenamiento que haremos para subir ciertos atributos, según el tipo de entrenamiento subirá una serie de atributos u otros.
     */
    public void entrenarPokemon(Pokemon pokemon, TipoEntrenamiento tipoEntrenamiento) {
        int costo, ataque, defensa, ataqueEspecial, defensaEspecial, velocidad, vitalidad;
        switch (tipoEntrenamiento) {
            // Se puede sustituir el switch al darle a la bombilla y te lo hace así: if ("pesado".equals(TipoEntrenamiento)) { // entrenamiento pesado
            case PESADO: // entrenamiento pesado
                costo = 20 * pokemon.getNivel();
                ataque = 0;
                defensa = 5;
                ataqueEspecial = 0;
                defensaEspecial = 5;
                velocidad = 0;
                vitalidad = 5;

                if (pokedollar >= costo) {
                    // por ejemplo si fuese un entrenamiento "pesado":
                    pokemon.setDefensa(pokemon.getDefensa() + defensa);
                    pokemon.setDefensaEspecial(pokemon.getDefensaEspecial() + defensaEspecial);
                    pokemon.setVitalidad(pokemon.getVitalidad() + vitalidad);
                    System.out.println(nombre + " ha entrenado a " + pokemon.getNombre() + " mediante un entrenamiento de tipo " + tipoEntrenamiento + ".");
                    pokedollar -= costo;
                }

                break;
            case FURIOSO: // entrenamiento furioso
                costo = 30 * pokemon.getNivel();
                ataque = 5;
                defensa = 0;
                ataqueEspecial = 5;
                defensaEspecial = 0;
                velocidad = 5;
                vitalidad = 0;
                if (pokedollar >= costo) {
                    pokemon.setAtaque(pokemon.getAtaque() + ataque);
                    pokemon.setAtaqueEspecial(pokemon.getAtaqueEspecial() + ataqueEspecial);
                    pokemon.setVelocidad(pokemon.getVelocidad() + velocidad);
                    System.out.println(nombre + " ha entrenado a " + pokemon.getNombre() + " mediante un entrenamiento de tipo " + tipoEntrenamiento + ".");
                    pokedollar -= costo;
                }
                break;
            case FUNCIONAL: // entrenamiento funcional
                costo = 40 * pokemon.getNivel();
                ataque = 5;
                defensa = 5;
                ataqueEspecial = 0;
                defensaEspecial = 0;
                velocidad = 5;
                vitalidad = 5;
                if (pokedollar >= costo) {
                    pokemon.setAtaque(pokemon.getAtaque() + ataque);
                    pokemon.setDefensa(pokemon.getDefensa() + defensa);
                    pokemon.setVelocidad(pokemon.getVelocidad() + velocidad);
                    pokemon.setVitalidad(pokemon.getVitalidad() + vitalidad);
                    System.out.println(nombre + " ha entrenado a " + pokemon.getNombre() + " mediante un entrenamiento de tipo " + tipoEntrenamiento + ".");
                    pokedollar -= costo;
                }
                break;
            case ONIRICO: // entrenamiento onírico
                costo = 40 * pokemon.getNivel();
                ataque = 0;
                defensa = 0;
                ataqueEspecial = 5;
                defensaEspecial = 5;
                velocidad = 5;
                vitalidad = 5;
                if (pokedollar >= costo) {
                    pokemon.setAtaqueEspecial(pokemon.getAtaqueEspecial() + ataqueEspecial);
                    pokemon.setDefensaEspecial(pokemon.getDefensaEspecial() + defensaEspecial);
                    pokemon.setVelocidad(pokemon.getVelocidad() + velocidad);
                    pokemon.setVitalidad(pokemon.getVitalidad() + vitalidad);
                    System.out.println(nombre + " ha entrenado a " + pokemon.getNombre() + " mediante un entrenamiento de tipo " + tipoEntrenamiento + ".");
                    pokedollar -= costo;
                }
                break;
            default:
                System.out.println("Tipo de entrenamiento no válido.");
                return;
        }
    }

    /**
     * Metodo para capturar Pokemon gastando pokeballs
     * si no tiene pokeballs no se puede realizar el metodo
     * @param pokemonCapturado
     * @return
     */
    public boolean capturar(Pokemon pokemonCapturado){
        if (this.pokeballs < 1)
            return false;
        this.pokeballs--;
        Random randomCaptura = new Random();
        int captura = randomCaptura.nextInt(2);
        if (captura != 0)
            return false;
        listaPokemon.add(pokemonCapturado);
        return true;
    }

    /**
     * metodo para comprar pokeballs con pokedollars y nos devuelve true
     * si se ha realizado bien el metodo
     * @return
     */
    public boolean comprarPokeball(){
        if (Entrenador.getPokedollar() < 20) {
            return false;
        }
        Entrenador.setPokedollar(Entrenador.getPokedollar() - 20);
        Entrenador.pokeballs++;
        return true;

    }

}


