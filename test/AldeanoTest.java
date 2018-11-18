import Excepciones.AldeanoOcupado;
import Excepciones.CasilleroOcupado;
import Excepciones.EdificioConVidaMaxima;
import Excepciones.ExcedeLimiteDelMapa;
import espacio.Mapa;
import estados.Construyendo;
import estados.GenerandoOro;
import estados.Reparando;
import estructuras.Castillo;
import estructuras.Cuartel;
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

        jugador.construirCuartel(unAldeano,10 , 10);
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
        unCastillo.ataqueDeEspadachin();

        unAldeano.comenzarReparacion(unCastillo);
        assertEquals(970, unCastillo.getVida());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(985, unCastillo.getVida());

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
    public void testAldeanoOcupadoReparandoException() throws CasilleroOcupado, ExcedeLimiteDelMapa, EdificioConVidaMaxima, AldeanoOcupado {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Aldeano unAldeano = new Aldeano(jugador);
        Castillo unCastillo = new Castillo(jugador);
        Castillo otroCastillo = new Castillo(jugador);

        unCastillo.ataqueDeEspadachin();
        otroCastillo.ataqueDeArquero();

        unAldeano.comenzarReparacion(unCastillo);
        unAldeano.comenzarReparacion(otroCastillo);

    }

    @Test (expected = AldeanoOcupado.class)
    public void testAldeanoConstruyendoxception() throws CasilleroOcupado, ExcedeLimiteDelMapa, AldeanoOcupado {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Aldeano unAldeano = new Aldeano(jugador);
        Cuartel unCuartel = new Cuartel();
        Cuartel otroCuartel = new Cuartel();

        unAldeano.comenzarConstruccion(unCuartel);
        unAldeano.comenzarConstruccion(otroCuartel);

    }

    @Test
    public void testAldeanoMoverHorizontalmenteLoRealizaCorrectamente() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10,10);
        Aldeano unAldeano = new Aldeano(null);

        mapa.colocarUnidadEn(unAldeano,0,0);
        unAldeano.moverDerecha(mapa);
        assertEquals(unAldeano, mapa.getContenido(1,0));
    }

    @Test
    public void testAldeanoMoverseHorizontalmenteActualizaPosicion() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10,10);
        Aldeano unAldeano = new Aldeano(null);

        mapa.colocarUnidadEn(unAldeano,1,1);
        unAldeano.moverIzquierda(mapa);
        assertEquals(0, unAldeano.getPosicionHorizontal());
    }

    @Test
    public void testAldeanoMoverEnVerticalLoRealizaCorrectamente() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10,10);
        Aldeano unAldeano = new Aldeano(null);

        mapa.colocarUnidadEn(unAldeano,1,1);
        unAldeano.moverArriba(mapa);
        assertEquals(unAldeano, mapa.getContenido(1,2));
    }

    @Test
    public void testAldeanoMoverVerticalActualizaPosicion() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10,10);
        Aldeano unAldeano = new Aldeano(null);

        mapa.colocarUnidadEn(unAldeano,1,1);
        unAldeano.moverAbajo(mapa);
        assertEquals(0, unAldeano.getPosicionVertical());
    }

    @Test
    public void testAldeanoMoverseDiagonalLoRealizaCorrectamente() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10,10);
        Aldeano unAldeano = new Aldeano(null);

        mapa.colocarUnidadEn(unAldeano,1,1);
        unAldeano.moverDerechaSuperior(mapa);
        assertEquals(unAldeano, mapa.getContenido(2,2));
    }

    @Test
    public void testAldeanoMoverseDiagonalActualizaPosicion() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10,10);
        Aldeano unAldeano = new Aldeano(null);

        mapa.colocarUnidadEn(unAldeano,1,1);
        unAldeano.moverIzquierdaInferior(mapa);
        assertEquals(0, unAldeano.getPosicionHorizontal());
        assertEquals(0,unAldeano.getPosicionVertical());
    }

    @Test(expected = ExcedeLimiteDelMapa.class)
    public void testAldeanoNoSeVaDelMapa() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10,10);
        Aldeano unAldeano = new Aldeano(null);

        mapa.colocarUnidadEn(unAldeano,0,0);
        unAldeano.moverIzquierda(mapa);
    }

    @Test(expected = CasilleroOcupado.class)
    public void testAldeanoNoSePuedeMoverHaciaUnCasilleroOcupado() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10, 10);
        Aldeano unAldeano = new Aldeano(null);
        Aldeano otroAldeano = new Aldeano(null);

        mapa.colocarUnidadEn(unAldeano, 1,1);
        mapa.colocarUnidadEn(otroAldeano,0,0);

        unAldeano.moverIzquierdaInferior(mapa);
    }


}