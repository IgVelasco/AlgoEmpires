import Excepciones.CasilleroOcupado;
import contenibles.Contenible;
import espacio.Casillero;
import org.junit.Test;
import unidades.Aldeano;

import static org.junit.Assert.*;


public class CasilleroTest {

    @Test
    public void testCasilleroSeCreaSinContenido() {
        Casillero unCasillero = new Casillero();
        assertFalse(unCasillero.casilleroEstaOcupado());


    }

    @Test
    public void testCasilleroPuedeContenerUnaUnidadContenible() throws CasilleroOcupado {
        Contenible unAldeano = new Aldeano(null);
        Casillero unCasillero = new Casillero();

        unCasillero.contener(unAldeano);

        assertTrue(unCasillero.casilleroEstaOcupado());
        assertEquals(unAldeano, unCasillero.getContenido());


    }

    @Test
    public void testCasilleroQuedaLibreLuegoDeLiberarlo() throws CasilleroOcupado {
        Contenible unAldeano = new Aldeano(null);
        Casillero unCasillero = new Casillero();

        unCasillero.contener(unAldeano);

        unCasillero.liberar();

        assertFalse(unCasillero.casilleroEstaOcupado());
        assertNull(unCasillero.getContenido());
    }

    @Test(expected = CasilleroOcupado.class)
    public void testCasilleroLanzaExcepcionSiSeIntentaContenerMientrasEstaOcupado() throws CasilleroOcupado {
        Contenible unAldeano = new Aldeano(null);
        Casillero unCasillero = new Casillero();
        unCasillero.contener(unAldeano);

        Contenible otroAldeano = new Aldeano(null);
        unCasillero.contener(otroAldeano);

    }
}
