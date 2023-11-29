public class prueba_tablero {


    public static void main(String[] args) {

            Character[][] tablero;
            Character m= 65;
            tablero =new Character[10][10];

        for (int i = 0; i < tablero.length ; i++) {
            if ( i==0 ){
                System.out.print(" ");
                for (int k = 1; k < tablero[i].length+1 ; k++) {
                    System.out.print(" " + k +" ");
                }
                System.out.println(" ");
            }
            for (int j = 0; j <tablero[i].length ; j++) {
                if (j==0){

                    System.out.print("" + m + "" );
                    m++;
                }
                tablero[i][j]='-';
                System.out.printf(" %c ",tablero[i][j]);
            }
            System.out.println(" ");
        }

    }

}
