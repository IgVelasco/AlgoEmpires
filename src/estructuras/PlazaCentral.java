package estructuras;

import Excepciones.OroInsuficiente;
import contenibles.Contenible;
import espacio.Posicion;
import juego.Jugador;
import unidades.Aldeano;

public class PlazaCentral extends Estructura {
    private int precioAldeano = 25;

    public PlazaCentral(Jugador jugador) {
        vida = 450;
        vidaMaxima = 450;
        velocidadDeReparacion = 25;
        propietario = jugador;
    }

    public Aldeano crearAldeano(int oroDisponible) throws OroInsuficiente {
        if(oroDisponible < precioAldeano) throw new OroInsuficiente();
        return new Aldeano(this.propietario);
    }

    @Override
    public void setPosicion(Posicion pos) {
       posicion = pos;
    }
}
