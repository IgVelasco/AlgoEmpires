import Excepciones.OroInsuficiente;
import estructuras.Cuartel;
import org.junit.Test;
import contenibles.Contenible;
import unidades.*;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CuartelTest {

    @Test
    public void testCuartelSeCreaCon250DeVida() {
        Cuartel unCuartel = new Cuartel(null);

        assertEquals(250, unCuartel.getVida());
    }

    @Test
    public void testCrearEspadachinCreaUnaUnidadDelTipoEspadachin() throws OroInsuficiente {
        Cuartel unCuartel = new Cuartel(null);

        Contenible unaUnidad = unCuartel.crearEspadachin(50);

        assertThat(unaUnidad, instanceOf(Espadachin.class));
    }

    @Test
    public void testCrearArqueroCreaUnaUnidadDelTipoArquero() throws OroInsuficiente {
        Cuartel unCuartel = new Cuartel(null);

        Contenible unaUnidad = unCuartel.crearArquero(75);

        assertThat(unaUnidad, instanceOf(Arquero.class));
    }

    @Test(expected = OroInsuficiente.class)
    public void testNoCrearEspadachinSinOroSuficiente() throws OroInsuficiente {
        Cuartel unCuartel = new Cuartel(null);

        unCuartel.crearEspadachin(25);

    }

    @Test(expected = OroInsuficiente.class)
    public void testNoCrearArqueroSinOroSuficiente() throws OroInsuficiente {
        Cuartel unCuartel = new Cuartel(null);

        unCuartel.crearArquero(25);
    }
}
