import java.util.Random;

public class pez {

    public static void main(String[] args) {

        Random ran = new Random();


        int contalto=1,contancho,altopez,anchopez;


        altopez = ran.nextInt(2,4);
        anchopez = ran.nextInt(2,5);




        System.out.printf("\nEl pez esta en la altura %d y en el ancho %d\n",altopez,anchopez);

       for (int i = 1; i <=5 ; i++){
           contancho=1;
            if (i==1 || i==5){
                /*Arriba abajo*/
                for (int a=1; a<=6; a++){
                System.out.print(" * ");
                }
            }else {

                for (int b=1; b<=6;b++){

                    if (b==1 || b==6){
                        /*Bordes*/
                        System.out.print(" * ");

                    } else if (altopez==contalto && anchopez==contancho) {

                        System.out.print(" X ");

                    } else {

                        System.out.print("   ");

                    }
                    contancho++;
                }
                    contalto++;
            }


           System.out.println();

       }



    }


}
