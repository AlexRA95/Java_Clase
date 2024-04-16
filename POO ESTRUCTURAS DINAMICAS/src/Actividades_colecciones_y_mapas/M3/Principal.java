package Actividades_colecciones_y_mapas.M3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        HashMap<String,String> duolingo =new HashMap<>();
        Scanner key=new Scanner(System.in);
        Random ran = new Random();

        duolingo.put("hello", "hola");
        duolingo.put("goodbye", "adiós");
        duolingo.put("cat", "gato");
        duolingo.put("dog", "perro");
        duolingo.put("house", "casa");
        duolingo.put("car", "coche");
        duolingo.put("computer", "computadora");
        duolingo.put("book", "libro");
        duolingo.put("tree", "árbol");
        duolingo.put("flower", "flor");
        duolingo.put("friend", "amigo");
        duolingo.put("family", "familia");
        duolingo.put("sun", "sol");
        duolingo.put("moon", "luna");
        duolingo.put("water", "agua");
        duolingo.put("fire", "fuego");
        duolingo.put("sky", "cielo");
        duolingo.put("earth", "tierra");
        duolingo.put("food", "comida");
        duolingo.put("love", "amor");

        System.out.println(" - - - - - - - - - DUOLINGO - - - - - - - - -");
        ArrayList<String> lista= new ArrayList<>();
        int cont =0;
        lista.addAll(duolingo.keySet());
        for (int i = 0; i <5 ; i++) {
            int a= ran.nextInt(0, lista.size());
            String word=lista.get(a);
            System.out.println("Cual es la traducción de === " + word);
            String b= key.nextLine();
            if (duolingo.get(word).equals(b)){
                System.out.println("Correcto");
                cont++;
            }else{
                System.out.println("Incorrecto");
            }
            lista.remove(a);
            System.out.println();
        }

        System.out.println("Has acertado " + cont + " palabras");


    }
}
