import java.util.Scanner;
public class ej10 {




    public static void main(String[] args) {

        int num = 0, num2, num3;
        num2 = 0;
        Scanner keyboard = new Scanner(System.in);


        int i;
        for (i = 0; i <= 10; i++) {

            try {

                System.out.println("Pon un numero:");

                num = keyboard.nextInt();
                
            }catch (Exception e){

                System.out.println("Valor incorrecto");
                keyboard.nextLine();

                i--;
                
            }
            
            

            num2 = ((num2 + num));

        }

        num3 = ((num2 / i));

        System.out.printf("La media es %d",num3);


    }

}
