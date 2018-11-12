package espacio;

import Excepciones.CasilleroOcupado;
import contenibles.Contenible;

public class Mapa {

    private int cantCeldas;
    Casillero[][] mapa;

    public Mapa(int x, int y) {
        mapa = new Casillero[x][y];

        cantCeldas = x*y;

        for (int i = 0 ; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Casillero casillero = new Casillero();
                mapa[i][j] = casillero;
            }
        }
    }

    public int getCantCeldas() { return this.cantCeldas;}

    public Contenible getContenido (int x, int y) {
        return this.mapa[x][y].getContenido();
    }

    public void colocarUnidadEn(Contenible unidad, int x, int y) throws CasilleroOcupado {
        this.mapa[x][y].contener(unidad);
    }

    public void liberarUbicacion(int x, int y) {
        this.mapa[x][y].liberar();
    }
}
