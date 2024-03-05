package Calculadora;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CalculadoraTest {

    int datoEntradaSuma1;
    int datoEntradaSuma2;
    int resultadoEspSuma;
    int datoEntradaResta1;
    int datoEntradaResta2;
    int resultadoEspResta;
    int datoEntradaMulti1;
    int datoEntradaMulti2;
    int resultadoEspMulti;
    int datoEntradaDiv1;
    int datoEntradaDiv2;
    int resultadoEspDiv;
    public CalculadoraTest(int sum1, int sum2, int resulSuma, int rest1, int rest2, int resulRest, int multi1, int multi2, int resulMulti, int div1, int div2, int resulDiv) {
        this.datoEntradaSuma1 = sum1;
        this.datoEntradaSuma2 = sum2;
        this.resultadoEspSuma = resulSuma;
        this.datoEntradaResta1 = rest1;
        this.datoEntradaResta2 = rest2;
        this.resultadoEspResta = resulRest;
        this.datoEntradaMulti1 = multi1;
        this.datoEntradaMulti2 = multi2;
        this.resultadoEspMulti = resulMulti;
        this.datoEntradaDiv1 = div1;
        this.datoEntradaDiv2 = div2;
        this.resultadoEspDiv = resulDiv;
    }

    @Parameters
    public static ArrayList<Integer[]> obtenerParametros() {

        ArrayList<Integer[]> parametros = new ArrayList();
        parametros.add(new Integer[]{1, 10, 11, 8, 5, 3, 2, 2, 4, 6, 3, 2});
        parametros.add(new Integer[]{8, 8, 16, 99, 9, 90, 10, 10, 100, 50, 2, 25});
        parametros.add(new Integer[]{4, 4, 8, 88, 2, 86, 4, 8, 32, 32, 4, 8});
        return parametros;

    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSuma() {
        Calculadora p = new Calculadora();
        int resultadoObtenido = p.suma(datoEntradaSuma1, datoEntradaSuma2);
        assertEquals("probando", this.resultadoEspSuma, resultadoObtenido);
    }

    /**
     * Test of restar method, of class Calculadora.
     */
    @Test
    public void testRestar() {
        Calculadora p = new Calculadora();
        int resultadoObtenido = p.restar(datoEntradaResta1, datoEntradaResta2);
        assertEquals("probando", this.resultadoEspResta, resultadoObtenido);
    }

    @Test
    public void testMulti() {
        Calculadora p = new Calculadora();
        int resultadoObtenido = p.multi(datoEntradaMulti1, datoEntradaMulti2);
        assertEquals("probando", this.resultadoEspMulti, resultadoObtenido);
    }

    @Test
    public void testDividir() {
        Calculadora p = new Calculadora();
        int resultadoObtenido = p.dividir(datoEntradaDiv1, datoEntradaDiv2);
        assertEquals("probando", this.resultadoEspDiv, resultadoObtenido);
    }
}