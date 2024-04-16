package Actividades_colecciones_y_mapas.M1;

import java.util.HashMap;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        HashMap<String,String> listadoUsarios=new HashMap<>();

        listadoUsarios.put("admin","1234");
        listadoUsarios.put("Juan","qwerty");

        Scanner key= new Scanner(System.in);

        int cont=0;
        boolean acceso=false;

        do {
            System.out.println("Introduzca un nombre de usuario: ");
            String u=key.nextLine();
            if (listadoUsarios.containsKey(u)){
                System.out.println("Introduzca su contraseña: ");
                String c= key.nextLine();
                if (listadoUsarios.get(u).equals(c)){
                    System.out.println("Ha accedido al area restringida.");
                    acceso=true;
                }else {
                    System.out.println("Contraseña incorrecta.");
                    cont++;
                }
            }else {
                System.out.println("Usuario no existe.");
            }

        }while (cont<3 && !acceso);
        if (!acceso){
            System.out.println("No tiene acceso al area restringida");
        }

    }

}
