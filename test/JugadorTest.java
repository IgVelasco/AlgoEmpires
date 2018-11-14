import excepciones.CasilleroOcupado;
import excepciones.ExcedeLimiteDelMapa;
import espacio.Mapa;
import juego.Jugador;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class JugadorTest {

    @Test
    public void testCrearJugadorColocaEstructuras() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa , 20/2 , 0);

        assert (mapa.casillerosEstanOcupados(20/2, 0, 4));
        assert (mapa.casillerosEstanOcupados(8, 0, 2 ));
    }

    @Test
    public void testCrearJugadorColocaUnidades() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa (20, 20);
        Jugador unJugador = new Jugador (mapa, 20/2, 0);

        assert (mapa.casillerosEstanOcupados(7, 0, 1));
        assert (mapa.casillerosEstanOcupados(7, 1, 1));
        assert (mapa.casillerosEstanOcupados(7, 2, 1));
    }

}