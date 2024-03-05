package ejerciosBase.EjA3;

import java.util.Random;

public class Rectangulo {
    private int x1, x2, y1, y2;
    private final int max = 100, min = 0;

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        if (x1 > x2 || x1 < min || x1 > min || x2 > max) {
            System.err.println("ERROR");
        } else {
            this.x1 = x1;
        }

    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        if (x2 < x1 || x1 < min || x1 > min || x2 > max) {
            System.err.println("ERROR");
        } else {
            this.x2 = x2;
        }

    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        if (y1 > y2 || y1 < min || y1 > min || y2 > max) {
            System.err.println("ERROR");
        } else {
            this.y1 = y1;
        }

    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        if (y2 < y1 || y1 < min || y1 > min || y2 > max) {
            System.err.println("ERROR");
        } else {
            this.y2 = y2;
        }

    }

    public Rectangulo(int x1, int x2, int y1, int y2) {
        if (x1 > x2 || y1 > y2 || x1<min || x1>max || x2>max || y1<min ||y1>max || y2>max ) {
            System.err.println("ERROR: Datos invalidos.");
        } else {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
    }

    public void imprimir() {
        System.out.printf("\nLas coordenadas son:\n x1: %d\n y1: %d\n x2: %d \n y2: %d", this.x1, this.y1, this.x2, this.y2);
    }

    public void setXs(int x1, int x2) {
        if (x1 > x2 || x1<min || x1>max || x2>max) {
            System.err.println("ERROR: Datos invalidos.");
        } else {
            this.x1 = x1;
            this.x2 = x2;
        }
    }

    public void setYs(int y1, int y2) {
        if (y1 > y2 || y1 < min || y1 > min || y2 > max) {
            System.err.println("ERROR: Datos invalidos.");
        } else {
            this.y1 = y1;
            this.y2 = y2;
        }
    }

    public void setXY(int x1, int x2, int y1, int y2) {
        if (x1 > x2 || y1 > y2 || x1<min || x1>max || x2>max || y1<min ||y1>max || y2>max ) {
            System.err.println("ERROR: Datos invalidos.");
        } else {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
    }

    public int getArea() {
        return Math.abs(this.x2 - this.x1) * Math.abs(this.y2 - this.y1);
    }

    public int getPerimetro() {
        return (Math.abs(this.x2 - this.x1) + Math.abs(this.y2 - this.y1)) * 2;
    }

    public static  Rectangulo rectAleatorio(){
        Random ran=new Random();
        int x1Test, x2Test, y1Test, y2Test;
        do {
            x1Test= ran.nextInt(0,101);
            x2Test= ran.nextInt(0,101);
            y1Test= ran.nextInt(0,101);
            y2Test= ran.nextInt(0,101);
        }while (x1Test > x2Test || y1Test > y2Test);
        return new Rectangulo(x1Test,x2Test,y1Test,y2Test);

    }
}
