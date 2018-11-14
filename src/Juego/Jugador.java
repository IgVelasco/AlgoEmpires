package Juego;

import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import espacio.Mapa;
import estructuras.Castillo;
import estructuras.Cuartel;
import estructuras.PlazaCentral;


import java.util.Dictionary;

public class Jugador {
    private Mapa mapa;
    private Castillo castillo;
    private PlazaCentral[] plazaCentrales;
    private Cuartel[] cuarteles;
   // private Dictionary<String Estructuras[]> Necesito estructuras para ir actualizando sus turnos de construccion

    public Jugador(Mapa mapa, int posicionCastilloHorizontal , int posicionCastilloHorizontalVertical ) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Castillo castillo = new Castillo();
        mapa.colocarEstructuraEn(castillo, posicionCastilloHorizontal, posicionCastilloHorizontalVertical, 4);
    }
}
