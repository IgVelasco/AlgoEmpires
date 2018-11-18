import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import Excepciones.UnidadYaUtilizada;
import espacio.Mapa;
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
}
