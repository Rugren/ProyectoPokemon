package org.proyectoPokemon.model.objeto;

import java.util.LinkedList;

/**
 * Clase principal de nuestro proyecto Pokemon / Objeto
 * @author Rugren MikelAnderson
 * @version
 */
public abstract class Objeto{
    private String nombre;
    private TipoObjeto tipoDeObjeto;
    private static LinkedList<Objeto> Tienda;

    /**
     * Método Objeto
     * Constructor que crea un objeto y lo añade a la tienda.
     * @param nombre
     * @param tipoDeObjeto
     */
    public Objeto(String nombre, TipoObjeto tipoDeObjeto) {
        this.nombre = nombre;
        this.tipoDeObjeto = tipoDeObjeto;
        Tienda.add(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // CREAR METODO APLICAR PESA, APLICAR pluma, etc. SERÍA NUESTRA TIENDA

}
