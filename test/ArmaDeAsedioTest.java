import Excepciones.*;
import espacio.Mapa;
import estructuras.Castillo;
import juego.Jugador;
import org.junit.Test;
import unidades.ArmaDeAsedio;

import static org.junit.Assert.assertEquals;

public class ArmaDeAsedioTest {

    @Test
    public void testArmaDeAsedioSeCreaCon150DeVida() {
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(null);

        assertEquals(150, unArmaDeAsedio.getVida());
    }


    @Test(expected = ContenibleFueraDeRango.class)
    public void testArmaDeAsedioNoAtacaArmaDeAsedioFueraDeRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, AsedioNoAtacaUnidad {
        Mapa mapa = new Mapa(10, 10);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(null);
        ArmaDeAsedio otroArmaDeAsedio = new ArmaDeAsedio(null);


        mapa.colocarUnidadEn(unArmaDeAsedio, 1, 1);
        mapa.colocarUnidadEn(otroArmaDeAsedio, 1, 9);

        unArmaDeAsedio.atacar(otroArmaDeAsedio);

    }


    @Test(expected = ContenibleDelMismoJugador.class)
    public void testArmaDeAsedioNoAtacaAUnidadCompaniera() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, AsedioNoAtacaUnidad {
        Mapa mapa = new Mapa(10, 10);
        Jugador jugador = new Jugador(mapa, 5, 5, null);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador);
        ArmaDeAsedio otroArmaDeAsedio = new ArmaDeAsedio(jugador);


        mapa.colocarUnidadEn(unArmaDeAsedio, 1, 1);
        mapa.colocarUnidadEn(otroArmaDeAsedio, 1, 2);

        unArmaDeAsedio.atacar(otroArmaDeAsedio);

        assertEquals(100, otroArmaDeAsedio.getVida());

    }

    @Test (expected = AsedioNoAtacaUnidad.class)
    public void testArmaDeAsedioNoAtacaUnidad() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, AsedioNoAtacaUnidad {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador);
        ArmaDeAsedio otroArmaDeAsedio = new ArmaDeAsedio(otroJugador);


        mapa.colocarUnidadEn(unArmaDeAsedio, 1, 1);
        mapa.colocarUnidadEn(otroArmaDeAsedio, 1, 2);

        unArmaDeAsedio.atacar(otroArmaDeAsedio);

        assertEquals(60, otroArmaDeAsedio.getVida());

    }

    @Test(expected = ContenibleFueraDeRango.class)
    public void testArmaDeAsedioNoAtacaEstructuraFueraDeRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, CasilleroOcupado, AsedioNoAtacaUnidad {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarUnidadEn(unArmaDeAsedio, 1, 1);
        mapa.colocarEstructuraEn(unCastillo, 1, 9, 4);

        unArmaDeAsedio.atacar(unCastillo);

        assertEquals(1000, unCastillo.getVida());

    }

    @Test
    public void testArmaDeAsedioAtacaEstructuraEnRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, AsedioNoAtacaUnidad {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(jugador);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarUnidadEn(unArmaDeAsedio, 0, 0);
        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4);

        unArmaDeAsedio.atacar(unCastillo);

        assertEquals(925, unCastillo.getVida());

    }

}
