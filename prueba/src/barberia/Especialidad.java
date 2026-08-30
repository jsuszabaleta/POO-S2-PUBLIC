package barberia;

public enum Especialidad {
    CORTE_CABELLO("Corte Tradicional y Moderno", 35000.0),
    AFEITADO_BARBA("Afeitado Classico y Ritual de Toalla Caliente", 25000.0),
    TRATAMIENTO_CAPILAR("Tratamiento Hidratante y Anti-Caida", 45000.0),
    COMBO_COMPLETO("Corte + Barba + Masaje Facial", 70000.0);
    private final String descripcion;
    private final double precioBase;

    Especialidad(String descripcion, double precioBase) {
        this.descripcion = descripcion;
        this.precioBase = precioBase;
    }
    
    public String getDescripcion() { return descripcion; }
    public double getPrecioBase() { return precioBase; }
}