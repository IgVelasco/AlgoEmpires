import modelo.espacio.Mapa;
import modelo.espacio.Posicion;
import modelo.estructuras.Castillo;
import modelo.excepciones.*;
import modelo.juego.Jugador;
import modelo.unidades.ArmaDeAsedio;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArmaDeAsedioTest {

    @Test
    public void testArmaDeAsedioSeCreaCon150DeVida() {
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(null, null);

        assertEquals(150, unArmaDeAsedio.getVida());
    }


    @Test(expected = ContenibleFueraDeRango.class)
    public void testArmaDeAsedioNoAtacaArmaDeAsedioFueraDeRango() {
        Mapa mapa = new Mapa(10, 10);
        Jugador jugador = new Jugador(mapa, 5, 5, null);

        Posicion posicionUnaArma = new Posicion(1,1);
        Posicion posicionOtraArma = new Posicion(1,9);


        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(null, posicionUnaArma);
        ArmaDeAsedio otroArmaDeAsedio = new ArmaDeAsedio(null, posicionOtraArma);


        unArmaDeAsedio.cargarArma(jugador);
        unArmaDeAsedio.realizarAccionCorrespondiente();
        unArmaDeAsedio.atacar(otroArmaDeAsedio, null);

    }


    @Test(expected = ContenibleDelMismoJugador.class)
    public void testArmaDeAsedioNoAtacaAUnidadCompaniera() {
        Mapa mapa = new Mapa(10, 10);
        Jugador jugador = new Jugador(mapa, 5, 5, null);

        Posicion posicionUnaArma = new Posicion(1,1);
        Posicion posicionOtraArma = new Posicion(1,2);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador,posicionUnaArma );
        ArmaDeAsedio otroArmaDeAsedio = new ArmaDeAsedio(jugador, posicionOtraArma);

        unArmaDeAsedio.cargarArma(jugador);
        unArmaDeAsedio.realizarAccionCorrespondiente();
        unArmaDeAsedio.atacar(otroArmaDeAsedio, jugador);

        assertEquals(100, otroArmaDeAsedio.getVida());

    }

    @Test (expected = AsedioNoAtacaUnidad.class)
    public void testArmaDeAsedioNoAtacaUnidad() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Posicion posicionUnaArma = new Posicion(1,1);
        Posicion posicionOtraArma = new Posicion(1,2);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador, posicionUnaArma);
        ArmaDeAsedio otroArmaDeAsedio = new ArmaDeAsedio(otroJugador, posicionOtraArma);


        unArmaDeAsedio.cargarArma(jugador);
        unArmaDeAsedio.realizarAccionCorrespondiente();
        unArmaDeAsedio.atacar(otroArmaDeAsedio, jugador);

    }

    @Test(expected = ContenibleFueraDeRango.class)
    public void testArmaDeAsedioNoAtacaEstructuraFueraDeRango() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Posicion posicionUnaArma = new Posicion(1,1);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador, posicionUnaArma);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarEstructuraEn(unCastillo, 1, 9, 4,1);

        unArmaDeAsedio.cargarArma(jugador);
        unArmaDeAsedio.realizarAccionCorrespondiente();
        unArmaDeAsedio.atacar(unCastillo, jugador);

        assertEquals(1000, unCastillo.getVida());

    }

    @Test
    public void testArmaDeAsedioAtacaEstructuraEnRango() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Posicion posicionUnaArma = new Posicion(0, 0);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador, posicionUnaArma);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4,1);

        unArmaDeAsedio.cargarArma(jugador);
        unArmaDeAsedio.realizarAccionCorrespondiente();
        unArmaDeAsedio.atacar(unCastillo, jugador);

        assertEquals(925, unCastillo.getVida());

    }


    @Test(expected = ArmaCargadaNoSePuedeMover.class)
    public void testArmaDeAsedioNoSePuedeMoverSiCargada() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Posicion posicionUnaArma = new Posicion(0, 0);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador, posicionUnaArma);
        Castillo unCastillo = new Castillo(otroJugador);

        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4,1);

        unArmaDeAsedio.cargarArma(jugador);
        unArmaDeAsedio.realizarMovimiento(mapa,1,0,jugador);
        unArmaDeAsedio.atacar(unCastillo, jugador);

    }

    @Test(expected = ArmaCargadaNoSePuedeMover.class)
    public void testArmaDeAsedioNoSePuedeMoverSiCargadaEnOtroTurno() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Posicion posicionUnaArma = new Posicion(0, 0);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador, posicionUnaArma);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4,1);

        unArmaDeAsedio.cargarArma(jugador);
        unArmaDeAsedio.realizarAccionCorrespondiente();
        unArmaDeAsedio.realizarMovimiento(mapa,1,0,jugador);


    }

    @Test
    public void testArmaDeAsedioSePuedeMoverDescargada() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);
        jugador.nuevoTurno();
        jugador.sumarOro(100);

        Posicion posicionUnaArma = new Posicion(0, 0);
        jugador.construirAsedio(posicionUnaArma);
        Castillo unCastillo = new Castillo(otroJugador);

        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4,1);

        ArmaDeAsedio unArmaDeAsedio = (ArmaDeAsedio) mapa.getContenido(0,0);

        unArmaDeAsedio.realizarMovimiento(mapa,1,0,jugador);

        assertEquals(mapa.getContenido(1,0), unArmaDeAsedio);


    }

    @Test(expected = ArmaCargadaNoSePuedeMover.class)
    public void testArmaDeAsedioNoSePuedeMoverDespuesDeDescargar() {

        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Posicion posicionUnaArma = new Posicion(0, 0);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador, posicionUnaArma);
        Castillo unCastillo = new Castillo(otroJugador);



        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4,1);

        unArmaDeAsedio.cargarArma(jugador);
        unArmaDeAsedio.realizarAccionCorrespondiente();
        unArmaDeAsedio.atacar(unCastillo, jugador);
        unArmaDeAsedio.realizarMovimiento(mapa,1,0,jugador);
        assertEquals(mapa.getContenido(1,0), unArmaDeAsedio);
    }

    @Test
    public void testArmaDeAsedioSePuedeMoverDespuesDeDescargarYQuePaseElTurno() {

        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        jugador.sumarOro(1000);

        Posicion posicionUnaArma = new Posicion(0, 0);
        jugador.construirAsedio(posicionUnaArma);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4,1);
        ArmaDeAsedio unArmaDeAsedio = (ArmaDeAsedio) mapa.getContenido(0,0);

        unArmaDeAsedio.cargarArma(jugador);
        unArmaDeAsedio.realizarAccionCorrespondiente();
        unArmaDeAsedio.atacar(unCastillo, jugador);
        unArmaDeAsedio.realizarAccionCorrespondiente();
        unArmaDeAsedio.realizarMovimiento(mapa,1,0,jugador);
        assertEquals(mapa.getContenido(1,0), unArmaDeAsedio);
    }


    @Test (expected = ArmaNoCargada.class)
    public void testArmaDeAsedioNoAtacaSinEstarCargada() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Posicion posicionUnaArma = new Posicion(0, 0);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador, posicionUnaArma);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4,1);

        unArmaDeAsedio.cargarArma(jugador);
        unArmaDeAsedio.atacar(unCastillo, jugador);

    }

    @Test (expected = ArmaYaCargada.class)
    public void testArmaYaCargada() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Posicion posicionUnaArma = new Posicion(0, 0);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador, posicionUnaArma);
        Castillo unCastillo = new Castillo(otroJugador);



        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4,1);

        unArmaDeAsedio.cargarArma(jugador);
        unArmaDeAsedio.realizarAccionCorrespondiente();
        unArmaDeAsedio.cargarArma(jugador);
        unArmaDeAsedio.atacar(unCastillo, jugador);

        assertEquals(925, unCastillo.getVida());

    }

    @Test (expected = ArmaSeCargaEnSiguienteTurno.class)
    public void testArmaSeCargaEnSiguienteTurno() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Posicion posicionUnaArma = new Posicion(0, 0);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador, posicionUnaArma);
        Castillo unCastillo = new Castillo(otroJugador);

        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4,1);

        unArmaDeAsedio.cargarArma(jugador);
        unArmaDeAsedio.cargarArma(jugador);
        unArmaDeAsedio.atacar(unCastillo, jugador);

        assertEquals(925, unCastillo.getVida());

    }

    @Test (expected = ArmaNoCargada.class)
    public void testErrorAtacarConArmaDeAsedioNoCargada() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Posicion posicionUnaArma = new Posicion(0, 0);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador, posicionUnaArma);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4,1);

        unArmaDeAsedio.realizarAccionCorrespondiente();
        unArmaDeAsedio.atacar(unCastillo, jugador);


        assertEquals(1000, unCastillo.getVida());

    }

}
