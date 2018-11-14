import Excepciones.AldeanoOcupado;
import Excepciones.CasilleroOcupado;
import Excepciones.EdificioConVidaMaxima;
import Excepciones.ExcedeLimiteDelMapa;
import espacio.Mapa;
import estados.Construyendo;
import estados.GenerandoOro;
import estados.Reparando;
import estructuras.Castillo;
import estructuras.Estructura;
import juego.Juego;
import juego.Jugador;
import unidades.Aldeano;
import org.junit.Test;
import unidades.Espadachin;

import static org.junit.Assert.assertEquals;

public class AldeanoTest {

    @Test
    public void testAldeanoSeCreaCon50DeVida() {
        Aldeano unAldeano = new Aldeano(null);

        assertEquals(50, unAldeano.getVida());
    }

    @Test
    public void testAldeanoEstaConstruyendo() throws CasilleroOcupado, ExcedeLimiteDelMapa, AldeanoOcupado {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Aldeano unAldeano = new Aldeano(jugador);

        jugador.construirCuartel(unAldeano);
        assertEquals(100, jugador.getOro());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(Construyendo.class, unAldeano.getEstado().getClass());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(Construyendo.class, unAldeano.getEstado().getClass());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(GenerandoOro.class, unAldeano.getEstado().getClass());

        assertEquals(100, jugador.getOro());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(120,jugador.getOro() );

    }

    @Test
    public void testAldeanoEstaReparandoNoDaOro() throws CasilleroOcupado, ExcedeLimiteDelMapa, EdificioConVidaMaxima, AldeanoOcupado {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Aldeano unAldeano = new Aldeano(jugador);
        Castillo unCastillo = new Castillo(jugador) ;

        unCastillo.ataqueDeEspadachin();

        unAldeano.comenzarReparacion(unCastillo);
        assertEquals(100, jugador.getOro());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(Reparando.class, unAldeano.getEstado().getClass());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(GenerandoOro.class, unAldeano.getEstado().getClass());

        assertEquals(100, jugador.getOro());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(120,jugador.getOro() );

    }

    @Test
    public void testAldeanoReparaVidaCorrecta() throws CasilleroOcupado, ExcedeLimiteDelMapa, EdificioConVidaMaxima, AldeanoOcupado {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Aldeano unAldeano = new Aldeano(jugador);
        Castillo unCastillo = new Castillo(jugador) ;

        unCastillo.ataqueDeEspadachin();

        unAldeano.comenzarReparacion(unCastillo);
        assertEquals(975, unCastillo.getVida());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(990, unCastillo.getVida());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(1000, unCastillo.getVida());

    }


    @Test (expected = EdificioConVidaMaxima.class)
    public void testAldeanoNoReparaEdificioConVidaMaxima() throws CasilleroOcupado, ExcedeLimiteDelMapa, EdificioConVidaMaxima, AldeanoOcupado {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Aldeano unAldeano = new Aldeano(jugador);
        Castillo unCastillo = new Castillo(jugador);

        unAldeano.comenzarReparacion(unCastillo);
        assertEquals(GenerandoOro.class, unAldeano.getEstado().getClass());
    }

    @Test (expected = AldeanoOcupado.class)
    public void testAldeanoOcupadoException() throws CasilleroOcupado, ExcedeLimiteDelMapa, EdificioConVidaMaxima, AldeanoOcupado {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Aldeano unAldeano = new Aldeano(jugador);
        Castillo unCastillo = new Castillo(jugador);
        Castillo otroCastillo = new Castillo(jugador);

        unCastillo.ataqueDeEspadachin();
        otroCastillo.ataqueDeEspadachin();

        unAldeano.comenzarReparacion(unCastillo);
        unAldeano.comenzarReparacion(otroCastillo);

    }






}