import modelo.espacio.Contenible;
import modelo.espacio.Mapa;
import modelo.excepciones.*;
import modelo.juego.Jugador;
import modelo.unidades.Aldeano;
import modelo.unidades.Arquero;
import modelo.unidades.Espadachin;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class JugadorTest {

    @Test
    public void testCrearJugadorColocaEstructuras() {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 20 / 2, 0, null);

        assert (mapa.casillerosEstanOcupados(20 / 2, 0, 4,1));
        assert (mapa.casillerosEstanOcupados(8, 0, 2,1));
    }

    @Test
    public void testCrearJugadorColocaUnidades() {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 20 / 2, 0, null);

        assert (mapa.casillerosEstanOcupados(7, 0, 1,1));
        assert (mapa.casillerosEstanOcupados(7, 1, 1,1));
        assert (mapa.casillerosEstanOcupados(7, 2, 1,1));
    }


    @Test
    public void testJugadorTurnoDaOroCorrecto() {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 20 / 2, 0, null);
        unJugador.nuevoTurno();

        assertEquals(160, unJugador.getOro());
    }


    @Test
    public void testJugadorTurnoDaOroCorrectoAlAgregarAldeano() {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 20 / 2, 0, null);
        unJugador.nuevoTurno();

        assertEquals(160, unJugador.getOro());
    }

    @Test
    public void testMatarUnidadLiberaUbicacion() {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 20/2, 0, null);
        Aldeano unAldeano = new Aldeano(unJugador);

        mapa.colocarUnidadEn(unAldeano, 10, 10);

        unAldeano.ataqueDeEspadachin();
        unAldeano.ataqueDeEspadachin();

        assertNull(mapa.getContenido(10, 10));
    }

    @Test
    public void testMatarUnidadDisminuyeLaPoblacion() {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 20/2, 0, null);
        Aldeano unAldeano = new Aldeano(unJugador);

        unJugador.aumentarPoblacion();
        mapa.colocarUnidadEn(unAldeano, 10, 10);

        assertEquals(4, unJugador.getPoblacionActual());


        unAldeano.ataqueDeEspadachin();
        unAldeano.ataqueDeEspadachin();

        assertEquals(3, unJugador.getPoblacionActual());

    }

    @Test (expected = PoblacionLimiteAlcanzada.class)
    public void testPoblacionMayorACincuentaTiraError() {
        Mapa mapa = new Mapa (20, 20);
        Jugador unJugador = new Jugador(mapa, 20/2, 0,null);

        for (int i = 0; i < 48; i++) {
            unJugador.aumentarPoblacion();
        }
    }

    @Test
    public void testDisminuirPoblacionCuandoNoHayTiraError() {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 20/2, 0, null);

        for (int i = 0; i < 4; i++)
            unJugador.disminuirPoblacion();


        assertEquals(0,unJugador.getPoblacionActual());
    }

}