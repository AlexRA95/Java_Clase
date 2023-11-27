import java.util.Scanner;

public class ej6 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduce tu nota:");
        double nota = keyboard.nextInt();

        System.out.println("Introduce tu edad:");
        double edad = keyboard.nextInt();

        System.out.println("Ponga M si es hombre");
        System.out.println("Ponga F si es mujer");
        System.out.println("Introduce tu sexo:");
        String sexo = keyboard.next();

        if ( nota > 5 && edad > 18 && sexo.equals("M")){

            System.out.println("Puede que puedas entrar");

        } else if (  nota > 5 && edad > 18 && sexo.equals("F") ) {

            System.out.println("Puedes entrar");

        } else if (nota < 5 || edad < 18) {

            System.out.println("O eres menor de edad o tu nota no te permite entrar");

        } else {

            System.out.println("Has introducido mal tus datos, vuelva a intentarlo");

        }


    }

}
