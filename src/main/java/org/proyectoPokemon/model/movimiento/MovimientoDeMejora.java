package org.proyectoPokemon.model.movimiento;

import org.proyectoPokemon.model.Pokemon;

/**
 * Clase principal de nuestro proyecto Pokemon / MovimientoDeMejora
 * @author Rugren MikelAnderson
 * @version
 */
public class MovimientoDeMejora extends Movimiento{
    private TipoMejora mejoraAplicada;
    private int turnosDuracion;

    /**
     * Constructor hijo para los movimientos de mejora
     * se añade el movimiento a la lista de movimientos
     * @param nombre
     * @param costeDeEstamina
     * @param mejoraAplicada
     * @param turnosDuracion
     */
    public MovimientoDeMejora(String nombre, int costeDeEstamina, TipoMejora mejoraAplicada, int turnosDuracion) {
        super(nombre);
        this.mejoraAplicada = mejoraAplicada;
        this.turnosDuracion = turnosDuracion;
        setCosteDeEstamina(this.turnosDuracion * 10);
    }

    public TipoMejora getMejoraAplicada() {
        return mejoraAplicada;
    }

    public void setMejoraAplicada(TipoMejora mejoraAplicada) {
        this.mejoraAplicada = mejoraAplicada;
    }

    public int getTurnosDuracion() {
        return turnosDuracion;
    }

    public void setTurnosDuracion(int turnosDuracion) {
        this.turnosDuracion = turnosDuracion;
    }

    /**
     * Constructor aplicarMovimentoMejora
     * Metodo para aplicar movimineto de mejora
     * @param pokemon
     */
    public String aplicarMovimentoMejora(Pokemon pokemon){
        String mensaje = "";
        if (getCosteDeEstamina() > pokemon.getEstamina()){
            mensaje = "No hay estamina suficiente.";
            return mensaje;
        }else
            pokemon.setEstamina(pokemon.getEstamina() - this.getCosteDeEstamina());
        mensaje = this.getMejoraAplicada() + " durante " + this.turnosDuracion + " turnos";
        return mensaje;
    }
}
