public class Citas implements Facturable {

    private static int contadorCitas = 0;

    private final int idCita;
    private Cliente cliente;
    private Barbero barbero;
    private TipoServicio[] servicios;
    private RangoHorario horario;

    // Constructor #1: una cita con un solo servicio
    public Citas(Cliente cliente, Barbero barbero, TipoServicio servicio, RangoHorario horario) {
        if (servicio == null) {
            throw new ServicioInvalidoException("La cita debe tener al menos un servicio.");
        }

        TipoServicio[] arregloServicios = new TipoServicio[1];
        arregloServicios[0] = servicio;

        contadorCitas = contadorCitas + 1;
        this.idCita = contadorCitas;
        this.cliente = cliente;
        this.barbero = barbero;
        this.servicios = arregloServicios;
        this.horario = horario;
    }

    // Constructor #2: una cita con varios servicios
    public Citas(Cliente cliente, Barbero barbero, TipoServicio[] servicios, RangoHorario horario) {
        if (servicios == null || servicios.length == 0) {
            throw new ServicioInvalidoException("La cita debe tener al menos un servicio.");
        }

        contadorCitas = contadorCitas + 1;
        this.idCita = contadorCitas;
        this.cliente = cliente;
        this.barbero = barbero;
        this.servicios = servicios;
        this.horario = horario;
    }

    public int getIdCita() {
        return idCita;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Barbero getBarbero() {
        return barbero;
    }

    public TipoServicio[] getServicios() {
        return servicios;
    }

    public RangoHorario getHorario() {
        return horario;
    }

    public static int getContadorCitas() {
        return contadorCitas;
    }

    public double calcularCostoTotal() {
        double subtotal = 0;
        for (TipoServicio servicio : servicios) {
            subtotal = subtotal + servicio.getPrecio();
        }
        return cliente.calcularTotal(subtotal);
    }

    public int calcularDuracionTotal() {
        int minutos = 0;
        for (TipoServicio servicio : servicios) {
            minutos = minutos + servicio.getDuracionMin();
        }
        return minutos;
    }

    @Override
    public String generarRecibo() {
        String recibo = "----- RECIBO CITA #" + idCita + " -----\n";
        recibo = recibo + "Cliente: " + cliente.getNombre() + "\n";
        recibo = recibo + "Barbero: " + barbero.getNombre() + "\n";
        recibo = recibo + "Servicios:\n";

        for (TipoServicio servicio : servicios) {
            recibo = recibo + "  - " + servicio.getNombre() + " ($" + servicio.getPrecio() + ")\n";
        }

        recibo = recibo + "Duracion total: " + calcularDuracionTotal() + " min\n";
        recibo = recibo + "Total a pagar: $" + calcularCostoTotal() + "\n";

        return recibo;
    }

    @Override
    public String toString() {
        return "Cita{id=" + idCita + ", cliente=" + cliente.getNombre() +
                ", barbero=" + barbero.getNombre() + ", total=$" + calcularCostoTotal() + "}";
    }
}