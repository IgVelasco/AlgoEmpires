import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EspadachinTest {

    @Test
    public void testEspadachinSeCreaCon100DeVida() {
        Espadachin unEspadachin = new Espadachin();

        assertEquals(100, unEspadachin.getVida());
    }

}
