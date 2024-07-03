import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Comerciante implements Serializable {
    final static String URL="jdbc:mysql://127.0.0.1:3306/potioncraft";
    final static String USER="root";
    final static String PASS="123456";
    final static Path log= Paths.get("Datos/test.log");

    protected int id;
    protected String nombre;

    public Comerciante(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    //2 comerciantes son iguales si tienen el mismo id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comerciante that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "";
    }
    public void verComercianteIngredientes(){
    }

    public void reabastecer(){}

    public double[] comprarIngredientes(double oro){
        return null;
    }

}
