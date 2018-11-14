import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import espacio.Mapa;
import estados.Construyendo;
import estados.GenerandoOro;
import juego.Juego;
import juego.Jugador;
import unidades.Aldeano;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AldeanoTest {

    @Test
    public void testAldeanoSeCreaCon50DeVida() {
        Aldeano unAldeano = new Aldeano(null);

        assertEquals(50, unAldeano.getVida());
    }

    @Test
    public void testAldeanoEstaConstruyendo() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Aldeano unAldeano = new Aldeano(jugador);


        jugador.construirCuartel(unAldeano);
        assertEquals(jugador.getOro(), 100);

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(Construyendo.class, unAldeano.getEstado().getClass());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(Construyendo.class, unAldeano.getEstado().getClass());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(GenerandoOro.class, unAldeano.getEstado().getClass());

        assertEquals(jugador.getOro(), 100);

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(jugador.getOro(), 120);

    }

    @Test
    public void testAldeanoEstaReparando() throws CasilleroOcupado, ExcedeLimiteDelMapa {
    }
}