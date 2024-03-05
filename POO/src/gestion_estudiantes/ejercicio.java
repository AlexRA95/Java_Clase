package gestion_estudiantes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ejercicio {

    static void menu(){
        System.out.println("------MENÚ------");
        System.out.println("1. Agregar estudiante.");
        System.out.println("2. Agregar nota.");
        System.out.println("3. Mostrar estudiante.");
        System.out.println("4. Eliminar estudiante.");
        System.out.println("5. Listar estudiantes.");
        System.out.println("6. Salir");
        System.out.println("Seleccione una opción...");
    }

    public static void agregarEstudiante(ArrayList<Estudiante> lista, Scanner key){
        key.nextLine();
        System.out.println("Introduce un nombre: ");
        String nombre= key.nextLine();
        System.out.println("Introduce una edad: ");
        int edad= key.nextInt();
        Estudiante aux = new Estudiante(nombre,edad);
        System.out.println("Estudiante añadido...");
        aux.imprimir();
        lista.add(aux);
    }

    public static void agregarNota(ArrayList<Estudiante> lista, Scanner key){
        key.nextLine();
        System.out.println("ID alumno: ");
        int id= key.nextInt();
        boolean existe=false;
        for (Estudiante e: lista
             ) {
            if (e.getIdEstudiante()==id){
                key.nextLine();
                System.out.println("Alumno encontrado.");
                System.out.println("");
                System.out.println("Introduzca la asigantura a la que agregar nota: ");
                String a =key.nextLine();
                System.out.println("Introduce la nota: ");
                Double nota = key.nextDouble();
                e.setNotas(Asignatura.valueOf(a),nota);
                System.out.println(Arrays.toString(e.getNotas()));
                existe=true;

            }
        }
        if (!existe){
            System.out.println("El alumno no existe");
        }

    }

    public static void main(String[] args) {
        ArrayList<Estudiante> lista= new ArrayList<>();
        Scanner key= new Scanner(System.in);
        boolean salir=false;
        Integer opc=0;

        while (!salir){
            menu();
            opc= key.nextInt();
            switch (opc){
                case 1->{
                    agregarEstudiante(lista,key);
                }
                case 2->{
                    agregarNota(lista,key);
                }
                case 3->{}
                case 4->{}
                case 5->{}
                case 6->{
                    System.out.println("Has salido...");
                    salir=true;
                }
                default -> {

                }
            }
        }




    }

}
