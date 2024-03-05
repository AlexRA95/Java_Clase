package Vehiculos;

public class Vehiculo{
    private String matricula;
    private int vMax;
    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    public void setvMax(int vMax) {
        this.vMax = vMax;
    }

    @Override
    public String toString() {
        return "\nVEHICULO--> " + getClass().getSimpleName() + "\n" +
                "Matricula--> " + getMatricula() +"\n"+
                "Velocidad máxima--> " + getvMax() + "\n";
    }

    public int getvMax() {
        return vMax;
    }

    public String getMatricula() {
        return matricula;
    }
}
