package Franquicia;

public class AniComp extends Animal{
    private boolean gato;
    private String raza;
    private boolean vacunado;

    public AniComp(String nombre, int edad, int peso, boolean gato, String raza, boolean vacunado) {
        super(nombre, edad, peso);
        this.gato = gato;
        this.raza = raza;
        this.vacunado = vacunado;
    }

    public boolean isGato() {
        return gato;
    }

    @Override
    public void revision() {
        if (!vacunado){
            vacunado=true;
            System.out.println("El "+(isGato()?"gato ":"perro ") + getNombre() +" ha sido vacunado");
        }else {
            System.out.println("El "+(isGato()?"gato ":"perro ") + getNombre() +" ya ha sido vacunado");
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "Gato/Perro--> " + (isGato()?"Gato ":"Perro ") + "\n" +
                "Raza--> " + getRaza() + "\n" +
                "Vacunado--> " +(isVacunado()?"Sí":"No");
    }

    public String getRaza() {
        return raza;
    }

    public boolean isVacunado() {
        return vacunado;
    }
}
