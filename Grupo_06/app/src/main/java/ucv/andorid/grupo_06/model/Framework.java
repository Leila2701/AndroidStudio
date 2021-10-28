package ucv.andorid.grupo_06.model;

public class Framework {
    private int img;
    private String nombre;
    private int contenido;

    public Framework(int img, String nombre, int contenido) {
        this.img = img;
        this.nombre = nombre;
        this.contenido = contenido;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getContenido() {
        return contenido;
    }

    public void setContenido(int contenido) {
        this.contenido = contenido;
    }
}
