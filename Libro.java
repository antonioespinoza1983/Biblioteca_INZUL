package TrabajoFinal;

public class Libro {
    private String titulo;
    private String autor;
    private boolean prestado;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.prestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void prestar() throws LibroNoDisponibleException {
        if (!prestado) {
            prestado = true;
            System.out.println("El libro '" + titulo + "' ha sido prestado.");
        } else {
            throw new LibroNoDisponibleException("El libro '" + titulo + "' ya está prestado.");
        }
    }

    public void devolver() throws PrestamoNoEncontradoException {
        if (prestado) {
            prestado = false;
            System.out.println("El libro '" + titulo + "' ha sido devuelto.");
        } else {
            throw new PrestamoNoEncontradoException("El libro '" + titulo + "' no estaba prestado.");
        }
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Prestado: " + (prestado ? "Sí" : "No");
    }
}
