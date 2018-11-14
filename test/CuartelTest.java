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
        Cuartel unCuartel = new Cuartel();

        assertEquals(250, unCuartel.getVida());
    }

    @Test
    public void testCrearEspadachinCreaUnaUnidadDelTipoEspadachin(){
        Cuartel unCuartel = new Cuartel();

        Contenible unaUnidad = unCuartel.crearEspadachin();

        assertThat(unaUnidad, instanceOf(Espadachin.class));
    }

    @Test
    public void testCrearArqueroCreaUnaUnidadDelTipoArquero(){
        Cuartel unCuartel = new Cuartel();

        Contenible unaUnidad = unCuartel.crearArquero();

        assertThat(unaUnidad, instanceOf(Arquero.class));
    }
}
