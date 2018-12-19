import modelo.espacio.Mapa;
import modelo.estructuras.Cimiento;
import modelo.estructuras.Cuartel;
import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.CimientoFinalizado;
import modelo.excepciones.ExcedeLimiteDelMapa;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.unidades.Aldeano;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CimientoTest {

    @Test
    public void testCimientoGuardaElTipoDeEstructuraConLaCantidadDeTurnosCorrespondiente() {
        Mapa mapa = new Mapa(20,20);
        Cuartel cuartel = new Cuartel(null);
        Cimiento cimiento = new Cimiento(cuartel,mapa,10,10,4);

        assertEquals(3,cimiento.getTurnosRestantes());
        assertEquals(cuartel, cimiento.getFuturaEstructura());
    }



   @Test
    public void testCimientoAvanzaLosTurnosCuandoSeLoConstruye() {
        Cuartel cuartel = new Cuartel(null);
        Mapa unMapa = new Mapa(20,20);
        Cimiento unCimiento = new Cimiento(cuartel,unMapa,5,5,4);

        unCimiento.avanzarConstruccion(null);

        assertEquals(2, unCimiento.getTurnosRestantes());
    }


    @Test
    public void testCimientoLiberaAlAldeanoDeSuConstruccion() {

        Juego unJuego = new Juego(20,20);

        Jugador jugador = unJuego.getJugadorActual();
        Aldeano unAldeano = new Aldeano(jugador);
        Mapa mapa = unJuego.getMapa();
        mapa.colocarUnidadEn(unAldeano,4,4);
        jugador.agregarAccionable(unAldeano);

        jugador.construirCuartel(unAldeano,5,5);

        unJuego.siguienteTurno(); //Jug ok
        unJuego.siguienteTurno(); //jug not ok
        unJuego.siguienteTurno(); //Jug ok
        unJuego.siguienteTurno(); //jug not ok
        unJuego.siguienteTurno(); //Jug ok
        unJuego.siguienteTurno(); //jug not ok

        unJuego.siguienteTurno();
        unJuego.siguienteTurno();

        assertEquals(370, jugador.getOro());
    }

    @Test
    public void testCimientoPoneLaEstructuraEnSuLugar(){
        Juego unJuego = new Juego(20,20);

        Jugador jugador = unJuego.getJugadorActual();
        Aldeano unAldeano = new Aldeano(jugador);
        Mapa mapa = unJuego.getMapa();
        mapa.colocarUnidadEn(unAldeano,4,4);
        jugador.agregarAccionable(unAldeano);

        jugador.construirCuartel(unAldeano,5,5);

        Cimiento elCimiento = (Cimiento) mapa.getContenido(5,5);
        Cuartel cuartel = (Cuartel) elCimiento.getFuturaEstructura();

        unJuego.siguienteTurno(); //Jug ok
        unJuego.siguienteTurno(); //jug not ok
        unJuego.siguienteTurno(); //Jug ok
        unJuego.siguienteTurno(); //jug not ok
        unJuego.siguienteTurno(); //Jug ok
        unJuego.siguienteTurno(); //jug not ok

        assertEquals(cuartel, mapa.getContenido(5,5));

    }

    @Test
    public void testCimientoDesapareceCuandoSeLoAtaca(){

        Juego unJuego = new Juego(20,20);

        Jugador jugador = unJuego.getJugadorActual();
        Aldeano unAldeano = new Aldeano(jugador);
        Mapa mapa = unJuego.getMapa();
        mapa.colocarUnidadEn(unAldeano,4,4);
        jugador.agregarAccionable(unAldeano);

        jugador.construirCuartel(unAldeano,5,5);

        Cimiento elCimiento = (Cimiento) mapa.getContenido(5,5);

        elCimiento.recibirAtaque(1);

        assertNull(mapa.getContenido(5,5));

    }


}
