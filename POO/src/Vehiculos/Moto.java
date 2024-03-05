package Vehiculos;

public class Moto extends Vehiculo{
    private int cilindrada;
    private boolean biPlaza;

    public Moto(String matricula, int cilindrada, boolean biPlaza) {
        super(matricula);
        this.cilindrada = cilindrada;
        this.biPlaza = biPlaza;
        if (cilindrada<=125){
            setvMax(100);
        } else if (cilindrada<=250) {
            setvMax(160);
        }else {setvMax(200);}
    }

    @Override
    public String toString() {
        return super.toString() +
                "Cilindrada--> " + getCilindrada() + "\n" +
                "Numero de plazas--> " + (isBiPlaza()?"2":"1");
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public boolean isBiPlaza() {
        return biPlaza;
    }
}
