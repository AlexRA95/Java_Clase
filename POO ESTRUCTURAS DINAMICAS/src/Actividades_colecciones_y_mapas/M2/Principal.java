package Actividades_colecciones_y_mapas.M2;

import java.util.HashMap;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        HashMap<String,String> traducciones =new HashMap<>();
        Scanner key=new Scanner(System.in);

        traducciones.put("hello", "hola");
        traducciones.put("goodbye", "adiós");
        traducciones.put("cat", "gato");
        traducciones.put("dog", "perro");
        traducciones.put("house", "casa");
        traducciones.put("car", "coche");
        traducciones.put("computer", "computadora");
        traducciones.put("book", "libro");
        traducciones.put("tree", "árbol");
        traducciones.put("flower", "flor");
        traducciones.put("friend", "amigo");
        traducciones.put("family", "familia");
        traducciones.put("sun", "sol");
        traducciones.put("moon", "luna");
        traducciones.put("water", "agua");
        traducciones.put("fire", "fuego");
        traducciones.put("sky", "cielo");
        traducciones.put("earth", "tierra");
        traducciones.put("food", "comida");
        traducciones.put("love", "amor");

        System.out.println(traducciones.keySet());
        System.out.println("Introduce una palabra ingles para saber su traducción: ");
        String a= key.nextLine();
        if (traducciones.containsKey(a)){
            System.out.println(traducciones.get(a));
        }else {
            System.out.println("Esa palabra no está en ele diccionario, ¿Quiere introducir su traducción?");
            System.out.println("1. SÍ");
            System.out.println("2. NO");
            System.out.println("Introduce que quiere hacer:");
            int b= key.nextInt();
            if (b==1){
                key.nextLine();
                System.out.println("Introduce la traducción de \'" + a + "\': ");
                String c = key.nextLine();
                traducciones.put(a,c);
                System.out.println("Se ha añadido la palabra " + a + " con traducción -> " + c);

            } else{
                System.out.println("Adios");
            }
        }
    }

}
