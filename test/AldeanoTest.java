import unidades.Aldeano;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AldeanoTest {

    @Test
    public void testAldeanoSeCreaCon50DeVida() {
        Aldeano unAldeano = new Aldeano();

        assertEquals(50, unAldeano.getVida());
    }

}