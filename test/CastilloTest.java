import Excepciones.*;
import contenibles.Contenible;
import espacio.Mapa;
import estructuras.Castillo;
import juego.Jugador;
import org.junit.Test;
import unidades.ArmaDeAsedio;
import unidades.Espadachin;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CastilloTest {

    @Test
    public void testCastilloSeCreaCon1000DeVida() {
        Castillo unCastillo = new Castillo(null);

        assertEquals(1000, unCastillo.getVida());
    }

    @Test(expected = OroInsuficiente.class)
    public void testNoCrearAldeanoSinOroSuficiente() throws OroInsuficiente, PoblacionLimiteAlcanzada {
        Castillo unCastillo = new Castillo(null);

        unCastillo.crearArmaDeAsedio(10);
    }



    @Test
    public void testCastilloAtacaAUnidadEnRango() throws  CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(20,20);
        Jugador unJugador = new Jugador(mapa, 15 ,15, null );
        Jugador otroJugador = new Jugador(mapa, 10 ,10, null );

        Castillo unCastillo = new Castillo(unJugador);
        Espadachin unEspadachin = new Espadachin(otroJugador);

        mapa.colocarUnidadEn(unEspadachin,4,7);
        mapa.colocarEstructuraEn(unCastillo,0,7, 4);

        unCastillo.atacar(mapa);

        assertEquals(80, unEspadachin.getVida());

    }


    @Test
    public void testCastilloNoAtacaUnidadFueraDeRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, CasilleroOcupado, ExcedeLimiteDelMapa {
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

    @Test
    public void testCastilloNoAtacaUnidadDelMismoJugador() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa(20,20);
        Jugador unJugador = new Jugador(mapa, 15 ,15, null );

        Castillo unCastillo = new Castillo(unJugador);
        Espadachin unEspadachin = new Espadachin(unJugador);

        mapa.colocarUnidadEn(unEspadachin,5,7);
        mapa.colocarEstructuraEn(unCastillo,0,7, 4);

        unCastillo.atacar(mapa);

        assertEquals(100, unEspadachin.getVida());

    }


    /*
    @Test
    public void testCastilloAtacaEstructuraEnRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, CasilleroOcupado, ExcedeLimiteDelMapa {
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