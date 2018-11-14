package Juego;

import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import espacio.Mapa;
import estructuras.Castillo;


public class Juego {
    private Jugador[] jugadores;
    private Mapa mapa;


    public Juego(int DimensionHorizontal, int DimensionVertical) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        jugadores = new Jugador[2];

        mapa = new Mapa(DimensionHorizontal, DimensionVertical);

        jugadores[1] = new Jugador(mapa, 0, (DimensionVertical / 2));
        jugadores[0] = new Jugador(mapa, DimensionVertical - 5, DimensionVertical / 2);


    }
}
