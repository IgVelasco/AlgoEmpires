import contenibles.Contenible;
import estructuras.PlazaCentral;
import org.junit.Test;
import unidades.Aldeano;
import unidades.Espadachin;

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
    public void testCrearAldeanoDevuelveUnaUnidadDeClaseAldeano(){
        PlazaCentral unaPlaza = new PlazaCentral();

        Contenible unaUnidad = unaPlaza.crearAldeano();

        assertThat(unaUnidad, instanceOf(Aldeano.class));
    }
}
