package modelo.estructuras;

import modelo.espacio.Posicion;
import modelo.excepciones.OroInsuficiente;
import modelo.excepciones.PoblacionLimiteAlcanzada;
import modelo.juego.Jugador;
import modelo.unidades.Arquero;
import modelo.unidades.Espadachin;

import java.util.LinkedList;

public class Cuartel extends Estructura {

    private static final int
            PRECIO_ESPADACHIN = 50,
            PRECIO_ARQUERO = 75;

    public Cuartel(Jugador unJugador) {
        vida = 250;
        vidaMaxima = 250;
        velocidadDeReparacion = 50;
        propietario = unJugador;
        posiciones = new LinkedList<Posicion>();
    }

    public Espadachin crearEspadachin(int oroDisponible) throws OroInsuficiente, PoblacionLimiteAlcanzada {
        if (oroDisponible < PRECIO_ESPADACHIN) throw new OroInsuficiente();
        this.propietario.aumentarPoblacion();
        return new Espadachin(propietario);
    }

    public Arquero crearArquero(int oroDisponible) throws OroInsuficiente, PoblacionLimiteAlcanzada {
        if (oroDisponible < PRECIO_ARQUERO) throw new OroInsuficiente();
        this.propietario.aumentarPoblacion();
        return new Arquero(propietario);
    }

}