import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class CreacionDeUnidadesTest {

    @Test
    public void testAldeanoSeCreaCon50DeVida() {
        Aldeano unAldeano = new Aldeano();

        assertEquals(50, unAldeano.getVida());
    }

    @Test
    public void testEspadachinSeCreaCon100DeVida() {
        Espadachin unEspadachin = new Espadachin();

        assertEquals(100, unEspadachin.getVida());
    }

    @Test
    public void testArqueroSeCreaCon75DeVida() {
        Arquero unArquero = new Arquero();

        assertEquals(75, unArquero.getVida());
    }

    @Test
    public void testArmaDeAsedioSeCreaCon150DeVida() {
        ArmaDeAsedio unArma = new ArmaDeAsedio();

        assertEquals(150, unArma.getVida());
    }
}
