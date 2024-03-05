public class dias_mes {

    public static int calculoNumDias (int inicio, int fin) {
        int contador = 0;
        if ( ((inicio>=fin)) || (!(1<=inicio && inicio<=30)) || (!(1<=fin && fin<=30)) ) {
            return -1;
        } // if
        for (int i=inicio; i<fin; i++) {
            contador ++;
        } // for
        return contador;
    }


    public static void main(String[] args) {

        System.out.println(calculoNumDias(18,2));



    }


}
