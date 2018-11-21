package espacio;

import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import contenibles.Contenible;
import estructuras.Estructura;
import unidades.UnidadMovil;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Mapa {

    private int cantCeldas;
    private Map<Posicion, Casillero> mapa;

    public Mapa(int x, int y) {
        mapa = new HashMap<Posicion, Casillero>();

        cantCeldas = x * y;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Posicion posicion = new Posicion(i, j);
                Casillero casillero = new Casillero();
                mapa.put(posicion, casillero);
            }
        }
    }

    public int getCantCeldas() {
        return this.cantCeldas;
    }

    public Contenible getContenido(int x, int y) throws ExcedeLimiteDelMapa {
        Posicion posicion = this.getPosicion(x, y);
        return mapa.get(posicion).getContenido();
    }

    public void colocarUnidadEn(UnidadMovil unidad, int x, int y) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        Posicion posicion = this.getPosicion(x, y);
        mapa.get(posicion).contener(unidad);
        unidad.setPosicion(posicion);
    }


    public void colocarEstructuraEn(Estructura unaEstructura, int x, int y, int dimension) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        if (casillerosEstanOcupados(x, y, dimension))
            throw new CasilleroOcupado();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                Posicion posicion = this.getPosicion(x + i, y + j);
                mapa.get(posicion).contener(unaEstructura);
                unaEstructura.agregarPosicion(posicion);
            }
        }
    }

    public boolean casillerosEstanOcupados(int x, int y, int dimensiones) throws ExcedeLimiteDelMapa {
        for (int i = 0; i < dimensiones; i++) {
            for (int j = 0; j < dimensiones; j++) {
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


    public void mover(int x, int y, int incX, int incY) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        UnidadMovil unidad = (UnidadMovil) this.getContenido(x, y); // aca hay que lanzar error si es estructura.
        this.colocarUnidadEn(unidad, x + incX, y + incY);
        this.liberarUbicacion(x, y);
    }

    private Posicion getPosicion(int x, int y) throws ExcedeLimiteDelMapa {
        Set<Posicion> posiciones = this.mapa.keySet();
        for (Posicion pos : posiciones) {
            if (pos.posicionCorrespondiente(x, y)) {
                return pos;
            }
        }
        throw new ExcedeLimiteDelMapa();
    }

    //Bad Code incoming
    public LinkedList<Contenible> getConteniblesEnRango(LinkedList<Posicion> posiciones, int alcance, Estructura estructura) throws ExcedeLimiteDelMapa {
        int x = posiciones.getFirst().getPosX();
        int y = posiciones.getFirst().getPosY();

        x -= alcance;
        y -= alcance;

        LinkedList<Contenible> conteniblesEnRango = new LinkedList<Contenible>();

        for (int i = 0; i < 4 + (alcance * 2); i++) {
            for (int j = 0; j < (4 + (alcance * 2)); j++) {
                try {
                    if (getContenido(x + i, y + j) == null)
                        continue;
                } catch (ExcedeLimiteDelMapa excedeLimiteDelMapa) {
                    continue;
                }
                conteniblesEnRango.add(this.getContenido(x + i, y + j));
            }

        }
        return conteniblesEnRango;
    }
}


