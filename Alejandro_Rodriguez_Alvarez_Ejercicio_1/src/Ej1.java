import java.util.Scanner;

public class Ej1 {


    static Integer menu() {
        Integer opc = -1;
        Boolean exit = false;
        Scanner key = new Scanner(System.in);

        do {
            System.out.println("----- MENÚ DE OPCIONES -----");
            System.out.println("1. Alimento más sano.");
            System.out.println("2. Clasificación nutriscore");
            System.out.println("3. Alimentos con mayor y menor energía.");
            System.out.println("4. Salir.");
            System.out.println("Seleccione una opción...");
            try {
                opc = key.nextInt();
                exit = true;
            } catch (Exception e) {
                System.out.println("ERROR: Dato invalido");
                key.nextLine();
                exit = false;
            }
        } while (!exit);

        return opc;

    }

    static String numeroComida(Integer numero) {
        String comida = "";

        switch (numero) {
            case 0 -> comida = "Fruta";
            case 1 -> comida = "Zumo";
            case 2 -> comida = "Pizza";
            case 3 -> comida = "Cereales";
            default -> comida = "";
        }

        return comida;

    }

    static void alimentoMasSano(Integer[][] matriz) {
        Double media = 0.0, sumatorio = 0.0, probar = Double.MAX_VALUE;
        Integer comida = -1;

        for (int i = 0; i < matriz[0].length; i++) {
            sumatorio = 0.0;
            for (int j = 1; j < matriz.length; j++) {
                sumatorio += matriz[j][i];
            }
            media = (sumatorio / 3);

            if (media < probar) {
                probar = media;
                comida = i;
            }

        }

        System.out.printf("\nLa comida más sana es: %s con un valor medio nutricional de %.2f\n", numeroComida(comida), probar);

    }

    static String clasiNutri(Integer nutricion) {
        String solu = "";

        if (nutricion >= 10) {
            solu = "A";
        } else if (nutricion >= 5) {
            solu = "B";
        } else if (nutricion >= 2) {
            solu = "C";
        } else if (nutricion >= 0) {
            solu = "D";
        } else {
            solu = "E";
        }

        return solu;

    }

    static void nutriScore(Integer[][] matriz) {
        Integer nutri;
        for (int i = 0; i < matriz[0].length; i++) {
            nutri = 0;
            nutri = (matriz[0][i] - (matriz[3][i] + matriz[1][i] * matriz[2][i]));
            System.out.printf("Alimento -> %S Clasificación -> %S", numeroComida(i), clasiNutri(nutri));
            System.out.println(" ");
        }

    }

    static void energia(Integer[][] matriz) {
        Integer energia, minimo = Integer.MAX_VALUE, maximo = Integer.MIN_VALUE, comidaMin = -1, comidaMax = -1;
        for (int i = 0; i < matriz[0].length; i++) {
            energia = 0;
            energia = (matriz[0][i] - matriz[3][i]);
            if (minimo > energia) {
                minimo = energia;
                comidaMin = i;
            }
            if (maximo < energia) {
                maximo = energia;
                comidaMax = i;
            }
        }
        System.out.println("Alimentos con MAYOR y MENOR aporte energético: ");
        System.out.printf("\n-MAYOR aporte energético-> %S - %d Kj.", numeroComida(comidaMax), maximo);
        System.out.printf("\n-MENOR aporte energético-> %S - %d Kj.\n", numeroComida(comidaMin), minimo);
    }

    public static void main(String[] args) {
        Integer[][] tabla = {{50, 24, 200, 304}, {1, 0, 10, 36}, {0, 0, 59, 8}, {15, 18, 7, 12}};
        Boolean salir = false;


        while (!salir) {
            switch (menu()) {
                case 1 -> {
                    alimentoMasSano(tabla);
                }
                case 2 -> {
                    nutriScore(tabla);
                }
                case 3 -> {
                    energia(tabla);
                }
                case 4 -> {
                    System.out.println("Saliendo...");
                    salir = true;
                }
                default -> {
                    System.out.println("ERROR: DATO INVALIDO.");
                }
            }

        }
    }


}
