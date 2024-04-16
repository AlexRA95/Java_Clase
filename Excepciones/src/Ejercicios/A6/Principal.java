package Ejercicios.A6;

public class Principal {
    public static void main(String[] args) {
        boolean salir=true;
        Gato g1=null,g2=null,g3=null;
        try {
            g1=new Gato("Gato1",12);
            g2=new Gato("Gato2",4);
            g3=new Gato("Gato3",7);
        }catch (GatoNombreEx e){
            System.out.println(e.toString());
        }catch (GatoEdadEx e){
            System.out.println(e.toString());
        }
        g1.imprimir();
        g2.imprimir();
        g3.imprimir();
        try {
            g1.setNombre("ho");
        }catch (GatoNombreEx e){
            System.out.println(e.toString());
        }

        try {
            g2.setEdad(-7);
        }catch (GatoEdadEx e){
            System.out.println(e.toString());
        }

        try {
            g3.setNombre("kk");
        }catch (GatoNombreEx e){
            System.out.println(e.toString());
        }

    }
}
