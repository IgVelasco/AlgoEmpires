import modelo.estructuras.Cuartel;
import modelo.excepciones.OroInsuficiente;
import modelo.excepciones.PoblacionLimiteAlcanzada;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CuartelTest {

    @Test
    public void testCuartelSeCreaCon250DeVida() {
        Cuartel unCuartel = new Cuartel(null);

        assertEquals(250, unCuartel.getVida());
    }

    @Test(expected = OroInsuficiente.class)
    public void testNoCrearEspadachinSinOroSuficiente() {
        Cuartel unCuartel = new Cuartel(null);

        unCuartel.crearEspadachin(25, null);

    }

    @Test(expected = OroInsuficiente.class)
    public void testNoCrearArqueroSinOroSuficiente() {
        Cuartel unCuartel = new Cuartel(null);

        unCuartel.crearArquero(25, null);
    }
}
