package juego;

import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import espacio.Mapa;


public class Juego {
    private Jugador[] jugadores;
    private Mapa mapa;


    public Juego(int DimensionHorizontal, int DimensionVertical) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        jugadores = new Jugador[2];

        mapa = new Mapa(DimensionHorizontal, DimensionVertical);

        jugadores[1] = new Jugador(mapa, DimensionHorizontal / 2, 0);
        jugadores[0] = new Jugador(mapa, DimensionHorizontal / 2, DimensionVertical - 4);


    }

}
