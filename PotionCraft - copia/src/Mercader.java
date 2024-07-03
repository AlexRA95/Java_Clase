import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Mercader extends Comerciante implements Serializable {
    private HashMap<Ingrediente, Integer> ingredientes;

    public Mercader(int id, String nombre) {
        super(id, nombre);
        this.ingredientes = new HashMap<>();
        addIngredientes();
    }

    private void addIngredientes(){
        try(Connection con = DriverManager.getConnection(URL,USER,PASS)){
            Random ran =new Random();
            System.out.println("Conexion establecida");
            String query="SELECT * from Ingrediente Order by RAND() LIMIT 5";
            Statement stmt= con.createStatement();
            ResultSet resultado=stmt.executeQuery(query);

            while (resultado.next()){
                int cantidad=ran.nextInt(5,11);
                switch (resultado.getString("tipo")){
                    case "HIERBA"->{
                        ingredientes.put(new Hierba(resultado.getInt(1),resultado.getString(3),resultado.getString(4),resultado.getDouble(5),resultado.getString(6)),cantidad);
                    }
                    case "SETA"->{
                        ingredientes.put(new Seta(resultado.getInt(1),resultado.getString(3),resultado.getString(4),resultado.getDouble(5),resultado.getString(7),resultado.getInt(8)),cantidad);
                    }
                    case "MINERAL"->{
                        ingredientes.put(new Mineral(resultado.getInt(1),resultado.getString(3),resultado.getString(4),resultado.getDouble(5),resultado.getDouble(9)),cantidad);
                    }
                }
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
        for (Ingrediente i: ingredientes.keySet()){
            if (i instanceof Mineral){
                System.out.println("-------> " + i.getNombre().toUpperCase()+ ", Precio: " + i.getPrecio() + ", Nivel de Dureza: " + ((Mineral) i).getNivelDeDureza() + ", CANTIDAD: " + ingredientes.get(i));
            } else if (i instanceof Hierba){
                System.out.println("-------> " + i.getNombre().toUpperCase()+ ", Precio: " + i.getPrecio() + ", Efecto Positivo: " + ((Hierba) i).getEfectoPositivo() + ", CANTIDAD: " + ingredientes.get(i));
            } else if (i instanceof Seta) {
                System.out.println("-------> " + i.getNombre().toUpperCase()+ ", Precio: " + i.getPrecio() + ", Efecto Negativo: " + ((Seta) i).getEfectoNegativo() + ", Nivel de Toxicidad: " + ((Seta) i).getNivelToxicidad() + ", CANTIDAD: " + ingredientes.get(i));
            }

        }
    }


    @Override
    public String toString() {
        return "Mercader{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
