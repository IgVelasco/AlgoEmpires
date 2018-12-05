import modelo.espacio.Mapa;
import modelo.estructuras.Castillo;
import modelo.excepciones.*;
import modelo.juego.Jugador;
import modelo.unidades.Aldeano;
import modelo.unidades.Espadachin;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class EspadachinTest {

    @Test
    public void testEspadachinSeCreaCon100DeVida() {
        Espadachin unEspadachin = new Espadachin(null);

        assertEquals(100, unEspadachin.getVida());
    }

    @Test(expected = ContenibleFueraDeRango.class)
    public void testEspadachinAtacaEspadachinFueraDeRango() {
        Mapa mapa = new Mapa(10, 10);
        Jugador jugador = new Jugador(mapa, 5, 5, null);

        Espadachin unEspadachin = new Espadachin(jugador);
        Espadachin otroEspadachin = new Espadachin(null);


        mapa.colocarUnidadEn(unEspadachin, 1, 1);
        mapa.colocarUnidadEn(otroEspadachin, 1, 9);

        unEspadachin.atacar(otroEspadachin, jugador);
    }


    @Test(expected = ContenibleDelMismoJugador.class)
    public void testEspadachinNoAtacaAUnidadCompaniera() {
        Mapa mapa = new Mapa(10, 10);
        Jugador jugador = new Jugador(mapa, 5, 5, null);

        Espadachin unEspadachin = new Espadachin(jugador);
        Espadachin otroEspadachin = new Espadachin(jugador);


        mapa.colocarUnidadEn(unEspadachin, 1, 1);
        mapa.colocarUnidadEn(otroEspadachin, 1, 2);

        unEspadachin.atacar(otroEspadachin, jugador);

        assertEquals(100, otroEspadachin.getVida());

    }

    @Test
    public void testEspadachinAtacaEspadachinEnRango() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Espadachin unEspadachin = new Espadachin(jugador);
        Espadachin otroEspadachin = new Espadachin(otroJugador);


        mapa.colocarUnidadEn(unEspadachin, 1, 1);
        mapa.colocarUnidadEn(otroEspadachin, 1, 2);

        unEspadachin.atacar(otroEspadachin, jugador);

        assertEquals(75, otroEspadachin.getVida());

    }

    @Test(expected = ContenibleFueraDeRango.class)
    public void testEspadachinAtacaEstructuraFueraDeRango() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Espadachin unEspadachin = new Espadachin(jugador);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarUnidadEn(unEspadachin, 1, 1);
        mapa.colocarEstructuraEn(unCastillo, 1, 9, 4);

        unEspadachin.atacar(unCastillo, jugador);

        assertEquals(1000, unCastillo.getVida());

    }

    @Test
    public void testEspadachinAtacaEstructuraEnRango() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Espadachin unEspadachin = new Espadachin(jugador);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarUnidadEn(unEspadachin, 0, 0);
        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4);

        unEspadachin.atacar(unCastillo, jugador);

        assertEquals(985, unCastillo.getVida());


    }

    @Test
    public void testEspadachinMataUnidad() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 6, 6, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Espadachin unEspadachin = new Espadachin(jugador);
        Aldeano unAldeano = new Aldeano(otroJugador);


        mapa.colocarUnidadEn(unEspadachin, 1, 1);
        mapa.colocarUnidadEn(unAldeano, 0, 0);

        unEspadachin.atacar(unAldeano, jugador);
        jugador.nuevoTurno();
        unEspadachin.atacar(unAldeano, jugador);

        assertEquals(0, unAldeano.getVida());
        assertNull(mapa.getContenido(0, 0));

    }


    @Test (expected = UnidadYaAtaco.class)
    public void testEspadachinNoPuedeAtacarDosVecesEnUnTurno() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 6, 6, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Espadachin unEspadachin = new Espadachin(jugador);
        Aldeano unAldeano = new Aldeano(otroJugador);


        mapa.colocarUnidadEn(unEspadachin, 1, 1);
        mapa.colocarUnidadEn(unAldeano, 0, 0);

        unEspadachin.atacar(unAldeano, jugador);
        unEspadachin.atacar(unAldeano, jugador);
    }


}
