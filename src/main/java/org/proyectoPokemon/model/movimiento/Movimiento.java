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

    /**
     * Recorre la lista de todos los movimientos para devolver un movimiento concreto de la lista
     * @param movimiento
     * @return
     */
    public static Movimiento getMovimiento(Movimiento movimiento){
        for (int i = 0; i < movimientosDisponibles.size(); i++){
            if(movimientosDisponibles.get(i) == movimiento){
                return movimiento;
            }
        }return movimiento;
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

}
