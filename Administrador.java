package TrabajoFinal;

public class Administrador extends Usuario {

    public Administrador(String nombreCompleto, String documentoIdentidad, String direccion, String numeroContacto, String correoElectronico) {
        super(nombreCompleto, documentoIdentidad, direccion, numeroContacto, correoElectronico);
    }

    @Override
    public String getRol() {
        return "Administrador";
    }

    // Métodos específicos del administrador pueden agregarse aquí
    public void gestionarLibros(SistemaBiblioteca sistema, Libro libro) {
        sistema.agregarLibro(libro);
    }
}
