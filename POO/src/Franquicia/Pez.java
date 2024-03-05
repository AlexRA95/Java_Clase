package Franquicia;

public class Pez extends Animal{
    private String color;
    private int phApro;
    private int phActu;
    public Pez(String nombre, int edad, int peso, String color, int phApro, int phActu) {
        super(nombre, edad, peso);
        this.color = color;
        this.phApro = phApro;
        this.phActu=phActu;
    }

    @Override
    public void revision() {
        if (phActu!=phApro){
            System.out.println("El ph de la pecera actual es de " + phActu + " y el recomendado es " + phApro + ", por lo tanto el pez no está en condiciones optimas. Se va a proceder a cambiar el ph.");
            phActu=phApro;
        }else {
            System.out.println("El pez está en condiciones optima ya que su pecera tiene el ph correcto.");
        }
    }

    public String getColor() {
        return color;
    }

    public int getPhActu() {
        return phActu;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Color--> " + getColor() + "\n" +
                "PH ideal--> " + getPhActu();
    }
}
