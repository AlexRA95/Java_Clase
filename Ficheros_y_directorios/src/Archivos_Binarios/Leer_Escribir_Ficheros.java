package Archivos_Binarios;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Leer_Escribir_Ficheros {


    public static void main(String[] args) {
        Path ruta= Paths.get("DataSet/Pasajeros.bin");
        ListaPasajeros pasajeros=new ListaPasajeros();

        Persona j=new Persona("Jose",47,1.74);
        Persona r=new Persona("Rosa",25,1.78);
        Persona a=new Persona("Ana",42,1.65);


        pasajeros.addPersona("Jose",47,1.74);
        pasajeros.addPersona("Rosa",25,1.78);
        pasajeros.addPersona("Ana",42,1.65);

        /*

        try {
            if (Files.notExists(ruta)){
                Files.createFile(ruta);
            }
            OutputStream flujoSalida=Files.newOutputStream(ruta, StandardOpenOption.APPEND);
            ObjectOutputStream flujoSalidaObjetos=new ObjectOutputStream(flujoSalida);
            flujoSalidaObjetos.writeObject(j);
            flujoSalidaObjetos.writeObject(r);
            flujoSalidaObjetos.writeObject(a);
        } catch (IOException e) {
            System.out.println(e);
        }*/

/*

        try{
            InputStream flujoEntrada=Files.newInputStream(ruta);
            ObjectInputStream flujoEntradaObjetos=new ObjectInputStream(flujoEntrada);
            while (true){
                System.out.println(flujoEntradaObjetos.readObject().toString());
            }

        }catch(Exception e){
            System.out.println(e);
        }

*/

        /*        try {
            if (Files.notExists(ruta)){
                Files.createFile(ruta);
            }
            OutputStream flujoSalida=Files.newOutputStream(ruta, StandardOpenOption.APPEND);
            ObjectOutputStream flujoSalidaObjetos=new ObjectOutputStream(flujoSalida);
            flujoSalidaObjetos.writeObject(pasajeros);
        } catch (IOException e) {
            System.out.println(e);
        }
*/


/*

        try {
            InputStream flujoEntrada=Files.newInputStream(ruta);
            ObjectInputStream flujoEntradaObjetos=new ObjectInputStream(flujoEntrada);
            pasajeros = (ListaPasajeros) flujoEntradaObjetos.readObject();
        } catch (Exception e) {
            System.out.println(e);
        }

        pasajeros.imprimirLista();


*/


    }

}
