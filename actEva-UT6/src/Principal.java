public class Principal {

    public static void main(String[] args) {

        System.out.println("\n * Prueba de constructores");
        Cafetera  c1 = new Cafetera();
        c1.imprimir();
        Cafetera c2 = new Cafetera(6000);
        c2.imprimir();
        Cafetera c3 = new Cafetera(200);
        c3.imprimir();
        Cafetera c4 = new Cafetera(2000,2500);
        c4.imprimir();
        Cafetera c5 = new Cafetera(1500, -1);
        c5.imprimir();
        Cafetera c6 = new Cafetera(800, 500);
        c6.imprimir();

        System.out.println("\n * Prueba de llenar cafetera");
        c5.imprimir();
        c5.llenarCafetera();
        c5.imprimir();

        System.out.println("\n * Prueba de vaciar cafetera");
        c5.imprimir();
        c5.vaciarCafetera();
        c5.imprimir();

        System.out.println("\n* Prueba de agregar cafe");
        c1.imprimir();
        c1.agregarCafe(-1500);
        c1.imprimir();
        c1.agregarCafe(500);
        c1.imprimir();
        c1.agregarCafe(1500);
        c1.imprimir();

        System.out.println("\n* Prueba de servir taza");
        c2.imprimir();
        c2.servirTaza(TipoTaza.TRENTA);
        c2.imprimir();
        c2.servirTaza(TipoTaza.VENTI);
        c2.imprimir();
        c2.servirTaza(TipoTaza.GRANDE);
        c2.imprimir();
        c2.servirTaza(TipoTaza.TALL);
        c2.imprimir();
        c2.servirTaza(TipoTaza.SHORT);
        c2.imprimir();

        System.out.println("\n* Prueba de no tener cafe suficiente para servir un tipo de taza concreto");
        c6.imprimir();
        c6.servirTaza(TipoTaza.TRENTA);
        c6.imprimir();

        System.out.println("\n* Prueba de vaciar cafetera cuando hay menos de 200ml");
        c6.imprimir();
        c6.servirTaza(TipoTaza.GRANDE);
        c6.imprimir();

        System.out.println("\n* Prueba de cafetera mas llena");
        System.out.println("  - Entre c3 y c4 la cafetera más llena es...");
        Cafetera.masLLena(c3,c4).imprimir();

        System.out.println("\n* Prueba de contador de cafeteras");
        System.out.printf("   - Se han creado un total de %d cafeteras.\n",Cafetera.getCafeterasTotales());

        System.out.println("\n* Prueba de café desperdiciado");
        System.out.printf("   - Se ha desperdiciado un total de %dml. de café.\n",Cafetera.getCafeDesperdiciado());


    }
}
