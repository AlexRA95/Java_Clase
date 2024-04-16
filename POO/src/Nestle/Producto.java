package Nestle;

public class Producto {
    private int id;
    private String nombre;
    private double ppu;
    static int idCont=0;

    public Producto(String nombre, double ppu) {
        this.nombre = nombre;
        this.ppu = ppu;
        this.id=++idCont;
    }
}
