package Crear_Ficheros_Directorios;

import java.io.IOException;
import java.nio.file.*;

public class principal {
    public static void main(String[] args) {
        Path directorio= Paths.get("Dataset");
        Path origen = Paths.get("Dataset/Fichero.txt");
        Path destino = Paths.get("Dataset/Carpeta1/Fichero.txt");

        try {
            DirectoryStream<Path> stream= Files.newDirectoryStream(Paths.get(""));
            for (Path p : stream){
                System.out.println(p);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
