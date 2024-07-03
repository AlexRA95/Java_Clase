package Archivos_Binarios;

import java.io.Serializable;

public class Maleta implements Serializable {
    private int tamano;
    private String tag;

    public Maleta(int tamano, String tag) {
        this.tamano = tamano;
        this.tag = tag;
    }
}
