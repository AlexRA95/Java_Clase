import java.util.Scanner;

public class funciones1 {

    static void entreNum(int start, int end) {

        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }

    }

    public static void main(String[] args) {

        Scanner key = new Scanner(System.in);
        int a, b;

        System.out.println("Introduce el numero de inicio: ");
        a = key.nextInt();

        System.out.println("Introduce el numero final: ");
        b = key.nextInt();

        entreNum(a, b);

    }

}
