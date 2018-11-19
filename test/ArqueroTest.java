import Excepciones.*;
import espacio.Mapa;
import estructuras.Castillo;
import juego.Jugador;
import unidades.Arquero;
import unidades.Arquero;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArqueroTest {

    @Test
    public void testArqueroSeCreaCon75DeVida() {
        Arquero unArquero = new Arquero(null);

        assertEquals(75, unArquero.getVida());
    }
    @Test
    public void testArqueroMoverHorizontalmenteLoRealizaCorrectamente() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Arquero unArquero = new Arquero(null);

        mapa.colocarUnidadEn(unArquero,0,0);
        unArquero.moverDerecha(mapa);
        assertEquals(unArquero, mapa.getContenido(1,0));
    }

    @Test
    public void testArqueroMoverseHorizontalmenteActualizaPosicion() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Arquero unArquero = new Arquero(null);

        mapa.colocarUnidadEn(unArquero,1,1);
        unArquero.moverIzquierda(mapa);
        assertEquals(0, unArquero.getPosicionHorizontal());
    }

    @Test
    public void testArqueroMoverEnVerticalLoRealizaCorrectamente() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Arquero unArquero = new Arquero(null);

        mapa.colocarUnidadEn(unArquero,1,1);
        unArquero.moverArriba(mapa);
        assertEquals(unArquero, mapa.getContenido(1,2));
    }

    @Test
    public void testArqueroMoverVerticalActualizaPosicion() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Arquero unArquero = new Arquero(null);

        mapa.colocarUnidadEn(unArquero,1,1);
        unArquero.moverAbajo(mapa);
        assertEquals(0, unArquero.getPosicionVertical());
    }

    @Test
    public void testArqueroMoverseDiagonalLoRealizaCorrectamente() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Arquero unArquero = new Arquero(null);

        mapa.colocarUnidadEn(unArquero,1,1);
        unArquero.moverDerechaSuperior(mapa);
        assertEquals(unArquero, mapa.getContenido(2,2));
    }

    @Test
    public void testArqueroMoverseDiagonalActualizaPosicion() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Arquero unArquero = new Arquero(null);

        mapa.colocarUnidadEn(unArquero,1,1);
        unArquero.moverIzquierdaInferior(mapa);
        assertEquals(0, unArquero.getPosicionHorizontal());
        assertEquals(0,unArquero.getPosicionVertical());
    }

    @Test(expected = ContenibleFueraDeRango.class)
    public void testArqueroAtacaArqueroFueraDeRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa(10,10);

        Arquero unArquero = new Arquero(null);
        Arquero otroArquero = new Arquero(null);



        mapa.colocarUnidadEn(unArquero,1,1);
        mapa.colocarUnidadEn(otroArquero,1,9);

        unArquero.atacar(otroArquero);



    }



    @Test(expected = ContenibleDelMismoJugador.class)
    public void testArqueroNoAtacaAUnidadCompaniera() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador(mapa, 5 ,5, null );

        Arquero unArquero = new Arquero(jugador);
        Arquero otroArquero = new Arquero(jugador);



        mapa.colocarUnidadEn(unArquero,1,1);
        mapa.colocarUnidadEn(otroArquero,1,2);

        unArquero.atacar(otroArquero);

        assertEquals(100, otroArquero.getVida());

    }

    @Test
    public void testArqueroAtacaArqueroEnRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador(mapa, 5 ,5, null );
        Jugador otroJugador = new Jugador(mapa, 13 ,5, null );

        Arquero unArquero = new Arquero(jugador);
        Arquero otroArquero = new Arquero(otroJugador);



        mapa.colocarUnidadEn(unArquero,1,1);
        mapa.colocarUnidadEn(otroArquero,1,2);

        unArquero.atacar(otroArquero);

        assertEquals(60, otroArquero.getVida());

    }

    @Test(expected = ContenibleFueraDeRango.class)
    public void testArqueroAtacaEstructuraFueraDeRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador(mapa, 5 ,5, null );
        Jugador otroJugador = new Jugador(mapa, 13 ,5, null );

        Arquero unArquero = new Arquero(jugador);
        Castillo unCastillo = new Castillo(otroJugador);



        mapa.colocarUnidadEn(unArquero,1,1);
        mapa.colocarUnidadEn(unCastillo,1,9);

        unArquero.atacar(unCastillo);

        assertEquals(1000 ,unCastillo.getVida());

    }

    @Test
    public void testArqueroAtacaEstructuraEnRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador(mapa, 5 ,5, null );
        Jugador otroJugador = new Jugador(mapa, 13 ,5, null );

        Arquero unArquero = new Arquero(jugador);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarUnidadEn(unArquero,0,0);
        mapa.colocarUnidadEn(unCastillo,1,1);

        unArquero.atacar(unCastillo);

        assertEquals(990 ,unCastillo.getVida());


    }



}
