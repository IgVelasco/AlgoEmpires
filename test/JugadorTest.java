import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import espacio.Mapa;
import Juego.Jugador;
import org.junit.Test;


public class JugadorTest {

    @Test
    public void testArmaDeAsedioSeCreaCon150DeVida() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugadorUno = new Jugador(mapa , 20/2 , 0);
        Jugador unJugadorDos = new Jugador(mapa , 20/2 , 15);

    }

}