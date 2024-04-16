package Personas_Orden;

import java.util.Comparator;

public class PorEdad implements Comparator<Persona> {

    @Override
    public int compare(Persona o1, Persona o2) {
        if (o1.getEdad()<o2.getEdad()){
            return 1;
        }else {
            return -1;
        }
    }
}
