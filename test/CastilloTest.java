import estructuras.Castillo;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CastilloTest{

    @Test
    public void testCastilloSeCreaCon1000DeVida() {
        Castillo unCastillo = new Castillo();

        assertEquals(1000, unCastillo.getVida());
    }
}