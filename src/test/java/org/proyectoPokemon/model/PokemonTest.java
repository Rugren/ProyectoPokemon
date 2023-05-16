package org.proyectoPokemon.model;

import junit.framework.TestCase;
import org.proyectoPokemon.model.movimiento.MovimientoDeAtaque;

public class PokemonTest extends TestCase {

    public void testSubirNivel() {
    }

    public void testAprenderMovimiento() {
        MovimientoDeAtaque mA1 = new MovimientoDeAtaque("impactrueno", 10, Tipo.ELECTRICO);
        Pokemon p1 = new Pokemon("Pikachu","juanito", Sexo.MACHO,Tipo.ELECTRICO,null);

    }

    public void testQuitarmoviento() {
    }

    public void testAtacar() {
    }

    public void testDescansar() {
    }

    public void testGetListaDesventaja() {
    }

    public void testGetListaVentaja() {
    }

    public void testGetListaAtaqueNulo() {
    }

    public void testComprobarVentaja() {
    }
}