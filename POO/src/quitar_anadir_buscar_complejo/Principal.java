package quitar_anadir_buscar_complejo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Principal {
    private static void mostrarTrabajador(ArrayList<Trabajador> lista) {
        for (Trabajador t: lista){
            t.imprimir();
        }
    }
    private static void borrarTrabajador(ArrayList<Trabajador> lista, Scanner key) {
        mostrarTrabajador(lista);
        System.out.println("Introduce un nombre: ");
        String nombre= key.nextLine();
        if (lista.contains(new Minero(nombre))){
            System.out.println("Introduce el trabajo del trabajador: ");
            String trabajo= key.nextLine();
            Iterator<Trabajador> iter= lista.iterator();
            while (iter.hasNext()) {
                Trabajador t= iter.next();
                if (trabajo.equals("Panadero")) {
                    if (t instanceof Panadero){
                        if (t.getNombre().equals(nombre)){
                            iter.remove();
                        }
                    }
                } else if (trabajo.equals("Minero")) {
                    if (t instanceof Minero){
                        if (t.getNombre().equals(nombre)){
                            iter.remove();
                        }
                    }
                } else {
                    System.out.println("Ese trabajo no existe");
                }
            }
        }else {
            System.out.println("Ese trabajador no existe.");
        }
    }
    public static void main(String[] args) {
        ArrayList<Trabajador> lista = new ArrayList<>();
        Scanner key=new Scanner(System.in);

        Minero minero1 = new Minero("Juan", LocalDate.of(1985, 5, 10), TipoMineral.ORO);
        Minero minero2 = new Minero("Maria", LocalDate.of(1990, 8, 15), TipoMineral.PLATA);
        lista.add(minero1);
        lista.add(minero2);

        // Crear algunos objetos Panadero y agregarlos a la lista
        Panadero panadero1 = new Panadero("Carlos", LocalDate.of(1988, 3, 25), "Madrid");
        Panadero panadero2 = new Panadero("Laura", LocalDate.of(1995, 6, 12), "Barcelona");

        lista.add(panadero1);
        lista.add(panadero2);

        borrarTrabajador(lista, key);

    }



}
