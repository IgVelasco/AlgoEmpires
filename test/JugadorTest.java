import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import Excepciones.PoblacionLimiteAlcanzada;
import espacio.Mapa;
import juego.Jugador;
import org.junit.Test;
import unidades.Aldeano;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class JugadorTest {

    @Test
    public void testCrearJugadorColocaEstructuras() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 20 / 2, 0, null);

        assert (mapa.casillerosEstanOcupados(20 / 2, 0, 4));
        assert (mapa.casillerosEstanOcupados(8, 0, 2));
    }

    @Test
    public void testCrearJugadorColocaUnidades() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 20 / 2, 0, null);

        assert (mapa.casillerosEstanOcupados(7, 0, 1));
        assert (mapa.casillerosEstanOcupados(7, 1, 1));
        assert (mapa.casillerosEstanOcupados(7, 2, 1));
    }


    @Test
    public void testJugadorTurnoDaOroCorrecto() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 20 / 2, 0, null);
        unJugador.nuevoTurno();

        assertEquals(160, unJugador.getOro());
    }

    @Test
    public void testMatarUnidadLiberaUbicacion() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 20/2, 0, null);
        Aldeano unAldeano = new Aldeano(unJugador);

        mapa.colocarUnidadEn(unAldeano, 10, 10);

        unAldeano.ataqueDeEspadachin();
        unAldeano.ataqueDeEspadachin();

        assertEquals(null, mapa.getContenido(10,10));
    }

    @Test
    public void testMatarUnidadDisminuyeLaPoblacion() throws CasilleroOcupado, ExcedeLimiteDelMapa, PoblacionLimiteAlcanzada {
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
    public void testPoblacionMayorACincuentaTiraError() throws CasilleroOcupado, ExcedeLimiteDelMapa, PoblacionLimiteAlcanzada {
        Mapa mapa = new Mapa (20, 20);
        Jugador unJugador = new Jugador(mapa, 20/2, 0,null);

        for (int i = 0; i < 48; i++) {
            unJugador.aumentarPoblacion();
        }
    }

    @Test
    public void testDisminuirPoblacionCuandoNoHayTiraError() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 20/2, 0, null);

        for (int i = 0; i < 4; i++)
            unJugador.disminuirPoblacion();


        assertEquals(0,unJugador.getPoblacionActual());
    }

}