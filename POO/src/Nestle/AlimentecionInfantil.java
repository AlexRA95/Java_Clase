package Nestle;

public class AlimentecionInfantil extends Producto{
    private String frutas;
    private TipoAliInfa tipoAliInfa;

    public AlimentecionInfantil(String nombre, double ppu, String frutas, TipoAliInfa tipoAliInfa) {
        super(nombre, ppu);
        this.frutas = frutas;
        this.tipoAliInfa = tipoAliInfa;
    }
}
