import java.util.Scanner;

public class contarletrascadena {

    static int contarCadena(String cadena) {

        int letras = 0;
        for (int i = 0; i < cadena.length(); i++) {

            Character caracter;
            caracter = cadena.charAt(i);

            if (Character.isLetter(caracter)) {
                letras++;
            }
        }

        return letras;
    }

    public static void main(String[] args) {

        String hola;

        Scanner key =new Scanner(System.in);

        System.out.println("Introduce un texto: ");
        hola = key.nextLine();

        int resultado = contarCadena(hola);

        System.out.printf("\nEn esa cadena hay %d letras\n",resultado);


    }

}
