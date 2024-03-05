package alquiler_de_juegos;

import java.util.ArrayList;

public class Netflix {

    ArrayList<Persona> personas=new ArrayList<>();
    ArrayList<Pelicula> peliculas=new ArrayList<>();

    public void addPersona(int DNI, String nombre, String email){
        personas.add(new Persona(DNI, nombre, email));
    }
    public void addPeliculas(String titulo, String nombreDirector, Categoria categoria){
        peliculas.add(new Pelicula(titulo,nombreDirector,categoria));
    }


}
