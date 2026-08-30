package barberia;

/**
* Excepcion de regla de negocio: no permite agendar dos citas al mismo barbero en el mismo horario.
*/

public class HorarioOcupadoException extends Exception {
    private final String nombreBarbero;
    private final String horario;

    public HorarioOcupadoException(String nombreBarbero, String horario) {
        super("EL BARBERO " + nombreBarbero + " YA TIENE UNA CITA AGENDADA EN EL HORARIO: " +
        horario);
        this.nombreBarbero = nombreBarbero;
        this.horario = horario;
    }
    
    public String getNombreBarbero() { return nombreBarbero; }
    public String getHorario() { return horario; }
}