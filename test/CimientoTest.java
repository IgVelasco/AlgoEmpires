import modelo.espacio.Mapa;
import modelo.espacio.Posicion;
import modelo.estructuras.Cimiento;
import modelo.estructuras.Cuartel;
import modelo.estructuras.PlazaCentral;
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

        Juego unJuego = new Juego(40, 40);

        Jugador jugador = unJuego.getJugadorActual();
        Posicion posicionAldeano = new Posicion(34, 34);

        jugador.crearAldeano(new PlazaCentral(jugador), posicionAldeano);

        Mapa mapa = unJuego.getMapa();


        Aldeano unAldeano = (Aldeano) mapa.getContenido(34, 34);
        jugador.construirCuartel(unAldeano,35,35);

        unJuego.siguienteTurno(); //Jug ok
        unJuego.siguienteTurno(); //jug not ok
        unJuego.siguienteTurno(); //Jug ok
        unJuego.siguienteTurno(); //jug not ok
        unJuego.siguienteTurno(); //Jug ok
        unJuego.siguienteTurno(); //jug not ok

        unJuego.siguienteTurno();
        unJuego.siguienteTurno();

        unJuego.siguienteTurno();
        unJuego.siguienteTurno();

        assertEquals(365, jugador.getOro());
    }

    @Test
    public void testCimientoPoneLaEstructuraEnSuLugar() {
        Juego unJuego = new Juego(40, 40);
        Jugador jugador = unJuego.getJugadorActual();
        jugador.nuevoTurno();
        Posicion posicionAldeano = new Posicion(34, 34);
        jugador.crearAldeano(new PlazaCentral(jugador), posicionAldeano);
        Mapa mapa = unJuego.getMapa();


        Aldeano unAldeano = (Aldeano) mapa.getContenido(34, 34);
        jugador.construirCuartel(unAldeano,35,35);

        Cimiento elCimiento = (Cimiento) mapa.getContenido(35,35);
        Cuartel cuartel = (Cuartel) elCimiento.getFuturaEstructura();

        unJuego.siguienteTurno(); //Jug ok
        unJuego.siguienteTurno(); //jug not ok
        unJuego.siguienteTurno(); //Jug ok
        unJuego.siguienteTurno(); //jug not ok
        unJuego.siguienteTurno(); //Jug ok
        unJuego.siguienteTurno(); //jug not ok

        assertEquals(cuartel, mapa.getContenido(35,35));

    }

    @Test
    public void testCimientoDesapareceCuandoSeLoAtaca(){

        Juego unJuego = new Juego(20,20);

        Jugador jugador = unJuego.getJugadorActual();
        Posicion posicionAldeano = new Posicion(4, 4);
        jugador.crearAldeano(new PlazaCentral(jugador), posicionAldeano);
        Mapa mapa = unJuego.getMapa();

        Aldeano unAldeano = (Aldeano) mapa.getContenido(4, 4);
        jugador.construirCuartel(unAldeano,5,5);

        Cimiento elCimiento = (Cimiento) mapa.getContenido(5,5);

        elCimiento.recibirAtaque(1);

        assertNull(mapa.getContenido(5,5));

    }

}
