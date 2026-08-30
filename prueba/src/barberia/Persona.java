package barberia;
public abstract class Persona {
    private String id;
    private String nombre;
    private String telefono;

    public Persona(String id, String nombre, String telefono){
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    public String getNombre(){
        return nombre;
    }
    public String getId(){
        return id;
    }

    public String getTelefono() {
        return telefono;
    }

    public abstract void mostrarDetalles();
}
