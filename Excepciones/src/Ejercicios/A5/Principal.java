package Ejercicios.A5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    static int pedirNumero(Scanner key){
        boolean salir=true;
        int sol=0;
        while (salir){
            try {
                System.out.println("Introduce un número: ");
                sol= key.nextInt();
                salir=false;
            }catch (InputMismatchException e){
                System.out.println("Valor incorrecto...");
                System.out.println();
                key.nextLine();
            }
        }
        return sol;
    }

    static void imprimePositivo(Scanner key) throws NumPositivoEx {
        int p=pedirNumero(key);

        if (p<0) throw new NumPositivoEx(p);
        System.out.println("El número es --> " + p);

    }
    static void imprimeNegativo(Scanner key) throws NumNegativoEx{
        int p=pedirNumero(key);
        if (p>=0) throw new NumNegativoEx(p);
        System.out.println("El número es --> " + p);
    }

    public static void main(String[] args) {
        boolean keep=true;
        Scanner key=new Scanner(System.in);

        while (keep){
            try {
                System.out.println("1. Imprimir números positivos.");
                System.out.println("2. Imprimir números negativos.");
                System.out.println("-1. Para salir.");
                System.out.println("Introduce tu opción: ");
                int n= key.nextInt();

                switch (n){
                    case 1->{
                        try {
                            imprimePositivo(key);
                        }catch (NumPositivoEx e){
                            System.out.println(e.toString());
                        }
                    }
                    case 2->{
                        try {
                            imprimeNegativo(key);
                        }catch (NumNegativoEx e){
                            System.out.println(e.toString());
                        }
                    }
                    case (-1)->{
                        keep=false;
                        System.out.println("Saliendo del programa.");
                    }
                    default -> System.out.println("Valor incorrecto.");
                }

            }catch (InputMismatchException e){
                System.out.println("Valor invalido introducido.");
            }


        }



    }

}
