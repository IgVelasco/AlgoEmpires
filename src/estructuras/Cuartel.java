package estructuras;

import Excepciones.OroInsuficiente;
import contenibles.Contenible;
import juego.Jugador;
import unidades.Arquero;
import unidades.Espadachin;

public class Cuartel extends Estructura {

    private int precioEspadachin = 50;
    private int precioArquero = 75;

    public Cuartel(Jugador unJugador) {
        vida = 250;
        vidaMaxima = 250;
        velocidadDeReparacion = 50;
        propietario = unJugador;
    }

    public Espadachin crearEspadachin(int oroDisponible) throws OroInsuficiente {
        if(oroDisponible < precioEspadachin ) throw new OroInsuficiente();

        return new Espadachin(propietario);
    }

    public Arquero crearArquero(int oroDisponible) throws OroInsuficiente {
        if(oroDisponible < precioArquero) throw new OroInsuficiente();
        return new Arquero(propietario);
    }


    @Override
    public void setPosicion(int x, int y) {
        this.posX.add(x);
        this.posY.add(y);
    }
}
