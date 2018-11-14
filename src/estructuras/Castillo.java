package estructuras;

import Excepciones.OroInsuficiente;
import contenibles.Contenible;
import juego.Jugador;
import unidades.ArmaDeAsedio;

public class Castillo extends Estructura implements Contenible {

    private int precioArmaDeAsedio = 200;
    private Jugador perteneceA;

    public Castillo(Jugador jugador) {
        perteneceA = jugador;
        vida = 1000;
        vidaMaxima = 1000;
        velocidadDeReparacion = 15;
    }

    public int getVida() {
        return vida;
    }

    public ArmaDeAsedio crearArmaDeAsedio(int oroDisponible) throws OroInsuficiente {
        if(oroDisponible < precioArmaDeAsedio) {
            throw new OroInsuficiente();
        }
        return new ArmaDeAsedio();
    }

}
