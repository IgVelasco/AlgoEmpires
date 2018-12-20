import modelo.espacio.Posicion;
import modelo.estructuras.PlazaCentral;
import modelo.excepciones.OroInsuficiente;
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
        Posicion posicionPlaza = new Posicion(3,3);
        Posicion posicionAldano = new Posicion(3,3);

        PlazaCentral unaPlaza = new PlazaCentral(null);
        unaPlaza.agregarPosicion(posicionPlaza);

        unaPlaza.crearAldeano(10, null, posicionAldano);
    }
}
