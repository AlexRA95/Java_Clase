import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Recolector extends Comerciante implements Serializable {
    private HashMap<Seta,Integer>setas;

    public Recolector(int id, String nombre) {
        super(id, nombre);
        this.setas = new HashMap<>();
        addIngredientes();
    }

    /*Este metodo accede a la base de datos y le carga 5 ingredientes aleatorios*/
    private void addIngredientes(){
        try(Connection con = DriverManager.getConnection(URL,USER,PASS)){
            Random ran =new Random();
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
        return id+ ". " + getClass().getSimpleName().toUpperCase() + "--> " + nombre + ".";
    }

    /*Este metodo enseña el comerciate y los ingredientes que tiene*/
    @Override
    public void verComercianteIngredientes() {
        super.verComercianteIngredientes();
        System.out.println(getClass().getSimpleName().toUpperCase() + "--> " + nombre + ", INGREDIENTES: ");
        for (Seta s: setas.keySet()){
            System.out.println("-------> " + " Número ingrediente: " + s.getId() + ". "  + s.getNombre().toUpperCase()+ ", Precio: " + s.getPrecio() + ", Efecto Negativo: " + s.getEfectoNegativo() + ", Nivel de Toxicidad: " + s.getNivelToxicidad() + ", CANTIDAD: " + setas.get(s));
        }
    }

    /*Este metodo accede a la base de datos y añade 5 ingredientes más a la lista*/
    @Override
    public void reabastecer() {
        ArrayList<String> save=new ArrayList<>();
        save.add(getClass().getSimpleName().toUpperCase() + ": " + nombre);
        try(Connection con = DriverManager.getConnection(URL,USER,PASS)){
            Random ran =new Random();
            String query="SELECT * from Ingrediente WHERE tipo=\"Seta\" Order by RAND() LIMIT 5";
            Statement stmt= con.createStatement();
            ResultSet resultado=stmt.executeQuery(query);

            while (resultado.next()){
                Integer temp=null;
                Integer antes=null;
                int cantidad=ran.nextInt(5,11);
                if (!setas.isEmpty()){
                    if (setas.containsKey(new Seta(resultado.getInt(1)))){
                        temp=setas.get(new Seta(resultado.getInt(1)));
                        temp+=cantidad;
                        antes= setas.get(new Seta(resultado.getInt(1)));
                    }
                }
                setas.put(new Seta(resultado.getInt(1),resultado.getString(3),resultado.getString(4),resultado.getDouble(5),resultado.getString(7),resultado.getInt(8)),(temp==null?cantidad:temp));

                save.add("--> " + resultado.getString(3) + ". Cantidad previa: " + (antes==null?"0": antes) + ". Cantidad actual: " + setas.get(new Seta(resultado.getInt(1))));
            }

        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error en la BBDD");
        }
        try {
            save.add("");
            Files.write(log,save, StandardOpenOption.APPEND);
        }catch (IOException e){
            System.out.println(e);
        }
    }

    /*Este metodo hace que el usuario pueda comprar ingredientes del comerciante*/
    @Override
    public double[] comprarIngredientes(double oro) {
        Scanner key=new Scanner(System.in);
        double [] resultado = new double[3];
        int ingre=0;
        int cantidad=0;
        boolean salir=false;
        while (!salir){
            try{
                verComercianteIngredientes();
                System.out.println("Introduce -1 para no comprar nada.");
                System.out.println(" ");
                System.out.println("¿Qué quieres comprar?:");
                ingre= key.nextInt();
                if (ingre==-1){
                    salir=true;
                }else if (!setas.containsKey(new Seta(ingre))){
                    System.out.println("Ese ingrediente no está disponible.");
                }
                else {
                    key.nextLine();
                    System.out.println();
                    System.out.println("Introduce la cantidad de ese ingrediente que quiere comprar: ");
                    cantidad= key.nextInt();
                        if (cantidad<=0){
                            System.out.println("No puedes comprar menos de 1 ingrediente.");
                        }
                        else if (setas.get(new Seta(ingre))>=cantidad){
                            for (Seta s: setas.keySet()){
                                if (s.equals(new Seta(ingre))){
                                    if (oro<s.getPrecio()*cantidad){
                                        System.out.println("No tienes suficiente oro para comprar eso.");
                                    }else {
                                        resultado[0]=ingre;
                                        resultado[1]=cantidad;
                                        resultado[2]=s.getPrecio()*cantidad;
                                        setas.replace(new Seta(ingre),setas.get(new Seta(ingre))-cantidad);
                                        salir=true;
                                    }
                                }
                            }
                        }else {
                            System.out.println("No se pueden comprar más ingredientes de los disponibles.");
                        }
                }

            }catch(InputMismatchException e){
                System.out.println("Dato introducido por teclado invalido");
            } finally {
                key.nextLine();
            }
        }
        return resultado;
    }
}
