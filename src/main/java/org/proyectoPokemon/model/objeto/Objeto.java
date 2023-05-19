package org.proyectoPokemon.model.objeto;

import org.proyectoPokemon.model.Pokemon;

import java.util.LinkedList;

/**
 * Clase principal de nuestro proyecto Pokemon / Objeto // ESTA SERÍA NUESTRA TIENDA
 * @author Rugren MikelAnderson
 * @version
 */
public class Objeto{
    private String nombre;
    private TipoObjeto tipoDeObjeto;
    private static LinkedList<Objeto> tienda = new LinkedList<>();

    /**
     * Método Objeto
     * Constructor que crea un objeto y lo añade a la tienda.
     * @param nombre
     * @param tipoDeObjeto
     */
    public Objeto(String nombre, TipoObjeto tipoDeObjeto) {
        this.nombre = nombre;
        this.tipoDeObjeto = tipoDeObjeto;
        tienda.add(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoObjeto getTipoDeObjeto() {
        return tipoDeObjeto;
    }

    public void setTipoDeObjeto(TipoObjeto tipoDeObjeto) {
        this.tipoDeObjeto = tipoDeObjeto;
    }

    public static LinkedList<Objeto> getTienda() {
        return tienda;
    }

    public static void setTienda(LinkedList<Objeto> tienda) {
        Objeto.tienda = tienda;
    }

    /**
     * Metodo para aplicar los objetos al pokemon segun sea su tipo de Objeto
     * @param pokemon
     * @param tipoDeObjeto
     * @return
     */
    public boolean aplicarObjeto(Pokemon pokemon, TipoObjeto tipoDeObjeto){
        if (!(pokemon.getObjeto() == null))
            return false;
        if(tipoDeObjeto == TipoObjeto.PESA){
            pokemon.setAtaque(pokemon.getAtaque() + 2);
            pokemon.setVelocidad(pokemon.getVelocidad() - 1);
            return true;
        }
        if (tipoDeObjeto == TipoObjeto.PLUMA){
            pokemon.setVelocidad(pokemon.getVelocidad() + 3);
            pokemon.setDefensa(pokemon.getDefensa() - 2);
            pokemon.setDefensaEspecial(pokemon.getDefensaEspecial() - 2);
            return true;

        }
        if(tipoDeObjeto == TipoObjeto.CHALECO){
            pokemon.setDefensa(pokemon.getDefensa() + 2);
            pokemon.setDefensaEspecial(pokemon.getDefensaEspecial() - 2);
            pokemon.setVelocidad(pokemon.getVelocidad() - 1);
            pokemon.setAtaque(pokemon.getAtaque() - 1);
            return true;

        }
        if(tipoDeObjeto == TipoObjeto.BASTON){
            pokemon.setEstamina(pokemon.getEstamina() + 2);
            pokemon.setVelocidad(pokemon.getVelocidad() - 1);
            return true;

        }
        if (tipoDeObjeto == TipoObjeto.PILAS){
            pokemon.descansar();
            pokemon.setDefensaEspecial(pokemon.getDefensaEspecial() - 3);
            return true;
        }return true;
    }


}
