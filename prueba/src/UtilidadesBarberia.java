import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public final class UtilidadesBarberia {

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static final NumberFormat FORMATO_MONEDA = NumberFormat.getCurrencyInstance(Locale.US);

    private UtilidadesBarberia() {
        throw new IllegalStateException("Clase utilitaria de apoyo para la barbería");
    }

    public static String formatearMoneda(double valor) {
        return FORMATO_MONEDA.format(valor);
    }

    public static RangoHorario crearHorario(LocalDateTime inicio, int duracionMinutos) {
        if (inicio == null || duracionMinutos <= 0) {
            throw new IllegalArgumentException("El horario debe tener una fecha inicial válida y duración positiva.");
        }
        return new RangoHorario(inicio, inicio.plusMinutes(duracionMinutos));
    }

    public static String formatearHorario(RangoHorario horario) {
        if (horario == null) {
            return "Horario no disponible";
        }
        return horario.getInicio().format(FORMATO_FECHA) + " - " + horario.getFinal().format(FORMATO_FECHA);
    }

    public static String resumenCita(Citas cita) {
        if (cita == null) {
            return "No hay una cita disponible para mostrar.";
        }

        StringBuilder resumen = new StringBuilder();
        resumen.append("Cita #")
                .append(cita.getIdCita())
                .append(" | Cliente: ")
                .append(cita.getCliente().getNombre())
                .append(" | Barbero: ")
                .append(cita.getBarbero().getNombre())
                .append(" | Horario: ")
                .append(formatearHorario(cita.getHorario()))
                .append(" | Total: ")
                .append(formatearMoneda(cita.calcularCostoTotal()));

        return resumen.toString();
    }
}
