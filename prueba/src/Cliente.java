public class Cliente extends Persona{
    private static int contadorCliente = 0;


    public Cliente(String nombre, String telefono){
        super("CLI-" + contadorCliente, nombre, telefono);
        contadorCliente++;
    }
    protected Cliente(String id, String nombre, String telefono) {
        super(id, nombre, telefono);
    }
    @Override
    public void mostrarDetalles(){
        System.out.println("Cliente estandar " + "| Nombre: " + getNombre()
        + " | Telefono " + getTelefono() + " | ID: " + getId());
    }
    public double calcularTotal(double total){
        return total;
    }
}
