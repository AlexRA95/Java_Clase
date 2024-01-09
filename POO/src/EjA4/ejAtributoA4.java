package EjA4;

public class ejAtributoA4 {

    public static void main(String[] args) {
        Articulo obj1= new Articulo("Toalla",25,30);
        Articulo obj2= new Articulo("Coche", 753159, 5 , 2);

        double pvp1 =obj1.precio + (obj1.precio*(obj1.iva/100));

        System.out.printf("\n %s - Precio %d € - IVA: %.2f - PVP: %.2f € - Unidades %d",obj1.nombre,obj1.precio,obj1.iva,pvp1,obj1.cuantosQuedan);


        double pvp2 =obj2.precio + (obj2.precio*(obj2.iva/100));

        System.out.printf("\n %s - Precio %d € - IVA: %.2f - PVP: %.2f € - Unidades %d",obj2.nombre,obj2.precio,obj2.iva,pvp2,obj2.cuantosQuedan);
    }

}
