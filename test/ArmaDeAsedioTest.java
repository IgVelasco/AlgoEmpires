import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import espacio.Mapa;
import unidades.Aldeano;
import unidades.ArmaDeAsedio;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArmaDeAsedioTest {

    @Test
    public void testArmaDeAsedioSeCreaCon150DeVida() {
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio();

        assertEquals(150, unArmaDeAsedio.getVida());
    }

    @Test
    public void testArmaAsedioMoverHorizontalmenteLoRealizaCorrectamente() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10,10);
        ArmaDeAsedio unArma = new ArmaDeAsedio();

        mapa.colocarUnidadEn(unArma,0,0);
        unArma.moverDerecha(mapa);
        assertEquals(unArma, mapa.getContenido(1,0));
    }

    @Test
    public void testArmaAsedioMoverseHorizontalmenteActualizaPosicion() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10,10);
        ArmaDeAsedio unArma = new ArmaDeAsedio();

        mapa.colocarUnidadEn(unArma,1,1);
        unArma.moverIzquierda(mapa);
        assertEquals(0, unArma.getPosicionHorizontal());
    }

    @Test
    public void testArmaAsedioMoverEnVerticalLoRealizaCorrectamente() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10,10);
        ArmaDeAsedio unArma = new ArmaDeAsedio();

        mapa.colocarUnidadEn(unArma,1,1);
        unArma.moverArriba(mapa);
        assertEquals(unArma, mapa.getContenido(1,2));
    }

    @Test
    public void testArmaAsedioMoverVerticalActualizaPosicion() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10,10);
        ArmaDeAsedio unArma = new ArmaDeAsedio();

        mapa.colocarUnidadEn(unArma,1,1);
        unArma.moverAbajo(mapa);
        assertEquals(0, unArma.getPosicionVertical());
    }

    @Test
    public void testAldeanoMoverseDiagonalLoRealizaCorrectamente() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10,10);
        ArmaDeAsedio unArma = new ArmaDeAsedio();

        mapa.colocarUnidadEn(unArma,1,1);
        unArma.moverDerechaSuperior(mapa);
        assertEquals(unArma, mapa.getContenido(2,2));
    }

    @Test
    public void testArmaAsedioMoverseDiagonalActualizaPosicion() throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa mapa = new Mapa(10,10);
        ArmaDeAsedio unArma = new ArmaDeAsedio();

        mapa.colocarUnidadEn(unArma,1,1);
        unArma.moverIzquierdaInferior(mapa);
        assertEquals(0, unArma.getPosicionHorizontal());
        assertEquals(0,unArma.getPosicionVertical());
    }
}
