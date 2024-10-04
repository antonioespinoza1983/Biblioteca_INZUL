package TrabajoFinal;

import java.time.LocalDate;

public class Prestamo {
    private Libro libro;
    private Cliente cliente;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(Libro libro, Cliente cliente, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.libro = libro;
        this.cliente = cliente;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    // Getters
    public Libro getLibro() {
        return libro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    @Override
    public String toString() {
        return "Libro: " + libro.getTitulo() + ", Cliente: " + cliente.getNombreCompleto() + ", Fecha Préstamo: " + fechaPrestamo + ", Fecha Devolución: " + fechaDevolucion;
    }
}