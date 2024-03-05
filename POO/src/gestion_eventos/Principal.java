package gestion_eventos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static int menu(Scanner key){
        System.out.println("------OPCIONES------");
        System.out.println(" ");
        System.out.println("1. Agregar un nuevo evento.");
        System.out.println("2. Mostrar todos los eventos.");
        System.out.println("3. Buscar eventos por fecha.");
        System.out.println("4. Eliminar un evento.");
        System.out.println("Introduce tu opción: ");
        return key.nextInt();
    }
    public static void agregarEvento(ArrayList<Evento> lista,Scanner key){
        key.nextLine();
        Boolean aux1=false,aux2=false;
        LocalTime hora = LocalTime.now();
        LocalDate fecha = LocalDate.now();
        System.out.println("Introduce el nombre del evento: ");
        String nombre= key.nextLine();
        while (!aux1){
            System.out.println("Introduce la fecha del evento en formato (AAAA-MM-DD): ");
            try {
                String fechaAux = key.nextLine();
                fecha= LocalDate.parse(fechaAux);
                aux1=true;
            }catch (Exception e){
                System.err.println("ERROR: Formato incorrecto");
            }
        }
        while (!aux2){
            System.out.println("Introduce la hora de inicio del evento en formato (HH:mm):");
            try {
                String horaAux = key.nextLine();
                hora=LocalTime.parse(horaAux);
                aux2=true;
            }catch (Exception e){
                System.err.println("ERROR: Formato invalido");
            }
        }
        System.out.println("Introducir duración del evento en horas: ");
        int duracion= key.nextInt();
        lista.add(new Evento(nombre,fecha,hora, duracion));
    }
    public static void listarEventos(ArrayList<Evento> lista){
        if (lista.isEmpty()){
            System.out.println("No hay eventos actualmente, añada alguno para poder verlos.");
        }else {
            for (Evento e: lista){
                System.out.println(e.toString());
                System.out.println(" ");
            }
        }
    }
    public static void buscarFecha(ArrayList<Evento> lista, Scanner key){
        key.nextLine();
        Boolean salir=false;
        LocalDate fecha= LocalDate.now();
        while (!salir){
            System.out.println("Introduce la fecha por la que buscar eventos en formato (AAAA-MM-DD): ");
            try {
                String fechaAux= key.nextLine();
                fecha=LocalDate.parse(fechaAux);
                salir=true;
            }catch (Exception e){
                System.err.println("ERROR: FORMATO INVALIDO");
            }
            for (Evento e: lista){
                if (e.equals(new Evento(fecha))){
                    System.out.println(e.toString());
                }
            }
        }
    }
    public static void eliminarEvento(ArrayList<Evento> lista, Scanner key){
        key.nextLine();
        System.out.println("Introduce el nombre del evento a borrar: ");
        String nombre= key.nextLine();

    }

    public static void main(String[] args) {
        ArrayList<Evento> listaEventos=new ArrayList<>();
        Scanner key = new Scanner(System.in);
        boolean salir=false;
        while (!salir){
            switch (menu(key)){
                case 1->{
                    agregarEvento(listaEventos,key);
                }
                case 2->{
                    listarEventos(listaEventos);
                }
                case 3->{
                    buscarFecha(listaEventos,key);
                }
                case 4->{
                    System.out.println("SALIENDO DEL PROGRAMA...");
                    salir=true;
                }
                default -> {
                    System.err.println("ERROR: Valor incorrecto.");
                }
            }

        }


    }

}
