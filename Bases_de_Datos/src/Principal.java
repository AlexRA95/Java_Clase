import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    final static String URL="jdbc:mysql://127.0.0.1:3306/tienda";
    final static String USER="root";
    final static String PASS="123456";

    public static void main(String[] args) {

        Double precioMin=100.00;
        try(Connection con= DriverManager.getConnection(URL,USER,PASS);) {
            System.out.println("Conexión establecida");
            String query="SELECT * FROM producto WHERE precio > ?";
            PreparedStatement stmt= con.prepareStatement(query);
            stmt.setDouble(1,precioMin);
            ResultSet tabla = stmt.executeQuery();
            ArrayList<Producto> lista=new ArrayList<>();

            while (tabla.next()){
                Producto p =new Producto(tabla.getInt(1),tabla.getString(2),tabla.getDouble(3));
                lista.add(p);
            }

            for (Producto p : lista){
                System.out.println(p.toString());
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Error en la BBDD");
        }





    }
}
