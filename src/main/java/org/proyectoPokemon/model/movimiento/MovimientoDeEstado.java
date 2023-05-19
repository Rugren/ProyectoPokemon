package org.proyectoPokemon.model.movimiento;

import org.proyectoPokemon.model.Estado;
import org.proyectoPokemon.model.Pokemon;

/**
 * Clase principal de nuestro proyecto Pokemon / MovimientoDeEstado
 * Altera el estado del pokemon Enemigo
 * @author Rugren MikelAnderson
 * @version
 */

public class MovimientoDeEstado extends Movimiento{
    private Estado estadoAplicado;
    private int turnosDuracion;

    /**
     * Constructor hijo para los movimentos de Estado
     * se añade el movimiento a la lista de movimientos.
     * @param nombre
     * @param costeDeEstamina
     * @param estadoAplicado
     * @param turnosDuracion
     */
    public MovimientoDeEstado(String nombre, int costeDeEstamina, Estado estadoAplicado, int turnosDuracion) {
        super(nombre);
        this.estadoAplicado = estadoAplicado;
        this.turnosDuracion = turnosDuracion;
        setCosteDeEstamina(this.turnosDuracion * 10);
    }

    public Estado getEstadoAplicado() {
        return estadoAplicado;
    }

    public void setEstadoAplicado(Estado estadoAplicado) {
        this.estadoAplicado = estadoAplicado;
    }

    public int getTurnosDuracion() {
        return turnosDuracion;
    }

    public void setTurnosDuracion(int turnosDuracion) {
        this.turnosDuracion = turnosDuracion;
    }

    /**
     * Constructor aplicarMovimientoEstado
     * Método para aplicar movimiento de estado
     * @param pokemon
     */
    public String aplicarMovimientoEstado(Pokemon pokemon){
        String mensaje = "";
        if (pokemon.getEstamina() < getCosteDeEstamina()){
            mensaje = "No hay estamina suficiente para realizar movimiento.";
            return mensaje;
        }else
            pokemon.setEstamina(pokemon.getEstamina() - this.getCosteDeEstamina());
            pokemon.setEstado(this.estadoAplicado);
            mensaje = this.estadoAplicado + "durante " + this.turnosDuracion + " turnos.";
    return mensaje;
    }
}
