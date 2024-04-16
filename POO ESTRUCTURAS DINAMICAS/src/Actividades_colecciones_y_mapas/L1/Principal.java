package Actividades_colecciones_y_mapas.L1;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Principal {


    public static void main(String[] args) {

        ColaTareas lista=new ColaTareas();

        lista.listarTareas();

        lista.addTarea(new Tarea("ey",Prio.MEDIA));
        lista.addTarea(new Tarea("ay",Prio.ALTA));
        lista.addTarea(new Tarea("yu",Prio.BAJA));

        //lista.listarTareas();
        lista.cambiarPrio();

        lista.listarTareas();

        lista.hacerTarea();

    }

    }
