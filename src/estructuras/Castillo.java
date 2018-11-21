package estructuras;

import Excepciones.ExcedeLimiteDelMapa;
import Excepciones.OroInsuficiente;
import Excepciones.PoblacionLimiteAlcanzada;
import contenibles.Contenible;
import espacio.Mapa;
import espacio.Posicion;
import juego.Jugador;
import unidades.ArmaDeAsedio;

import java.util.LinkedList;

public class Castillo extends Estructura {

    private int precioArmaDeAsedio = 200;
    private int alcance = 3;

    public Castillo(Jugador jugador) {
        propietario = jugador;
        vida = 1000;
        vidaMaxima = 1000;
        velocidadDeReparacion = 15;
        posiciones = new LinkedList<Posicion>();

    }

    public ArmaDeAsedio crearArmaDeAsedio(int oroDisponible) throws OroInsuficiente, PoblacionLimiteAlcanzada {
        if (oroDisponible < precioArmaDeAsedio) {
            throw new OroInsuficiente();
        }
        this.propietario.aumentarPoblacion();
        return new ArmaDeAsedio(propietario);
    }

    public void atacar(Castillo otroCastillo) {

    }


    public void atacar(Mapa mapa) throws ExcedeLimiteDelMapa {
        LinkedList<Contenible> atacables = mapa.getConteniblesEnRango(posiciones, alcance, this);
        for (Contenible atacable : atacables) {
            if (atacable.sonDelMismoJugador(this.propietario))
                continue;
            atacable.ataqueDeCastillo();

        }
    }
}
