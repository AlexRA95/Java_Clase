package comoExamen;

import java.util.Scanner;

public class comoExamen1 {
    static Integer menuPrincipal() {
        Scanner key = new Scanner(System.in);
        Integer opc = -1;
        Boolean exit = false;

        while (!exit) {
            System.out.println("------Menú------");
            System.out.println("[1] Para ver las horas que has estudiado las ultimas 4 semanas.");
            System.out.println("[2] Para sumar todas las horas que has estudiado las ultimas 4 semanas.");
            System.out.println("[3] Para saber la media de horas que has estudiado al día.");
            System.out.println("[4] Para saber el día que más has estudiado.");
            System.out.println("[5] Para saber la semana que más has estudiado.");
            System.out.println("[6] Para saber el día de la semana donde has estudiado más.");
            System.out.println("[0] Para salir");
            System.out.println("Introduce tu opción:");
            try {
                opc = key.nextInt();
                exit = true;
            } catch (Exception e) {
                System.out.println("Valor incorrecto.");
                exit = false;
                key.nextLine();
            }
            System.out.println(" ");
        }

        return opc;

    }

    static void mostrarCalendario(Integer[][] matriz) {
        Integer contar = 1;
        for (int i = 0; i < matriz.length; i++) {
            if (i == 0) {
                System.out.println("    L  M  X  J  V  S  D");
            }
            for (int j = 0; j < matriz[i].length; j++) {
                if (j == 0) {
                    System.out.printf("S%d", contar);
                    contar++;
                }
                System.out.print("  " + matriz[i][j]);
            }
            System.out.println(" ");
        }
    }

    static void sumarHorasSemana(Integer[][] matriz) {
        Integer sumatorio = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                sumatorio += matriz[i][j];
            }
        }
        System.out.printf("\nHas estudiado un total de %d horas\n", sumatorio);
    }

    static void mediaHorasDia(Integer[][] matriz) {
        Double sumatorio = 0.0, contador = 1.0, media;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                sumatorio += matriz[i][j];
                contador++;
            }
        }
        media = (sumatorio / contador);
        System.out.printf("\nHas estudiado una media de %.2f horas al día\n", media);
    }

    static String diaSemana(Integer dia) {
        String resultado = "";

        switch (dia) {
            case 0 -> resultado = "Lunes";
            case 1 -> resultado = "Martes";
            case 2 -> resultado = "Miercoles";
            case 3 -> resultado = "Jueves";
            case 4 -> resultado = "Viernes";
            case 5 -> resultado = "Sabado";
            case 6 -> resultado = "Domingo";
            default -> resultado = null;
        }
        return resultado;
    }

    static void diaMasEstudio(Integer[][] matriz) {
        Integer aa = 0, masHoras = 0, dia = -1, semana = 1;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                aa = matriz[i][j];
                if (aa >= masHoras) {
                    masHoras = aa;
                    dia = j;
                    semana = i + 1;
                    aa=0;
                }
            }
        }
        System.out.printf("\nEl día que más has estudiado fue un %s de la %dº semana", diaSemana(dia), semana);
    }

    static void semanaMasEstudio(Integer[][] matriz) {
        Integer sumatorioSemana = 0, resultado = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                sumatorioSemana += matriz[i][j];
            }
            System.out.printf("\nLa semana %d has estudiado %d horas.\n", i + 1, sumatorioSemana);
            if (sumatorioSemana >= resultado) {
                resultado = i + 1;
                sumatorioSemana=0;
            }
        }
        System.out.printf("\nLa semana que más has estudiado ha sido la semana nº %d\n", resultado);
    }

    static void diaSemanaMasEstudio(Integer[][] matriz){
        Integer sumatorioDias=0,resultado=0,dia=0;
        for (int i = 0; i <matriz[0].length ; i++) {
            for (int j = 0; j <matriz.length ; j++) {
                sumatorioDias+=matriz[j][i];
            }
            if (sumatorioDias>=resultado){
                resultado=sumatorioDias;
                sumatorioDias=0;
                dia=i;
            }

        }
        System.out.printf("\nEl día de la semana que más estudias es el %s\n",diaSemana(dia));
    }

    public static void main(String[] args) {
        Integer[][] calendario = {{1, 2, 1, 1, 0, 2, 3}, {0, 1, 1, 2, 0, 2, 2}, {0, 1, 1, 1, 0, 2, 3}, {1, 2, 2, 1, 0, 5, 4}};
        Boolean salir = false;

        while (!salir) {
            switch (menuPrincipal()) {
                case 1 -> {
                    System.out.println("Opcion 1:");
                    mostrarCalendario(calendario);
                }
                case 2 -> {
                    System.out.println("Opcion 2:");
                    sumarHorasSemana(calendario);
                }
                case 3 -> {
                    System.out.println("Opcion 3:");
                    mediaHorasDia(calendario);
                }
                case 4 -> {
                    System.out.println("Opción 4:");
                    diaMasEstudio(calendario);
                }
                case 5 -> {
                    System.out.println("Opción 5: ");
                    semanaMasEstudio(calendario);
                }
                case 6->{
                    System.out.println("Opcción 6:");
                    diaSemanaMasEstudio(calendario);
                }
                case 0 -> {
                    System.out.println("Saliendo del programa...");
                    salir = true;
                }
                default -> {
                    System.out.println("ERROR: Valor incorrecto.");
                }
            }
            System.out.println(" ");
        }
    }
}
