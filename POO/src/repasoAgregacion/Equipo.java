package repasoAgregacion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Equipo {

    private String nombre;

    private List<Jugador> jugadores;
    private Integer puntuacion;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
        this.puntuacion=0;
    }

    public boolean agregarJugador(Jugador j){
        if (jugadores.contains(j)){
            System.out.println("ERROR");
            return false;
        }else {
            jugadores.add(j);
            System.out.println("El jugador se ha agregado");
            return true;
        }
    }

    public boolean eliminarJugador(Jugador j){
        if (jugadores.contains(j)){
            Iterator<Jugador> iter = jugadores.iterator();
            while (iter.hasNext()){
                Jugador aux=iter.next();
                if (aux.equals(j)){
                    iter.remove();
                    return true;
                }
            }
        }else {
            System.out.println("ERROR: El jugador no existe");
        }
        return false;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipo equipo)) return false;
        return Objects.equals(nombre, equipo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void addPuntos(int puntos){
        this.puntuacion+=puntos;
    }


    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void imprimir(){
        System.out.println("EQUIPO--> " + nombre + " PUNTUACIÓN--> " + puntuacion);
    }
}
