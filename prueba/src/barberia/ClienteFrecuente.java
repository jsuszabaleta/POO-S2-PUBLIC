package barberia;
public class ClienteFrecuente extends Cliente{
    private final double descuento = 0.15;

    public ClienteFrecuente(String nombre, String telefono){
        super(nombre, telefono);
    }

    @Override
    public double calcularTotal(double subtotal){
        double montoDescontado = subtotal * descuento;
        return subtotal - montoDescontado;
    }
    @Override
    public void mostrarDetalles(){
        System.out.println("Cliente VIP" + " ID: " + getId() + " Nombre: " + getNombre() + " Telefono: "
        + getTelefono() + " descuento activo: " + (descuento * 100) + "%");

    }
}
