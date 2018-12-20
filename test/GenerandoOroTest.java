import modelo.espacio.Mapa;
import modelo.estados.aldeano.GenerandoOro;
import modelo.juego.Jugador;
import modelo.unidades.Aldeano;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GenerandoOroTest {

    @Test
    public void testSeSuma20DeOro() {
        GenerandoOro unEstado = new GenerandoOro();
        Mapa unMapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(unMapa, 20 / 2, 0, null);
        unJugador.nuevoTurno();
        Aldeano unAldeano = new Aldeano(unJugador, null);


        unEstado.realizarAccion(unAldeano);

        assertEquals(120, unJugador.getOro());
    }
}
