import Excepciones.CasilleroOcupado;
import Excepciones.ContenibleFueraDeRango;
import Excepciones.ExcedeLimiteDelMapa;
import Excepciones.UnidadYaUtilizada;
import contenibles.Contenible;
import espacio.Mapa;
import estructuras.Castillo;
import unidades.Espadachin;
import unidades.Espadachin;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EspadachinTest {

    @Test
    public void testEspadachinSeCreaCon100DeVida() {
        Espadachin unEspadachin = new Espadachin();

        assertEquals(100, unEspadachin.getVida());
    }
    @Test
    public void testEspadachinMoverHorizontalmenteLoRealizaCorrectamente() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Espadachin unEspadachin = new Espadachin();

        mapa.colocarUnidadEn(unEspadachin,0,0);
        unEspadachin.moverDerecha(mapa);
        assertEquals(unEspadachin, mapa.getContenido(1,0));
    }

    @Test
    public void testEspadachinMoverseHorizontalmenteActualizaPosicion() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Espadachin unEspadachin = new Espadachin();

        mapa.colocarUnidadEn(unEspadachin,1,1);
        unEspadachin.moverIzquierda(mapa);
        assertEquals(0, unEspadachin.getPosicionHorizontal());
    }

    @Test
    public void testEspadachinMoverEnVerticalLoRealizaCorrectamente() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Espadachin unEspadachin = new Espadachin();

        mapa.colocarUnidadEn(unEspadachin,1,1);
        unEspadachin.moverArriba(mapa);
        assertEquals(unEspadachin, mapa.getContenido(1,2));
    }

    @Test
    public void testEspadachinMoverVerticalActualizaPosicion() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Espadachin unEspadachin = new Espadachin();

        mapa.colocarUnidadEn(unEspadachin,1,1);
        unEspadachin.moverAbajo(mapa);
        assertEquals(0, unEspadachin.getPosicionVertical());
    }

    @Test
    public void testEspadachinMoverseDiagonalLoRealizaCorrectamente() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Espadachin unEspadachin = new Espadachin();

        mapa.colocarUnidadEn(unEspadachin,1,1);
        unEspadachin.moverDerechaSuperior(mapa);
        assertEquals(unEspadachin, mapa.getContenido(2,2));
    }


    @Test
    public void testEspadachinMoverseDiagonalActualizaPosicion() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Espadachin unEspadachin = new Espadachin();

        mapa.colocarUnidadEn(unEspadachin,1,1);
        unEspadachin.moverIzquierdaInferior(mapa);
        assertEquals(0, unEspadachin.getPosicionHorizontal());
        assertEquals(0,unEspadachin.getPosicionVertical());
    }


    @Test(expected = ContenibleFueraDeRango.class)
    public void testEspadachinAtacaEspadachinFueraDeRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10,10);

        Espadachin unEspadachin = new Espadachin();
        Espadachin otroEspadachin = new Espadachin();



        mapa.colocarUnidadEn(unEspadachin,1,1);
        mapa.colocarUnidadEn(unEspadachin,1,9);

        unEspadachin.atacar(otroEspadachin);



    }

    public void testEspadachinAtacaEspadachinEnRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10,10);

        Espadachin unEspadachin = new Espadachin();
        Espadachin otroEspadachin = new Espadachin();



        mapa.colocarUnidadEn(unEspadachin,1,1);
        mapa.colocarUnidadEn(otroEspadachin,1,2);

        unEspadachin.atacar(otroEspadachin);

        assertEquals(75, otroEspadachin.getVida());

    }

    @Test(expected = ContenibleFueraDeRango.class)
    public void testEspadachinAtacaEstructuraFueraDeRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(20,20);

        Espadachin unEspadachin = new Espadachin();
        Castillo unCastillo = new Castillo(null);



        mapa.colocarUnidadEn(unEspadachin,1,1);
        mapa.colocarUnidadEn(unCastillo,1,9);

        unEspadachin.atacar(unCastillo);

        assertEquals(1000 ,unCastillo.getVida());

    }

    public void testEspadachinAtacaEstructuraEnRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(20,20);

        Espadachin unEspadachin = new Espadachin();
        Castillo unCastillo = new Castillo(null);



        mapa.colocarUnidadEn(unEspadachin,0,0);
        mapa.colocarUnidadEn(unCastillo,1,1);

        unEspadachin.atacar(unCastillo);

        assertEquals(985 ,unCastillo.getVida());


    }



}
