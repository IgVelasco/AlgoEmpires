import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArqueroTest {

    @Test
    public void testArqueroSeCreaCon75DeVida() {
        Arquero unArquero = new Arquero();

        assertEquals(75, unArquero.getVida());
    }

}
