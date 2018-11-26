import modelo.espacio.Mapa;
import modelo.estados.aldeano.Construyendo;
import modelo.estados.aldeano.GenerandoOro;
import modelo.estructuras.Cimiento;
import modelo.estructuras.Cuartel;
import modelo.excepciones.AldeanoOcupado;
import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.ContenibleNoPropia;
import modelo.excepciones.ExcedeLimiteDelMapa;
import modelo.juego.Jugador;
import modelo.unidades.Aldeano;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstruyendoTest {

    @Test
    public void testFinalizarConstruccionDesocupaAldeano() throws CasilleroOcupado, ExcedeLimiteDelMapa, AldeanoOcupado, ContenibleNoPropia {
        Mapa unMapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(unMapa, 10, 0, null);
        Cuartel unCuartel = new Cuartel(null);
        Cimiento unCimiento = new Cimiento(unCuartel,unMapa,5,5,2 );
        Construyendo unEstado = new Construyendo(unCimiento);
        Aldeano unAldeano = new Aldeano(unJugador);

        unAldeano.comenzarCimientos(unCimiento, unJugador);
        unEstado.realizarAccion(unAldeano);

        assertEquals(Construyendo.class, unAldeano.getEstado().getClass());

        unEstado.realizarAccion(unAldeano);
        unEstado.realizarAccion(unAldeano);
        unEstado.realizarAccion(unAldeano);


        assertEquals(GenerandoOro.class, unAldeano.getEstado().getClass());
    }
}
