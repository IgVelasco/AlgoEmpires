import Excepciones.OroInsuficiente;
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
        PlazaCentral plaza = new PlazaCentral();

        assertEquals(450, plaza.getVida());
    }

    @Test
    public void testCrearAldeanoDevuelveUnaUnidadDeClaseAldeano() throws OroInsuficiente {
        PlazaCentral unaPlaza = new PlazaCentral();

        Contenible unaUnidad = unaPlaza.crearAldeano(25);

        assertThat(unaUnidad, instanceOf(Aldeano.class));
    }

    @Test(expected = OroInsuficiente.class)
    public void testNoCrearAldeanoSinOroSuficiente() throws OroInsuficiente {
        PlazaCentral unaPlaza = new PlazaCentral();

        unaPlaza.crearAldeano(10);
    }
}
