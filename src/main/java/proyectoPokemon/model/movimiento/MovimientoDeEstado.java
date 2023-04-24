package proyectoPokemon.model.movimiento;

import proyectoPokemon.model.Estado;
//Altera el estado del pokemon Enemigo
public class MovimientoDeEstado extends Movimiento{
    private Estado estadoAplicado;
    private int turnosDuracion;

    public MovimientoDeEstado(String nombre, int costeDeEstamina) {
        super(nombre, costeDeEstamina);
    }
}
