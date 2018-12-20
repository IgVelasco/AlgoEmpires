package modelo.estructuras;

import modelo.espacio.Posicion;
import modelo.excepciones.ContenibleNoPropia;
import modelo.excepciones.OroInsuficiente;
import modelo.juego.Jugador;
import modelo.unidades.Aldeano;

import java.util.LinkedList;

public class PlazaCentral extends Estructura {
    private static final int PRECIO_ALDEANO = 25;

    public PlazaCentral(Jugador jugador) {
        vida = 450;
        vidaMaxima = 450;
        velocidadDeReparacion = 25;
        propietario = jugador;
        posiciones = new LinkedList<Posicion>();

    }

    public Aldeano crearAldeano(int oroDisponible, Jugador unJugador, Posicion posicion) {
        if (! sonDelMismoJugador(unJugador)) {
            throw new ContenibleNoPropia();
        }
        if (oroDisponible < PRECIO_ALDEANO) throw new OroInsuficiente();
        propietario.restarOro(PRECIO_ALDEANO);
        this.propietario.aumentarPoblacion();
        Aldeano aldeano = new Aldeano(this.propietario, posicion);
        this.propietario.agregarAccionable(aldeano);
        return aldeano;
    }

}
