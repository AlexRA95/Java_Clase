package EjA1;

import EjA1.Punto;

public class ejAtributoA1 {
    public static void main(String[] args) {

        Punto p1 = new Punto(5,0);
        Punto p2 =new Punto(10,10);
        Punto p3 =new Punto(-3,7);

        System.out.println("Parte 1:");

        System.out.printf("\nEl punto 1 tiene las cordenadas ( x: %d , y: %d )",p1.x,p1.y);

        System.out.printf("\nEl punto 2 tiene las cordenadas ( x: %d , y: %d )",p2.x,p2.y);

        System.out.printf("\nEl punto 3 tiene las cordenadas ( x: %d , y: %d )",p3.x,p3.y);

        p1.x=p1.x/5;
        p1.y--;
        p2.x=p3.x+2;
        p2.y++;
        p3.x=p3.x*5;
        p3.y=(p1.x+p1.y+p2.x+p2.y+p3.x+p3.y);

        System.out.println();
        System.out.println();
        System.out.println("Parte 2: ");

        System.out.printf("\nEl punto 1 tiene las cordenadas ( x: %d , y: %d )",p1.x,p1.y);

        System.out.printf("\nEl punto 2 tiene las cordenadas ( x: %d , y: %d )",p2.x,p2.y);

        System.out.printf("\nEl punto 3 tiene las cordenadas ( x: %d , y: %d )",p3.x,p3.y);

    }
}
