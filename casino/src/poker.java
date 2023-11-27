import java.util.Random;


public class poker {

    public static void main(String[] args) {

        Random ran = new Random();


        int num1 = ran.nextInt(1, 4);
        int num2 = ran.nextInt(1, 13);
        String carta;
        String palo = switch (num1) {
            case 1 -> "treboles";
            case 2 -> "picas";
            case 3 -> "diamantes";
            case 4 -> "corazones";
            default -> null;
        };

        carta = switch (num2) {
            case 1 -> "AS";
            case 11 -> "J";
            case 12 -> "Q";
            case 13 -> "K";
            default -> String.valueOf(num2);
        };

        System.out.printf("%S de %S",carta,palo);




        }
    }







