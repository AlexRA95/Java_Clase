package ejCLASE;

public class programarFunciones {

    static void showMatriz(int[][] invent, String[] ciudad, int[] talla){

        for (int i = 0; i < invent.length ; i++) {
            if (i==0){
                for (int l = 0; l <ciudad[1].length()+2 ; l++) {
                    System.out.print(" ");
                }
                for (int k = 0; k < talla.length ; k++) {
                    System.out.print(" " + talla[k] +" ");
                }
                System.out.println(" ");
            }
            for (int j = 0; j < invent[i].length ; j++) {
                if (j==0){
                    System.out.print(" " + ciudad[i] +" ");
                    for (int m = 0; m < ciudad[1].length()-ciudad[i].length() ; m++) {
                        System.out.print(" ");
                    }
                }
                System.out.print("  " + invent[i][j] + " ");
            }
            System.out.println(" ");
        }

    }

    static String masStockCiudad(String[] l,int [][] m ){
        String resultado=" ";
        int a=0,b=0;
        for (int i = 0; i <m.length ; i++) {
            a=0;
            for (int j = 0; j < m[i].length ; j++) {
                a+=m[i][j];

            }
            if (a>b){
                resultado=l[i];
                b=a;
            }
        }

        return resultado;

    }

    static int masStockUnidad(int[] num, int[][]cant){
        int resultado=0,a=0,b=0;

        for (int i = 0; i < cant[0].length ; i++) {
            a=0;
            for (int j = 0; j < cant.length ; j++) {
                a+=cant[j][i];

            }
            if (a>=0){
                resultado=num[i];
                b=a;
            }
        }
        return resultado;
    }

    public static void main(String[] args) {

        int [][] inventario={{0,2,0,0,1,3},{1,0,2,1,2,0},{3,0,1,2,1,2},{0,2,1,0,2,3}};
        String[] tienda= {"Mérida", "Don Benito", "Badajoz", "Caceres"};
        int [] numeros={35,36,37,38,39,40};


        showMatriz(inventario,tienda,numeros);

        System.out.println("La tienda con mas stock es :  " + masStockCiudad(tienda,inventario));
        System.out.println("El número con más stock entre todas las tiendas es : " + masStockUnidad(numeros,inventario));
    }

}
