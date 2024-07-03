import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Juego  implements Serializable{
    static Path ruta = Paths.get("Datos/PotionCraft.bin");
    private Jugador jugador;

    public Juego() {
        try{
            if (Files.notExists(ruta)){
                Files.createFile(ruta);
                this.jugador=new Jugador();
                guardar();
            }else{
                cargar();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }


    public void guardar(){
        try {
            OutputStream flujoSalida = Files.newOutputStream(ruta);
            ObjectOutputStream flujoSalidaObjetos=new ObjectOutputStream(flujoSalida);
            flujoSalidaObjetos.writeObject(jugador);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void cargar(){
        try {
            InputStream flujoEntrada=Files.newInputStream(ruta);
            ObjectInputStream flujoEntradaObjetos=new ObjectInputStream(flujoEntrada);
            jugador= (Jugador) flujoEntradaObjetos.readObject();

        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void mostrarPociones(){
        for (Pocion p: jugador.getPociones().keySet()){
            System.out.println(p.toString());
        }
    }

    public void mostrarIngredientes(){
        for (Ingrediente i: jugador.getIngredientes().keySet()){
            System.out.println(i.toString());
        }
    }
    public void ingredientesPociones(){
        for (Pocion p: jugador.getPociones().keySet()){
            p.pocIngre();
        }
    }

    public void verComerciantes(){
        jugador.verComercianteIngrediente();
    }
}
