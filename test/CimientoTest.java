import Excepciones.CimientoFinalizado;
import Excepciones.CimientoNoFinalizado;
import estructuras.Cimiento;
import estructuras.Cuartel;
import estructuras.Estructura;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CimientoTest {

    @Test
    public void testCimientoGuardaElTipoDeEstructuraConLaCantidadDeTurnosCorrespondiente() {

        Cuartel unCuartel = new Cuartel(null);
        Cimiento cimientoCuartel = new Cimiento(unCuartel);

        assertEquals(3, cimientoCuartel.getTurnosRestantes());
    }

    @Test
    public void testCimientoAvanzaLosTurnosCuandoSeLoConstruye() throws CimientoFinalizado {

        Cimiento unCimiento = new Cimiento(null);

        unCimiento.avanzarConstruccion();

        assertEquals(2, unCimiento.getTurnosRestantes());
    }

    @Test(expected = CimientoFinalizado.class)
    public void testCimientoLanzaErrorCuandoNoQuedanMasTurnosRestantes() throws CimientoFinalizado {
        Cimiento unCimiento = new Cimiento(null);

        unCimiento.avanzarConstruccion(); //Turnos restantes: 2
        unCimiento.avanzarConstruccion(); //Turnos restantes: 1
        unCimiento.avanzarConstruccion(); //Turnos restantes: 0

        unCimiento.avanzarConstruccion(); // Este lanza excepcion
    }

    @Test(expected = CimientoNoFinalizado.class)
    public void testCimientoLanzaErrorSiSeIntentaTerminarConstruccionAntes() throws CimientoNoFinalizado {
        Cimiento unCimiento = new Cimiento(null);

        unCimiento.finalizarConstruccion();
    }

    @Test
    public void testCimientoDevuelveLaEstructuraQueLeCorrespondeCuandoFinaliza() throws CimientoFinalizado, CimientoNoFinalizado {
        Cuartel unCuartel = new Cuartel(null);
        Cimiento unCimiento = new Cimiento(unCuartel);

        unCimiento.avanzarConstruccion(); //Turnos restantes: 2
        unCimiento.avanzarConstruccion(); //Turnos restantes: 1
        unCimiento.avanzarConstruccion(); //Turnos restantes: 0

        Estructura nuevaEstructura = unCimiento.finalizarConstruccion();

        assertEquals(unCuartel, nuevaEstructura);

    }
}
