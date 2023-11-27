import java.util.Scanner;

public class cadenatexto1 {

    public static void main(String[] args) {

        Scanner key = new Scanner(System.in);

        String word1,word2 = "";
        Character letra;


        System.out.println("Introuduce una palabra: ");
        word1= key.nextLine();

        for (int i = 0; i < word1.length() ; i++) {

             letra =word1.charAt(i);

            if (Character.isUpperCase(letra)){

                letra=Character.toLowerCase(letra);

            } else {

                letra=Character.toUpperCase(letra);

            }

            word2+=letra;

        }


        System.out.println(word2);

    }
}
