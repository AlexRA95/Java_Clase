package cuenta_corriente;

import java.util.ArrayList;

public class ej_cuenta {

    public static void main(String[] args) {
        ArrayList<Cuenta> lista= new ArrayList<>();
        lista.add(new Cuenta("Pepe"));
        lista.add(new Cuenta("Jose",500));
        
    }

}
