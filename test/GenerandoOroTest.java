import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import espacio.Mapa;
import estados.GenerandoOro;
import juego.Jugador;
import org.junit.Test;
import unidades.Aldeano;

import static org.junit.Assert.assertEquals;

public class GenerandoOroTest {

    @Test
    public void testSeSuma20DeOro() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        GenerandoOro unEstado = new GenerandoOro();
        Mapa unMapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(unMapa, 20 / 2, 0, null);
        Aldeano unAldeano = new Aldeano(unJugador);

        unEstado.realizarAccion(unAldeano);

        assertEquals(120, unJugador.getOro());
    }
}
