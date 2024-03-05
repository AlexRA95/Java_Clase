package contarLetras;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ContarLetrasTest {
    private String datoEntrada;
    private int resultado;

    public ContarLetrasTest(Datos a) {
        this.datoEntrada = a.getCadena();
        this.resultado = a.getResul();
    }

    @Parameters
    public static ArrayList<Datos> obtenerParametros(){

        ArrayList<Datos> lista=new ArrayList<>();
        lista.add(new Datos("hola",4));
        lista.add(new Datos("adios",5));
        lista.add(new Datos("asdfghjklñ",10));
        lista.add(new Datos("qazwsxed",8));
        return lista;
    }


    @Test
    public void name() {
        ContarLetras c=new ContarLetras();
        int resultadoObtenido =c.contando(datoEntrada);
        assertEquals("test",this.resultado,resultadoObtenido);
    }
}