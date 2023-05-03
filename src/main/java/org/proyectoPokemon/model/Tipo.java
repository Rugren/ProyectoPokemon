package org.proyectoPokemon.model;

import java.util.LinkedList;

public enum Tipo {
    AGUA, BICHO, DRAGON, ELECTRICO, FANTASMA, FUEGO, HIELO,
    LUCHA, NORMAL, PLANTA, PSIQUICO, ROCA, TIERRA, VENENO, VOLADOR;

    public Tipo getTipo(String tipo) {
        if (tipo.equals("AGUA"))
            return AGUA;
        return PLANTA;
    }

    static LinkedList<Tipo> listaTipos;

}
