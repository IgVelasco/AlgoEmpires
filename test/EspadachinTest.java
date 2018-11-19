import Excepciones.*;
import contenibles.Contenible;
import espacio.Mapa;
import estructuras.Castillo;
import juego.Jugador;
import unidades.Espadachin;
import unidades.Espadachin;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EspadachinTest {

    @Test
    public void testEspadachinSeCreaCon100DeVida() {
        Espadachin unEspadachin = new Espadachin(null);

        assertEquals(100, unEspadachin.getVida());
    }
    @Test
    public void testEspadachinMoverHorizontalmenteLoRealizaCorrectamente() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Espadachin unEspadachin = new Espadachin(null);

        mapa.colocarUnidadEn(unEspadachin,0,0);
        unEspadachin.moverDerecha(mapa);
        assertEquals(unEspadachin, mapa.getContenido(1,0));
    }

    @Test
    public void testEspadachinMoverseHorizontalmenteActualizaPosicion() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Espadachin unEspadachin = new Espadachin(null);

        mapa.colocarUnidadEn(unEspadachin,1,1);
        unEspadachin.moverIzquierda(mapa);
        assertEquals(0, unEspadachin.getPosicionHorizontal());
    }

    @Test
    public void testEspadachinMoverEnVerticalLoRealizaCorrectamente() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Espadachin unEspadachin = new Espadachin(null);

        mapa.colocarUnidadEn(unEspadachin,1,1);
        unEspadachin.moverArriba(mapa);
        assertEquals(unEspadachin, mapa.getContenido(1,2));
    }

    @Test
    public void testEspadachinMoverVerticalActualizaPosicion() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Espadachin unEspadachin = new Espadachin(null);

        mapa.colocarUnidadEn(unEspadachin,1,1);
        unEspadachin.moverAbajo(mapa);
        assertEquals(0, unEspadachin.getPosicionVertical());
    }

    @Test
    public void testEspadachinMoverseDiagonalLoRealizaCorrectamente() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Espadachin unEspadachin = new Espadachin(null);

        mapa.colocarUnidadEn(unEspadachin,1,1);
        unEspadachin.moverDerechaSuperior(mapa);
        assertEquals(unEspadachin, mapa.getContenido(2,2));
    }


    @Test
    public void testEspadachinMoverseDiagonalActualizaPosicion() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Espadachin unEspadachin = new Espadachin(null);

        mapa.colocarUnidadEn(unEspadachin,1,1);
        unEspadachin.moverIzquierdaInferior(mapa);
        assertEquals(0, unEspadachin.getPosicionHorizontal());
        assertEquals(0,unEspadachin.getPosicionVertical());
    }


    @Test(expected = ContenibleFueraDeRango.class)
    public void testEspadachinAtacaEspadachinFueraDeRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa(10,10);

        Espadachin unEspadachin = new Espadachin(null);
        Espadachin otroEspadachin = new Espadachin(null);



        mapa.colocarUnidadEn(unEspadachin,1,1);
        mapa.colocarUnidadEn(otroEspadachin,1,9);

        unEspadachin.atacar(otroEspadachin);



    }


    @Test(expected = ContenibleDelMismoJugador.class)
    public void testEspadachinNoAtacaAUnidadCompaniera() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador(mapa, 5 ,5, null );

        Espadachin unEspadachin = new Espadachin(jugador);
        Espadachin otroEspadachin = new Espadachin(jugador);



        mapa.colocarUnidadEn(unEspadachin,1,1);
        mapa.colocarUnidadEn(otroEspadachin,1,2);

        unEspadachin.atacar(otroEspadachin);

        assertEquals(100, otroEspadachin.getVida());

    }

    @Test
    public void testEspadachinAtacaEspadachinEnRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador(mapa, 5 ,5, null );
        Jugador otroJugador = new Jugador(mapa, 13 ,5, null );

        Espadachin unEspadachin = new Espadachin(jugador);
        Espadachin otroEspadachin = new Espadachin(otroJugador);



        mapa.colocarUnidadEn(unEspadachin,1,1);
        mapa.colocarUnidadEn(otroEspadachin,1,2);

        unEspadachin.atacar(otroEspadachin);

        assertEquals(75, otroEspadachin.getVida());

    }

    @Test(expected = ContenibleFueraDeRango.class)
    public void testEspadachinAtacaEstructuraFueraDeRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador(mapa, 5 ,5, null );
        Jugador otroJugador = new Jugador(mapa, 13 ,5, null );

        Espadachin unEspadachin = new Espadachin(jugador);
        Castillo unCastillo = new Castillo(otroJugador);



        mapa.colocarUnidadEn(unEspadachin,1,1);
        mapa.colocarUnidadEn(unCastillo,1,9);

        unEspadachin.atacar(unCastillo);

        assertEquals(1000 ,unCastillo.getVida());

    }

    @Test
    public void testEspadachinAtacaEstructuraEnRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleDelMismoJugador {
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador(mapa, 5 ,5, null );
        Jugador otroJugador = new Jugador(mapa, 13 ,5, null );

        Espadachin unEspadachin = new Espadachin(jugador);
        Castillo unCastillo = new Castillo(otroJugador);


        mapa.colocarUnidadEn(unEspadachin,0,0);
        mapa.colocarUnidadEn(unCastillo,1,1);

        unEspadachin.atacar(unCastillo);

        assertEquals(985 ,unCastillo.getVida());


    }



}
