package repasoAgregacion;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Campeonato {

    public DateTimeFormatter formatofecha=DateTimeFormatter.ofPattern("dd MMMM yyyy");
    private final String NOMBRE;
    private ArrayList<Equipo> equipos;
    private ArrayList<Evento> eventos;

    public Campeonato(String nombre) {
        this.NOMBRE = nombre;
        this.equipos = new ArrayList<>();
        this.eventos = new ArrayList<>();
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void addEventos(Evento e) {
        this.eventos.add(e);
    }
    public void addEquipos(Equipo e){
        this.equipos.add(e);
    }

    //ORDEN DE FECHA
    public void listarEventos(){
        Comparator compa=Comparator.comparing(Evento:: getFecha).reversed();
        Collections.sort(eventos,compa);
        for (Evento e: eventos){
                e.imprimir();
        }
    }

    //ORDEN DE PUNTUCAION (5,3,1)
    public void mostrarClasificacion(){
        ArrayList<Equipo> lista=new ArrayList<>();
        lista.addAll(getEquipos());
        int cont=1;
        Comparator compa=Comparator.comparing(Equipo::getPuntuacion).reversed();
        lista.sort(compa);
        for (Equipo e:lista){
            System.out.print("Equipo " + cont +" ");
            e.imprimir();
            cont++;
        }
    }

    public int vecesWin(Jugador j){
        int win=0;
        for (Evento e: eventos){
            if (e.getPodio()[0]!=null){
                if (e.getPodio()[0].getJugadores().contains(j)){
                    win++;
                }
            }
        }
        return win;
    }

    //ORDEN ALFABÉTICO DE NOMBRE
    public void mostrarJugadores(){
        ArrayList<Jugador> lista=new ArrayList<>();
        for (Equipo e: equipos){
            lista.addAll(e.getJugadores());
        }
        Comparator compa=Comparator.comparing(Jugador::getNombre);
        lista.sort(compa);
        for (Jugador j:lista){
            System.out.println(j.toString() + "  GANDOR/A " + vecesWin(j));
        }
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }
}
