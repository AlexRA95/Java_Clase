package Nestle;

public class Refresco extends Producto{
    private String tipoEnvase;
    private int tamano;
    private int gramosAzucar;
    private boolean energetica;

    public Refresco(String nombre, double ppu, String tipoEnvase, int tamano, int gramosAzucar, boolean energetica) {
        super(nombre, ppu);
        this.tipoEnvase = tipoEnvase;
        this.tamano = tamano;
        this.gramosAzucar = gramosAzucar;
        this.energetica = energetica;
    }
}
