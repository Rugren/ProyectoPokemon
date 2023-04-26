package proyectoPokemon.model;

import org.junit.jupiter.api.Test;
import proyectoPokemon.model.movimiento.Movimiento;
import proyectoPokemon.model.movimiento.MovimientoDeAtaque;
import proyectoPokemon.model.movimiento.MovimientoDeEstado;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {

    @Test
    void getListaDesventaja() {
    }

    @Test
    void getListaVentaja() {
    }

    @Test
    void getListaAtaqueNulo() {
    }

    @Test
    void comprobarVentaja() {
        MovimientoDeAtaque impactrueno = new MovimientoDeAtaque("impactrueno",20,Tipo.ELECTRICO);

        Movimiento[] listaDeMovimientosPikachu = new Movimiento[4];
        listaDeMovimientosPikachu[0] = impactrueno;


        Pokemon p1 = new Pokemon("pikachu", "lolo", listaDeMovimientosPikachu,
                Sexo.MACHO,Tipo.ELECTRICO);
        Pokemon p2 = new Pokemon("Charizard","Chaizard", listaDeMovimientosPikachu,Sexo.MACHO,Tipo.FUEGO);

        p1.comprobarVentaja(p2);

    }
}