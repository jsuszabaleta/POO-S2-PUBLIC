package barberia;

/**
* Clase utilitaria con metodos estaticos para operaciones generales del negocio.
*/

public class CalculadoraBarberia {
    public static int totalCitasProcesadas = 0;
    public static final double IVA = 0.19;

    private CalculadoraBarberia() {
        // Constructor privado para evitar instanciacion
    }

    public static double aplicarIva(double subtotal) {
        return subtotal * (1 + IVA);
    }

    public static String formatearMoneda(double monto) {
        return String.format("$%,.2f COP", monto);
    }

    public static void registrarCitaExitosa() {
        totalCitasProcesadas++;
    }
}