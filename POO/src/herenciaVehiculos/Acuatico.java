package herenciaVehiculos;

public class Acuatico extends Vehiculo{

    private final Integer ESLORA;

    public Acuatico(String MATRICULA, String MODELO, Integer ESLORA) {
        super(MATRICULA, MODELO);
        this.ESLORA = ESLORA;
    }

    @Override
    public void imprimir() {
        System.out.println(getClass().getSimpleName() + ": " + getMATRICULA() + ", " + getMODELO() + ", " + ESLORA );
    }
}
