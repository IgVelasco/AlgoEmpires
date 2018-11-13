import Excepciones.CasilleroOcupado;
import contenibles.Contenible;
import org.junit.Test;
import espacio.Mapa;
import unidades.Aldeano;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MapaTest {

    @Test
    public void testMapaSeCreaCorrectamente() {
        Mapa map = new Mapa(5,5);

        assertEquals(25, map.getCantCeldas());

    }

    @Test
    public void testPreguntarContenidoEnUbicacionVaciaDevuelveNada() {
        Mapa mapa = new Mapa(5, 5);

        assertNull(mapa.getContenido(4, 4));
    }

    @Test
    public void testSePuedeColocarUnidadEnPosicionEspecifica() throws CasilleroOcupado {
        Mapa mapa = new Mapa(5, 5);
        Contenible aldeano = new Aldeano();

        mapa.colocarUnidadEn(aldeano, 3, 3);

        assertEquals(aldeano, mapa.getContenido(3, 3));
    }

    @Test
    public void testAlEliminarContenidoDeUnaPosicionSeLibera() throws CasilleroOcupado {
        Mapa mapa = new Mapa(5, 5);
        Contenible aldeano = new Aldeano();

        mapa.colocarUnidadEn(aldeano, 4, 4);
        mapa.liberarUbicacion(4, 4);

        assertNull(mapa.getContenido(4, 4));
    }

}

