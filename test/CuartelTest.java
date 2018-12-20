import modelo.espacio.Posicion;
import modelo.estructuras.Cuartel;
import modelo.excepciones.OroInsuficiente;
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
        Posicion posicionCuartel = new Posicion(10,10);
        Posicion posicionEspadachin = new Posicion(11,11);

        Cuartel unCuartel = new Cuartel(null);
        unCuartel.agregarPosicion(posicionCuartel);

        unCuartel.crearEspadachin(25, null, posicionEspadachin);

    }

    @Test(expected = OroInsuficiente.class)
    public void testNoCrearArqueroSinOroSuficiente() {
        Posicion posicionCuartel = new Posicion(10,10);
        Posicion posicionArquero = new Posicion(11,11);

        Cuartel unCuartel = new Cuartel(null);
        unCuartel.agregarPosicion(posicionCuartel);

        unCuartel.crearArquero(25, null, posicionArquero);
    }
}
