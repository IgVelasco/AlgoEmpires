import org.junit.Test;
import espacio.Mapa;

import static org.junit.Assert.assertEquals;

public class MapaTest {

    @Test
    public void testMapaSeCreaCorrectamente() {
        Mapa map = new Mapa(5,5);

        assertEquals(25, map.getCantCeldas());

    }
}
