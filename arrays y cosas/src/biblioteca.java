import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/*
 * Programa para el control de mesas de la biblioteca
 */
public class biblioteca {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random generador = new Random();
        int [] mesas;
        mesas = new int [10];
        int personas;

        for (int i = 0; i < mesas.length; i++) {
            mesas[i]= generador.nextInt(0,7);
        }


        System.out.println();
        do {
            // Muestra el estado de ocupación de las mesas
            System.out.println();
            System.out.print("│Mesa nº: ");
            for (int i = 1; i < mesas.length+1; i++) {
                System.out.printf("│ %2d ", i);
            }
            System.out.println();
            System.out.print("│Ocupación");
            for (int m : mesas) {
                System.out.printf("│ %2d ", m);
            }
            System.out.println();

            System.out.print("¿Cuántos son? (Introduzca -1 para salir del programa): ");
            personas = Integer.parseInt(teclado.nextLine());

            if (personas > 6) {
                System.out.print("Lo siento, no admitimos grupos de 6, haga grupos de");
                System.out.println(" 6 personas como máximo e intente de nuevo.");
            } else {
                // Busca una mesa que esté vacía.
                int iVacia = 0;
                boolean hayMesaVacia = false;
                for(int i = mesas.length-1; i >= 0; i--) {
                    if (mesas[i] == 0) {
                        iVacia = i;
                        hayMesaVacia = true;
                    }
                }

                if (hayMesaVacia) {
                    mesas[iVacia] = personas; // coloca a las personas en la mesa libre
                    System.out.println("Por favor, siéntense en la mesa número " + (iVacia + 1) + ".");
                }else {
                    // Busca un hueco.
                    int iHueco = 0;
                    boolean hayHueco = false;
                    for (int i = mesas.length-1; i >= 0; i--) {
                        if (personas <= (6 - mesas[i])) {
                            iHueco = i;
                            hayHueco = true;
                        }
                    }

                    if (hayHueco) {
                        mesas[iHueco] += personas;
                        System.out.println("Tendrán que compartir mesa. Por favor, siéntense en la mesa número " + (iHueco + 1) + ".");
                    } else {
                        System.out.println("Lo siento, en estos momentos no queda sitio.");
                        System.out.println("¿Ponemos una mesa más?: ");
                        String eleccion = teclado.nextLine();
                        if (eleccion.toUpperCase().equals("SI")){
                            mesas= Arrays.copyOf(mesas, mesas.length+1);
                            mesas[mesas.length-1]=personas;
                        }
                    }
                }

            }
        } while (personas != -1);

    }

}
