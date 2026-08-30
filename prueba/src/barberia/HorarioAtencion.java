package barberia;
import java.util.Objects;

/**
* Clase Inmutable para garantizar la integridad de los bloques de tiempo agendados.
*/

public final class HorarioAtencion {
    private final String horaInicio;
    private final String horaFin;
    private final String diaSemana;

    public HorarioAtencion(String diaSemana, String horaInicio, String horaFin) {
        this.diaSemana = Objects.requireNonNull(diaSemana, "El dia no puede ser nulo");
        this.horaInicio = Objects.requireNonNull(horaInicio, "La hora de inicio no puede ser nula");
        this.horaFin = Objects.requireNonNull(horaFin, "La hora de fin no puede ser nula");
    }

    public String getDiaSemana() { return diaSemana; }
    public String getHoraInicio() { return horaInicio; }
    public String getHoraFin() { return horaFin; }

    @Override
    public String toString() {
        return diaSemana + " [" + horaInicio + " - " + horaFin + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorarioAtencion que = (HorarioAtencion) o;
        return Objects.equals(horaInicio, que.horaInicio) &&
            Objects.equals(horaFin, que.horaFin) &&
            Objects.equals(diaSemana, que.diaSemana);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horaInicio, horaFin, diaSemana);
    }
}