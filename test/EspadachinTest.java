import modelo.espacio.Mapa;
import modelo.espacio.Posicion;
import modelo.estructuras.Castillo;
import modelo.excepciones.ContenibleDelMismoJugador;
import modelo.excepciones.ContenibleFueraDeRango;
import modelo.excepciones.UnidadYaAtaco;
import modelo.juego.Jugador;
import modelo.unidades.Aldeano;
import modelo.unidades.Espadachin;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EspadachinTest {

    @Test
    public void testEspadachinSeCreaCon100DeVida() {
        Espadachin unEspadachin = new Espadachin(null, null);

        assertEquals(100, unEspadachin.getVida());
    }

    @Test(expected = ContenibleFueraDeRango.class)
    public void testEspadachinAtacaEspadachinFueraDeRango() {
        Mapa mapa = new Mapa(10, 10);
        Jugador jugador = new Jugador(mapa, 5, 5, null);

        Posicion posicionEspadachin = new Posicion(1, 1);
        Posicion posicionOtroEspadachin = new Posicion(1, 9);

        Espadachin unEspadachin = new Espadachin(jugador, posicionEspadachin);
        Espadachin otroEspadachin = new Espadachin(null, posicionOtroEspadachin);

        unEspadachin.atacar(otroEspadachin, jugador);
    }


    @Test(expected = ContenibleDelMismoJugador.class)
    public void testEspadachinNoAtacaAUnidadCompaniera() {
        Mapa mapa = new Mapa(10, 10);
        Jugador jugador = new Jugador(mapa, 5, 5, null);

        Posicion posicionEspadachin = new Posicion(1, 1);
        Posicion posicionOtroEspadachin = new Posicion(1, 2);

        Espadachin unEspadachin = new Espadachin(jugador, posicionEspadachin);
        Espadachin otroEspadachin = new Espadachin(jugador, posicionOtroEspadachin);

        unEspadachin.atacar(otroEspadachin, jugador);

        assertEquals(100, otroEspadachin.getVida());

    }

    @Test
    public void testEspadachinAtacaEspadachinEnRango() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Posicion posicionEspadachin = new Posicion(1, 1);
        Posicion posicionOtroEspadachin = new Posicion(1, 2);

        Espadachin unEspadachin = new Espadachin(jugador, posicionEspadachin);
        Espadachin otroEspadachin = new Espadachin(otroJugador, posicionOtroEspadachin);

        unEspadachin.atacar(otroEspadachin, jugador);

        assertEquals(75, otroEspadachin.getVida());

    }

    @Test(expected = ContenibleFueraDeRango.class)
    public void testEspadachinAtacaEstructuraFueraDeRango() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);


        Posicion posicionEspadachin = new Posicion(1, 1);
        Espadachin unEspadachin = new Espadachin(jugador, posicionEspadachin);
        Castillo unCastillo = new Castillo(otroJugador);

        mapa.colocarEstructuraEn(unCastillo, 1, 9, 4,1);

        unEspadachin.atacar(unCastillo, jugador);

        assertEquals(1000, unCastillo.getVida());

    }

    @Test
    public void testEspadachinAtacaEstructuraEnRango() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Posicion posicionEspadachin = new Posicion(0, 0);
        Espadachin unEspadachin = new Espadachin(jugador, posicionEspadachin);
        Castillo unCastillo = new Castillo(otroJugador);

        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4,1);

        unEspadachin.atacar(unCastillo, jugador);

        assertEquals(985, unCastillo.getVida());


    }

    @Test
    public void testEspadachinMataUnidad() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 6, 6, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);


        Posicion posicionEspadachin = new Posicion(1, 1);
        Posicion posicionAldeano = new Posicion(0,0);

        Espadachin unEspadachin = new Espadachin(jugador, posicionEspadachin);
        Aldeano unAldeano = new Aldeano(otroJugador, posicionAldeano);

        unEspadachin.atacar(unAldeano, jugador);
        jugador.nuevoTurno();
        unEspadachin.atacar(unAldeano, jugador);

        assertEquals(0, unAldeano.getVida());
    }


    @Test (expected = UnidadYaAtaco.class)
    public void testEspadachinNoPuedeAtacarDosVecesEnUnTurno() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 6, 6, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Posicion posicionEspadachin = new Posicion(1, 1);
        Posicion posicionAldeano = new Posicion(0,0);

        Espadachin unEspadachin = new Espadachin(jugador, posicionEspadachin);
        Aldeano unAldeano = new Aldeano(otroJugador, posicionAldeano);

        unEspadachin.atacar(unAldeano, jugador);
        unEspadachin.atacar(unAldeano, jugador);
    }


}
