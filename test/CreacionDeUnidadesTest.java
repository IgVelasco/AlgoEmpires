import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;


public class CreacionDeUnidadesTest {

    @Test
    public void AldeanoSeCreaCon50DeVida() {
        Aldeano unAldeano = new Aldeano();

        assertEquals(50, unAldeano.getVida());
    }

    @Test
    public void EspadachinSeCreaCon100DeVida() {
        Espadachin unEspadachin = new Espadachin();

        assertEquals(100, unEspadachin.getVida());
    }

    @Test
    public void ArqueroSeCreaCon75DeVida() {
        Arquero unArquero = new Arquero();

        assertEquals(75, unArquero.getVida());
    }

    @Test
    public void ArmaDeAsedioSeCreaCon150DeVida() {
        ArmaDeAsedio unArma = new ArmaDeAsedio();

        assertEquals(150, unArma.getVida());
    }
}
