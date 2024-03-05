package Vehiculos;

public class Camion extends Vehiculo{
    private int potencia;
    private boolean remolPesado;

    public Camion(String matricula, int potencia, boolean remolPesado) {
        super(matricula);
        this.potencia = potencia;
        this.remolPesado = remolPesado;
        if (remolPesado){
            setvMax(70);
        } else if (potencia<=200) {
            setvMax(80);
        }else {setvMax(90);}
    }

    @Override
    public String toString() {
        return super.toString() +
                "Potencia--> " + getPotencia() + "\n" +
                "Tipo de remolque--> " + (isRemolPesado()?"Pesado":"Ligero");
    }

    public int getPotencia() {
        return potencia;
    }

    public boolean isRemolPesado() {
        return remolPesado;
    }
}
