import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Jugador implements Serializable {
    final static Path comerciantesData= Paths.get("Datos/comerciantes.csv");
    final static String URL="jdbc:mysql://127.0.0.1:3306/potioncraft";
    final static String USER="root";
    final static String PASS="123456";
    private int oro;
    private int reputacion;
    private HashMap<Pocion,Integer> pociones;
    private HashMap<Ingrediente,Integer> ingredientes;
    private HashSet<Comerciante> comerciantes;

    public Jugador() {
        this.oro = 1000;
        this.reputacion = 0;
        this.pociones = inicializarPociones();
        pocionesIngredientes();
        this.ingredientes = inicializarIngredientes();
        this.comerciantes=inicializarComerciantes();
    }

    private HashSet<Comerciante> inicializarComerciantes(){
        List<String> lineas = new ArrayList<>();
        try{
            lineas= Files.readAllLines(comerciantesData);
        }catch(Exception e){
            System.out.println(e);
        }
        HashSet<Comerciante> lista=new HashSet<>();

        for (String linea: lineas){
            if (!linea.equals(" ")){
                String[] datos =linea.split(";");
                switch (datos[0]){
                    case "HERBORISTA" ->{
                        lista.add(new Herborista(Integer.parseInt(datos[1]),datos[2]));
                    }
                    case "RECOLECTOR SETAS" ->{
                        lista.add(new Recolector(Integer.parseInt(datos[1]),datos[2]));
                    }
                    case "MERCADER" ->{
                        lista.add(new Mercader(Integer.parseInt(datos[1]),datos[2]));
                    }
                    case "MINERO" ->{
                        lista.add(new Minero(Integer.parseInt(datos[1]),datos[2]));
                    }
                }
            }
        }

        return lista;

    }

    private HashMap<Pocion,Integer> inicializarPociones(){
        HashMap<Pocion,Integer>lista=new HashMap<>();

        try(Connection con = DriverManager.getConnection(URL,USER,PASS)){
            System.out.println("Conexion establecida");
            String query="SELECT * FROM Pocion";
            Statement stmt= con.createStatement();
            ResultSet resultado=stmt.executeQuery(query);

            while (resultado.next()){
                lista.put(new Pocion(resultado.getInt(1),resultado.getString(2)),0);
            }

        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error en la BBDD");
        }

        return lista;

    }

    private HashMap<Ingrediente,Integer> inicializarIngredientes(){
        HashMap<Ingrediente,Integer>lista=new HashMap<>();

        try(Connection con = DriverManager.getConnection(URL,USER,PASS)){
            System.out.println("Conexion establecida");
            String query="SELECT * FROM Ingrediente";
            Statement stmt= con.createStatement();
            ResultSet resultado=stmt.executeQuery(query);

            while (resultado.next()){
                switch (resultado.getString("tipo")){
                    case "HIERBA"->{
                        lista.put(new Hierba(resultado.getInt(1),resultado.getString(3),resultado.getString(4),resultado.getDouble(5),resultado.getString(6)),0);
                    }
                    case "SETA"->{
                        lista.put(new Seta(resultado.getInt(1),resultado.getString(3),resultado.getString(4),resultado.getDouble(5),resultado.getString(7),resultado.getInt(8)),0);
                    }
                    case "MINERAL"->{
                        lista.put(new Mineral(resultado.getInt(1),resultado.getString(3),resultado.getString(4),resultado.getDouble(5),resultado.getDouble(9)),0);
                    }
                }
            }

        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error en la BBDD");
        }

        return lista;

    }

    private void pocionesIngredientes(){
        try(Connection con = DriverManager.getConnection(URL,USER,PASS)){
            System.out.println("Conexion establecida");
            String query="SELECT p.identificador,i.*,ip.unidades FROM Ingredientes_Pociones ip JOIN Ingrediente i ON i.identificador=ip.idIngrediente JOIN Pocion p ON p.identificador=ip.idPocion";
            Statement stmt= con.createStatement();
            ResultSet resultado=stmt.executeQuery(query);

            while (resultado.next()){
                for (Pocion pocion : pociones.keySet()) {
                    if (resultado.getInt(1)==pocion.getId()){
                        switch (resultado.getString("tipo")){
                            case "HIERBA"->{
                                pocion.setIngredientes(new Hierba(resultado.getInt(2),resultado.getString(4),resultado.getString(5),resultado.getDouble(6),resultado.getString(7)),resultado.getInt(11));
                            }
                            case "SETA"->{
                                pocion.setIngredientes(new Seta(resultado.getInt(2),resultado.getString(4),resultado.getString(5),resultado.getDouble(6),resultado.getString(8),resultado.getInt(9)),resultado.getInt(11));
                            }
                            case "MINERAL"->{
                                pocion.setIngredientes(new Mineral(resultado.getInt(2),resultado.getString(4),resultado.getString(5),resultado.getDouble(6),resultado.getDouble(10)),resultado.getInt(11));
                            }
                        }
                    }
                }
            }

        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error en la BBDD");
        }
    }

    public HashMap<Pocion, Integer> getPociones() {
        return pociones;
    }

    public HashMap<Ingrediente, Integer> getIngredientes() {
        return ingredientes;
    }

    public HashSet<Comerciante> getComerciantes() {
        return comerciantes;
    }

    public void verComercianteIngrediente(){
        for (Comerciante c : comerciantes){
            c.verComercianteIngredientes();
            System.out.println();
        }
    }
}
