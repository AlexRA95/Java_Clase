package Ejercicios.A1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner key=new Scanner(System.in);
        boolean exit=false;
        int num=0;

        while (!exit){
            try{
                System.out.println("Introduce un número: ");
                num = key.nextInt();

                System.out.println("Valor introducido: " + num);
            }catch (InputMismatchException e){
                System.out.println("Valor introducido incorrecto");
                key.nextLine();
            }
            if (num==(-1)){
                exit=true;
            }


        }

    }
}
