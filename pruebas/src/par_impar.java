public class par_impar {

    public static boolean esPar(int x){
        boolean esPar=false;

        if ((x%2)==0){
            esPar=true;
        }else {
            esPar=false;
        }

        return esPar;

    }


    public static void main(String[] args) {

        for (int i = 0; i < 101; i++) {
            if (esPar(i)){
                System.out.printf("\nEl número %d es par\n",i);
            }else {
                System.out.printf("\nEl número %d es no par\n",i);
            }

        }


    }


}
