void main(String[] args) {
Persona nuevoCliente = new ClienteFrecuente("Jesus Zabaleta" , "305 2383066");
nuevoCliente.mostrarDetalles();
Persona nuevoCliente2 = new Cliente("Diego hernadez", "319 5792809");
nuevoCliente2.mostrarDetalles();

// 2. Crear un barbero (ajusta el constructor según lo tengas)
    Barbero barbero1 = new Barbero("Carlos Ruiz", "123456", 8, Especializacion.CORTE_CABELLO);

    // 3. Crear un horario
    RangoHorario horario1 = new RangoHorario(
            java.time.LocalDateTime.of(2026, 8, 30, 15, 0),
            java.time.LocalDateTime.of(2026, 8, 30, 15, 30)
    );

    // 4. Crear una cita con un solo servicio
    Citas cita1 = new Citas((Cliente) nuevoCliente, barbero1, TipoServicio.CORTE_CABELLO, horario1);

    System.out.println(cita1.generarRecibo());

    // 5. Probar con cliente frecuente, para ver el descuento aplicado
    RangoHorario horario2 = new RangoHorario(
            java.time.LocalDateTime.of(2026, 8, 30, 16, 0),
            java.time.LocalDateTime.of(2026, 8, 30, 16, 30)
    );
    Citas cita2 = new Citas((Cliente) nuevoCliente2, barbero1, TipoServicio.CORTE_CABELLO, horario2);

    System.out.println(cita2.generarRecibo());

    // 6. Probar que lance la excepcion si no hay servicios
    try {
        Citas citaInvalida = new Citas((Cliente) nuevoCliente, barbero1, (TipoServicio) null, horario1);
    } catch (ServicioInvalidoException e) {
        System.out.println("Error esperado: " + e.getMessage());
    }
}
