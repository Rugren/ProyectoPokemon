package org.proyectoPokemon.model.movimiento;

import org.proyectoPokemon.model.Pokemon;

import java.util.LinkedList;

/**
 * Clase principal de nuestro proyecto Pokemon / Movimiento
 * @author Rugren MikelAnderson
 * @version
 */
public abstract class Movimiento {
    private String nombre;
    private int costeDeEstamina;


    private static LinkedList<Movimiento> movimientosDisponibles = new LinkedList<>();

    /**
     * Método del nombre del Movimiento
     * @param nombre
     */
    public Movimiento(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getCosteDeEstamina() {
        return costeDeEstamina;
    }

    public void setCosteDeEstamina(int costeDeEstamina) {
        this.costeDeEstamina = costeDeEstamina;
    }

    private static LinkedList<Movimiento> getMovimientosDisponibles() {
        return movimientosDisponibles;
    }
    public static Movimiento getMovimiento(int movimiento){
        return Movimiento.movimientosDisponibles.get(movimiento);

    }

    public static void setMovimientosDisponibles(LinkedList<Movimiento> movimientosDisponibles) {
        Movimiento.movimientosDisponibles = movimientosDisponibles;
    }

    /**
     * Método addMovimiento
     * contructor que añade un movimiento nuevo a nuestros movimientos que ya tenemos
     * @param movimiento
     */
    public static void addMovimiento(Movimiento movimiento){
        movimientosDisponibles.add(movimiento);
    }

    /**
     * Método aplicarMovimiento
     * contructor que aplica movimiento al pokemon, es decir, que se lo añade los movientos que ya tenía el pokemon.
     * @param pokemon
     */
    //Aplicar movimiento
    public void aplicarMovimiento(Pokemon pokemon){

    }
}
