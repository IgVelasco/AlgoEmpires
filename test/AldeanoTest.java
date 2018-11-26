import modelo.espacio.Mapa;
import modelo.estados.aldeano.Construyendo;
import modelo.estados.aldeano.GenerandoOro;
import modelo.estados.aldeano.Reparando;
import modelo.estructuras.Castillo;
import modelo.estructuras.Cimiento;
import modelo.estructuras.Cuartel;
import modelo.excepciones.*;
import modelo.juego.Jugador;
import modelo.unidades.Aldeano;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AldeanoTest {

    @Test
    public void testAldeanoSeCreaCon50DeVida() {
        Aldeano unAldeano = new Aldeano(null);

        assertEquals(50, unAldeano.getVida());
    }

    @Test
    public void testAldeanoEstaConstruyendo() throws CasilleroOcupado, ExcedeLimiteDelMapa, AldeanoOcupado, ContenibleNoPropia {
        Mapa mapa = new Mapa(30, 30);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Aldeano unAldeano = new Aldeano(jugador);

        jugador.construirCuartel(unAldeano, 20, 20);
        assertEquals(100, jugador.getOro());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(Construyendo.class, unAldeano.getEstado().getClass());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(Construyendo.class, unAldeano.getEstado().getClass());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(GenerandoOro.class, unAldeano.getEstado().getClass());

        assertEquals(100, jugador.getOro());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(120, jugador.getOro());

    }

    @Test
    public void testAldeanoEstaReparandoNoDaOro() throws CasilleroOcupado, ExcedeLimiteDelMapa, EdificioConVidaMaxima, AldeanoOcupado {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Aldeano unAldeano = new Aldeano(jugador);
        Castillo unCastillo = new Castillo(jugador);

        unCastillo.ataqueDeEspadachin();

        unAldeano.comenzarReparacion(unCastillo);
        assertEquals(100, jugador.getOro());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(Reparando.class, unAldeano.getEstado().getClass());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(GenerandoOro.class, unAldeano.getEstado().getClass());

        assertEquals(100, jugador.getOro());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(120, jugador.getOro());

    }

    @Test
    public void testAldeanoReparaVidaCorrecta() throws CasilleroOcupado, ExcedeLimiteDelMapa, EdificioConVidaMaxima, AldeanoOcupado {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Aldeano unAldeano = new Aldeano(jugador);
        Castillo unCastillo = new Castillo(jugador);

        unCastillo.ataqueDeEspadachin();
        unCastillo.ataqueDeEspadachin();

        unAldeano.comenzarReparacion(unCastillo);
        assertEquals(970, unCastillo.getVida());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(985, unCastillo.getVida());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(1000, unCastillo.getVida());

    }


    @Test(expected = EdificioConVidaMaxima.class)
    public void testAldeanoNoReparaEdificioConVidaMaxima() throws CasilleroOcupado, ExcedeLimiteDelMapa, EdificioConVidaMaxima, AldeanoOcupado {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Aldeano unAldeano = new Aldeano(jugador);
        Castillo unCastillo = new Castillo(jugador);

        unAldeano.comenzarReparacion(unCastillo);
        assertEquals(GenerandoOro.class, unAldeano.getEstado().getClass());
    }

    @Test(expected = AldeanoOcupado.class)
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

    @Test(expected = AldeanoOcupado.class)
    public void testAldeanoConstruyendoException() throws CasilleroOcupado, ExcedeLimiteDelMapa, AldeanoOcupado, ContenibleNoPropia {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Aldeano unAldeano = new Aldeano(jugador);
        Cuartel unCuartel = new Cuartel(null);
        Cuartel otroCuartel = new Cuartel(null);
        Cimiento unCimiento = new Cimiento(unCuartel,mapa,10,10,2);
        Cimiento otroCimiento = new Cimiento(otroCuartel,mapa,12,12,2);

        unAldeano.comenzarCimientos(unCimiento, jugador);
        unAldeano.comenzarCimientos(otroCimiento, jugador);

    }

    @Test
    public void testAldeanoSeMueveCorrectamenteHaciaAtras() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada, MovimientoFueraDeRango, ContenibleNoPropia {
        Mapa mapa = new Mapa(10, 10);
        Aldeano unAldeano = new Aldeano(null);

        mapa.colocarUnidadEn(unAldeano, 2, 2);

        unAldeano.realizarMovimiento(mapa, -1, -1,null);
        assertEquals(unAldeano, mapa.getContenido(1, 1));
    }

    @Test
    public void testAldeanoSeMueveCorrectamenteHaciaAdelante() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada, MovimientoFueraDeRango, ContenibleNoPropia {
        Mapa mapa = new Mapa(10, 10);
        Aldeano unAldeano = new Aldeano(null);

        mapa.colocarUnidadEn(unAldeano, 2, 2);

        unAldeano.realizarMovimiento(mapa, 1, 1, null);
        assertEquals(unAldeano, mapa.getContenido(3, 3));
    }

    @Test(expected = MovimientoFueraDeRango.class)
    public void testAldeanoNoPuedeMoverseMasDeUnCasillero() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada, MovimientoFueraDeRango, ContenibleNoPropia {
        Mapa mapa = new Mapa(10, 10);
        Aldeano unAldeano = new Aldeano(null);

        mapa.colocarUnidadEn(unAldeano, 2, 2);

        unAldeano.realizarMovimiento(mapa, 2, 2, null);
    }

    @Test(expected = ExcedeLimiteDelMapa.class)
    public void testAldeanoNoPuedeMoverseFueraDelMapa() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada, MovimientoFueraDeRango, ContenibleNoPropia {
        Mapa mapa = new Mapa(10, 10);
        Aldeano unAldeano = new Aldeano(null);

        mapa.colocarUnidadEn(unAldeano, 0, 0);

        unAldeano.realizarMovimiento(mapa, -1, -1, null);
    }

    @Test(expected = CasilleroOcupado.class)
    public void testAldeanoNoPuedeMoverseAUnCasilleroOcupado() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada, MovimientoFueraDeRango, ContenibleNoPropia {
        Mapa mapa = new Mapa(10, 10);
        Aldeano unAldeano = new Aldeano(null);
        Aldeano otroAldeano = new Aldeano(null);

        mapa.colocarUnidadEn(unAldeano, 0, 0);
        mapa.colocarUnidadEn(otroAldeano, 1, 1);

        unAldeano.realizarMovimiento(mapa, 1, 1, null);
    }

    @Test(expected = UnidadYaUtilizada.class)
    public void testAldeanoNoPuedeMoverseDosVecesEnUnTurno() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada, MovimientoFueraDeRango, ContenibleNoPropia {
        Mapa mapa = new Mapa(10, 10);
        Aldeano unAldeano = new Aldeano(null);

        mapa.colocarUnidadEn(unAldeano, 1, 1);

        unAldeano.realizarMovimiento(mapa, 1, 1, null);
        unAldeano.realizarMovimiento(mapa, 1, 1, null);
    }

    @Test
    public void testAldeanoPuedeMoverseDevueltaAlPasarElTurno() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada, MovimientoFueraDeRango, ContenibleNoPropia {
        Mapa mapa = new Mapa(10, 10);
        Aldeano unAldeano = new Aldeano(null);

        mapa.colocarUnidadEn(unAldeano, 1, 1);

        unAldeano.realizarMovimiento(mapa, 1, 1, null);
        assertEquals(unAldeano, mapa.getContenido(2, 2));

        unAldeano.permitirMovimiento();
        unAldeano.realizarMovimiento(mapa, 1, 1, null);
        assertEquals(unAldeano, mapa.getContenido(3, 3));
    }

    @Test (expected = ContenibleNoPropia.class)
    public void testAldeanoNoPuedoMoverSiNoEsPropio() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada, MovimientoFueraDeRango, ContenibleNoPropia {

        Mapa mapa = new Mapa(10, 10);
        Jugador unJugador = new Jugador(mapa,5,5,null);
        Aldeano unAldeano = new Aldeano(null);

        mapa.colocarUnidadEn(unAldeano, 1, 1);

        unAldeano.realizarMovimiento(mapa, 1, 1, unJugador);
        assertEquals(unAldeano, mapa.getContenido(2, 2));

    }

}