import modelo.estructuras.PlazaCentral;
import modelo.excepciones.OroInsuficiente;
import modelo.excepciones.PoblacionLimiteAlcanzada;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlazaCentralTest {

    @Test
    public void testPlazaCentralSeCreaCon450DeVida() {
        PlazaCentral plaza = new PlazaCentral(null);

        assertEquals(450, plaza.getVida());
    }

    @Test(expected = OroInsuficiente.class)
    public void testNoCrearAldeanoSinOroSuficiente() {
        PlazaCentral unaPlaza = new PlazaCentral(null);

        unaPlaza.crearAldeano(10);
    }
}
