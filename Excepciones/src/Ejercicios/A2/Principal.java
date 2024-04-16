package Ejercicios.A2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner key=new Scanner(System.in);
        boolean exit=false;
        int num1=0,num2=0;

        while (!exit){
            try{
                System.out.println("Introduce un número: ");
                num1 = key.nextInt();
                System.out.println("Introduce otro número: ");
                num2 = key.nextInt();

                double div= num1/num2;
                System.out.println("La división entre " + num1 + " y " + num2 + " = " + div);
            }catch (InputMismatchException e){
                System.out.println("Valor introducido incorrecto");
                key.nextLine();
            }catch (ArithmeticException e){
                System.out.println("No se puede dividir esos valores");
            }
            if (num1==(-1) || num2==(-1)){
                exit=true;
            }


        }


    }

}
