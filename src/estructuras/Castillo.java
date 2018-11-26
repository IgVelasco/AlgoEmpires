package estructuras;

import Excepciones.ExcedeLimiteDelMapa;
import Excepciones.OroInsuficiente;
import Excepciones.PoblacionLimiteAlcanzada;
import contenibles.Contenible;
import espacio.Mapa;
import espacio.Posicion;
import juego.Jugador;
import unidades.ArmaDeAsedio;

import java.util.ArrayList;
import java.util.LinkedList;

public class Castillo extends Estructura {

    private static final int
            PRECIO_ARMA_DE_ASEDIO = 200,
            ALCANCE = 3;

    public Castillo(Jugador jugador) {
        propietario = jugador;
        vida = 1000;
        vidaMaxima = 1000;
        velocidadDeReparacion = 15;
        posiciones = new LinkedList<Posicion>();

    }

    public ArmaDeAsedio crearArmaDeAsedio(int oroDisponible) throws OroInsuficiente, PoblacionLimiteAlcanzada {
        if (oroDisponible < PRECIO_ARMA_DE_ASEDIO) {
            throw new OroInsuficiente();
        }
        this.propietario.aumentarPoblacion();
        return new ArmaDeAsedio(propietario);
    }

    public void atacar(Mapa mapa) throws ExcedeLimiteDelMapa {
        LinkedList<Contenible> atacables =  mapa.getConteniblesEnRango(posiciones, ALCANCE);

        while (atacables.contains(this)){ //Saco al castillo de los atacables
            atacables.remove(this);
        }

        ArrayList<Contenible> yaAtacados = new ArrayList<>();

        for (Contenible atacable : atacables) {
            if (atacable.sonDelMismoJugador(this.propietario) || yaAtacados.contains(atacable))
                continue;
            atacable.ataqueDeCastillo();
            yaAtacados.add(atacable);

        }
    }
}
