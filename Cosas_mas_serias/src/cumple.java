public class cumple {

    public static void main(String[] args) {


        int edad = 10;
        double money = 10;
        double total= 0;

        do {
            total +=  money;
            money *=1.5 ;
            edad++;

            System.out.printf("\nCon %d años me da %.2f pst\n",edad,money);



        }while ( money<166365 );

        System.out.printf("\nEl total es %f",total);
        System.out.println("\nQue en euros son "+(float)(total/166.368)+" € ");


    }

}
