package EjA4;

public class Articulo {
    public int precio;
    public double iva;
    public String nombre;
    public int cuantosQuedan;

    public Articulo(String nombre, int precio, int cuantosQuedan){

        if (precio>0 && nombre.length()>=2 && cuantosQuedan>=0){
            this.precio=precio;
            this.nombre=nombre;
            this.cuantosQuedan=cuantosQuedan;
            this.iva=21;

        }else {
            System.err.println("ERROR DATO INVALIDO.");
        }


    }

    public Articulo(String nombre,int precio,  int cuantosQuedan, double iva){

        if (precio>0 && nombre.length()>=2 && cuantosQuedan>=0 && iva>=0){
            this.precio=precio;
            this.nombre=nombre;
            this.cuantosQuedan=cuantosQuedan;
            this.iva=iva;

        }else {
            System.err.println("ERROR DATO INVALIDO.");
        }

    }
}
