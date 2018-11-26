import modelo.espacio.Mapa;
import modelo.estructuras.Castillo;
import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.ContenibleDelMismoJugador;
import modelo.excepciones.ContenibleFueraDeRango;
import modelo.excepciones.ExcedeLimiteDelMapa;
import modelo.juego.Jugador;
import modelo.unidades.Espadachin;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EspadachinTest {

    @Test
    public void testEspadachinSeCreaCon100DeVida() {
        Espadachin unEspadachin = new Espadachin(null);

        assertEquals(100, unEspadachin.getVida());
    }

    @Test(expected = ContenibleFueraDeRango.class)
    public void testEspadachinAtacaEspadachinFueraDeRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa(10, 10);

        Espadachin unEspadachin = new Espadachin(null);
        Espadachin otroEspadachin = new Espadachin(null);


        mapa.colocarUnidadEn(unEspadachin, 1, 1);
        mapa.colocarUnidadEn(otroEspadachin, 1, 9);

        unEspadachin.atacar(otroEspadachin);


    }


    @Test(expected = ContenibleDelMismoJugador.class)
    public void testEspadachinNoAtacaAUnidadCompaniera() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa(10, 10);
        Jugador jugador = new Jugador(mapa, 5, 5, null);

        Espadachin unEspadachin = new Espadachin(jugador);
        Espadachin otroEspadachin = new Espadachin(jugador);


        mapa.colocarUnidadEn(unEspadachin, 1, 1);
        mapa.colocarUnidadEn(otroEspadachin, 1, 2);

        unEspadachin.atacar(otroEspadachin);

        assertEquals(100, otroEspadachin.getVida());

    }

    @Test
    public void testEspadachinAtacaEspadachinEnRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Espadachin unEspadachin = new Espadachin(jugador);
        Espadachin otroEspadachin = new Espadachin(otroJugador);


        mapa.colocarUnidadEn(unEspadachin, 1, 1);
        mapa.colocarUnidadEn(otroEspadachin, 1, 2);

        unEspadachin.atacar(otroEspadachin);

        assertEquals(75, otroEspadachin.getVida());

    }

    @Test(expected = ContenibleFueraDeRango.class)
    public void testEspadachinAtacaEstructuraFueraDeRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Espadachin unEspadachin = new Espadachin(jugador);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarUnidadEn(unEspadachin, 1, 1);
        mapa.colocarEstructuraEn(unCastillo, 1, 9, 4);

        unEspadachin.atacar(unCastillo);

        assertEquals(1000, unCastillo.getVida());

    }

    @Test
    public void testEspadachinAtacaEstructuraEnRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Espadachin unEspadachin = new Espadachin(jugador);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarUnidadEn(unEspadachin, 0, 0);
        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4);

        unEspadachin.atacar(unCastillo);

        assertEquals(985, unCastillo.getVida());


    }


}
