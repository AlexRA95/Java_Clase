package Actividades_colecciones_y_mapas.R2;

import java.util.*;

public class Principal {
    public static void main(String[] args) {

        Scanner key=new Scanner(System.in);
        System.out.println("Introduce una palabra: ");
        String palabra=key.nextLine();
        ArrayList<String> palabras=new ArrayList<>(List.of(palabra.split("\\s+")));
        Set<String> palabrasUnicas=new LinkedHashSet<>(palabras);

        System.out.println("En la frase hay " + palabrasUnicas.size() + " palabras únicas.");


        for (String s: palabrasUnicas){
            int cont=0;
            for (String p: palabras){
                if (p.equals(s)){
                    cont++;
                }
            }
            System.out.println(s.toUpperCase() + "---> " + cont);
        }


    }
}
