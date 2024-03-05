package Gimnasio;

import java.time.LocalDate;
import java.util.ArrayList;

public class Seccion {

    private String nombre;
    private int id;
    private static int idCont=0;
    private ArrayList<Incidencia> incidencias;

    public Seccion(String nombre) {
        this.nombre = nombre;
        this.id = ++idCont;
        this.incidencias = new ArrayList<>();
    }

    public void addIncidencia(String desc){
        if (incidencias.contains(new Incidencia(desc))){
            System.out.println("Esta incidencia ya existe.");
        }else{incidencias.add(new Incidencia(desc));}
    }

    public void mostrarIncidencias(){
            for (Incidencia i: incidencias){
                int cont=1;
                System.out.println( "INCIDENCIA " + cont++ + "\n" + i.toString());
            }
    }


}
