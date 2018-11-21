import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import espacio.Mapa;
import juego.Jugador;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


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
}