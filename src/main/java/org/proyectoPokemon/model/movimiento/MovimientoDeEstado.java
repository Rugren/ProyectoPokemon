package org.proyectoPokemon.model.movimiento;

import org.proyectoPokemon.model.Estado;
import org.proyectoPokemon.model.Pokemon;

//Altera el estado del pokemon Enemigo
public class MovimientoDeEstado extends Movimiento{
    private Estado estadoAplicado;
    private int turnosDuracion;

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

    //Metodo aplicar movimiento de estado.
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
