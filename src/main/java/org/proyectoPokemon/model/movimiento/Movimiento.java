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

    private static LinkedList<Movimiento> getMovimientosDisponibles() {
        return movimientosDisponibles;
    }
    public static Movimiento getMovimiento(int movimiento){
        return Movimiento.movimientosDisponibles.get(movimiento);

    }

    public static void setMovimientosDisponibles(LinkedList<Movimiento> movimientosDisponibles) {
        Movimiento.movimientosDisponibles = movimientosDisponibles;
    }
    public static void addMovimiento(Movimiento movimiento){
        movimientosDisponibles.add(movimiento);
    }

    //Aplicar movimiento
    public void aplicarMovimiento(Pokemon pokemon){

    }
}
