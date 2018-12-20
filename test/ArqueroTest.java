import modelo.espacio.Mapa;
import modelo.espacio.Posicion;
import modelo.estructuras.Castillo;
import modelo.estructuras.Cuartel;
import modelo.excepciones.*;
import modelo.juego.Jugador;
import modelo.unidades.Aldeano;
import modelo.unidades.Arquero;
import modelo.unidades.Espadachin;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ArqueroTest {

    @Test
    public void testArqueroSeCreaCon75DeVida() {
        Arquero unArquero = new Arquero(null, null);

        assertEquals(75, unArquero.getVida());
    }

    @Test(expected = ContenibleFueraDeRango.class)
    public void testArqueroAtacaArqueroFueraDeRango() {
        Mapa mapa = new Mapa(10, 10);
        Jugador jugador = new Jugador(mapa, 5, 5, null);

        Posicion posicionArquero = new Posicion(1, 1);
        Posicion posicionOtroArquero = new Posicion(1, 9);

        Arquero unArquero  = new Arquero(jugador, posicionArquero);
        Arquero otroArquero = new Arquero(null, posicionOtroArquero);

        unArquero.atacar(otroArquero, jugador);


    }


    @Test(expected = ContenibleDelMismoJugador.class)
    public void testArqueroNoAtacaAUnidadCompaniera() {
        Mapa mapa = new Mapa(10, 10);
        Jugador jugador = new Jugador(mapa, 5, 5, null);

        Posicion posicionArquero = new Posicion(1, 1);
        Posicion posicionOtroArquero = new Posicion(1, 3);

        Arquero unArquero  = new Arquero(jugador, posicionArquero);
        Arquero otroArquero = new Arquero(jugador, posicionOtroArquero);

        unArquero.atacar(otroArquero, jugador);

        assertEquals(100, otroArquero.getVida());

    }

    @Test
    public void testArqueroAtacaArqueroEnRango() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Posicion posicionArquero = new Posicion(1, 1);
        Posicion posicionOtroArquero = new Posicion(1, 2);

        Arquero unArquero  = new Arquero(jugador, posicionArquero);
        Arquero otroArquero = new Arquero(null, posicionOtroArquero);

        unArquero.atacar(otroArquero, jugador);

        assertEquals(60, otroArquero.getVida());

    }

    @Test(expected = ContenibleFueraDeRango.class)
    public void testArqueroAtacaEstructuraFueraDeRango() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Posicion posicionArquero = new Posicion(1, 1);


        Arquero unArquero  = new Arquero(jugador, posicionArquero);
        Castillo unCastillo = new Castillo(otroJugador);

        mapa.colocarEstructuraEn(unCastillo, 1, 9, 4,1);

        unArquero.atacar(unCastillo, jugador);

        assertEquals(1000, unCastillo.getVida());

    }

    @Test
    public void testArqueroAtacaEstructuraEnRango() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Posicion posicionArquero = new Posicion(0, 0);


        Arquero unArquero  = new Arquero(jugador, posicionArquero);
        Castillo unCastillo = new Castillo(otroJugador);

        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4,1);

        unArquero.atacar(unCastillo, jugador);

        assertEquals(990, unCastillo.getVida());


    }

    @Test
    public void testArqueroMataUnidad() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 7, 7, null);
        Jugador otroJugador = new Jugador(mapa, 14, 5, null);

        Posicion posicionArquero = new Posicion(0, 0);
        Posicion posicionAldeano = new Posicion(0, 0);

        Arquero unArquero  = new Arquero(jugador, posicionArquero);
        Aldeano unAldeano = new Aldeano(otroJugador, posicionAldeano);

        unArquero.atacar(unAldeano, jugador);
        jugador.nuevoTurno();
        unArquero.atacar(unAldeano, jugador);
        jugador.nuevoTurno();
        unArquero.atacar(unAldeano, jugador);
        jugador.nuevoTurno();
        unArquero.atacar(unAldeano, jugador);

        assertEquals(-10, unAldeano.getVida());
        assertNull(mapa.getContenido(1, 1));

    }

    @Test
    public void testArqueroMataEstructura() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 14, 14, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Posicion posicionArquero = new Posicion(0, 0);

        Arquero unArquero = new Arquero(jugador, posicionArquero);
        Cuartel unCuartel = new Cuartel(otroJugador);

        mapa.colocarEstructuraEn(unCuartel, 1, 1, 2,1);


        for (int x = 0; x<25 ;x++) {
            unArquero.atacar(unCuartel, jugador);
            jugador.nuevoTurno();
        }
        assertEquals(0, unCuartel.getVida());
        assertNull(mapa.getContenido(1, 1));
        assertNull(mapa.getContenido(1, 2));
        assertNull(mapa.getContenido(2, 1));
        assertNull(mapa.getContenido(2, 2));

    }


}
