package ejerciosBase.EjA1;

import java.util.Random;

public class Punto {

    private int x, y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void desplaza(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public double distancia(int x, int y) {
        double distan = 0;
        distan = Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
        return distan;
    }

    public void imprime() {
        System.out.printf("\nLas coordenadas son (%d , %d)\n", this.x, this.y);
    }

    public static Punto creaPuntoAleatorio(){

        Random ran=new Random();

        return new Punto(ran.nextInt(-100,101), ran.nextInt(-100,101));


    }


}
