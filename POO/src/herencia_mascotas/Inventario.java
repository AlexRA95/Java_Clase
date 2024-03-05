package herencia_mascotas;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventario {

    private ArrayList<Mascotas> lista;

    public Inventario() {
        this.lista = new ArrayList<>();
    }

    public void  anadir(Mascotas a){
        this.lista.add(a);
    }

    public void listaSimple(){
        if (lista.isEmpty()){
            System.out.println("La lista está vacia.");
        }else{for (Mascotas m: lista){
            System.out.println(m.getClass().getSimpleName() + "(" + m.getNombre() + ")");
        }}

    }

    public void listaCompleta(){
        if (lista.isEmpty()){
            System.out.println("La lista está vacia.");
        }else{
            for (Mascotas m: lista){
                System.out.println(m.toString());
            }
        }
    }

    public void listaTipo(String tipo){
        if (lista.isEmpty()){
            System.out.println("La lista está vacia.");
        }else{
            for (Mascotas m: lista){
                String clase= m.getClass().getSimpleName();
                if (tipo.equalsIgnoreCase(clase)){
                    System.out.println(m.toString());
                }
            }
        }
    }

    public void borrar(String tipo, String nombre){
        if (lista.isEmpty()){
            System.out.println("La lista está vacia.");
        }else{
            Iterator<Mascotas> iterator= lista.iterator();
            while (iterator.hasNext()){
                Mascotas m=iterator.next();
                String clase= m.getClass().getSimpleName();
                if (tipo.equalsIgnoreCase(clase)){
                    if (m.getNombre().equalsIgnoreCase(nombre)){
                        iterator.remove();
                    }
                }
            }
        }

    }

    public void vaciar(){
        Iterator<Mascotas> iterator=lista.iterator();
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }
        System.out.println("Lista vaciada.");
    }
}
