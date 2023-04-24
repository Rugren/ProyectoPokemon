package proyectoPokemon.model.movimiento;

import proyectoPokemon.model.Pokemon;

public class MovimientoDeMejora extends Movimiento{
    private TipoMejora mejoraAplicada;
    private int turnosDuracion;


    public MovimientoDeMejora(String nombre, int costeDeEstamina, TipoMejora mejoraAplicada, int turnosDuracion) {
        super(nombre, costeDeEstamina);
        this.mejoraAplicada = mejoraAplicada;
        this.turnosDuracion = turnosDuracion;
        setCosteDeEstamina(this.turnosDuracion * 10);
    }

    public TipoMejora getMejoraAplicada() {
        return mejoraAplicada;
    }

    public void setMejoraAplicada(TipoMejora mejoraAplicada) {
        this.mejoraAplicada = mejoraAplicada;
    }

    public int getTurnosDuracion() {
        return turnosDuracion;
    }

    public void setTurnosDuracion(int turnosDuracion) {
        this.turnosDuracion = turnosDuracion;
    }

    //Metodo para aplicar movimineto de mejora
    public String aplicarMovimentoMejora(Pokemon pokemon){
        String mensaje = "";
        if (getCosteDeEstamina() > pokemon.getEstamina()){
            mensaje = "No hay estamina suficiente.";
            return mensaje;
        }else
            pokemon.setEstamina(pokemon.getEstamina() - this.getCosteDeEstamina());
        mensaje = this.getMejoraAplicada() + " durante " + this.turnosDuracion + " turnos";
        return mensaje;
    }
}
