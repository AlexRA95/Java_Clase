package Prueba;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class prueba2 {
    public static void main(String[] args) {

        HashMap<String, Integer> lista=new HashMap<>();
        LocalDateTime dia=LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        lista.put("Ey",1);
        lista.put("lel",1);
        lista.put("Ey",2);

        for (String s: lista.keySet()){
            System.out.println(s + ", " + lista.get(s));
        }

        String fecha=formato.format(dia);

        System.out.println(fecha);


    }
}
