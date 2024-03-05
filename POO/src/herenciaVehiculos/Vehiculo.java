package herenciaVehiculos;

public abstract class  Vehiculo {

    private final String MATRICULA;
    private final String MODELO;

    public Vehiculo(String MATRICULA, String MODELO) {
        this.MATRICULA = MATRICULA;
        this.MODELO = MODELO;
    }

    public abstract void imprimir();

    public String getMATRICULA() {
        return MATRICULA;
    }

    public String getMODELO() {
        return MODELO;
    }
}
