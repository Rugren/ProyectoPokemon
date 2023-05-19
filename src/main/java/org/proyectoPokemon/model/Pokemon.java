package org.proyectoPokemon.model;

import org.proyectoPokemon.database.PokemonCRUD;
import org.proyectoPokemon.model.movimiento.Movimiento;
import org.proyectoPokemon.model.objeto.Objeto;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

/**
 * Clase principal de nuestro proyecto Pokemon / Pokemon
 * @author MikelAnderson Rugren
 * @version
 */
public class Pokemon {
    private int idPokedex;
    private int idPokemon;
    private String nombre;
    private String mote;
    private int vitalidad;
    private int ataque;
    private int defensa;
    private int ataqueEspecial;
    private int defensaEspecial;
    private int velocidad;
    private int estamina;
    private final int ESTAMINA_MAX = 100;
    private int nivel = 1;
    private Movimiento movimiento;

    private Movimiento[] listaDeMovimientos;
    private int fertilidad = 5;
    private Sexo sexo;
    private Tipo tipo1;
    private Tipo tipo2;
    private Estado estado;
    private Objeto objeto;
    private int nivelExperiencia;
    private static HashMap<Tipo, LinkedList<Tipo>> listaVentaja = getListaVentaja();
    private static HashMap<Tipo, LinkedList<Tipo>> listaDesventaja = getListaDesventaja();
    private static HashMap<Tipo, LinkedList<Tipo>> listaAtaqueNulo = getListaAtaqueNulo();
    private static LinkedList<Pokemon> pokedex;

    /**
     * Constructor para insertar pokemon en la base de DAtos
     * @param idPokedex
     * @param mote
     * @param sexo
     */
    public Pokemon(int idPokedex, String mote, Sexo sexo) {
        this.idPokedex = idPokedex;
        this.nombre = PokemonCRUD.getNombre(idPokedex);
        this.mote = mote;
        Random rnd = new Random();
        this.vitalidad = rnd.nextInt(10) + 1;
        this.ataque = rnd.nextInt(10) + 1;
        this.defensa = rnd.nextInt(10) + 1;
        this.ataqueEspecial = rnd.nextInt(10) + 1;
        this.defensaEspecial = rnd.nextInt(10) + 1;
        this.velocidad = rnd.nextInt(10) + 1;
        this.estamina = ESTAMINA_MAX;
        this.nivel = 1;
        this.fertilidad = 5;
        this.sexo = sexo;
        this.tipo1 = PokemonCRUD.getTipo1(idPokedex);
        this.tipo2 = PokemonCRUD.getTipo2(idPokedex);
        this.nivelExperiencia = 1;
    }


    /**
     * Constructor para porbar el test De aprender movimientos
     * @param nombre
     * @param tipo1
     * @param tipo2
     * @param listaDeMovimientos
     */
   public Pokemon(String nombre, Tipo tipo1, Tipo tipo2, Movimiento[] listaDeMovimientos) {
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.listaDeMovimientos = new Movimiento[3];
    }

    /**
     *
     * @param nombre
     * @param tipo1
     * @param tipo2
     */
    public Pokemon(String nombre, Tipo tipo1, Tipo tipo2) {
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
    }

    public Pokemon(String nombre, String mote, Sexo sexo, Tipo tipo1, Tipo tipo2) {
        this.nombre = nombre;
        this.mote = mote;
        this.sexo = sexo;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
    }

    /**
     * Constructor para probar el Test descansar
     * @param nombre
     * @param estamina
     */
    public Pokemon(String nombre, int estamina) {
        this.nombre = nombre;
        this.estamina = ESTAMINA_MAX;
    }

    /**
     * Devuelve una lista con todos los pokemon
     * @return
     */
    public static LinkedList<Pokemon> getPokedex() {
        if (pokedex == null)
            pokedex = new LinkedList<>();
        return pokedex;
    }

    public int getIdPokedex() {
        return idPokedex;
    }

    public void setIdPokedex(int idPokedex) {
        this.idPokedex = idPokedex;
    }

    public int getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(int idPokemon) {
        this.idPokemon = idPokemon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMote() {
        return mote;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public int getVitalidad() {
        return vitalidad;
    }

    public void setVitalidad(int vitalidad) {
        this.vitalidad = vitalidad;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public void setAtaqueEspecial(int ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    public void setDefensaEspecial(int defensaEspecial) {
        this.defensaEspecial = defensaEspecial;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getEstamina() {
        return estamina;
    }

    public void setEstamina(int estamina) {
        this.estamina = estamina;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public int getFertilidad() {
        return fertilidad;
    }

    public void setFertilidad(int fertilidad) {
        this.fertilidad = fertilidad;
    }

    public Sexo getSexo() {
        return sexo;
    }

    /**
     * Devuelve el valor del Enum Sexo en un String
     * @return
     */
    public String getSexoString(){
        String string = String.valueOf(Sexo.valueOf(String.valueOf(getSexo())));
        return string;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Tipo getTipo1() {
        return tipo1;
    }
    public Tipo getTipo2() {
        return tipo2;
    }

    public void setTipo1(Tipo tipo1) {
        this.tipo1 = tipo1;
    }

    public void setTipo2(Tipo tipo2) {
        this.tipo2 = tipo2;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public int getNivelExperiencia() {
        return nivelExperiencia;
    }

    public void setNivelExperiencia(int nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }

    public Movimiento[] getListaDeMovimientos() {

        if (listaDeMovimientos == null)
            listaDeMovimientos[0] = org.proyectoPokemon.model.movimiento.Movimiento.getMovimiento(1);
        return listaDeMovimientos;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    //FUNCIONES DEL POKEMON

    /**
     * Metodo para subir de nivel a nuestro pokemon.
     */
    public void subirNivel() {
        Random rnd = new Random();
        if (this.nivelExperiencia == 10 * this.nivel) {
            setVitalidad(this.vitalidad + (rnd.nextInt(5) + 1));
            setAtaque(this.ataque + (rnd.nextInt(5) + 1));
            setDefensa(this.defensa + (rnd.nextInt(5) + 1));
            setAtaqueEspecial(this.ataqueEspecial + (rnd.nextInt(5) + 1));
            setDefensaEspecial(this.defensaEspecial + (rnd.nextInt(5) + 1));
            setVelocidad(this.velocidad + (rnd.nextInt(5) + 1));
        }
        if (nivel % 3 == 0) {
            aprenderMovimiento(movimiento);
        }
    }

    /**
     * Recorre la lista de movimentos disponibles y se le añade a la lista de movimientos de nuestro pokemon
     * devuelve verdadero si se realiza correctamente
     * @param movimiento
     * @return
     */
    public boolean aprenderMovimiento( Movimiento movimiento) {
        for (int i = 0; i < listaDeMovimientos.length; i++){
            if(listaDeMovimientos[i] == null){
                listaDeMovimientos[i] = Movimiento.getMovimiento(movimiento);
                return true;
            }
        }return true;
    }

    /**
     * @param aprendenMovimiento
     * @param quitarMovimiento
     * @return indica si se ha completado o no el metodo.
     */
    public boolean aprenderMovimiento(int aprendenMovimiento, int quitarMovimiento) {
        if (this.nivel % 3 == 0) {
            if (listaDeMovimientos.length > 2) {
                quitarmoviento(quitarMovimiento);
                listaDeMovimientos[quitarMovimiento] = Movimiento.getMovimiento(aprendenMovimiento);
                return true;
            }
        }
        return false;
    }

    /**
     * @param indexMovimiento
     * @return indica si se ha completado o no el metodo.
     */
    public boolean quitarmoviento(int indexMovimiento) {
        if (listaDeMovimientos.length > 0) {
            listaDeMovimientos[indexMovimiento] = null;
            return true;
        } else
            return false;
    }

    /**
     * Método para atacar un pokemon a otro.
     * @param pokemon
     */
    public void atacar(Pokemon pokemon) {
    }

    /**
     * Metodo para descanasar el pokemon y recuperar estamina
     * devuelve un boolean
     * @return
     */
    public boolean descansar() {
        if (getEstamina() >= ESTAMINA_MAX)
            return false;
        setEstamina(ESTAMINA_MAX);
        return true;
    }

    /**
     * Listado de tipo del pokemon:
     * Método estático que devuelve un hashmap
     * Este método crea un hashmap usando los tipos de pokemon como clave valor
     * y el valor asociado a cada clave es una lista LinkedList con los tipos de pokemon que tienen desventaja
     * @return devuelve una colección hashmap con los tipos de pokemon que tienen desventaja con otro tipo
     */
    public static HashMap<Tipo, LinkedList<Tipo>> getListaDesventaja() {
        if (listaDesventaja == null) {
            listaDesventaja = new HashMap<>();
            listaDesventaja.put(Tipo.AGUA, new LinkedList<>());
            listaDesventaja.put(Tipo.BICHO, new LinkedList<>());
            listaDesventaja.put(Tipo.DRAGON, new LinkedList<>());
            listaDesventaja.put(Tipo.ELECTRICO, new LinkedList<>());
            listaDesventaja.put(Tipo.FANTASMA, new LinkedList<>());
            listaDesventaja.put(Tipo.FUEGO, new LinkedList<>());
            listaDesventaja.put(Tipo.HIELO, new LinkedList<>());
            listaDesventaja.put(Tipo.LUCHA, new LinkedList<>());
            listaDesventaja.put(Tipo.NORMAL, new LinkedList<>());
            listaDesventaja.put(Tipo.PLANTA, new LinkedList<>());
            listaDesventaja.put(Tipo.PSIQUICO, new LinkedList<>());
            listaDesventaja.put(Tipo.ROCA, new LinkedList<>());
            listaDesventaja.put(Tipo.TIERRA, new LinkedList<>());
            listaDesventaja.put(Tipo.VENENO, new LinkedList<>());
            listaDesventaja.put(Tipo.VOLADOR, new LinkedList<>());

            listaDesventaja.get(Tipo.AGUA).add(Tipo.AGUA);
            listaDesventaja.get(Tipo.AGUA).add(Tipo.DRAGON);
            listaDesventaja.get(Tipo.AGUA).add(Tipo.PLANTA);

            listaDesventaja.get(Tipo.BICHO).add(Tipo.FANTASMA);
            listaDesventaja.get(Tipo.BICHO).add(Tipo.FUEGO);
            listaDesventaja.get(Tipo.BICHO).add(Tipo.LUCHA);
            listaDesventaja.get(Tipo.BICHO).add(Tipo.VOLADOR);

            listaDesventaja.get(Tipo.ELECTRICO).add(Tipo.DRAGON);
            listaDesventaja.get(Tipo.ELECTRICO).add(Tipo.ELECTRICO);
            listaDesventaja.get(Tipo.ELECTRICO).add(Tipo.PLANTA);

            listaDesventaja.get(Tipo.FUEGO).add(Tipo.AGUA);
            listaDesventaja.get(Tipo.FUEGO).add(Tipo.DRAGON);
            listaDesventaja.get(Tipo.FUEGO).add(Tipo.FUEGO);
            listaDesventaja.get(Tipo.FUEGO).add(Tipo.ROCA);

            listaDesventaja.get(Tipo.HIELO).add(Tipo.AGUA);
            listaDesventaja.get(Tipo.HIELO).add(Tipo.HIELO);

            listaDesventaja.get(Tipo.LUCHA).add(Tipo.BICHO);
            listaDesventaja.get(Tipo.LUCHA).add(Tipo.PSIQUICO);
            listaDesventaja.get(Tipo.LUCHA).add(Tipo.VENENO);
            listaDesventaja.get(Tipo.LUCHA).add(Tipo.VOLADOR);

            listaDesventaja.get(Tipo.NORMAL).add(Tipo.ROCA);

            listaDesventaja.get(Tipo.PLANTA).add(Tipo.BICHO);
            listaDesventaja.get(Tipo.PLANTA).add(Tipo.DRAGON);
            listaDesventaja.get(Tipo.PLANTA).add(Tipo.FUEGO);
            listaDesventaja.get(Tipo.PLANTA).add(Tipo.PLANTA);
            listaDesventaja.get(Tipo.PLANTA).add(Tipo.VENENO);
            listaDesventaja.get(Tipo.PLANTA).add(Tipo.VOLADOR);

            listaDesventaja.get(Tipo.PSIQUICO).add(Tipo.PSIQUICO);

            listaDesventaja.get(Tipo.ROCA).add(Tipo.LUCHA);
            listaDesventaja.get(Tipo.ROCA).add(Tipo.TIERRA);

            listaDesventaja.get(Tipo.TIERRA).add(Tipo.BICHO);
            listaDesventaja.get(Tipo.TIERRA).add(Tipo.PLANTA);

            listaDesventaja.get(Tipo.VENENO).add(Tipo.FANTASMA);
            listaDesventaja.get(Tipo.VENENO).add(Tipo.ROCA);
            listaDesventaja.get(Tipo.VENENO).add(Tipo.TIERRA);
            listaDesventaja.get(Tipo.VENENO).add(Tipo.VENENO);

            listaDesventaja.get(Tipo.VOLADOR).add(Tipo.ELECTRICO);
            listaDesventaja.get(Tipo.VOLADOR).add(Tipo.ROCA);

        }
        return listaDesventaja;
    }

    /**
     * Listado de tipo del pokemon:
     * Método estático que devuelve un hashmap
     * Este método crea un hashmap usando los tipos de pokemon como clave valor
     * y el valor asociado a cada clave es una lista LinkedList con los tipos de pokemon que tienen ventaja
     * @return devuelve una colección hashmap con los tipos de pokemon que tienen ventaja con otro tipo
     */
    public static HashMap<Tipo, LinkedList<Tipo>> getListaVentaja() {
        if (listaVentaja == null) {
            listaVentaja = new HashMap<>();

            listaVentaja.put(Tipo.AGUA, new LinkedList<>());
            listaVentaja.put(Tipo.BICHO, new LinkedList<>());
            listaVentaja.put(Tipo.DRAGON, new LinkedList<>());
            listaVentaja.put(Tipo.ELECTRICO, new LinkedList<>());
            listaVentaja.put(Tipo.FANTASMA, new LinkedList<>());
            listaVentaja.put(Tipo.FUEGO, new LinkedList<>());
            listaVentaja.put(Tipo.HIELO, new LinkedList<>());
            listaVentaja.put(Tipo.LUCHA, new LinkedList<>());
            listaVentaja.put(Tipo.NORMAL, new LinkedList<>());
            listaVentaja.put(Tipo.PLANTA, new LinkedList<>());
            listaVentaja.put(Tipo.PSIQUICO, new LinkedList<>());
            listaVentaja.put(Tipo.ROCA, new LinkedList<>());
            listaVentaja.put(Tipo.TIERRA, new LinkedList<>());
            listaVentaja.put(Tipo.VENENO, new LinkedList<>());
            listaVentaja.put(Tipo.VOLADOR, new LinkedList<>());

            listaVentaja.get(Tipo.AGUA).add(Tipo.FUEGO);
            listaVentaja.get(Tipo.AGUA).add(Tipo.ROCA);
            listaVentaja.get(Tipo.AGUA).add(Tipo.TIERRA);

            listaVentaja.get(Tipo.BICHO).add(Tipo.PLANTA);
            listaVentaja.get(Tipo.BICHO).add(Tipo.PSIQUICO);
            listaVentaja.get(Tipo.BICHO).add(Tipo.VENENO);

            listaVentaja.get(Tipo.DRAGON).add(Tipo.DRAGON);

            listaVentaja.get(Tipo.ELECTRICO).add(Tipo.AGUA);
            listaVentaja.get(Tipo.ELECTRICO).add(Tipo.VOLADOR);

            listaVentaja.get(Tipo.FANTASMA).add(Tipo.FANTASMA);

            listaVentaja.get(Tipo.FUEGO).add(Tipo.BICHO);
            listaVentaja.get(Tipo.FUEGO).add(Tipo.HIELO);
            listaVentaja.get(Tipo.FUEGO).add(Tipo.PLANTA);

            listaVentaja.get(Tipo.HIELO).add(Tipo.DRAGON);
            listaVentaja.get(Tipo.HIELO).add(Tipo.PLANTA);
            listaVentaja.get(Tipo.HIELO).add(Tipo.TIERRA);
            listaVentaja.get(Tipo.HIELO).add(Tipo.VOLADOR);

            listaVentaja.get(Tipo.LUCHA).add(Tipo.HIELO);
            listaVentaja.get(Tipo.LUCHA).add(Tipo.NORMAL);
            listaVentaja.get(Tipo.LUCHA).add(Tipo.ROCA);

            listaVentaja.get(Tipo.PLANTA).add(Tipo.AGUA);
            listaVentaja.get(Tipo.PLANTA).add(Tipo.ROCA);
            listaVentaja.get(Tipo.PLANTA).add(Tipo.TIERRA);

            listaVentaja.get(Tipo.PSIQUICO).add(Tipo.LUCHA);
            listaVentaja.get(Tipo.PSIQUICO).add(Tipo.VENENO);

            listaVentaja.get(Tipo.ROCA).add(Tipo.DRAGON);
            listaVentaja.get(Tipo.ROCA).add(Tipo.FUEGO);
            listaVentaja.get(Tipo.ROCA).add(Tipo.HIELO);
            listaVentaja.get(Tipo.ROCA).add(Tipo.VOLADOR);

            listaVentaja.get(Tipo.TIERRA).add(Tipo.ELECTRICO);
            listaVentaja.get(Tipo.TIERRA).add(Tipo.FUEGO);
            listaVentaja.get(Tipo.TIERRA).add(Tipo.ROCA);
            listaVentaja.get(Tipo.TIERRA).add(Tipo.VENENO);

            listaVentaja.get(Tipo.VENENO).add(Tipo.BICHO);
            listaVentaja.get(Tipo.VENENO).add(Tipo.PLANTA);

            listaVentaja.get(Tipo.VOLADOR).add(Tipo.BICHO);
            listaVentaja.get(Tipo.VOLADOR).add(Tipo.LUCHA);
            listaVentaja.get(Tipo.VOLADOR).add(Tipo.PLANTA);

        }
        return listaVentaja;
    }

    /**
     * Listado de tipo del pokemon:
     * Método estático que devuelve un hashmap
     * Este método crea un hashmap usando los tipos de pokemon como clave valor
     * y el valor asociado a cada clave es una lista LinkedList con los tipos de pokemon que tienen un ataque nulo
     * @return devuelve una colección hashmap con los tipos de pokemon que tienen un ataque nulo con otro tipo
     */
    public static HashMap<Tipo, LinkedList<Tipo>> getListaAtaqueNulo() {
        if (listaAtaqueNulo == null) {
            listaAtaqueNulo = new HashMap<>();

            listaAtaqueNulo.put(Tipo.ELECTRICO, new LinkedList<>());
            listaAtaqueNulo.put(Tipo.FANTASMA, new LinkedList<>());
            listaAtaqueNulo.put(Tipo.LUCHA, new LinkedList<>());
            listaAtaqueNulo.put(Tipo.NORMAL, new LinkedList<>());
            listaAtaqueNulo.put(Tipo.TIERRA, new LinkedList<>());

            listaAtaqueNulo.get(Tipo.ELECTRICO).add(Tipo.TIERRA);

            listaAtaqueNulo.get(Tipo.FANTASMA).add(Tipo.NORMAL);
            listaAtaqueNulo.get(Tipo.FANTASMA).add(Tipo.PSIQUICO);

            listaAtaqueNulo.get(Tipo.LUCHA).add(Tipo.FANTASMA);

            listaAtaqueNulo.get(Tipo.NORMAL).add(Tipo.FANTASMA);

            listaAtaqueNulo.get(Tipo.TIERRA).add(Tipo.VOLADOR);
        }
        return listaAtaqueNulo;
    }

    /**
     * Comprobar ventaja de this con otro pokemon indicado.
     *
     * @param pokemon
     * @return nos devuelve la ventaja que tiene sobre el otro pokemon
     */
    public float comprobarVentaja(Pokemon pokemon) {
        if (Pokemon.listaVentaja.get(getTipo1()).contains(pokemon.getTipo1()))
            return 2.0f;
        if (Pokemon.listaVentaja.get(getTipo1()).contains(pokemon.getTipo1()))
            return 0.5f;
        if (Pokemon.listaAtaqueNulo.get(getTipo1()).contains(pokemon.getTipo1()))
            return 0f;
        return 1f;
    }

    /**
     * Método combatir contra pokemon rival.
     * @param pokemonRival
     * @return nos devuelve si estamos combatiendo contra un pokemon rival.
     */
    public boolean combatir(Pokemon pokemonRival) {
        return false;
    }

    /**
     * Método anadirExperiencia
     * Usado para añadir experiencia obtenida por cualquier cosa, ya sea un combate, con objeto, etc.
     * @param nivelExperiencia
     */
    public void anadirExperiencia(int nivelExperiencia) {
        this.nivelExperiencia += nivelExperiencia;
    }


    /*@Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + this.nombre + '\'' +
                ", mote='" + this.mote + '\'' +
                ", tipo1=" + this.tipo1 +
                ", tipo2=" + this.tipo2 +
                ", nivel=" + this.nivel +
                '}';
    }*/

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", mote='" + mote + '\'' +
                '}';
    }
}



