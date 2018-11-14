package juego;

import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import espacio.Mapa;
import estructuras.Castillo;
import estructuras.Cuartel;
import estructuras.PlazaCentral;
import unidades.Aldeano;

public class Jugador {
    private Mapa mapa;
    private Castillo castillo;
    private PlazaCentral[] plazaCentrales;
    private Cuartel[] cuarteles;
    public int oro;
   // private Dictionary<String Estructuras[]> Necesito estructuras para ir actualizando sus turnos de construccion

    public Jugador(Mapa mapa, int posicionCastilloHorizontal , int posicionCastilloVertical ) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Castillo castillo = new Castillo();
        PlazaCentral plaza = new PlazaCentral();
        Aldeano aldeano1 = new Aldeano();
        Aldeano aldeano2 = new Aldeano();
        Aldeano aldeano3 = new Aldeano();

        oro = 100;

        mapa.colocarEstructuraEn(castillo, posicionCastilloHorizontal, posicionCastilloVertical, 4);
        mapa.colocarEstructuraEn(plaza, posicionCastilloHorizontal - 2, posicionCastilloVertical, 2 );

        mapa.colocarUnidadEn(aldeano1, posicionCastilloHorizontal - 3, posicionCastilloVertical);
        mapa.colocarUnidadEn(aldeano2, posicionCastilloHorizontal - 3, posicionCastilloVertical + 1);
        mapa.colocarUnidadEn(aldeano3, posicionCastilloHorizontal - 3, posicionCastilloVertical + 2);
    }
}
