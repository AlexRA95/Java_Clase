package ConjuntoNumeros;

import javax.swing.plaf.IconUIResource;
import java.beans.Introspector;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Principal {
    public static void main(String[] args) {
        Set<Integer> numeros=new HashSet<>();
        Set<Integer> numerosTree=new TreeSet<>();
        Set<Integer> numerosLinked=new LinkedHashSet<>();

        numeros.add(1);numerosTree.add(1);numerosLinked.add(1);
        numeros.add(1);numerosTree.add(1);numerosLinked.add(1);
        numeros.add(2);numerosTree.add(2);numerosLinked.add(2);
        numeros.add(11);numerosTree.add(11);numerosLinked.add(11);
        numeros.add(7);numerosTree.add(7);numerosLinked.add(7);
        numeros.add(9);numerosTree.add(9);numerosLinked.add(9);

        System.out.println("HASSET: ");
        for (Integer i: numeros){
            System.out.printf("%d ",i);
        }
        System.out.println();

        System.out.println("TREE: ");
        for (Integer i: numerosTree){
            System.out.printf("%d ",i);
        }
        System.out.println();

        System.out.println("Linked: ");
        for (Integer i: numerosLinked){
            System.out.printf("%d ",i);
        }
        System.out.println();
    }

}
