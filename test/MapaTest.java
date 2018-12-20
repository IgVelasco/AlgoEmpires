import modelo.espacio.Mapa;
import modelo.espacio.Posicion;
import modelo.estructuras.Castillo;
import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.ExcedeLimiteDelMapa;
import modelo.unidades.Aldeano;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MapaTest {

    @Test
    public void testMapaSeCreaCorrectamente() {
        Mapa map = new Mapa(5, 5);

        assertEquals(25, map.getCantCeldas());

    }

    @Test
    public void testPreguntarContenidoEnUbicacionVaciaDevuelveNada() {
        Mapa mapa = new Mapa(5, 5);

        assertNull(mapa.getContenido(4, 4));
    }

    @Test
    public void testSePuedeColocarUnidadEnPosicionEspecifica() {
        Mapa mapa = new Mapa(5, 5);

        Posicion posicionUnAldeano = new Posicion(0, 0);
        Aldeano aldeano = new Aldeano(null, posicionUnAldeano);


        mapa.colocarUnidadEn(aldeano, posicionUnAldeano);

        assertEquals(aldeano, mapa.getContenido(0, 0));
    }

    @Test
    public void testAlEliminarContenidoDeUnaPosicionSeLibera() {
        Mapa mapa = new Mapa(5, 5);
        Posicion posicionUnAldeano = new Posicion(4, 4);
        Aldeano aldeano = new Aldeano(null, posicionUnAldeano);


        mapa.colocarUnidadEn(aldeano, posicionUnAldeano);
        mapa.liberarUbicacion( new Posicion(4,4));

        assertNull(mapa.getContenido(4, 4));
    }


    @Test
    public void testSePuedeColocarEstructuraEnPosicionEspecifica() {
        Mapa mapa = new Mapa(20, 20);
        Castillo castillo = new Castillo(null);

        mapa.colocarEstructuraEn(castillo, 5, 5, 4,1);
        assertEquals(castillo, mapa.getContenido(8, 8));
        assertEquals(castillo, mapa.getContenido(7, 7));
        assertEquals(castillo, mapa.getContenido(6, 6));
        assertEquals(castillo, mapa.getContenido(5, 5));

        assertNull(mapa.getContenido(4, 4));
    }


    @Test(expected = ExcedeLimiteDelMapa.class)
    public void testConstruirAfueraDelMapaError() {
        Mapa mapa = new Mapa(5, 5);
        Castillo unCastillo = new Castillo(null);

        mapa.colocarEstructuraEn(unCastillo, -1, -1, 4,1);
    }


    @Test(expected = ExcedeLimiteDelMapa.class)
    public void testConstruirParteAfueraDelMapaError() {
        Mapa mapa = new Mapa(5, 5);
        Castillo unCastillo = new Castillo(null);

        mapa.colocarEstructuraEn(unCastillo, 3, 3, 4,1);
        assertNull(mapa.getContenido(3, 3));
        assertNull(mapa.getContenido(4, 3));
    }

    @Test(expected = CasilleroOcupado.class)
    public void testConstruirDosCastillosEnMismoLugar() {
        Mapa mapa = new Mapa(20, 20);
        Castillo unCastillo = new Castillo(null);
        Castillo otroCastillo = new Castillo(null);

        mapa.colocarEstructuraEn(unCastillo, 5, 5, 4,1);
        mapa.colocarEstructuraEn(otroCastillo, 5, 5, 4,1);

        assertEquals(unCastillo, mapa.getContenido(8, 8));
        assertEquals(unCastillo, mapa.getContenido(7, 7));
        assertEquals(unCastillo, mapa.getContenido(6, 6));
        assertEquals(unCastillo, mapa.getContenido(5, 5));
    }

    @Test(expected = ExcedeLimiteDelMapa.class)
    public void testPedirContenidoAfueraDelMapaError() {
        Mapa mapa = new Mapa(5, 5);

        mapa.getContenido(-1, -1);
    }

    @Test(expected = ExcedeLimiteDelMapa.class)
    public void testMoverUnidadAfueraDelMapaError() {
        Mapa mapa = new Mapa(5, 5);

        Posicion posicionUnAldeano = new Posicion(0, 0);
        Posicion posicionAMover = new Posicion(-1, -1);
        Aldeano aldeano = new Aldeano(null, posicionUnAldeano);

        mapa.colocarUnidadEn(aldeano, posicionUnAldeano);
        mapa.mover(0, 0, posicionAMover);
    }
}
