package modelo.estructuras;

import javafx.geometry.Pos;
import modelo.espacio.Posicion;
import modelo.excepciones.ContenibleNoPropia;
import modelo.excepciones.OroInsuficiente;
import modelo.excepciones.PosicionFueraDeRango;
import modelo.juego.Jugador;
import modelo.unidades.Arquero;
import modelo.unidades.Espadachin;

import java.util.LinkedList;

public class Cuartel extends Estructura {

    private static final int
            PRECIO_ESPADACHIN = 50,
            PRECIO_ARQUERO = 75;

    public Cuartel(Jugador unJugador) {
        vida = 250;
        vidaMaxima = 250;
        velocidadDeReparacion = 50;
        propietario = unJugador;
        posiciones = new LinkedList<Posicion>();
    }

    public Espadachin crearEspadachin(int oroDisponible, Jugador unJugador, Posicion posicion) {
        if (! sonDelMismoJugador(unJugador)) {
            throw new ContenibleNoPropia();
        }
        if (calcularDistancia(posicion.getPosX(),posicion.getPosY())>1)
            throw new PosicionFueraDeRango();
        if (oroDisponible < PRECIO_ESPADACHIN) throw new OroInsuficiente();
        propietario.restarOro(PRECIO_ESPADACHIN);
        this.propietario.aumentarPoblacion();
        return new Espadachin(propietario, posicion);
    }

    public Arquero crearArquero(int oroDisponible, Jugador unJugador, Posicion posicion) {
        if (! sonDelMismoJugador(unJugador)) {
            throw new ContenibleNoPropia();
        }
        if (calcularDistancia(posicion.getPosX(),posicion.getPosY())>1)
            throw new PosicionFueraDeRango();
        if (oroDisponible < PRECIO_ARQUERO) throw new OroInsuficiente();
        propietario.restarOro(PRECIO_ARQUERO);
        this.propietario.aumentarPoblacion();
        return new Arquero(propietario, posicion);
    }

}
