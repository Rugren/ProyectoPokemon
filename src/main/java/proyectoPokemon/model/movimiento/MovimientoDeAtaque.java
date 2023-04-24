package proyectoPokemon.model.movimiento;

import proyectoPokemon.model.Pokemon;
import proyectoPokemon.model.Tipo;

//Quita vitalidad al enemigo
public class MovimientoDeAtaque extends Movimiento{
    private int potenciaDeAtaque;
    private Tipo tipoDelAtaque;


    public MovimientoDeAtaque(String nombre, int costeDeEstamina, int potenciaDeAtaque, Tipo tipoDelAtaque) {

        super(nombre, costeDeEstamina);
        this.potenciaDeAtaque = potenciaDeAtaque;
        this.tipoDelAtaque = tipoDelAtaque;
        setCosteDeEstamina(this.potenciaDeAtaque / 2);
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
