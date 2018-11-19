package espacio;

import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import contenibles.Contenible;
import unidades.UnidadMovil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Mapa {

    private int cantCeldas;
    private Map <Posicion, Casillero> mapa;

    public Mapa(int x, int y) {
        mapa = new HashMap<Posicion, Casillero>();

        cantCeldas = x*y;

        for (int i = 0 ; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Posicion posicion = new Posicion(i,j);
                Casillero casillero = new Casillero();
                int[] pos = {i,j};
                mapa.put(posicion,casillero);
            }
        }
    }

    public int getCantCeldas() { return this.cantCeldas;}

    public Contenible getContenido (int x, int y) throws ExcedeLimiteDelMapa {
        Posicion posicion = this.getPosicion(x, y);
        return mapa.get(posicion).getContenido();
    }

    public void colocarUnidadEn(Contenible unidad, int x, int y) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Posicion posicion = this.getPosicion(x, y);
        mapa.get(posicion).contener(unidad);
        unidad.setPosicion(posicion);
    }


    public void colocarEstructuraEn(Contenible unidad, int x, int y, int dimension) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        if(casillerosEstanOcupados(x, y, dimension))
            throw new CasilleroOcupado();
        for(int i = 0; i < dimension ; i++){
            for(int j = 0; j < dimension ; j++){
                Posicion posicion = this.getPosicion(x + i, y + j);
                mapa.get(posicion).contener(unidad);
                unidad.setPosicion(posicion);
            }
        }
    }

    public boolean casillerosEstanOcupados(int x, int y, int dimensiones) throws ExcedeLimiteDelMapa {
        for(int i = 0; i < dimensiones ; i++){
            for(int j = 0; j < dimensiones ; j++){
                Posicion posicion = this.getPosicion(x + i, y + j);
                if (mapa.get(posicion).casilleroEstaOcupado()) {
                    return true;
                }
            }
        }
        return false;
    }


    public void liberarUbicacion(int x, int y) throws ExcedeLimiteDelMapa {
        Posicion posicion = this.getPosicion(x, y);
        mapa.get(posicion).liberar();
    }

    // TODO ESTO ME PARECE MAL POR QUE YO LE DIGO AL MAPA QUE ME MUEVA LAS COSAS NO A LA UNIDAD MOVIBLE, MOVETE.

    public void mover(int x, int y, int incX, int incY) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        UnidadMovil unidad = (UnidadMovil) this.getContenido( x, y); // aca hay que lanzar error si es estructura.
        this.colocarUnidadEn(unidad, x + incX, y + incY);
        this.liberarUbicacion( x, y);
    }

    private Posicion getPosicion(int x, int y) throws ExcedeLimiteDelMapa {
        Set<Posicion> posiciones = this.mapa.keySet();
        for (Posicion pos: posiciones) {
            if(pos.posicionCorrespondiente(x, y)) {
                return pos;
            }
        }
        throw new ExcedeLimiteDelMapa();
    }

}


