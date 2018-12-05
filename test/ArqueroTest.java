import modelo.espacio.Mapa;
import modelo.estructuras.Castillo;
import modelo.estructuras.Cuartel;
import modelo.excepciones.*;
import modelo.juego.Jugador;
import modelo.unidades.Aldeano;
import modelo.unidades.Arquero;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ArqueroTest {

    @Test
    public void testArqueroSeCreaCon75DeVida() {
        Arquero unArquero = new Arquero(null);

        assertEquals(75, unArquero.getVida());
    }

    @Test(expected = ContenibleFueraDeRango.class)
    public void testArqueroAtacaArqueroFueraDeRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, ContenibleNoPropia, UnidadYaAtaco {
        Mapa mapa = new Mapa(10, 10);
        Jugador jugador = new Jugador(mapa, 5, 5, null);

        Arquero unArquero = new Arquero(jugador);
        Arquero otroArquero = new Arquero(null);


        mapa.colocarUnidadEn(unArquero, 1, 1);
        mapa.colocarUnidadEn(otroArquero, 1, 9);

        unArquero.atacar(otroArquero, jugador);


    }


    @Test(expected = ContenibleDelMismoJugador.class)
    public void testArqueroNoAtacaAUnidadCompaniera() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, ContenibleNoPropia, UnidadYaAtaco {
        Mapa mapa = new Mapa(10, 10);
        Jugador jugador = new Jugador(mapa, 5, 5, null);

        Arquero unArquero = new Arquero(jugador);
        Arquero otroArquero = new Arquero(jugador);


        mapa.colocarUnidadEn(unArquero, 1, 1);
        mapa.colocarUnidadEn(otroArquero, 1, 2);

        unArquero.atacar(otroArquero, jugador);

        assertEquals(100, otroArquero.getVida());

    }

    @Test
    public void testArqueroAtacaArqueroEnRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, ContenibleNoPropia, UnidadYaAtaco {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Arquero unArquero = new Arquero(jugador);
        Arquero otroArquero = new Arquero(otroJugador);


        mapa.colocarUnidadEn(unArquero, 1, 1);
        mapa.colocarUnidadEn(otroArquero, 1, 2);

        unArquero.atacar(otroArquero, jugador);

        assertEquals(60, otroArquero.getVida());

    }

    @Test(expected = ContenibleFueraDeRango.class)
    public void testArqueroAtacaEstructuraFueraDeRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, ContenibleNoPropia, UnidadYaAtaco {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Arquero unArquero = new Arquero(jugador);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarUnidadEn(unArquero, 1, 1);
        mapa.colocarEstructuraEn(unCastillo, 1, 9, 4);

        unArquero.atacar(unCastillo, jugador);

        assertEquals(1000, unCastillo.getVida());

    }

    @Test
    public void testArqueroAtacaEstructuraEnRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, ContenibleNoPropia, UnidadYaAtaco {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Arquero unArquero = new Arquero(jugador);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarUnidadEn(unArquero, 0, 0);
        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4);

        unArquero.atacar(unCastillo, jugador);

        assertEquals(990, unCastillo.getVida());


    }

    @Test
    public void testArqueroMataUnidad() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, ContenibleNoPropia, UnidadYaAtaco, ArmaYaCargada {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Arquero unArquero = new Arquero(jugador);
        Aldeano unAldeano = new Aldeano(otroJugador);


        mapa.colocarUnidadEn(unArquero, 0, 0);
        mapa.colocarUnidadEn(unAldeano, 1, 1);

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
    public void testArqueroMataEstructura() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador, ContenibleNoPropia, UnidadYaAtaco, ArmaYaCargada {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 14, 14, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Arquero unArquero = new Arquero(jugador);
        Cuartel unCuartel = new Cuartel(otroJugador);


        mapa.colocarUnidadEn(unArquero, 0, 0);
        mapa.colocarEstructuraEn(unCuartel, 1, 1, 2);


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
