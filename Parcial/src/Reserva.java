import java.util.Arrays;

public class Reserva {
    private int idReserva;
    private static int contadorId = 1;
    private Habitacion[] habitaciones;
    private int[] noches;

    public Reserva(Habitacion habitacion, int noches){
        if(habitacion == null) {
            throw new IllegalArgumentException("Debe ingresar al menos una habitacion a registrar");
        }
        if(noches <= 0){
            throw new IllegalArgumentException("Debe durar al menos una noche para que la reserva sea valida");
        }
        int[] arregloNoches = new int[1];
        Habitacion [] arregloHabitacion = new Habitacion[1];
        arregloHabitacion[0] = habitacion;
        this.idReserva = contadorId;
        this.habitaciones = arregloHabitacion;
        this.noches = arregloNoches;
        contadorId++;
    }
    public Reserva(Habitacion[] habitaciones, int[] noches){
        if(habitaciones == null || habitaciones.length == 0 || habitaciones.length > 5){
            throw new IllegalArgumentException("Debe ingresar al menos una habitacion a registrar/No puede registrar " +
                    "mas de 5 habitaciones");
        }
        if(noches.length != habitaciones.length){
            throw new IllegalArgumentException("Debe haber la misma cantidad de noches que de habitaciones");
        }
        for(int noche : noches){
            if(noche <= 0){
                throw new IllegalArgumentException("Debe durar al menos una noche");
            }
        }
        this.idReserva = contadorId;
        validarDuplicado(habitaciones);
        this.habitaciones = habitaciones;
        contadorId++;
    }
    public double calcularPrecioTotal(){
        double total = 0;
        int contador = 0;
        for (Habitacion habitacion : habitaciones ){
            total =+ habitacion.calcularPrecio()*noches[contador];
            contador++;
        }
        return total;
    }
    public void validarDuplicado(Habitacion[] h){
        for(int i = 0 ; i < habitaciones.length-1 ; i++){
            Habitacion validarHabitacion = habitaciones[i];
            if(!validarHabitacion.equals(habitaciones[i+1])){
                throw new IllegalArgumentException("Usted esta tratando de reservar la misma habitacion dos veces");
            }
        }
    }

    @Override
    public String toString() {
        return "Usted esta a punto de finalizar su reserva, por favor verifique: {" +
                "El id de su reserva es: " + idReserva +
                ", Las habitaciones que usted va a reservar son: " + Arrays.toString(habitaciones) +
                '}';
    }
}
