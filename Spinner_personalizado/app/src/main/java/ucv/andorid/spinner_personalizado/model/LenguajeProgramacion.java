package ucv.andorid.spinner_personalizado.model;

public class LenguajeProgramacion {
    private String nombre_lenguaje;
    private int imagen_lenguaje;

    public LenguajeProgramacion(String nombre_lenguaje, int imagen_lenguaje) {
        this.nombre_lenguaje = nombre_lenguaje;
        this.imagen_lenguaje = imagen_lenguaje;
    }

    public String getNombre_lenguaje() {
        return nombre_lenguaje;
    }

    public void setNombre_lenguaje(String nombre_lenguaje) {
        this.nombre_lenguaje = nombre_lenguaje;
    }

    public int getImagen_lenguaje() {
        return imagen_lenguaje;
    }

    public void setImagen_lenguaje(int imagen_lenguaje) {
        this.imagen_lenguaje = imagen_lenguaje;
    }
}
