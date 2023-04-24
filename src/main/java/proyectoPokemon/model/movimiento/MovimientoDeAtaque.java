package proyectoPokemon.model.movimiento;

import proyectoPokemon.model.Pokemon;
import proyectoPokemon.model.Tipo;

//Quita vitalidad al enemigo
public class MovimientoDeAtaque extends Movimiento{
    private int potenciaDeAtaque;
    private Tipo tipoDelAtaque;


    public MovimientoDeAtaque(String nombre, int costeDeEstamina, Tipo tipo) {
        super(nombre, costeDeEstamina, tipo);
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

    public void aplicarMovimentoAtaque(Pokemon pokemon){

    }
}
