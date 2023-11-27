import java.util.Random;
import java.util.Scanner;
/*Alejandro Rodríguez Álvarez*/
/*Fecha: 27/10/2023*/
/*Esto es un programa excesivamente largo donde podremos jugar a la version más complicada del piedra, papel, tijera*/

public class trabajo_1 {





    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        Random rnd = new Random();
        int opc1 = 0, opc2 = 0, cont, ia, userwin = 0, iawin = 0, win = 0, lose = 0, total = 0, emp = 0, round = 0, bo5user = 0, bo5ia = 0;
        double ganar, totales, percent;
        boolean ok = true;

        /*Lo primero de todo es montar un menú que explique las normas de juego y lo que puedes hacer con el programa*/
        /*Anteriormente hemos declarado distintas variables y explicaremos para que sirve cada una:
         * opc1, es la opción del menú que el usuario usará
         * opc2, es la opción que usará el usuario en el juego
         * cont, es la variable de inicialización del bucle
         * ia, es un número aleatorio que simula una opción de juego
         * userwin, es un contador de las rondas que ha ganado el usuario
         * iawin, es el contador de las rondas que ha ganado la ia
         * win, es un contador del numero de partidas ganadas
         * lose, es un contador del numero de rondas perdidas
         * total, es un contador del numero total de partidas jugadas
         * emp, es un contador del numero de rondas empatadas
         * round, es un contador del numero de rondas ganadas
         * bo5user y bo5ia, sirven para contar las victorias en el mejor de 5 sin tocar nada en las estadisticas
         * ganar, es el valor userwin pero en double
         * totales, es el valor round pero en double
         * percent, es el resultado de la división entre ganar y totales, luego multiplicado por 100 para ser un %
         * el booleano ok, sirve para el control de excepciones en el scanner */
        System.out.println("--------------  PIEDRA, PAPEL, TIJERA, LAGARTO, SPOK  --------------");
        System.out.println("                         EL VIDEOJUEGO                              ");
        System.out.println(" ");
        System.out.println("INSTRUCCIONES: ");
        System.out.println(" ");
        System.out.println("En este programa podremos jugar al afamadísimo juego de piedra, papel, tijera, lagarto, spok.");
        System.out.println(" ");
        System.out.println("Se contarán con varios modos de juegos");
        System.out.println(" ");
        System.out.println("1.  El primero es una partida a 1 ronda.");
        System.out.println(" ");
        System.out.println("2.  El segundo es una partida al mejor de 5 rondas");
        System.out.println(" ");
        System.out.println("3.  Luego tendremos la opción de ver las estadísticas de juego de esta sesión");
        System.out.println(" ");

        /*Aqui usamos el scanner para que salga solo esta parte*/
        System.out.println("Presiona enter para continuar");
        keyboard.nextLine();

        System.out.println("Las normas de juego son estas:");
        System.out.println(" ");
        System.out.println("""
                1. Piedra aplasta Tijeras.
                2. Tijeras cortan Papel.
                3. Papel cubre Piedra.
                4. Piedra aplasta Lagarto.
                5. Lagarto envenena Spock.
                6. Spock destroza Tijeras.
                7. Tijeras decapitan Lagarto.
                8. Lagarto se come el Papel.
                9. Papel desautoriza a Spock.
                10. Spock vaporiza la Piedra.""");

        System.out.println(" ");
        /*Aqui usamos el scanner para que salga solo esta parte, luego se inicializa el bucle*/
        System.out.println("Presiona enter para jugar");
        keyboard.nextLine();
        cont = 0;


        while (cont == 0) {
            /*Aqui está el menú de opciones de juego*/
            System.out.println( "--------------  Menú de juego  --------------" );
            System.out.println("Escriba 1 si quiere jugar una partida normal.");
            System.out.println("Escriba 2 si quiere jugar una partida al mejor de 5.");
            System.out.println("Escriba 3 para ver sus estadísticas en esta sesión de juego.");
            System.out.println("Escriba 0 para salir del juego");
            System.out.println(" ");
            System.out.println("Escriba su opción: ");
            try {

                opc1 = keyboard.nextInt();

            } catch (Exception e) {

                System.out.println("Dato no valido");


            }

            /*Con el dato que nos da el usuario entramos en switch para realizar las opciones que quiere*/
            switch (opc1) {
                case 1->{

                    /*Partida normal*/
                    do {

                        System.out.println(" ");


                        System.out.println( "--------------  Menú de opciones  --------------" );
                        System.out.println("Escriba 1 si quieres sacar PIEDRA");
                        System.out.println("Escriba 2 si quieres sacar PAPEL");
                        System.out.println("Escriba 3 si quieres sacar TIJERA");
                        System.out.println("Escriba 4 si quieres sacar LAGARTO");
                        System.out.println("Escriba 5 si quieres sacar SPOK");
                        System.out.println("Escribe que quieres jugar:");

                        try {


                            opc2 = keyboard.nextInt();
                            ok = true;

                        } catch (Exception e) {


                            System.out.println("Dato no valido" );
                            ok = false;
                            keyboard.nextLine();

                        }

                        System.out.println(" ");

                    } while (!ok);

                    switch (opc2) {
                        case 1:
                            System.out.println("Has sacado PIEDRA.");
                            break;
                        case 2:
                            System.out.println("Has sacado PAPEL.");
                            break;
                        case 3:
                            System.out.println("Has sacado TIJERA.");
                            break;
                        case 4:
                            System.out.println("Has sacado LAGARTO.");
                            break;
                        case 5:
                            System.out.println("Has sacado SPOK.");
                            break;

                    }

                    System.out.println(" ");

                    /*Se le da un valor random a ia y luego comparamos en un if los valores de ia y opc2
                     * Si se gana o se pierde aumenta un contador para las estadisticas
                     * si se gana o se pierde, se cuanta que se gana/pierde una ronda y una partida*/
                    ia = rnd.nextInt(1, 6);


                    switch (ia) {
                        case 1:
                            System.out.println("La IA ha sacado PIEDRA.");
                            break;
                        case 2:
                            System.out.println("La IA ha sacado PAPEL.");
                            break;
                        case 3:
                            System.out.println("La IA ha sacado TIJERA.");
                            break;
                        case 4:
                            System.out.println("La IA ha sacado LAGARTO.");
                            break;
                        case 5:
                            System.out.println("La IA ha sacado SPOK.");
                            break;

                    }

                    System.out.println(" ");

                    if (opc2 == ia) {

                        System.out.println("EMPATE: habeis sacado la misma mano.");
                        emp++;
                        total++;

                    } else if (opc2 == 1 && ia == 2) {

                        System.out.println("HAS PERDIDO: El papel de tu rival cubre tu piedra.");
                        lose++;
                        iawin++;

                    } else if (opc2 == 1 && ia == 3) {

                        System.out.println("HAS GANADO: Tu piedra aplasta la tijera de tu rival.");
                        win++;
                        userwin++;

                    } else if (opc2 == 1 && ia == 4) {

                        System.out.println("HAS GANADO: Tu piedra aplasta al lagarto de tu rival.");
                        win++;
                        userwin++;

                    } else if (opc2 == 1 && ia == 5) {

                        System.out.println("HAS PERDIDO: El Spok rival ha vaporizado tu piedra.");
                        lose++;
                        iawin++;

                    } else if (opc2 == 2 && ia == 1) {

                        System.out.println("HAS GANADO: Tu papel cubre la piedra del rival.");
                        win++;
                        userwin++;

                    } else if (opc2 == 2 && ia == 3) {

                        System.out.println("HAS PERDIDO: Las tijeras de tu rival han cortado tu papel.");
                        lose++;
                        iawin++;

                    } else if (opc2 == 2 && ia == 4) {

                        System.out.println("HAS PERDIDO: El lagarto de tu rival se come tu papel.");
                        lose++;
                        iawin++;

                    } else if (opc2 == 2 && ia == 5) {

                        System.out.println("HAS GANADO: Tu papel ha desautorizado al Spok rival.");
                        win++;
                        userwin++;

                    } else if (opc2 == 3 && ia == 1) {

                        System.out.println("HAS PERDIDO: Tu tijera ha sido aplastada por la piedra del rival.");
                        lose++;
                        iawin++;

                    } else if (opc2 == 3 && ia == 2) {

                        System.out.println("HAS GANADO: Tus tijeras han cortado el papel rival.");
                        win++;
                        userwin++;

                    } else if (opc2 == 3 && ia == 4) {

                        System.out.println("HAS GANADO: Tus tijeras han decapitado al lagarto rival.");
                        win++;
                        userwin++;

                    } else if (opc2 == 3 && ia == 5) {

                        System.out.println("HAS PERDIDO: Tus tijeras han sido destrozadas por Spok.");
                        lose++;
                        iawin++;

                    } else if (opc2 == 4 && ia == 1) {

                        System.out.println("HAS PERDIDO: Tu lagarto ha sido aplastado por la piedra rival.");
                        lose++;
                        iawin++;

                    } else if (opc2 == 4 && ia == 2) {

                        System.out.println("HAS GANADO: Tu lagarto se ha comido el papel rival.");
                        win++;
                        userwin++;

                    } else if (opc2 == 4 && ia == 3) {

                        System.out.println("HAS GANADO: Tu lagarto ha sido decapitado por la tijera del rival.");
                        win++;
                        userwin++;

                    } else if (opc2 == 4 && ia == 5) {

                        System.out.println("HAS GANADO: Tu lagarto ha envenenado al Spok rival.");
                        win++;
                        userwin++;

                    } else if (opc2 == 5 && ia == 1) {

                        System.out.println("HAS GANADO: Tu Spok ha desintegrado la piedra  rival.");
                        win++;
                        userwin++;

                    } else if (opc2 == 5 && ia == 2) {

                        System.out.println("HAS PERDIDO: Tu Spok ha sido desautorizado por el papel rival.");
                        lose++;
                        iawin++;

                    } else if (opc2 == 5 && ia == 3) {

                        System.out.println("HAS GANADO: Tu Spok ha destruido la tijera del rival.");
                        win++;
                        userwin++;

                    } else if (opc2 == 5 && ia == 4) {

                        System.out.println("HAS PERDIDO: Tu Spok ha sido envenedado por el lagarto del rival.");
                        lose++;
                        iawin++;

                    }

                    System.out.println(" ");

                    total++;
                    round++;

                }



                case 2->{

                    /*Mejor de 5*/
                    bo5user = 0;
                    bo5ia = 0;

                    /*También hay que saber que hay contadores de rondas y de partidas, es decir
                     * si ganas una ronda del mejor de 5 se suma al contador de rondas, pero si ganas una partida se suma al contador de partidas*/

                    for (int i = 1; i <= 5; i++) {


                        do {

                            System.out.println(" ");
                            System.out.printf("\nEl jugador ha ganado %d rondas y la ia ha ganado %d\n", bo5user, bo5ia);

                            System.out.println("--------------  Menú de opciones  --------------");
                            System.out.println("Escriba 1 si quieres sacar PIEDRA");
                            System.out.println("Escriba 2 si quieres sacar PAPEL");
                            System.out.println("Escriba 3 si quieres sacar TIJERA");
                            System.out.println("Escriba 4 si quieres sacar LAGARTO");
                            System.out.println("Escriba 5 si quieres sacar SPOK");
                            System.out.println("Escribe que quieres jugar:");

                            try {


                                opc2 = keyboard.nextInt();
                                ok = true;

                            } catch (Exception e) {


                                System.out.println("Dato no valido");
                                ok = false;
                                keyboard.nextLine();

                            }

                        } while (!ok);

                        switch (opc2) {
                            case 1:
                                System.out.println("Has sacado PIEDRA.");
                                break;
                            case 2:
                                System.out.println("Has sacado PAPEL.");
                                break;
                            case 3:
                                System.out.println("Has sacado TIJERA.");
                                break;
                            case 4:
                                System.out.println("Has sacado LAGARTO.");
                                break;
                            case 5:
                                System.out.println("Has sacado SPOK.");
                                break;

                        }

                        System.out.println(" ");


                        ia = rnd.nextInt(1, 6);

                        switch (ia) {
                            case 1:
                                System.out.println("La IA ha sacado PIEDRA.");
                                break;
                            case 2:
                                System.out.println("La IA ha sacado PAPEL.");
                                break;
                            case 3:
                                System.out.println("La IA ha sacado TIJERA.");
                                break;
                            case 4:
                                System.out.println("La IA ha sacado LAGARTO.");
                                break;
                            case 5:
                                System.out.println("La IA ha sacado SPOK.");
                                break;

                        }

                        System.out.println(" ");


                        if (opc2 == ia) {

                            System.out.println("EMPATE: habeis sacado la misma mano.");
                            emp++;


                        } else if (opc2 == 1 && ia == 2) {

                            System.out.println("HAS PERDIDO: El papel de tu rival cubre tu piedra.");
                            iawin++;
                            bo5ia++;


                        } else if (opc2 == 1 && ia == 3) {

                            System.out.println("HAS GANADO: Tu piedra aplasta la tijera de tu rival.");
                            userwin++;
                            bo5user++;


                        } else if (opc2 == 1 && ia == 4) {

                            System.out.println("HAS GANADO: Tu piedra aplasta al lagarto de tu rival.");
                            userwin++;
                            bo5user++;


                        } else if (opc2 == 1 && ia == 5) {

                            System.out.println("HAS PERDIDO: El Spok rival ha vaporizado tu piedra.");
                            iawin++;
                            bo5ia++;


                        } else if (opc2 == 2 && ia == 1) {

                            System.out.println("HAS GANADO: Tu papel cubre la piedra del rival.");
                            userwin++;
                            bo5user++;


                        } else if (opc2 == 2 && ia == 3) {

                            System.out.println("HAS PERDIDO: Las tijeras de tu rival han cortado tu papel.");
                            iawin++;
                            bo5ia++;


                        } else if (opc2 == 2 && ia == 4) {

                            System.out.println("HAS PERDIDO: El lagarto de tu rival se come tu papel.");
                            iawin++;
                            bo5ia++;


                        } else if (opc2 == 2 && ia == 5) {

                            System.out.println("HAS GANADO: Tu papel ha desautorizado al Spok rival.");
                            userwin++;
                            bo5user++;


                        } else if (opc2 == 3 && ia == 1) {

                            System.out.println("HAS PERDIDO: Tu tijera ha sido aplastada por la piedra del rival.");
                            iawin++;
                            bo5ia++;


                        } else if (opc2 == 3 && ia == 2) {

                            System.out.println("HAS GANADO: Tus tijeras han cortado el papel rival.");
                            userwin++;
                            bo5user++;


                        } else if (opc2 == 3 && ia == 4) {

                            System.out.println("HAS GANADO: Tus tijeras han decapitado al lagarto rival.");
                            userwin++;
                            bo5user++;


                        } else if (opc2 == 3 && ia == 5) {

                            System.out.println("HAS PERDIDO: Tus tijeras han sido destrozadas por Spok.");
                            iawin++;
                            bo5ia++;


                        } else if (opc2 == 4 && ia == 1) {

                            System.out.println("HAS PERDIDO: Tu lagarto ha sido aplastado por la piedra rival.");
                            iawin++;
                            bo5ia++;


                        } else if (opc2 == 4 && ia == 2) {

                            System.out.println("HAS GANADO: Tu lagarto se ha comido el papel rival.");
                            userwin++;
                            bo5user++;


                        } else if (opc2 == 4 && ia == 3) {

                            System.out.println("HAS GANADO: Tu lagarto ha sido decapitado por la tijera del rival.");
                            userwin++;
                            bo5user++;


                        } else if (opc2 == 4 && ia == 5) {

                            System.out.println("HAS GANADO: Tu lagarto ha envenenado al Spok rival.");
                            userwin++;
                            bo5user++;


                        } else if (opc2 == 5 && ia == 1) {

                            System.out.println("HAS GANADO: Tu Spok ha desintegrado la piedra  rival.");
                            userwin++;
                            bo5user++;


                        } else if (opc2 == 5 && ia == 2) {

                            System.out.println("HAS PERDIDO: Tu Spok ha sido desautorizado por el papel rival.");
                            iawin++;
                            bo5ia++;


                        } else if (opc2 == 5 && ia == 3) {

                            System.out.println("HAS GANADO: Tu Spok ha destruido la tijera del rival.");
                            userwin++;
                            bo5user++;


                        } else if (opc2 == 5 && ia == 4) {

                            System.out.println("HAS PERDIDO: Tu Spok ha sido envenedado por el lagarto del rival.");
                            iawin++;
                            bo5ia++;


                        }

                        System.out.println(" ");

                        round++;


                        if (bo5user == 3 || bo5ia == 3) {

                            i = 5;


                        }

                        if (bo5user == 2 && bo5ia == 2) {

                            i--;
                            System.out.println("Ronda de desempate.");

                        }


                    }


                    System.out.println(" ");

                    if (bo5user == 3) {

                        System.out.println("HAS GANADO AL MEJOR DE 5 :)");
                        win++;

                    } else {

                        System.out.println("HAS PERDIDO AL MEJOR DE 5 :(");
                        lose++;

                    }
                    total++;

                    System.out.println(" ");


                }



                case 3->{

                    /*Estadisticas*/
                    /*El porcentaje tendría que ser el número de rondas ganadas entre el número total de rondas *100*/
                    ganar = userwin;
                    totales = round;

                    percent = ((ganar / totales) * 100);
                    System.out.printf("\nHas ganado %d partidas\n", win);
                    System.out.printf("\nHas perdido %d partidas\n", lose);
                    System.out.printf("\nHas jugado un total de %d partidas\n", total);
                    System.out.printf("\nHas ganado %d rondas\n", userwin);
                    System.out.printf("\nHas perdido %d rondas\n", iawin);
                    System.out.printf("\nHas empatado %d rondas\n", emp);
                    System.out.printf("\nHas jugado un total de %d rondas\n", round);
                    System.out.printf("\nTu porcentaje de aciertos es del %2f", percent);
                    System.out.println("%");
                    System.out.println();


                }



                case 0->{
                    /*Salir*/
                    System.out.println("Has salido del programa.");
                    cont = 1;}



                default->{System.out.println("No has introducido una opción valida.");}



            }

        }


    }


}
