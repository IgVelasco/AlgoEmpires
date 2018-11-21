import Excepciones.OroInsuficiente;
import Excepciones.PoblacionLimiteAlcanzada;
import estructuras.Cuartel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CuartelTest {

    @Test
    public void testCuartelSeCreaCon250DeVida() {
        Cuartel unCuartel = new Cuartel(null);

        assertEquals(250, unCuartel.getVida());
    }

    @Test(expected = OroInsuficiente.class)
    public void testNoCrearEspadachinSinOroSuficiente() throws OroInsuficiente, PoblacionLimiteAlcanzada {
        Cuartel unCuartel = new Cuartel(null);

        unCuartel.crearEspadachin(25);

    }

    @Test(expected = OroInsuficiente.class)
    public void testNoCrearArqueroSinOroSuficiente() throws OroInsuficiente, PoblacionLimiteAlcanzada {
        Cuartel unCuartel = new Cuartel(null);

        unCuartel.crearArquero(25);
    }
}
