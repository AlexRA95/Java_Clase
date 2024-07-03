import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Minero extends Comerciante implements Serializable {
    private HashMap<Mineral,Integer> minerales;

    public Minero(int id, String nombre) {
        super(id, nombre);
        this.minerales = new HashMap<>();
        addIngredientes();
    }

    private void addIngredientes(){
        try(Connection con = DriverManager.getConnection(URL,USER,PASS)){
            Random ran =new Random();
            System.out.println("Conexion establecida");
            String query="SELECT * from Ingrediente WHERE tipo=\"Mineral\" Order by RAND() LIMIT 5";
            Statement stmt= con.createStatement();
            ResultSet resultado=stmt.executeQuery(query);

            while (resultado.next()){
                int cantidad=ran.nextInt(5,11);
                minerales.put(new Mineral(resultado.getInt(1),resultado.getString(3),resultado.getString(4),resultado.getDouble(5),resultado.getDouble(9)),cantidad);
            }

        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error en la BBDD");
        }
    }

    @Override
    public String toString() {
        return "Minero{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public void verComercianteIngredientes() {
        super.verComercianteIngredientes();
        System.out.println(getClass().getSimpleName().toUpperCase() + "--> " + nombre + ", INGREDIENTES: ");
        for (Mineral m: minerales.keySet()){
            System.out.println("-------> " + m.getNombre().toUpperCase()+ ", Precio: " + m.getPrecio() + ", Nivel de Dureza: " + m.getNivelDeDureza() + ", CANTIDAD: " + minerales.get(m));
        }
    }
}
