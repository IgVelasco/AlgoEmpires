import excepciones.CasilleroOcupado;
import contenibles.Contenible;
import espacio.Casillero;
import unidades.Aldeano;
import org.junit.Test;

import static org.junit.Assert.*;


public class CasilleroTest {

    @Test
    public void testCasilleroSeCreaSinContenido(){
        Casillero unCasillero = new Casillero();
        assertFalse(unCasillero.casilleroEstaOcupado() );


    }

    @Test
    public void testCasilleroPuedeContenerUnaUnidadContenible() throws CasilleroOcupado {
        Contenible unAldeano = new Aldeano();
        Casillero unCasillero = new Casillero();

        unCasillero.contener(unAldeano);

        assertTrue(unCasillero.casilleroEstaOcupado());
        assertEquals( unAldeano, unCasillero.getContenido());


    }

    @Test
    public void testCasilleroQuedaLibreLuegoDeLiberarlo() throws CasilleroOcupado {
        Contenible unAldeano = new Aldeano();
        Casillero unCasillero = new Casillero();

        unCasillero.contener(unAldeano);

        unCasillero.liberar();

        assertFalse(unCasillero.casilleroEstaOcupado());
        assertNull(unCasillero.getContenido());
    }

    @Test(expected = CasilleroOcupado.class)
    public void testCasilleroLanzaExcepcionSiSeIntentaContenerMientrasEstaOcupado() throws CasilleroOcupado {
        Contenible unAldeano = new Aldeano();
        Casillero unCasillero = new Casillero();
        unCasillero.contener(unAldeano);

        Contenible otroAldeano = new Aldeano();
        unCasillero.contener(otroAldeano);

    }
}
