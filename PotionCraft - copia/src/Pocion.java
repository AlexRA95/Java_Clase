import java.io.Serializable;
import java.util.HashMap;

public class Pocion  implements Serializable {

    /* Identificador de la poción */
    private int id;
    /*Nombre de la poción*/
    private String nombre;
    /*HashMap donde se almacenan los ingredientes que necesita cada poción para ser creado, que será la key y la cantidad de ese ingrediente que se necesita para poder hacer la poción, que será el valor*/
    private HashMap<Ingrediente,Integer> ingredientes;

    public Pocion(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.ingredientes=new HashMap<>();
    }

    public void setIngredientes(Ingrediente i, int cantidad) {
        this.ingredientes.put(i,cantidad);
    }

    public int getId() {
        return id;
    }

    public void pocIngre(){
        System.out.println(nombre.toUpperCase() + ":");
        for (Ingrediente i : ingredientes.keySet()){
            System.out.println("-----> " + i.getClass().getSimpleName()+ ", " + i.getNombre().toUpperCase() + ", Precio: " + i.getPrecio() + ". Cantidad necesaria: " + ingredientes.get(i));
        }
    }

    @Override
    public String toString() {
        return "----> POCIÓN, " + nombre;
    }
}
