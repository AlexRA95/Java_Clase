import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Partida implements Serializable {
    final static Path comerciantesData= Paths.get("Datos/comerciantes.csv");
    final static String URL="jdbc:mysql://127.0.0.1:3306/potioncraft";
    final static String USER="root";
    final static String PASS="123456";
    final static Path log= Paths.get("Datos/test.log");
    private double oro;
    private int reputacion;
    //Se guardan todas las pociones e ingredientes en 2 hashmaps con sus cantidades, si la cantidad es mayor que 0, es que
    //el jugador tiene esa poción o ingrediente
    private HashMap<Pocion,Integer> pociones;
    private HashMap<Ingrediente,Integer> ingredientes;
    //Los comerciantes se guardan en una linkedList para hacer una cola en comprar ingredientes
    private LinkedList<Comerciante> comerciantes;

    /*El constructor inicializa las pociones, los ingredientes y los comerciantes*/
    public Partida() {
        this.oro = 1000.0;
        this.reputacion = 0;
        this.pociones = inicializarPociones();
        pocionesIngredientes();
        this.ingredientes = inicializarIngredientes();
        this.comerciantes=inicializarComerciantes();
    }

    /*Este metodo lee el archivo .csv e inicializa a los ingredientes en el arraylist*/
    private LinkedList<Comerciante> inicializarComerciantes(){
        List<String> lineas = new ArrayList<>();
        try{
            lineas= Files.readAllLines(comerciantesData);
        }catch(Exception e){
            System.out.println(e);
        }
        LinkedList<Comerciante> lista=new LinkedList<>();

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

    /*Este metodo accede a la base de datos e inicializa todas las pociones*/
    private HashMap<Pocion,Integer> inicializarPociones(){
        HashMap<Pocion,Integer>lista=new HashMap<>();

        try(Connection con = DriverManager.getConnection(URL,USER,PASS)){
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

    /*Este metodo accede a la base de datos e inicializa todos los ingredientes*/
    private HashMap<Ingrediente,Integer> inicializarIngredientes(){
        HashMap<Ingrediente,Integer>lista=new HashMap<>();

        try(Connection con = DriverManager.getConnection(URL,USER,PASS)){
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

    /*Este metodo asigna los ingredientes para hacer cada poción a las pociones correspondientes*/
    private void pocionesIngredientes(){
        try(Connection con = DriverManager.getConnection(URL,USER,PASS)){
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

    public void verComercianteIngrediente(){
        for (Comerciante c : comerciantes){
            c.verComercianteIngredientes();
            System.out.println();
        }
    }

    /*Este método llama a los metodos de los comerciantes para reabastecerse, cambia la reputción y empieza a escribir el .log*/
    public void reabastecerComerciantes(){
        reputacion=reputacion-1;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        ArrayList<String> save=new ArrayList<>();
        LocalDateTime dia=LocalDateTime.now();
        try {
            if (Files.notExists(log)){
                Files.createFile(log);
            }
            String fecha=formato.format(dia);
            save.add(fecha + " - INICIO REABASTECIMIENTO DE COMERCIANTES: ");
            Files.write(log,save, StandardOpenOption.APPEND);
            for (Comerciante c : comerciantes){
                //Metodo de los comerciantes que los reabastece
                c.reabastecer();
            }
            ArrayList<String> fin=new ArrayList<>();
            dia=LocalDateTime.now();
            String fechaFin=formato.format(dia);
            fin.add(fechaFin + " - FIN DEL REABASTECIMIENTO DE COMERCIANTES. ");
            Files.write(log,fin, StandardOpenOption.APPEND);
        }catch (IOException e){
            System.out.println(e);
        }
    }

    /*Este método muestra las estadisticas de la partida, junto a las pociones que tiene el usuario y los ingredientes */
    public void mostrarEstadisticas(){
        System.out.println("- - - - - - - E S T A D I S T I C A S - - - - - - - ");
        System.out.println("---> ORO: " + oro);
        System.out.println("---> REPUTACIÓN: " + reputacion);
        System.out.println("POCIONES EN TU POSESIÓN: ");
        for (Pocion p : pociones.keySet()){
            if (pociones.get(p)>0){
                System.out.println(p.toString() + ". CANTIDAD: " + pociones.get(p));
            }
        }
        System.out.println("INGREDIENTES EN TU POSESIÓN: ");
        for (Ingrediente i : ingredientes.keySet()){
            if (ingredientes.get(i)>0){
                System.out.println(i.toString() + " CANTIDAD: " + ingredientes.get(i));
            }
        }
    }

    /*Este metodo llama al primer comerciante de la cola y llama a su metodo comprar, pasandole el oro de la partida
    * Este devuelve un array de 3 posiciones, la 0 es el id del ingrediente, la 1 es la cantidad que se ha comprado
    * la 2 es el oro que cuestan los ingredientes.
    * Si la posición 0 es 0, significa que no se ha comprado nada .
    * Independientemente del resultado, el primero pasa al final de la cola*/
    public void comprarIngrediente(){
        int antes;
        double [] resultado;
        resultado=comerciantes.getFirst().comprarIngredientes(oro);
        if (resultado[1]==0){
            System.out.println("No has comprado nada.");
        }else {
            antes= ingredientes.get(new Ingrediente((int) resultado[0]));
            ingredientes.replace(new Ingrediente((int) resultado[0]), (int) (antes+resultado[1]));
            this.oro-=resultado[2];
        }
        comerciantes.addLast(comerciantes.getFirst());
        comerciantes.removeFirst();

    }

    /*Este metodo comprueba si se puede crear una poción, se le pasa el hashmap con los ingredientes y la cantidad que se necesita de cada
    * ingrediente, devuelve un booleano diciendo si se puede crear */
    private boolean sePuedeCrear(HashMap<Ingrediente,Integer>ingrPocion){
        //El contador es para comprobar que se tienen todos los ingredientes, ya que si el contador es distinto al tamaño del hashmap, significa que no se tienen todos los ingredientes
        int cont=0;
            for (Ingrediente i : ingredientes.keySet()){
                if (ingredientes.get(i)>0){
                    if (ingrPocion.containsKey(i)){
                        if (ingredientes.get(i)>=ingrPocion.get(i)){
                            cont++;
                        }
                    }
                }
            }
        return cont == ingrPocion.size();
    }

    /*Este metodo recibe una poción y quita los ingredientes y la cantidad que se necesita de los ingredientes de la partida*/
    private void quitarIngredientes(Pocion poti){
        //Creamos un hashmap secundario de los ingredientes que se necesitan para crear la poción
        HashMap<Ingrediente,Integer> aQuitar=new HashMap<>();
        for (Pocion p : pociones.keySet()){
            if (p.equals(poti)){
                aQuitar.putAll(p.getIngredientes());
            }
        }
        for (Ingrediente i : aQuitar.keySet()){
            int restar=aQuitar.get(i);
            int antes= ingredientes.get(i);
            ingredientes.replace(i,antes-restar);
        }
    }

    /*Este metodo cambia la reputación dependiendo de la poción que se ha creado*/
    private void cambiarReputacion(Pocion poti){
        int repuCambio=0, posi=0, nega=0;
        HashMap<Ingrediente,Integer> aQuitar=new HashMap<>();
        for (Pocion p : pociones.keySet()){
            if (p.equals(poti)){
                aQuitar.putAll(p.getIngredientes());
            }
        }
        for (Ingrediente i : aQuitar.keySet()){
            if (i instanceof Hierba){
                posi++;
            } else if (i instanceof Seta) {
                repuCambio-=((Seta) i).getNivelToxicidad();
                nega++;
            } else if (i instanceof Mineral) {
                repuCambio+= (int) ((Mineral) i).getNivelDeDureza();
            }
        }
        if (posi>nega)reputacion++;

    }

    /*Este metodo crea las pociones, para ello, primero se guardan un arrayList secundario con las pociones que se pueden crear
    * Tras eso, se enseñan las pociones que se pueden crear y se pide al usuario que eliga la poción que quiere hacer
    * Luego se cambia la cantidad de esa poción en el hashmap y se cambian los ingredientes y la reputación*/
    public void crearPocion(){
        Scanner key=new Scanner(System.in);
        int opc=0;
        boolean salir=false;
        ArrayList<Pocion> disponibles=new ArrayList<>();
        for (Pocion p : pociones.keySet()){
            if (sePuedeCrear(p.getIngredientes())){
                disponibles.add(p);
            }
        }
        while (!salir){
            try{
                System.out.println("POCIONES CREABLES: ");
                for (Pocion p: disponibles){
                    System.out.println(p.toString());
                }
                System.out.println("Pulsa -1 para salir.");
                System.out.println("Elige la poción que quires hacer por su ID: ");
                opc= key.nextInt();
                if (opc==-1){
                    salir=true;
                } else if (!disponibles.contains(new Pocion(opc))) {
                    System.out.println("Numero incorrecto...");
                }else {
                    int antes= pociones.get(new Pocion(opc));
                    pociones.replace(new Pocion(opc),antes+1);
                    quitarIngredientes(new Pocion(opc));
                    cambiarReputacion(new Pocion(opc));
                }
                salir=true;
            }catch(InputMismatchException e){
                System.out.println("Dato introducido por teclado invalido");
            } finally {
                key.nextLine();
            }
        }
    }

    /*Este metodo calcula el precio de una poción que se le pasa por parametros y lo devuelve en un double*/
    private double calcularPrecio(Pocion poti){
        double precio=0;
        HashMap<Ingrediente,Integer> aQuitar=new HashMap<>();
        for (Pocion p : pociones.keySet()){
            if (p.equals(poti)){
                aQuitar.putAll(p.getIngredientes());
            }
        }
        for (Ingrediente i : aQuitar.keySet()){
            precio+=i.getPrecio()*aQuitar.get(i);
        }
        if (reputacion<=-10){
            return precio;
        } else if (reputacion>=10) {
            return precio*1.2;
        }else {
            double test=1.0-(reputacion*0.1);
            return precio*test;
        }
    }

    /*Este metodo vende las pociones, para ello, primero se guardan un arrayList secundario con las pociones que se pueden tienen
     * Tras eso, se enseñan las pociones que se pueden tienen y se pide al usuario que eliga la poción que quiere vender
     * Luego se cambia la cantidad de esa poción en el hashmap y se cambia el oro*/
    public void venderPocion(){
        Scanner key=new Scanner(System.in);
        int opc=0;
        boolean salir=false;
        ArrayList<Pocion> disponibles=new ArrayList<>();
        for (Pocion p : pociones.keySet()){
            if (sePuedeCrear(p.getIngredientes())){
                disponibles.add(p);
            }
        }
        while (!salir){
            try{
                System.out.println("POCIONES VENDIBLES: ");
                for (Pocion p: disponibles){
                    System.out.println(p.toString() + ". PRECIO: " + calcularPrecio(p));
                }
                System.out.println("Pulsa -1 para salir.");
                System.out.println("Elige la poción que quires hacer por su ID: ");
                opc= key.nextInt();
                if (opc==-1){
                    salir=true;
                } else if (!disponibles.contains(new Pocion(opc))) {
                    System.out.println("Numero incorrecto...");
                }else {
                    int antes= pociones.get(new Pocion(opc));
                    pociones.replace(new Pocion(opc),antes-1);
                    oro+=calcularPrecio(new Pocion(opc));
                }
                salir=true;
            }catch(InputMismatchException e){
                System.out.println("Dato introducido por teclado invalido");
            } finally {
                key.nextLine();
            }
        }
    }
}


