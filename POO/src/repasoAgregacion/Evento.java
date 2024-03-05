package repasoAgregacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Evento {

    private final String  NOMBRE;
    private LocalDate fecha;
    private Equipo[] podio;

    public Evento(String nombre, LocalDate fecha) {
        this.NOMBRE = nombre;
        this.fecha = fecha;
        this.podio = new Equipo[3];
    }

    public boolean setPodio(Equipo primero, Equipo segundo, Equipo tercero) {

        if (primero.equals(segundo) || primero.equals(tercero) || segundo.equals(tercero)){
            System.out.println("ERROR");
            return false;
        }else {
            podio[0]=primero;
            podio[1]=segundo;
            podio[2]=tercero;
            podio[0].addPuntos(5);
            podio[1].addPuntos(3);
            podio[2].addPuntos(1);
            return true;
        }
    }
    public LocalDate getFecha() {
        return fecha;
    }


    public void imprimir() {
        DateTimeFormatter formatofecha=DateTimeFormatter.ofPattern("dd MMMM yyyy");
        System.out.println("Evento --> " +
                "Nombre: '" + NOMBRE + '\'' +
                ", fecha: " + fecha.format(formatofecha));
        if (podio[0]==null){
            System.out.println();
        }else {
            System.out.print(" " + "1# " + podio[0].getNombre() + " " + "2# " + podio[1].getNombre() + " 3# " + podio[2].getNombre());
        }


    }
    public Equipo[] getPodio() {
        return podio;
    }

}
