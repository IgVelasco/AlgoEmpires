import modelo.espacio.Mapa;
import modelo.estructuras.Castillo;
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

        unCastillo.crearArmaDeAsedio(10, null);
    }

    @Test
    public void testArmaDeAsedioCreadaConVidaCorrecta() {
        Mapa mapa = new Mapa(20, 20);

        Jugador unJugador = new Jugador(mapa, 15, 15, null);

        Castillo unCastillo = new Castillo(unJugador);

        ArmaDeAsedio unArmaDeAsedio = unCastillo.crearArmaDeAsedio(1000, unJugador);
        assertEquals(150, unArmaDeAsedio.getVida());

    }


    @Test
    public void testCastilloAtacaAUnidadEnRango() {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 15, 15, null);
        Jugador otroJugador = new Jugador(mapa, 10, 10, null);

        Castillo unCastillo = new Castillo(unJugador);
        Espadachin unEspadachin = new Espadachin(otroJugador);

        mapa.colocarUnidadEn(unEspadachin, 4, 7);
        mapa.colocarEstructuraEn(unCastillo, 0, 7, 4,1);

        unCastillo.atacar(mapa);

        assertEquals(80, unEspadachin.getVida());

    }


    @Test
    public void testCastilloNoAtacaUnidadFueraDeRango() {
        Mapa mapa = new Mapa(30, 30);
        Jugador unJugador = new Jugador(mapa, 15, 15, null);
        Jugador otroJugador = new Jugador(mapa, 20, 20, null);

        Castillo unCastillo = new Castillo(unJugador);
        Espadachin unEspadachin = new Espadachin(otroJugador);

        mapa.colocarUnidadEn(unEspadachin, 10, 10);
        mapa.colocarEstructuraEn(unCastillo, 0, 7, 4,1);

        unCastillo.atacar(mapa);

        assertEquals(100, unEspadachin.getVida());

    }

    @Test
    public void testCastilloNoAtacaUnidadDelMismoJugador() {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 15, 15, null);

        Castillo unCastillo = new Castillo(unJugador);
        Espadachin unEspadachin = new Espadachin(unJugador);

        mapa.colocarUnidadEn(unEspadachin, 5, 7);
        mapa.colocarEstructuraEn(unCastillo, 0, 7, 4,1);

        unCastillo.atacar(mapa);

        assertEquals(100, unEspadachin.getVida());

    }

    @Test
    public void testCastilloMataUnidad()  {
        Mapa mapa = new Mapa(20, 20);
        Jugador unJugador = new Jugador(mapa, 15, 15, null);
        Jugador otroJugador = new Jugador(mapa, 10, 10, null);

        Castillo unCastillo = new Castillo(unJugador);
        Aldeano unAldeano = new Aldeano(otroJugador);

        mapa.colocarUnidadEn(unAldeano, 4, 7);
        mapa.colocarEstructuraEn(unCastillo, 0, 7, 4,1);

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