package org.javafx.model;

import org.javafx.model.movimiento.Movimiento;
import org.javafx.model.objeto.Objeto;

import java.util.LinkedList;
import java.util.Random;

public class Pokemon {
    private String nombre;
    private String mote;
    private int vitalidad;
    private int ataque;
    private int defensa;
    private int ataqueEspecial;
    private int defensaEspecial;
    private int velocidad;
    private int estamina;
    private int nivel = 1;
    private Movimiento movimiento;

    private Movimiento[] listaDeMovimientos = new Movimiento[4];
    private int fertilidad = 5;
    private Sexo sexo;
    private Tipo tipo;
    private Estado estado;
    private Objeto objeto;
    private int nivelExperiencia;

    public Pokemon(String nombre, String mote,
                   Movimiento[] listaDeMovimientos,
                   Sexo sexo, Tipo tipo, Estado estado, Objeto objeto) {
        Random rnd = new Random();
        this.nombre = nombre;
        this.mote = mote;
        this.vitalidad = rnd.nextInt(10) + 1;
        this.ataque = rnd.nextInt(10) + 1;
        this.defensa = rnd.nextInt(10) + 1;
        this.ataqueEspecial = rnd.nextInt(10) + 1;
        this.defensaEspecial = rnd.nextInt(10) + 1;
        this.velocidad = rnd.nextInt(10) + 1;
        this.estamina = rnd.nextInt(10) + 1;
        this.nivel = 1;
        this.listaDeMovimientos = listaDeMovimientos;
        this.fertilidad = 5;
        this.sexo = sexo;
        this.tipo = tipo;
        this.estado = estado;
        this.objeto = objeto;
        this.nivelExperiencia = 1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMote() {
        return mote;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public int getVitalidad() {
        return vitalidad;
    }

    public void setVitalidad(int vitalidad) {
        this.vitalidad = vitalidad;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public void setAtaqueEspecial(int ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    public void setDefensaEspecial(int defensaEspecial) {
        this.defensaEspecial = defensaEspecial;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getEstamina() {
        return estamina;
    }

    public void setEstamina(int estamina) {
        this.estamina = estamina;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public int getFertilidad() {
        return fertilidad;
    }

    public void setFertilidad(int fertilidad) {
        this.fertilidad = fertilidad;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public int getNivelExperiencia() {
        return nivelExperiencia;
    }

    public void setNivelExperiencia(int nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }



    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    //FUNCIONES DEL POKEMON
    public void subirNivel(){
        Random rnd = new Random();
        if (nivelExperiencia == 10 * nivel){
            setVitalidad(this.vitalidad + (rnd.nextInt(5) + 1));
            setAtaque(this.ataque + (rnd.nextInt(5) + 1));
            setDefensa(this.defensa + (rnd.nextInt(5) + 1));
            setAtaqueEspecial(this.ataqueEspecial + (rnd.nextInt(5) + 1));
            setDefensaEspecial(this.defensaEspecial + (rnd.nextInt(5) + 1));
            setVelocidad(this.velocidad + (rnd.nextInt(5) + 1));
        }
        if (nivel % 3 == 0){
            aprenderMovimiento();
        }
    }
    public void atacar(Pokemon pokemon){

    }

    public String comprobarVentaja(Pokemon pokemon){
        String mensaje = "";
        if (this.tipo == Tipo.AGUA){
            if (pokemon.tipo == Tipo.AGUA || pokemon.tipo == Tipo.DRAGON || pokemon.tipo == Tipo.PLANTA){
                mensaje = "VENTAJA";
            }else if(pokemon.tipo == Tipo.FUEGO || pokemon.tipo == Tipo.ROCA || pokemon.tipo == Tipo.TIERRA){
                mensaje = "DOBLE_VENTAJA";
            }else
                mensaje = "NEUTRO";
            }
        if (this.tipo == Tipo.BICHO){
            if (pokemon.tipo == Tipo.FANTASMA || pokemon.tipo == Tipo.FUEGO || pokemon.tipo == Tipo.LUCHA){
                mensaje = "VENTAJA";
            }else if(pokemon.tipo == Tipo.PLANTA || pokemon.tipo == Tipo.PSIQUICO || pokemon.tipo == Tipo.VENENO){
                mensaje = "DOBLE_VENTAJA";
            }else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.DRAGON){
            if(pokemon.tipo == Tipo.DRAGON){
                mensaje = "DOBLE_VENTAJA";
            }else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.ELECTRICO){
            if (pokemon.tipo == Tipo.DRAGON || pokemon.tipo == Tipo.ELECTRICO || pokemon.tipo == Tipo.PLANTA){
                mensaje = "VENTAJA";
            }else if(pokemon.tipo == Tipo.AGUA || pokemon.tipo == Tipo.VOLADOR){
                mensaje = "DOBLE_VENTAJA";
            }else if (pokemon.tipo == Tipo.TIERRA){
                mensaje = "DESVENTAJA";
            }
            else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.FANTASMA){
            if (pokemon.tipo == Tipo.FANTASMA){
                mensaje = "DOBLE_VENTAJA";
            }else if (pokemon.tipo == Tipo.NORMAL || pokemon.tipo == Tipo.PSIQUICO){
                mensaje = "DESVENTAJA";
            }else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.FUEGO){
            if (pokemon.tipo == Tipo.AGUA || pokemon.tipo == Tipo.DRAGON || pokemon.tipo == Tipo.FUEGO || pokemon.tipo == Tipo.ROCA){
                mensaje = "VENTAJA";
            }else if(pokemon.tipo == Tipo.BICHO || pokemon.tipo == Tipo.HIELO || pokemon.tipo == Tipo.PLANTA){
                mensaje = "DOBLE_VENTAJA";
            }else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.HIELO){
            if (pokemon.tipo == Tipo.AGUA || pokemon.tipo == Tipo.HIELO){
                mensaje = "VENTAJA";
            }else if(pokemon.tipo == Tipo.DRAGON || pokemon.tipo == Tipo.PLANTA || pokemon.tipo == Tipo.TIERRA || pokemon.tipo == Tipo.VOLADOR){
                mensaje = "DOBLE_VENTAJA";
            }else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.LUCHA){
            if (pokemon.tipo == Tipo.BICHO || pokemon.tipo == Tipo.PSIQUICO ||
                pokemon.tipo == Tipo.VENENO || pokemon.tipo == Tipo.VOLADOR){
                mensaje = "VENTAJA";
            }else if(pokemon.tipo == Tipo.HIELO || pokemon.tipo == Tipo.NORMAL || pokemon.tipo == Tipo.ROCA){
                mensaje = "DOBLE_VENTAJA";
            }else if (pokemon.tipo == Tipo.FANTASMA){
                mensaje = "DESVENTAJA";
            }
            else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.NORMAL){
            if (pokemon.tipo == Tipo.FANTASMA){
                mensaje = "DESVENTAJA";
            }else if (pokemon.tipo == Tipo.PSIQUICO){
                mensaje = "VENTAJA";
            }else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.PLANTA){
            if (pokemon.tipo == Tipo.BICHO || pokemon.tipo == Tipo.DRAGON || pokemon.tipo == Tipo.FUEGO ||
                pokemon.tipo == Tipo.PLANTA || pokemon.tipo == Tipo.VENENO || pokemon.tipo == Tipo.VOLADOR){
                mensaje = "VENTAJA";
            }else if(pokemon.tipo == Tipo.AGUA || pokemon.tipo == Tipo.ROCA || pokemon.tipo == Tipo.TIERRA){
                mensaje = "DOBLE_VENTAJA";
            }else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.PSIQUICO){
            if (pokemon.tipo == Tipo.PSIQUICO){
                mensaje = "VENTAJA";
            }else if(pokemon.tipo == Tipo.LUCHA || pokemon.tipo == Tipo.VENENO){
                mensaje = "DOBLE_VENTAJA";
            }else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.ROCA){
            if (pokemon.tipo == Tipo.LUCHA || pokemon.tipo == Tipo.TIERRA){
                mensaje = "VENTAJA";
            }else if(pokemon.tipo == Tipo.BICHO || pokemon.tipo == Tipo.FUEGO || pokemon.tipo == Tipo.HIELO ||
                    pokemon.tipo == Tipo.VOLADOR){
                mensaje = "DOBLE_VENTAJA";
            }else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.TIERRA){
            if (pokemon.tipo == Tipo.BICHO || pokemon.tipo == Tipo.PLANTA){
                mensaje = "VENTAJA";
            }else if(pokemon.tipo == Tipo.ELECTRICO || pokemon.tipo == Tipo.FUEGO || pokemon.tipo == Tipo.ROCA ||
                    pokemon.tipo == Tipo.VENENO){
                mensaje = "DOBLE_VENTAJA";
            }else if (pokemon.tipo == Tipo.VOLADOR){
                mensaje = "DESVENTAJA";
            }
            else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.VENENO){
            if (pokemon.tipo == Tipo.FANTASMA || pokemon.tipo == Tipo.ROCA || pokemon.tipo == Tipo.TIERRA ||
                pokemon.tipo == Tipo.VENENO){
                mensaje = "VENTAJA";
            }else if(pokemon.tipo == Tipo.BICHO || pokemon.tipo == Tipo.PLANTA){
                mensaje = "DOBLE_VENTAJA";
            }else
                mensaje = "NEUTRO";
        }
        if (this.tipo == Tipo.VOLADOR){
            if (pokemon.tipo == Tipo.ELECTRICO || pokemon.tipo == Tipo.ROCA){
                mensaje = "VENTAJA";
            }else if(pokemon.tipo == Tipo.BICHO || pokemon.tipo == Tipo.LUCHA || pokemon.tipo == Tipo.PLANTA){
                mensaje = "DOBLE_VENTAJA";
            }else
                mensaje = "NEUTRO";
        }
    return mensaje;
    }

    public void descansar(){
        setEstamina(this.estamina + 15);
    }

    public void aprenderMovimiento(){

    }

}
