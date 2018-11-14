import contenibles.Contenible;
import espacio.Casillero;
import estructuras.Castillo;
import org.junit.Test;
import unidades.ArmaDeAsedio;
import unidades.Arquero;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CastilloTest{

    @Test
    public void testCastilloSeCreaCon1000DeVida() {
        Castillo unCastillo = new Castillo();

        assertEquals(1000, unCastillo.getVida());
    }

    @Test
    public void testCrearArmaDeAsedioDevuelveUnaUnidadDelTipoArmaDeAsedio(){
        Castillo unCastillo = new Castillo();
        Contenible unaUnidad = unCastillo.crearArmaDeAsedio();

        assertThat(unaUnidad, instanceOf(ArmaDeAsedio.class));
    }
}