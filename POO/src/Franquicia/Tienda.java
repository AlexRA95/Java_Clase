package Franquicia;

import java.util.ArrayList;
import java.util.Iterator;

public class Tienda {

    private int idTienda;
    private static int idCont=0;
    private String ubicacion;
    private ArrayList<Animal> lista;

    public Tienda(int idTienda, String ubicacion) {
        this.idTienda = idTienda;
        this.ubicacion = ubicacion;
        this.lista = new ArrayList<>();
    }

    public void revisar(){
        for (Animal a:lista){
            a.revision();
        }
    }

    public void addAniComp(String nombre, int edad, int peso, boolean gato, String raza, boolean vacunado){
        lista.add(new AniComp(nombre,edad,peso,gato,raza,vacunado));
    }

    public void addPajaro(String nombre, int edad, int peso, String especie, int pesoIdeal){
        lista.add(new Pajaro(nombre,edad,peso,especie,pesoIdeal));
    }

    public void addPez(String nombre, int edad, int peso, String color, int phApro, int phActu){
        lista.add(new Pez(nombre, edad, peso, color, phApro,phActu));
    }

    public void mostrarAnimales(){
        for (Animal a: lista){
            System.out.println(a.toString());
        }
    }

}
