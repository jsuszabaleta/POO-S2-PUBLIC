package barberia;

/**
* Interfaz que define el contrato para elementos que generan un cobro en la barberia.
*/

public interface Facturable {
    double calcularTotalServicio();
    String generarReciboDetallado();
}