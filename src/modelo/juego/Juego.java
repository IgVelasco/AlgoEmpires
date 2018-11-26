package modelo.juego;

import modelo.espacio.Mapa;
import modelo.excepciones.ArmaYaCargada;
import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.ExcedeLimiteDelMapa;


public class Juego {
    private Jugador[] jugadores;
    private Mapa mapa;
    private Turno turno;


    public Juego(int DimensionHorizontal, int DimensionVertical) throws CasilleroOcupado, ExcedeLimiteDelMapa, ArmaYaCargada {
        turno = new Turno();
        jugadores = new Jugador[2];
        mapa = new Mapa(DimensionHorizontal, DimensionVertical);

        jugadores[1] = new Jugador(mapa, DimensionHorizontal / 2, 0, this);
        jugadores[0] = new Jugador(mapa, DimensionHorizontal / 2, DimensionVertical - 4, this);

        jugadores[turno.primerTurno()].nuevoTurno();

    }


    public void siguienteTurno() throws ExcedeLimiteDelMapa, ArmaYaCargada, CasilleroOcupado {
        jugadores[turno.siguienteTurno()].nuevoTurno();
    }

}



