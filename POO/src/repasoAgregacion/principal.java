package repasoAgregacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class principal {

    public static void main(String[] args) {
        Campeonato c=new Campeonato("Copa pistón");
        c.addEventos(new Evento("Nacional1",LocalDate.parse("2023-09-12")));
        c.addEventos(new Evento("Nacional2",LocalDate.parse("2022-04-12")));
        c.addEventos(new Evento("Nacional3",LocalDate.parse("2024-01-12")));
        c.addEventos(new Evento("Nacional4",LocalDate.parse("2014-11-01")));

        c.listarEventos();
        c.addEquipos(new Equipo("Los ceros"));
        c.getEquipos().get(0).agregarJugador(new Jugador("Paco1"));
        c.getEquipos().get(0).agregarJugador(new Jugador("Paco2"));
        c.getEquipos().get(0).agregarJugador(new Jugador("Paco3"));
        c.addEquipos(new Equipo("Los unos"));
        c.getEquipos().get(1).agregarJugador(new Jugador("Pepe1"));
        c.getEquipos().get(1).agregarJugador(new Jugador("Pepe2"));
        c.getEquipos().get(1).agregarJugador(new Jugador("Pepe3"));
        c.addEquipos(new Equipo("Las dos"));
        c.getEquipos().get(2).agregarJugador(new Jugador("Paca1"));
        c.getEquipos().get(2).agregarJugador(new Jugador("Paca2"));
        c.getEquipos().get(2).agregarJugador(new Jugador("Paca3"));
        c.addEquipos(new Equipo("Las tres"));
        c.getEquipos().get(3).agregarJugador(new Jugador("Paca1"));
        c.getEquipos().get(3).agregarJugador(new Jugador("Paca2"));
        c.getEquipos().get(3).agregarJugador(new Jugador("Paca3"));
        c.addEquipos(new Equipo("Las cuatro"));
        c.getEquipos().get(4).agregarJugador(new Jugador("Paca1"));
        c.getEquipos().get(4).agregarJugador(new Jugador("Paca2"));
        c.getEquipos().get(4).agregarJugador(new Jugador("Paca3"));
        c.addEquipos(new Equipo("Las cinco"));
        c.getEquipos().get(5).agregarJugador(new Jugador("Paca1"));
        c.getEquipos().get(5).agregarJugador(new Jugador("Paca2"));
        c.getEquipos().get(5).agregarJugador(new Jugador("Paca3"));
        c.addEquipos(new Equipo("Las seis"));
        c.getEquipos().get(6).agregarJugador(new Jugador("Paca1"));
        c.getEquipos().get(6).agregarJugador(new Jugador("Paca2"));
        c.getEquipos().get(6).agregarJugador(new Jugador("Paca3"));
        c.addEquipos(new Equipo("Las siete"));
        c.getEquipos().get(7).agregarJugador(new Jugador("Paca1"));
        c.getEquipos().get(7).agregarJugador(new Jugador("Paca2"));
        c.getEquipos().get(7).agregarJugador(new Jugador("Paca3"));
        c.addEquipos(new Equipo("Las ocho"));
        c.getEquipos().get(8).agregarJugador(new Jugador("Paca1"));
        c.getEquipos().get(8).agregarJugador(new Jugador("Paca2"));
        c.getEquipos().get(8).agregarJugador(new Jugador("Paca3"));




        c.getEventos().get(0).setPodio(c.getEquipos().get(2),c.getEquipos().get(0),c.getEquipos().get(1));
        c.getEventos().get(1).setPodio(c.getEquipos().get(0),c.getEquipos().get(3),c.getEquipos().get(4));
        c.getEventos().get(2).setPodio(c.getEquipos().get(0),c.getEquipos().get(2),c.getEquipos().get(6));
        c.getEventos().get(3).setPodio(c.getEquipos().get(7),c.getEquipos().get(0),c.getEquipos().get(8));

        c.mostrarJugadores();

        c.mostrarClasificacion();


    }

}
