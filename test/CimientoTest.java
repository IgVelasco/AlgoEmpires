import Excepciones.CasilleroOcupado;
import Excepciones.CimientoFinalizado;
import Excepciones.CimientoNoFinalizado;
import Excepciones.ExcedeLimiteDelMapa;
import espacio.Mapa;
import estados.GenerandoOro;
import estructuras.Cimiento;
import estructuras.Cuartel;
import estructuras.Estructura;
import juego.Jugador;
import org.junit.Test;
import unidades.Aldeano;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CimientoTest {

    @Test
    public void testCimientoGuardaElTipoDeEstructuraConLaCantidadDeTurnosCorrespondiente() throws CasilleroOcupado, ExcedeLimiteDelMapa {

        Cuartel unCuartel = new Cuartel(null);
        Mapa unMapa = new Mapa(20,20);
        Cimiento cimientoCuartel = new Cimiento(unCuartel,unMapa,5,5,5);

        assertEquals(3, cimientoCuartel.getTurnosRestantes());
    }

    @Test
    public void testCimientoAvanzaLosTurnosCuandoSeLoConstruye() throws CimientoFinalizado, CasilleroOcupado, ExcedeLimiteDelMapa {

        Mapa unMapa = new Mapa(20,20);
        Cimiento unCimiento = new Cimiento(null,unMapa,5,5,5);

        unCimiento.avanzarConstruccion(null);

        assertEquals(2, unCimiento.getTurnosRestantes());
    }

    @Test
    public void testCimientoColocaLaEstructuraLuegoDeTerminarSuConstruccion()
            throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Mapa unMapa = new Mapa(20,20);
        Aldeano unAldeano = new Aldeano(null);
        Cuartel unCuartel = new Cuartel(null);
        Cimiento unCimiento = new Cimiento(unCuartel,unMapa,5,5,5);

        unCimiento.avanzarConstruccion(unAldeano);
        assertEquals(unCimiento, unMapa.getContenido(5,5));

        unCimiento.avanzarConstruccion(unAldeano);
        unCimiento.avanzarConstruccion(unAldeano);

        assertEquals(unCuartel, unMapa.getContenido(5,5));

    }

    @Test
    public void testCimientoLiberaAlAldeanoDeSuConstruccion() throws CasilleroOcupado, ExcedeLimiteDelMapa {

        Mapa unMapa = new Mapa(20,20);
        Jugador jugador = new Jugador(unMapa , 5 , 5 , null);
        Aldeano unAldeano = new Aldeano(jugador);
        Cuartel unCuartel = new Cuartel(null);
        Cimiento unCimiento = new Cimiento(unCuartel,unMapa,10,10,2);

        unCimiento.avanzarConstruccion(unAldeano);
        unCimiento.avanzarConstruccion(unAldeano);
        unCimiento.avanzarConstruccion(unAldeano);

        unAldeano.realizarAccionCorrespondiente();

        assertEquals(jugador.getOro(), 120);
    }


}
