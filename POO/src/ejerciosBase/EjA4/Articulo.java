package ejerciosBase.EjA4;

public class Articulo {
    private int precio;
    private final double iva;
    private String nombre;
    private int cuantosQuedan;
    public static final int IVA_GENERAL=21, IVA_REDUCIDO=10, IVA_SUPER_REDUCIDO=4;

    public Articulo(String nombre, int precio, int cuantosQuedan, int tipoIva) {

        if (precio > 0 && nombre.length() >= 2 && cuantosQuedan >= 0) {
            this.precio = precio;
            this.nombre = nombre;
            this.cuantosQuedan = cuantosQuedan;
        } else {
            System.err.println("ERROR DATO INVALIDO.");
        }
        switch (tipoIva){
            case 2->{
                this.iva= IVA_REDUCIDO;
            }
            case 3->{
                this.iva= IVA_SUPER_REDUCIDO;
            }
            default -> {
                this.iva= IVA_GENERAL;
            }
        }
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        if (precio<0){
            System.err.println("ERROR");
        } else {this.precio = precio;}

    }

    public double getIva() {
        return iva;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length()<2){
            System.err.println("ERROR");
        }else {this.nombre = nombre;}

    }

    public int getCuantosQuedan() {
        return cuantosQuedan;
    }

    public void setCuantosQuedan(int cuantosQuedan) {
        if (cuantosQuedan<0){
            System.err.println("ERROR");
        }else {
            this.cuantosQuedan = cuantosQuedan;
        }
    }

    public double getPVP(){

        return this.precio+(this.precio*(this.iva/100));

    }

    public double getPVPDescuento(double descuento){

        return this.getPVP()-(this.getPVP()*(descuento/100));

    }

    public void imprimir(){
            System.out.printf("\n %s - Precio %d € - IVA: %.2f - PVP: %.2f € - Unidades %d",this.nombre, this.precio, this.iva, this.getPVP(), this.precio);
    }

    public boolean vender(int cantidad){
        boolean seHace;
        if ((this.cuantosQuedan-cantidad)<0){
            seHace=false;
        }else {
            seHace=true;
            this.cuantosQuedan-=cantidad;
        }

        return seHace;

    }

    public boolean almacenar(int cantidad){
        boolean seHace;
        if (cantidad<=0){
            seHace=false;
        }else {
            seHace=true;
            this.cuantosQuedan+=cantidad;
        }

        return seHace;

    }

}
