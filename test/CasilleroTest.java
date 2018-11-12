import contenibles.Contenible;
import espacio.Casillero;
import unidades.Aldeano;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class CasilleroTest {

    @Test
    public void testCasilleroSeCreaSinContenido(){
        Casillero unCasillero = new Casillero();
        assertFalse(unCasillero.casilleroEstaOcupado() );


    }

    @Test
    public void testCasilleroPuedeContenerUnaUnidadContenible(){
        Contenible unAldeano = new Aldeano();
        Casillero unCasillero = new Casillero();

        unCasillero.contener(unAldeano);

        assertTrue(unCasillero.casilleroEstaOcupado());
        assertEquals( unAldeano, unCasillero.getContenido());


    }
}
