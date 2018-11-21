package estructuras;

import Excepciones.OroInsuficiente;
import Excepciones.PoblacionLimiteAlcanzada;
import espacio.Posicion;
import juego.Jugador;
import unidades.Arquero;
import unidades.Espadachin;

import java.util.LinkedList;

public class Cuartel extends Estructura {

    private int precioEspadachin = 50;
    private int precioArquero = 75;

    public Cuartel(Jugador unJugador) {
        vida = 250;
        vidaMaxima = 250;
        velocidadDeReparacion = 50;
        propietario = unJugador;
        posiciones = new LinkedList<Posicion>();
    }

    public Espadachin crearEspadachin(int oroDisponible) throws OroInsuficiente, PoblacionLimiteAlcanzada {
        if (oroDisponible < precioEspadachin) throw new OroInsuficiente();
        this.propietario.aumentarPoblacion();
        return new Espadachin(propietario);
    }

    public Arquero crearArquero(int oroDisponible) throws OroInsuficiente, PoblacionLimiteAlcanzada {
        if (oroDisponible < precioArquero) throw new OroInsuficiente();
        this.propietario.aumentarPoblacion();
        return new Arquero(propietario);
    }

}
