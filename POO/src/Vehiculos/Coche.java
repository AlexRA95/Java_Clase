package Vehiculos;

public class Coche extends Vehiculo{
    private int potencia;
    private int peso;

    public Coche(String matricula, int potencia, int peso) {
        super(matricula);
        this.potencia = potencia;
        this.peso = peso;
        if (potencia<=100){
            setvMax(150);
        } else if (potencia<=180) {
            setvMax(190);
        }else {setvMax(220);}
    }

    @Override
    public String toString() {
        return super.toString() +
                "Potencia--> " + getPotencia() + "\n" +
                "Peso--> " + getPeso();
    }

    public int getPotencia() {
        return potencia;
    }

    public int getPeso() {
        return peso;
    }
}
