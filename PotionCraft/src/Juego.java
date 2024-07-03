import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Juego  implements Serializable{
    static Path ruta = Paths.get("Datos/PotionCraft.bin");
    private Partida partida;

    /* El constructor comprueba si existe el archivo binario de la partida.
    * Si existe se cargan los datos del binario, si no existe se crea el binario, se crea el objeto partida y se guarda en el binario creado. */
    public Juego() {
        try{
            if (Files.notExists(ruta)){
                Files.createFile(ruta);
                this.partida =new Partida();
                guardar();
            }else{
                cargar();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /* Este método guarda el objeto partida en el binario */
    public void guardar(){
        try {
            OutputStream flujoSalida = Files.newOutputStream(ruta);
            ObjectOutputStream flujoSalidaObjetos=new ObjectOutputStream(flujoSalida);
            flujoSalidaObjetos.writeObject(partida);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /* Este método carga los datos del archivo binario partida */
    public void cargar(){
        try {
            InputStream flujoEntrada=Files.newInputStream(ruta);
            ObjectInputStream flujoEntradaObjetos=new ObjectInputStream(flujoEntrada);
            partida = (Partida) flujoEntradaObjetos.readObject();

        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void ingredientesPociones(){
        for (Pocion p: partida.getPociones().keySet()){
            p.pocIngre();
        }
    }

    public void verComerciantes(){
        partida.verComercianteIngrediente();
    }

    public void reabastecer(){
        partida.reabastecerComerciantes();
    }

    public void estadisticas(){
        partida.mostrarEstadisticas();
    }

    public void comprarIngredientes(){
        partida.comprarIngrediente();
    }

    public void crearPocion(){
        partida.crearPocion();
    }

    public void venderPocion(){
        partida.venderPocion();
    }
}
