package modelo.juego;

import modelo.espacio.Mapa;


public class Juego {
    private Jugador[] jugadores;
    private Mapa mapa;
    private Turno turno;
    public Jugador jugadorActual;


    public Juego(int DimensionHorizontal, int DimensionVertical) {
        turno = new Turno();
        jugadores = new Jugador[2];
        mapa = new Mapa(DimensionHorizontal, DimensionVertical);

        jugadores[1] = new Jugador(mapa, DimensionHorizontal / 2, 0, this);
        jugadores[0] = new Jugador(mapa, DimensionHorizontal / 2, DimensionVertical - 4, this);

        jugadorActual = jugadores[turno.primerTurno()];
        jugadorActual.nuevoTurno();

    }


    public void siguienteTurno()  {
        jugadorActual = jugadores[turno.siguienteTurno()];
        jugadorActual.nuevoTurno();
    }

    public void perdedor() {
        //ganador(jugadores[turno.siguienteTurno()])
    }

    public Mapa getMapa() { return this.mapa;
    }

    public Jugador[] getJugadores() { return jugadores;
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }
}



