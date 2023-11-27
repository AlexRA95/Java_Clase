import java.util.Scanner;


public class switches_y_eso {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduce un número por pantalla:");
        int num1 = keyboard.nextInt();

        switch (num1){
            case 1:
                System.out.println("Es lunes");
                break;
            case 2:
                System.out.println("Es martes");
                break;
            case 3:
                System.out.println("Es miercoles");
                break;
            case 4:
                System.out.println("Es jueves");
                break;
            case 5:
                System.out.println("Es viernes");
                break;
            case 6:
                System.out.println("Es sábado");
                break;
            case 7:
                System.out.println("Es domingo");
                break;
            default:
                System.out.println("No has puesto un dia de la semana");


        }

    }

}
