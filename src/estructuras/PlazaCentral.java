package estructuras;

import Excepciones.OroInsuficiente;
import Excepciones.PoblacionLimiteAlcanzada;
import contenibles.Contenible;
import espacio.Posicion;
import juego.Jugador;
import unidades.Aldeano;

import java.util.LinkedList;

public class PlazaCentral extends Estructura {
    private int precioAldeano = 25;

    public PlazaCentral(Jugador jugador) {
        vida = 450;
        vidaMaxima = 450;
        velocidadDeReparacion = 25;
        propietario = jugador;
        posiciones = new LinkedList<Posicion>();

    }

    public Aldeano crearAldeano(int oroDisponible)throws OroInsuficiente, PoblacionLimiteAlcanzada {
        if(oroDisponible < precioAldeano) throw new OroInsuficiente();
        this.propietario.aumentarPoblacion();
        return new Aldeano(this.propietario);
    }

}
