import modelo.espacio.Contenible;
import modelo.espacio.Mapa;
import modelo.espacio.Posicion;
import modelo.estructuras.Castillo;
import modelo.estructuras.Cuartel;
import modelo.estructuras.PlazaCentral;
import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.ExcedeLimiteDelMapa;
import modelo.excepciones.OroInsuficiente;
import modelo.excepciones.PoblacionLimiteAlcanzada;
import modelo.juego.Jugador;
import modelo.unidades.Aldeano;
import modelo.unidades.ArmaDeAsedio;
import modelo.unidades.Espadachin;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CastilloTest {

    @Test
    public void testCastilloSeCreaCon1000DeVida() {
        Castillo unCastillo = new Castillo(null);

        assertEquals(1000, unCastillo.getVida());
    }

    @Test(expected = OroInsuficiente.class)
    public void testNoCrearAldeanoSinOroSuficiente() {

        Castillo unCastillo = new Castillo(null);
        unCastillo.crearArmaDeAsedio(10, null, null);
    }

    @Test
    public void testArmaDeAsedioCreadaConVidaCorrecta() {
        Mapa mapa = new Mapa(20, 20);

        Jugador unJugador = new Jugador(mapa, 15, 15, null);

        Castillo unCastillo = new Castillo(unJugador);

        Posicion posicionArmaDeAsedio = new Posicion(1, 1);

        ArmaDeAsedio unArmaDeAsedio = unCastillo.crearArmaDeAsedio(1000, unJugador, posicionArmaDeAsedio );
        assertEquals(150, unArmaDeAsedio.getVida());

    }


    @Test
    public void testCastilloAtacaAUnidadEnRango() {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 15, 15, null);
        Jugador otroJugador = new Jugador(mapa, 10, 10, null);
        otroJugador.nuevoTurno();

        Posicion posicionEspadachin = new Posicion(4,7);

        Castillo unCastillo = new Castillo(unJugador);
        otroJugador.crearEspadachin(new Cuartel(otroJugador), posicionEspadachin);

        Espadachin unEspadachin = (Espadachin) mapa.getContenido(4,7);

        mapa.colocarEstructuraEn(unCastillo, 0, 7, 4,1);
        unCastillo.atacar(mapa);

        assertEquals(80,  unEspadachin.getVida());

    }


    @Test
    public void testCastilloNoAtacaUnidadFueraDeRango() {
        Mapa mapa = new Mapa(30, 30);
        Jugador unJugador = new Jugador(mapa, 15, 15, null);
        Jugador otroJugador = new Jugador(mapa, 20, 20, null);
        otroJugador.nuevoTurno();

        Posicion posicionEspadachin = new Posicion(10,10);

        Castillo unCastillo = new Castillo(unJugador);
        otroJugador.crearEspadachin(new Cuartel(otroJugador), posicionEspadachin);

        Espadachin unEspadachin = (Espadachin) mapa.getContenido(10,10);

        mapa.colocarEstructuraEn(unCastillo, 0, 7, 4,1);
        unCastillo.atacar(mapa);

        assertEquals(100, unEspadachin.getVida());

    }

    @Test
    public void testCastilloNoAtacaUnidadDelMismoJugador() {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 15, 15, null);
        unJugador.nuevoTurno();

        Posicion posicionEspadachin = new Posicion(4,7);

        Castillo unCastillo = new Castillo(unJugador);
        unJugador.crearEspadachin(new Cuartel(unJugador), posicionEspadachin);

        Espadachin unEspadachin = (Espadachin) mapa.getContenido(4,7);

        mapa.colocarEstructuraEn(unCastillo, 0, 7, 4,1);
        unCastillo.atacar(mapa);

        assertEquals(100, unEspadachin.getVida());

    }

    @Test
    public void testCastilloMataUnidad()  {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 15, 15, null);
        Jugador otroJugador = new Jugador(mapa, 10, 10, null);


        Posicion posicionAldeano = new Posicion(4,7);
        otroJugador.crearAldeano(new PlazaCentral(otroJugador), posicionAldeano);

        Castillo unCastillo = new Castillo(unJugador);
        mapa.colocarEstructuraEn(unCastillo, 0, 7, 4,1);

        Aldeano unAldeano = (Aldeano) mapa.getContenido(4,7);

        unCastillo.atacar(mapa);
        unCastillo.atacar(mapa);
        unCastillo.atacar(mapa);

        assertEquals(-10, unAldeano.getVida());
        assertNull(mapa.getContenido(4, 7));

    }


    /*
    @Test
    public void testCastilloAtacaEstructuraEnRango() do, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(20,20);
        Jugador unJugador = new Jugador(mapa, 15 ,15, null );
        Jugador otroJugador = new Jugador(mapa, 10 ,10, null );

        Castillo unCastillo = new Castillo(unJugador);
        Espadachin unEspadachin = new Espadachin(otroJugador);

        mapa.colocarUnidadEn(unEspadachin,8,8);
        mapa.colocarEstructuraEn(unCastillo,0,7, 4);

        unCastillo.atacar(mapa);

        assertEquals(100, unEspadachin.getVida());


    }

    */


}