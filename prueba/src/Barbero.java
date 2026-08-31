public class Barbero extends Persona {
    private static int contadorBarbero = 1;
    private final int calificacion;
    private final Especializacion especializacion;
    private final double[] produccionSemanal;

    public Barbero(String nombre, String telefono, int calificacion, Especializacion especializacion) {
        super("BAR-" + contadorBarbero, nombre, telefono);
        this.calificacion = calificacion;
        this.especializacion = especializacion;
        this.produccionSemanal = new double [7];
        contadorBarbero++;

    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Barbero | ID: " + getId()
                + " | Nombre: " + getNombre()
                + " | Teléfono: " + getTelefono()
                + " | Calificación: " + calificacion
                + " | Especialización: " + especializacion);
    }

    public Especializacion getEspecializacion() {
        return especializacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public double[] getProduccionSemanal() {
        return produccionSemanal;
    }

    public void registrarGanancia(int diaSemana, double monto) {
        if (diaSemana >= 0 && diaSemana < 7) {
            this.produccionSemanal[diaSemana] += monto;
        } else {
            System.out.println("Error: Día de la semana inválido (debe ser entre 0 y 6).");
        }
    }
}
