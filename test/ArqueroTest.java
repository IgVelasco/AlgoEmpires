import Excepciones.CasilleroOcupado;
import Excepciones.ContenibleFueraDeRango;
import Excepciones.ExcedeLimiteDelMapa;
import Excepciones.UnidadYaUtilizada;
import espacio.Mapa;
import estructuras.Castillo;
import unidades.Arquero;
import unidades.Arquero;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArqueroTest {

    @Test
    public void testArqueroSeCreaCon75DeVida() {
        Arquero unArquero = new Arquero();

        assertEquals(75, unArquero.getVida());
    }
    @Test
    public void testArqueroMoverHorizontalmenteLoRealizaCorrectamente() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Arquero unArquero = new Arquero();

        mapa.colocarUnidadEn(unArquero,0,0);
        unArquero.moverDerecha(mapa);
        assertEquals(unArquero, mapa.getContenido(1,0));
    }

    @Test
    public void testArqueroMoverseHorizontalmenteActualizaPosicion() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Arquero unArquero = new Arquero();

        mapa.colocarUnidadEn(unArquero,1,1);
        unArquero.moverIzquierda(mapa);
        assertEquals(0, unArquero.getPosicionHorizontal());
    }

    @Test
    public void testArqueroMoverEnVerticalLoRealizaCorrectamente() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Arquero unArquero = new Arquero();

        mapa.colocarUnidadEn(unArquero,1,1);
        unArquero.moverArriba(mapa);
        assertEquals(unArquero, mapa.getContenido(1,2));
    }

    @Test
    public void testArqueroMoverVerticalActualizaPosicion() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Arquero unArquero = new Arquero();

        mapa.colocarUnidadEn(unArquero,1,1);
        unArquero.moverAbajo(mapa);
        assertEquals(0, unArquero.getPosicionVertical());
    }

    @Test
    public void testArqueroMoverseDiagonalLoRealizaCorrectamente() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Arquero unArquero = new Arquero();

        mapa.colocarUnidadEn(unArquero,1,1);
        unArquero.moverDerechaSuperior(mapa);
        assertEquals(unArquero, mapa.getContenido(2,2));
    }

    @Test
    public void testArqueroMoverseDiagonalActualizaPosicion() throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        Mapa mapa = new Mapa(10,10);
        Arquero unArquero = new Arquero();

        mapa.colocarUnidadEn(unArquero,1,1);
        unArquero.moverIzquierdaInferior(mapa);
        assertEquals(0, unArquero.getPosicionHorizontal());
        assertEquals(0,unArquero.getPosicionVertical());
    }

    @Test(expected = ContenibleFueraDeRango.class)
    public void testArqueroAtacaArqueroFueraDeRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10,10);

        Arquero unArquero = new Arquero();
        Arquero otroArquero = new Arquero();



        mapa.colocarUnidadEn(unArquero,1,1);
        mapa.colocarUnidadEn(unArquero,1,9);

        unArquero.atacar(otroArquero);



    }


    @Test
    public void testArqueroAtacaArqueroEnRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10,10);

        Arquero unArquero = new Arquero();
        Arquero otroArquero = new Arquero();



        mapa.colocarUnidadEn(unArquero,1,1);
        mapa.colocarUnidadEn(otroArquero,1,2);

        unArquero.atacar(otroArquero);

        assertEquals(60, otroArquero.getVida());

    }

    @Test(expected = ContenibleFueraDeRango.class)
    public void testArqueroAtacaEstructuraFueraDeRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(20,20);

        Arquero unArquero = new Arquero();
        Castillo unCastillo = new Castillo(null);



        mapa.colocarUnidadEn(unArquero,1,1);
        mapa.colocarUnidadEn(unCastillo,1,9);

        unArquero.atacar(unCastillo);

        assertEquals(1000 ,unCastillo.getVida());

    }

    @Test
    public void testArqueroAtacaEstructuraEnRango() throws ContenibleFueraDeRango, CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(20,20);

        Arquero unArquero = new Arquero();
        Castillo unCastillo = new Castillo(null);



        mapa.colocarUnidadEn(unArquero,0,0);
        mapa.colocarUnidadEn(unCastillo,1,1);

        unArquero.atacar(unCastillo);

        assertEquals(990 ,unCastillo.getVida());


    }


}
