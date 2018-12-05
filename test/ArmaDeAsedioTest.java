import modelo.espacio.Mapa;
import modelo.estructuras.Castillo;
import modelo.excepciones.*;
import modelo.juego.Jugador;
import modelo.unidades.ArmaDeAsedio;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArmaDeAsedioTest {

    @Test
    public void testArmaDeAsedioSeCreaCon150DeVida() {
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(null);

        assertEquals(150, unArmaDeAsedio.getVida());
    }


    @Test(expected = ContenibleFueraDeRango.class)
    public void testArmaDeAsedioNoAtacaArmaDeAsedioFueraDeRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, AsedioNoAtacaUnidad, ArmaNoCargada, ArmaYaCargada, ArmaSeCargaEnSiguienteTurno, ContenibleNoPropia {
        Mapa mapa = new Mapa(10, 10);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(null);
        ArmaDeAsedio otroArmaDeAsedio = new ArmaDeAsedio(null);


        mapa.colocarUnidadEn(unArmaDeAsedio, 1, 1);
        mapa.colocarUnidadEn(otroArmaDeAsedio, 1, 9);


        unArmaDeAsedio.cargarArma();
        unArmaDeAsedio.realizarAccionCorrespondiente();
        unArmaDeAsedio.atacar(otroArmaDeAsedio, null);

    }


    @Test(expected = ContenibleDelMismoJugador.class)
    public void testArmaDeAsedioNoAtacaAUnidadCompaniera() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, AsedioNoAtacaUnidad, ArmaNoCargada, ArmaYaCargada, ArmaSeCargaEnSiguienteTurno, ContenibleNoPropia {
        Mapa mapa = new Mapa(10, 10);
        Jugador jugador = new Jugador(mapa, 5, 5, null);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador);
        ArmaDeAsedio otroArmaDeAsedio = new ArmaDeAsedio(jugador);


        mapa.colocarUnidadEn(unArmaDeAsedio, 1, 1);
        mapa.colocarUnidadEn(otroArmaDeAsedio, 1, 2);

        unArmaDeAsedio.cargarArma();
        unArmaDeAsedio.realizarAccionCorrespondiente();
        unArmaDeAsedio.atacar(otroArmaDeAsedio, jugador);

        assertEquals(100, otroArmaDeAsedio.getVida());

    }

    @Test (expected = AsedioNoAtacaUnidad.class)
    public void testArmaDeAsedioNoAtacaUnidad() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, AsedioNoAtacaUnidad, ArmaNoCargada, ArmaYaCargada, ArmaSeCargaEnSiguienteTurno, ContenibleNoPropia {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador);
        ArmaDeAsedio otroArmaDeAsedio = new ArmaDeAsedio(otroJugador);


        mapa.colocarUnidadEn(unArmaDeAsedio, 1, 1);
        mapa.colocarUnidadEn(otroArmaDeAsedio, 1, 2);



        unArmaDeAsedio.cargarArma();
        unArmaDeAsedio.realizarAccionCorrespondiente();
        unArmaDeAsedio.atacar(otroArmaDeAsedio, jugador);

    }

    @Test(expected = ContenibleFueraDeRango.class)
    public void testArmaDeAsedioNoAtacaEstructuraFueraDeRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, CasilleroOcupado, AsedioNoAtacaUnidad, ArmaNoCargada, ArmaYaCargada, ArmaSeCargaEnSiguienteTurno, ContenibleNoPropia {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarUnidadEn(unArmaDeAsedio, 1, 1);
        mapa.colocarEstructuraEn(unCastillo, 1, 9, 4);

        unArmaDeAsedio.cargarArma();
        unArmaDeAsedio.realizarAccionCorrespondiente();
        unArmaDeAsedio.atacar(unCastillo, jugador);

        assertEquals(1000, unCastillo.getVida());

    }

    @Test
    public void testArmaDeAsedioAtacaEstructuraEnRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, AsedioNoAtacaUnidad, ArmaNoCargada, ArmaYaCargada, ArmaSeCargaEnSiguienteTurno, ContenibleNoPropia {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarUnidadEn(unArmaDeAsedio, 0, 0);
        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4);

        unArmaDeAsedio.cargarArma();
        unArmaDeAsedio.realizarAccionCorrespondiente();
        unArmaDeAsedio.atacar(unCastillo, jugador);

        assertEquals(925, unCastillo.getVida());

    }


    @Test(expected = ArmaCargadaNoSePuedeMover.class)
    public void testArmaDeAsedioNoSePuedeMoverSiCargada() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, AsedioNoAtacaUnidad, ArmaNoCargada, ArmaYaCargada, ArmaSeCargaEnSiguienteTurno, MovimientoFueraDeRango, ArmaCargadaNoSePuedeMover, ContenibleNoPropia, UnidadYaUtilizada {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarUnidadEn(unArmaDeAsedio, 0, 0);
        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4);

        unArmaDeAsedio.cargarArma();
        unArmaDeAsedio.realizarMovimiento(mapa,1,0,jugador);
        unArmaDeAsedio.atacar(unCastillo, jugador);

    }

    @Test(expected = ArmaCargadaNoSePuedeMover.class)
    public void testArmaDeAsedioNoSePuedeMoverSiCargadaEnOtroTurno() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, AsedioNoAtacaUnidad, ArmaNoCargada, ArmaYaCargada, ArmaSeCargaEnSiguienteTurno, MovimientoFueraDeRango, ArmaCargadaNoSePuedeMover, ContenibleNoPropia, UnidadYaUtilizada {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarUnidadEn(unArmaDeAsedio, 0, 0);
        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4);

        unArmaDeAsedio.cargarArma();
        unArmaDeAsedio.realizarAccionCorrespondiente();
        unArmaDeAsedio.realizarMovimiento(mapa,1,0,jugador);


    }

    @Test
    public void testArmaDeAsedioSePuedeMoverDescargada() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, AsedioNoAtacaUnidad, ArmaNoCargada, ArmaYaCargada, ArmaSeCargaEnSiguienteTurno, MovimientoFueraDeRango, ArmaCargadaNoSePuedeMover, ContenibleNoPropia, UnidadYaUtilizada {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarUnidadEn(unArmaDeAsedio, 0, 0);
        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4);

        unArmaDeAsedio.realizarMovimiento(mapa,1,0,jugador);

        assertEquals(mapa.getContenido(1,0), unArmaDeAsedio);


    }

    @Test(expected = ArmaCargadaNoSePuedeMover.class)
    public void testArmaDeAsedioNoSePuedeMoverDespuesDeDescargar() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, AsedioNoAtacaUnidad, ArmaNoCargada, ArmaYaCargada, ArmaSeCargaEnSiguienteTurno, MovimientoFueraDeRango, ArmaCargadaNoSePuedeMover, ContenibleNoPropia, UnidadYaUtilizada {

        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarUnidadEn(unArmaDeAsedio, 0, 0);
        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4);

        unArmaDeAsedio.cargarArma();
        unArmaDeAsedio.realizarAccionCorrespondiente();
        unArmaDeAsedio.atacar(unCastillo, jugador);
        unArmaDeAsedio.realizarMovimiento(mapa,1,0,jugador);
        assertEquals(mapa.getContenido(1,0), unArmaDeAsedio);
    }

    @Test
    public void testArmaDeAsedioSePuedeMoverDespuesDeDescargarYQuePaseElTurno() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, AsedioNoAtacaUnidad, ArmaNoCargada, ArmaYaCargada, ArmaSeCargaEnSiguienteTurno, MovimientoFueraDeRango, ArmaCargadaNoSePuedeMover, ContenibleNoPropia, UnidadYaUtilizada {

        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarUnidadEn(unArmaDeAsedio, 0, 0);
        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4);

        unArmaDeAsedio.cargarArma();
        unArmaDeAsedio.realizarAccionCorrespondiente();
        unArmaDeAsedio.atacar(unCastillo, jugador);
        unArmaDeAsedio.realizarAccionCorrespondiente();
        unArmaDeAsedio.realizarMovimiento(mapa,1,0,jugador);
        assertEquals(mapa.getContenido(1,0), unArmaDeAsedio);
    }


    @Test (expected = ArmaNoCargada.class)
    public void testArmaDeAsedioNoAtacaSinEstarCargada() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, AsedioNoAtacaUnidad, ArmaNoCargada, ArmaYaCargada, ArmaSeCargaEnSiguienteTurno, ContenibleNoPropia {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarUnidadEn(unArmaDeAsedio, 0, 0);
        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4);

        unArmaDeAsedio.cargarArma();
        unArmaDeAsedio.atacar(unCastillo, jugador);

    }

    @Test (expected = ArmaYaCargada.class)
    public void testArmaYaCargada() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, AsedioNoAtacaUnidad, ArmaNoCargada, ArmaYaCargada, ArmaSeCargaEnSiguienteTurno, ContenibleNoPropia {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarUnidadEn(unArmaDeAsedio, 0, 0);
        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4);

        unArmaDeAsedio.cargarArma();
        unArmaDeAsedio.realizarAccionCorrespondiente();
        unArmaDeAsedio.cargarArma();
        unArmaDeAsedio.atacar(unCastillo, jugador);

        assertEquals(925, unCastillo.getVida());

    }

    @Test (expected = ArmaSeCargaEnSiguienteTurno.class)
    public void testArmaSeCargaEnSiguienteTurno() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, AsedioNoAtacaUnidad, ArmaNoCargada, ArmaYaCargada, ArmaSeCargaEnSiguienteTurno, ContenibleNoPropia {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarUnidadEn(unArmaDeAsedio, 0, 0);
        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4);

        unArmaDeAsedio.cargarArma();
        unArmaDeAsedio.cargarArma();
        unArmaDeAsedio.atacar(unCastillo, jugador);

        assertEquals(925, unCastillo.getVida());

    }

    @Test (expected = ArmaNoCargada.class)
    public void testErrorAtacarConArmaDeAsedioNoCargada() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, AsedioNoAtacaUnidad, ArmaNoCargada, ArmaYaCargada, ArmaSeCargaEnSiguienteTurno, ContenibleNoPropia {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarUnidadEn(unArmaDeAsedio, 0, 0);
        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4);

        unArmaDeAsedio.realizarAccionCorrespondiente();
        unArmaDeAsedio.atacar(unCastillo, jugador);


        assertEquals(1000, unCastillo.getVida());

    }

}
