package delorean;

import java.util.Scanner;

public class principal {

    public static void main(String[] args) {
        Coche c= new Coche("123456cgb");

        c.starStop();
        c.reparar();
        c.starStop();
        c.starStop();
        c.elevalunas();
        c.starStop();
        c.elevalunas();
        c.elevalunas(2);
    }

}
