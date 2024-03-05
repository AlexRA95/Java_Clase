package ejerciosBase.EjA1;

public class ejAtributoA1 {
    public static void main(String[] args) {

        Punto p1 = new Punto(5,0);
        Punto p2 =new Punto(10,10);
        Punto p3 =new Punto(-3,7);
        Punto p4 = Punto.creaPuntoAleatorio();

        System.out.println("Parte 1:");

        p1.imprime();

        p2.imprime();

        p3.imprime();

        p4.imprime();

        System.out.printf("\nLa distancia entre el P1 y el P2 es %.2f\n",p1.distancia(p2.getX(),p2.getY()));


        p1.setX(p1.getX()/5);
        p1.setY(p1.getY()-1);
        p2.setX(p3.getX()+2);
        p2.setY(p2.getY()+1);
        p3.setX(p3.getX()*5);
        p3.setY(p1.getX()+p1.getY()+p2.getX()+p2.getY()+p3.getX()+p3.getY());

        System.out.println();
        System.out.println();
        System.out.println("Parte 2: ");

        p1.imprime();

        p2.imprime();

        p3.imprime();



    }
}
