package quitar_anadir_buscar_simple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Principal {
    private static void mostrarTrabajadores(ArrayList<Trabajador> lista) {
        for (Trabajador t: lista){
            System.out.printf("\n %-15s %d",t.getNombre(),t.getId());
        }
    }
    private static void anadirTrabajador(Scanner key, ArrayList<Trabajador> lista) {
        mostrarTrabajadores(lista);
        System.out.println("\n Introduce el nombre del trabajador: ");
        String nombre= key.nextLine();
        if (lista.contains(new Trabajador(nombre))){
            System.out.println("Este trabajador ya está  trabajando.");
        }else {
            lista.add(new Trabajador(nombre));
            System.out.printf("\nSe ha añadido el trabajador %s",lista.get(lista.size()-1).getNombre());
            mostrarTrabajadores(lista);
        }
    }
    private static void eliminarTrabajador(ArrayList<Trabajador> lista, Scanner key) {
        System.out.println(" ");
        mostrarTrabajadores(lista);
        System.out.println("\n Introduce un trabajador que quieras quitar: ");
        String nombre= key.nextLine();
        if (lista.contains(new Trabajador(nombre))){
            Iterator<Trabajador> iter= lista.iterator();
            while (iter.hasNext()){
                Trabajador t=iter.next();
                if (t.equals(new Trabajador(nombre))){
                    System.out.printf("\nSe ha eliminado el trabajador %s con ID %d \n",t.getNombre(),t.getId());
                    iter.remove();
                    mostrarTrabajadores(lista);
                }
            }
        }else {
            System.out.println("No existe este trabajador.");
        }
    }
    public static void main(String[] args) {
        ArrayList<Trabajador> lista=new ArrayList<>();
        Scanner key=new Scanner(System.in);
        lista.add(new Trabajador("Pepe"));
        lista.add(new Trabajador("Rosa"));
        lista.add(new Trabajador("Jose"));
        lista.add(new Trabajador("Ara"));
        lista.add(new Trabajador("Jorge"));

        /*LocalDate cumple=LocalDate.of(2024,9,16);
        LocalDate finCurso=LocalDate.parse("2024-09-02");
        LocalDate hoy=LocalDate.now();

        System.out.println("Mi cumpleaños es antes de fin de curso?");
        System.out.println((cumple.isBefore(finCurso))?"Si":"No");

        int dias=(int) ChronoUnit.DAYS.between(hoy,cumple);
        System.out.println("Quedan " + dias + " para mi cumpleaños.");

        System.out.println(cumple);

        DateTimeFormatter formatoFecha=DateTimeFormatter.ofPattern("dd 'de' MMM. 'de' yy");
        System.out.println(cumple.format(formatoFecha));*/
        /*System.out.printf("%-15s %-15s %-15s ","col1","col2","col3");*/
        mostrarTrabajadores(lista);

        anadirTrabajador(key, lista);

        eliminarTrabajador(lista, key);


    }




}
