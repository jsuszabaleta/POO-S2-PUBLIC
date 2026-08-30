public enum TipoServicio {
    CORTE_CABELLO("Corte de Cabello", 15000.0, 30),
    AFEITADO("Afeitado", 10000.0, 20),
    TRATAMIENTO_BARBA("Tratamiento de Barba", 20000.0, 40);

    private final String nombre;
    private final double precio;
    private final int duracionMin;

    TipoServicio(String nombre, double precio, int duracionMin) {
        this.nombre = nombre;
        this.precio = precio;
        this.duracionMin = duracionMin;
    }

    @Override
    public String toString() {
        return "Tipo de servicio a recibir:" +
                "| Nombre: " + nombre + '\'' +
                "| precio: " + precio +
                "| duracion minima: " + duracionMin
                ;
    }

   public double getPrecio() {
    return precio;
}

public int getDuracionMin() {
    return duracionMin;
}

public String getNombre() {
    return nombre;
}
    }

