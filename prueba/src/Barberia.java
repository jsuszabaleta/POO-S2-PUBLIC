import java.util.ArrayList;
import java.time.LocalDateTime;

public class Barberia {
    private ArrayList<Barbero> barberos;
    private ArrayList<Citas> citas;

    public Barberia() {
        this.barberos = new ArrayList<>();
        this.citas = new ArrayList<>();
    }

    // Sobrecarga 1: agendar cita con UN solo servicio
    public Citas agendarCita(Cliente cliente, Barbero barbero, TipoServicio servicio, RangoHorario horario) {
        validarBarbero(barbero);
        validarHorarioLibre(barbero, horario);

        Citas nuevaCita = new Citas(cliente, barbero, servicio, horario);
        citas.add(nuevaCita);
        return nuevaCita;
    }

    // Sobrecarga 2: agendar cita con VARIOS servicios
    public Citas agendarCita(Cliente cliente, Barbero barbero, TipoServicio[] servicios, RangoHorario horario) {
        validarBarbero(barbero);
        validarHorarioLibre(barbero, horario);

        Citas nuevaCita = new Citas(cliente, barbero, servicios, horario);
        citas.add(nuevaCita);
        return nuevaCita;
    }

    private void validarBarbero(Barbero barbero) {
        if (!barberos.contains(barbero)) {
            throw new BarberoNoDisponibleException(
                "El barbero " + barbero.getNombre() + " no pertenece a esta barbería.");
        }
    }

    private void validarHorarioLibre(Barbero barbero, RangoHorario horario) {
        for (Citas c : citas) {
            if (c.getBarbero().equals(barbero) && c.getHorario().seSolapan(horario)) {
                throw new HorarioOcupadoException(
                    "El barbero " + barbero.getNombre() + " ya tiene una cita en ese horario.");
            }
        }
    }

    public Citas buscarCitaPorId(int idCita) {
        for (Citas c : citas) {
            if (c.getIdCita() == idCita) {
                return c;
            }
        }
        throw new CitaNoEncontradaException("No existe una cita con el ID " + idCita);
    }

    public double calcularProduccion(Barbero b, LocalDateTime fecha) {
        double total = 0;
        for (Citas c : citas) {
            if (c.getBarbero().equals(b) && c.getHorario().getInicio().toLocalDate().equals(fecha.toLocalDate())) {
                total += c.calcularCostoTotal();
            }
        }
        return total;
    }

    public ArrayList<Barbero> getBarberos() {
        return barberos;
    }

    public ArrayList<Citas> getCitas() {
        return citas;
    }
}
