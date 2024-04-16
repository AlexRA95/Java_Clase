package Ejercicios.A3;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        double[] vector = new double[5];
        Scanner key=new Scanner(System.in);
        boolean exit=false;
        int i=0;

        while (!exit){
            try {
                System.out.println("Introduce un número: ");
                vector[i]= key.nextInt();

                i++;
            }catch (IndexOutOfBoundsException e){
                System.out.println("El array ya está lleno.");
                System.out.println("Saliendo del programa...");
                exit=true;
            }catch (InputMismatchException e){
                System.out.println("Valor no valido...");
                key.nextLine();
            }

        }

        System.out.println(Arrays.toString(vector));




    }
}
