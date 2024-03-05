public class primo_o_no {

    public static boolean esPrimo(int x) {
        boolean esPrimo = false;
        int cont = 0;
        for (int i = x; i > 0; i--) {
            if ((x % i) == 0) {
                cont++;
            }
        }

        if (cont == 2) {
            esPrimo = true;
        } else {
            esPrimo = false;
        }


        return esPrimo;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 101; i++) {
            if (esPrimo(i)) {
                System.out.printf("\nEl número %d es primo\n", i);
            } else {
                System.out.printf("\nEl número %d no es primo\n", i);
            }

        }
    }


}
