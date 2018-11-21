import Excepciones.OroInsuficiente;
import Excepciones.PoblacionLimiteAlcanzada;
import contenibles.Contenible;
import estructuras.PlazaCentral;
import org.junit.Test;
import unidades.Aldeano;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PlazaCentralTest{

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
