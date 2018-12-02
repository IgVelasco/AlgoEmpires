import modelo.espacio.Contenible;
import modelo.espacio.Mapa;
import modelo.excepciones.*;
import modelo.juego.Jugador;
import modelo.unidades.Aldeano;
import modelo.unidades.Arquero;
import modelo.unidades.Espadachin;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class JugadorTest {

    @Test
    public void testCrearJugadorColocaEstructuras() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 20 / 2, 0, null);

        assert (mapa.casillerosEstanOcupados(20 / 2, 0, 4));
        assert (mapa.casillerosEstanOcupados(8, 0, 2));
    }

    @Test
    public void testCrearJugadorColocaUnidades() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 20 / 2, 0, null);

        assert (mapa.casillerosEstanOcupados(7, 0, 1));
        assert (mapa.casillerosEstanOcupados(7, 1, 1));
        assert (mapa.casillerosEstanOcupados(7, 2, 1));
    }


    @Test
    public void testJugadorTurnoDaOroCorrecto() throws CasilleroOcupado, ExcedeLimiteDelMapa, ArmaYaCargada {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 20 / 2, 0, null);
        unJugador.nuevoTurno();

        assertEquals(160, unJugador.getOro());
    }


    @Test
    public void testJugadorTurnoDaOroCorrectoAlAgregarAldeano() throws CasilleroOcupado, ExcedeLimiteDelMapa, ArmaYaCargada {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 20 / 2, 0, null);
        unJugador.nuevoTurno();

        assertEquals(160, unJugador.getOro());
    }

    @Test
    public void testMatarUnidadLiberaUbicacion() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 20/2, 0, null);
        Aldeano unAldeano = new Aldeano(unJugador);

        mapa.colocarUnidadEn(unAldeano, 10, 10);

        unAldeano.ataqueDeEspadachin();
        unAldeano.ataqueDeEspadachin();

        assertNull(mapa.getContenido(10, 10));
    }

    @Test
    public void testMatarUnidadDisminuyeLaPoblacion() throws CasilleroOcupado, ExcedeLimiteDelMapa, PoblacionLimiteAlcanzada {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 20/2, 0, null);
        Aldeano unAldeano = new Aldeano(unJugador);

        unJugador.aumentarPoblacion();
        mapa.colocarUnidadEn(unAldeano, 10, 10);

        assertEquals(4, unJugador.getPoblacionActual());


        unAldeano.ataqueDeEspadachin();
        unAldeano.ataqueDeEspadachin();

        assertEquals(3, unJugador.getPoblacionActual());

    }

    @Test (expected = PoblacionLimiteAlcanzada.class)
    public void testPoblacionMayorACincuentaTiraError() throws CasilleroOcupado, ExcedeLimiteDelMapa, PoblacionLimiteAlcanzada {
        Mapa mapa = new Mapa (20, 20);
        Jugador unJugador = new Jugador(mapa, 20/2, 0,null);

        for (int i = 0; i < 48; i++) {
            unJugador.aumentarPoblacion();
        }
    }

    @Test
    public void testDisminuirPoblacionCuandoNoHayTiraError() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 20/2, 0, null);

        for (int i = 0; i < 4; i++)
            unJugador.disminuirPoblacion();


        assertEquals(0,unJugador.getPoblacionActual());
    }

    @Test
    public void testUnidadSeMueveCorrectamente() throws CasilleroOcupado, ExcedeLimiteDelMapa, MovimientoFueraDeRango, ArmaCargadaNoSePuedeMover, ContenibleNoPropia, UnidadYaUtilizada {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 20/2, 0, null);
        Aldeano unAldeano = new Aldeano(unJugador);

        mapa.colocarUnidadEn(unAldeano,1, 1);
        unJugador.mover(unAldeano, 1, 1);

        assertEquals(unAldeano, mapa.getContenido(2, 2));
    }

    @Test (expected = MovimientoFueraDeRango.class)
    public void testMoverDosCasillerosNoSePuede() throws CasilleroOcupado, ExcedeLimiteDelMapa, MovimientoFueraDeRango, ArmaCargadaNoSePuedeMover, ContenibleNoPropia, UnidadYaUtilizada {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 20/2, 0, null);
        Aldeano unAldeano = new Aldeano(unJugador);

        mapa.colocarUnidadEn(unAldeano, 1, 1);
        unJugador.mover(unAldeano, 2, 2);
    }

    @Test
    public void testPuedoMoverDosAldeanosDistintosEnElMismoTurno() throws CasilleroOcupado, ExcedeLimiteDelMapa, MovimientoFueraDeRango, ArmaCargadaNoSePuedeMover, ContenibleNoPropia, UnidadYaUtilizada {
        Mapa mapa = new Mapa (20, 20);
        Jugador unJugador = new Jugador(mapa, 10, 0, null);
        Aldeano unAldeano = new Aldeano(unJugador);
        Aldeano otroAldeano = new Aldeano(unJugador);

        mapa.colocarUnidadEn(unAldeano, 2, 2);
        mapa.colocarUnidadEn(otroAldeano, 5, 5);

        unJugador.mover(unAldeano,1, 1);
        unJugador.mover(otroAldeano, 1, 1);

        assertEquals(unAldeano, mapa.getContenido(3, 3));
        assertEquals(otroAldeano, mapa.getContenido(6, 6));
    }

    @Test (expected = UnidadYaUtilizada.class)
    public void testUnidadSoloPuedeMoverseUnaVezPorTurno() throws CasilleroOcupado, ExcedeLimiteDelMapa, MovimientoFueraDeRango, ArmaCargadaNoSePuedeMover, ContenibleNoPropia, UnidadYaUtilizada {
        Mapa mapa = new Mapa (20, 20);
        Jugador unJugador = new Jugador(mapa, 10, 0, null);
        Aldeano unAldeano = new Aldeano(unJugador);

        mapa.colocarUnidadEn(unAldeano, 1, 1);
        unJugador.mover(unAldeano, 1, 1);

        assertEquals(unAldeano, mapa.getContenido(2, 2));

        unJugador.mover(unAldeano, 1, 1);
    }

    @Test
    public void testPuedoMoverDosVecesAUnaUnidadSiPasaElTurno() throws CasilleroOcupado, ExcedeLimiteDelMapa, MovimientoFueraDeRango, ArmaCargadaNoSePuedeMover, ContenibleNoPropia, UnidadYaUtilizada, ArmaYaCargada {
        Mapa mapa = new Mapa (20, 20);
        Jugador unJugador = new Jugador(mapa, 10, 0, null);
        Aldeano unAldeano = new Aldeano(unJugador);

        mapa.colocarUnidadEn(unAldeano, 1, 1);
        unJugador.mover(unAldeano, 1, 1);

        assertEquals(unAldeano, mapa.getContenido(2, 2));

        unJugador.nuevoTurno();
        unJugador.mover(unAldeano, 1, 1);

        assertEquals(unAldeano, mapa.getContenido(3, 3));
    }

    @Test (expected = OroInsuficiente.class)
    public void testNoPuedoConstruirAsedioConOroInicial() throws CasilleroOcupado, ExcedeLimiteDelMapa, PoblacionLimiteAlcanzada, OroInsuficiente {
        Mapa mapa = new Mapa (20, 20);
        Jugador unJugador = new Jugador(mapa, 10, 0, null);

        unJugador.construirAsedio();
    }

    @Test (expected = ContenibleFueraDeRango.class)
    public void testUnidadNoPuedeAtacarFueraDeSuRango() throws CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleFueraDeRango, ArmaNoCargada, UnidadYaUtilizada, AsedioNoAtacaUnidad, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa (20, 20);
        Jugador unJugador = new Jugador(mapa, 10, 0, null);
        Jugador otroJugadpr = new Jugador(mapa, 10, 10, null);
        Espadachin unEspadachin = new Espadachin(unJugador);
        Aldeano unAldeano =  new Aldeano(otroJugadpr);

        mapa.colocarUnidadEn(unEspadachin, 1, 1);
        mapa.colocarUnidadEn(unAldeano, 5, 5);

        unJugador.atacar(unEspadachin, 5, 5);
    }

    @Test (expected = ContenibleDelMismoJugador.class)
    public void testUnidadNoPuedeAtacarAUnAldeanoAliado() throws CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleFueraDeRango, ArmaNoCargada, UnidadYaUtilizada, AsedioNoAtacaUnidad, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa (20, 20);
        Jugador unJugador = new Jugador(mapa, 10, 0, null);
        Espadachin unEspadachin = new Espadachin(unJugador);
        Aldeano unAldeano = new Aldeano(unJugador);

        mapa.colocarUnidadEn(unEspadachin, 1, 1);
        mapa.colocarUnidadEn(unAldeano, 2, 2);

        unJugador.atacar(unEspadachin, 2, 2);
    }

    @Test (expected = UnidadYaUtilizada.class)
    public void testUnidadNoPuedeAtacarDosVecesEnUnTurno() throws CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleFueraDeRango, ArmaNoCargada, UnidadYaUtilizada, AsedioNoAtacaUnidad, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa (20, 20);
        Jugador unJugador = new Jugador(mapa, 10, 0, null);
        Jugador otroJugadpr = new Jugador(mapa, 10, 10, null);
        Espadachin unEspadachin = new Espadachin(unJugador);
        Aldeano unAldeano =  new Aldeano(otroJugadpr);

        mapa.colocarUnidadEn(unEspadachin, 1, 1);
        mapa.colocarUnidadEn(unAldeano, 2, 2);

        unJugador.atacar(unEspadachin, 2, 2);
        unJugador.atacar(unEspadachin, 2, 2);
    }

    @Test
    public void testUnidadAtacaCorrectamenteDosVecesSiPasaElTurno() throws CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleFueraDeRango, ArmaNoCargada, UnidadYaUtilizada, AsedioNoAtacaUnidad, ContenibleDelMismoJugador, ArmaYaCargada {
        Mapa mapa = new Mapa (20, 20);
        Jugador unJugador = new Jugador(mapa, 10, 0, null);
        Jugador otroJugadpr = new Jugador(mapa, 10, 10, null);
        Arquero unArquero = new Arquero(unJugador);
        Aldeano unAldeano =  new Aldeano(otroJugadpr);

        mapa.colocarUnidadEn(unArquero, 1, 1);
        mapa.colocarUnidadEn(unAldeano, 2, 2);

        unJugador.atacar(unArquero, 2, 2);

        assertEquals(35, unAldeano.getVida());

        unJugador.nuevoTurno();
        unJugador.atacar(unArquero, 2, 2);

        assertEquals(20, unAldeano.getVida());
    }



}