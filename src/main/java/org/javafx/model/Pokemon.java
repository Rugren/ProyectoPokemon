package org.javafx.model;

import org.javafx.model.movimiento.Movimiento;
import org.javafx.model.objeto.Objeto;

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
    private int fertilidad = 5;
    private Sexo sexo;
    private Tipo tipo;
    private Objeto objeto;
    private int nivelExperiencia;
    private TipoEstado estado;
    private TipoVentaja ventaja;

    public Pokemon(String nombre, String mote, int vitalidad, int ataque,
                   int defensa, int ataqueEspecial, int defensaEspecial, int velocidad,
                   int estamina, int nivel, Movimiento movimiento, int fertilidad, Sexo sexo,
                   Tipo tipo, Objeto objeto, int nivelExperiencia, TipoEstado estado,
                   TipoVentaja ventaja) {
        this.nombre = nombre;
        this.mote = mote;
        this.vitalidad = vitalidad;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.velocidad = velocidad;
        this.estamina = estamina;
        this.nivel = nivel;
        this.movimiento = movimiento;
        this.fertilidad = fertilidad;
        this.sexo = sexo;
        this.tipo = tipo;
        this.objeto = objeto;
        this.nivelExperiencia = nivelExperiencia;
        this.estado = estado;
        this.ventaja = ventaja;
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

    public TipoEstado getEstado() {
        return estado;
    }

    public void setEstado(TipoEstado estado) {
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
    }


    public void atacar(Pokemon pokemon){

    }

    public String comprobarVentaja(Pokemon pokemon){
        if ()
    }

    public void descansar(){
        setEstamina(this.estamina = this.estamina + );
    }

    public void aprenderMovimiento(){

    }

}
