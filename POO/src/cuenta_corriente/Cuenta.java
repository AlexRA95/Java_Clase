package cuenta_corriente;

import java.util.Arrays;

public class Cuenta {

    private static int id=0;
    private String titular;
    private double cantidad;
    private double[] movimientos= new double[0];

    Cuenta(String titular){
        this.titular=titular;
        id++;
    }
    Cuenta(String titular, double cantidad){
        this.titular=titular;
        this.cantidad=cantidad;
        id++;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public static double getId() {
        return id;
    }

    public String getTitular() {
        return titular;
    }

    public double getCantidad() {
        return cantidad;
    }

    public boolean ingresar(double cantidad){
        boolean done=false;
        if (cantidad<0){
            System.err.println("No se pueden ingresar cantidades negativas.");
        }else {
            this.cantidad+=cantidad;
            historial(cantidad);
            System.out.println("Ingreso realizado correctamente.");
            done=true;
        }
        return done;
    }

    public  boolean esMorosa(){
        boolean moroso=false;
        if (this.cantidad<0) {
            moroso = true;
        }
        return moroso;
    }

    public boolean retirar(double cantidad){
        boolean done=false;
        if (cantidad>0){
            System.err.println("No se pueden retirar cantidades positivas.");
        }else {
            this.cantidad-=cantidad;
            historial(cantidad);
            System.out.println("Retiro realizado correctamente.");
            done=true;
        }
        return done;
    }

    public void historial(double cantidad){
        this.movimientos=Arrays.copyOf(movimientos,movimientos.length+1);
        this.movimientos[movimientos.length-1]=cantidad;
    }
}
