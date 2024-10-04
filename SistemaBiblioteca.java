package TrabajoFinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaBiblioteca {
    private List<Usuario> usuarios;
    private List<Libro> libros;
    private List<Prestamo> prestamos;

    public SistemaBiblioteca() {
        usuarios = new ArrayList<>();
        libros = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    // Métodos para gestionar usuarios
    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario registrado: " + usuario.getNombreCompleto() + " - Rol: " + usuario.getRol());
    }

    public Usuario buscarUsuarioPorDocumento(String documento) throws UsuarioNoEncontradoException {
        for (Usuario u : usuarios) {
            if (u.getDocumentoIdentidad().equals(documento)) {
                return u;
            }
        }
        throw new UsuarioNoEncontradoException("Usuario con documento " + documento + " no encontrado.");
    }

    // Métodos para gestionar libros
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado: " + libro);
    }

    public Libro buscarLibroPorTitulo(String titulo) throws LibroNoDisponibleException {
        for (Libro l : libros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                return l;
            }
        }
        throw new LibroNoDisponibleException("Libro con título '" + titulo + "' no encontrado.");
    }

    // Métodos para gestionar préstamos
    public void prestarLibro(String titulo, String documentoUsuario) throws Exception {
        Libro libro = buscarLibroPorTitulo(titulo);
        if (libro.isPrestado()) {
            throw new LibroNoDisponibleException("El libro '" + libro.getTitulo() + "' no está disponible para préstamo.");
        }

        Usuario usuario = buscarUsuarioPorDocumento(documentoUsuario);
        if (!(usuario instanceof Cliente)) {
            throw new Exception("Solo los clientes pueden tomar libros prestados.");
        }

        Cliente cliente = (Cliente) usuario;
        LocalDate fechaPrestamo = LocalDate.now();
        LocalDate fechaDevolucion = fechaPrestamo.plusWeeks(2);

        Prestamo prestamo = new Prestamo(libro, cliente, fechaPrestamo, fechaDevolucion);
        prestamos.add(prestamo);
        libro.prestar();
        cliente.agregarPrestamo(prestamo);

        System.out.println("Préstamo realizado: " + prestamo);
    }

    public void devolverLibro(String titulo, String documentoUsuario) throws Exception {
        Libro libro = buscarLibroPorTitulo(titulo);
        Usuario usuario = buscarUsuarioPorDocumento(documentoUsuario);

        if (!(usuario instanceof Cliente)) {
            throw new Exception("Solo los clientes pueden devolver libros.");
        }

        Cliente cliente = (Cliente) usuario;
        Prestamo prestamoEncontrado = null;

        for (Prestamo p : prestamos) {
            if (p.getLibro().equals(libro) && p.getCliente().equals(cliente)) {
                prestamoEncontrado = p;
                break;
            }
        }

        if (prestamoEncontrado == null) {
            throw new PrestamoNoEncontradoException("No se encontró un préstamo para el libro '" + titulo + "' y usuario " + usuario.getNombreCompleto());
        }

        prestamos.remove(prestamoEncontrado);
        libro.devolver();
        cliente.getPrestamos().remove(prestamoEncontrado);

        System.out.println("Libro devuelto: " + libro.getTitulo() + " por " + cliente.getNombreCompleto());
    }

    // Método para listar todos los libros
    public void listarLibros() {
        System.out.println("Lista de Libros:");
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            for (Libro l : libros) {
                System.out.println(l);
            }
        }
    }

    // Método para listar todos los préstamos
    public void listarPrestamos() {
        System.out.println("Lista de Préstamos:");
        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
        } else {
            for (Prestamo p : prestamos) {
                System.out.println(p);
            }
        }
    }
}
