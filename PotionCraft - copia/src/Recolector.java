import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Random;

public class Recolector extends Comerciante implements Serializable {
    private HashMap<Seta,Integer>setas;

    public Recolector(int id, String nombre) {
        super(id, nombre);
        this.setas = new HashMap<>();
        addIngredientes();
    }

    private void addIngredientes(){
        try(Connection con = DriverManager.getConnection(URL,USER,PASS)){
            Random ran =new Random();
            System.out.println("Conexion establecida");
            String query="SELECT * from Ingrediente WHERE tipo=\"Seta\" Order by RAND() LIMIT 5";
            Statement stmt= con.createStatement();
            ResultSet resultado=stmt.executeQuery(query);

            while (resultado.next()){
                int cantidad=ran.nextInt(5,11);
                setas.put(new Seta(resultado.getInt(1),resultado.getString(3),resultado.getString(4),resultado.getDouble(5),resultado.getString(7),resultado.getInt(8)),cantidad);
            }

        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error en la BBDD");
        }
    }

    @Override
    public String toString() {
        return "Recolector{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public void verComercianteIngredientes() {
        super.verComercianteIngredientes();
        System.out.println(getClass().getSimpleName().toUpperCase() + "--> " + nombre + ", INGREDIENTES: ");
        for (Seta s: setas.keySet()){
            System.out.println("-------> " + s.getNombre().toUpperCase()+ ", Precio: " + s.getPrecio() + ", Efecto Negativo: " + s.getEfectoNegativo() + ", Nivel de Toxicidad: " + s.getNivelToxicidad() + ", CANTIDAD: " + setas.get(s));
        }
    }
}
