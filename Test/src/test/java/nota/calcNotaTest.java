package nota;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class calcNotaTest {
    private int bien;
    private int mal;
    private int blanco;
    private int resultadoExp;

    public calcNotaTest(int bien, int mal, int blanco, int resultadoExp) {
        this.bien = bien;
        this.mal = mal;
        this.blanco = blanco;
        this.resultadoExp = resultadoExp;
    }

    @Parameters
    public static Collection<Integer[]> obtenerParametros()
    {
        Collection<Integer[]> parametros = new ArrayList();
        parametros.add(new Integer[] {8,2,0,6});
        parametros.add(new Integer[] {9,4,8,-1});
        parametros.add(new Integer[] {11,8,4,-2});
        parametros.add(new Integer[] {4,17,2,-3});
        parametros.add(new Integer[] {6,7,87,-4});
        return parametros;
    }

    @Test
    public void testCalcularNota(){
        CalcNota c= new CalcNota();
        int resultadoObtenido= c.calcularNota(bien,mal,blanco);
        assertEquals("probando",this.resultadoExp,resultadoObtenido);
    }


}