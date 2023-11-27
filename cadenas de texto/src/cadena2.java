import java.util.Scanner;

public class cadena2 {

    public static void main(String[] args) {

        Scanner key = new Scanner(System.in);

        String word;
        Character letra;
        Integer contCons = 0, contVoca=0;


        System.out.println("Introuduce una palabra: ");
        word = key.nextLine();

        for (int i = 0; i < word.length(); i++) {
            letra = word.charAt(i);

            if (!Character.isSpaceChar(letra)) {

                switch (Character.toUpperCase(letra)) {

                    case 'A', 'E', 'I', 'O', 'U' -> contVoca++;

                    default -> contCons++;

                }

            }

        }

        System.out.printf("\nHay %d vocales y %d consonates en la palabra %s\n", contVoca,contCons, word);

    }

}
