package ejerciosBase.EjA3;

public class ejAtributoA3 {

    public static void main(String[] args) {
        Rectangulo rec1 = new Rectangulo(0, 5, 0, 5);
        Rectangulo rec2 = new Rectangulo(7, 20, 9, 30);
        Rectangulo rec3= Rectangulo.rectAleatorio();


        System.out.printf("\n El rectangulo definido por las coordenadas ( %d , %d ) y ( %d , %d ) tiene un perimetro %d y un area %d\n ", rec1.getX1(), rec1.getY1(), rec1.getX2(), rec1.getY2(), rec1.getPerimetro(), rec1.getArea());

        System.out.printf("\n El rectangulo definido por las coordenadas ( %d , %d ) y ( %d , %d ) tiene un perimetro %d y un area %d\n ", rec2.getX1(), rec2.getY1(), rec2.getX2(), rec2.getY2(), rec2.getPerimetro(), rec2.getArea());

        rec3.imprimir();


        System.out.println("");

        rec1.setXY(-5,75,9,15);

        rec2.setXY(7,43,58,609);


        System.out.printf("\n El rectangulo definido por las coordenadas ( %d , %d ) y ( %d , %d ) tiene un perimetro %d y un area %d\n ", rec1.getX1(), rec1.getY1(), rec1.getX2(), rec1.getY2(), rec1.getPerimetro(), rec1.getArea());

        System.out.printf("\n El rectangulo definido por las coordenadas ( %d , %d ) y ( %d , %d ) tiene un perimetro %d y un area %d\n ", rec2.getX1(), rec2.getY1(), rec2.getX2(), rec2.getY2(), rec2.getPerimetro(), rec2.getArea());


    }

}
