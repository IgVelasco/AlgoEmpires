import estructuras.Cuartel;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CuartelTest {

    @Test
    public void testCuartelSeCreaCon250DeVida() {
        Cuartel unCuartel = new Cuartel();

        assertEquals(250, unCuartel.getVida());
    }
}
