import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class buscar_cadena {

    static void mostrar (String[] array){

        for (int i = 1; i <= array.length ; i++) {

            if (i%5==0){
                System.out.println(" ");
            } else if (i== array.length) {
                System.out.print(array[i-1]);
            }else {System.out.print(array[i-1] + ", ");}
        }

    }

    static int menu (){
        Scanner key =new Scanner(System.in);
        Integer op ;

        System.out.println("MENÚ");
        System.out.println("[1] Para ver todas las palabras.");
        System.out.println("[2] Para buscar palabras por 1 caracter.");
        System.out.println("[3] Para calcular la longitud media de las palabras del array.");
        System.out.println("[4] Para ver las palabras de una longitud mayor a la pedida.");
        System.out.println("[5] Para elegir una palabra aleatoria y hacer que las posiciones pares sean mayusculas y las impares minusculas.");
        System.out.println("[0] Para salir.");
        System.out.println("Introduce tu opción: ");
        op = key.nextInt();

        return op;

    }

    static void media(String[] array){
        String prueba;
        Integer media=0;
        for (int i = 0; i <array.length ; i++) {
            prueba=array[i];
            media+=prueba.length();
        }
        media=media/array.length;

        System.out.println("La longitud media de las palabras es " + media);
    }

    static void palabraMayor(String[] array){
        Scanner key = new Scanner(System.in);
        System.out.println("Introduce la longitud minima de las palabras que quieres ver: ");
        int aa = key.nextInt();
        for (int i = 0; i <array.length ; i++) {
            String prueba = array[i];
            if (aa <= prueba.length()){
                System.out.println(prueba);
            }
        }
    }

    //seguir
    static void palabraRandom(String[] array){
        Random ran = new Random();
        int random;
        String palabra="";
        random = ran.nextInt(0,array.length-1);

        for (int i = 0; i <array[random].length() ; i++) {
            if ((i%2)==0){
                palabra+=array[random].toLowerCase().charAt(i);
            }else {palabra+=array[random].toUpperCase().charAt(i);}

        }

        System.out.println(palabra);

    }

    static void buscar(String[] array){
        Scanner key =new Scanner(System.in);
        String buscar,prueba;
        System.out.println("Introduce el caracter a buscar:");
        buscar = key.nextLine();

        for (int i = 0; i < array.length ; i++) {
            if (array[i].contains(buscar)){
                System.out.println(array[i]);
            }

        }

    }

    static void palabrasUnicas(String[] array){
        String[] unico;
        unico= new String[1];

        for (int i = 0; i < array.length ; i++) {
            int aa =0;
            for (int j = 0; j < unico.length ; j++) {

                if (array[i].equals(unico[j])){
                    aa++;
                }

                if (aa>0){
                    j= unico.length;
                }
            }
            if (aa==0){
                unico[unico.length-1]=array[i];
                unico=Arrays.copyOf(unico,unico.length+1);
            }

        }

    }

    public static void main(String[] args) {
        Boolean salida=false;
        String [] diccionario = {"debugging", "script", "backend", "frontend", "javaScript", "ciclo", "condicional", "programador", "objeto", "clase", "método", "algoritmo", "variable", "ciclo", "condicional", "programador", "compilador", "depuración", "interfaz", "herencia", "polimorfismo", "encapsulamiento", "objeto", "clase", "método", "estructura de datos", "API", "framework", "lenguaje de programación", "git", "commit", "repositorio", "código fuente", "compilación", "intérprete", "bug"};

        while (!salida){

            switch (menu()){
                case 1-> mostrar(diccionario);
                case 2-> buscar(diccionario);
                case 3-> media(diccionario);
                case 4-> palabraMayor(diccionario);
                case 5-> palabraRandom(diccionario);
                case 0-> salida=true;
                default -> System.out.println("Valor invalido");

            }

        }

        System.out.println("Saliendo del programa...");



    }


}
