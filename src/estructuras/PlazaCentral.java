package estructuras;

import Excepciones.OroInsuficiente;
import contenibles.Contenible;
import juego.Jugador;
import unidades.Aldeano;

public class PlazaCentral extends Estructura {
    private int precioAldeano = 25;
    public Jugador perteneceA;

    public PlazaCentral(Jugador jugador) {
        vida = 450;
        vidaMaxima = 450;
        velocidadDeReparacion = 25;
        this.perteneceA = jugador;
    }

    public Aldeano crearAldeano(int oroDisponible) throws OroInsuficiente {
        if(oroDisponible < precioAldeano) throw new OroInsuficiente();
        return new Aldeano(this.perteneceA);
    }
}
