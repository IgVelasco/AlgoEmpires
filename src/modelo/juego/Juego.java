package modelo.juego;

import modelo.espacio.Mapa;


public class Juego {
    private Jugador[] jugadores;
    private Mapa mapa;
    private Turno turno;


    public Juego(int DimensionHorizontal, int DimensionVertical) {
        turno = new Turno();
        jugadores = new Jugador[2];
        mapa = new Mapa(DimensionHorizontal, DimensionVertical);

        jugadores[1] = new Jugador(mapa, DimensionHorizontal / 2, 0, this);
        jugadores[0] = new Jugador(mapa, DimensionHorizontal / 2, DimensionVertical - 4, this);

        jugadores[turno.primerTurno()].nuevoTurno();

    }


    public void siguienteTurno()  {
        jugadores[turno.siguienteTurno()].nuevoTurno();
    }

    public void perdedor() {
        //ganador(jugadores[turno.siguienteTurno()])
    }

    public Mapa getMapa() { return this.mapa;
    }

    public Jugador[] getJugadores() { return jugadores;
    }
}



