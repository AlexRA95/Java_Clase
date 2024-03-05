package doblesPrueba;

import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PrestamoTest {

    private Persona personaMockito;

    public PrestamoTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        personaMockito = mock(Persona.class);
        when(personaMockito.esMayor18()).thenReturn(true);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of esPersonaValida method, of class Prestamo.
     */
    @Test
    public void testEsPersonaValida() {
        System.out.println("esPersonaValida");
        Prestamo instance = new Prestamo();
        boolean expResult = true;
        boolean result = instance.esPersonaValida(personaMockito);
        assertEquals(expResult, result);
        // verify(personaMockito).esMayor18();
        //verify(personaMockito).getNombre();
// la siguiente línea verifica cuántas veces se hace una llamada
        //verify(personaMockito, times(1)).esMayor18();
// la siguiente línea verifica que nunca se ha llamado al método
        //verify(personaMockito, never()).getNombre();
// la siguiente línea verifica que al menos se ha llamado una vez al método
        //verify(personaMockito, atLeastOnce()).esMayor18();
// la siguiente línea verifica al menos se ha llamado dos veces al método
        //verify(personaMockito, atLeast(2)).esMayor18();
    } // testEsPersonaValida
}