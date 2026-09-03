import java.sql.SQLOutput;

void main(String[] args) {
Habitacion primeraSuite = new Habitacion("301", "Suite", 300000, 0, 0.20);
Habitacion enOferta = new Habitacion("208", "En Oferta", 100000, 0, 0);
Habitacion segundaSuite = new Habitacion("402", "Suite", 280000, 0, 0.20);
Habitacion segundaEnOferta = new Habitacion("110", "En oferta", 90000, 0, 0);
Habitacion estandar = new Habitacion("105", "Estandar", 150000, 0, 0);

Habitacion [] HabitacionesPrimeraReserva = new Habitacion[5];
HabitacionesPrimeraReserva[0] = primeraSuite;
HabitacionesPrimeraReserva[1] = enOferta;
HabitacionesPrimeraReserva[2] = segundaEnOferta;
HabitacionesPrimeraReserva[3] = segundaSuite;
HabitacionesPrimeraReserva[4] = estandar;

int[] nochesPrimeraReserva = new int[5];
nochesPrimeraReserva[0] = 2;
nochesPrimeraReserva[1] = 4;
nochesPrimeraReserva[2] = 2;
nochesPrimeraReserva[3] = 1;
nochesPrimeraReserva[4] = 3;

Reserva primeraReserva = new Reserva(HabitacionesPrimeraReserva, nochesPrimeraReserva);

Habitacion segundaEstandar = new Habitacion("106", "Estandar", 150000, 0, 0);
try{
    Reserva segundaReserva = new Reserva(segundaEstandar, -2);
} catch (Exception e) {
    System.out.println("Error en la cantidad de noches" + e.getMessage());
} finally{
    System.out.println("Intento de reserva finalizado");
}
try{
    Habitacion nuevaSuite = new Habitacion("987", "Suite", -50000, 0, 20);
    Reserva reservaError = new Reserva(nuevaSuite, 3);
} catch (Exception e) {
    System.out.println("Error en la tarifa base de la habitacion" + e.getMessage());
}finally {
    System.out.println("Su intento de reserva ha finalizado");
}

Habitacion estandar100 = new Habitacion("547", "Estandar", 100000, 0, 0);
Habitacion estandar120 = new Habitacion("548", "Estandar", 120000, 0, 0);
Habitacion suite250 = new Habitacion("100", "Suite", 250000, 0, 20);

Habitacion[] segundaGranReserva = new Habitacion[5];
segundaGranReserva[0] = estandar100;
segundaGranReserva[1] = estandar100;
segundaGranReserva[2] = suite250;
segundaGranReserva[3] = segundaEnOferta;
segundaGranReserva[4] = primeraSuite;
int[] segundaReservaNoche = new int[5];
segundaReservaNoche[0] = 1;
segundaReservaNoche[1] = 1;
segundaReservaNoche[2] = 1;
segundaReservaNoche[3] = 1;
segundaReservaNoche[4] = 1;

Reserva terceraReserva = new Reserva(segundaGranReserva, segundaReservaNoche);
terceraReserva.calcularPrecioTotal();



}


