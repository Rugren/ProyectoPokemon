package org.javafx.model.movimiento;

import org.javafx.model.Estados;
//Altera el estado del pokemon Enemigo
public class MovimientoDeEstado extends Movimiento{
    private Estados estadoAplicado;
    private int turnosDuracion;

    public MovimientoDeEstado(String nombre, int costeDeEstamina) {
        super(nombre, costeDeEstamina);
    }
}
