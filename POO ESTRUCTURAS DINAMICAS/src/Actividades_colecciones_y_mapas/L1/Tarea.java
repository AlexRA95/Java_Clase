package Actividades_colecciones_y_mapas.L1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Tarea {
    private static Set<String> codigos_usados=new HashSet<>();
    private String id;
    private String descripcion;
    private Prio prio;
    private LocalDateTime alta;

    public Tarea(String descripcion, Prio prio) {
        this.id = darID();
        this.descripcion = descripcion;
        this.prio = prio;
        this.alta = LocalDateTime.now();
    }

    private static String darID(){
        String palabra="";
        Random ran= new Random();
        while (!codigos_usados.contains(palabra)){
            for (int i = 0; i <3 ; i++) {
                int letra=ran.nextInt('A','Z'+1);
                Character a= (char) letra;
                palabra=palabra.concat(a.toString());
            }
            if (!codigos_usados.contains(palabra)){
                codigos_usados.add(palabra);
            }
        }

        return palabra;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id='" + id + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", prio=" + prio +
                ", alta=" + alta +
                '}';
    }

    public void setPrio(Prio prio) {
        this.prio = prio;
    }

    public String getId() {
        return id;
    }

    public Prio getPrio() {
        return prio;
    }

    public LocalDateTime getAlta() {
        return alta;
    }
}
