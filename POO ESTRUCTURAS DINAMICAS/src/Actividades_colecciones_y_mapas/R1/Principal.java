package Actividades_colecciones_y_mapas.R1;

import java.util.*;

public class Principal {
    public static void main(String[] args) {
        Random ran =new Random();
        ArrayList<Integer> lista=new ArrayList<>();
        Set<Integer> numerosSinRepetir=new HashSet<>();
        Set<Integer> numerosUnicos=new HashSet<>();
        Set<Integer> numerosRepetidos=new HashSet<>();

        for (int i = 0; i <20 ; i++) {
            Integer num= ran.nextInt(0,11);
            lista.add(num);
        }

        for (Integer i : lista){
            if (!numerosSinRepetir.add(i)){
                numerosRepetidos.add(i);
            }else {
                numerosSinRepetir.add(i);
            }
        }
        numerosUnicos.addAll(lista);
        numerosUnicos.removeAll(numerosRepetidos);
        System.out.println("TODOS LOS NUMEROS: ");
        System.out.println(lista.toString());
        System.out.println("TODOS LOS NUMEROS UNA VEZ: ");
        System.out.println(numerosSinRepetir.toString());
        System.out.println("NUMEROS REPETIDOS: ");
        System.out.println(numerosRepetidos.toString());
        System.out.println("NUMERO QUE APARECEN 1 VEZ: ");
        System.out.println(numerosUnicos.toString());

    }
}
