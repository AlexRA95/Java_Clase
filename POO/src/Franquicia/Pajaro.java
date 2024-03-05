package Franquicia;

public class Pajaro extends Animal{
    private String especie;
    private int pesoIdeal;

    public Pajaro(String nombre, int edad, int peso, String especie, int pesoIdeal) {
        super(nombre, edad, peso);
        this.especie = especie;
        this.pesoIdeal = pesoIdeal;
    }

    public String getEspecie() {
        return especie;
    }

    public int getPesoIdeal() {
        return pesoIdeal;
    }

    @Override
    public void revision() {
        if (getPeso()!=pesoIdeal){
            System.out.println("El pajaro " + getNombre() + (getPeso()<pesoIdeal?" está por debajo ":"está por encima ") + "de su peso ideal, se le va a establecer una dieta.");
        }else {
            System.out.println("El pajaro " + getNombre() + " está en su peso ideal.");
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "Especie--> " + getEspecie() + "\n"+
                "Peso ideal--> " + getPesoIdeal();
    }
}
