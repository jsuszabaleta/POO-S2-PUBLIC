import java.time.LocalDateTime;

public class RangoHorario {

    private LocalDateTime inicio;
    private LocalDateTime finalHorario;

    public RangoHorario(LocalDateTime inicio, LocalDateTime finalHorario) {
        this.inicio = inicio;
        this.finalHorario = finalHorario;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFinal() {
        return finalHorario;
    }

    public Boolean seSolapan(RangoHorario otro) {
        if (this.inicio.isBefore(otro.getFinal()) && otro.getInicio().isBefore(this.finalHorario)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "RangoHorario{inicio=" + inicio + ", final=" + finalHorario + "}";
    }
}