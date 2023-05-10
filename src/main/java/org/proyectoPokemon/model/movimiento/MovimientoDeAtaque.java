package org.proyectoPokemon.model.movimiento;

import org.proyectoPokemon.model.Pokemon;
import org.proyectoPokemon.model.Tipo;

//Quita vitalidad al enemigo
public class MovimientoDeAtaque extends Movimiento{
    private int potenciaDeAtaque;
    private Tipo tipoDelAtaque;


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

    //metodo para aplicar movimiento de ataque
    public int aplicarMovimentoAtaque(Pokemon pokemon){
        if (pokemon.getEstamina() < getCosteDeEstamina()){
            return 0;
        }else
        pokemon.setEstamina(pokemon.getEstamina() - this.getCosteDeEstamina());
        return this.potenciaDeAtaque;
    }

}
