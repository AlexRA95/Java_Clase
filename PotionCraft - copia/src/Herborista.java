import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Random;

public class Herborista extends Comerciante implements Serializable {
    private HashMap<Hierba,Integer> hierbas;

    public Herborista(int id, String nombre) {
        super(id, nombre);
        this.hierbas = new HashMap<>();
        addIngredientes();
    }

    @Override
    public String toString() {
        return "Herborista{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    private void addIngredientes(){
        try(Connection con = DriverManager.getConnection(URL,USER,PASS)){
            Random ran =new Random();
            System.out.println("Conexion establecida");
            String query="SELECT * from Ingrediente WHERE tipo=\"Hierba\" Order by RAND() LIMIT 5";
            Statement stmt= con.createStatement();
            ResultSet resultado=stmt.executeQuery(query);

            while (resultado.next()){
                int cantidad=ran.nextInt(5,11);
                hierbas.put(new Hierba(resultado.getInt(1),resultado.getString(3),resultado.getString(4),resultado.getDouble(5),resultado.getString(6)),cantidad);
            }

        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error en la BBDD");
        }
    }

    @Override
    public void verComercianteIngredientes() {
        super.verComercianteIngredientes();
        System.out.println(getClass().getSimpleName().toUpperCase() + "--> " + nombre + ", INGREDIENTES: ");
        for (Hierba h: hierbas.keySet()){
            System.out.println("-------> " + h.getNombre().toUpperCase()+ ", Precio: " + h.getPrecio() + ", Efecto Positivo: " + h.getEfectoPositivo() + ", CANTIDAD: " + hierbas.get(h));
        }
    }

    @Override
    public void reabastecer() {
        super.reabastecer();
        try(Connection con = DriverManager.getConnection(URL,USER,PASS)){
            Random ran =new Random();
            System.out.println("Conexion establecida");
            String query="SELECT * from Ingrediente WHERE tipo=\"Hierba\" Order by RAND() LIMIT 5";
            Statement stmt= con.createStatement();
            ResultSet resultado=stmt.executeQuery(query);

            while (resultado.next()){
                Integer temp=null;
                int cantidad=ran.nextInt(5,11);
                if (!hierbas.isEmpty()){
                    if (hierbas.containsKey(new Hierba(resultado.getInt(1)))){
                        temp=hierbas.get(new Hierba(resultado.getInt(1)));
                        temp+=cantidad;
                    }
                }
                hierbas.put(new Hierba(resultado.getInt(1),resultado.getString(3),resultado.getString(4),resultado.getDouble(5),resultado.getString(6)),(temp==null?cantidad:temp));
            }

        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error en la BBDD");
        }

    }
}
