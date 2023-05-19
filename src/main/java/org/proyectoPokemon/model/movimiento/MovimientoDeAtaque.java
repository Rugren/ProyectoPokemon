package org.proyectoPokemon.model.movimiento;

import org.proyectoPokemon.model.Pokemon;
import org.proyectoPokemon.model.Tipo;

/**
 * Clase principal de nuestro proyecto Pokemon / MovimientoDeAtaque
 * Quita vitalidad al enemigo
 * @author Rugren MikelAnderson
 * @version
 */
public class MovimientoDeAtaque extends Movimiento{
    private int potenciaDeAtaque;
    private Tipo tipoDelAtaque;

    /**
     * Constructor hijo para los movimientos de Ataque
     * añade el movimiento a la lista de todos los movimientos
     * @param nombre
     * @param potenciaDeAtaque
     * @param tipoDelAtaque
     */
    public MovimientoDeAtaque(String nombre, int potenciaDeAtaque, Tipo tipoDelAtaque) {
        super(nombre);
        this.potenciaDeAtaque = potenciaDeAtaque;
        this.tipoDelAtaque = tipoDelAtaque;
        setCosteDeEstamina(this.potenciaDeAtaque / 2);
        addMovimiento(this);

    }

    public int getPotenciaDeAtaque() {
        return potenciaDeAtaque;
    }

    public void setPotenciaDeAtaque(int potenciaDeAtaque) {
        this.potenciaDeAtaque = potenciaDeAtaque;
    }

    public Tipo getTipoDelAtaque() {
        return tipoDelAtaque;
    }

    public void setTipoDelAtaque(Tipo tipoDelAtaque) {
        this.tipoDelAtaque = tipoDelAtaque;
    }

    /**
     * Constructor aplicarMovimentoAtaque
     * metodo para aplicar movimiento de ataque a los pokemon
     * @param pokemon
     */
    public int aplicarMovimentoAtaque(Pokemon pokemon){
        if (pokemon.getEstamina() < getCosteDeEstamina()){
            return 0;
        }else
        pokemon.setEstamina(pokemon.getEstamina() - this.getCosteDeEstamina());
        return this.potenciaDeAtaque;
    }

}
