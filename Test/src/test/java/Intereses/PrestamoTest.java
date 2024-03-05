package Intereses;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PrestamoTest {
    private CalcularInteres prueba;

    @Before
    public void setUp(){
        prueba = mock(CalcularInteres.class);
        when(prueba.calculoInteres(anyFloat(),anyInt())).thenReturn(1530.0f);
    }

    @Test
    public void calcularCuotaMes() {
        Prestamo p = new Prestamo();
        float capital=10000.0f;
        int tiempo=12;
        float expResul=960.0f;
        float resulObtenido=p.calcularCuotaMes(capital,tiempo,prueba);
        assertEquals(expResul,resulObtenido,1.0f);

    }


}