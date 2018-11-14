import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import espacio.Mapa;
import estados.Construyendo;
import estados.GenerandoOro;
import estructuras.Cuartel;
import juego.Jugador;
import org.junit.Test;
import unidades.Aldeano;

import static org.junit.Assert.assertEquals;

public class ConstruyendoTest {

    @Test
    public void testFinalizarConstruccionDesocupaAldeano () throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa unMapa = new Mapa (20, 20);
        Jugador unJugador = new Jugador(unMapa, 10, 0, null);
        Cuartel unCuartel = new Cuartel();
        Construyendo unEstado = new Construyendo(unCuartel);
        Aldeano unAldeano = new Aldeano(unJugador);

        unAldeano.comenzarConstruccion(unCuartel);
        unEstado.realizarAccionPasiva(unAldeano);

        assertEquals(Construyendo.class, unAldeano.getEstado().getClass());

        unEstado.realizarAccionPasiva(unAldeano);
        unEstado.realizarAccionPasiva(unAldeano);

        assertEquals(GenerandoOro.class, unAldeano.getEstado().getClass());
    }
}
