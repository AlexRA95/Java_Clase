import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Mercader extends Comerciante implements Serializable {
    private HashMap<Ingrediente, Integer> ingredientes;

    public Mercader(int id, String nombre) {
        super(id, nombre);
        this.ingredientes = new HashMap<>();
        addIngredientes();
    }

    /*Este metodo accede a la base de datos y le carga 5 ingredientes aleatorios*/
    private void addIngredientes(){
        try(Connection con = DriverManager.getConnection(URL,USER,PASS)){
            Random ran =new Random();
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

    /*Este metodo enseña el comerciate y los ingredientes que tiene*/
    @Override
    public void verComercianteIngredientes() {
        super.verComercianteIngredientes();
        System.out.println(getClass().getSimpleName().toUpperCase() + "--> " + nombre + ", INGREDIENTES: ");
        for (Ingrediente i: ingredientes.keySet()){
            if (i instanceof Mineral){
                System.out.println("-------> " + " Número ingrediente: " + i.getId() + ". " + i.getNombre().toUpperCase()+ ", Precio: " + i.getPrecio() + ", Nivel de Dureza: " + ((Mineral) i).getNivelDeDureza() + ", CANTIDAD: " + ingredientes.get(i));
            } else if (i instanceof Hierba){
                System.out.println("-------> " + " Número ingrediente: " + i.getId() + ". " + i.getNombre().toUpperCase()+ ", Precio: " + i.getPrecio() + ", Efecto Positivo: " + ((Hierba) i).getEfectoPositivo() + ", CANTIDAD: " + ingredientes.get(i));
            } else if (i instanceof Seta) {
                System.out.println("-------> " + " Número ingrediente: " + i.getId() + ". " + i.getNombre().toUpperCase()+ ", Precio: " + i.getPrecio() + ", Efecto Negativo: " + ((Seta) i).getEfectoNegativo() + ", Nivel de Toxicidad: " + ((Seta) i).getNivelToxicidad() + ", CANTIDAD: " + ingredientes.get(i));
            }

        }
    }


    @Override
    public String toString() {
        return id+ ". " + getClass().getSimpleName().toUpperCase() + "--> " + nombre + ".";
    }

    /*Este metodo accede a la base de datos y añade 5 ingredientes más a la lista*/
    @Override
    public void reabastecer() {
        ArrayList<String> save=new ArrayList<>();
        save.add(getClass().getSimpleName().toUpperCase() + ": " + nombre);
        try(Connection con = DriverManager.getConnection(URL,USER,PASS)){
            Random ran =new Random();
            String query="SELECT * from Ingrediente Order by RAND() LIMIT 5";
            Statement stmt= con.createStatement();
            ResultSet resultado=stmt.executeQuery(query);

            while (resultado.next()){
                Integer temp=null;
                Integer antes=null;
                int cantidad=ran.nextInt(5,11);
                if (!ingredientes.isEmpty()){
                    if (ingredientes.containsKey(new Ingrediente(resultado.getInt(1)))){
                        temp= ingredientes.get(new Ingrediente(resultado.getInt(1)));
                        temp+=cantidad;
                        antes= ingredientes.get(new Ingrediente(resultado.getInt(1)));
                    }
                }
                switch (resultado.getString("tipo")){
                    case "HIERBA"->{
                        ingredientes.put(new Hierba(resultado.getInt(1),resultado.getString(3),resultado.getString(4),resultado.getDouble(5),resultado.getString(6)),(temp==null?cantidad:temp));
                    }
                    case "SETA"->{
                        ingredientes.put(new Seta(resultado.getInt(1),resultado.getString(3),resultado.getString(4),resultado.getDouble(5),resultado.getString(7),resultado.getInt(8)),(temp==null?cantidad:temp));
                    }
                    case "MINERAL"->{
                        ingredientes.put(new Mineral(resultado.getInt(1),resultado.getString(3),resultado.getString(4),resultado.getDouble(5),resultado.getDouble(9)),(temp==null?cantidad:temp));
                    }
                }
                save.add("--> " + resultado.getString(3) + ". Cantidad previa: " + (antes==null?"0": antes) + ". Cantidad actual: " + ingredientes.get(new Ingrediente(resultado.getInt(1))));
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
                }else if (!ingredientes.containsKey(new Ingrediente(ingre))){
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
                    else if (ingredientes.get(new Ingrediente(ingre))>=cantidad){
                        for (Ingrediente i: ingredientes.keySet()){
                            if (i.equals(new Ingrediente(ingre))){
                                if (oro<i.getPrecio()*cantidad){
                                    System.out.println("No tienes suficiente oro para comprar eso.");
                                }else {
                                    resultado[0]=ingre;
                                    resultado[1]=cantidad;
                                    resultado[2]=i.getPrecio()*cantidad;
                                    ingredientes.replace(new Ingrediente(ingre),ingredientes.get(new Ingrediente(ingre))-cantidad);
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
