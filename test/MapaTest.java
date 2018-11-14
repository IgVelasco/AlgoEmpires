import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import contenibles.Contenible;
import org.junit.Test;
import espacio.Mapa;
import unidades.Aldeano;
import unidades.Arquero;


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
    @Test
    public void testMoverUnidadALaDerechaValida() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10, 10);
        Contenible aldeano = new Aldeano();

        mapa.colocarUnidadEn(aldeano, 5, 5);
        mapa.moverDerecha(5,5);

        assertNull(mapa.getContenido(5,5));
        assertEquals(aldeano, mapa.getContenido(6,5));
    }

    @Test
    public void testMoverUnidadALaIzquierdaValida() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10, 10);
        Contenible aldeano = new Aldeano();

        mapa.colocarUnidadEn(aldeano, 5, 5);
        mapa.moverIzquierda(5, 5);

        assertNull(mapa.getContenido(5, 5));
        assertEquals(aldeano, mapa.getContenido(4, 5));
    }

    @Test
    public void testMoverUnidadArribaValido() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10, 10);
        Contenible aldeano = new Aldeano();

        mapa.colocarUnidadEn(aldeano, 5, 5);
        mapa.moverArriba(5, 5);

        assertNull(mapa.getContenido(5, 5));
        assertEquals(aldeano, mapa.getContenido(5, 6));
    }

    @Test
    public void testMoverUnidadAbajoValido() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10, 10);
        Contenible aldeano = new Aldeano();

        mapa.colocarUnidadEn(aldeano, 5, 5);
        mapa.moverAbajo(5, 5);

        assertNull(mapa.getContenido(5, 5));
        assertEquals(aldeano, mapa.getContenido(5, 4));
    }

    @Test
    public void testMoverUnidaDerechaSuperiorValido() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10, 10);
        Contenible aldeano = new Aldeano();

        mapa.colocarUnidadEn(aldeano, 5, 5);
        mapa.moverDerechaSuperior(5, 5);

        assertNull(mapa.getContenido(5, 5));
        assertEquals(aldeano, mapa.getContenido(6, 6));
    }

    @Test
    public void testMoverUnidadDerechaInferiorValido() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10, 10);
        Contenible aldeano = new Aldeano();

        mapa.colocarUnidadEn(aldeano, 5, 5);
        mapa.moverDerechaInferior(5, 5);

        assertNull(mapa.getContenido(5, 5));
        assertEquals(aldeano, mapa.getContenido(6, 4));
    }

    @Test
    public void testMoverUnidadIzquierdaSuperiorValido() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10, 10);
        Contenible aldeano = new Aldeano();

        mapa.colocarUnidadEn(aldeano, 5, 5);
        mapa.moverIzquierdaSuperior(5, 5);

        assertNull(mapa.getContenido(5, 5));
        assertEquals(aldeano, mapa.getContenido(4, 6));
    }

    @Test
    public void testMoverUnidadIzquierdaInferiorValido() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10, 10);
        Contenible aldeano = new Aldeano();

        mapa.colocarUnidadEn(aldeano, 5, 5);
        mapa.moverIzquierdaInferior(5, 5);

        assertNull(mapa.getContenido(5, 5));
        assertEquals(aldeano, mapa.getContenido(4, 4));
    }

    @Test(expected = ExcedeLimiteDelMapa.class)
    public void testMoverAfueraDelMapaLanzaExcedeLimiteDelMapaError() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(5,5);
        Contenible unArquero = new Arquero();

        mapa.colocarUnidadEn(unArquero,0,0);
        mapa.moverIzquierda(0,0);
    }
}
