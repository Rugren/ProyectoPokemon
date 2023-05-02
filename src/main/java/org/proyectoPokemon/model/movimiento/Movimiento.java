package org.proyectoPokemon.model.movimiento;

import org.proyectoPokemon.model.Pokemon;

import java.util.LinkedList;

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

    public static LinkedList<Movimiento> getMovimientosDisponibles() {
        return movimientosDisponibles;
    }

    public static void setMovimientosDisponibles(LinkedList<Movimiento> movimientosDisponibles) {
        Movimiento.movimientosDisponibles = movimientosDisponibles;
    }

    //Aplicar movimiento
    public void aplicarMovimiento(Pokemon pokemon){

    }
}
