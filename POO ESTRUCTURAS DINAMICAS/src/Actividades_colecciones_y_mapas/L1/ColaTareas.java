package Actividades_colecciones_y_mapas.L1;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ColaTareas {
    LinkedList<Tarea> tareas;
    Scanner key;
    Comparator orden;

    public ColaTareas() {
        this.tareas =new LinkedList<>();
        key=new Scanner(System.in);
        orden=Comparator.comparing(Tarea::getPrio).thenComparing(Tarea::getAlta);
    }

    public void addTarea(Tarea a){
        tareas.add(a);
        tareas.sort(orden);

    }

    public void listarTareas(){
        if (tareas.isEmpty()){
            System.out.println("No hay tareas ahora mismo.");
        }else {
            for (Tarea t : tareas){
                System.out.println(t.toString());
            }
        }
    }

    public void cambiarPrio(){
        listarTareas();
        if (!tareas.isEmpty()){
            System.out.println("Introduce la tarea por su ID: ");
            String id= key.nextLine();
                for (Tarea t: tareas){
                    if (t.getId().equals(id)){
                        System.out.println("La prioridad actual es " + t.getPrio());
                        System.out.println("1. ALTA");
                        System.out.println("2. MEDIA");
                        System.out.println("3. BAJA");
                        System.out.println("Seleccione una nueva prioridad (ALTA por defecto): ");
                        int prio= key.nextInt();
                        switch (prio){
                            case 2-> t.setPrio(Prio.MEDIA);
                            case 3-> t.setPrio(Prio.BAJA);
                            default -> t.setPrio(Prio.ALTA);
                        }
                        System.out.println(t.toString());
                        tareas.sort(orden);
                    }
                }
        }
    }

    public void hacerTarea(){
        System.out.println(tareas.getFirst());
        System.out.println("Se ha realizado esta tarea!!");
        tareas.removeFirst();

    }
}
