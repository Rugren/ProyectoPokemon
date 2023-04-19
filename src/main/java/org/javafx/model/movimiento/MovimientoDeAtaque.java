package org.javafx.model.movimiento;

import org.javafx.model.Tipo;

//Quita vitalidad al enemigo
public class MovimientoDeAtaque extends Movimiento{
    private int potenciaDeAtaque;
    private Tipo tipoDelAtaque;


    public MovimientoDeAtaque(String nombre, int costeDeEstamina) {
        super(nombre, costeDeEstamina);
    }
}
