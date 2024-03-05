public class Cafetera {

    private int id=0;
    private static int desperdicio=0;
    private final int MINIMO=300, MAXIMO=3000;
    private final int tamano;
    private int  cantidadActual;
    private static int contadorId=0;

    public Cafetera() {
        this.tamano = 1000;
        this.cantidadActual = 0;
        this.id=++contadorId;
    }
    public Cafetera(int tamano) {
        if (tamano<MINIMO){
            this.tamano = MINIMO;
            this.cantidadActual = this.tamano;
        } else if (tamano>MAXIMO) {
            this.tamano = MAXIMO;
            this.cantidadActual = this.tamano;
        }else {
            this.tamano = tamano;
            this.cantidadActual = tamano;
        }
        this.id=++contadorId;
    }

    public Cafetera(int tamano, int cantidadActual) {

        if (tamano<MINIMO){
            this.tamano = MINIMO;
        } else if (tamano>MAXIMO) {
            this.tamano = MAXIMO;
        }else {
            this.tamano = tamano;
        }
        if (getTamano()<cantidadActual){
            this.cantidadActual=this.tamano;
        }else if(cantidadActual<0){
            this.cantidadActual=0;
        } else{
            this.cantidadActual=cantidadActual;
        }
        this.id=++contadorId;
    }

    public int getId() {
        return id;
    }

    public int getTamano() {
        return tamano;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public void imprimir(){
        System.out.printf("\n[ Cafetera: %d  Capacidad: %d ml  Cafe: %d ml. ]\n",getId(), getTamano(), getCantidadActual());
    }

    public void llenarCafetera(){
        this.cantidadActual=this.tamano;
        System.out.printf("\nLa cafetera %d se ha llenado correctamente.\n",getId());
    }

    public void servirTaza(TipoTaza taza){
        if (getCantidadActual()<taza.getCantidad()){
            System.out.println("No se puede servir esa taza.");
        }else {
            System.out.printf("\nSe ha servido una taza %s\n", taza);
            setCantidadActual(getCantidadActual()-taza.getCantidad());
            if (getCantidadActual()<200){
                System.out.println("No queda sufuciente café en esta cafetera, se procederá a vaciar.");
                desperdicio+=getCantidadActual();
                setCantidadActual(0);
            }
        }

    }
    public void vaciarCafetera(){
        desperdicio+=getCantidadActual();
        setCantidadActual(0);
        System.out.println("Se ha vaciado la cafetera " + getId());
    }

    public void agregarCafe(int cant){
        if (cant<=0){
            System.out.println("No se puede añadir una cantidad negativa de café.");
        }else if (cant>(getTamano()-getCantidadActual())){
            System.out.println("Se ha agregado café.");
            setCantidadActual(getTamano());
        }else {
            System.out.println("Se ha agregado café.");
            setCantidadActual(getCantidadActual()+cant);
        }
    }

    public static Cafetera masLLena(Cafetera a, Cafetera b){
        Cafetera aux;
        if (a.cantidadActual<b.cantidadActual){
            aux=b;
        }else {
            aux=a;
        }
        return aux;
    }

    public static int getCafeDesperdiciado(){
        return desperdicio;
    }
    public static int getCafeterasTotales(){
        return contadorId;
    }

}
