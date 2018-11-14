package estructuras;

import Excepciones.OroInsuficiente;
import contenibles.Contenible;
import juego.Jugador;
import unidades.ArmaDeAsedio;

public class Castillo implements Contenible, Estructura {

    private int vida = 1000;
    private int precioArmaDeAsedio = 200;
    public Jugador perteneceA;

    public Castillo(Jugador jugador) {
        perteneceA = jugador;
    }

    public int getVida() {
        return this.vida;
    }

    public ArmaDeAsedio crearArmaDeAsedio(int oroDisponible) throws OroInsuficiente {
        if(oroDisponible < precioArmaDeAsedio) {
            throw new OroInsuficiente();
        }
        return new ArmaDeAsedio();
    }
}
