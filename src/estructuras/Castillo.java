package estructuras;

import Excepciones.OroInsuficiente;
import contenibles.Contenible;
import espacio.Posicion;
import juego.Jugador;
import unidades.ArmaDeAsedio;

import java.util.LinkedList;

public class Castillo extends Estructura {

    private int precioArmaDeAsedio = 200;

    public Castillo(Jugador jugador) {
        propietario = jugador;
        vida = 1000;
        vidaMaxima = 1000;
        velocidadDeReparacion = 15;
        posiciones = new LinkedList<Posicion>();
    }

    public ArmaDeAsedio crearArmaDeAsedio(int oroDisponible) throws OroInsuficiente {
        if(oroDisponible < precioArmaDeAsedio) {
            throw new OroInsuficiente();
        }
        return new ArmaDeAsedio(propietario);
    }

    public void atacar(Castillo otroCastillo) {

    }


}
