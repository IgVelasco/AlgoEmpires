package juego;

import Excepciones.AldeanoOcupado;
import Excepciones.CasilleroOcupado;
import Excepciones.EdificioConVidaMaxima;
import Excepciones.ExcedeLimiteDelMapa;
import contenibles.Contenible;
import espacio.Mapa;
import estructuras.*;
import unidades.Aldeano;

import java.util.ArrayList;
import java.util.Iterator;

public class Jugador {
    private Mapa mapa;
    private Juego juego;
    private Castillo castillo;
    private ArrayList<Estructura> estructuras = new ArrayList<Estructura>();
    private ArrayList<Aldeano> aldeanos = new ArrayList<Aldeano>();
    private int oro;

    public Jugador(Mapa mapa, int posicionCastilloHorizontal , int posicionCastilloVertical , Juego juego) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        castillo = new Castillo(this);
        estructuras.add(new PlazaCentral(this));
        this.mapa = mapa;
        this.oro = 100;

        mapa.colocarEstructuraEn(castillo, posicionCastilloHorizontal, posicionCastilloVertical, 4);
        mapa.colocarEstructuraEn(estructuras.get(0), posicionCastilloHorizontal - 2, posicionCastilloVertical, 2);

        for (int i = 0; i < 3; i++) {
            aldeanos.add(i, new Aldeano(this));
            mapa.colocarUnidadEn(aldeanos.get(i), posicionCastilloHorizontal - 3, posicionCastilloVertical + i);
        }
    }

    public void nuevoTurno() {
        //this.turnoNumero++;

        for (Aldeano aldeano : aldeanos) {
            aldeano.realizarAccionCorrespondiente();
        }
    }

    public void finalizarTurno() {
        juego.siguienteTurno();
    }


    public void sumarOro(int unidadesDeOro) {
        this.oro += unidadesDeOro;
    }

    public void construirPlazaCentral (Aldeano aldeano, int x, int y) throws AldeanoOcupado, CasilleroOcupado, ExcedeLimiteDelMapa { // Podria ser asi o que se le pase un indez de array
        PlazaCentral unaPlazaCentral = new PlazaCentral(this);
        Cimiento unCimiento = new Cimiento(unaPlazaCentral);
        aldeano.comenzarCimientos(unCimiento);
        estructuras.add(unaPlazaCentral);
        mapa.colocarEstructuraEn(unaPlazaCentral, x, y ,2);
    }

    public void comenzarCuartel(Aldeano aldeano, int x, int y) throws AldeanoOcupado, CasilleroOcupado, ExcedeLimiteDelMapa {
        Cuartel unCuartel = new Cuartel(this);
        Cimiento elCimiento = new Cimiento(unCuartel);
        //estructuras.add(unCuartel);  Todavia no deberia agregarse
        aldeano.comenzarCimientos(elCimiento);
        mapa.colocarEstructuraEn((Estructura) elCimiento, x, y ,2);
    }


    public void repararEstructura(Aldeano unAldeano, Cuartel unCuartel) throws EdificioConVidaMaxima, AldeanoOcupado {
        unAldeano.comenzarReparacion(unCuartel);
    }

    public int getOro() {
        return this.oro;
    }
}
