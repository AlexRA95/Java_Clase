import java.util.Scanner;

public class javaPrueba {


    static Integer menu(Scanner tecla){
        Integer opc;
        System.out.println("[1] Mostrar todas las palabras.");
        System.out.println("[2] Mostrar palabras con un caracter.");
        System.out.println("[3] Mostrar longitud media de palabras.");
        System.out.println("[0] Para salir.");
        System.out.println("Introduce tu opción: ");
        opc= tecla.nextInt();

        return opc;

    }
    static void mostrarArray(String[] array){

        for (int i = 0; i < array.length ; i++) {

            System.out.printf("%s, ",array[i]);
            if ((i%5)==0){
                System.out.println(" ");
            }

        }

    }

    static void mostarPalabraCaracter(Scanner tecla, String[] array){
        tecla.nextLine();
        String caracter;
        System.out.println("Introduce el caracter a buscar: ");
        caracter = tecla.nextLine();

        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array[i].length(); j++) {
                if (array[i].contains(caracter)){
                    System.out.println(array[i]);
                    j= array[i].length();
                }
            }
        }

    }

    static void longitudMedia(String[] array){
        String sinEspacio,conEspacio;
        Integer total1=0, total2=0;
        for (int i = 0; i < array.length ; i++) {
            sinEspacio=array[i].replaceAll("\\s+","");
            System.out.println(sinEspacio);
            System.out.println(sinEspacio.length());
            conEspacio=array[i];
            System.out.println(conEspacio);
            System.out.println(conEspacio.length());
            total2+=conEspacio.length();
            total1+=sinEspacio.length();
        }
        System.out.printf("\nLa longitud media del array sin espacios en blanco es %d y con espacios es %d",total1,total2);
    }

    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        String [] diccionario={"debugging", "script", "backend", "frontend", "javaScript", "ciclo", "condicional", "programador", "objeto", "clase", "método", "algoritmo", "variable", "ciclo", "condicional", "programador", "compilador", "depuración", "interfaz", "herencia", "polimorfismo", "encapsulamiento", "objeto", "clase", "método", "estructura de datos", "API", "framework", "lenguaje de programación", "git", "commit", "repositorio", "código fuente", "compilación", "intérprete", "bug"};
        Boolean salir=false;


        while (!salir){

            switch (menu(key)){
                case 1->{mostrarArray(diccionario);}
                case 2->{mostarPalabraCaracter(key, diccionario);}
                case 3->{longitudMedia(diccionario);}
                case 0->{
                    System.out.println("Saliendo...");
                    salir=true;
                }
                default -> {

                    System.out.println("ERROR: Valor incorrecto.");

                }


            }

        }

    }
}
