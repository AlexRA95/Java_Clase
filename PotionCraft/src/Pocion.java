import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

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

    /*Constructor con solo ID para ver si 2 pociones son iguales*/
    public Pocion(int id) {
        this.id = id;
    }

    /*Metodo para añadir ingrdientes a las pociones*/
    public void setIngredientes(Ingrediente i, int cantidad) {
        this.ingredientes.put(i,cantidad);
    }

    public int getId() {
        return id;
    }

    /*Sacar por texto la poción y los ingredientes que se necesitan para hacerla*/
    public void pocIngre(){
        System.out.println(nombre.toUpperCase() + ":");
        for (Ingrediente i : ingredientes.keySet()){
            System.out.println("-----> " + i.getClass().getSimpleName().toUpperCase()+ ", " + i.getNombre() + ", Precio: " + i.getPrecio() + ". Cantidad necesaria: " + ingredientes.get(i));
        }
    }

    public HashMap<Ingrediente, Integer> getIngredientes() {
        return ingredientes;
    }

    @Override
    public String toString() {
        return "----> POCIÓN, " + "ID: " + id + ", " + nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pocion pocion)) return false;
        return getId() == pocion.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
