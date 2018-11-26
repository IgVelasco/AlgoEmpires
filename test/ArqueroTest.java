import modelo.espacio.Mapa;
import modelo.estructuras.Castillo;
import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.ContenibleDelMismoJugador;
import modelo.excepciones.ContenibleFueraDeRango;
import modelo.excepciones.ExcedeLimiteDelMapa;
import modelo.juego.Jugador;
import modelo.unidades.Arquero;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArqueroTest {

    @Test
    public void testArqueroSeCreaCon75DeVida() {
        Arquero unArquero = new Arquero(null);

        assertEquals(75, unArquero.getVida());
    }

    @Test(expected = ContenibleFueraDeRango.class)
    public void testArqueroAtacaArqueroFueraDeRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa(10, 10);

        Arquero unArquero = new Arquero(null);
        Arquero otroArquero = new Arquero(null);


        mapa.colocarUnidadEn(unArquero, 1, 1);
        mapa.colocarUnidadEn(otroArquero, 1, 9);

        unArquero.atacar(otroArquero);


    }


    @Test(expected = ContenibleDelMismoJugador.class)
    public void testArqueroNoAtacaAUnidadCompaniera() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa(10, 10);
        Jugador jugador = new Jugador(mapa, 5, 5, null);

        Arquero unArquero = new Arquero(jugador);
        Arquero otroArquero = new Arquero(jugador);


        mapa.colocarUnidadEn(unArquero, 1, 1);
        mapa.colocarUnidadEn(otroArquero, 1, 2);

        unArquero.atacar(otroArquero);

        assertEquals(100, otroArquero.getVida());

    }

    @Test
    public void testArqueroAtacaArqueroEnRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Arquero unArquero = new Arquero(jugador);
        Arquero otroArquero = new Arquero(otroJugador);


        mapa.colocarUnidadEn(unArquero, 1, 1);
        mapa.colocarUnidadEn(otroArquero, 1, 2);

        unArquero.atacar(otroArquero);

        assertEquals(60, otroArquero.getVida());

    }

    @Test(expected = ContenibleFueraDeRango.class)
    public void testArqueroAtacaEstructuraFueraDeRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Arquero unArquero = new Arquero(jugador);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarUnidadEn(unArquero, 1, 1);
        mapa.colocarEstructuraEn(unCastillo, 1, 9, 4);

        unArquero.atacar(unCastillo);

        assertEquals(1000, unCastillo.getVida());

    }

    @Test
    public void testArqueroAtacaEstructuraEnRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador(mapa, 5, 5, null);
        Jugador otroJugador = new Jugador(mapa, 13, 5, null);

        Arquero unArquero = new Arquero(jugador);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarUnidadEn(unArquero, 0, 0);
        mapa.colocarEstructuraEn(unCastillo, 1, 1, 4);

        unArquero.atacar(unCastillo);

        assertEquals(990, unCastillo.getVida());


    }


}
