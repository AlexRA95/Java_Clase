package Calculadora;

public class Calculadora {


    public static int suma(int num1, int num2) {

        return num1 + num2;


    }

    public static int restar(int num1, int num2) {

        return num1 - num2;

    }

    public static int multi(int num1, int num2) {

        return num1 * num2;

    }

    public static int dividir(int num1, int num2) {

        if (num2 == 0) {
            return 0;
        } else {
            return num1 / num2;
        }
    }
}
