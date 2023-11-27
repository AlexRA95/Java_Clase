import java.util.Random;

public class randomcosa {

    public static void main(String[] args) {


        Random generado = new Random();


        for (int i = 0; i < 10; i++) {
            int num = generado.nextInt(0, 10);
            System.out.println("Con random");
            System.out.println(num);

        }


        for (int i = 0; i < 10; i++) {
            System.out.println("Con math.random");

            System.out.println((int) (Math.random() * (5 + 1)));

        }


    }

}
