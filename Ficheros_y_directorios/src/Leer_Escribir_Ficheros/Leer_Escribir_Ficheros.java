package Leer_Escribir_Ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leer_Escribir_Ficheros {


    public static void main(String[] args) {
        Path archivo= Paths.get("DataSet/Personas.csv");
        List<String> lineas= new ArrayList<>();

        try {
            lineas = Files.readAllLines(archivo);
        } catch (IOException e) {}

        LinkedList<Persona> personas= new LinkedList<>();



        for (String linea: lineas){
            if (!linea.equals(" ")){
                String[] datos=linea.split(";");
                Persona p =new Persona(datos[0], Integer.parseInt(datos[1]) , Double.parseDouble(datos[2]));
                personas.add(p);
            }
        }


        Persona j = (new Persona("Juan",30,1.40));
        Persona v = (new Persona("Veronica",33,1.66));

        personas.add(j);
        lineas.add(j.toCSV());
        personas.add(v);
        lineas.add(v.toCSV());
        

        try {
            Files.write(archivo,lineas);
        }catch (IOException e){}


    }

}
