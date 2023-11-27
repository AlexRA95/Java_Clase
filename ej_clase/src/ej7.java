import java.util.Scanner;

public class ej7 {




    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduce el primer punto del centro de la primera circunferencia:");
        double x1 = keyboard.nextInt();


        System.out.println("Introduce el segundo punto del centro de la primera circunferencia:");
        double y1 = keyboard.nextInt();

        System.out.println("Introduce el radio de la primera circunferencia:");
        double r1 = keyboard.nextInt();


        System.out.println("Introduce el primer punto del centro de la segunda circunferencia:");
        double x2 = keyboard.nextInt();


        System.out.println("Introduce el segundo punto del centro de la segunda circunferencia:");
        double y2 = keyboard.nextInt();


        System.out.println("Introduce el radio de la segunda circunferencia:");
        double r2 = keyboard.nextInt();


        double distcir =  Math.sqrt(Math.abs((Math.pow(x1-x2,2))+(Math.pow(y1-y2,2)))) ;
        
        if (distcir == 0 && r1<r2){
            System.out.println("El primer circulo es concentrico al segundo");
            
            
        } else if (distcir == 0 && r1>r2) {

            System.out.println("El segundo circulo es concentrico al primer");

        } else if ( distcir > (r1+r2)) {

            System.out.println("Los circulos son exteriores");
            
        } else if ( distcir == (r1-r2) ) {

            System.out.println("Son tangentes interiores");

        } else if ( distcir > 0 && distcir < Math.abs(r1-r2) ) {

            System.out.println("Son interiores");

        } else if (distcir == (r1+r2)) {

            System.out.println("Son tangentes exteriores");

        } else if (distcir < (r1+r2) && distcir > (r1-r2) ) {

            System.out.println("Son secantes.");

        }


    }


}
