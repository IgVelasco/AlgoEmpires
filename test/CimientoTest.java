import modelo.espacio.Mapa;
import modelo.estructuras.Cimiento;
import modelo.estructuras.Cuartel;
import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.CimientoFinalizado;
import modelo.excepciones.ExcedeLimiteDelMapa;
import modelo.juego.Jugador;
import modelo.unidades.Aldeano;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CimientoTest {

    @Test
    public void testCimientoGuardaElTipoDeEstructuraConLaCantidadDeTurnosCorrespondiente() {

        Cuartel unCuartel = new Cuartel(null);
        Mapa unMapa = new Mapa(20,20);
        Cimiento cimientoCuartel = new Cimiento(unCuartel,unMapa,5,5,5);

        assertEquals(3, cimientoCuartel.getTurnosRestantes());
    }

    @Test
    public void testCimientoAvanzaLosTurnosCuandoSeLoConstruye() {

        Mapa unMapa = new Mapa(20,20);
        Cimiento unCimiento = new Cimiento(null,unMapa,5,5,5);

        unCimiento.avanzarConstruccion(null);

        assertEquals(2, unCimiento.getTurnosRestantes());
    }

  /*  @Test
    public void testCimientoLiberaAlAldeanoDeSuConstruccion() {

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
    }*/


}
