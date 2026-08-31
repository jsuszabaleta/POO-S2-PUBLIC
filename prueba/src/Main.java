import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        // ---------- 1. Array de Personas (polimorfismo + upcasting) ----------
        Persona[] personas = new Persona[3];
        personas[0] = new ClienteFrecuente("Jesus Zabaleta", "305 2383066"); // upcasting
        personas[1] = new Cliente("Diego Hernandez", "319 5792809");         // upcasting
        personas[2] = new Barbero("Carlos Ruiz", "123456", 8, Especializacion.CORTE_CABELLO); // upcasting

        System.out.println("===== LISTADO DE PERSONAS (polimorfismo) =====");
        for (Persona p : personas) {
            p.mostrarDetalles();
        }

        // ---------- 2. instanceof + downcasting ----------
        System.out.println("\n===== SOLO CLIENTES: prueba de descuento =====");
        for (Persona p : personas) {
            if (p instanceof Cliente) {
                Cliente c = (Cliente) p;
                System.out.println(c.getNombre() + " paga por 100.000 -> " + c.calcularTotal(100000));
            }
        }

        // ---------- 3. Comparación correcta de String ----------
        if (personas[0].getNombre().equals(personas[1].getNombre())) {
            System.out.println("Mismo nombre");
        } else {
            System.out.println("\nNombres distintos: " + personas[0].getNombre() + " vs " + personas[1].getNombre());
        }

        Barbero barbero1 = (Barbero) personas[2]; // downcasting explícito

        RangoHorario horario1 = new RangoHorario(
                LocalDateTime.of(2026, 8, 30, 15, 0),
                LocalDateTime.of(2026, 8, 30, 15, 30));
        RangoHorario horario2 = new RangoHorario(
                LocalDateTime.of(2026, 8, 30, 16, 0),
                LocalDateTime.of(2026, 8, 30, 16, 30));
        // ---------- 4. Array de objetos: citas sueltas (fuera de Barberia) ----------
        Citas[] citasSueltas = new Citas[2];
        citasSueltas[0] = new Citas((Cliente) personas[0], barbero1, TipoServicio.CORTE_CABELLO, horario1);
        citasSueltas[1] = new Citas((Cliente) personas[1], barbero1, TipoServicio.AFEITADO, horario2);
        //----4.1. Citas en ArrayList:
        Citas[] citaMultiple = new Citas[1];
        TipoServicio[] serviciosCombo = { TipoServicio.CORTE_CABELLO, TipoServicio.TRATAMIENTO_BARBA };
        citaMultiple[0] = new Citas((Cliente) personas[1], barbero1, serviciosCombo, horario2);
        System.out.println("\n===== RECIBOS (interfaz Facturable) =====");
        for (Citas cita : citasSueltas) {
            Facturable f = cita; // upcasting a la interfaz
            System.out.println(f.generarRecibo());
        }
        System.out.println("\n===== RECIBOS (interfaz Facturable) =====");
        for (Citas cita : citaMultiple) {
            Facturable f = cita; // upcasting a la interfaz
            System.out.println(f.generarRecibo());
        }

        // ---------- 5. Array primitivo ----------
        ((Barbero) personas[2]).registrarGanancia(0, 22750);
        double[] produccion = barbero1.getProduccionSemanal();
        System.out.println("===== PRODUCCION SEMANAL (arreglo primitivo) =====");
        for (int i = 0; i < produccion.length; i++) {
            System.out.println("Dia " + (i+1) + ": $" + produccion[i]);
        }
        ((Barbero) personas[2]).registrarGanancia(0, 35000);
        System.out.println("===== PRODUCCION SEMANAL (arreglo primitivo) =====");
        for (int i = 0; i < produccion.length; i++) {
            System.out.println("Dia " + (i+1) + ": $" + produccion[i]);
        }

        // ---------- 6. Try/catch #1: servicio inválido, con finally ----------
        try {
            new Citas((Cliente) personas[0], barbero1, (TipoServicio) null, horario1);
        } catch (ServicioInvalidoException e) {
            System.out.println("\nError esperado (cita sin servicio): " + e.getMessage());
        } finally {
            System.out.println("Intento de creacion de cita finalizado.\n");
        }

        // ---------- 7. Usando Barberia: agendar citas con validaciones ----------
        Barberia barberia = new Barberia();
        barberia.getBarberos().add(barbero1);

        System.out.println("===== AGENDANDO CITAS EN LA BARBERIA =====");
        try {
            barberia.agendarCita((Cliente) personas[0], barbero1, TipoServicio.CORTE_CABELLO, horario1);
            System.out.println("Cita 1 agendada con exito.");

            // Mismo horario, mismo barbero -> debe chocar
            barberia.agendarCita((Cliente) personas[1], barbero1, TipoServicio.AFEITADO, horario1);
            System.out.println("Cita 2 agendada con exito.");

        } catch (HorarioOcupadoException e) {
            System.out.println("Error de agenda: " + e.getMessage());
        } catch (BarberoNoDisponibleException e) {
            System.out.println("Error de barbero: " + e.getMessage());
        } finally {
            System.out.println("Intento de agendamiento finalizado.\n");
        }

        // ---------- 8. Try/catch #2: buscar una cita que no existe ----------
        try {
            barberia.buscarCitaPorId(999);
        } catch (CitaNoEncontradaException e) {
            System.out.println("Error de busqueda: " + e.getMessage());
        } finally {
            System.out.println("Busqueda de cita finalizada.");
        }

        // ---------- 9. Clase utilitaria: ejemplo de uso en la barbería ----------
        System.out.println("\n===== UTILIDADES DE BARBERÍA =====");
        RangoHorario horarioUtil = UtilidadesBarberia.crearHorario(
                LocalDateTime.of(2026, 8, 31, 10, 0),
                45
        );

        System.out.println("Horario generado: " + UtilidadesBarberia.formatearHorario(horarioUtil));
        System.out.println("Precio formateado: " + UtilidadesBarberia.formatearMoneda(32500.0));

        Citas citaEjemplo = new Citas(
                (Cliente) personas[1],
                barbero1,
                TipoServicio.CORTE_CABELLO,
                horarioUtil
        );

        System.out.println(UtilidadesBarberia.resumenCita(citaEjemplo));
    }
}
