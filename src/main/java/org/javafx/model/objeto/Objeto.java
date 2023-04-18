package org.javafx.model.objeto;
import org.javafx.model.Pokemon;
public abstract class Objeto{
    private String nombre;

    public Objeto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
