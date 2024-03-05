package ArrayListProducto;

import cosasClase.ejExamnes.Comida;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class ejProducto {

    public static void main(String[] args) {
        ArrayList<Producto> lista= new ArrayList<>();
        lista.add(new Producto("Plato",15));
        lista.add(new Producto("Copa",3));
        lista.add(new Producto("Platano",105));
        lista.add(new Producto("Mesa",99));
        lista.add(new Producto("Silla",56));

        Iterator iter = lista.iterator();

        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        System.out.println(" ");

        lista.remove(2);
        lista.remove(1);
        lista.add( 1,new Producto("Casa",852));
        iter = lista.iterator();

        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        lista.clear();
    }

}
