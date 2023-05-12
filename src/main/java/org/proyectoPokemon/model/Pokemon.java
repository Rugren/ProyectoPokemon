package org.proyectoPokemon.model;

import org.proyectoPokemon.model.movimiento.Movimiento;
import org.proyectoPokemon.model.objeto.Objeto;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

//JAVADOC
/**
 * Clase Pokemon principal de mi proyecto.
 * @author MikelAndersonOtavalo
 */
public class Pokemon {
    private String nombre;
    private String mote;
    private int vitalidad;
    private int ataque;
    private int defensa;
    private int ataqueEspecial;
    private int defensaEspecial;
    private int velocidad;
    private int estamina;
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
    private static HashMap<Tipo, LinkedList<Tipo>> listaVentaja;
    private static HashMap<Tipo, LinkedList<Tipo>> listaDesventaja;

    private static HashMap<Tipo, LinkedList<Tipo>> listaAtaqueNulo;
    private static LinkedList<Pokemon> pokedex;

    /**
     * Construtor de pokemon para pruebas
     *
     * @param nombre
     * @param mote
     * @param sexo
     * @param tipo1
     * @param tipo2
     */
    public Pokemon(String nombre, String mote,
                   Sexo sexo, Tipo tipo1, Tipo tipo2) {
        Random rnd = new Random();
        this.nombre = nombre;
        this.mote = mote;
        this.vitalidad = rnd.nextInt(10) + 1;
        this.ataque = rnd.nextInt(10) + 1;
        this.defensa = rnd.nextInt(10) + 1;
        this.ataqueEspecial = rnd.nextInt(10) + 1;
        this.defensaEspecial = rnd.nextInt(10) + 1;
        this.velocidad = rnd.nextInt(10) + 1;
        this.estamina = rnd.nextInt(10) + 1;
        this.nivel = 1;
        this.listaDeMovimientos = listaDeMovimientos;
        this.fertilidad = 5;
        this.sexo = sexo;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.nivelExperiencia = 1;
    }

    public Pokemon( String nomPokemon, Tipo tipo1, Tipo tipo2) {
        this.nombre = nomPokemon;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
    }

    public static LinkedList<Pokemon> getPokedex() {
        if (pokedex == null)
            pokedex = new LinkedList<>();
        return pokedex;
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
            aprenderMovimiento();
        }
    }

    public void aprenderMovimiento() {

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

    public boolean quitarmoviento(int indexMovimiento) {
        if (listaDeMovimientos.length > 0) {
            listaDeMovimientos[indexMovimiento] = null;
            return true;
        } else
            return false;
    }

    public void atacar(Pokemon pokemon) {

    }

    /*public String comprobarVentaja(Pokemon pokemon) {
    // Sustituido por el diccionario HashMap: public static HashMap<Tipo, LinkedList<Tipo>> getListaDesventaja() - getListaVentaja() y getListaAtaqueNulo
    // No borrar este método porque estaría bien hecho. Pero abajo mejor hecho con diccionarios en el método comprobarVentaja.
        String mensaje = "";
        if (this.tipo == Tipo.AGUA) {
            if (pokemon.tipo == Tipo.AGUA || pokemon.tipo == Tipo.DRAGON || pokemon.tipo == Tipo.PLANTA) {
                mensaje = "VENTAJA";
            } else if (pokemon.tipo == Tipo.FUEGO || pokemon.tipo == Tipo.ROCA || pokemon.tipo == Tipo.TIERRA) {
                mensaje = "DOBLE_VENTAJA";
            } else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.BICHO) {
            if (pokemon.tipo == Tipo.FANTASMA || pokemon.tipo == Tipo.FUEGO || pokemon.tipo == Tipo.LUCHA) {
                mensaje = "VENTAJA";
            } else if (pokemon.tipo == Tipo.PLANTA || pokemon.tipo == Tipo.PSIQUICO || pokemon.tipo == Tipo.VENENO) {
                mensaje = "DOBLE_VENTAJA";
            } else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.DRAGON) {
            if (pokemon.tipo == Tipo.DRAGON) {
                mensaje = "DOBLE_VENTAJA";
            } else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.ELECTRICO) {
            if (pokemon.tipo == Tipo.DRAGON || pokemon.tipo == Tipo.ELECTRICO || pokemon.tipo == Tipo.PLANTA) {
                mensaje = "VENTAJA";
            } else if (pokemon.tipo == Tipo.AGUA || pokemon.tipo == Tipo.VOLADOR) {
                mensaje = "DOBLE_VENTAJA";
            } else if (pokemon.tipo == Tipo.TIERRA) {
                mensaje = "DESVENTAJA";
            } else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.FANTASMA) {
            if (pokemon.tipo == Tipo.FANTASMA) {
                mensaje = "DOBLE_VENTAJA";
            } else if (pokemon.tipo == Tipo.NORMAL || pokemon.tipo == Tipo.PSIQUICO) {
                mensaje = "DESVENTAJA";
            } else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.FUEGO) {
            if (pokemon.tipo == Tipo.AGUA || pokemon.tipo == Tipo.DRAGON || pokemon.tipo == Tipo.FUEGO || pokemon.tipo == Tipo.ROCA) {
                mensaje = "VENTAJA";
            } else if (pokemon.tipo == Tipo.BICHO || pokemon.tipo == Tipo.HIELO || pokemon.tipo == Tipo.PLANTA) {
                mensaje = "DOBLE_VENTAJA";
            } else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.HIELO) {
            if (pokemon.tipo == Tipo.AGUA || pokemon.tipo == Tipo.HIELO) {
                mensaje = "VENTAJA";
            } else if (pokemon.tipo == Tipo.DRAGON || pokemon.tipo == Tipo.PLANTA || pokemon.tipo == Tipo.TIERRA || pokemon.tipo == Tipo.VOLADOR) {
                mensaje = "DOBLE_VENTAJA";
            } else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.LUCHA) {
            if (pokemon.tipo == Tipo.BICHO || pokemon.tipo == Tipo.PSIQUICO ||
                    pokemon.tipo == Tipo.VENENO || pokemon.tipo == Tipo.VOLADOR) {
                mensaje = "VENTAJA";
            } else if (pokemon.tipo == Tipo.HIELO || pokemon.tipo == Tipo.NORMAL || pokemon.tipo == Tipo.ROCA) {
                mensaje = "DOBLE_VENTAJA";
            } else if (pokemon.tipo == Tipo.FANTASMA) {
                mensaje = "DESVENTAJA";
            } else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.NORMAL) {
            if (pokemon.tipo == Tipo.FANTASMA) {
                mensaje = "DESVENTAJA";
            } else if (pokemon.tipo == Tipo.PSIQUICO) {
                mensaje = "VENTAJA";
            } else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.PLANTA) {
            if (pokemon.tipo == Tipo.BICHO || pokemon.tipo == Tipo.DRAGON || pokemon.tipo == Tipo.FUEGO ||
                    pokemon.tipo == Tipo.PLANTA || pokemon.tipo == Tipo.VENENO || pokemon.tipo == Tipo.VOLADOR) {
                mensaje = "VENTAJA";
            } else if (pokemon.tipo == Tipo.AGUA || pokemon.tipo == Tipo.ROCA || pokemon.tipo == Tipo.TIERRA) {
                mensaje = "DOBLE_VENTAJA";
            } else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.PSIQUICO) {
            if (pokemon.tipo == Tipo.PSIQUICO) {
                mensaje = "VENTAJA";
            } else if (pokemon.tipo == Tipo.LUCHA || pokemon.tipo == Tipo.VENENO) {
                mensaje = "DOBLE_VENTAJA";
            } else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.ROCA) {
            if (pokemon.tipo == Tipo.LUCHA || pokemon.tipo == Tipo.TIERRA) {
                mensaje = "VENTAJA";
            } else if (pokemon.tipo == Tipo.BICHO || pokemon.tipo == Tipo.FUEGO || pokemon.tipo == Tipo.HIELO ||
                    pokemon.tipo == Tipo.VOLADOR) {
                mensaje = "DOBLE_VENTAJA";
            } else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.TIERRA) {
            if (pokemon.tipo == Tipo.BICHO || pokemon.tipo == Tipo.PLANTA) {
                mensaje = "VENTAJA";
            } else if (pokemon.tipo == Tipo.ELECTRICO || pokemon.tipo == Tipo.FUEGO || pokemon.tipo == Tipo.ROCA ||
                    pokemon.tipo == Tipo.VENENO) {
                mensaje = "DOBLE_VENTAJA";
            } else if (pokemon.tipo == Tipo.VOLADOR) {
                mensaje = "DESVENTAJA";
            } else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.VENENO) {
            if (pokemon.tipo == Tipo.FANTASMA || pokemon.tipo == Tipo.ROCA || pokemon.tipo == Tipo.TIERRA ||
                    pokemon.tipo == Tipo.VENENO) {
                mensaje = "VENTAJA";
            } else if (pokemon.tipo == Tipo.BICHO || pokemon.tipo == Tipo.PLANTA) {
                mensaje = "DOBLE_VENTAJA";
            } else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.VOLADOR) {
            if (pokemon.tipo == Tipo.ELECTRICO || pokemon.tipo == Tipo.ROCA) {
                mensaje = "VENTAJA";
            } else if (pokemon.tipo == Tipo.BICHO || pokemon.tipo == Tipo.LUCHA || pokemon.tipo == Tipo.PLANTA) {
                mensaje = "DOBLE_VENTAJA";
            } else
                mensaje = "NEUTRO";
        }
        return mensaje;
    }*/

    public void descansar() {
        this.estamina = this.estamina + 15;
    }


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
     * @return nos devuelve l aventaja ue tiene sobre el otro pokemon
     */
    public float comprobarVentaja(Pokemon pokemon) {
        if (listaVentaja.get(this.tipo1).contains(pokemon.tipo1))
            return 2.0f;
        if (listaDesventaja.get(this.tipo1).contains(pokemon.tipo1))
            return 0.5f;
        if (listaAtaqueNulo.get(this.tipo1).contains(pokemon.tipo1))
            return 0f;
        return 1f;
    }


    public boolean combatir(Pokemon pokemonRival) {
        return false;
    }

    public void anadirExperiencia(int nivelExperiencia) {
        this.nivelExperiencia += nivelExperiencia;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", tipo1=" + tipo1 +
                ", tipo2=" + tipo2 +
                '}';
    }
}



