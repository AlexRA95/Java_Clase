package Ejercicios.A4;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Random ran= new Random();
        Scanner key=new Scanner(System.in);
        boolean exit=false;
        int n= ran.nextInt(1,101);
        int [] vect= new int[n];
        for (int i = 0; i < vect.length ; i++) {
            n= ran.nextInt(1,11);
            vect[i]=n;
        }
        while (!exit){
            try {
                System.out.println("Introduce una posición del vector que quieras ver(El máximo es --->  " + vect.length +"): ");
                n= key.nextInt();

                System.out.println(vect[n-1]);

            }catch (ArrayIndexOutOfBoundsException e){
                if (n==(-1)) {
                    exit = true;
                    System.out.println("Saliendo del programa...");
                }else {
                    System.out.println("Valor incorrecto, no corresponde al tamaño del Vector.");
                }
            }catch (InputMismatchException e){
                System.out.println("Valor incorrecto, no es un numero lo que has introducido.");
            }


            key.nextLine();

        }
    }
}
