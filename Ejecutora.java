package TrabajoFinal;

public class Ejecutora {
    public static void main(String[] args) {
        SistemaBiblioteca sistema = new SistemaBiblioteca();

        // Crear usuarios
        Administrador admin = new Administrador("Juan Perez", "12345678", "Av. Siempre Viva 123", "987654321", "juan.perez@inzul.org");
        Cliente cliente1 = new Cliente("Maria Lopez", "87654321", "Calle Falsa 456", "912345678", "maria.lopez@gmail.com");
        Cliente cliente2 = new Cliente("Carlos Ruiz", "11223344", "Avenida Libertad 789", "923456789", "carlos.ruiz@gmail.com");

        // Registrar usuarios
        sistema.registrarUsuario(admin);
        sistema.registrarUsuario(cliente1);
        sistema.registrarUsuario(cliente2);

        // Agregar libros
        Libro libro1 = new Libro("Cien Años de Soledad", "Gabriel García Márquez");
        Libro libro2 = new Libro("El Quijote", "Miguel de Cervantes");
        Libro libro3 = new Libro("La Teoría del Todo", "Stephen Hawking");

        sistema.agregarLibro(libro1);
        sistema.agregarLibro(libro2);
        sistema.agregarLibro(libro3);

        // Listar libros
        sistema.listarLibros();

        // Realizar préstamos
        try {
            sistema.prestarLibro("Cien Años de Soledad", "87654321"); // Maria presta "Cien Años de Soledad"
            sistema.prestarLibro("El Quijote", "11223344"); // Carlos presta "El Quijote"
            sistema.prestarLibro("Cien Años de Soledad", "11223344"); // Intentar prestar "Cien Años de Soledad" nuevamente
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Listar préstamos
        sistema.listarPrestamos();

        // Devolver un libro
        try {
            sistema.devolverLibro("Cien Años de Soledad", "87654321"); // Maria devuelve "Cien Años de Soledad"
            sistema.devolverLibro("ISBN999999", "87654321"); // Intentar devolver un libro inexistente
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Listar libros después de devoluciones
        sistema.listarLibros();

        // Listar préstamos después de devoluciones
        sistema.listarPrestamos();
    }
}
