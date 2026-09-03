import java.util.Objects;

public class Habitacion {
    private String idHabitacion;
    private String tipoHabitacion;
    private int tarifaBase;
    private double descuento;
    private double recargo;


    public Habitacion(String idHabitacion, String tipoHabitacion, int tarifaBase, double descuento, double recargo){
        this.idHabitacion = idHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        if(tarifaBase <= 0){
            throw new IllegalArgumentException(new tarifaNegativaException("No se puede crear una habitacion " +
                    "con una tarifa base negativa o igual a cero"));
        }
        this.tarifaBase = tarifaBase;
        this.descuento = descuento;
        this.recargo = recargo;
    }

    @Override
    public String toString() {
        return "Caracteristicas de la habitacion: {" +
                "Su numero: '" + idHabitacion + '\'' +
                ", Su tipo de habitacion: '" + tipoHabitacion + '\'' +
                ", Tarifa base: " + tarifaBase +
                ", Descuento aproximado: " + (descuento*100 + "%") +
                ", Recargo aproximado: " + (recargo*100 + "%") +
                '}';
    }
    public double calcularPrecio(){
        double descuentoTotal = tarifaBase * descuento;
        double recargoTotal = tarifaBase * recargo;
        return tarifaBase+descuentoTotal+recargoTotal;
    }

    public String getIdHabitacion() {
        return idHabitacion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Habitacion that = (Habitacion) o;
        return Objects.equals(getIdHabitacion(), that.getIdHabitacion());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdHabitacion());
    }
}
