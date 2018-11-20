import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import Excepciones.UnidadYaUtilizada;
import espacio.Mapa;
import unidades.Aldeano;
import unidades.ArmaDeAsedio;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArmaDeAsedioTest {

    @Test
    public void testArmaDeAsedioSeCreaCon150DeVida() {
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(null);

        assertEquals(150, unArmaDeAsedio.getVida());
    }
}
