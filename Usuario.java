package TrabajoFinal;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    protected String nombreCompleto;
    protected String documentoIdentidad;
    protected String direccion;
    protected String numeroContacto;
    protected String correoElectronico;
    protected List<Prestamo> prestamos;

    public Usuario(String nombreCompleto, String documentoIdentidad, String direccion, String numeroContacto, String correoElectronico) {
        this.nombreCompleto = nombreCompleto;
        this.documentoIdentidad = documentoIdentidad;
        this.direccion = direccion;
        this.numeroContacto = numeroContacto;
        this.correoElectronico = correoElectronico;
        this.prestamos = new ArrayList<>();
    }

    // Getters
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    // Método para agregar un préstamo
    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    // Método abstracto para obtener el rol del usuario
    public abstract String getRol();
}
