import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArmaDeAsedioTest {

    @Test
    public void testArmaDeAsedioSeCreaCon150DeVida() {
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio();

        assertEquals(150, unArmaDeAsedio.getVida());
    }

}
