import estructuras.Castillo;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CastilloTest{

    @Test
    public void testCastilloSeCreaCon1000DeVida() {
        Castillo unCastillo = new Castillo();

        assertEquals(450, unCastillo.getVida());
    }
}