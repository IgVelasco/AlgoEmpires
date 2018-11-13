package espacio;

import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import contenibles.Contenible;
import unidades.UnidadMovil;

public class Mapa {

    private int cantCeldas;
    private Casillero[][] mapa;

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

    public void colocarUnidadEn(Contenible unidad, int x, int y) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        try {
            this.mapa[x][y].contener(unidad); // Podriamos hacer que casillero esta ocupado tire la excepcion
        } catch (IndexOutOfBoundsException errorDeLimites) {
            throw new ExcedeLimiteDelMapa();
        }
    }


    public void colocarEstructuraEn(Contenible unidad, int x, int y, int dimension) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        if(!casillerosEstanOcupados(x, y, dimension))
            throw new CasilleroOcupado();
        for(int i = 0; i < dimension ; i++){
            for(int j = 0; j < dimension ; j++){
                this.mapa[x + i][y + j].contener(unidad);
            }
        }
    }

    private boolean casillerosEstanOcupados(int x , int y, int dimensiones) throws CasilleroOcupado,ExcedeLimiteDelMapa {
        for(int i = 0; i < dimensiones ; i++){
            for(int j = 0; j < dimensiones ; j++){
               try{
                  if (this.mapa[x + i][y + j].casilleroEstaOcupado()){
                      return false;
                  }
               }catch (IndexOutOfBoundsException errorDeLimites){
                   throw new ExcedeLimiteDelMapa();
               }
            }
        }
        return true;
    }


    public void liberarUbicacion(int x, int y) {
        this.mapa[x][y].liberar();
    }

    private void mover(int x, int y, int incX, int incY) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        UnidadMovil unidad = (UnidadMovil) this.getContenido( x, y); // aca hay que lanzar error si es estructura.
        try {
            this.colocarUnidadEn(unidad, x + incX, y + incY);
        } catch(IndexOutOfBoundsException errorDeLimites){
            throw new ExcedeLimiteDelMapa();
        }
        this.liberarUbicacion( x, y);
    }


    public void moverDerecha(int x, int y) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        this.mover( x, y, 1, 0);
    }

    public void moverIzquierda(int x, int y) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        this.mover(x, y, -1, 0);
    }

    public void moverArriba(int x, int y) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        this.mover(x, y, 0, 1);
    }

    public void moverAbajo(int x, int y) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        this.mover(x, y, 0, -1);
    }

    public void moverDerechaSuperior(int x, int y) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        this.mover(x, y, 1, 1);
    }

    public void moverDerechaInferior(int x, int y) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        this.mover(x, y, 1, -1);
    }

    public void moverIzquierdaSuperior(int x, int y) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        this.mover(x, y, -1, 1);
    }

    public void moverIzquierdaInferior(int x, int y) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        this.mover(x, y, -1, -1);
    }

}


