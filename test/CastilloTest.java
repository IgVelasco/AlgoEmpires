import Excepciones.OroInsuficiente;
import contenibles.Contenible;
import estructuras.Castillo;
import org.junit.Test;
import unidades.ArmaDeAsedio;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CastilloTest {

    @Test
    public void testCastilloSeCreaCon1000DeVida() {
        Castillo unCastillo = new Castillo();

        assertEquals(1000, unCastillo.getVida());
    }

    @Test
    public void testCrearArmaDeAsedioDevuelveUnaUnidadDelTipoArmaDeAsedio() throws OroInsuficiente {
        Castillo unCastillo = new Castillo();
        Contenible unaUnidad = unCastillo.crearArmaDeAsedio(200);

        assertThat(unaUnidad, instanceOf(ArmaDeAsedio.class));
    }

    @Test(expected = OroInsuficiente.class)
    public void testNoCrearAldeanoSinOroSuficiente() throws OroInsuficiente {
        Castillo unCastillo = new Castillo();

        unCastillo.crearArmaDeAsedio(10);
    }
}