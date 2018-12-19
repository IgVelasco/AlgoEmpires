import modelo.juego.Juego;
import modelo.juego.Jugador;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class JuegoTest {

    @Test
    public void testCambiarTurno() {
    }

    @Test
    public void testGetJugadores() {
    }

    @Test
    public  void testCambiarTurnoCambiaJugadorActual() {
        Juego unJuego = new Juego(20, 20);
        Jugador[] jugadores = unJuego.getJugadores();
        Jugador jugadorActual = unJuego.getJugadorActual();
        unJuego.siguienteTurno();
        assertNotEquals(unJuego.getJugadorActual(), jugadorActual);
    }
}