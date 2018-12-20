package modelo.excepciones;

import modelo.juego.Jugador;

public class PartidaTerminada extends RuntimeException {
    Jugador jugador;

    public PartidaTerminada(Jugador jugadores) {
        jugador = jugadores;
    }

    public Jugador getJugador(){
        return jugador;
    }
}
