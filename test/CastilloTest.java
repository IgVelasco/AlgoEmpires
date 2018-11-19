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

    @Test
    public void testCrearArmaDeAsedioDevuelveUnaUnidadDelTipoArmaDeAsedio() throws OroInsuficiente {
        Castillo unCastillo = new Castillo(null);
        Contenible unaUnidad = unCastillo.crearArmaDeAsedio(200);

        assertThat(unaUnidad, instanceOf(ArmaDeAsedio.class));
    }

    @Test(expected = OroInsuficiente.class)
    public void testNoCrearAldeanoSinOroSuficiente() throws OroInsuficiente {
        Castillo unCastillo = new Castillo(null);

        unCastillo.crearArmaDeAsedio(10);
    }


/*
    @Test(expected = ContenibleDelMismoJugador.class)
    public void testCastilloNoAtacaAUnidadCompaniera() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador(mapa, 5 ,5, null );

        Castillo unCastillo = new Castillo(jugador);
        Castillo otroCastillo = new Castillo(jugador);



        mapa.colocarUnidadEn(unCastillo,1,1);
        mapa.colocarUnidadEn(otroCastillo,1,2);

        unCastillo.atacar(otroCastillo);

        assertEquals(100, otroCastillo.getVida());

    }

    @Test
    public void testCastilloAtacaCastilloEnRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador(mapa, 5 ,5, null );
        Jugador otroJugador = new Jugador(mapa, 13 ,5, null );

        Castillo unCastillo = new Castillo(jugador);
        Castillo otroCastillo = new Castillo(otroJugador);



        mapa.colocarUnidadEn(unCastillo,1,1);
        mapa.colocarUnidadEn(otroCastillo,1,2);

        unCastillo.atacar(otroCastillo);

        assertEquals(75, otroCastillo.getVida());

    }

    @Test(expected = ContenibleFueraDeRango.class)
    public void testCastilloAtacaEstructuraFueraDeRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador(mapa, 5 ,5, null );
        Jugador otroJugador = new Jugador(mapa, 13 ,5, null );

        Castillo unCastillo = new Castillo(jugador);
        Castillo otroCastillo = new Castillo(otroJugador);



        mapa.colocarUnidadEn(unCastillo,1,1);
        mapa.colocarUnidadEn(unCastillo,1,9);

        unCastillo.atacar(unCastillo);

        assertEquals(1000 ,unCastillo.getVida());

    }

    @Test
    public void testCastilloAtacaEstructuraEnRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador(mapa, 5 ,5, null );
        Jugador otroJugador = new Jugador(mapa, 13 ,5, null );

        Castillo unCastillo = new Castillo(jugador);
        Espadachin unEspadachin = new Espadachin(otroJugador);


        mapa.colocarUnidadEn(unCastillo,0,0);
        mapa.colocarUnidadEn(unEspadachin,1,1);

        unCastillo.atacar(unCastillo);

        assertEquals(985 ,unCastillo.getVida());


    }
*/

}