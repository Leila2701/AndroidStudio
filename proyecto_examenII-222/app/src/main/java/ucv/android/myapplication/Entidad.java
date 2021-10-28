package ucv.android.myapplication;

import java.io.Serializable;

public class Entidad implements Serializable {
    private int imgFoto;
    private String titulo;

    public Entidad(int imgFoto, String titulo  ) {
        this.imgFoto = imgFoto;
        this.titulo = titulo;
    }

    public int getImgFoto() {
        return imgFoto;
    }


    public String getTitulo() {
        return titulo;
    }

}
