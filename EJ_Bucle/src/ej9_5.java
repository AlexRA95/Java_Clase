public class ej9_5 {

    public static void main(String[] args) {

        int num, num2;
        num = 7;
        num2=0;



        for (int i = 0; i <= 100; i++,num2=((num*i)) ) {


            System.out.printf("\nEl resultado de %d * %d es %d\n", num, i,num2);
        }

    }

}
