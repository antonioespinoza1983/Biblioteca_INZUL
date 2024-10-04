package TrabajoFinal;

public class Cliente extends Usuario {

    public Cliente(String nombreCompleto, String documentoIdentidad, String direccion, String numeroContacto, String correoElectronico) {
        super(nombreCompleto, documentoIdentidad, direccion, numeroContacto, correoElectronico);
    }

    @Override
    public String getRol() {
        return "Cliente";
    }

    // Métodos específicos del cliente pueden agregarse aquí
}