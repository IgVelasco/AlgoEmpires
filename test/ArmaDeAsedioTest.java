import org.junit.Test;
import unidades.ArmaDeAsedio;

import static org.junit.Assert.assertEquals;

public class ArmaDeAsedioTest {

    @Test
    public void testArmaDeAsedioSeCreaCon150DeVida() {
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(null);

        assertEquals(150, unArmaDeAsedio.getVida());
    }
}
