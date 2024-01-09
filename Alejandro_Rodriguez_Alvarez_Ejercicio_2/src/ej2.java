import java.util.Random;
import java.util.Scanner;

public class ej2 {

    static String palabraSecreta(String[] array){
        Integer random;
        String secret;
        Random ran =new Random();
        random= ran.nextInt(0, array.length-1);
        secret=array[random];

        return secret;

    }

    static void generarPista(String secreta, String user){
        for (int i = 0; i <user.length() ; i++) {
             secreta = secreta.toUpperCase();
             user = user.toUpperCase();

            if (Character.toString(secreta.charAt(i)).equals(Character.toString(user.charAt(i)))){
                System.out.print("X");
            } else if (secreta.contains(Character.toString(user.charAt(i)))) {
                System.out.print("O");
            }else {
                System.out.print("-");
            }
        }
        System.out.println(" ");

    }
    static Integer comprobarPalabra(String secret, String palabra){
    Integer ok=-1;
        if (palabra.length()!=secret.length()){
            System.out.printf("\n!!!DEBES INTRODUCIR UNA PALABRA DE %d LETRAS¡¡¡\n",secret.length());
            ok=-1;
        }else {ok=1;}

        return ok;
    }

    static Integer comprobarGanar(String secret, String palabra){
        secret=secret.toUpperCase();
        palabra=palabra.toUpperCase();
        Integer ganar=-1;

        if (secret.equals(palabra)){
            System.out.println("!!!FANTASTICO, HAS GANADO¡¡¡");
            ganar=1;
        }else{
            System.out.println("Lo siento, esa no era la palabra secreta.");
            ganar=-1;
        }

        return ganar;
    }

    public static void main(String[] args) {
        Scanner key=new Scanner(System.in);
        String palabra,palSecreta;

        String[] wordle={"perro", "plato", "trono", "pilar", "mundo", "cable", "silla", "cardo", "trato", "balsa", "cielo","papel", "trino", "palco", "nieve", "campo", "barco", "fruta",  "fiera", "lucha", "pieza", "nariz","chuzo", "perla",  "tarta", "truco", "miedo", "tabla", "radio", "sonar"};
        palSecreta=palabraSecreta(wordle);


        for (int i = 5; i >0 ; i--) {
            System.out.printf("\nTe quedan %d intentos.\n",i);
            System.out.printf("Introduce una palabra de %d letras: ",palSecreta.length());
            palabra=key.nextLine();
            if (comprobarPalabra(palSecreta,palabra)==-1){
                i++;
            }else {
                if (comprobarGanar(palSecreta,palabra)==-1){
                    if (i==1){
                        System.out.println("Lo siento, ya no te quedan intentos");
                        System.out.printf("\nLa palabra secreta era %S",palSecreta);
                    }else {
                        System.out.print("\n Te daré una pista... ");
                        generarPista(palSecreta,palabra);
                    }

                }else {
                    i=0;
                }
            }
        }
    }
}
