package estructuras;

import Excepciones.OroInsuficiente;
import contenibles.Contenible;
import juego.Jugador;
import unidades.Aldeano;

public class PlazaCentral implements Contenible {
    private int vida = 450;
    private int precioAldeano = 25;
    public Jugador perteneceA;

    public PlazaCentral(Jugador jugador) {
        this.perteneceA = jugador;
    }

    public int getVida() {
        return this.vida;
    }

    public Aldeano crearAldeano(int oroDisponible) throws OroInsuficiente {
        if(oroDisponible < precioAldeano) throw new OroInsuficiente();
        return new Aldeano(this.perteneceA);
    }
}
