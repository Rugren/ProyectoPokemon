package proyectoPokemon.model.movimiento;

public class MovimientoDeMejora extends Movimiento{
    private TipoMejora mejoraAplicada;
    private int turnosDuracion;


    public MovimientoDeMejora(String nombre, int costeDeEstamina) {
        super(nombre, costeDeEstamina);
    }
}
