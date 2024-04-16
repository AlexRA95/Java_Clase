package Nestle;

public class Agua extends Producto{
    private Mineralizacion mineralizacion;
    private String tipoEnvase;
    private int tamano;

    public Agua(String nombre, double ppu, Mineralizacion mineralizacion, String tipo_envase, int tamano) {
        super(nombre, ppu);
        this.mineralizacion = mineralizacion;
        this.tipoEnvase = tipo_envase;
        this.tamano = tamano;
    }
}
