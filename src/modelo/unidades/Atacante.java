package modelo.unidades;

import modelo.espacio.Contenible;
import modelo.excepciones.*;
import modelo.juego.Jugador;

public interface Atacante {
    void atacar(Contenible unContenible, Jugador unJugador) ;
}
