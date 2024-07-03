package Archivos_Binarios;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaPasajeros implements Serializable {
    private ArrayList<Persona> lista;

    public ListaPasajeros() {
        this.lista = new ArrayList<>();
    }

    public void addPersona(String nombre, int edad, double altura){
        lista.add(new Persona(nombre,edad,altura));
    }

    public void imprimirLista(){
        for (Persona persona : lista) {
            System.out.println(persona.toString());
        }
    }
}
