import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Minero extends Comerciante implements Serializable {
    private HashMap<Mineral,Integer> minerales;
    //Esta fecha sirve para comprobar que han pasado 5 minutos desde la utlima vez que se ha intentado comprar ingredientes
    static LocalDateTime fecha=LocalDateTime.MIN;

    public Minero(int id, String nombre) {
        super(id, nombre);
        this.minerales = new HashMap<>();
        addIngredientes();
    }

    /*Este metodo accede a la base de datos y le carga 5 ingredientes aleatorios*/
    private void addIngredientes(){
        try(Connection con = DriverManager.getConnection(URL,USER,PASS)){
            Random ran =new Random();
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
        return id+ ". " + getClass().getSimpleName().toUpperCase() + "--> " + nombre + ".";
    }

    /*Este metodo enseña el comerciate y los ingredientes que tiene*/
    @Override
    public void verComercianteIngredientes() {
        super.verComercianteIngredientes();
        System.out.println(getClass().getSimpleName().toUpperCase() + "--> " + nombre + ", INGREDIENTES: ");
        for (Mineral m: minerales.keySet()){
            System.out.println("-------> " + " Número ingrediente: " + m.getId() + ". " + m.getNombre().toUpperCase()+ ", Precio: " + m.getPrecio() + ", Nivel de Dureza: " + m.getNivelDeDureza() + ", CANTIDAD: " + minerales.get(m));
        }
    }

    /*Este metodo accede a la base de datos y añade 5 ingredientes más a la lista*/
    @Override
    public void reabastecer() {
        ArrayList<String> save=new ArrayList<>();
        save.add(getClass().getSimpleName().toUpperCase() + ": " + nombre);
        try(Connection con = DriverManager.getConnection(URL,USER,PASS)){
            Random ran =new Random();
            String query="SELECT * from Ingrediente WHERE tipo=\"Mineral\" Order by RAND() LIMIT 5";
            Statement stmt= con.createStatement();
            ResultSet resultado=stmt.executeQuery(query);

            while (resultado.next()){
                Integer antes=null;
                Integer temp=null;
                int cantidad=ran.nextInt(5,11);
                if (!minerales.isEmpty()){
                    if (minerales.containsKey(new Mineral(resultado.getInt(1)))){
                        temp=minerales.get(new Mineral(resultado.getInt(1)));
                        temp+=cantidad;
                        antes= minerales.get(new Mineral(resultado.getInt(1)));
                    }
                }
                minerales.put(new Mineral(resultado.getInt(1),resultado.getString(3),resultado.getString(4),resultado.getDouble(5),resultado.getDouble(9)),(temp==null?cantidad:temp));

                save.add("--> " + resultado.getString(3) + ". Cantidad previa: " + (antes==null?"0": antes) + ". Cantidad actual: " + minerales.get(new Mineral(resultado.getInt(1))));
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
    public double[] comprarIngredientes(double oro) {
        //Esta variable nos da la hora actual
        LocalDateTime actual=LocalDateTime.now();
        Scanner key=new Scanner(System.in);
        double [] resultado = new double[3];
        //Comprobamos que han pasado 5 minutos
        if (ChronoUnit.MINUTES.between(fecha,actual)<5){
            System.out.println("Aun no he vuelto de la mina...");
        }else {
            fecha=actual;
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
                    }else if (!minerales.containsKey(new Mineral(ingre))){
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
                        else if (minerales.get(new Mineral(ingre))>=cantidad){
                            for (Mineral m: minerales.keySet()){
                                if (m.equals(new Mineral(ingre))){
                                    if (oro<m.getPrecio()*cantidad){
                                        System.out.println("No tienes suficiente oro para comprar eso.");
                                    }else {
                                        resultado[0]=ingre;
                                        resultado[1]=cantidad;
                                        resultado[2]=m.getPrecio()*cantidad;
                                        minerales.replace(new Mineral(ingre),minerales.get(new Mineral(ingre))-cantidad);
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
        }
        return resultado;
    }
}
