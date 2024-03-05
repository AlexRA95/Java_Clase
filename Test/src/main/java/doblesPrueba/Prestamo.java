package doblesPrueba;

public class Prestamo {

    private Persona p;

//    public Prestamo(Persona p) {
//        this.p = p;
//    }

    public Persona getP() {
        return p;
    }

    public boolean esPersonaValida(Persona p) {
        if (p.esMayor18()) {
            return true;
        } else {
            // no se puede hacer préstamos a menores de edad
            return false;
        } // if
    }

}
