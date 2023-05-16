package org.proyectoPokemon.model;

import org.junit.Test;
import org.proyectoPokemon.model.movimiento.MovimientoDeAtaque;

public class PokemonTest1 {

    @Test
    public void atacar() {
    }

    @Test
    public void descansar() {
    }

    @Test
    public void aprenderMovimiento(){
        MovimientoDeAtaque mA1 = new MovimientoDeAtaque("impactrueno", 10, Tipo.ELECTRICO);
        //Pokemon p1 = new Pokemon(idPokemon, "Pikachu","juanito", Sexo.MACHO,Tipo.ELECTRICO,null);

    }
}