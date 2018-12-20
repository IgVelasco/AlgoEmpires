import modelo.espacio.Mapa;
import modelo.espacio.Posicion;
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
        Aldeano unAldeano = new Aldeano(null, null);

        assertEquals(50, unAldeano.getVida());
    }

    @Test
    public void testAldeanoEstaConstruyendo() {
        Mapa mapa = new Mapa(30, 30);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        jugador.nuevoTurno();

        Posicion posicionUnAldeano = new Posicion(19, 19);
        Aldeano unAldeano = new Aldeano(jugador, posicionUnAldeano);

        jugador.construirCuartel(unAldeano, 20, 20);
        assertEquals(50, jugador.getOro());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(Construyendo.class, unAldeano.getEstado().getClass());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(Construyendo.class, unAldeano.getEstado().getClass());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(GenerandoOro.class, unAldeano.getEstado().getClass());

        assertEquals(50, jugador.getOro());

        unAldeano.realizarAccionCorrespondiente();
        assertEquals(70, jugador.getOro());

    }

    @Test (expected = AldeanoOcupado.class)
    public void testAldeanoNoPuedeConstruirDosCosasALaVez() {
        Mapa mapa = new Mapa(30, 30);
        Jugador unJugador = new Jugador(mapa, 5, 5, null);

        Posicion posicionUnAldeano = new Posicion(19, 19);
        Aldeano unAldeano = new Aldeano(unJugador, posicionUnAldeano);

        unJugador.nuevoTurno();
        unJugador.nuevoTurno();
        unJugador.nuevoTurno();
        unJugador.nuevoTurno();
        unJugador.nuevoTurno();

        unJugador.construirCuartel(unAldeano, 20, 20);
        unJugador.construirCuartel(unAldeano, 18, 19);
    }

    @Test
    public void testAldeanoEstaReparandoNoDaOro() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        jugador.nuevoTurno();

        Posicion posicionUnAldeano = new Posicion(19, 19);
        Aldeano unAldeano = new Aldeano(jugador, posicionUnAldeano);
        Castillo unCastillo = new Castillo(jugador);

        unCastillo.ataqueDeEspadachin();

        jugador.repararEstructura(unAldeano, unCastillo);
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
    public void testAldeanoReparaVidaCorrecta() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);

        Posicion posicionUnAldeano = new Posicion(4, 4);
        Aldeano unAldeano = new Aldeano(jugador, posicionUnAldeano);
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
    public void testAldeanoNoReparaEdificioConVidaMaxima() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);

        Posicion posicionUnAldeano = new Posicion(4, 4);
        Aldeano unAldeano = new Aldeano(jugador, posicionUnAldeano);
        Castillo unCastillo = new Castillo(jugador);

        unAldeano.comenzarReparacion(unCastillo);
        assertEquals(GenerandoOro.class, unAldeano.getEstado().getClass());
    }

    @Test(expected = AldeanoOcupado.class)
    public void testAldeanoOcupadoReparandoException() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);

        Posicion posicionUnAldeano = new Posicion(4, 4);
        Aldeano unAldeano = new Aldeano(jugador, posicionUnAldeano);
        Castillo unCastillo = new Castillo(jugador);
        Castillo otroCastillo = new Castillo(jugador);

        unCastillo.ataqueDeEspadachin();
        otroCastillo.ataqueDeArquero();

        unAldeano.comenzarReparacion(unCastillo);
        unAldeano.comenzarReparacion(otroCastillo);

    }

    @Test(expected = AldeanoOcupado.class)
    public void testAldeanoConstruyendoException() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);

        Posicion posicionUnAldeano = new Posicion(11, 11);
        Aldeano unAldeano = new Aldeano(jugador, posicionUnAldeano);

        Cuartel unCuartel = new Cuartel(null);
        Cuartel otroCuartel = new Cuartel(null);
        Cimiento unCimiento = new Cimiento(unCuartel,mapa,10,10,2);
        Cimiento otroCimiento = new Cimiento(otroCuartel,mapa,12,12,2);

        unAldeano.comenzarCimientos(unCimiento, jugador);
        unAldeano.comenzarCimientos(otroCimiento, jugador);

    }

    @Test
    public void testAldeanoSeMueveCorrectamenteHaciaAtras() {
        Mapa mapa = new Mapa(10, 10);
        Jugador unJugador = new Jugador(mapa, 5, 5,null);

        Posicion posicionUnAldeano = new Posicion(2, 2);
        mapa.colocarUnidadEn(new Aldeano(unJugador,posicionUnAldeano), posicionUnAldeano);
        Aldeano unAldeano = (Aldeano) mapa.getContenido(2, 2);

        unAldeano.realizarMovimiento(mapa, 1, 1, unJugador);
        assertEquals(unAldeano, mapa.getContenido(1, 1));
    }

    @Test
    public void testAldeanoSeMueveCorrectamenteHaciaAdelante() {
        Mapa mapa = new Mapa(10, 10);
        Jugador unJugador = new Jugador(mapa, 5, 5,null);

        Posicion posicionUnAldeano = new Posicion(2, 2);
        mapa.colocarUnidadEn(new Aldeano(unJugador,posicionUnAldeano), posicionUnAldeano);

        Aldeano unAldeano = (Aldeano) mapa.getContenido(2, 2);

        unAldeano.realizarMovimiento(mapa, 3, 3, unJugador);
        assertEquals(unAldeano, mapa.getContenido(3, 3));
    }

    @Test(expected = MovimientoFueraDeRango.class)
    public void testAldeanoNoPuedeMoverseMasDeUnCasillero() {
        Mapa mapa = new Mapa(10, 10);
        Jugador unJugador = new Jugador(mapa, 5, 5,null);

        Posicion posicionUnAldeano = new Posicion(2, 2);
        Aldeano unAldeano = new Aldeano(unJugador, posicionUnAldeano);



        unAldeano.realizarMovimiento(mapa, 2, 2, unJugador);
    }

    @Test(expected = ExcedeLimiteDelMapa.class)
    public void testAldeanoNoPuedeMoverseFueraDelMapa() {
        Mapa mapa = new Mapa(10, 10);
        Jugador unJugador = new Jugador(mapa, 5, 5,null);

        Posicion posicionUnAldeano = new Posicion(0, 0);
        Aldeano unAldeano = new Aldeano(unJugador,posicionUnAldeano);

        unAldeano.realizarMovimiento(mapa, -1, -1, unJugador);
    }

    @Test(expected = CasilleroOcupado.class)
    public void testAldeanoNoPuedeMoverseAUnCasilleroOcupado() {
        Mapa mapa = new Mapa(10, 10);
        Jugador unJugador = new Jugador(mapa, 5, 5,null);
        Posicion posicionUnAldeano = new Posicion(0, 0);
        Posicion posicionOtroAldeano = new Posicion(1, 1);

        unJugador.sumarOro(1000);

        mapa.colocarUnidadEn(new Aldeano(unJugador,posicionOtroAldeano),posicionUnAldeano);
        mapa.colocarUnidadEn(new Aldeano(unJugador,posicionOtroAldeano),posicionUnAldeano);
        Aldeano unAldeano = (Aldeano) mapa.getContenido(0,0);

        unAldeano.realizarMovimiento(mapa, 1, 1, unJugador);
    }

    /*@Test(expected = UnidadYaUtilizada.class)
    public void testAldeanoNoPuedeMoverseDosVecesEnUnTurno() eRango, ContenibleNoPropia, ArmaCargadaNoSePuedeMover {
        Mapa mapa = new Mapa(10, 10);
        Aldeano unAldeano = new Aldeano(null);

        mapa.colocarUnidadEn(unAldeano, 1, 1);

        unAldeano.realizarMovimiento(mapa, 1, 1, null);
        unAldeano.realizarMovimiento(mapa, 1, 1, null);
    }*/

    /*@Test
    public void testAldeanoPuedeMoverseDevueltaAlPasarElTurno() eRango, ContenibleNoPropia, ArmaCargadaNoSePuedeMover {
        Mapa mapa = new Mapa(10, 10);
        Aldeano unAldeano = new Aldeano(null);

        mapa.colocarUnidadEn(unAldeano, 1, 1);

        unAldeano.realizarMovimiento(mapa, 1, 1, null);
        assertEquals(unAldeano, mapa.getContenido(2, 2));

        unAldeano.permitirMovimiento();
        unAldeano.realizarMovimiento(mapa, 1, 1, null);
        assertEquals(unAldeano, mapa.getContenido(3, 3));
    }*/

    @Test (expected = ContenibleNoPropia.class)
    public void testAldeanoNoPuedoMoverSiNoEsPropio() {

        Mapa mapa = new Mapa(10, 10);
        Jugador unJugador = new Jugador(mapa,5,5,null);

        Posicion posicionOtroAldeano = new Posicion(1, 1);
        Aldeano unAldeano = new Aldeano(null, posicionOtroAldeano);

        unAldeano.realizarMovimiento(mapa, 1, 1, unJugador);
        assertEquals(unAldeano, mapa.getContenido(2, 2));

    }

}