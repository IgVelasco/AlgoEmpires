import Excepciones.OroInsuficiente;
import Excepciones.PoblacionLimiteAlcanzada;
import estructuras.PlazaCentral;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlazaCentralTest {

    @Test
    public void testPlazaCentralSeCreaCon450DeVida() {
        PlazaCentral plaza = new PlazaCentral(null);

        assertEquals(450, plaza.getVida());
    }

    @Test(expected = OroInsuficiente.class)
    public void testNoCrearAldeanoSinOroSuficiente() throws OroInsuficiente, PoblacionLimiteAlcanzada {
        PlazaCentral unaPlaza = new PlazaCentral(null);

        unaPlaza.crearAldeano(10);
    }
}
